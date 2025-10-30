// File generated from our OpenAPI spec by Stainless.

package com.ours_privacy.api.models.identify

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.ours_privacy.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IdentifyCreateOrUpdateResponseTest {

    @Test
    fun create() {
        val identifyCreateOrUpdateResponse =
            IdentifyCreateOrUpdateResponse.builder()
                .success(IdentifyCreateOrUpdateResponse.Success.TRUE)
                .build()

        assertThat(identifyCreateOrUpdateResponse.success())
            .isEqualTo(IdentifyCreateOrUpdateResponse.Success.TRUE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val identifyCreateOrUpdateResponse =
            IdentifyCreateOrUpdateResponse.builder()
                .success(IdentifyCreateOrUpdateResponse.Success.TRUE)
                .build()

        val roundtrippedIdentifyCreateOrUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(identifyCreateOrUpdateResponse),
                jacksonTypeRef<IdentifyCreateOrUpdateResponse>(),
            )

        assertThat(roundtrippedIdentifyCreateOrUpdateResponse)
            .isEqualTo(identifyCreateOrUpdateResponse)
    }
}
