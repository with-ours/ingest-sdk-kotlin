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
import com.ours_privacy.api.models.visitor.VisitorUpsertParams
import com.ours_privacy.api.models.visitor.VisitorUpsertResponse

class VisitorServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    VisitorService {

    private val withRawResponse: VisitorService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): VisitorService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): VisitorService =
        VisitorServiceImpl(clientOptions.toBuilder().apply(modifier).build())

    override fun upsert(
        params: VisitorUpsertParams,
        requestOptions: RequestOptions,
    ): VisitorUpsertResponse =
        // post /identify
        withRawResponse().upsert(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        VisitorService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): VisitorService.WithRawResponse =
            VisitorServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val upsertHandler: Handler<VisitorUpsertResponse> =
            jsonHandler<VisitorUpsertResponse>(clientOptions.jsonMapper)

        override fun upsert(
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
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
