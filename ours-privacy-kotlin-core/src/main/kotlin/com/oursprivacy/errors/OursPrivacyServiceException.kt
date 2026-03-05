// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.errors

import com.oursprivacy.core.JsonValue
import com.oursprivacy.core.http.Headers

abstract class OursPrivacyServiceException
protected constructor(message: String, cause: Throwable? = null) :
    OursPrivacyException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
