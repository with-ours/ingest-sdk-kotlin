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
import com.ours_privacy.api.models.identify.IdentifyCreateOrUpdateParams
import com.ours_privacy.api.models.identify.IdentifyCreateOrUpdateResponse

class IdentifyServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    IdentifyServiceAsync {

    private val withRawResponse: IdentifyServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): IdentifyServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): IdentifyServiceAsync =
        IdentifyServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun createOrUpdate(
        params: IdentifyCreateOrUpdateParams,
        requestOptions: RequestOptions,
    ): IdentifyCreateOrUpdateResponse =
        // post /identify
        withRawResponse().createOrUpdate(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        IdentifyServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): IdentifyServiceAsync.WithRawResponse =
            IdentifyServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val createOrUpdateHandler: Handler<IdentifyCreateOrUpdateResponse> =
            jsonHandler<IdentifyCreateOrUpdateResponse>(clientOptions.jsonMapper)

        override suspend fun createOrUpdate(
            params: IdentifyCreateOrUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<IdentifyCreateOrUpdateResponse> {
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
                    .use { createOrUpdateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
