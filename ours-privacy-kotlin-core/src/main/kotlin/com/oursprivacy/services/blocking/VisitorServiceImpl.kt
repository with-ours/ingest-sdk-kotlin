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
import com.oursprivacy.models.visitor.VisitorUpsertParams
import com.oursprivacy.models.visitor.VisitorUpsertResponse

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
