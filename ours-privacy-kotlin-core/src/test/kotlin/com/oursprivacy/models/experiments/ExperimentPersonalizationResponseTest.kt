// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.models.experiments

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.oursprivacy.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExperimentPersonalizationResponseTest {

    @Test
    fun create() {
        val experimentPersonalizationResponse =
            ExperimentPersonalizationResponse.builder()
                .addPersonalization(
                    ExperimentPersonalizationResponse.Personalization.builder()
                        .assignedAt(0.0)
                        .experimentId("experiment_id")
                        .variantId("variant_id")
                        .experimentKey("experiment_key")
                        .experimentName("experiment_name")
                        .variantName("variant_name")
                        .build()
                )
                .success(ExperimentPersonalizationResponse.Success.TRUE)
                .build()

        assertThat(experimentPersonalizationResponse.personalizations())
            .containsExactly(
                ExperimentPersonalizationResponse.Personalization.builder()
                    .assignedAt(0.0)
                    .experimentId("experiment_id")
                    .variantId("variant_id")
                    .experimentKey("experiment_key")
                    .experimentName("experiment_name")
                    .variantName("variant_name")
                    .build()
            )
        assertThat(experimentPersonalizationResponse.success())
            .isEqualTo(ExperimentPersonalizationResponse.Success.TRUE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val experimentPersonalizationResponse =
            ExperimentPersonalizationResponse.builder()
                .addPersonalization(
                    ExperimentPersonalizationResponse.Personalization.builder()
                        .assignedAt(0.0)
                        .experimentId("experiment_id")
                        .variantId("variant_id")
                        .experimentKey("experiment_key")
                        .experimentName("experiment_name")
                        .variantName("variant_name")
                        .build()
                )
                .success(ExperimentPersonalizationResponse.Success.TRUE)
                .build()

        val roundtrippedExperimentPersonalizationResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(experimentPersonalizationResponse),
                jacksonTypeRef<ExperimentPersonalizationResponse>(),
            )

        assertThat(roundtrippedExperimentPersonalizationResponse)
            .isEqualTo(experimentPersonalizationResponse)
    }
}
