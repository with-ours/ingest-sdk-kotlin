// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.services.async

import com.oursprivacy.core.ClientOptions
import com.oursprivacy.core.RequestOptions
import com.oursprivacy.core.handlers.errorBodyHandler
import com.oursprivacy.core.handlers.errorHandler
import com.oursprivacy.core.handlers.jsonHandler
import com.oursprivacy.core.http.HttpMethod
import com.oursprivacy.core.http.HttpRequest
import com.oursprivacy.core.http.HttpResponse
import com.oursprivacy.core.http.HttpResponse.Handler
import com.oursprivacy.core.http.HttpResponseFor
import com.oursprivacy.core.http.json
import com.oursprivacy.core.http.parseable
import com.oursprivacy.core.prepareAsync
import com.oursprivacy.models.visitor.VisitorUpsertParams
import com.oursprivacy.models.visitor.VisitorUpsertResponse

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
