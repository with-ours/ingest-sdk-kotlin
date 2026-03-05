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
import com.oursprivacy.models.track.TrackEventParams
import com.oursprivacy.models.track.TrackEventResponse

class TrackServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    TrackServiceAsync {

    private val withRawResponse: TrackServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): TrackServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): TrackServiceAsync =
        TrackServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun event(
        params: TrackEventParams,
        requestOptions: RequestOptions,
    ): TrackEventResponse =
        // post /track
        withRawResponse().event(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TrackServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): TrackServiceAsync.WithRawResponse =
            TrackServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val eventHandler: Handler<TrackEventResponse> =
            jsonHandler<TrackEventResponse>(clientOptions.jsonMapper)

        override suspend fun event(
            params: TrackEventParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TrackEventResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(
                        if (clientOptions.baseUrlOverridden()) clientOptions.baseUrl()
                        else "https://api.oursprivacy.com/api/v1"
                    )
                    .addPathSegments("track")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { eventHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
