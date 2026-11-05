// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.services.async

import com.oursprivacy.TestServerExtension
import com.oursprivacy.client.okhttp.OursPrivacyOkHttpClientAsync
import com.oursprivacy.models.experiments.ExperimentAssignmentParams
import com.oursprivacy.models.experiments.ExperimentPersonalizationParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ExperimentServiceAsyncTest {

    @Test
    suspend fun assignment() {
        val client =
            OursPrivacyOkHttpClientAsync.builder().baseUrl(TestServerExtension.BASE_URL).build()
        val experimentServiceAsync = client.experiments()

        val response =
            experimentServiceAsync.assignment(
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
    suspend fun personalization() {
        val client =
            OursPrivacyOkHttpClientAsync.builder().baseUrl(TestServerExtension.BASE_URL).build()
        val experimentServiceAsync = client.experiments()

        val response =
            experimentServiceAsync.personalization(
                ExperimentPersonalizationParams.builder().token("token").visitorId("x").build()
            )

        response.validate()
    }
}
