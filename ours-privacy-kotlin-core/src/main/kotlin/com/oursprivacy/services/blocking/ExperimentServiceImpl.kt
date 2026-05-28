// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.services.blocking

import com.oursprivacy.core.ClientOptions
import com.oursprivacy.core.RequestOptions
import com.oursprivacy.core.checkRequired
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
import com.oursprivacy.models.experiments.ExperimentAssignmentParams
import com.oursprivacy.models.experiments.ExperimentAssignmentResponse
import com.oursprivacy.models.experiments.ExperimentPersonalizationParams
import com.oursprivacy.models.experiments.ExperimentPersonalizationResponse

class ExperimentServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ExperimentService {

    private val withRawResponse: ExperimentService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ExperimentService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ExperimentService =
        ExperimentServiceImpl(clientOptions.toBuilder().apply(modifier).build())

    override fun assignment(
        params: ExperimentAssignmentParams,
        requestOptions: RequestOptions,
    ): ExperimentAssignmentResponse =
        // post /experiments/assignments/{experiment_key}
        withRawResponse().assignment(params, requestOptions).parse()

    override fun personalization(
        params: ExperimentPersonalizationParams,
        requestOptions: RequestOptions,
    ): ExperimentPersonalizationResponse =
        // post /experiments/personalization
        withRawResponse().personalization(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ExperimentService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ExperimentService.WithRawResponse =
            ExperimentServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val assignmentHandler: Handler<ExperimentAssignmentResponse> =
            jsonHandler<ExperimentAssignmentResponse>(clientOptions.jsonMapper)

        override fun assignment(
            params: ExperimentAssignmentParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ExperimentAssignmentResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("experimentKey", params.experimentKey())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(
                        if (clientOptions.baseUrlOverridden()) clientOptions.baseUrl()
                        else "https://api.oursprivacy.com/api/v1"
                    )
                    .addPathSegments("experiments", "assignments", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { assignmentHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val personalizationHandler: Handler<ExperimentPersonalizationResponse> =
            jsonHandler<ExperimentPersonalizationResponse>(clientOptions.jsonMapper)

        override fun personalization(
            params: ExperimentPersonalizationParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ExperimentPersonalizationResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(
                        if (clientOptions.baseUrlOverridden()) clientOptions.baseUrl()
                        else "https://api.oursprivacy.com/api/v1"
                    )
                    .addPathSegments("experiments", "personalization")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { personalizationHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
