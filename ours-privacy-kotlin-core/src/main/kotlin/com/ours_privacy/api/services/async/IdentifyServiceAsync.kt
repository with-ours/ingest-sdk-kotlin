// File generated from our OpenAPI spec by Stainless.

package com.ours_privacy.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.ours_privacy.api.core.ClientOptions
import com.ours_privacy.api.core.RequestOptions
import com.ours_privacy.api.core.http.HttpResponseFor
import com.ours_privacy.api.models.identify.IdentifyCreateOrUpdateParams
import com.ours_privacy.api.models.identify.IdentifyCreateOrUpdateResponse

interface IdentifyServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): IdentifyServiceAsync

    /**
     * Define visitor properties on an existing visitor or create a new visitor. Note: This does not
     * fire an event. If you want to fire an event, use the track method and include properties for
     * the visitor.
     */
    suspend fun createOrUpdate(
        params: IdentifyCreateOrUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): IdentifyCreateOrUpdateResponse

    /**
     * A view of [IdentifyServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): IdentifyServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /identify`, but is otherwise the same as
         * [IdentifyServiceAsync.createOrUpdate].
         */
        @MustBeClosed
        suspend fun createOrUpdate(
            params: IdentifyCreateOrUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<IdentifyCreateOrUpdateResponse>
    }
}
