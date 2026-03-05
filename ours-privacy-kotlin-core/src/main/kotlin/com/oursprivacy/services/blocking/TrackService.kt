// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.oursprivacy.core.ClientOptions
import com.oursprivacy.core.RequestOptions
import com.oursprivacy.core.http.HttpResponseFor
import com.oursprivacy.models.track.TrackEventParams
import com.oursprivacy.models.track.TrackEventResponse

interface TrackService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): TrackService

    /**
     * Track events from your server. Please include at least one of: userId, externalId, or email.
     * These properties help us associate events with existing users. For all fields, null values
     * unset the property and undefined values do not unset existing properties.
     */
    fun event(
        params: TrackEventParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TrackEventResponse

    /** A view of [TrackService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): TrackService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /track`, but is otherwise the same as
         * [TrackService.event].
         */
        @MustBeClosed
        fun event(
            params: TrackEventParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TrackEventResponse>
    }
}
