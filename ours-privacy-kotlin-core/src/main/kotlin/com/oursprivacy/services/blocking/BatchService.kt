// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.oursprivacy.core.ClientOptions
import com.oursprivacy.core.RequestOptions
import com.oursprivacy.core.http.HttpResponseFor
import com.oursprivacy.models.batch.BatchCreateParams
import com.oursprivacy.models.batch.BatchCreateResponse

interface BatchService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): BatchService

    /**
     * Send multiple `/track`-shaped events in a single request. This endpoint is intended for
     * replay, backfill, and asynchronous bulk delivery. The top-level token is authorized once for
     * the full batch. Each batch row must include `distinctId`, and mixed validation or queue
     * outcomes are reported per row.
     */
    fun create(
        params: BatchCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BatchCreateResponse

    /** A view of [BatchService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): BatchService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /batch`, but is otherwise the same as
         * [BatchService.create].
         */
        @MustBeClosed
        fun create(
            params: BatchCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchCreateResponse>
    }
}
