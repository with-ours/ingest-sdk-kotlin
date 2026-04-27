// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.oursprivacy.core.ClientOptions
import com.oursprivacy.core.RequestOptions
import com.oursprivacy.core.http.HttpResponseFor
import com.oursprivacy.models.track.TrackEventParams
import com.oursprivacy.models.track.TrackEventResponse

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
     * These properties help us associate events with existing users. For top-level visitor
     * properties: null clears the existing value, while undefined, omitted fields, and empty
     * strings are ignored. For entries inside custom_properties: null, undefined, and empty strings
     * are all ignored (custom_properties use merge semantics). See
     * https://docs.oursprivacy.com/docs/data-types for details and common pitfalls.
     */
    suspend fun event(
        params: TrackEventParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TrackEventResponse

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
         * [TrackServiceAsync.event].
         */
        @MustBeClosed
        suspend fun event(
            params: TrackEventParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TrackEventResponse>
    }
}
