// File generated from our OpenAPI spec by Stainless.

package com.ours_privacy.api.client

import com.ours_privacy.api.core.ClientOptions
import com.ours_privacy.api.core.getPackageVersion
import com.ours_privacy.api.services.blocking.IdentifyService
import com.ours_privacy.api.services.blocking.IdentifyServiceImpl
import com.ours_privacy.api.services.blocking.TrackService
import com.ours_privacy.api.services.blocking.TrackServiceImpl

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

    private val track: TrackService by lazy { TrackServiceImpl(clientOptionsWithUserAgent) }

    private val identify: IdentifyService by lazy {
        IdentifyServiceImpl(clientOptionsWithUserAgent)
    }

    override fun async(): OursPrivacyClientAsync = async

    override fun withRawResponse(): OursPrivacyClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): OursPrivacyClient =
        OursPrivacyClientImpl(clientOptions.toBuilder().apply(modifier).build())

    override fun track(): TrackService = track

    override fun identify(): IdentifyService = identify

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OursPrivacyClient.WithRawResponse {

        private val track: TrackService.WithRawResponse by lazy {
            TrackServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val identify: IdentifyService.WithRawResponse by lazy {
            IdentifyServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): OursPrivacyClient.WithRawResponse =
            OursPrivacyClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        override fun track(): TrackService.WithRawResponse = track

        override fun identify(): IdentifyService.WithRawResponse = identify
    }
}
