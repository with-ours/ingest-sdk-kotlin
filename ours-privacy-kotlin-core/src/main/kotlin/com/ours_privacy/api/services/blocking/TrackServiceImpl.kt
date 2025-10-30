// File generated from our OpenAPI spec by Stainless.

package com.ours_privacy.api.services.blocking

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
import com.ours_privacy.api.core.prepare
import com.ours_privacy.api.models.track.TrackEventParams
import com.ours_privacy.api.models.track.TrackEventResponse

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
