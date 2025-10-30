// File generated from our OpenAPI spec by Stainless.

package com.ours_privacy.api.errors

import com.ours_privacy.api.core.JsonValue
import com.ours_privacy.api.core.http.Headers

abstract class OursPrivacyServiceException
protected constructor(message: String, cause: Throwable? = null) :
    OursPrivacyException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
