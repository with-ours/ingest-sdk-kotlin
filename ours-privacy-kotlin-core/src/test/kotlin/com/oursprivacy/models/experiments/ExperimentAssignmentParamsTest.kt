// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.models.experiments

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExperimentAssignmentParamsTest {

    @Test
    fun create() {
        ExperimentAssignmentParams.builder()
            .experimentKey("experiment_key")
            .token("token")
            .visitorId("x")
            .context(
                ExperimentAssignmentParams.Context.builder().search("search").url("url").build()
            )
            .trackImpression(true)
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ExperimentAssignmentParams.builder()
                .experimentKey("experiment_key")
                .token("token")
                .visitorId("x")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("experiment_key")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ExperimentAssignmentParams.builder()
                .experimentKey("experiment_key")
                .token("token")
                .visitorId("x")
                .context(
                    ExperimentAssignmentParams.Context.builder().search("search").url("url").build()
                )
                .trackImpression(true)
                .build()

        val body = params._body()

        assertThat(body.token()).isEqualTo("token")
        assertThat(body.visitorId()).isEqualTo("x")
        assertThat(body.context())
            .isEqualTo(
                ExperimentAssignmentParams.Context.builder().search("search").url("url").build()
            )
        assertThat(body.trackImpression()).isEqualTo(true)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ExperimentAssignmentParams.builder()
                .experimentKey("experiment_key")
                .token("token")
                .visitorId("x")
                .build()

        val body = params._body()

        assertThat(body.token()).isEqualTo("token")
        assertThat(body.visitorId()).isEqualTo("x")
    }
}
