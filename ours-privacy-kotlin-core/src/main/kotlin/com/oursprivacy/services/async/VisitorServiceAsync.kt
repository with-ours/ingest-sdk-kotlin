// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.oursprivacy.core.ClientOptions
import com.oursprivacy.core.RequestOptions
import com.oursprivacy.core.http.HttpResponseFor
import com.oursprivacy.models.visitor.VisitorUpsertParams
import com.oursprivacy.models.visitor.VisitorUpsertResponse

interface VisitorServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): VisitorServiceAsync

    /**
     * Define visitor properties on an existing visitor or create a new visitor. This fires a
     * $identify event, making the call visible in the event stream.
     */
    suspend fun upsert(
        params: VisitorUpsertParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VisitorUpsertResponse

    /**
     * A view of [VisitorServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): VisitorServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /identify`, but is otherwise the same as
         * [VisitorServiceAsync.upsert].
         */
        @MustBeClosed
        suspend fun upsert(
            params: VisitorUpsertParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VisitorUpsertResponse>
    }
}
