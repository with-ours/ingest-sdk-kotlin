// File generated from our OpenAPI spec by Stainless.

package com.ours_privacy.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.ours_privacy.api.core.ClientOptions
import com.ours_privacy.api.core.RequestOptions
import com.ours_privacy.api.core.http.HttpResponseFor
import com.ours_privacy.api.models.track.TrackCreateEventParams
import com.ours_privacy.api.models.track.TrackCreateEventResponse

interface TrackServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): TrackServiceAsync

    /**
     * Track events from your server. Please include at least one of: userId, externalId, or email.
     * These properties help us associate events with existing users. For all fields, null values
     * unset the property and undefined values do not unset existing properties.
     */
    suspend fun createEvent(
        params: TrackCreateEventParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TrackCreateEventResponse

    /** A view of [TrackServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): TrackServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /track`, but is otherwise the same as
         * [TrackServiceAsync.createEvent].
         */
        @MustBeClosed
        suspend fun createEvent(
            params: TrackCreateEventParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TrackCreateEventResponse>
    }
}
