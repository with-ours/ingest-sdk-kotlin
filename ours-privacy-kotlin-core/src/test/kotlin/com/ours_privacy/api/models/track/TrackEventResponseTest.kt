// File generated from our OpenAPI spec by Stainless.

package com.ours_privacy.api.models.track

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.ours_privacy.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TrackEventResponseTest {

    @Test
    fun create() {
        val trackEventResponse =
            TrackEventResponse.builder().success(TrackEventResponse.Success.TRUE).build()

        assertThat(trackEventResponse.success()).isEqualTo(TrackEventResponse.Success.TRUE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val trackEventResponse =
            TrackEventResponse.builder().success(TrackEventResponse.Success.TRUE).build()

        val roundtrippedTrackEventResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(trackEventResponse),
                jacksonTypeRef<TrackEventResponse>(),
            )

        assertThat(roundtrippedTrackEventResponse).isEqualTo(trackEventResponse)
    }
}
