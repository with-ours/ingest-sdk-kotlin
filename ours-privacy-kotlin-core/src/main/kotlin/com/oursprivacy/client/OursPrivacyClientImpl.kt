// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.client

import com.oursprivacy.core.ClientOptions
import com.oursprivacy.core.getPackageVersion
import com.oursprivacy.services.blocking.BatchService
import com.oursprivacy.services.blocking.BatchServiceImpl
import com.oursprivacy.services.blocking.TrackService
import com.oursprivacy.services.blocking.TrackServiceImpl
import com.oursprivacy.services.blocking.VisitorService
import com.oursprivacy.services.blocking.VisitorServiceImpl

class OursPrivacyClientImpl(private val clientOptions: ClientOptions) : OursPrivacyClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Kotlin ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: OursPrivacyClientAsync by lazy { OursPrivacyClientAsyncImpl(clientOptions) }

    private val withRawResponse: OursPrivacyClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val batch: BatchService by lazy { BatchServiceImpl(clientOptionsWithUserAgent) }

    private val track: TrackService by lazy { TrackServiceImpl(clientOptionsWithUserAgent) }

    private val visitor: VisitorService by lazy { VisitorServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): OursPrivacyClientAsync = async

    override fun withRawResponse(): OursPrivacyClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): OursPrivacyClient =
        OursPrivacyClientImpl(clientOptions.toBuilder().apply(modifier).build())

    override fun batch(): BatchService = batch

    override fun track(): TrackService = track

    override fun visitor(): VisitorService = visitor

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OursPrivacyClient.WithRawResponse {

        private val batch: BatchService.WithRawResponse by lazy {
            BatchServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val track: TrackService.WithRawResponse by lazy {
            TrackServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val visitor: VisitorService.WithRawResponse by lazy {
            VisitorServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): OursPrivacyClient.WithRawResponse =
            OursPrivacyClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        override fun batch(): BatchService.WithRawResponse = batch

        override fun track(): TrackService.WithRawResponse = track

        override fun visitor(): VisitorService.WithRawResponse = visitor
    }
}
