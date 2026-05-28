// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.models.experiments

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.oursprivacy.core.ExcludeMissing
import com.oursprivacy.core.JsonField
import com.oursprivacy.core.JsonMissing
import com.oursprivacy.core.JsonValue
import com.oursprivacy.core.Params
import com.oursprivacy.core.checkRequired
import com.oursprivacy.core.http.Headers
import com.oursprivacy.core.http.QueryParams
import com.oursprivacy.errors.OursPrivacyInvalidDataException
import java.util.Collections
import java.util.Objects

/**
 * Return the server-side variant assignment for a visitor in a single A/B or multivariate
 * experiment, identified by its experiment key. Bucketing is deterministic on `visitor_id` and is
 * sticky across calls. Tracking an impression is the default — pass `track_impression: false` to
 * read without recording. The browser SDK and this endpoint converge on the same variant for the
 * same visitor.
 */
class ExperimentAssignmentParams
private constructor(
    private val experimentKey: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** The experiment's stable key. Surfaced in the dashboard under each experiment's setup tab. */
    fun experimentKey(): String? = experimentKey

    /**
     * The experiment token (`exp_*`) for the experiment settings holding this experiment. Available
     * from the dashboard.
     *
     * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun token(): String = body.token()

    /**
     * Stable identifier for the visitor — typically the Ours visitor id from your browser cookie,
     * or your own server-side user id if you keep the same id consistent across browser and server.
     *
     * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun visitorId(): String = body.visitorId()

    /**
     * Optional page context for URL + query-param eligibility. Variant bucketing is deterministic
     * on `visitor_id` regardless of context.
     *
     * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun context(): Context? = body.context()

    /**
     * When true (default), an `$experiment_impression` event is enqueued and the visitor's
     * `experiment_assignments` map is updated. Set to false to read the assignment without
     * recording an impression — useful for in-test diagnostics.
     *
     * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun trackImpression(): Boolean? = body.trackImpression()

    /**
     * Returns the raw JSON value of [token].
     *
     * Unlike [token], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _token(): JsonField<String> = body._token()

    /**
     * Returns the raw JSON value of [visitorId].
     *
     * Unlike [visitorId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _visitorId(): JsonField<String> = body._visitorId()

    /**
     * Returns the raw JSON value of [context].
     *
     * Unlike [context], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _context(): JsonField<Context> = body._context()

    /**
     * Returns the raw JSON value of [trackImpression].
     *
     * Unlike [trackImpression], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _trackImpression(): JsonField<Boolean> = body._trackImpression()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ExperimentAssignmentParams].
         *
         * The following fields are required:
         * ```kotlin
         * .token()
         * .visitorId()
         * ```
         */
        fun builder() = Builder()
    }

    /** A builder for [ExperimentAssignmentParams]. */
    class Builder internal constructor() {

        private var experimentKey: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        internal fun from(experimentAssignmentParams: ExperimentAssignmentParams) = apply {
            experimentKey = experimentAssignmentParams.experimentKey
            body = experimentAssignmentParams.body.toBuilder()
            additionalHeaders = experimentAssignmentParams.additionalHeaders.toBuilder()
            additionalQueryParams = experimentAssignmentParams.additionalQueryParams.toBuilder()
        }

        /**
         * The experiment's stable key. Surfaced in the dashboard under each experiment's setup tab.
         */
        fun experimentKey(experimentKey: String?) = apply { this.experimentKey = experimentKey }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [token]
         * - [visitorId]
         * - [context]
         * - [trackImpression]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * The experiment token (`exp_*`) for the experiment settings holding this experiment.
         * Available from the dashboard.
         */
        fun token(token: String) = apply { body.token(token) }

        /**
         * Sets [Builder.token] to an arbitrary JSON value.
         *
         * You should usually call [Builder.token] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun token(token: JsonField<String>) = apply { body.token(token) }

        /**
         * Stable identifier for the visitor — typically the Ours visitor id from your browser
         * cookie, or your own server-side user id if you keep the same id consistent across browser
         * and server.
         */
        fun visitorId(visitorId: String) = apply { body.visitorId(visitorId) }

        /**
         * Sets [Builder.visitorId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.visitorId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun visitorId(visitorId: JsonField<String>) = apply { body.visitorId(visitorId) }

        /**
         * Optional page context for URL + query-param eligibility. Variant bucketing is
         * deterministic on `visitor_id` regardless of context.
         */
        fun context(context: Context?) = apply { body.context(context) }

        /**
         * Sets [Builder.context] to an arbitrary JSON value.
         *
         * You should usually call [Builder.context] with a well-typed [Context] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun context(context: JsonField<Context>) = apply { body.context(context) }

        /**
         * When true (default), an `$experiment_impression` event is enqueued and the visitor's
         * `experiment_assignments` map is updated. Set to false to read the assignment without
         * recording an impression — useful for in-test diagnostics.
         */
        fun trackImpression(trackImpression: Boolean?) = apply {
            body.trackImpression(trackImpression)
        }

        /**
         * Alias for [Builder.trackImpression].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun trackImpression(trackImpression: Boolean) = trackImpression(trackImpression as Boolean?)

        /**
         * Sets [Builder.trackImpression] to an arbitrary JSON value.
         *
         * You should usually call [Builder.trackImpression] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun trackImpression(trackImpression: JsonField<Boolean>) = apply {
            body.trackImpression(trackImpression)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [ExperimentAssignmentParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```kotlin
         * .token()
         * .visitorId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ExperimentAssignmentParams =
            ExperimentAssignmentParams(
                experimentKey,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> experimentKey ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val token: JsonField<String>,
        private val visitorId: JsonField<String>,
        private val context: JsonField<Context>,
        private val trackImpression: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("token") @ExcludeMissing token: JsonField<String> = JsonMissing.of(),
            @JsonProperty("visitor_id")
            @ExcludeMissing
            visitorId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("context") @ExcludeMissing context: JsonField<Context> = JsonMissing.of(),
            @JsonProperty("track_impression")
            @ExcludeMissing
            trackImpression: JsonField<Boolean> = JsonMissing.of(),
        ) : this(token, visitorId, context, trackImpression, mutableMapOf())

        /**
         * The experiment token (`exp_*`) for the experiment settings holding this experiment.
         * Available from the dashboard.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun token(): String = token.getRequired("token")

        /**
         * Stable identifier for the visitor — typically the Ours visitor id from your browser
         * cookie, or your own server-side user id if you keep the same id consistent across browser
         * and server.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun visitorId(): String = visitorId.getRequired("visitor_id")

        /**
         * Optional page context for URL + query-param eligibility. Variant bucketing is
         * deterministic on `visitor_id` regardless of context.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun context(): Context? = context.getNullable("context")

        /**
         * When true (default), an `$experiment_impression` event is enqueued and the visitor's
         * `experiment_assignments` map is updated. Set to false to read the assignment without
         * recording an impression — useful for in-test diagnostics.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun trackImpression(): Boolean? = trackImpression.getNullable("track_impression")

        /**
         * Returns the raw JSON value of [token].
         *
         * Unlike [token], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("token") @ExcludeMissing fun _token(): JsonField<String> = token

        /**
         * Returns the raw JSON value of [visitorId].
         *
         * Unlike [visitorId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("visitor_id") @ExcludeMissing fun _visitorId(): JsonField<String> = visitorId

        /**
         * Returns the raw JSON value of [context].
         *
         * Unlike [context], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("context") @ExcludeMissing fun _context(): JsonField<Context> = context

        /**
         * Returns the raw JSON value of [trackImpression].
         *
         * Unlike [trackImpression], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("track_impression")
        @ExcludeMissing
        fun _trackImpression(): JsonField<Boolean> = trackImpression

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```kotlin
             * .token()
             * .visitorId()
             * ```
             */
            fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var token: JsonField<String>? = null
            private var visitorId: JsonField<String>? = null
            private var context: JsonField<Context> = JsonMissing.of()
            private var trackImpression: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(body: Body) = apply {
                token = body.token
                visitorId = body.visitorId
                context = body.context
                trackImpression = body.trackImpression
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * The experiment token (`exp_*`) for the experiment settings holding this experiment.
             * Available from the dashboard.
             */
            fun token(token: String) = token(JsonField.of(token))

            /**
             * Sets [Builder.token] to an arbitrary JSON value.
             *
             * You should usually call [Builder.token] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun token(token: JsonField<String>) = apply { this.token = token }

            /**
             * Stable identifier for the visitor — typically the Ours visitor id from your browser
             * cookie, or your own server-side user id if you keep the same id consistent across
             * browser and server.
             */
            fun visitorId(visitorId: String) = visitorId(JsonField.of(visitorId))

            /**
             * Sets [Builder.visitorId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.visitorId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun visitorId(visitorId: JsonField<String>) = apply { this.visitorId = visitorId }

            /**
             * Optional page context for URL + query-param eligibility. Variant bucketing is
             * deterministic on `visitor_id` regardless of context.
             */
            fun context(context: Context?) = context(JsonField.ofNullable(context))

            /**
             * Sets [Builder.context] to an arbitrary JSON value.
             *
             * You should usually call [Builder.context] with a well-typed [Context] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun context(context: JsonField<Context>) = apply { this.context = context }

            /**
             * When true (default), an `$experiment_impression` event is enqueued and the visitor's
             * `experiment_assignments` map is updated. Set to false to read the assignment without
             * recording an impression — useful for in-test diagnostics.
             */
            fun trackImpression(trackImpression: Boolean?) =
                trackImpression(JsonField.ofNullable(trackImpression))

            /**
             * Alias for [Builder.trackImpression].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun trackImpression(trackImpression: Boolean) =
                trackImpression(trackImpression as Boolean?)

            /**
             * Sets [Builder.trackImpression] to an arbitrary JSON value.
             *
             * You should usually call [Builder.trackImpression] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun trackImpression(trackImpression: JsonField<Boolean>) = apply {
                this.trackImpression = trackImpression
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```kotlin
             * .token()
             * .visitorId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("token", token),
                    checkRequired("visitorId", visitorId),
                    context,
                    trackImpression,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OursPrivacyInvalidDataException if any value type in this object doesn't match
         *   its expected type.
         */
        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            token()
            visitorId()
            context()?.validate()
            trackImpression()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OursPrivacyInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        internal fun validity(): Int =
            (if (token.asKnown() == null) 0 else 1) +
                (if (visitorId.asKnown() == null) 0 else 1) +
                (context.asKnown()?.validity() ?: 0) +
                (if (trackImpression.asKnown() == null) 0 else 1)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                token == other.token &&
                visitorId == other.visitorId &&
                context == other.context &&
                trackImpression == other.trackImpression &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(token, visitorId, context, trackImpression, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{token=$token, visitorId=$visitorId, context=$context, trackImpression=$trackImpression, additionalProperties=$additionalProperties}"
    }

    /**
     * Optional page context for URL + query-param eligibility. Variant bucketing is deterministic
     * on `visitor_id` regardless of context.
     */
    class Context
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val search: JsonField<String>,
        private val url: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("search") @ExcludeMissing search: JsonField<String> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        ) : this(search, url, mutableMapOf())

        /**
         * The current query string (e.g. `?utm_source=meta`). When provided, the experiment's
         * query-param conditions are evaluated for eligibility. If omitted, the query string is
         * parsed from `url`.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun search(): String? = search.getNullable("search")

        /**
         * The current page URL. When provided, the experiment's URL patterns are evaluated for
         * eligibility — visitors on non-matching URLs are returned `in_experiment: false`. Omit
         * when the caller is pre-gating the request.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun url(): String? = url.getNullable("url")

        /**
         * Returns the raw JSON value of [search].
         *
         * Unlike [search], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("search") @ExcludeMissing fun _search(): JsonField<String> = search

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Context]. */
            fun builder() = Builder()
        }

        /** A builder for [Context]. */
        class Builder internal constructor() {

            private var search: JsonField<String> = JsonMissing.of()
            private var url: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(context: Context) = apply {
                search = context.search
                url = context.url
                additionalProperties = context.additionalProperties.toMutableMap()
            }

            /**
             * The current query string (e.g. `?utm_source=meta`). When provided, the experiment's
             * query-param conditions are evaluated for eligibility. If omitted, the query string is
             * parsed from `url`.
             */
            fun search(search: String?) = search(JsonField.ofNullable(search))

            /**
             * Sets [Builder.search] to an arbitrary JSON value.
             *
             * You should usually call [Builder.search] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun search(search: JsonField<String>) = apply { this.search = search }

            /**
             * The current page URL. When provided, the experiment's URL patterns are evaluated for
             * eligibility — visitors on non-matching URLs are returned `in_experiment: false`. Omit
             * when the caller is pre-gating the request.
             */
            fun url(url: String?) = url(JsonField.ofNullable(url))

            /**
             * Sets [Builder.url] to an arbitrary JSON value.
             *
             * You should usually call [Builder.url] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun url(url: JsonField<String>) = apply { this.url = url }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Context].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Context = Context(search, url, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OursPrivacyInvalidDataException if any value type in this object doesn't match
         *   its expected type.
         */
        fun validate(): Context = apply {
            if (validated) {
                return@apply
            }

            search()
            url()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: OursPrivacyInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        internal fun validity(): Int =
            (if (search.asKnown() == null) 0 else 1) + (if (url.asKnown() == null) 0 else 1)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Context &&
                search == other.search &&
                url == other.url &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(search, url, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Context{search=$search, url=$url, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExperimentAssignmentParams &&
            experimentKey == other.experimentKey &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(experimentKey, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "ExperimentAssignmentParams{experimentKey=$experimentKey, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
