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
                .failed(0L)
                .addResult(
                    BatchCreateResponse.Result.UnionMember0.builder()
                        .index(0L)
                        .success(BatchCreateResponse.Result.UnionMember0.Success.TRUE)
                        .build()
                )
                .success(true)
                .build()

        assertThat(batchCreateResponse.accepted()).isEqualTo(0L)
        assertThat(batchCreateResponse.failed()).isEqualTo(0L)
        assertThat(batchCreateResponse.results())
            .containsExactly(
                BatchCreateResponse.Result.ofUnionMember0(
                    BatchCreateResponse.Result.UnionMember0.builder()
                        .index(0L)
                        .success(BatchCreateResponse.Result.UnionMember0.Success.TRUE)
                        .build()
                )
            )
        assertThat(batchCreateResponse.success()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val batchCreateResponse =
            BatchCreateResponse.builder()
                .accepted(0L)
                .failed(0L)
                .addResult(
                    BatchCreateResponse.Result.UnionMember0.builder()
                        .index(0L)
                        .success(BatchCreateResponse.Result.UnionMember0.Success.TRUE)
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedBatchCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(batchCreateResponse),
                jacksonTypeRef<BatchCreateResponse>(),
            )

        assertThat(roundtrippedBatchCreateResponse).isEqualTo(batchCreateResponse)
    }
}
