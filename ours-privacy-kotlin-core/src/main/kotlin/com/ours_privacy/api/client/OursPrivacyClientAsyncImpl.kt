// File generated from our OpenAPI spec by Stainless.

package com.ours_privacy.api.client

import com.ours_privacy.api.core.ClientOptions
import com.ours_privacy.api.core.getPackageVersion
import com.ours_privacy.api.services.async.TrackServiceAsync
import com.ours_privacy.api.services.async.TrackServiceAsyncImpl
import com.ours_privacy.api.services.async.VisitorServiceAsync
import com.ours_privacy.api.services.async.VisitorServiceAsyncImpl

class OursPrivacyClientAsyncImpl(private val clientOptions: ClientOptions) :
    OursPrivacyClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Kotlin ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: OursPrivacyClient by lazy { OursPrivacyClientImpl(clientOptions) }

    private val withRawResponse: OursPrivacyClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val track: TrackServiceAsync by lazy {
        TrackServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val visitor: VisitorServiceAsync by lazy {
        VisitorServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): OursPrivacyClient = sync

    override fun withRawResponse(): OursPrivacyClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): OursPrivacyClientAsync =
        OursPrivacyClientAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override fun track(): TrackServiceAsync = track

    override fun visitor(): VisitorServiceAsync = visitor

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OursPrivacyClientAsync.WithRawResponse {

        private val track: TrackServiceAsync.WithRawResponse by lazy {
            TrackServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val visitor: VisitorServiceAsync.WithRawResponse by lazy {
            VisitorServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): OursPrivacyClientAsync.WithRawResponse =
            OursPrivacyClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        override fun track(): TrackServiceAsync.WithRawResponse = track

        override fun visitor(): VisitorServiceAsync.WithRawResponse = visitor
    }
}
