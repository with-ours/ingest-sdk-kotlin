// File generated from our OpenAPI spec by Stainless.

package com.ours_privacy.api.models.visitor

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.ours_privacy.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VisitorUpsertResponseTest {

    @Test
    fun create() {
        val visitorUpsertResponse =
            VisitorUpsertResponse.builder().success(VisitorUpsertResponse.Success.TRUE).build()

        assertThat(visitorUpsertResponse.success()).isEqualTo(VisitorUpsertResponse.Success.TRUE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val visitorUpsertResponse =
            VisitorUpsertResponse.builder().success(VisitorUpsertResponse.Success.TRUE).build()

        val roundtrippedVisitorUpsertResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(visitorUpsertResponse),
                jacksonTypeRef<VisitorUpsertResponse>(),
            )

        assertThat(roundtrippedVisitorUpsertResponse).isEqualTo(visitorUpsertResponse)
    }
}
