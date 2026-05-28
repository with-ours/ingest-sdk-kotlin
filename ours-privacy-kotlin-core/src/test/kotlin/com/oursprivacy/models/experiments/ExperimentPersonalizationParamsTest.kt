// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.models.experiments

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExperimentPersonalizationParamsTest {

    @Test
    fun create() {
        ExperimentPersonalizationParams.builder().token("token").visitorId("x").build()
    }

    @Test
    fun body() {
        val params = ExperimentPersonalizationParams.builder().token("token").visitorId("x").build()

        val body = params._body()

        assertThat(body.token()).isEqualTo("token")
        assertThat(body.visitorId()).isEqualTo("x")
    }
}
