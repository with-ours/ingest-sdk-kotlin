// File generated from our OpenAPI spec by Stainless.

package com.ours_privacy.api.models.track

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.ours_privacy.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TrackCreateEventResponseTest {

    @Test
    fun create() {
        val trackCreateEventResponse =
            TrackCreateEventResponse.builder()
                .success(TrackCreateEventResponse.Success.TRUE)
                .build()

        assertThat(trackCreateEventResponse.success())
            .isEqualTo(TrackCreateEventResponse.Success.TRUE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val trackCreateEventResponse =
            TrackCreateEventResponse.builder()
                .success(TrackCreateEventResponse.Success.TRUE)
                .build()

        val roundtrippedTrackCreateEventResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(trackCreateEventResponse),
                jacksonTypeRef<TrackCreateEventResponse>(),
            )

        assertThat(roundtrippedTrackCreateEventResponse).isEqualTo(trackCreateEventResponse)
    }
}
