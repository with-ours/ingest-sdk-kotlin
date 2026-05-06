// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.models.batch

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.oursprivacy.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BatchCreateResponseTest {

    @Test
    fun create() {
        val batchCreateResponse =
            BatchCreateResponse.builder()
                .accepted(0L)
                .failed(BatchCreateResponse.Failed._0)
                .addResult(
                    BatchCreateResponse.Result.builder()
                        .index(0L)
                        .success(BatchCreateResponse.Result.Success.TRUE)
                        .build()
                )
                .success(BatchCreateResponse.Success.TRUE)
                .build()

        assertThat(batchCreateResponse.accepted()).isEqualTo(0L)
        assertThat(batchCreateResponse.failed()).isEqualTo(BatchCreateResponse.Failed._0)
        assertThat(batchCreateResponse.results())
            .containsExactly(
                BatchCreateResponse.Result.builder()
                    .index(0L)
                    .success(BatchCreateResponse.Result.Success.TRUE)
                    .build()
            )
        assertThat(batchCreateResponse.success()).isEqualTo(BatchCreateResponse.Success.TRUE)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val batchCreateResponse =
            BatchCreateResponse.builder()
                .accepted(0L)
                .failed(BatchCreateResponse.Failed._0)
                .addResult(
                    BatchCreateResponse.Result.builder()
                        .index(0L)
                        .success(BatchCreateResponse.Result.Success.TRUE)
                        .build()
                )
                .success(BatchCreateResponse.Success.TRUE)
                .build()

        val roundtrippedBatchCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchCreateResponse),
                jacksonTypeRef<BatchCreateResponse>(),
            )

        assertThat(roundtrippedBatchCreateResponse).isEqualTo(batchCreateResponse)
    }
}
