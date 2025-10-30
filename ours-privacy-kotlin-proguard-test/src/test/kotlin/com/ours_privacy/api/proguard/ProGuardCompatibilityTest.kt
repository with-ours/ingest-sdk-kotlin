// File generated from our OpenAPI spec by Stainless.

package com.ours_privacy.api.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.ours_privacy.api.client.okhttp.OursPrivacyOkHttpClient
import com.ours_privacy.api.core.jsonMapper
import com.ours_privacy.api.models.track.TrackCreateEventResponse
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
        val client = OursPrivacyOkHttpClient.builder().apiKey("My API Key").build()

        assertThat(client).isNotNull()
        assertThat(client.track()).isNotNull()
        assertThat(client.identify()).isNotNull()
    }

    @Test
    fun trackCreateEventResponseRoundtrip() {
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
