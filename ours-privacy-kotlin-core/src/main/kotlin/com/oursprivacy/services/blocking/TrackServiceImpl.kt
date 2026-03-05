// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.services.blocking

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
import com.oursprivacy.core.prepare
import com.oursprivacy.models.track.TrackEventParams
import com.oursprivacy.models.track.TrackEventResponse

class TrackServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    TrackService {

    private val withRawResponse: TrackService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): TrackService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): TrackService =
        TrackServiceImpl(clientOptions.toBuilder().apply(modifier).build())

    override fun event(
        params: TrackEventParams,
        requestOptions: RequestOptions,
    ): TrackEventResponse =
        // post /track
        withRawResponse().event(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TrackService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): TrackService.WithRawResponse =
            TrackServiceImpl.WithRawResponseImpl(clientOptions.toBuilder().apply(modifier).build())

        private val eventHandler: Handler<TrackEventResponse> =
            jsonHandler<TrackEventResponse>(clientOptions.jsonMapper)

        override fun event(
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
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
