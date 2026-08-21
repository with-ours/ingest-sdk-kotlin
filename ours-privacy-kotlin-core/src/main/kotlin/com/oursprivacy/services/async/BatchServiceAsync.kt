// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.oursprivacy.core.ClientOptions
import com.oursprivacy.core.RequestOptions
import com.oursprivacy.core.http.HttpResponseFor
import com.oursprivacy.models.batch.BatchCreateParams
import com.oursprivacy.models.batch.BatchCreateResponse

interface BatchServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): BatchServiceAsync

    /**
     * Send multiple `/track`-shaped events in a single request. This endpoint is intended for
     * replay, backfill, and asynchronous bulk delivery. The top-level token is authorized once for
     * the full batch. Each batch row must include `distinctId`, and mixed validation or queue
     * outcomes are reported per row.
     */
    suspend fun create(
        params: BatchCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BatchCreateResponse

    /** A view of [BatchServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): BatchServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /batch`, but is otherwise the same as
         * [BatchServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: BatchCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchCreateResponse>
    }
}
