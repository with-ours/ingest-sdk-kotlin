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
     * Track events from your server. Include at least one of userId, externalId, or email so the
     * event can be associated with a visitor. Identity resolution runs in priority order: userId
     * (direct, no lookup) → externalId (lookup by your ID) → email (fallback lookup). If you know
     * both userId and externalId, send both. For top-level visitor properties: null clears the
     * existing value, while undefined, omitted fields, and empty strings are ignored. For entries
     * inside custom_properties: null, undefined, and empty strings are all ignored
     * (custom_properties use merge semantics). See https://docs.oursprivacy.com/docs/data-types for
     * details and common pitfalls.
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
