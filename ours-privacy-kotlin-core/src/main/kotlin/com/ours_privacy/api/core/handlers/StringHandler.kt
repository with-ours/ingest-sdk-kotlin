@file:JvmName("StringHandler")

package com.ours_privacy.api.core.handlers

import com.ours_privacy.api.core.http.HttpResponse
import com.ours_privacy.api.core.http.HttpResponse.Handler

internal fun stringHandler(): Handler<String> = StringHandlerInternal

private object StringHandlerInternal : Handler<String> {
    override fun handle(response: HttpResponse): String =
        response.body().readBytes().toString(Charsets.UTF_8)
}
