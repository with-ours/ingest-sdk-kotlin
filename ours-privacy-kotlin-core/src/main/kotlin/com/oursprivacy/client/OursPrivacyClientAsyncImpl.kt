// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.client

import com.oursprivacy.core.ClientOptions
import com.oursprivacy.core.getPackageVersion
import com.oursprivacy.services.async.BatchServiceAsync
import com.oursprivacy.services.async.BatchServiceAsyncImpl
import com.oursprivacy.services.async.TrackServiceAsync
import com.oursprivacy.services.async.TrackServiceAsyncImpl
import com.oursprivacy.services.async.VisitorServiceAsync
import com.oursprivacy.services.async.VisitorServiceAsyncImpl

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

    private val batch: BatchServiceAsync by lazy {
        BatchServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): OursPrivacyClient = sync

    override fun withRawResponse(): OursPrivacyClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): OursPrivacyClientAsync =
        OursPrivacyClientAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override fun track(): TrackServiceAsync = track

    override fun visitor(): VisitorServiceAsync = visitor

    override fun batch(): BatchServiceAsync = batch

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OursPrivacyClientAsync.WithRawResponse {

        private val track: TrackServiceAsync.WithRawResponse by lazy {
            TrackServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val visitor: VisitorServiceAsync.WithRawResponse by lazy {
            VisitorServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val batch: BatchServiceAsync.WithRawResponse by lazy {
            BatchServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): OursPrivacyClientAsync.WithRawResponse =
            OursPrivacyClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        override fun track(): TrackServiceAsync.WithRawResponse = track

        override fun visitor(): VisitorServiceAsync.WithRawResponse = visitor

        override fun batch(): BatchServiceAsync.WithRawResponse = batch
    }
}
