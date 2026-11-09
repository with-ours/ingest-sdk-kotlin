// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.core

/** Field names in lower case, without underscores or hyphens. */
private val SENSITIVE_FIELDS =
    setOf("accesstoken", "apikey", "clientsecret", "password", "refreshtoken", "token")

/**
 * Replaces the values of sensitive JSON fields, at any depth, in the lines of a body. Everything
 * else in a line is kept as it is.
 *
 * A value can span lines, so an instance holds on to any value still open at the end of a line. Use
 * a new instance for each body.
 */
internal class SensitiveFieldRedactor {

    private var openDepth = 0

    fun redact(line: String): String {
        val redacted = StringBuilder()
        var index = if (openDepth > 0) skipValue(line, 0) else 0
        var copied = index
        while (index < line.length) {
            if (line[index] != '"') {
                index++
                continue
            }
            val nameEnd = stringEnd(line, index)
            val colon = skipWhitespace(line, nameEnd)
            if (colon < line.length && line[colon] == ':') {
                val name =
                    line
                        .substring(index + 1, nameEnd - 1)
                        .lowercase()
                        .replace("_", "")
                        .replace("-", "")
                if (name in SENSITIVE_FIELDS) {
                    val valueStart = skipWhitespace(line, colon + 1)
                    redacted.append(line, copied, valueStart).append("\"██\"")
                    index = skipValue(line, valueStart)
                    copied = index
                    continue
                }
            }
            index = nameEnd
        }
        return redacted.append(line, copied, line.length).toString()
    }

    private fun skipWhitespace(line: String, start: Int): Int {
        var index = start
        while (index < line.length && line[index].isWhitespace()) {
            index++
        }
        return index
    }

    /** Returns the index just past the string that opens at [start]. */
    private fun stringEnd(line: String, start: Int): Int {
        var index = start + 1
        while (index < line.length) {
            when (line[index]) {
                '\\' -> index++
                '"' -> return index + 1
            }
            index++
        }
        return line.length
    }

    /**
     * Returns the index just past the value at [start], or the line's end if the value continues.
     */
    private fun skipValue(line: String, start: Int): Int {
        var depth = openDepth
        var inString = false
        var index = start
        while (index < line.length) {
            val char = line[index]
            when {
                inString ->
                    if (char == '\\') {
                        index++
                    } else if (char == '"') {
                        inString = false
                        if (depth == 0) {
                            return index + 1
                        }
                    }
                char == '"' -> inString = true
                char == '{' || char == '[' -> depth++
                char == '}' || char == ']' -> {
                    if (depth == 0) {
                        return index
                    }
                    depth--
                    if (depth == 0) {
                        openDepth = 0
                        return index + 1
                    }
                }
                depth == 0 && (char == ',' || char.isWhitespace()) -> return index
            }
            index++
        }
        openDepth = depth
        return line.length
    }
}

/** Returns [text], a complete JSON document, with the values of sensitive fields replaced. */
internal fun redactSensitiveFields(text: String): String =
    text.lines().joinToString("\n", transform = SensitiveFieldRedactor()::redact)
