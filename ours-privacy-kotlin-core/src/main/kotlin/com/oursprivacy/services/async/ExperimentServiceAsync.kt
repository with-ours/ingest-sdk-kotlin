// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.oursprivacy.core.ClientOptions
import com.oursprivacy.core.RequestOptions
import com.oursprivacy.core.http.HttpResponseFor
import com.oursprivacy.models.experiments.ExperimentAssignmentParams
import com.oursprivacy.models.experiments.ExperimentAssignmentResponse
import com.oursprivacy.models.experiments.ExperimentPersonalizationParams
import com.oursprivacy.models.experiments.ExperimentPersonalizationResponse

interface ExperimentServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ExperimentServiceAsync

    /**
     * Return the server-side variant assignment for a visitor in a single A/B or multivariate
     * experiment, identified by its experiment key. Bucketing is deterministic on `visitor_id` and
     * is sticky across calls. Tracking an impression is the default — pass `track_impression:
     * false` to read without recording. The browser SDK and this endpoint converge on the same
     * variant for the same visitor.
     */
    suspend fun assignment(
        experimentKey: String,
        params: ExperimentAssignmentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExperimentAssignmentResponse =
        assignment(params.toBuilder().experimentKey(experimentKey).build(), requestOptions)

    /** @see assignment */
    suspend fun assignment(
        params: ExperimentAssignmentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExperimentAssignmentResponse

    /**
     * Return the active personalization assignments for a visitor. Read-only and never records an
     * impression. Personalizations are populated by the event-driven rule engine — until that
     * ships, this endpoint returns an empty list for every visitor, which is the correct
     * fail-closed behavior (no false positives).
     */
    suspend fun personalization(
        params: ExperimentPersonalizationParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExperimentPersonalizationResponse

    /**
     * A view of [ExperimentServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ExperimentServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /experiments/assignments/{experiment_key}`, but is
         * otherwise the same as [ExperimentServiceAsync.assignment].
         */
        @MustBeClosed
        suspend fun assignment(
            experimentKey: String,
            params: ExperimentAssignmentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExperimentAssignmentResponse> =
            assignment(params.toBuilder().experimentKey(experimentKey).build(), requestOptions)

        /** @see assignment */
        @MustBeClosed
        suspend fun assignment(
            params: ExperimentAssignmentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExperimentAssignmentResponse>

        /**
         * Returns a raw HTTP response for `post /experiments/personalization`, but is otherwise the
         * same as [ExperimentServiceAsync.personalization].
         */
        @MustBeClosed
        suspend fun personalization(
            params: ExperimentPersonalizationParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExperimentPersonalizationResponse>
    }
}
