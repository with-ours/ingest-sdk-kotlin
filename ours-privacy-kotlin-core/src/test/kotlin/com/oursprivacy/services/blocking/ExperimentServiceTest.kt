// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.services.blocking

import com.oursprivacy.client.okhttp.OursPrivacyOkHttpClient
import com.oursprivacy.models.experiments.ExperimentAssignmentParams
import com.oursprivacy.models.experiments.ExperimentPersonalizationParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ExperimentServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun assignment() {
        val client = OursPrivacyOkHttpClient.fromEnv()
        val experimentService = client.experiments()

        val response =
            experimentService.assignment(
                ExperimentAssignmentParams.builder()
                    .experimentKey("experiment_key")
                    .token("token")
                    .visitorId("x")
                    .context(
                        ExperimentAssignmentParams.Context.builder()
                            .search("search")
                            .url("url")
                            .build()
                    )
                    .trackImpression(true)
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun personalization() {
        val client = OursPrivacyOkHttpClient.fromEnv()
        val experimentService = client.experiments()

        val response =
            experimentService.personalization(
                ExperimentPersonalizationParams.builder().token("token").visitorId("x").build()
            )

        response.validate()
    }
}
