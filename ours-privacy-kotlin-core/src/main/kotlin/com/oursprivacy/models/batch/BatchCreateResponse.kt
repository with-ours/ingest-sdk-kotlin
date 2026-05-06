// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.models.batch

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.oursprivacy.core.BaseDeserializer
import com.oursprivacy.core.BaseSerializer
import com.oursprivacy.core.Enum
import com.oursprivacy.core.ExcludeMissing
import com.oursprivacy.core.JsonField
import com.oursprivacy.core.JsonMissing
import com.oursprivacy.core.JsonValue
import com.oursprivacy.core.allMaxBy
import com.oursprivacy.core.checkKnown
import com.oursprivacy.core.checkRequired
import com.oursprivacy.core.getOrThrow
import com.oursprivacy.core.toImmutable
import com.oursprivacy.errors.OursPrivacyInvalidDataException
import java.util.Collections
import java.util.Objects

class BatchCreateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val accepted: JsonField<Long>,
    private val failed: JsonField<Long>,
    private val results: JsonField<List<Result>>,
    private val success: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("accepted") @ExcludeMissing accepted: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("failed") @ExcludeMissing failed: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("results")
        @ExcludeMissing
        results: JsonField<List<Result>> = JsonMissing.of(),
        @JsonProperty("success") @ExcludeMissing success: JsonField<Boolean> = JsonMissing.of(),
    ) : this(accepted, failed, results, success, mutableMapOf())

    /**
     * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun accepted(): Long = accepted.getRequired("accepted")

    /**
     * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun failed(): Long = failed.getRequired("failed")

    /**
     * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun results(): List<Result> = results.getRequired("results")

    /**
     * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun success(): Boolean = success.getRequired("success")

    /**
     * Returns the raw JSON value of [accepted].
     *
     * Unlike [accepted], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("accepted") @ExcludeMissing fun _accepted(): JsonField<Long> = accepted

    /**
     * Returns the raw JSON value of [failed].
     *
     * Unlike [failed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("failed") @ExcludeMissing fun _failed(): JsonField<Long> = failed

    /**
     * Returns the raw JSON value of [results].
     *
     * Unlike [results], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("results") @ExcludeMissing fun _results(): JsonField<List<Result>> = results

    /**
     * Returns the raw JSON value of [success].
     *
     * Unlike [success], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("success") @ExcludeMissing fun _success(): JsonField<Boolean> = success

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BatchCreateResponse].
         *
         * The following fields are required:
         * ```kotlin
         * .accepted()
         * .failed()
         * .results()
         * .success()
         * ```
         */
        fun builder() = Builder()
    }

    /** A builder for [BatchCreateResponse]. */
    class Builder internal constructor() {

        private var accepted: JsonField<Long>? = null
        private var failed: JsonField<Long>? = null
        private var results: JsonField<MutableList<Result>>? = null
        private var success: JsonField<Boolean>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(batchCreateResponse: BatchCreateResponse) = apply {
            accepted = batchCreateResponse.accepted
            failed = batchCreateResponse.failed
            results = batchCreateResponse.results.map { it.toMutableList() }
            success = batchCreateResponse.success
            additionalProperties = batchCreateResponse.additionalProperties.toMutableMap()
        }

        fun accepted(accepted: Long) = accepted(JsonField.of(accepted))

        /**
         * Sets [Builder.accepted] to an arbitrary JSON value.
         *
         * You should usually call [Builder.accepted] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun accepted(accepted: JsonField<Long>) = apply { this.accepted = accepted }

        fun failed(failed: Long) = failed(JsonField.of(failed))

        /**
         * Sets [Builder.failed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.failed] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun failed(failed: JsonField<Long>) = apply { this.failed = failed }

        fun results(results: List<Result>) = results(JsonField.of(results))

        /**
         * Sets [Builder.results] to an arbitrary JSON value.
         *
         * You should usually call [Builder.results] with a well-typed `List<Result>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun results(results: JsonField<List<Result>>) = apply {
            this.results = results.map { it.toMutableList() }
        }

        /**
         * Adds a single [Result] to [results].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addResult(result: Result) = apply {
            results =
                (results ?: JsonField.of(mutableListOf())).also {
                    checkKnown("results", it).add(result)
                }
        }

        /** Alias for calling [addResult] with `Result.ofUnionMember0(unionMember0)`. */
        fun addResult(unionMember0: Result.UnionMember0) =
            addResult(Result.ofUnionMember0(unionMember0))

        /** Alias for calling [addResult] with `Result.ofUnionMember1(unionMember1)`. */
        fun addResult(unionMember1: Result.UnionMember1) =
            addResult(Result.ofUnionMember1(unionMember1))

        fun success(success: Boolean) = success(JsonField.of(success))

        /**
         * Sets [Builder.success] to an arbitrary JSON value.
         *
         * You should usually call [Builder.success] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun success(success: JsonField<Boolean>) = apply { this.success = success }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [BatchCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```kotlin
         * .accepted()
         * .failed()
         * .results()
         * .success()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BatchCreateResponse =
            BatchCreateResponse(
                checkRequired("accepted", accepted),
                checkRequired("failed", failed),
                checkRequired("results", results).map { it.toImmutable() },
                checkRequired("success", success),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OursPrivacyInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): BatchCreateResponse = apply {
        if (validated) {
            return@apply
        }

        accepted()
        failed()
        results().forEach { it.validate() }
        success()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: OursPrivacyInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    internal fun validity(): Int =
        (if (accepted.asKnown() == null) 0 else 1) +
            (if (failed.asKnown() == null) 0 else 1) +
            (results.asKnown()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (success.asKnown() == null) 0 else 1)

    @JsonDeserialize(using = Result.Deserializer::class)
    @JsonSerialize(using = Result.Serializer::class)
    class Result
    private constructor(
        private val unionMember0: UnionMember0? = null,
        private val unionMember1: UnionMember1? = null,
        private val _json: JsonValue? = null,
    ) {

        fun unionMember0(): UnionMember0? = unionMember0

        fun unionMember1(): UnionMember1? = unionMember1

        fun isUnionMember0(): Boolean = unionMember0 != null

        fun isUnionMember1(): Boolean = unionMember1 != null

        fun asUnionMember0(): UnionMember0 = unionMember0.getOrThrow("unionMember0")

        fun asUnionMember1(): UnionMember1 = unionMember1.getOrThrow("unionMember1")

        fun _json(): JsonValue? = _json

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```kotlin
         * import com.oursprivacy.core.JsonValue
         *
         * val result: String? = result.accept(object : Result.Visitor<String?> {
         *     override fun visitUnionMember0(unionMember0: UnionMember0): String? = unionMember0.toString()
         *
         *     // ...
         *
         *     override fun unknown(json: JsonValue?): String? {
         *         // Or inspect the `json`.
         *         return null
         *     }
         * })
         * ```
         *
         * @throws OursPrivacyInvalidDataException if [Visitor.unknown] is not overridden in
         *   [visitor] and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                unionMember0 != null -> visitor.visitUnionMember0(unionMember0)
                unionMember1 != null -> visitor.visitUnionMember1(unionMember1)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OursPrivacyInvalidDataException if any value type in this object doesn't match
         *   its expected type.
         */
        fun validate(): Result = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitUnionMember0(unionMember0: UnionMember0) {
                        unionMember0.validate()
                    }

                    override fun visitUnionMember1(unionMember1: UnionMember1) {
                        unionMember1.validate()
                    }
                }
            )
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OursPrivacyInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        internal fun validity(): Int =
            accept(
                object : Visitor<Int> {
                    override fun visitUnionMember0(unionMember0: UnionMember0) =
                        unionMember0.validity()

                    override fun visitUnionMember1(unionMember1: UnionMember1) =
                        unionMember1.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Result &&
                unionMember0 == other.unionMember0 &&
                unionMember1 == other.unionMember1
        }

        override fun hashCode(): Int = Objects.hash(unionMember0, unionMember1)

        override fun toString(): String =
            when {
                unionMember0 != null -> "Result{unionMember0=$unionMember0}"
                unionMember1 != null -> "Result{unionMember1=$unionMember1}"
                _json != null -> "Result{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Result")
            }

        companion object {

            fun ofUnionMember0(unionMember0: UnionMember0) = Result(unionMember0 = unionMember0)

            fun ofUnionMember1(unionMember1: UnionMember1) = Result(unionMember1 = unionMember1)
        }

        /** An interface that defines how to map each variant of [Result] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitUnionMember0(unionMember0: UnionMember0): T

            fun visitUnionMember1(unionMember1: UnionMember1): T

            /**
             * Maps an unknown variant of [Result] to a value of type [T].
             *
             * An instance of [Result] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OursPrivacyInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OursPrivacyInvalidDataException("Unknown Result: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Result>(Result::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Result {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<UnionMember0>())?.let {
                                Result(unionMember0 = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<UnionMember1>())?.let {
                                Result(unionMember1 = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Result(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Result>(Result::class) {

            override fun serialize(
                value: Result,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.unionMember0 != null -> generator.writeObject(value.unionMember0)
                    value.unionMember1 != null -> generator.writeObject(value.unionMember1)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Result")
                }
            }
        }

        class UnionMember0
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val index: JsonField<Long>,
            private val success: JsonField<Success>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("index") @ExcludeMissing index: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("success")
                @ExcludeMissing
                success: JsonField<Success> = JsonMissing.of(),
            ) : this(index, success, mutableMapOf())

            /**
             * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or
             *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun index(): Long = index.getRequired("index")

            /**
             * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or
             *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun success(): Success = success.getRequired("success")

            /**
             * Returns the raw JSON value of [index].
             *
             * Unlike [index], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

            /**
             * Returns the raw JSON value of [success].
             *
             * Unlike [success], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("success") @ExcludeMissing fun _success(): JsonField<Success> = success

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [UnionMember0].
                 *
                 * The following fields are required:
                 * ```kotlin
                 * .index()
                 * .success()
                 * ```
                 */
                fun builder() = Builder()
            }

            /** A builder for [UnionMember0]. */
            class Builder internal constructor() {

                private var index: JsonField<Long>? = null
                private var success: JsonField<Success>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(unionMember0: UnionMember0) = apply {
                    index = unionMember0.index
                    success = unionMember0.success
                    additionalProperties = unionMember0.additionalProperties.toMutableMap()
                }

                fun index(index: Long) = index(JsonField.of(index))

                /**
                 * Sets [Builder.index] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.index] with a well-typed [Long] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun index(index: JsonField<Long>) = apply { this.index = index }

                fun success(success: Success) = success(JsonField.of(success))

                /**
                 * Sets [Builder.success] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.success] with a well-typed [Success] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun success(success: JsonField<Success>) = apply { this.success = success }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [UnionMember0].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```kotlin
                 * .index()
                 * .success()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): UnionMember0 =
                    UnionMember0(
                        checkRequired("index", index),
                        checkRequired("success", success),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OursPrivacyInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): UnionMember0 = apply {
                if (validated) {
                    return@apply
                }

                index()
                success().validate()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OursPrivacyInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            internal fun validity(): Int =
                (if (index.asKnown() == null) 0 else 1) + (success.asKnown()?.validity() ?: 0)

            class Success @JsonCreator private constructor(private val value: JsonField<Boolean>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<Boolean> = value

                companion object {

                    val TRUE = of(true)

                    fun of(value: Boolean) = Success(JsonField.of(value))
                }

                /** An enum containing [Success]'s known values. */
                enum class Known {
                    TRUE
                }

                /**
                 * An enum containing [Success]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Success] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    TRUE,
                    /**
                     * An enum member indicating that [Success] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        TRUE -> Value.TRUE
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws OursPrivacyInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        TRUE -> Known.TRUE
                        else -> throw OursPrivacyInvalidDataException("Unknown Success: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * @throws OursPrivacyInvalidDataException if this class instance's value does not
                 *   have the expected primitive type.
                 */
                fun asBoolean(): Boolean =
                    _value().asBoolean()
                        ?: throw OursPrivacyInvalidDataException("Value is not a Boolean")

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OursPrivacyInvalidDataException if any value type in this object doesn't
                 *   match its expected type.
                 */
                fun validate(): Success = apply {
                    if (validated) {
                        return@apply
                    }

                    known()
                    validated = true
                }

                fun isValid(): Boolean =
                    try {
                        validate()
                        true
                    } catch (e: OursPrivacyInvalidDataException) {
                        false
                    }

                /**
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Success && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is UnionMember0 &&
                    index == other.index &&
                    success == other.success &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(index, success, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "UnionMember0{index=$index, success=$success, additionalProperties=$additionalProperties}"
        }

        class UnionMember1
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val code: JsonField<Code>,
            private val index: JsonField<Long>,
            private val message: JsonField<String>,
            private val success: JsonField<Success>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("code") @ExcludeMissing code: JsonField<Code> = JsonMissing.of(),
                @JsonProperty("index") @ExcludeMissing index: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("message")
                @ExcludeMissing
                message: JsonField<String> = JsonMissing.of(),
                @JsonProperty("success")
                @ExcludeMissing
                success: JsonField<Success> = JsonMissing.of(),
            ) : this(code, index, message, success, mutableMapOf())

            /**
             * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or
             *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun code(): Code = code.getRequired("code")

            /**
             * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or
             *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun index(): Long = index.getRequired("index")

            /**
             * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or
             *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun message(): String = message.getRequired("message")

            /**
             * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or
             *   is unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun success(): Success = success.getRequired("success")

            /**
             * Returns the raw JSON value of [code].
             *
             * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<Code> = code

            /**
             * Returns the raw JSON value of [index].
             *
             * Unlike [index], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("index") @ExcludeMissing fun _index(): JsonField<Long> = index

            /**
             * Returns the raw JSON value of [message].
             *
             * Unlike [message], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("message") @ExcludeMissing fun _message(): JsonField<String> = message

            /**
             * Returns the raw JSON value of [success].
             *
             * Unlike [success], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("success") @ExcludeMissing fun _success(): JsonField<Success> = success

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [UnionMember1].
                 *
                 * The following fields are required:
                 * ```kotlin
                 * .code()
                 * .index()
                 * .message()
                 * .success()
                 * ```
                 */
                fun builder() = Builder()
            }

            /** A builder for [UnionMember1]. */
            class Builder internal constructor() {

                private var code: JsonField<Code>? = null
                private var index: JsonField<Long>? = null
                private var message: JsonField<String>? = null
                private var success: JsonField<Success>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(unionMember1: UnionMember1) = apply {
                    code = unionMember1.code
                    index = unionMember1.index
                    message = unionMember1.message
                    success = unionMember1.success
                    additionalProperties = unionMember1.additionalProperties.toMutableMap()
                }

                fun code(code: Code) = code(JsonField.of(code))

                /**
                 * Sets [Builder.code] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.code] with a well-typed [Code] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun code(code: JsonField<Code>) = apply { this.code = code }

                fun index(index: Long) = index(JsonField.of(index))

                /**
                 * Sets [Builder.index] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.index] with a well-typed [Long] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun index(index: JsonField<Long>) = apply { this.index = index }

                fun message(message: String) = message(JsonField.of(message))

                /**
                 * Sets [Builder.message] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.message] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun message(message: JsonField<String>) = apply { this.message = message }

                fun success(success: Success) = success(JsonField.of(success))

                /**
                 * Sets [Builder.success] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.success] with a well-typed [Success] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun success(success: JsonField<Success>) = apply { this.success = success }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [UnionMember1].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```kotlin
                 * .code()
                 * .index()
                 * .message()
                 * .success()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): UnionMember1 =
                    UnionMember1(
                        checkRequired("code", code),
                        checkRequired("index", index),
                        checkRequired("message", message),
                        checkRequired("success", success),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OursPrivacyInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): UnionMember1 = apply {
                if (validated) {
                    return@apply
                }

                code().validate()
                index()
                message()
                success().validate()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: OursPrivacyInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            internal fun validity(): Int =
                (code.asKnown()?.validity() ?: 0) +
                    (if (index.asKnown() == null) 0 else 1) +
                    (if (message.asKnown() == null) 0 else 1) +
                    (success.asKnown()?.validity() ?: 0)

            class Code @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    val INVALID_EVENT = of("invalid_event")

                    val QUEUE_FAILED = of("queue_failed")

                    fun of(value: String) = Code(JsonField.of(value))
                }

                /** An enum containing [Code]'s known values. */
                enum class Known {
                    INVALID_EVENT,
                    QUEUE_FAILED,
                }

                /**
                 * An enum containing [Code]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Code] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    INVALID_EVENT,
                    QUEUE_FAILED,
                    /**
                     * An enum member indicating that [Code] was instantiated with an unknown value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        INVALID_EVENT -> Value.INVALID_EVENT
                        QUEUE_FAILED -> Value.QUEUE_FAILED
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws OursPrivacyInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        INVALID_EVENT -> Known.INVALID_EVENT
                        QUEUE_FAILED -> Known.QUEUE_FAILED
                        else -> throw OursPrivacyInvalidDataException("Unknown Code: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws OursPrivacyInvalidDataException if this class instance's value does not
                 *   have the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString()
                        ?: throw OursPrivacyInvalidDataException("Value is not a String")

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OursPrivacyInvalidDataException if any value type in this object doesn't
                 *   match its expected type.
                 */
                fun validate(): Code = apply {
                    if (validated) {
                        return@apply
                    }

                    known()
                    validated = true
                }

                fun isValid(): Boolean =
                    try {
                        validate()
                        true
                    } catch (e: OursPrivacyInvalidDataException) {
                        false
                    }

                /**
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Code && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            class Success @JsonCreator private constructor(private val value: JsonField<Boolean>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<Boolean> = value

                companion object {

                    val FALSE = of(false)

                    fun of(value: Boolean) = Success(JsonField.of(value))
                }

                /** An enum containing [Success]'s known values. */
                enum class Known {
                    FALSE
                }

                /**
                 * An enum containing [Success]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Success] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    FALSE,
                    /**
                     * An enum member indicating that [Success] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        FALSE -> Value.FALSE
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws OursPrivacyInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        FALSE -> Known.FALSE
                        else -> throw OursPrivacyInvalidDataException("Unknown Success: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * @throws OursPrivacyInvalidDataException if this class instance's value does not
                 *   have the expected primitive type.
                 */
                fun asBoolean(): Boolean =
                    _value().asBoolean()
                        ?: throw OursPrivacyInvalidDataException("Value is not a Boolean")

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OursPrivacyInvalidDataException if any value type in this object doesn't
                 *   match its expected type.
                 */
                fun validate(): Success = apply {
                    if (validated) {
                        return@apply
                    }

                    known()
                    validated = true
                }

                fun isValid(): Boolean =
                    try {
                        validate()
                        true
                    } catch (e: OursPrivacyInvalidDataException) {
                        false
                    }

                /**
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Success && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is UnionMember1 &&
                    code == other.code &&
                    index == other.index &&
                    message == other.message &&
                    success == other.success &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(code, index, message, success, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "UnionMember1{code=$code, index=$index, message=$message, success=$success, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BatchCreateResponse &&
            accepted == other.accepted &&
            failed == other.failed &&
            results == other.results &&
            success == other.success &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(accepted, failed, results, success, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BatchCreateResponse{accepted=$accepted, failed=$failed, results=$results, success=$success, additionalProperties=$additionalProperties}"
}
