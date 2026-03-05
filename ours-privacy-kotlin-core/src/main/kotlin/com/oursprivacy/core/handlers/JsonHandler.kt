@file:JvmName("JsonHandler")

package com.oursprivacy.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.oursprivacy.core.http.HttpResponse
import com.oursprivacy.core.http.HttpResponse.Handler
import com.oursprivacy.errors.OursPrivacyInvalidDataException

internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T {
            try {
                return jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw OursPrivacyInvalidDataException("Error reading response", e)
            }
        }
    }
