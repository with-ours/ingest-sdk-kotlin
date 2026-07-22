// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.models.experiments

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.oursprivacy.core.JsonValue
import com.oursprivacy.core.jsonMapper
import com.oursprivacy.errors.OursPrivacyInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ExperimentAssignmentResponseTest {

    @Test
    fun ofUnionMember0() {
        val unionMember0 =
            ExperimentAssignmentResponse.UnionMember0.builder()
                .experimentId("experiment_id")
                .inExperiment(ExperimentAssignmentResponse.UnionMember0.InExperiment.TRUE)
                .success(ExperimentAssignmentResponse.UnionMember0.Success.TRUE)
                .variantId("variant_id")
                .experimentKey("experiment_key")
                .experimentName("experiment_name")
                .isControl(true)
                .redirect("redirect")
                .type("type")
                .variantName("variant_name")
                .build()

        val experimentAssignmentResponse = ExperimentAssignmentResponse.ofUnionMember0(unionMember0)

        assertThat(experimentAssignmentResponse.unionMember0()).isEqualTo(unionMember0)
        assertThat(experimentAssignmentResponse.unionMember1()).isNull()
    }

    @Test
    fun ofUnionMember0Roundtrip() {
        val jsonMapper = jsonMapper()
        val experimentAssignmentResponse =
            ExperimentAssignmentResponse.ofUnionMember0(
                ExperimentAssignmentResponse.UnionMember0.builder()
                    .experimentId("experiment_id")
                    .inExperiment(ExperimentAssignmentResponse.UnionMember0.InExperiment.TRUE)
                    .success(ExperimentAssignmentResponse.UnionMember0.Success.TRUE)
                    .variantId("variant_id")
                    .experimentKey("experiment_key")
                    .experimentName("experiment_name")
                    .isControl(true)
                    .redirect("redirect")
                    .type("type")
                    .variantName("variant_name")
                    .build()
            )

        val roundtrippedExperimentAssignmentResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(experimentAssignmentResponse),
                jacksonTypeRef<ExperimentAssignmentResponse>(),
            )

        assertThat(roundtrippedExperimentAssignmentResponse).isEqualTo(experimentAssignmentResponse)
    }

    @Test
    fun ofUnionMember1() {
        val unionMember1 =
            ExperimentAssignmentResponse.UnionMember1.builder()
                .inExperiment(ExperimentAssignmentResponse.UnionMember1.InExperiment.FALSE)
                .success(ExperimentAssignmentResponse.UnionMember1.Success.TRUE)
                .build()

        val experimentAssignmentResponse = ExperimentAssignmentResponse.ofUnionMember1(unionMember1)

        assertThat(experimentAssignmentResponse.unionMember0()).isNull()
        assertThat(experimentAssignmentResponse.unionMember1()).isEqualTo(unionMember1)
    }

    @Test
    fun ofUnionMember1Roundtrip() {
        val jsonMapper = jsonMapper()
        val experimentAssignmentResponse =
            ExperimentAssignmentResponse.ofUnionMember1(
                ExperimentAssignmentResponse.UnionMember1.builder()
                    .inExperiment(ExperimentAssignmentResponse.UnionMember1.InExperiment.FALSE)
                    .success(ExperimentAssignmentResponse.UnionMember1.Success.TRUE)
                    .build()
            )

        val roundtrippedExperimentAssignmentResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(experimentAssignmentResponse),
                jacksonTypeRef<ExperimentAssignmentResponse>(),
            )

        assertThat(roundtrippedExperimentAssignmentResponse).isEqualTo(experimentAssignmentResponse)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val experimentAssignmentResponse =
            jsonMapper()
                .convertValue(testCase.value, jacksonTypeRef<ExperimentAssignmentResponse>())

        val e =
            assertThrows<OursPrivacyInvalidDataException> {
                experimentAssignmentResponse.validate()
            }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
