// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.services.blocking

import com.oursprivacy.TestServerExtension
import com.oursprivacy.client.okhttp.OursPrivacyOkHttpClient
import com.oursprivacy.models.experiments.ExperimentAssignmentParams
import com.oursprivacy.models.experiments.ExperimentPersonalizationParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ExperimentServiceTest {

    @Test
    fun assignment() {
        val client = OursPrivacyOkHttpClient.builder().baseUrl(TestServerExtension.BASE_URL).build()
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

    @Test
    fun personalization() {
        val client = OursPrivacyOkHttpClient.builder().baseUrl(TestServerExtension.BASE_URL).build()
        val experimentService = client.experiments()

        val response =
            experimentService.personalization(
                ExperimentPersonalizationParams.builder().token("token").visitorId("x").build()
            )

        response.validate()
    }
}
