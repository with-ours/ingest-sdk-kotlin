// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.oursprivacy.client.okhttp.OursPrivacyOkHttpClient
import com.oursprivacy.core.jsonMapper
import com.oursprivacy.models.experiments.ExperimentAssignmentResponse
import com.oursprivacy.models.track.TrackEventResponse
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.javaMethod
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProGuardCompatibilityTest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")

            // We have to manually run the test methods instead of using the JUnit runner because it
            // seems impossible to get working with R8.
            val test = ProGuardCompatibilityTest()
            test::class
                .memberFunctions
                .asSequence()
                .filter { function ->
                    function.javaMethod?.isAnnotationPresent(Test::class.java) == true
                }
                .forEach { it.call(test) }
        }
    }

    @Test
    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream(
                "META-INF/proguard/ours-privacy-kotlin-core.pro"
            )

        assertThat(rulesFile).isNotNull()
    }

    @Test
    fun client() {
        val client = OursPrivacyOkHttpClient.fromEnv()

        assertThat(client).isNotNull()
        assertThat(client.batch()).isNotNull()
        assertThat(client.track()).isNotNull()
        assertThat(client.visitor()).isNotNull()
        assertThat(client.experiments()).isNotNull()
    }

    @Test
    fun trackEventResponseRoundtrip() {
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

    @Test
    fun experimentAssignmentResponseRoundtrip() {
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
}
