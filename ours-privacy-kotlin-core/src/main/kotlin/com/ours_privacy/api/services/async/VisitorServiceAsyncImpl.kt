// File generated from our OpenAPI spec by Stainless.

package com.ours_privacy.api.services.async

import com.ours_privacy.api.core.ClientOptions
import com.ours_privacy.api.core.RequestOptions
import com.ours_privacy.api.core.handlers.errorBodyHandler
import com.ours_privacy.api.core.handlers.errorHandler
import com.ours_privacy.api.core.handlers.jsonHandler
import com.ours_privacy.api.core.http.HttpMethod
import com.ours_privacy.api.core.http.HttpRequest
import com.ours_privacy.api.core.http.HttpResponse
import com.ours_privacy.api.core.http.HttpResponse.Handler
import com.ours_privacy.api.core.http.HttpResponseFor
import com.ours_privacy.api.core.http.json
import com.ours_privacy.api.core.http.parseable
import com.ours_privacy.api.core.prepareAsync
import com.ours_privacy.api.models.visitor.VisitorUpsertParams
import com.ours_privacy.api.models.visitor.VisitorUpsertResponse

class VisitorServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    VisitorServiceAsync {

    private val withRawResponse: VisitorServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): VisitorServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): VisitorServiceAsync =
        VisitorServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun upsert(
        params: VisitorUpsertParams,
        requestOptions: RequestOptions,
    ): VisitorUpsertResponse =
        // post /identify
        withRawResponse().upsert(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        VisitorServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): VisitorServiceAsync.WithRawResponse =
            VisitorServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val upsertHandler: Handler<VisitorUpsertResponse> =
            jsonHandler<VisitorUpsertResponse>(clientOptions.jsonMapper)

        override suspend fun upsert(
            params: VisitorUpsertParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VisitorUpsertResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(
                        if (clientOptions.baseUrlOverridden()) clientOptions.baseUrl()
                        else "https://api.oursprivacy.com/api/v1"
                    )
                    .addPathSegments("identify")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { upsertHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
