// File generated from our OpenAPI spec by Stainless.

package com.ours_privacy.api.models.track

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.ours_privacy.api.core.ExcludeMissing
import com.ours_privacy.api.core.JsonField
import com.ours_privacy.api.core.JsonMissing
import com.ours_privacy.api.core.JsonValue
import com.ours_privacy.api.core.Params
import com.ours_privacy.api.core.checkRequired
import com.ours_privacy.api.core.http.Headers
import com.ours_privacy.api.core.http.QueryParams
import com.ours_privacy.api.core.toImmutable
import com.ours_privacy.api.errors.OursPrivacyInvalidDataException
import java.util.Collections
import java.util.Objects

/**
 * Track events from your server. Please include at least one of: userId, externalId, or email.
 * These properties help us associate events with existing users. For all fields, null values unset
 * the property and undefined values do not unset existing properties.
 */
class TrackEventParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The token for your Ours Privacy Source. You can find this in the Ours dashboard.
     *
     * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun token(): String = body.token()

    /**
     * The name of the event you're tracking. This must be whitelisted in the Ours dashboard.
     *
     * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun event(): String = body.event()

    /**
     * These properties are used throughout the Ours app to pass known values onto destinations
     *
     * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun defaultProperties(): DefaultProperties? = body.defaultProperties()

    /**
     * A unique identifier for the event. This helps prevent duplicate events.
     *
     * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun distinctId(): String? = body.distinctId()

    /**
     * The email address of a user. We will associate this event with the user or create a user.
     * Used for lookup if externalId and userId are not included in the request.
     *
     * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun email(): String? = body.email()

    /**
     * Any additional event properties you want to pass along.
     *
     * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun eventProperties(): EventProperties? = body.eventProperties()

    /**
     * The externalId (the ID in your system) of a user. We will associate this event with the user
     * or create a user. If included in the request, email lookup is ignored.
     *
     * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun externalId(): String? = body.externalId()

    /**
     * The time at which the event occurred in milliseconds since UTC epoch. The time must be in the
     * past and within the last 7 days.
     *
     * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun time(): Double? = body.time()

    /**
     * The Ours user id stored in local storage and cookies on your web properties. If userId is
     * included in the request, we do not lookup the user by email or externalId.
     *
     * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun userId(): String? = body.userId()

    /**
     * Properties to set on the visitor. (optional) You can also update these properties via the
     * identify endpoint.
     *
     * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun userProperties(): UserProperties? = body.userProperties()

    /**
     * Returns the raw JSON value of [token].
     *
     * Unlike [token], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _token(): JsonField<String> = body._token()

    /**
     * Returns the raw JSON value of [event].
     *
     * Unlike [event], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _event(): JsonField<String> = body._event()

    /**
     * Returns the raw JSON value of [defaultProperties].
     *
     * Unlike [defaultProperties], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _defaultProperties(): JsonField<DefaultProperties> = body._defaultProperties()

    /**
     * Returns the raw JSON value of [distinctId].
     *
     * Unlike [distinctId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _distinctId(): JsonField<String> = body._distinctId()

    /**
     * Returns the raw JSON value of [email].
     *
     * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _email(): JsonField<String> = body._email()

    /**
     * Returns the raw JSON value of [eventProperties].
     *
     * Unlike [eventProperties], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _eventProperties(): JsonField<EventProperties> = body._eventProperties()

    /**
     * Returns the raw JSON value of [externalId].
     *
     * Unlike [externalId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _externalId(): JsonField<String> = body._externalId()

    /**
     * Returns the raw JSON value of [time].
     *
     * Unlike [time], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _time(): JsonField<Double> = body._time()

    /**
     * Returns the raw JSON value of [userId].
     *
     * Unlike [userId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _userId(): JsonField<String> = body._userId()

    /**
     * Returns the raw JSON value of [userProperties].
     *
     * Unlike [userProperties], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _userProperties(): JsonField<UserProperties> = body._userProperties()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TrackEventParams].
         *
         * The following fields are required:
         * ```kotlin
         * .token()
         * .event()
         * ```
         */
        fun builder() = Builder()
    }

    /** A builder for [TrackEventParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        internal fun from(trackEventParams: TrackEventParams) = apply {
            body = trackEventParams.body.toBuilder()
            additionalHeaders = trackEventParams.additionalHeaders.toBuilder()
            additionalQueryParams = trackEventParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [token]
         * - [event]
         * - [defaultProperties]
         * - [distinctId]
         * - [email]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The token for your Ours Privacy Source. You can find this in the Ours dashboard. */
        fun token(token: String) = apply { body.token(token) }

        /**
         * Sets [Builder.token] to an arbitrary JSON value.
         *
         * You should usually call [Builder.token] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun token(token: JsonField<String>) = apply { body.token(token) }

        /**
         * The name of the event you're tracking. This must be whitelisted in the Ours dashboard.
         */
        fun event(event: String) = apply { body.event(event) }

        /**
         * Sets [Builder.event] to an arbitrary JSON value.
         *
         * You should usually call [Builder.event] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun event(event: JsonField<String>) = apply { body.event(event) }

        /**
         * These properties are used throughout the Ours app to pass known values onto destinations
         */
        fun defaultProperties(defaultProperties: DefaultProperties?) = apply {
            body.defaultProperties(defaultProperties)
        }

        /**
         * Sets [Builder.defaultProperties] to an arbitrary JSON value.
         *
         * You should usually call [Builder.defaultProperties] with a well-typed [DefaultProperties]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun defaultProperties(defaultProperties: JsonField<DefaultProperties>) = apply {
            body.defaultProperties(defaultProperties)
        }

        /** A unique identifier for the event. This helps prevent duplicate events. */
        fun distinctId(distinctId: String?) = apply { body.distinctId(distinctId) }

        /**
         * Sets [Builder.distinctId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.distinctId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun distinctId(distinctId: JsonField<String>) = apply { body.distinctId(distinctId) }

        /**
         * The email address of a user. We will associate this event with the user or create a user.
         * Used for lookup if externalId and userId are not included in the request.
         */
        fun email(email: String?) = apply { body.email(email) }

        /**
         * Sets [Builder.email] to an arbitrary JSON value.
         *
         * You should usually call [Builder.email] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun email(email: JsonField<String>) = apply { body.email(email) }

        /** Any additional event properties you want to pass along. */
        fun eventProperties(eventProperties: EventProperties?) = apply {
            body.eventProperties(eventProperties)
        }

        /**
         * Sets [Builder.eventProperties] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eventProperties] with a well-typed [EventProperties]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun eventProperties(eventProperties: JsonField<EventProperties>) = apply {
            body.eventProperties(eventProperties)
        }

        /**
         * The externalId (the ID in your system) of a user. We will associate this event with the
         * user or create a user. If included in the request, email lookup is ignored.
         */
        fun externalId(externalId: String?) = apply { body.externalId(externalId) }

        /**
         * Sets [Builder.externalId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.externalId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun externalId(externalId: JsonField<String>) = apply { body.externalId(externalId) }

        /**
         * The time at which the event occurred in milliseconds since UTC epoch. The time must be in
         * the past and within the last 7 days.
         */
        fun time(time: Double?) = apply { body.time(time) }

        /**
         * Alias for [Builder.time].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun time(time: Double) = time(time as Double?)

        /**
         * Sets [Builder.time] to an arbitrary JSON value.
         *
         * You should usually call [Builder.time] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun time(time: JsonField<Double>) = apply { body.time(time) }

        /**
         * The Ours user id stored in local storage and cookies on your web properties. If userId is
         * included in the request, we do not lookup the user by email or externalId.
         */
        fun userId(userId: String?) = apply { body.userId(userId) }

        /**
         * Sets [Builder.userId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.userId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun userId(userId: JsonField<String>) = apply { body.userId(userId) }

        /**
         * Properties to set on the visitor. (optional) You can also update these properties via the
         * identify endpoint.
         */
        fun userProperties(userProperties: UserProperties?) = apply {
            body.userProperties(userProperties)
        }

        /**
         * Sets [Builder.userProperties] to an arbitrary JSON value.
         *
         * You should usually call [Builder.userProperties] with a well-typed [UserProperties] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun userProperties(userProperties: JsonField<UserProperties>) = apply {
            body.userProperties(userProperties)
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
         * Returns an immutable instance of [TrackEventParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```kotlin
         * .token()
         * .event()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): TrackEventParams =
            TrackEventParams(body.build(), additionalHeaders.build(), additionalQueryParams.build())
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val token: JsonField<String>,
        private val event: JsonField<String>,
        private val defaultProperties: JsonField<DefaultProperties>,
        private val distinctId: JsonField<String>,
        private val email: JsonField<String>,
        private val eventProperties: JsonField<EventProperties>,
        private val externalId: JsonField<String>,
        private val time: JsonField<Double>,
        private val userId: JsonField<String>,
        private val userProperties: JsonField<UserProperties>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("token") @ExcludeMissing token: JsonField<String> = JsonMissing.of(),
            @JsonProperty("event") @ExcludeMissing event: JsonField<String> = JsonMissing.of(),
            @JsonProperty("defaultProperties")
            @ExcludeMissing
            defaultProperties: JsonField<DefaultProperties> = JsonMissing.of(),
            @JsonProperty("distinctId")
            @ExcludeMissing
            distinctId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
            @JsonProperty("eventProperties")
            @ExcludeMissing
            eventProperties: JsonField<EventProperties> = JsonMissing.of(),
            @JsonProperty("externalId")
            @ExcludeMissing
            externalId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("time") @ExcludeMissing time: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("userId") @ExcludeMissing userId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("userProperties")
            @ExcludeMissing
            userProperties: JsonField<UserProperties> = JsonMissing.of(),
        ) : this(
            token,
            event,
            defaultProperties,
            distinctId,
            email,
            eventProperties,
            externalId,
            time,
            userId,
            userProperties,
            mutableMapOf(),
        )

        /**
         * The token for your Ours Privacy Source. You can find this in the Ours dashboard.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun token(): String = token.getRequired("token")

        /**
         * The name of the event you're tracking. This must be whitelisted in the Ours dashboard.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun event(): String = event.getRequired("event")

        /**
         * These properties are used throughout the Ours app to pass known values onto destinations
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun defaultProperties(): DefaultProperties? =
            defaultProperties.getNullable("defaultProperties")

        /**
         * A unique identifier for the event. This helps prevent duplicate events.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun distinctId(): String? = distinctId.getNullable("distinctId")

        /**
         * The email address of a user. We will associate this event with the user or create a user.
         * Used for lookup if externalId and userId are not included in the request.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun email(): String? = email.getNullable("email")

        /**
         * Any additional event properties you want to pass along.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun eventProperties(): EventProperties? = eventProperties.getNullable("eventProperties")

        /**
         * The externalId (the ID in your system) of a user. We will associate this event with the
         * user or create a user. If included in the request, email lookup is ignored.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun externalId(): String? = externalId.getNullable("externalId")

        /**
         * The time at which the event occurred in milliseconds since UTC epoch. The time must be in
         * the past and within the last 7 days.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun time(): Double? = time.getNullable("time")

        /**
         * The Ours user id stored in local storage and cookies on your web properties. If userId is
         * included in the request, we do not lookup the user by email or externalId.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun userId(): String? = userId.getNullable("userId")

        /**
         * Properties to set on the visitor. (optional) You can also update these properties via the
         * identify endpoint.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun userProperties(): UserProperties? = userProperties.getNullable("userProperties")

        /**
         * Returns the raw JSON value of [token].
         *
         * Unlike [token], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("token") @ExcludeMissing fun _token(): JsonField<String> = token

        /**
         * Returns the raw JSON value of [event].
         *
         * Unlike [event], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("event") @ExcludeMissing fun _event(): JsonField<String> = event

        /**
         * Returns the raw JSON value of [defaultProperties].
         *
         * Unlike [defaultProperties], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("defaultProperties")
        @ExcludeMissing
        fun _defaultProperties(): JsonField<DefaultProperties> = defaultProperties

        /**
         * Returns the raw JSON value of [distinctId].
         *
         * Unlike [distinctId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("distinctId")
        @ExcludeMissing
        fun _distinctId(): JsonField<String> = distinctId

        /**
         * Returns the raw JSON value of [email].
         *
         * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

        /**
         * Returns the raw JSON value of [eventProperties].
         *
         * Unlike [eventProperties], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("eventProperties")
        @ExcludeMissing
        fun _eventProperties(): JsonField<EventProperties> = eventProperties

        /**
         * Returns the raw JSON value of [externalId].
         *
         * Unlike [externalId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("externalId")
        @ExcludeMissing
        fun _externalId(): JsonField<String> = externalId

        /**
         * Returns the raw JSON value of [time].
         *
         * Unlike [time], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("time") @ExcludeMissing fun _time(): JsonField<Double> = time

        /**
         * Returns the raw JSON value of [userId].
         *
         * Unlike [userId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("userId") @ExcludeMissing fun _userId(): JsonField<String> = userId

        /**
         * Returns the raw JSON value of [userProperties].
         *
         * Unlike [userProperties], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("userProperties")
        @ExcludeMissing
        fun _userProperties(): JsonField<UserProperties> = userProperties

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
             * .event()
             * ```
             */
            fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var token: JsonField<String>? = null
            private var event: JsonField<String>? = null
            private var defaultProperties: JsonField<DefaultProperties> = JsonMissing.of()
            private var distinctId: JsonField<String> = JsonMissing.of()
            private var email: JsonField<String> = JsonMissing.of()
            private var eventProperties: JsonField<EventProperties> = JsonMissing.of()
            private var externalId: JsonField<String> = JsonMissing.of()
            private var time: JsonField<Double> = JsonMissing.of()
            private var userId: JsonField<String> = JsonMissing.of()
            private var userProperties: JsonField<UserProperties> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(body: Body) = apply {
                token = body.token
                event = body.event
                defaultProperties = body.defaultProperties
                distinctId = body.distinctId
                email = body.email
                eventProperties = body.eventProperties
                externalId = body.externalId
                time = body.time
                userId = body.userId
                userProperties = body.userProperties
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The token for your Ours Privacy Source. You can find this in the Ours dashboard. */
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
             * The name of the event you're tracking. This must be whitelisted in the Ours
             * dashboard.
             */
            fun event(event: String) = event(JsonField.of(event))

            /**
             * Sets [Builder.event] to an arbitrary JSON value.
             *
             * You should usually call [Builder.event] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun event(event: JsonField<String>) = apply { this.event = event }

            /**
             * These properties are used throughout the Ours app to pass known values onto
             * destinations
             */
            fun defaultProperties(defaultProperties: DefaultProperties?) =
                defaultProperties(JsonField.ofNullable(defaultProperties))

            /**
             * Sets [Builder.defaultProperties] to an arbitrary JSON value.
             *
             * You should usually call [Builder.defaultProperties] with a well-typed
             * [DefaultProperties] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun defaultProperties(defaultProperties: JsonField<DefaultProperties>) = apply {
                this.defaultProperties = defaultProperties
            }

            /** A unique identifier for the event. This helps prevent duplicate events. */
            fun distinctId(distinctId: String?) = distinctId(JsonField.ofNullable(distinctId))

            /**
             * Sets [Builder.distinctId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.distinctId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun distinctId(distinctId: JsonField<String>) = apply { this.distinctId = distinctId }

            /**
             * The email address of a user. We will associate this event with the user or create a
             * user. Used for lookup if externalId and userId are not included in the request.
             */
            fun email(email: String?) = email(JsonField.ofNullable(email))

            /**
             * Sets [Builder.email] to an arbitrary JSON value.
             *
             * You should usually call [Builder.email] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun email(email: JsonField<String>) = apply { this.email = email }

            /** Any additional event properties you want to pass along. */
            fun eventProperties(eventProperties: EventProperties?) =
                eventProperties(JsonField.ofNullable(eventProperties))

            /**
             * Sets [Builder.eventProperties] to an arbitrary JSON value.
             *
             * You should usually call [Builder.eventProperties] with a well-typed [EventProperties]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun eventProperties(eventProperties: JsonField<EventProperties>) = apply {
                this.eventProperties = eventProperties
            }

            /**
             * The externalId (the ID in your system) of a user. We will associate this event with
             * the user or create a user. If included in the request, email lookup is ignored.
             */
            fun externalId(externalId: String?) = externalId(JsonField.ofNullable(externalId))

            /**
             * Sets [Builder.externalId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.externalId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun externalId(externalId: JsonField<String>) = apply { this.externalId = externalId }

            /**
             * The time at which the event occurred in milliseconds since UTC epoch. The time must
             * be in the past and within the last 7 days.
             */
            fun time(time: Double?) = time(JsonField.ofNullable(time))

            /**
             * Alias for [Builder.time].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun time(time: Double) = time(time as Double?)

            /**
             * Sets [Builder.time] to an arbitrary JSON value.
             *
             * You should usually call [Builder.time] with a well-typed [Double] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun time(time: JsonField<Double>) = apply { this.time = time }

            /**
             * The Ours user id stored in local storage and cookies on your web properties. If
             * userId is included in the request, we do not lookup the user by email or externalId.
             */
            fun userId(userId: String?) = userId(JsonField.ofNullable(userId))

            /**
             * Sets [Builder.userId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.userId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun userId(userId: JsonField<String>) = apply { this.userId = userId }

            /**
             * Properties to set on the visitor. (optional) You can also update these properties via
             * the identify endpoint.
             */
            fun userProperties(userProperties: UserProperties?) =
                userProperties(JsonField.ofNullable(userProperties))

            /**
             * Sets [Builder.userProperties] to an arbitrary JSON value.
             *
             * You should usually call [Builder.userProperties] with a well-typed [UserProperties]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun userProperties(userProperties: JsonField<UserProperties>) = apply {
                this.userProperties = userProperties
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
             * .event()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("token", token),
                    checkRequired("event", event),
                    defaultProperties,
                    distinctId,
                    email,
                    eventProperties,
                    externalId,
                    time,
                    userId,
                    userProperties,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            token()
            event()
            defaultProperties()?.validate()
            distinctId()
            email()
            eventProperties()?.validate()
            externalId()
            time()
            userId()
            userProperties()?.validate()
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
                (if (event.asKnown() == null) 0 else 1) +
                (defaultProperties.asKnown()?.validity() ?: 0) +
                (if (distinctId.asKnown() == null) 0 else 1) +
                (if (email.asKnown() == null) 0 else 1) +
                (eventProperties.asKnown()?.validity() ?: 0) +
                (if (externalId.asKnown() == null) 0 else 1) +
                (if (time.asKnown() == null) 0 else 1) +
                (if (userId.asKnown() == null) 0 else 1) +
                (userProperties.asKnown()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                token == other.token &&
                event == other.event &&
                defaultProperties == other.defaultProperties &&
                distinctId == other.distinctId &&
                email == other.email &&
                eventProperties == other.eventProperties &&
                externalId == other.externalId &&
                time == other.time &&
                userId == other.userId &&
                userProperties == other.userProperties &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                token,
                event,
                defaultProperties,
                distinctId,
                email,
                eventProperties,
                externalId,
                time,
                userId,
                userProperties,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{token=$token, event=$event, defaultProperties=$defaultProperties, distinctId=$distinctId, email=$email, eventProperties=$eventProperties, externalId=$externalId, time=$time, userId=$userId, userProperties=$userProperties, additionalProperties=$additionalProperties}"
    }

    /** These properties are used throughout the Ours app to pass known values onto destinations */
    class DefaultProperties
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val activeDuration: JsonField<Double>,
        private val adId: JsonField<String>,
        private val adsetId: JsonField<String>,
        private val browserLanguage: JsonField<String>,
        private val browserName: JsonField<String>,
        private val browserVersion: JsonField<String>,
        private val campaignId: JsonField<String>,
        private val clickid: JsonField<String>,
        private val clid: JsonField<String>,
        private val cpuArchitecture: JsonField<String>,
        private val currentUrl: JsonField<String>,
        private val dclid: JsonField<String>,
        private val deviceModel: JsonField<String>,
        private val deviceType: JsonField<String>,
        private val deviceVendor: JsonField<String>,
        private val duration: JsonField<Double>,
        private val encoding: JsonField<String>,
        private val engineName: JsonField<String>,
        private val engineVersion: JsonField<String>,
        private val epik: JsonField<String>,
        private val fbc: JsonField<String>,
        private val fbclid: JsonField<String>,
        private val fbp: JsonField<String>,
        private val fv: JsonField<Boolean>,
        private val gadSource: JsonField<String>,
        private val gbraid: JsonField<String>,
        private val gclid: JsonField<String>,
        private val host: JsonField<String>,
        private val iframe: JsonField<Boolean>,
        private val ip: JsonField<String>,
        private val irclickid: JsonField<String>,
        private val isBot: JsonValue,
        private val liFatId: JsonField<String>,
        private val msclkid: JsonField<String>,
        private val ndclid: JsonField<String>,
        private val newS: JsonField<Boolean>,
        private val osName: JsonField<String>,
        private val osVersion: JsonField<String>,
        private val pageHash: JsonField<Double>,
        private val pathname: JsonField<String>,
        private val qclid: JsonField<String>,
        private val rdtCid: JsonField<String>,
        private val receivedAt: JsonField<String>,
        private val referrer: JsonField<String>,
        private val sacid: JsonField<String>,
        private val sccid: JsonField<String>,
        private val screenHeight: JsonField<Double>,
        private val screenWidth: JsonField<Double>,
        private val sessionCount: JsonField<Double>,
        private val sid: JsonField<String>,
        private val sr: JsonField<String>,
        private val title: JsonField<String>,
        private val ttclid: JsonField<String>,
        private val twclid: JsonField<String>,
        private val uafvl: JsonField<String>,
        private val userAgent: JsonField<String>,
        private val utmCampaign: JsonField<String>,
        private val utmContent: JsonField<String>,
        private val utmMedium: JsonField<String>,
        private val utmName: JsonField<String>,
        private val utmSource: JsonField<String>,
        private val utmTerm: JsonField<String>,
        private val version: JsonField<String>,
        private val wbraid: JsonField<String>,
        private val webview: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("activeDuration")
            @ExcludeMissing
            activeDuration: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("ad_id") @ExcludeMissing adId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("adset_id") @ExcludeMissing adsetId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("browser_language")
            @ExcludeMissing
            browserLanguage: JsonField<String> = JsonMissing.of(),
            @JsonProperty("browser_name")
            @ExcludeMissing
            browserName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("browser_version")
            @ExcludeMissing
            browserVersion: JsonField<String> = JsonMissing.of(),
            @JsonProperty("campaign_id")
            @ExcludeMissing
            campaignId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("clickid") @ExcludeMissing clickid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("clid") @ExcludeMissing clid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("cpu_architecture")
            @ExcludeMissing
            cpuArchitecture: JsonField<String> = JsonMissing.of(),
            @JsonProperty("current_url")
            @ExcludeMissing
            currentUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("dclid") @ExcludeMissing dclid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("device_model")
            @ExcludeMissing
            deviceModel: JsonField<String> = JsonMissing.of(),
            @JsonProperty("device_type")
            @ExcludeMissing
            deviceType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("device_vendor")
            @ExcludeMissing
            deviceVendor: JsonField<String> = JsonMissing.of(),
            @JsonProperty("duration")
            @ExcludeMissing
            duration: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("encoding")
            @ExcludeMissing
            encoding: JsonField<String> = JsonMissing.of(),
            @JsonProperty("engine_name")
            @ExcludeMissing
            engineName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("engine_version")
            @ExcludeMissing
            engineVersion: JsonField<String> = JsonMissing.of(),
            @JsonProperty("epik") @ExcludeMissing epik: JsonField<String> = JsonMissing.of(),
            @JsonProperty("fbc") @ExcludeMissing fbc: JsonField<String> = JsonMissing.of(),
            @JsonProperty("fbclid") @ExcludeMissing fbclid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("fbp") @ExcludeMissing fbp: JsonField<String> = JsonMissing.of(),
            @JsonProperty("fv") @ExcludeMissing fv: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("gad_source")
            @ExcludeMissing
            gadSource: JsonField<String> = JsonMissing.of(),
            @JsonProperty("gbraid") @ExcludeMissing gbraid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("gclid") @ExcludeMissing gclid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("host") @ExcludeMissing host: JsonField<String> = JsonMissing.of(),
            @JsonProperty("iframe") @ExcludeMissing iframe: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("ip") @ExcludeMissing ip: JsonField<String> = JsonMissing.of(),
            @JsonProperty("irclickid")
            @ExcludeMissing
            irclickid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("is_bot") @ExcludeMissing isBot: JsonValue = JsonMissing.of(),
            @JsonProperty("li_fat_id")
            @ExcludeMissing
            liFatId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("msclkid") @ExcludeMissing msclkid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ndclid") @ExcludeMissing ndclid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("new_s") @ExcludeMissing newS: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("os_name") @ExcludeMissing osName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("os_version")
            @ExcludeMissing
            osVersion: JsonField<String> = JsonMissing.of(),
            @JsonProperty("page_hash")
            @ExcludeMissing
            pageHash: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("pathname")
            @ExcludeMissing
            pathname: JsonField<String> = JsonMissing.of(),
            @JsonProperty("qclid") @ExcludeMissing qclid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("rdt_cid") @ExcludeMissing rdtCid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("received_at")
            @ExcludeMissing
            receivedAt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("referrer")
            @ExcludeMissing
            referrer: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sacid") @ExcludeMissing sacid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sccid") @ExcludeMissing sccid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("screen_height")
            @ExcludeMissing
            screenHeight: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("screen_width")
            @ExcludeMissing
            screenWidth: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("sessionCount")
            @ExcludeMissing
            sessionCount: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("sid") @ExcludeMissing sid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sr") @ExcludeMissing sr: JsonField<String> = JsonMissing.of(),
            @JsonProperty("title") @ExcludeMissing title: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ttclid") @ExcludeMissing ttclid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("twclid") @ExcludeMissing twclid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("uafvl") @ExcludeMissing uafvl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("user_agent")
            @ExcludeMissing
            userAgent: JsonField<String> = JsonMissing.of(),
            @JsonProperty("utm_campaign")
            @ExcludeMissing
            utmCampaign: JsonField<String> = JsonMissing.of(),
            @JsonProperty("utm_content")
            @ExcludeMissing
            utmContent: JsonField<String> = JsonMissing.of(),
            @JsonProperty("utm_medium")
            @ExcludeMissing
            utmMedium: JsonField<String> = JsonMissing.of(),
            @JsonProperty("utm_name") @ExcludeMissing utmName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("utm_source")
            @ExcludeMissing
            utmSource: JsonField<String> = JsonMissing.of(),
            @JsonProperty("utm_term") @ExcludeMissing utmTerm: JsonField<String> = JsonMissing.of(),
            @JsonProperty("version") @ExcludeMissing version: JsonField<String> = JsonMissing.of(),
            @JsonProperty("wbraid") @ExcludeMissing wbraid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("webview") @ExcludeMissing webview: JsonField<Boolean> = JsonMissing.of(),
        ) : this(
            activeDuration,
            adId,
            adsetId,
            browserLanguage,
            browserName,
            browserVersion,
            campaignId,
            clickid,
            clid,
            cpuArchitecture,
            currentUrl,
            dclid,
            deviceModel,
            deviceType,
            deviceVendor,
            duration,
            encoding,
            engineName,
            engineVersion,
            epik,
            fbc,
            fbclid,
            fbp,
            fv,
            gadSource,
            gbraid,
            gclid,
            host,
            iframe,
            ip,
            irclickid,
            isBot,
            liFatId,
            msclkid,
            ndclid,
            newS,
            osName,
            osVersion,
            pageHash,
            pathname,
            qclid,
            rdtCid,
            receivedAt,
            referrer,
            sacid,
            sccid,
            screenHeight,
            screenWidth,
            sessionCount,
            sid,
            sr,
            title,
            ttclid,
            twclid,
            uafvl,
            userAgent,
            utmCampaign,
            utmContent,
            utmMedium,
            utmName,
            utmSource,
            utmTerm,
            version,
            wbraid,
            webview,
            mutableMapOf(),
        )

        /**
         * The active time in milliseconds that the user had this tab active
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun activeDuration(): Double? = activeDuration.getNullable("activeDuration")

        /**
         * The ad id for detected in the session. This is set by the web sdk automatically.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun adId(): String? = adId.getNullable("ad_id")

        /**
         * The adset id for detected in the session. This is set by the web sdk automatically.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun adsetId(): String? = adsetId.getNullable("adset_id")

        /**
         * The language of the browser. Ex: en-US
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun browserLanguage(): String? = browserLanguage.getNullable("browser_language")

        /**
         * The name of the browser. Ex: Chrome
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun browserName(): String? = browserName.getNullable("browser_name")

        /**
         * The version of the browser. Ex: 114.0
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun browserVersion(): String? = browserVersion.getNullable("browser_version")

        /**
         * The campaign id for detected in the session. This is set by the web sdk automatically.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun campaignId(): String? = campaignId.getNullable("campaign_id")

        /**
         * The Click ID. Ex: clickid123
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun clickid(): String? = clickid.getNullable("clickid")

        /**
         * The Generic Click ID. Ex: clid123
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun clid(): String? = clid.getNullable("clid")

        /**
         * The architecture of the CPU. Ex: x64
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun cpuArchitecture(): String? = cpuArchitecture.getNullable("cpu_architecture")

        /**
         * The full url (including query params) of the current page
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun currentUrl(): String? = currentUrl.getNullable("current_url")

        /**
         * The DoubleClick Click ID. Ex: dclid123
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun dclid(): String? = dclid.getNullable("dclid")

        /**
         * The model of the device. Ex: iPhone 13
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun deviceModel(): String? = deviceModel.getNullable("device_model")

        /**
         * The type of device the user is using. Ex: mobile
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun deviceType(): String? = deviceType.getNullable("device_type")

        /**
         * The vendor of the device. Ex: Apple
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun deviceVendor(): String? = deviceVendor.getNullable("device_vendor")

        /**
         * The time in milliseconds since the page was loaded // script was loaded
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun duration(): Double? = duration.getNullable("duration")

        /**
         * The browsers encoding. Ex: UTF-8
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun encoding(): String? = encoding.getNullable("encoding")

        /**
         * The name of the browser engine. Ex: Blink
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun engineName(): String? = engineName.getNullable("engine_name")

        /**
         * The version of the browser engine. Ex: 114.0
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun engineVersion(): String? = engineVersion.getNullable("engine_version")

        /**
         * The Pinterest Click ID. Ex: epik456
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun epik(): String? = epik.getNullable("epik")

        /**
         * Facebook Click ID with prefix format for Conversions API tracking. Ex:
         * fb.1.1554763741205.AbCdEfGhIjKlMnOpQrStUvWxYz1234567890
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun fbc(): String? = fbc.getNullable("fbc")

        /**
         * Raw Facebook Click ID query parameter without prefix from ad clicks. Ex:
         * AbCdEfGhIjKlMnOpQrStUvWxYz1234567890
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun fbclid(): String? = fbclid.getNullable("fbclid")

        /**
         * Facebook Browser ID parameter for identifying browsers and attributing events. Ex:
         * fb.1.1554763741205.1098115397
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun fbp(): String? = fbp.getNullable("fbp")

        /**
         * Deprecated
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun fv(): Boolean? = fv.getNullable("fv")

        /**
         * The Google Ad Source. Ex: google
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun gadSource(): String? = gadSource.getNullable("gad_source")

        /**
         * The Google Braid ID. Ex: gbraid123
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun gbraid(): String? = gbraid.getNullable("gbraid")

        /**
         * The Google Click ID. Ex: gclid123
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun gclid(): String? = gclid.getNullable("gclid")

        /**
         * The host of the current page. Ex: example.com
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun host(): String? = host.getNullable("host")

        /**
         * Whether the user is in an iframe. Ex: true
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun iframe(): Boolean? = iframe.getNullable("iframe")

        /**
         * The IP address of the user. Ex: 127.0.0.1
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun ip(): String? = ip.getNullable("ip")

        /**
         * The Impact Click ID. Ex: irclickid123
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun irclickid(): String? = irclickid.getNullable("irclickid")

        /**
         * Whether we have detected that the user is a bot. This is set automatically by the Ours
         * server primarily for events tracked through the web SDK.
         */
        @JsonProperty("is_bot") @ExcludeMissing fun _isBot(): JsonValue = isBot

        /**
         * The LinkedIn Click ID. Ex: li_fat_id123
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun liFatId(): String? = liFatId.getNullable("li_fat_id")

        /**
         * The Microsoft Click ID. Ex: msclkid123
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun msclkid(): String? = msclkid.getNullable("msclkid")

        /**
         * The NextDoor Click ID. Ex: ndclid123
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun ndclid(): String? = ndclid.getNullable("ndclid")

        /**
         * Deprecated
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun newS(): Boolean? = newS.getNullable("new_s")

        /**
         * The name of the operating system. Ex: Windows
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun osName(): String? = osName.getNullable("os_name")

        /**
         * The version of the operating system. Ex: 10.0
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun osVersion(): String? = osVersion.getNullable("os_version")

        /**
         * A random set of numbers for the page load
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun pageHash(): Double? = pageHash.getNullable("page_hash")

        /**
         * The pathname of the current page. Ex: /home
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun pathname(): String? = pathname.getNullable("pathname")

        /**
         * The Quora Click ID. Ex: qclid123
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun qclid(): String? = qclid.getNullable("qclid")

        /**
         * The Reddit Click ID. Ex: rdt_cid123
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun rdtCid(): String? = rdtCid.getNullable("rdt_cid")

        /**
         * The time the event was received by an Ours server in ISO format
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun receivedAt(): String? = receivedAt.getNullable("received_at")

        /**
         * The referrer URL of the current page
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun referrer(): String? = referrer.getNullable("referrer")

        /**
         * The StackAdapt Tracking ID. Ex: sacid123
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun sacid(): String? = sacid.getNullable("sacid")

        /**
         * The SnapChat Click ID. Ex: sccid123
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun sccid(): String? = sccid.getNullable("sccid")

        /**
         * The height of the screen. Ex: 1080
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun screenHeight(): Double? = screenHeight.getNullable("screen_height")

        /**
         * The width of the screen. Ex: 1920
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun screenWidth(): Double? = screenWidth.getNullable("screen_width")

        /**
         * The number of sessions the user has had. Ex: 3
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun sessionCount(): Double? = sessionCount.getNullable("sessionCount")

        /**
         * The session ID as assigned automatically by the web SDK. This is required for session
         * replay
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun sid(): String? = sid.getNullable("sid")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun sr(): String? = sr.getNullable("sr")

        /**
         * The title of the current page
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun title(): String? = title.getNullable("title")

        /**
         * The TikTok Click ID. Ex: ttclid123
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun ttclid(): String? = ttclid.getNullable("ttclid")

        /**
         * The Twitter Click ID. Ex: twclid123
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun twclid(): String? = twclid.getNullable("twclid")

        /**
         * User agent as a full list of strings.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun uafvl(): String? = uafvl.getNullable("uafvl")

        /**
         * The user agent of the browser
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun userAgent(): String? = userAgent.getNullable("user_agent")

        /**
         * The UTM Campaign. The web SDK automatically captures this from the query params.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun utmCampaign(): String? = utmCampaign.getNullable("utm_campaign")

        /**
         * The UTM Content. The web SDK automatically captures this from the query params.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun utmContent(): String? = utmContent.getNullable("utm_content")

        /**
         * The UTM Medium. The web SDK automatically captures this from the query params.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun utmMedium(): String? = utmMedium.getNullable("utm_medium")

        /**
         * The UTM Name. The web SDK automatically captures this from the query params.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun utmName(): String? = utmName.getNullable("utm_name")

        /**
         * The UTM Source. The web SDK automatically captures this from the query params.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun utmSource(): String? = utmSource.getNullable("utm_source")

        /**
         * The UTM Term. The web SDK automatically captures this from the query params.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun utmTerm(): String? = utmTerm.getNullable("utm_term")

        /**
         * The version of the web SDK
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun version(): String? = version.getNullable("version")

        /**
         * The WBRAID Identifier. The web SDK automatically captures this from the query params.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun wbraid(): String? = wbraid.getNullable("wbraid")

        /**
         * Whether the user is in a webview. Ex: true
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun webview(): Boolean? = webview.getNullable("webview")

        /**
         * Returns the raw JSON value of [activeDuration].
         *
         * Unlike [activeDuration], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("activeDuration")
        @ExcludeMissing
        fun _activeDuration(): JsonField<Double> = activeDuration

        /**
         * Returns the raw JSON value of [adId].
         *
         * Unlike [adId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ad_id") @ExcludeMissing fun _adId(): JsonField<String> = adId

        /**
         * Returns the raw JSON value of [adsetId].
         *
         * Unlike [adsetId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("adset_id") @ExcludeMissing fun _adsetId(): JsonField<String> = adsetId

        /**
         * Returns the raw JSON value of [browserLanguage].
         *
         * Unlike [browserLanguage], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("browser_language")
        @ExcludeMissing
        fun _browserLanguage(): JsonField<String> = browserLanguage

        /**
         * Returns the raw JSON value of [browserName].
         *
         * Unlike [browserName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("browser_name")
        @ExcludeMissing
        fun _browserName(): JsonField<String> = browserName

        /**
         * Returns the raw JSON value of [browserVersion].
         *
         * Unlike [browserVersion], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("browser_version")
        @ExcludeMissing
        fun _browserVersion(): JsonField<String> = browserVersion

        /**
         * Returns the raw JSON value of [campaignId].
         *
         * Unlike [campaignId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("campaign_id")
        @ExcludeMissing
        fun _campaignId(): JsonField<String> = campaignId

        /**
         * Returns the raw JSON value of [clickid].
         *
         * Unlike [clickid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("clickid") @ExcludeMissing fun _clickid(): JsonField<String> = clickid

        /**
         * Returns the raw JSON value of [clid].
         *
         * Unlike [clid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("clid") @ExcludeMissing fun _clid(): JsonField<String> = clid

        /**
         * Returns the raw JSON value of [cpuArchitecture].
         *
         * Unlike [cpuArchitecture], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("cpu_architecture")
        @ExcludeMissing
        fun _cpuArchitecture(): JsonField<String> = cpuArchitecture

        /**
         * Returns the raw JSON value of [currentUrl].
         *
         * Unlike [currentUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("current_url")
        @ExcludeMissing
        fun _currentUrl(): JsonField<String> = currentUrl

        /**
         * Returns the raw JSON value of [dclid].
         *
         * Unlike [dclid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("dclid") @ExcludeMissing fun _dclid(): JsonField<String> = dclid

        /**
         * Returns the raw JSON value of [deviceModel].
         *
         * Unlike [deviceModel], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("device_model")
        @ExcludeMissing
        fun _deviceModel(): JsonField<String> = deviceModel

        /**
         * Returns the raw JSON value of [deviceType].
         *
         * Unlike [deviceType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("device_type")
        @ExcludeMissing
        fun _deviceType(): JsonField<String> = deviceType

        /**
         * Returns the raw JSON value of [deviceVendor].
         *
         * Unlike [deviceVendor], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("device_vendor")
        @ExcludeMissing
        fun _deviceVendor(): JsonField<String> = deviceVendor

        /**
         * Returns the raw JSON value of [duration].
         *
         * Unlike [duration], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("duration") @ExcludeMissing fun _duration(): JsonField<Double> = duration

        /**
         * Returns the raw JSON value of [encoding].
         *
         * Unlike [encoding], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("encoding") @ExcludeMissing fun _encoding(): JsonField<String> = encoding

        /**
         * Returns the raw JSON value of [engineName].
         *
         * Unlike [engineName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("engine_name")
        @ExcludeMissing
        fun _engineName(): JsonField<String> = engineName

        /**
         * Returns the raw JSON value of [engineVersion].
         *
         * Unlike [engineVersion], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("engine_version")
        @ExcludeMissing
        fun _engineVersion(): JsonField<String> = engineVersion

        /**
         * Returns the raw JSON value of [epik].
         *
         * Unlike [epik], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("epik") @ExcludeMissing fun _epik(): JsonField<String> = epik

        /**
         * Returns the raw JSON value of [fbc].
         *
         * Unlike [fbc], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fbc") @ExcludeMissing fun _fbc(): JsonField<String> = fbc

        /**
         * Returns the raw JSON value of [fbclid].
         *
         * Unlike [fbclid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fbclid") @ExcludeMissing fun _fbclid(): JsonField<String> = fbclid

        /**
         * Returns the raw JSON value of [fbp].
         *
         * Unlike [fbp], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fbp") @ExcludeMissing fun _fbp(): JsonField<String> = fbp

        /**
         * Returns the raw JSON value of [fv].
         *
         * Unlike [fv], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fv") @ExcludeMissing fun _fv(): JsonField<Boolean> = fv

        /**
         * Returns the raw JSON value of [gadSource].
         *
         * Unlike [gadSource], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("gad_source") @ExcludeMissing fun _gadSource(): JsonField<String> = gadSource

        /**
         * Returns the raw JSON value of [gbraid].
         *
         * Unlike [gbraid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("gbraid") @ExcludeMissing fun _gbraid(): JsonField<String> = gbraid

        /**
         * Returns the raw JSON value of [gclid].
         *
         * Unlike [gclid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("gclid") @ExcludeMissing fun _gclid(): JsonField<String> = gclid

        /**
         * Returns the raw JSON value of [host].
         *
         * Unlike [host], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("host") @ExcludeMissing fun _host(): JsonField<String> = host

        /**
         * Returns the raw JSON value of [iframe].
         *
         * Unlike [iframe], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("iframe") @ExcludeMissing fun _iframe(): JsonField<Boolean> = iframe

        /**
         * Returns the raw JSON value of [ip].
         *
         * Unlike [ip], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ip") @ExcludeMissing fun _ip(): JsonField<String> = ip

        /**
         * Returns the raw JSON value of [irclickid].
         *
         * Unlike [irclickid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("irclickid") @ExcludeMissing fun _irclickid(): JsonField<String> = irclickid

        /**
         * Returns the raw JSON value of [liFatId].
         *
         * Unlike [liFatId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("li_fat_id") @ExcludeMissing fun _liFatId(): JsonField<String> = liFatId

        /**
         * Returns the raw JSON value of [msclkid].
         *
         * Unlike [msclkid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("msclkid") @ExcludeMissing fun _msclkid(): JsonField<String> = msclkid

        /**
         * Returns the raw JSON value of [ndclid].
         *
         * Unlike [ndclid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ndclid") @ExcludeMissing fun _ndclid(): JsonField<String> = ndclid

        /**
         * Returns the raw JSON value of [newS].
         *
         * Unlike [newS], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("new_s") @ExcludeMissing fun _newS(): JsonField<Boolean> = newS

        /**
         * Returns the raw JSON value of [osName].
         *
         * Unlike [osName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("os_name") @ExcludeMissing fun _osName(): JsonField<String> = osName

        /**
         * Returns the raw JSON value of [osVersion].
         *
         * Unlike [osVersion], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("os_version") @ExcludeMissing fun _osVersion(): JsonField<String> = osVersion

        /**
         * Returns the raw JSON value of [pageHash].
         *
         * Unlike [pageHash], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("page_hash") @ExcludeMissing fun _pageHash(): JsonField<Double> = pageHash

        /**
         * Returns the raw JSON value of [pathname].
         *
         * Unlike [pathname], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("pathname") @ExcludeMissing fun _pathname(): JsonField<String> = pathname

        /**
         * Returns the raw JSON value of [qclid].
         *
         * Unlike [qclid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("qclid") @ExcludeMissing fun _qclid(): JsonField<String> = qclid

        /**
         * Returns the raw JSON value of [rdtCid].
         *
         * Unlike [rdtCid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("rdt_cid") @ExcludeMissing fun _rdtCid(): JsonField<String> = rdtCid

        /**
         * Returns the raw JSON value of [receivedAt].
         *
         * Unlike [receivedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("received_at")
        @ExcludeMissing
        fun _receivedAt(): JsonField<String> = receivedAt

        /**
         * Returns the raw JSON value of [referrer].
         *
         * Unlike [referrer], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("referrer") @ExcludeMissing fun _referrer(): JsonField<String> = referrer

        /**
         * Returns the raw JSON value of [sacid].
         *
         * Unlike [sacid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sacid") @ExcludeMissing fun _sacid(): JsonField<String> = sacid

        /**
         * Returns the raw JSON value of [sccid].
         *
         * Unlike [sccid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sccid") @ExcludeMissing fun _sccid(): JsonField<String> = sccid

        /**
         * Returns the raw JSON value of [screenHeight].
         *
         * Unlike [screenHeight], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("screen_height")
        @ExcludeMissing
        fun _screenHeight(): JsonField<Double> = screenHeight

        /**
         * Returns the raw JSON value of [screenWidth].
         *
         * Unlike [screenWidth], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("screen_width")
        @ExcludeMissing
        fun _screenWidth(): JsonField<Double> = screenWidth

        /**
         * Returns the raw JSON value of [sessionCount].
         *
         * Unlike [sessionCount], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("sessionCount")
        @ExcludeMissing
        fun _sessionCount(): JsonField<Double> = sessionCount

        /**
         * Returns the raw JSON value of [sid].
         *
         * Unlike [sid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sid") @ExcludeMissing fun _sid(): JsonField<String> = sid

        /**
         * Returns the raw JSON value of [sr].
         *
         * Unlike [sr], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sr") @ExcludeMissing fun _sr(): JsonField<String> = sr

        /**
         * Returns the raw JSON value of [title].
         *
         * Unlike [title], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("title") @ExcludeMissing fun _title(): JsonField<String> = title

        /**
         * Returns the raw JSON value of [ttclid].
         *
         * Unlike [ttclid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ttclid") @ExcludeMissing fun _ttclid(): JsonField<String> = ttclid

        /**
         * Returns the raw JSON value of [twclid].
         *
         * Unlike [twclid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("twclid") @ExcludeMissing fun _twclid(): JsonField<String> = twclid

        /**
         * Returns the raw JSON value of [uafvl].
         *
         * Unlike [uafvl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("uafvl") @ExcludeMissing fun _uafvl(): JsonField<String> = uafvl

        /**
         * Returns the raw JSON value of [userAgent].
         *
         * Unlike [userAgent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("user_agent") @ExcludeMissing fun _userAgent(): JsonField<String> = userAgent

        /**
         * Returns the raw JSON value of [utmCampaign].
         *
         * Unlike [utmCampaign], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("utm_campaign")
        @ExcludeMissing
        fun _utmCampaign(): JsonField<String> = utmCampaign

        /**
         * Returns the raw JSON value of [utmContent].
         *
         * Unlike [utmContent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("utm_content")
        @ExcludeMissing
        fun _utmContent(): JsonField<String> = utmContent

        /**
         * Returns the raw JSON value of [utmMedium].
         *
         * Unlike [utmMedium], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("utm_medium") @ExcludeMissing fun _utmMedium(): JsonField<String> = utmMedium

        /**
         * Returns the raw JSON value of [utmName].
         *
         * Unlike [utmName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("utm_name") @ExcludeMissing fun _utmName(): JsonField<String> = utmName

        /**
         * Returns the raw JSON value of [utmSource].
         *
         * Unlike [utmSource], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("utm_source") @ExcludeMissing fun _utmSource(): JsonField<String> = utmSource

        /**
         * Returns the raw JSON value of [utmTerm].
         *
         * Unlike [utmTerm], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("utm_term") @ExcludeMissing fun _utmTerm(): JsonField<String> = utmTerm

        /**
         * Returns the raw JSON value of [version].
         *
         * Unlike [version], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("version") @ExcludeMissing fun _version(): JsonField<String> = version

        /**
         * Returns the raw JSON value of [wbraid].
         *
         * Unlike [wbraid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("wbraid") @ExcludeMissing fun _wbraid(): JsonField<String> = wbraid

        /**
         * Returns the raw JSON value of [webview].
         *
         * Unlike [webview], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("webview") @ExcludeMissing fun _webview(): JsonField<Boolean> = webview

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

            /** Returns a mutable builder for constructing an instance of [DefaultProperties]. */
            fun builder() = Builder()
        }

        /** A builder for [DefaultProperties]. */
        class Builder internal constructor() {

            private var activeDuration: JsonField<Double> = JsonMissing.of()
            private var adId: JsonField<String> = JsonMissing.of()
            private var adsetId: JsonField<String> = JsonMissing.of()
            private var browserLanguage: JsonField<String> = JsonMissing.of()
            private var browserName: JsonField<String> = JsonMissing.of()
            private var browserVersion: JsonField<String> = JsonMissing.of()
            private var campaignId: JsonField<String> = JsonMissing.of()
            private var clickid: JsonField<String> = JsonMissing.of()
            private var clid: JsonField<String> = JsonMissing.of()
            private var cpuArchitecture: JsonField<String> = JsonMissing.of()
            private var currentUrl: JsonField<String> = JsonMissing.of()
            private var dclid: JsonField<String> = JsonMissing.of()
            private var deviceModel: JsonField<String> = JsonMissing.of()
            private var deviceType: JsonField<String> = JsonMissing.of()
            private var deviceVendor: JsonField<String> = JsonMissing.of()
            private var duration: JsonField<Double> = JsonMissing.of()
            private var encoding: JsonField<String> = JsonMissing.of()
            private var engineName: JsonField<String> = JsonMissing.of()
            private var engineVersion: JsonField<String> = JsonMissing.of()
            private var epik: JsonField<String> = JsonMissing.of()
            private var fbc: JsonField<String> = JsonMissing.of()
            private var fbclid: JsonField<String> = JsonMissing.of()
            private var fbp: JsonField<String> = JsonMissing.of()
            private var fv: JsonField<Boolean> = JsonMissing.of()
            private var gadSource: JsonField<String> = JsonMissing.of()
            private var gbraid: JsonField<String> = JsonMissing.of()
            private var gclid: JsonField<String> = JsonMissing.of()
            private var host: JsonField<String> = JsonMissing.of()
            private var iframe: JsonField<Boolean> = JsonMissing.of()
            private var ip: JsonField<String> = JsonMissing.of()
            private var irclickid: JsonField<String> = JsonMissing.of()
            private var isBot: JsonValue = JsonMissing.of()
            private var liFatId: JsonField<String> = JsonMissing.of()
            private var msclkid: JsonField<String> = JsonMissing.of()
            private var ndclid: JsonField<String> = JsonMissing.of()
            private var newS: JsonField<Boolean> = JsonMissing.of()
            private var osName: JsonField<String> = JsonMissing.of()
            private var osVersion: JsonField<String> = JsonMissing.of()
            private var pageHash: JsonField<Double> = JsonMissing.of()
            private var pathname: JsonField<String> = JsonMissing.of()
            private var qclid: JsonField<String> = JsonMissing.of()
            private var rdtCid: JsonField<String> = JsonMissing.of()
            private var receivedAt: JsonField<String> = JsonMissing.of()
            private var referrer: JsonField<String> = JsonMissing.of()
            private var sacid: JsonField<String> = JsonMissing.of()
            private var sccid: JsonField<String> = JsonMissing.of()
            private var screenHeight: JsonField<Double> = JsonMissing.of()
            private var screenWidth: JsonField<Double> = JsonMissing.of()
            private var sessionCount: JsonField<Double> = JsonMissing.of()
            private var sid: JsonField<String> = JsonMissing.of()
            private var sr: JsonField<String> = JsonMissing.of()
            private var title: JsonField<String> = JsonMissing.of()
            private var ttclid: JsonField<String> = JsonMissing.of()
            private var twclid: JsonField<String> = JsonMissing.of()
            private var uafvl: JsonField<String> = JsonMissing.of()
            private var userAgent: JsonField<String> = JsonMissing.of()
            private var utmCampaign: JsonField<String> = JsonMissing.of()
            private var utmContent: JsonField<String> = JsonMissing.of()
            private var utmMedium: JsonField<String> = JsonMissing.of()
            private var utmName: JsonField<String> = JsonMissing.of()
            private var utmSource: JsonField<String> = JsonMissing.of()
            private var utmTerm: JsonField<String> = JsonMissing.of()
            private var version: JsonField<String> = JsonMissing.of()
            private var wbraid: JsonField<String> = JsonMissing.of()
            private var webview: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(defaultProperties: DefaultProperties) = apply {
                activeDuration = defaultProperties.activeDuration
                adId = defaultProperties.adId
                adsetId = defaultProperties.adsetId
                browserLanguage = defaultProperties.browserLanguage
                browserName = defaultProperties.browserName
                browserVersion = defaultProperties.browserVersion
                campaignId = defaultProperties.campaignId
                clickid = defaultProperties.clickid
                clid = defaultProperties.clid
                cpuArchitecture = defaultProperties.cpuArchitecture
                currentUrl = defaultProperties.currentUrl
                dclid = defaultProperties.dclid
                deviceModel = defaultProperties.deviceModel
                deviceType = defaultProperties.deviceType
                deviceVendor = defaultProperties.deviceVendor
                duration = defaultProperties.duration
                encoding = defaultProperties.encoding
                engineName = defaultProperties.engineName
                engineVersion = defaultProperties.engineVersion
                epik = defaultProperties.epik
                fbc = defaultProperties.fbc
                fbclid = defaultProperties.fbclid
                fbp = defaultProperties.fbp
                fv = defaultProperties.fv
                gadSource = defaultProperties.gadSource
                gbraid = defaultProperties.gbraid
                gclid = defaultProperties.gclid
                host = defaultProperties.host
                iframe = defaultProperties.iframe
                ip = defaultProperties.ip
                irclickid = defaultProperties.irclickid
                isBot = defaultProperties.isBot
                liFatId = defaultProperties.liFatId
                msclkid = defaultProperties.msclkid
                ndclid = defaultProperties.ndclid
                newS = defaultProperties.newS
                osName = defaultProperties.osName
                osVersion = defaultProperties.osVersion
                pageHash = defaultProperties.pageHash
                pathname = defaultProperties.pathname
                qclid = defaultProperties.qclid
                rdtCid = defaultProperties.rdtCid
                receivedAt = defaultProperties.receivedAt
                referrer = defaultProperties.referrer
                sacid = defaultProperties.sacid
                sccid = defaultProperties.sccid
                screenHeight = defaultProperties.screenHeight
                screenWidth = defaultProperties.screenWidth
                sessionCount = defaultProperties.sessionCount
                sid = defaultProperties.sid
                sr = defaultProperties.sr
                title = defaultProperties.title
                ttclid = defaultProperties.ttclid
                twclid = defaultProperties.twclid
                uafvl = defaultProperties.uafvl
                userAgent = defaultProperties.userAgent
                utmCampaign = defaultProperties.utmCampaign
                utmContent = defaultProperties.utmContent
                utmMedium = defaultProperties.utmMedium
                utmName = defaultProperties.utmName
                utmSource = defaultProperties.utmSource
                utmTerm = defaultProperties.utmTerm
                version = defaultProperties.version
                wbraid = defaultProperties.wbraid
                webview = defaultProperties.webview
                additionalProperties = defaultProperties.additionalProperties.toMutableMap()
            }

            /** The active time in milliseconds that the user had this tab active */
            fun activeDuration(activeDuration: Double?) =
                activeDuration(JsonField.ofNullable(activeDuration))

            /**
             * Alias for [Builder.activeDuration].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun activeDuration(activeDuration: Double) = activeDuration(activeDuration as Double?)

            /**
             * Sets [Builder.activeDuration] to an arbitrary JSON value.
             *
             * You should usually call [Builder.activeDuration] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun activeDuration(activeDuration: JsonField<Double>) = apply {
                this.activeDuration = activeDuration
            }

            /** The ad id for detected in the session. This is set by the web sdk automatically. */
            fun adId(adId: String?) = adId(JsonField.ofNullable(adId))

            /**
             * Sets [Builder.adId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.adId] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun adId(adId: JsonField<String>) = apply { this.adId = adId }

            /**
             * The adset id for detected in the session. This is set by the web sdk automatically.
             */
            fun adsetId(adsetId: String?) = adsetId(JsonField.ofNullable(adsetId))

            /**
             * Sets [Builder.adsetId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.adsetId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun adsetId(adsetId: JsonField<String>) = apply { this.adsetId = adsetId }

            /** The language of the browser. Ex: en-US */
            fun browserLanguage(browserLanguage: String?) =
                browserLanguage(JsonField.ofNullable(browserLanguage))

            /**
             * Sets [Builder.browserLanguage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.browserLanguage] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun browserLanguage(browserLanguage: JsonField<String>) = apply {
                this.browserLanguage = browserLanguage
            }

            /** The name of the browser. Ex: Chrome */
            fun browserName(browserName: String?) = browserName(JsonField.ofNullable(browserName))

            /**
             * Sets [Builder.browserName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.browserName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun browserName(browserName: JsonField<String>) = apply {
                this.browserName = browserName
            }

            /** The version of the browser. Ex: 114.0 */
            fun browserVersion(browserVersion: String?) =
                browserVersion(JsonField.ofNullable(browserVersion))

            /**
             * Sets [Builder.browserVersion] to an arbitrary JSON value.
             *
             * You should usually call [Builder.browserVersion] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun browserVersion(browserVersion: JsonField<String>) = apply {
                this.browserVersion = browserVersion
            }

            /**
             * The campaign id for detected in the session. This is set by the web sdk
             * automatically.
             */
            fun campaignId(campaignId: String?) = campaignId(JsonField.ofNullable(campaignId))

            /**
             * Sets [Builder.campaignId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.campaignId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun campaignId(campaignId: JsonField<String>) = apply { this.campaignId = campaignId }

            /** The Click ID. Ex: clickid123 */
            fun clickid(clickid: String?) = clickid(JsonField.ofNullable(clickid))

            /**
             * Sets [Builder.clickid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.clickid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun clickid(clickid: JsonField<String>) = apply { this.clickid = clickid }

            /** The Generic Click ID. Ex: clid123 */
            fun clid(clid: String?) = clid(JsonField.ofNullable(clid))

            /**
             * Sets [Builder.clid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.clid] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun clid(clid: JsonField<String>) = apply { this.clid = clid }

            /** The architecture of the CPU. Ex: x64 */
            fun cpuArchitecture(cpuArchitecture: String?) =
                cpuArchitecture(JsonField.ofNullable(cpuArchitecture))

            /**
             * Sets [Builder.cpuArchitecture] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cpuArchitecture] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun cpuArchitecture(cpuArchitecture: JsonField<String>) = apply {
                this.cpuArchitecture = cpuArchitecture
            }

            /** The full url (including query params) of the current page */
            fun currentUrl(currentUrl: String?) = currentUrl(JsonField.ofNullable(currentUrl))

            /**
             * Sets [Builder.currentUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.currentUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun currentUrl(currentUrl: JsonField<String>) = apply { this.currentUrl = currentUrl }

            /** The DoubleClick Click ID. Ex: dclid123 */
            fun dclid(dclid: String?) = dclid(JsonField.ofNullable(dclid))

            /**
             * Sets [Builder.dclid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.dclid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun dclid(dclid: JsonField<String>) = apply { this.dclid = dclid }

            /** The model of the device. Ex: iPhone 13 */
            fun deviceModel(deviceModel: String?) = deviceModel(JsonField.ofNullable(deviceModel))

            /**
             * Sets [Builder.deviceModel] to an arbitrary JSON value.
             *
             * You should usually call [Builder.deviceModel] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun deviceModel(deviceModel: JsonField<String>) = apply {
                this.deviceModel = deviceModel
            }

            /** The type of device the user is using. Ex: mobile */
            fun deviceType(deviceType: String?) = deviceType(JsonField.ofNullable(deviceType))

            /**
             * Sets [Builder.deviceType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.deviceType] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun deviceType(deviceType: JsonField<String>) = apply { this.deviceType = deviceType }

            /** The vendor of the device. Ex: Apple */
            fun deviceVendor(deviceVendor: String?) =
                deviceVendor(JsonField.ofNullable(deviceVendor))

            /**
             * Sets [Builder.deviceVendor] to an arbitrary JSON value.
             *
             * You should usually call [Builder.deviceVendor] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun deviceVendor(deviceVendor: JsonField<String>) = apply {
                this.deviceVendor = deviceVendor
            }

            /** The time in milliseconds since the page was loaded // script was loaded */
            fun duration(duration: Double?) = duration(JsonField.ofNullable(duration))

            /**
             * Alias for [Builder.duration].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun duration(duration: Double) = duration(duration as Double?)

            /**
             * Sets [Builder.duration] to an arbitrary JSON value.
             *
             * You should usually call [Builder.duration] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun duration(duration: JsonField<Double>) = apply { this.duration = duration }

            /** The browsers encoding. Ex: UTF-8 */
            fun encoding(encoding: String?) = encoding(JsonField.ofNullable(encoding))

            /**
             * Sets [Builder.encoding] to an arbitrary JSON value.
             *
             * You should usually call [Builder.encoding] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun encoding(encoding: JsonField<String>) = apply { this.encoding = encoding }

            /** The name of the browser engine. Ex: Blink */
            fun engineName(engineName: String?) = engineName(JsonField.ofNullable(engineName))

            /**
             * Sets [Builder.engineName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.engineName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun engineName(engineName: JsonField<String>) = apply { this.engineName = engineName }

            /** The version of the browser engine. Ex: 114.0 */
            fun engineVersion(engineVersion: String?) =
                engineVersion(JsonField.ofNullable(engineVersion))

            /**
             * Sets [Builder.engineVersion] to an arbitrary JSON value.
             *
             * You should usually call [Builder.engineVersion] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun engineVersion(engineVersion: JsonField<String>) = apply {
                this.engineVersion = engineVersion
            }

            /** The Pinterest Click ID. Ex: epik456 */
            fun epik(epik: String?) = epik(JsonField.ofNullable(epik))

            /**
             * Sets [Builder.epik] to an arbitrary JSON value.
             *
             * You should usually call [Builder.epik] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun epik(epik: JsonField<String>) = apply { this.epik = epik }

            /**
             * Facebook Click ID with prefix format for Conversions API tracking. Ex:
             * fb.1.1554763741205.AbCdEfGhIjKlMnOpQrStUvWxYz1234567890
             */
            fun fbc(fbc: String?) = fbc(JsonField.ofNullable(fbc))

            /**
             * Sets [Builder.fbc] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fbc] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun fbc(fbc: JsonField<String>) = apply { this.fbc = fbc }

            /**
             * Raw Facebook Click ID query parameter without prefix from ad clicks. Ex:
             * AbCdEfGhIjKlMnOpQrStUvWxYz1234567890
             */
            fun fbclid(fbclid: String?) = fbclid(JsonField.ofNullable(fbclid))

            /**
             * Sets [Builder.fbclid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fbclid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fbclid(fbclid: JsonField<String>) = apply { this.fbclid = fbclid }

            /**
             * Facebook Browser ID parameter for identifying browsers and attributing events. Ex:
             * fb.1.1554763741205.1098115397
             */
            fun fbp(fbp: String?) = fbp(JsonField.ofNullable(fbp))

            /**
             * Sets [Builder.fbp] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fbp] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun fbp(fbp: JsonField<String>) = apply { this.fbp = fbp }

            /** Deprecated */
            fun fv(fv: Boolean?) = fv(JsonField.ofNullable(fv))

            /**
             * Alias for [Builder.fv].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun fv(fv: Boolean) = fv(fv as Boolean?)

            /**
             * Sets [Builder.fv] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fv] with a well-typed [Boolean] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun fv(fv: JsonField<Boolean>) = apply { this.fv = fv }

            /** The Google Ad Source. Ex: google */
            fun gadSource(gadSource: String?) = gadSource(JsonField.ofNullable(gadSource))

            /**
             * Sets [Builder.gadSource] to an arbitrary JSON value.
             *
             * You should usually call [Builder.gadSource] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun gadSource(gadSource: JsonField<String>) = apply { this.gadSource = gadSource }

            /** The Google Braid ID. Ex: gbraid123 */
            fun gbraid(gbraid: String?) = gbraid(JsonField.ofNullable(gbraid))

            /**
             * Sets [Builder.gbraid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.gbraid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun gbraid(gbraid: JsonField<String>) = apply { this.gbraid = gbraid }

            /** The Google Click ID. Ex: gclid123 */
            fun gclid(gclid: String?) = gclid(JsonField.ofNullable(gclid))

            /**
             * Sets [Builder.gclid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.gclid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun gclid(gclid: JsonField<String>) = apply { this.gclid = gclid }

            /** The host of the current page. Ex: example.com */
            fun host(host: String?) = host(JsonField.ofNullable(host))

            /**
             * Sets [Builder.host] to an arbitrary JSON value.
             *
             * You should usually call [Builder.host] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun host(host: JsonField<String>) = apply { this.host = host }

            /** Whether the user is in an iframe. Ex: true */
            fun iframe(iframe: Boolean?) = iframe(JsonField.ofNullable(iframe))

            /**
             * Alias for [Builder.iframe].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun iframe(iframe: Boolean) = iframe(iframe as Boolean?)

            /**
             * Sets [Builder.iframe] to an arbitrary JSON value.
             *
             * You should usually call [Builder.iframe] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun iframe(iframe: JsonField<Boolean>) = apply { this.iframe = iframe }

            /** The IP address of the user. Ex: 127.0.0.1 */
            fun ip(ip: String?) = ip(JsonField.ofNullable(ip))

            /**
             * Sets [Builder.ip] to an arbitrary JSON value.
             *
             * You should usually call [Builder.ip] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun ip(ip: JsonField<String>) = apply { this.ip = ip }

            /** The Impact Click ID. Ex: irclickid123 */
            fun irclickid(irclickid: String?) = irclickid(JsonField.ofNullable(irclickid))

            /**
             * Sets [Builder.irclickid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.irclickid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun irclickid(irclickid: JsonField<String>) = apply { this.irclickid = irclickid }

            /**
             * Whether we have detected that the user is a bot. This is set automatically by the
             * Ours server primarily for events tracked through the web SDK.
             */
            fun isBot(isBot: JsonValue) = apply { this.isBot = isBot }

            /** The LinkedIn Click ID. Ex: li_fat_id123 */
            fun liFatId(liFatId: String?) = liFatId(JsonField.ofNullable(liFatId))

            /**
             * Sets [Builder.liFatId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.liFatId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun liFatId(liFatId: JsonField<String>) = apply { this.liFatId = liFatId }

            /** The Microsoft Click ID. Ex: msclkid123 */
            fun msclkid(msclkid: String?) = msclkid(JsonField.ofNullable(msclkid))

            /**
             * Sets [Builder.msclkid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.msclkid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun msclkid(msclkid: JsonField<String>) = apply { this.msclkid = msclkid }

            /** The NextDoor Click ID. Ex: ndclid123 */
            fun ndclid(ndclid: String?) = ndclid(JsonField.ofNullable(ndclid))

            /**
             * Sets [Builder.ndclid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.ndclid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun ndclid(ndclid: JsonField<String>) = apply { this.ndclid = ndclid }

            /** Deprecated */
            fun newS(newS: Boolean?) = newS(JsonField.ofNullable(newS))

            /**
             * Alias for [Builder.newS].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun newS(newS: Boolean) = newS(newS as Boolean?)

            /**
             * Sets [Builder.newS] to an arbitrary JSON value.
             *
             * You should usually call [Builder.newS] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun newS(newS: JsonField<Boolean>) = apply { this.newS = newS }

            /** The name of the operating system. Ex: Windows */
            fun osName(osName: String?) = osName(JsonField.ofNullable(osName))

            /**
             * Sets [Builder.osName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.osName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun osName(osName: JsonField<String>) = apply { this.osName = osName }

            /** The version of the operating system. Ex: 10.0 */
            fun osVersion(osVersion: String?) = osVersion(JsonField.ofNullable(osVersion))

            /**
             * Sets [Builder.osVersion] to an arbitrary JSON value.
             *
             * You should usually call [Builder.osVersion] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun osVersion(osVersion: JsonField<String>) = apply { this.osVersion = osVersion }

            /** A random set of numbers for the page load */
            fun pageHash(pageHash: Double?) = pageHash(JsonField.ofNullable(pageHash))

            /**
             * Alias for [Builder.pageHash].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun pageHash(pageHash: Double) = pageHash(pageHash as Double?)

            /**
             * Sets [Builder.pageHash] to an arbitrary JSON value.
             *
             * You should usually call [Builder.pageHash] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun pageHash(pageHash: JsonField<Double>) = apply { this.pageHash = pageHash }

            /** The pathname of the current page. Ex: /home */
            fun pathname(pathname: String?) = pathname(JsonField.ofNullable(pathname))

            /**
             * Sets [Builder.pathname] to an arbitrary JSON value.
             *
             * You should usually call [Builder.pathname] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun pathname(pathname: JsonField<String>) = apply { this.pathname = pathname }

            /** The Quora Click ID. Ex: qclid123 */
            fun qclid(qclid: String?) = qclid(JsonField.ofNullable(qclid))

            /**
             * Sets [Builder.qclid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.qclid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun qclid(qclid: JsonField<String>) = apply { this.qclid = qclid }

            /** The Reddit Click ID. Ex: rdt_cid123 */
            fun rdtCid(rdtCid: String?) = rdtCid(JsonField.ofNullable(rdtCid))

            /**
             * Sets [Builder.rdtCid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.rdtCid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun rdtCid(rdtCid: JsonField<String>) = apply { this.rdtCid = rdtCid }

            /** The time the event was received by an Ours server in ISO format */
            fun receivedAt(receivedAt: String?) = receivedAt(JsonField.ofNullable(receivedAt))

            /**
             * Sets [Builder.receivedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.receivedAt] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun receivedAt(receivedAt: JsonField<String>) = apply { this.receivedAt = receivedAt }

            /** The referrer URL of the current page */
            fun referrer(referrer: String?) = referrer(JsonField.ofNullable(referrer))

            /**
             * Sets [Builder.referrer] to an arbitrary JSON value.
             *
             * You should usually call [Builder.referrer] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun referrer(referrer: JsonField<String>) = apply { this.referrer = referrer }

            /** The StackAdapt Tracking ID. Ex: sacid123 */
            fun sacid(sacid: String?) = sacid(JsonField.ofNullable(sacid))

            /**
             * Sets [Builder.sacid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sacid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sacid(sacid: JsonField<String>) = apply { this.sacid = sacid }

            /** The SnapChat Click ID. Ex: sccid123 */
            fun sccid(sccid: String?) = sccid(JsonField.ofNullable(sccid))

            /**
             * Sets [Builder.sccid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sccid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sccid(sccid: JsonField<String>) = apply { this.sccid = sccid }

            /** The height of the screen. Ex: 1080 */
            fun screenHeight(screenHeight: Double?) =
                screenHeight(JsonField.ofNullable(screenHeight))

            /**
             * Alias for [Builder.screenHeight].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun screenHeight(screenHeight: Double) = screenHeight(screenHeight as Double?)

            /**
             * Sets [Builder.screenHeight] to an arbitrary JSON value.
             *
             * You should usually call [Builder.screenHeight] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun screenHeight(screenHeight: JsonField<Double>) = apply {
                this.screenHeight = screenHeight
            }

            /** The width of the screen. Ex: 1920 */
            fun screenWidth(screenWidth: Double?) = screenWidth(JsonField.ofNullable(screenWidth))

            /**
             * Alias for [Builder.screenWidth].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun screenWidth(screenWidth: Double) = screenWidth(screenWidth as Double?)

            /**
             * Sets [Builder.screenWidth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.screenWidth] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun screenWidth(screenWidth: JsonField<Double>) = apply {
                this.screenWidth = screenWidth
            }

            /** The number of sessions the user has had. Ex: 3 */
            fun sessionCount(sessionCount: Double?) =
                sessionCount(JsonField.ofNullable(sessionCount))

            /**
             * Alias for [Builder.sessionCount].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun sessionCount(sessionCount: Double) = sessionCount(sessionCount as Double?)

            /**
             * Sets [Builder.sessionCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sessionCount] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sessionCount(sessionCount: JsonField<Double>) = apply {
                this.sessionCount = sessionCount
            }

            /**
             * The session ID as assigned automatically by the web SDK. This is required for session
             * replay
             */
            fun sid(sid: String?) = sid(JsonField.ofNullable(sid))

            /**
             * Sets [Builder.sid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sid] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun sid(sid: JsonField<String>) = apply { this.sid = sid }

            fun sr(sr: String?) = sr(JsonField.ofNullable(sr))

            /**
             * Sets [Builder.sr] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sr] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun sr(sr: JsonField<String>) = apply { this.sr = sr }

            /** The title of the current page */
            fun title(title: String?) = title(JsonField.ofNullable(title))

            /**
             * Sets [Builder.title] to an arbitrary JSON value.
             *
             * You should usually call [Builder.title] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun title(title: JsonField<String>) = apply { this.title = title }

            /** The TikTok Click ID. Ex: ttclid123 */
            fun ttclid(ttclid: String?) = ttclid(JsonField.ofNullable(ttclid))

            /**
             * Sets [Builder.ttclid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.ttclid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun ttclid(ttclid: JsonField<String>) = apply { this.ttclid = ttclid }

            /** The Twitter Click ID. Ex: twclid123 */
            fun twclid(twclid: String?) = twclid(JsonField.ofNullable(twclid))

            /**
             * Sets [Builder.twclid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.twclid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun twclid(twclid: JsonField<String>) = apply { this.twclid = twclid }

            /** User agent as a full list of strings. */
            fun uafvl(uafvl: String?) = uafvl(JsonField.ofNullable(uafvl))

            /**
             * Sets [Builder.uafvl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.uafvl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun uafvl(uafvl: JsonField<String>) = apply { this.uafvl = uafvl }

            /** The user agent of the browser */
            fun userAgent(userAgent: String?) = userAgent(JsonField.ofNullable(userAgent))

            /**
             * Sets [Builder.userAgent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.userAgent] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun userAgent(userAgent: JsonField<String>) = apply { this.userAgent = userAgent }

            /** The UTM Campaign. The web SDK automatically captures this from the query params. */
            fun utmCampaign(utmCampaign: String?) = utmCampaign(JsonField.ofNullable(utmCampaign))

            /**
             * Sets [Builder.utmCampaign] to an arbitrary JSON value.
             *
             * You should usually call [Builder.utmCampaign] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun utmCampaign(utmCampaign: JsonField<String>) = apply {
                this.utmCampaign = utmCampaign
            }

            /** The UTM Content. The web SDK automatically captures this from the query params. */
            fun utmContent(utmContent: String?) = utmContent(JsonField.ofNullable(utmContent))

            /**
             * Sets [Builder.utmContent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.utmContent] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun utmContent(utmContent: JsonField<String>) = apply { this.utmContent = utmContent }

            /** The UTM Medium. The web SDK automatically captures this from the query params. */
            fun utmMedium(utmMedium: String?) = utmMedium(JsonField.ofNullable(utmMedium))

            /**
             * Sets [Builder.utmMedium] to an arbitrary JSON value.
             *
             * You should usually call [Builder.utmMedium] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun utmMedium(utmMedium: JsonField<String>) = apply { this.utmMedium = utmMedium }

            /** The UTM Name. The web SDK automatically captures this from the query params. */
            fun utmName(utmName: String?) = utmName(JsonField.ofNullable(utmName))

            /**
             * Sets [Builder.utmName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.utmName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun utmName(utmName: JsonField<String>) = apply { this.utmName = utmName }

            /** The UTM Source. The web SDK automatically captures this from the query params. */
            fun utmSource(utmSource: String?) = utmSource(JsonField.ofNullable(utmSource))

            /**
             * Sets [Builder.utmSource] to an arbitrary JSON value.
             *
             * You should usually call [Builder.utmSource] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun utmSource(utmSource: JsonField<String>) = apply { this.utmSource = utmSource }

            /** The UTM Term. The web SDK automatically captures this from the query params. */
            fun utmTerm(utmTerm: String?) = utmTerm(JsonField.ofNullable(utmTerm))

            /**
             * Sets [Builder.utmTerm] to an arbitrary JSON value.
             *
             * You should usually call [Builder.utmTerm] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun utmTerm(utmTerm: JsonField<String>) = apply { this.utmTerm = utmTerm }

            /** The version of the web SDK */
            fun version(version: String?) = version(JsonField.ofNullable(version))

            /**
             * Sets [Builder.version] to an arbitrary JSON value.
             *
             * You should usually call [Builder.version] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun version(version: JsonField<String>) = apply { this.version = version }

            /**
             * The WBRAID Identifier. The web SDK automatically captures this from the query params.
             */
            fun wbraid(wbraid: String?) = wbraid(JsonField.ofNullable(wbraid))

            /**
             * Sets [Builder.wbraid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.wbraid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun wbraid(wbraid: JsonField<String>) = apply { this.wbraid = wbraid }

            /** Whether the user is in a webview. Ex: true */
            fun webview(webview: Boolean?) = webview(JsonField.ofNullable(webview))

            /**
             * Alias for [Builder.webview].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun webview(webview: Boolean) = webview(webview as Boolean?)

            /**
             * Sets [Builder.webview] to an arbitrary JSON value.
             *
             * You should usually call [Builder.webview] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun webview(webview: JsonField<Boolean>) = apply { this.webview = webview }

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
             * Returns an immutable instance of [DefaultProperties].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): DefaultProperties =
                DefaultProperties(
                    activeDuration,
                    adId,
                    adsetId,
                    browserLanguage,
                    browserName,
                    browserVersion,
                    campaignId,
                    clickid,
                    clid,
                    cpuArchitecture,
                    currentUrl,
                    dclid,
                    deviceModel,
                    deviceType,
                    deviceVendor,
                    duration,
                    encoding,
                    engineName,
                    engineVersion,
                    epik,
                    fbc,
                    fbclid,
                    fbp,
                    fv,
                    gadSource,
                    gbraid,
                    gclid,
                    host,
                    iframe,
                    ip,
                    irclickid,
                    isBot,
                    liFatId,
                    msclkid,
                    ndclid,
                    newS,
                    osName,
                    osVersion,
                    pageHash,
                    pathname,
                    qclid,
                    rdtCid,
                    receivedAt,
                    referrer,
                    sacid,
                    sccid,
                    screenHeight,
                    screenWidth,
                    sessionCount,
                    sid,
                    sr,
                    title,
                    ttclid,
                    twclid,
                    uafvl,
                    userAgent,
                    utmCampaign,
                    utmContent,
                    utmMedium,
                    utmName,
                    utmSource,
                    utmTerm,
                    version,
                    wbraid,
                    webview,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): DefaultProperties = apply {
            if (validated) {
                return@apply
            }

            activeDuration()
            adId()
            adsetId()
            browserLanguage()
            browserName()
            browserVersion()
            campaignId()
            clickid()
            clid()
            cpuArchitecture()
            currentUrl()
            dclid()
            deviceModel()
            deviceType()
            deviceVendor()
            duration()
            encoding()
            engineName()
            engineVersion()
            epik()
            fbc()
            fbclid()
            fbp()
            fv()
            gadSource()
            gbraid()
            gclid()
            host()
            iframe()
            ip()
            irclickid()
            liFatId()
            msclkid()
            ndclid()
            newS()
            osName()
            osVersion()
            pageHash()
            pathname()
            qclid()
            rdtCid()
            receivedAt()
            referrer()
            sacid()
            sccid()
            screenHeight()
            screenWidth()
            sessionCount()
            sid()
            sr()
            title()
            ttclid()
            twclid()
            uafvl()
            userAgent()
            utmCampaign()
            utmContent()
            utmMedium()
            utmName()
            utmSource()
            utmTerm()
            version()
            wbraid()
            webview()
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
            (if (activeDuration.asKnown() == null) 0 else 1) +
                (if (adId.asKnown() == null) 0 else 1) +
                (if (adsetId.asKnown() == null) 0 else 1) +
                (if (browserLanguage.asKnown() == null) 0 else 1) +
                (if (browserName.asKnown() == null) 0 else 1) +
                (if (browserVersion.asKnown() == null) 0 else 1) +
                (if (campaignId.asKnown() == null) 0 else 1) +
                (if (clickid.asKnown() == null) 0 else 1) +
                (if (clid.asKnown() == null) 0 else 1) +
                (if (cpuArchitecture.asKnown() == null) 0 else 1) +
                (if (currentUrl.asKnown() == null) 0 else 1) +
                (if (dclid.asKnown() == null) 0 else 1) +
                (if (deviceModel.asKnown() == null) 0 else 1) +
                (if (deviceType.asKnown() == null) 0 else 1) +
                (if (deviceVendor.asKnown() == null) 0 else 1) +
                (if (duration.asKnown() == null) 0 else 1) +
                (if (encoding.asKnown() == null) 0 else 1) +
                (if (engineName.asKnown() == null) 0 else 1) +
                (if (engineVersion.asKnown() == null) 0 else 1) +
                (if (epik.asKnown() == null) 0 else 1) +
                (if (fbc.asKnown() == null) 0 else 1) +
                (if (fbclid.asKnown() == null) 0 else 1) +
                (if (fbp.asKnown() == null) 0 else 1) +
                (if (fv.asKnown() == null) 0 else 1) +
                (if (gadSource.asKnown() == null) 0 else 1) +
                (if (gbraid.asKnown() == null) 0 else 1) +
                (if (gclid.asKnown() == null) 0 else 1) +
                (if (host.asKnown() == null) 0 else 1) +
                (if (iframe.asKnown() == null) 0 else 1) +
                (if (ip.asKnown() == null) 0 else 1) +
                (if (irclickid.asKnown() == null) 0 else 1) +
                (if (liFatId.asKnown() == null) 0 else 1) +
                (if (msclkid.asKnown() == null) 0 else 1) +
                (if (ndclid.asKnown() == null) 0 else 1) +
                (if (newS.asKnown() == null) 0 else 1) +
                (if (osName.asKnown() == null) 0 else 1) +
                (if (osVersion.asKnown() == null) 0 else 1) +
                (if (pageHash.asKnown() == null) 0 else 1) +
                (if (pathname.asKnown() == null) 0 else 1) +
                (if (qclid.asKnown() == null) 0 else 1) +
                (if (rdtCid.asKnown() == null) 0 else 1) +
                (if (receivedAt.asKnown() == null) 0 else 1) +
                (if (referrer.asKnown() == null) 0 else 1) +
                (if (sacid.asKnown() == null) 0 else 1) +
                (if (sccid.asKnown() == null) 0 else 1) +
                (if (screenHeight.asKnown() == null) 0 else 1) +
                (if (screenWidth.asKnown() == null) 0 else 1) +
                (if (sessionCount.asKnown() == null) 0 else 1) +
                (if (sid.asKnown() == null) 0 else 1) +
                (if (sr.asKnown() == null) 0 else 1) +
                (if (title.asKnown() == null) 0 else 1) +
                (if (ttclid.asKnown() == null) 0 else 1) +
                (if (twclid.asKnown() == null) 0 else 1) +
                (if (uafvl.asKnown() == null) 0 else 1) +
                (if (userAgent.asKnown() == null) 0 else 1) +
                (if (utmCampaign.asKnown() == null) 0 else 1) +
                (if (utmContent.asKnown() == null) 0 else 1) +
                (if (utmMedium.asKnown() == null) 0 else 1) +
                (if (utmName.asKnown() == null) 0 else 1) +
                (if (utmSource.asKnown() == null) 0 else 1) +
                (if (utmTerm.asKnown() == null) 0 else 1) +
                (if (version.asKnown() == null) 0 else 1) +
                (if (wbraid.asKnown() == null) 0 else 1) +
                (if (webview.asKnown() == null) 0 else 1)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is DefaultProperties &&
                activeDuration == other.activeDuration &&
                adId == other.adId &&
                adsetId == other.adsetId &&
                browserLanguage == other.browserLanguage &&
                browserName == other.browserName &&
                browserVersion == other.browserVersion &&
                campaignId == other.campaignId &&
                clickid == other.clickid &&
                clid == other.clid &&
                cpuArchitecture == other.cpuArchitecture &&
                currentUrl == other.currentUrl &&
                dclid == other.dclid &&
                deviceModel == other.deviceModel &&
                deviceType == other.deviceType &&
                deviceVendor == other.deviceVendor &&
                duration == other.duration &&
                encoding == other.encoding &&
                engineName == other.engineName &&
                engineVersion == other.engineVersion &&
                epik == other.epik &&
                fbc == other.fbc &&
                fbclid == other.fbclid &&
                fbp == other.fbp &&
                fv == other.fv &&
                gadSource == other.gadSource &&
                gbraid == other.gbraid &&
                gclid == other.gclid &&
                host == other.host &&
                iframe == other.iframe &&
                ip == other.ip &&
                irclickid == other.irclickid &&
                isBot == other.isBot &&
                liFatId == other.liFatId &&
                msclkid == other.msclkid &&
                ndclid == other.ndclid &&
                newS == other.newS &&
                osName == other.osName &&
                osVersion == other.osVersion &&
                pageHash == other.pageHash &&
                pathname == other.pathname &&
                qclid == other.qclid &&
                rdtCid == other.rdtCid &&
                receivedAt == other.receivedAt &&
                referrer == other.referrer &&
                sacid == other.sacid &&
                sccid == other.sccid &&
                screenHeight == other.screenHeight &&
                screenWidth == other.screenWidth &&
                sessionCount == other.sessionCount &&
                sid == other.sid &&
                sr == other.sr &&
                title == other.title &&
                ttclid == other.ttclid &&
                twclid == other.twclid &&
                uafvl == other.uafvl &&
                userAgent == other.userAgent &&
                utmCampaign == other.utmCampaign &&
                utmContent == other.utmContent &&
                utmMedium == other.utmMedium &&
                utmName == other.utmName &&
                utmSource == other.utmSource &&
                utmTerm == other.utmTerm &&
                version == other.version &&
                wbraid == other.wbraid &&
                webview == other.webview &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                activeDuration,
                adId,
                adsetId,
                browserLanguage,
                browserName,
                browserVersion,
                campaignId,
                clickid,
                clid,
                cpuArchitecture,
                currentUrl,
                dclid,
                deviceModel,
                deviceType,
                deviceVendor,
                duration,
                encoding,
                engineName,
                engineVersion,
                epik,
                fbc,
                fbclid,
                fbp,
                fv,
                gadSource,
                gbraid,
                gclid,
                host,
                iframe,
                ip,
                irclickid,
                isBot,
                liFatId,
                msclkid,
                ndclid,
                newS,
                osName,
                osVersion,
                pageHash,
                pathname,
                qclid,
                rdtCid,
                receivedAt,
                referrer,
                sacid,
                sccid,
                screenHeight,
                screenWidth,
                sessionCount,
                sid,
                sr,
                title,
                ttclid,
                twclid,
                uafvl,
                userAgent,
                utmCampaign,
                utmContent,
                utmMedium,
                utmName,
                utmSource,
                utmTerm,
                version,
                wbraid,
                webview,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "DefaultProperties{activeDuration=$activeDuration, adId=$adId, adsetId=$adsetId, browserLanguage=$browserLanguage, browserName=$browserName, browserVersion=$browserVersion, campaignId=$campaignId, clickid=$clickid, clid=$clid, cpuArchitecture=$cpuArchitecture, currentUrl=$currentUrl, dclid=$dclid, deviceModel=$deviceModel, deviceType=$deviceType, deviceVendor=$deviceVendor, duration=$duration, encoding=$encoding, engineName=$engineName, engineVersion=$engineVersion, epik=$epik, fbc=$fbc, fbclid=$fbclid, fbp=$fbp, fv=$fv, gadSource=$gadSource, gbraid=$gbraid, gclid=$gclid, host=$host, iframe=$iframe, ip=$ip, irclickid=$irclickid, isBot=$isBot, liFatId=$liFatId, msclkid=$msclkid, ndclid=$ndclid, newS=$newS, osName=$osName, osVersion=$osVersion, pageHash=$pageHash, pathname=$pathname, qclid=$qclid, rdtCid=$rdtCid, receivedAt=$receivedAt, referrer=$referrer, sacid=$sacid, sccid=$sccid, screenHeight=$screenHeight, screenWidth=$screenWidth, sessionCount=$sessionCount, sid=$sid, sr=$sr, title=$title, ttclid=$ttclid, twclid=$twclid, uafvl=$uafvl, userAgent=$userAgent, utmCampaign=$utmCampaign, utmContent=$utmContent, utmMedium=$utmMedium, utmName=$utmName, utmSource=$utmSource, utmTerm=$utmTerm, version=$version, wbraid=$wbraid, webview=$webview, additionalProperties=$additionalProperties}"
    }

    /** Any additional event properties you want to pass along. */
    class EventProperties
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [EventProperties]. */
            fun builder() = Builder()
        }

        /** A builder for [EventProperties]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(eventProperties: EventProperties) = apply {
                additionalProperties = eventProperties.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [EventProperties].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): EventProperties = EventProperties(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): EventProperties = apply {
            if (validated) {
                return@apply
            }

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
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is EventProperties && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "EventProperties{additionalProperties=$additionalProperties}"
    }

    /**
     * Properties to set on the visitor. (optional) You can also update these properties via the
     * identify endpoint.
     */
    class UserProperties
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val adId: JsonField<String>,
        private val adsetId: JsonField<String>,
        private val campaignId: JsonField<String>,
        private val city: JsonField<String>,
        private val clickid: JsonField<String>,
        private val clid: JsonField<String>,
        private val companyName: JsonField<String>,
        private val consent: JsonField<Consent>,
        private val country: JsonField<String>,
        private val customProperties: JsonField<CustomProperties>,
        private val dateOfBirth: JsonField<String>,
        private val dclid: JsonField<String>,
        private val email: JsonField<String>,
        private val epik: JsonField<String>,
        private val externalId: JsonField<String>,
        private val fbc: JsonField<String>,
        private val fbclid: JsonField<String>,
        private val fbp: JsonField<String>,
        private val firstName: JsonField<String>,
        private val gadSource: JsonField<String>,
        private val gbraid: JsonField<String>,
        private val gclid: JsonField<String>,
        private val gender: JsonField<String>,
        private val ip: JsonField<String>,
        private val irclickid: JsonField<String>,
        private val isBot: JsonValue,
        private val jobTitle: JsonField<String>,
        private val lastName: JsonField<String>,
        private val liFatId: JsonField<String>,
        private val msclkid: JsonField<String>,
        private val ndclid: JsonField<String>,
        private val phoneNumber: JsonValue,
        private val qclid: JsonField<String>,
        private val rdtCid: JsonField<String>,
        private val referrer: JsonField<String>,
        private val sacid: JsonField<String>,
        private val sccid: JsonField<String>,
        private val sid: JsonField<String>,
        private val state: JsonField<String>,
        private val ttclid: JsonField<String>,
        private val twclid: JsonField<String>,
        private val userAgent: JsonField<String>,
        private val userAgentFullList: JsonField<String>,
        private val utmCampaign: JsonField<String>,
        private val utmContent: JsonField<String>,
        private val utmMedium: JsonField<String>,
        private val utmName: JsonField<String>,
        private val utmSource: JsonField<String>,
        private val utmTerm: JsonField<String>,
        private val wbraid: JsonField<String>,
        private val zip: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("ad_id") @ExcludeMissing adId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("adset_id") @ExcludeMissing adsetId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("campaign_id")
            @ExcludeMissing
            campaignId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("city") @ExcludeMissing city: JsonField<String> = JsonMissing.of(),
            @JsonProperty("clickid") @ExcludeMissing clickid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("clid") @ExcludeMissing clid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("company_name")
            @ExcludeMissing
            companyName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("consent") @ExcludeMissing consent: JsonField<Consent> = JsonMissing.of(),
            @JsonProperty("country") @ExcludeMissing country: JsonField<String> = JsonMissing.of(),
            @JsonProperty("custom_properties")
            @ExcludeMissing
            customProperties: JsonField<CustomProperties> = JsonMissing.of(),
            @JsonProperty("date_of_birth")
            @ExcludeMissing
            dateOfBirth: JsonField<String> = JsonMissing.of(),
            @JsonProperty("dclid") @ExcludeMissing dclid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
            @JsonProperty("epik") @ExcludeMissing epik: JsonField<String> = JsonMissing.of(),
            @JsonProperty("external_id")
            @ExcludeMissing
            externalId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("fbc") @ExcludeMissing fbc: JsonField<String> = JsonMissing.of(),
            @JsonProperty("fbclid") @ExcludeMissing fbclid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("fbp") @ExcludeMissing fbp: JsonField<String> = JsonMissing.of(),
            @JsonProperty("first_name")
            @ExcludeMissing
            firstName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("gad_source")
            @ExcludeMissing
            gadSource: JsonField<String> = JsonMissing.of(),
            @JsonProperty("gbraid") @ExcludeMissing gbraid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("gclid") @ExcludeMissing gclid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("gender") @ExcludeMissing gender: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ip") @ExcludeMissing ip: JsonField<String> = JsonMissing.of(),
            @JsonProperty("irclickid")
            @ExcludeMissing
            irclickid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("is_bot") @ExcludeMissing isBot: JsonValue = JsonMissing.of(),
            @JsonProperty("job_title")
            @ExcludeMissing
            jobTitle: JsonField<String> = JsonMissing.of(),
            @JsonProperty("last_name")
            @ExcludeMissing
            lastName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("li_fat_id")
            @ExcludeMissing
            liFatId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("msclkid") @ExcludeMissing msclkid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ndclid") @ExcludeMissing ndclid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("phone_number") @ExcludeMissing phoneNumber: JsonValue = JsonMissing.of(),
            @JsonProperty("qclid") @ExcludeMissing qclid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("rdt_cid") @ExcludeMissing rdtCid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("referrer")
            @ExcludeMissing
            referrer: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sacid") @ExcludeMissing sacid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sccid") @ExcludeMissing sccid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("sid") @ExcludeMissing sid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("state") @ExcludeMissing state: JsonField<String> = JsonMissing.of(),
            @JsonProperty("ttclid") @ExcludeMissing ttclid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("twclid") @ExcludeMissing twclid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("user_agent")
            @ExcludeMissing
            userAgent: JsonField<String> = JsonMissing.of(),
            @JsonProperty("user_agent_full_list")
            @ExcludeMissing
            userAgentFullList: JsonField<String> = JsonMissing.of(),
            @JsonProperty("utm_campaign")
            @ExcludeMissing
            utmCampaign: JsonField<String> = JsonMissing.of(),
            @JsonProperty("utm_content")
            @ExcludeMissing
            utmContent: JsonField<String> = JsonMissing.of(),
            @JsonProperty("utm_medium")
            @ExcludeMissing
            utmMedium: JsonField<String> = JsonMissing.of(),
            @JsonProperty("utm_name") @ExcludeMissing utmName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("utm_source")
            @ExcludeMissing
            utmSource: JsonField<String> = JsonMissing.of(),
            @JsonProperty("utm_term") @ExcludeMissing utmTerm: JsonField<String> = JsonMissing.of(),
            @JsonProperty("wbraid") @ExcludeMissing wbraid: JsonField<String> = JsonMissing.of(),
            @JsonProperty("zip") @ExcludeMissing zip: JsonValue = JsonMissing.of(),
        ) : this(
            adId,
            adsetId,
            campaignId,
            city,
            clickid,
            clid,
            companyName,
            consent,
            country,
            customProperties,
            dateOfBirth,
            dclid,
            email,
            epik,
            externalId,
            fbc,
            fbclid,
            fbp,
            firstName,
            gadSource,
            gbraid,
            gclid,
            gender,
            ip,
            irclickid,
            isBot,
            jobTitle,
            lastName,
            liFatId,
            msclkid,
            ndclid,
            phoneNumber,
            qclid,
            rdtCid,
            referrer,
            sacid,
            sccid,
            sid,
            state,
            ttclid,
            twclid,
            userAgent,
            userAgentFullList,
            utmCampaign,
            utmContent,
            utmMedium,
            utmName,
            utmSource,
            utmTerm,
            wbraid,
            zip,
            mutableMapOf(),
        )

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun adId(): String? = adId.getNullable("ad_id")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun adsetId(): String? = adsetId.getNullable("adset_id")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun campaignId(): String? = campaignId.getNullable("campaign_id")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun city(): String? = city.getNullable("city")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun clickid(): String? = clickid.getNullable("clickid")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun clid(): String? = clid.getNullable("clid")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun companyName(): String? = companyName.getNullable("company_name")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun consent(): Consent? = consent.getNullable("consent")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun country(): String? = country.getNullable("country")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun customProperties(): CustomProperties? =
            customProperties.getNullable("custom_properties")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun dateOfBirth(): String? = dateOfBirth.getNullable("date_of_birth")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun dclid(): String? = dclid.getNullable("dclid")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun email(): String? = email.getNullable("email")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun epik(): String? = epik.getNullable("epik")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun externalId(): String? = externalId.getNullable("external_id")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun fbc(): String? = fbc.getNullable("fbc")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun fbclid(): String? = fbclid.getNullable("fbclid")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun fbp(): String? = fbp.getNullable("fbp")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun firstName(): String? = firstName.getNullable("first_name")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun gadSource(): String? = gadSource.getNullable("gad_source")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun gbraid(): String? = gbraid.getNullable("gbraid")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun gclid(): String? = gclid.getNullable("gclid")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun gender(): String? = gender.getNullable("gender")

        /**
         * The IP address of the user
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun ip(): String? = ip.getNullable("ip")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun irclickid(): String? = irclickid.getNullable("irclickid")

        @JsonProperty("is_bot") @ExcludeMissing fun _isBot(): JsonValue = isBot

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun jobTitle(): String? = jobTitle.getNullable("job_title")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun lastName(): String? = lastName.getNullable("last_name")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun liFatId(): String? = liFatId.getNullable("li_fat_id")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun msclkid(): String? = msclkid.getNullable("msclkid")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun ndclid(): String? = ndclid.getNullable("ndclid")

        @JsonProperty("phone_number") @ExcludeMissing fun _phoneNumber(): JsonValue = phoneNumber

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun qclid(): String? = qclid.getNullable("qclid")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun rdtCid(): String? = rdtCid.getNullable("rdt_cid")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun referrer(): String? = referrer.getNullable("referrer")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun sacid(): String? = sacid.getNullable("sacid")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun sccid(): String? = sccid.getNullable("sccid")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun sid(): String? = sid.getNullable("sid")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun state(): String? = state.getNullable("state")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun ttclid(): String? = ttclid.getNullable("ttclid")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun twclid(): String? = twclid.getNullable("twclid")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun userAgent(): String? = userAgent.getNullable("user_agent")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun userAgentFullList(): String? = userAgentFullList.getNullable("user_agent_full_list")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun utmCampaign(): String? = utmCampaign.getNullable("utm_campaign")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun utmContent(): String? = utmContent.getNullable("utm_content")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun utmMedium(): String? = utmMedium.getNullable("utm_medium")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun utmName(): String? = utmName.getNullable("utm_name")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun utmSource(): String? = utmSource.getNullable("utm_source")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun utmTerm(): String? = utmTerm.getNullable("utm_term")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun wbraid(): String? = wbraid.getNullable("wbraid")

        @JsonProperty("zip") @ExcludeMissing fun _zip(): JsonValue = zip

        /**
         * Returns the raw JSON value of [adId].
         *
         * Unlike [adId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ad_id") @ExcludeMissing fun _adId(): JsonField<String> = adId

        /**
         * Returns the raw JSON value of [adsetId].
         *
         * Unlike [adsetId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("adset_id") @ExcludeMissing fun _adsetId(): JsonField<String> = adsetId

        /**
         * Returns the raw JSON value of [campaignId].
         *
         * Unlike [campaignId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("campaign_id")
        @ExcludeMissing
        fun _campaignId(): JsonField<String> = campaignId

        /**
         * Returns the raw JSON value of [city].
         *
         * Unlike [city], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("city") @ExcludeMissing fun _city(): JsonField<String> = city

        /**
         * Returns the raw JSON value of [clickid].
         *
         * Unlike [clickid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("clickid") @ExcludeMissing fun _clickid(): JsonField<String> = clickid

        /**
         * Returns the raw JSON value of [clid].
         *
         * Unlike [clid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("clid") @ExcludeMissing fun _clid(): JsonField<String> = clid

        /**
         * Returns the raw JSON value of [companyName].
         *
         * Unlike [companyName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("company_name")
        @ExcludeMissing
        fun _companyName(): JsonField<String> = companyName

        /**
         * Returns the raw JSON value of [consent].
         *
         * Unlike [consent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("consent") @ExcludeMissing fun _consent(): JsonField<Consent> = consent

        /**
         * Returns the raw JSON value of [country].
         *
         * Unlike [country], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("country") @ExcludeMissing fun _country(): JsonField<String> = country

        /**
         * Returns the raw JSON value of [customProperties].
         *
         * Unlike [customProperties], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("custom_properties")
        @ExcludeMissing
        fun _customProperties(): JsonField<CustomProperties> = customProperties

        /**
         * Returns the raw JSON value of [dateOfBirth].
         *
         * Unlike [dateOfBirth], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("date_of_birth")
        @ExcludeMissing
        fun _dateOfBirth(): JsonField<String> = dateOfBirth

        /**
         * Returns the raw JSON value of [dclid].
         *
         * Unlike [dclid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("dclid") @ExcludeMissing fun _dclid(): JsonField<String> = dclid

        /**
         * Returns the raw JSON value of [email].
         *
         * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

        /**
         * Returns the raw JSON value of [epik].
         *
         * Unlike [epik], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("epik") @ExcludeMissing fun _epik(): JsonField<String> = epik

        /**
         * Returns the raw JSON value of [externalId].
         *
         * Unlike [externalId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("external_id")
        @ExcludeMissing
        fun _externalId(): JsonField<String> = externalId

        /**
         * Returns the raw JSON value of [fbc].
         *
         * Unlike [fbc], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fbc") @ExcludeMissing fun _fbc(): JsonField<String> = fbc

        /**
         * Returns the raw JSON value of [fbclid].
         *
         * Unlike [fbclid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fbclid") @ExcludeMissing fun _fbclid(): JsonField<String> = fbclid

        /**
         * Returns the raw JSON value of [fbp].
         *
         * Unlike [fbp], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("fbp") @ExcludeMissing fun _fbp(): JsonField<String> = fbp

        /**
         * Returns the raw JSON value of [firstName].
         *
         * Unlike [firstName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("first_name") @ExcludeMissing fun _firstName(): JsonField<String> = firstName

        /**
         * Returns the raw JSON value of [gadSource].
         *
         * Unlike [gadSource], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("gad_source") @ExcludeMissing fun _gadSource(): JsonField<String> = gadSource

        /**
         * Returns the raw JSON value of [gbraid].
         *
         * Unlike [gbraid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("gbraid") @ExcludeMissing fun _gbraid(): JsonField<String> = gbraid

        /**
         * Returns the raw JSON value of [gclid].
         *
         * Unlike [gclid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("gclid") @ExcludeMissing fun _gclid(): JsonField<String> = gclid

        /**
         * Returns the raw JSON value of [gender].
         *
         * Unlike [gender], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("gender") @ExcludeMissing fun _gender(): JsonField<String> = gender

        /**
         * Returns the raw JSON value of [ip].
         *
         * Unlike [ip], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ip") @ExcludeMissing fun _ip(): JsonField<String> = ip

        /**
         * Returns the raw JSON value of [irclickid].
         *
         * Unlike [irclickid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("irclickid") @ExcludeMissing fun _irclickid(): JsonField<String> = irclickid

        /**
         * Returns the raw JSON value of [jobTitle].
         *
         * Unlike [jobTitle], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("job_title") @ExcludeMissing fun _jobTitle(): JsonField<String> = jobTitle

        /**
         * Returns the raw JSON value of [lastName].
         *
         * Unlike [lastName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("last_name") @ExcludeMissing fun _lastName(): JsonField<String> = lastName

        /**
         * Returns the raw JSON value of [liFatId].
         *
         * Unlike [liFatId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("li_fat_id") @ExcludeMissing fun _liFatId(): JsonField<String> = liFatId

        /**
         * Returns the raw JSON value of [msclkid].
         *
         * Unlike [msclkid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("msclkid") @ExcludeMissing fun _msclkid(): JsonField<String> = msclkid

        /**
         * Returns the raw JSON value of [ndclid].
         *
         * Unlike [ndclid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ndclid") @ExcludeMissing fun _ndclid(): JsonField<String> = ndclid

        /**
         * Returns the raw JSON value of [qclid].
         *
         * Unlike [qclid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("qclid") @ExcludeMissing fun _qclid(): JsonField<String> = qclid

        /**
         * Returns the raw JSON value of [rdtCid].
         *
         * Unlike [rdtCid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("rdt_cid") @ExcludeMissing fun _rdtCid(): JsonField<String> = rdtCid

        /**
         * Returns the raw JSON value of [referrer].
         *
         * Unlike [referrer], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("referrer") @ExcludeMissing fun _referrer(): JsonField<String> = referrer

        /**
         * Returns the raw JSON value of [sacid].
         *
         * Unlike [sacid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sacid") @ExcludeMissing fun _sacid(): JsonField<String> = sacid

        /**
         * Returns the raw JSON value of [sccid].
         *
         * Unlike [sccid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sccid") @ExcludeMissing fun _sccid(): JsonField<String> = sccid

        /**
         * Returns the raw JSON value of [sid].
         *
         * Unlike [sid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sid") @ExcludeMissing fun _sid(): JsonField<String> = sid

        /**
         * Returns the raw JSON value of [state].
         *
         * Unlike [state], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("state") @ExcludeMissing fun _state(): JsonField<String> = state

        /**
         * Returns the raw JSON value of [ttclid].
         *
         * Unlike [ttclid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ttclid") @ExcludeMissing fun _ttclid(): JsonField<String> = ttclid

        /**
         * Returns the raw JSON value of [twclid].
         *
         * Unlike [twclid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("twclid") @ExcludeMissing fun _twclid(): JsonField<String> = twclid

        /**
         * Returns the raw JSON value of [userAgent].
         *
         * Unlike [userAgent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("user_agent") @ExcludeMissing fun _userAgent(): JsonField<String> = userAgent

        /**
         * Returns the raw JSON value of [userAgentFullList].
         *
         * Unlike [userAgentFullList], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("user_agent_full_list")
        @ExcludeMissing
        fun _userAgentFullList(): JsonField<String> = userAgentFullList

        /**
         * Returns the raw JSON value of [utmCampaign].
         *
         * Unlike [utmCampaign], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("utm_campaign")
        @ExcludeMissing
        fun _utmCampaign(): JsonField<String> = utmCampaign

        /**
         * Returns the raw JSON value of [utmContent].
         *
         * Unlike [utmContent], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("utm_content")
        @ExcludeMissing
        fun _utmContent(): JsonField<String> = utmContent

        /**
         * Returns the raw JSON value of [utmMedium].
         *
         * Unlike [utmMedium], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("utm_medium") @ExcludeMissing fun _utmMedium(): JsonField<String> = utmMedium

        /**
         * Returns the raw JSON value of [utmName].
         *
         * Unlike [utmName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("utm_name") @ExcludeMissing fun _utmName(): JsonField<String> = utmName

        /**
         * Returns the raw JSON value of [utmSource].
         *
         * Unlike [utmSource], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("utm_source") @ExcludeMissing fun _utmSource(): JsonField<String> = utmSource

        /**
         * Returns the raw JSON value of [utmTerm].
         *
         * Unlike [utmTerm], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("utm_term") @ExcludeMissing fun _utmTerm(): JsonField<String> = utmTerm

        /**
         * Returns the raw JSON value of [wbraid].
         *
         * Unlike [wbraid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("wbraid") @ExcludeMissing fun _wbraid(): JsonField<String> = wbraid

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

            /** Returns a mutable builder for constructing an instance of [UserProperties]. */
            fun builder() = Builder()
        }

        /** A builder for [UserProperties]. */
        class Builder internal constructor() {

            private var adId: JsonField<String> = JsonMissing.of()
            private var adsetId: JsonField<String> = JsonMissing.of()
            private var campaignId: JsonField<String> = JsonMissing.of()
            private var city: JsonField<String> = JsonMissing.of()
            private var clickid: JsonField<String> = JsonMissing.of()
            private var clid: JsonField<String> = JsonMissing.of()
            private var companyName: JsonField<String> = JsonMissing.of()
            private var consent: JsonField<Consent> = JsonMissing.of()
            private var country: JsonField<String> = JsonMissing.of()
            private var customProperties: JsonField<CustomProperties> = JsonMissing.of()
            private var dateOfBirth: JsonField<String> = JsonMissing.of()
            private var dclid: JsonField<String> = JsonMissing.of()
            private var email: JsonField<String> = JsonMissing.of()
            private var epik: JsonField<String> = JsonMissing.of()
            private var externalId: JsonField<String> = JsonMissing.of()
            private var fbc: JsonField<String> = JsonMissing.of()
            private var fbclid: JsonField<String> = JsonMissing.of()
            private var fbp: JsonField<String> = JsonMissing.of()
            private var firstName: JsonField<String> = JsonMissing.of()
            private var gadSource: JsonField<String> = JsonMissing.of()
            private var gbraid: JsonField<String> = JsonMissing.of()
            private var gclid: JsonField<String> = JsonMissing.of()
            private var gender: JsonField<String> = JsonMissing.of()
            private var ip: JsonField<String> = JsonMissing.of()
            private var irclickid: JsonField<String> = JsonMissing.of()
            private var isBot: JsonValue = JsonMissing.of()
            private var jobTitle: JsonField<String> = JsonMissing.of()
            private var lastName: JsonField<String> = JsonMissing.of()
            private var liFatId: JsonField<String> = JsonMissing.of()
            private var msclkid: JsonField<String> = JsonMissing.of()
            private var ndclid: JsonField<String> = JsonMissing.of()
            private var phoneNumber: JsonValue = JsonMissing.of()
            private var qclid: JsonField<String> = JsonMissing.of()
            private var rdtCid: JsonField<String> = JsonMissing.of()
            private var referrer: JsonField<String> = JsonMissing.of()
            private var sacid: JsonField<String> = JsonMissing.of()
            private var sccid: JsonField<String> = JsonMissing.of()
            private var sid: JsonField<String> = JsonMissing.of()
            private var state: JsonField<String> = JsonMissing.of()
            private var ttclid: JsonField<String> = JsonMissing.of()
            private var twclid: JsonField<String> = JsonMissing.of()
            private var userAgent: JsonField<String> = JsonMissing.of()
            private var userAgentFullList: JsonField<String> = JsonMissing.of()
            private var utmCampaign: JsonField<String> = JsonMissing.of()
            private var utmContent: JsonField<String> = JsonMissing.of()
            private var utmMedium: JsonField<String> = JsonMissing.of()
            private var utmName: JsonField<String> = JsonMissing.of()
            private var utmSource: JsonField<String> = JsonMissing.of()
            private var utmTerm: JsonField<String> = JsonMissing.of()
            private var wbraid: JsonField<String> = JsonMissing.of()
            private var zip: JsonValue = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(userProperties: UserProperties) = apply {
                adId = userProperties.adId
                adsetId = userProperties.adsetId
                campaignId = userProperties.campaignId
                city = userProperties.city
                clickid = userProperties.clickid
                clid = userProperties.clid
                companyName = userProperties.companyName
                consent = userProperties.consent
                country = userProperties.country
                customProperties = userProperties.customProperties
                dateOfBirth = userProperties.dateOfBirth
                dclid = userProperties.dclid
                email = userProperties.email
                epik = userProperties.epik
                externalId = userProperties.externalId
                fbc = userProperties.fbc
                fbclid = userProperties.fbclid
                fbp = userProperties.fbp
                firstName = userProperties.firstName
                gadSource = userProperties.gadSource
                gbraid = userProperties.gbraid
                gclid = userProperties.gclid
                gender = userProperties.gender
                ip = userProperties.ip
                irclickid = userProperties.irclickid
                isBot = userProperties.isBot
                jobTitle = userProperties.jobTitle
                lastName = userProperties.lastName
                liFatId = userProperties.liFatId
                msclkid = userProperties.msclkid
                ndclid = userProperties.ndclid
                phoneNumber = userProperties.phoneNumber
                qclid = userProperties.qclid
                rdtCid = userProperties.rdtCid
                referrer = userProperties.referrer
                sacid = userProperties.sacid
                sccid = userProperties.sccid
                sid = userProperties.sid
                state = userProperties.state
                ttclid = userProperties.ttclid
                twclid = userProperties.twclid
                userAgent = userProperties.userAgent
                userAgentFullList = userProperties.userAgentFullList
                utmCampaign = userProperties.utmCampaign
                utmContent = userProperties.utmContent
                utmMedium = userProperties.utmMedium
                utmName = userProperties.utmName
                utmSource = userProperties.utmSource
                utmTerm = userProperties.utmTerm
                wbraid = userProperties.wbraid
                zip = userProperties.zip
                additionalProperties = userProperties.additionalProperties.toMutableMap()
            }

            fun adId(adId: String?) = adId(JsonField.ofNullable(adId))

            /**
             * Sets [Builder.adId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.adId] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun adId(adId: JsonField<String>) = apply { this.adId = adId }

            fun adsetId(adsetId: String?) = adsetId(JsonField.ofNullable(adsetId))

            /**
             * Sets [Builder.adsetId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.adsetId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun adsetId(adsetId: JsonField<String>) = apply { this.adsetId = adsetId }

            fun campaignId(campaignId: String?) = campaignId(JsonField.ofNullable(campaignId))

            /**
             * Sets [Builder.campaignId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.campaignId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun campaignId(campaignId: JsonField<String>) = apply { this.campaignId = campaignId }

            fun city(city: String?) = city(JsonField.ofNullable(city))

            /**
             * Sets [Builder.city] to an arbitrary JSON value.
             *
             * You should usually call [Builder.city] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun city(city: JsonField<String>) = apply { this.city = city }

            fun clickid(clickid: String?) = clickid(JsonField.ofNullable(clickid))

            /**
             * Sets [Builder.clickid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.clickid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun clickid(clickid: JsonField<String>) = apply { this.clickid = clickid }

            fun clid(clid: String?) = clid(JsonField.ofNullable(clid))

            /**
             * Sets [Builder.clid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.clid] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun clid(clid: JsonField<String>) = apply { this.clid = clid }

            fun companyName(companyName: String?) = companyName(JsonField.ofNullable(companyName))

            /**
             * Sets [Builder.companyName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.companyName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun companyName(companyName: JsonField<String>) = apply {
                this.companyName = companyName
            }

            fun consent(consent: Consent?) = consent(JsonField.ofNullable(consent))

            /**
             * Sets [Builder.consent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.consent] with a well-typed [Consent] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun consent(consent: JsonField<Consent>) = apply { this.consent = consent }

            fun country(country: String?) = country(JsonField.ofNullable(country))

            /**
             * Sets [Builder.country] to an arbitrary JSON value.
             *
             * You should usually call [Builder.country] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun country(country: JsonField<String>) = apply { this.country = country }

            fun customProperties(customProperties: CustomProperties?) =
                customProperties(JsonField.ofNullable(customProperties))

            /**
             * Sets [Builder.customProperties] to an arbitrary JSON value.
             *
             * You should usually call [Builder.customProperties] with a well-typed
             * [CustomProperties] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun customProperties(customProperties: JsonField<CustomProperties>) = apply {
                this.customProperties = customProperties
            }

            fun dateOfBirth(dateOfBirth: String?) = dateOfBirth(JsonField.ofNullable(dateOfBirth))

            /**
             * Sets [Builder.dateOfBirth] to an arbitrary JSON value.
             *
             * You should usually call [Builder.dateOfBirth] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun dateOfBirth(dateOfBirth: JsonField<String>) = apply {
                this.dateOfBirth = dateOfBirth
            }

            fun dclid(dclid: String?) = dclid(JsonField.ofNullable(dclid))

            /**
             * Sets [Builder.dclid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.dclid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun dclid(dclid: JsonField<String>) = apply { this.dclid = dclid }

            fun email(email: String?) = email(JsonField.ofNullable(email))

            /**
             * Sets [Builder.email] to an arbitrary JSON value.
             *
             * You should usually call [Builder.email] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun email(email: JsonField<String>) = apply { this.email = email }

            fun epik(epik: String?) = epik(JsonField.ofNullable(epik))

            /**
             * Sets [Builder.epik] to an arbitrary JSON value.
             *
             * You should usually call [Builder.epik] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun epik(epik: JsonField<String>) = apply { this.epik = epik }

            fun externalId(externalId: String?) = externalId(JsonField.ofNullable(externalId))

            /**
             * Sets [Builder.externalId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.externalId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun externalId(externalId: JsonField<String>) = apply { this.externalId = externalId }

            fun fbc(fbc: String?) = fbc(JsonField.ofNullable(fbc))

            /**
             * Sets [Builder.fbc] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fbc] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun fbc(fbc: JsonField<String>) = apply { this.fbc = fbc }

            fun fbclid(fbclid: String?) = fbclid(JsonField.ofNullable(fbclid))

            /**
             * Sets [Builder.fbclid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fbclid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fbclid(fbclid: JsonField<String>) = apply { this.fbclid = fbclid }

            fun fbp(fbp: String?) = fbp(JsonField.ofNullable(fbp))

            /**
             * Sets [Builder.fbp] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fbp] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun fbp(fbp: JsonField<String>) = apply { this.fbp = fbp }

            fun firstName(firstName: String?) = firstName(JsonField.ofNullable(firstName))

            /**
             * Sets [Builder.firstName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.firstName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun firstName(firstName: JsonField<String>) = apply { this.firstName = firstName }

            fun gadSource(gadSource: String?) = gadSource(JsonField.ofNullable(gadSource))

            /**
             * Sets [Builder.gadSource] to an arbitrary JSON value.
             *
             * You should usually call [Builder.gadSource] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun gadSource(gadSource: JsonField<String>) = apply { this.gadSource = gadSource }

            fun gbraid(gbraid: String?) = gbraid(JsonField.ofNullable(gbraid))

            /**
             * Sets [Builder.gbraid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.gbraid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun gbraid(gbraid: JsonField<String>) = apply { this.gbraid = gbraid }

            fun gclid(gclid: String?) = gclid(JsonField.ofNullable(gclid))

            /**
             * Sets [Builder.gclid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.gclid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun gclid(gclid: JsonField<String>) = apply { this.gclid = gclid }

            fun gender(gender: String?) = gender(JsonField.ofNullable(gender))

            /**
             * Sets [Builder.gender] to an arbitrary JSON value.
             *
             * You should usually call [Builder.gender] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun gender(gender: JsonField<String>) = apply { this.gender = gender }

            /** The IP address of the user */
            fun ip(ip: String?) = ip(JsonField.ofNullable(ip))

            /**
             * Sets [Builder.ip] to an arbitrary JSON value.
             *
             * You should usually call [Builder.ip] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun ip(ip: JsonField<String>) = apply { this.ip = ip }

            fun irclickid(irclickid: String?) = irclickid(JsonField.ofNullable(irclickid))

            /**
             * Sets [Builder.irclickid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.irclickid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun irclickid(irclickid: JsonField<String>) = apply { this.irclickid = irclickid }

            fun isBot(isBot: JsonValue) = apply { this.isBot = isBot }

            fun jobTitle(jobTitle: String?) = jobTitle(JsonField.ofNullable(jobTitle))

            /**
             * Sets [Builder.jobTitle] to an arbitrary JSON value.
             *
             * You should usually call [Builder.jobTitle] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun jobTitle(jobTitle: JsonField<String>) = apply { this.jobTitle = jobTitle }

            fun lastName(lastName: String?) = lastName(JsonField.ofNullable(lastName))

            /**
             * Sets [Builder.lastName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.lastName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun lastName(lastName: JsonField<String>) = apply { this.lastName = lastName }

            fun liFatId(liFatId: String?) = liFatId(JsonField.ofNullable(liFatId))

            /**
             * Sets [Builder.liFatId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.liFatId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun liFatId(liFatId: JsonField<String>) = apply { this.liFatId = liFatId }

            fun msclkid(msclkid: String?) = msclkid(JsonField.ofNullable(msclkid))

            /**
             * Sets [Builder.msclkid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.msclkid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun msclkid(msclkid: JsonField<String>) = apply { this.msclkid = msclkid }

            fun ndclid(ndclid: String?) = ndclid(JsonField.ofNullable(ndclid))

            /**
             * Sets [Builder.ndclid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.ndclid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun ndclid(ndclid: JsonField<String>) = apply { this.ndclid = ndclid }

            fun phoneNumber(phoneNumber: JsonValue) = apply { this.phoneNumber = phoneNumber }

            fun qclid(qclid: String?) = qclid(JsonField.ofNullable(qclid))

            /**
             * Sets [Builder.qclid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.qclid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun qclid(qclid: JsonField<String>) = apply { this.qclid = qclid }

            fun rdtCid(rdtCid: String?) = rdtCid(JsonField.ofNullable(rdtCid))

            /**
             * Sets [Builder.rdtCid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.rdtCid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun rdtCid(rdtCid: JsonField<String>) = apply { this.rdtCid = rdtCid }

            fun referrer(referrer: String?) = referrer(JsonField.ofNullable(referrer))

            /**
             * Sets [Builder.referrer] to an arbitrary JSON value.
             *
             * You should usually call [Builder.referrer] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun referrer(referrer: JsonField<String>) = apply { this.referrer = referrer }

            fun sacid(sacid: String?) = sacid(JsonField.ofNullable(sacid))

            /**
             * Sets [Builder.sacid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sacid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sacid(sacid: JsonField<String>) = apply { this.sacid = sacid }

            fun sccid(sccid: String?) = sccid(JsonField.ofNullable(sccid))

            /**
             * Sets [Builder.sccid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sccid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sccid(sccid: JsonField<String>) = apply { this.sccid = sccid }

            fun sid(sid: String?) = sid(JsonField.ofNullable(sid))

            /**
             * Sets [Builder.sid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sid] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun sid(sid: JsonField<String>) = apply { this.sid = sid }

            fun state(state: String?) = state(JsonField.ofNullable(state))

            /**
             * Sets [Builder.state] to an arbitrary JSON value.
             *
             * You should usually call [Builder.state] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun state(state: JsonField<String>) = apply { this.state = state }

            fun ttclid(ttclid: String?) = ttclid(JsonField.ofNullable(ttclid))

            /**
             * Sets [Builder.ttclid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.ttclid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun ttclid(ttclid: JsonField<String>) = apply { this.ttclid = ttclid }

            fun twclid(twclid: String?) = twclid(JsonField.ofNullable(twclid))

            /**
             * Sets [Builder.twclid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.twclid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun twclid(twclid: JsonField<String>) = apply { this.twclid = twclid }

            fun userAgent(userAgent: String?) = userAgent(JsonField.ofNullable(userAgent))

            /**
             * Sets [Builder.userAgent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.userAgent] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun userAgent(userAgent: JsonField<String>) = apply { this.userAgent = userAgent }

            fun userAgentFullList(userAgentFullList: String?) =
                userAgentFullList(JsonField.ofNullable(userAgentFullList))

            /**
             * Sets [Builder.userAgentFullList] to an arbitrary JSON value.
             *
             * You should usually call [Builder.userAgentFullList] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun userAgentFullList(userAgentFullList: JsonField<String>) = apply {
                this.userAgentFullList = userAgentFullList
            }

            fun utmCampaign(utmCampaign: String?) = utmCampaign(JsonField.ofNullable(utmCampaign))

            /**
             * Sets [Builder.utmCampaign] to an arbitrary JSON value.
             *
             * You should usually call [Builder.utmCampaign] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun utmCampaign(utmCampaign: JsonField<String>) = apply {
                this.utmCampaign = utmCampaign
            }

            fun utmContent(utmContent: String?) = utmContent(JsonField.ofNullable(utmContent))

            /**
             * Sets [Builder.utmContent] to an arbitrary JSON value.
             *
             * You should usually call [Builder.utmContent] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun utmContent(utmContent: JsonField<String>) = apply { this.utmContent = utmContent }

            fun utmMedium(utmMedium: String?) = utmMedium(JsonField.ofNullable(utmMedium))

            /**
             * Sets [Builder.utmMedium] to an arbitrary JSON value.
             *
             * You should usually call [Builder.utmMedium] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun utmMedium(utmMedium: JsonField<String>) = apply { this.utmMedium = utmMedium }

            fun utmName(utmName: String?) = utmName(JsonField.ofNullable(utmName))

            /**
             * Sets [Builder.utmName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.utmName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun utmName(utmName: JsonField<String>) = apply { this.utmName = utmName }

            fun utmSource(utmSource: String?) = utmSource(JsonField.ofNullable(utmSource))

            /**
             * Sets [Builder.utmSource] to an arbitrary JSON value.
             *
             * You should usually call [Builder.utmSource] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun utmSource(utmSource: JsonField<String>) = apply { this.utmSource = utmSource }

            fun utmTerm(utmTerm: String?) = utmTerm(JsonField.ofNullable(utmTerm))

            /**
             * Sets [Builder.utmTerm] to an arbitrary JSON value.
             *
             * You should usually call [Builder.utmTerm] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun utmTerm(utmTerm: JsonField<String>) = apply { this.utmTerm = utmTerm }

            fun wbraid(wbraid: String?) = wbraid(JsonField.ofNullable(wbraid))

            /**
             * Sets [Builder.wbraid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.wbraid] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun wbraid(wbraid: JsonField<String>) = apply { this.wbraid = wbraid }

            fun zip(zip: JsonValue) = apply { this.zip = zip }

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
             * Returns an immutable instance of [UserProperties].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): UserProperties =
                UserProperties(
                    adId,
                    adsetId,
                    campaignId,
                    city,
                    clickid,
                    clid,
                    companyName,
                    consent,
                    country,
                    customProperties,
                    dateOfBirth,
                    dclid,
                    email,
                    epik,
                    externalId,
                    fbc,
                    fbclid,
                    fbp,
                    firstName,
                    gadSource,
                    gbraid,
                    gclid,
                    gender,
                    ip,
                    irclickid,
                    isBot,
                    jobTitle,
                    lastName,
                    liFatId,
                    msclkid,
                    ndclid,
                    phoneNumber,
                    qclid,
                    rdtCid,
                    referrer,
                    sacid,
                    sccid,
                    sid,
                    state,
                    ttclid,
                    twclid,
                    userAgent,
                    userAgentFullList,
                    utmCampaign,
                    utmContent,
                    utmMedium,
                    utmName,
                    utmSource,
                    utmTerm,
                    wbraid,
                    zip,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): UserProperties = apply {
            if (validated) {
                return@apply
            }

            adId()
            adsetId()
            campaignId()
            city()
            clickid()
            clid()
            companyName()
            consent()?.validate()
            country()
            customProperties()?.validate()
            dateOfBirth()
            dclid()
            email()
            epik()
            externalId()
            fbc()
            fbclid()
            fbp()
            firstName()
            gadSource()
            gbraid()
            gclid()
            gender()
            ip()
            irclickid()
            jobTitle()
            lastName()
            liFatId()
            msclkid()
            ndclid()
            qclid()
            rdtCid()
            referrer()
            sacid()
            sccid()
            sid()
            state()
            ttclid()
            twclid()
            userAgent()
            userAgentFullList()
            utmCampaign()
            utmContent()
            utmMedium()
            utmName()
            utmSource()
            utmTerm()
            wbraid()
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
            (if (adId.asKnown() == null) 0 else 1) +
                (if (adsetId.asKnown() == null) 0 else 1) +
                (if (campaignId.asKnown() == null) 0 else 1) +
                (if (city.asKnown() == null) 0 else 1) +
                (if (clickid.asKnown() == null) 0 else 1) +
                (if (clid.asKnown() == null) 0 else 1) +
                (if (companyName.asKnown() == null) 0 else 1) +
                (consent.asKnown()?.validity() ?: 0) +
                (if (country.asKnown() == null) 0 else 1) +
                (customProperties.asKnown()?.validity() ?: 0) +
                (if (dateOfBirth.asKnown() == null) 0 else 1) +
                (if (dclid.asKnown() == null) 0 else 1) +
                (if (email.asKnown() == null) 0 else 1) +
                (if (epik.asKnown() == null) 0 else 1) +
                (if (externalId.asKnown() == null) 0 else 1) +
                (if (fbc.asKnown() == null) 0 else 1) +
                (if (fbclid.asKnown() == null) 0 else 1) +
                (if (fbp.asKnown() == null) 0 else 1) +
                (if (firstName.asKnown() == null) 0 else 1) +
                (if (gadSource.asKnown() == null) 0 else 1) +
                (if (gbraid.asKnown() == null) 0 else 1) +
                (if (gclid.asKnown() == null) 0 else 1) +
                (if (gender.asKnown() == null) 0 else 1) +
                (if (ip.asKnown() == null) 0 else 1) +
                (if (irclickid.asKnown() == null) 0 else 1) +
                (if (jobTitle.asKnown() == null) 0 else 1) +
                (if (lastName.asKnown() == null) 0 else 1) +
                (if (liFatId.asKnown() == null) 0 else 1) +
                (if (msclkid.asKnown() == null) 0 else 1) +
                (if (ndclid.asKnown() == null) 0 else 1) +
                (if (qclid.asKnown() == null) 0 else 1) +
                (if (rdtCid.asKnown() == null) 0 else 1) +
                (if (referrer.asKnown() == null) 0 else 1) +
                (if (sacid.asKnown() == null) 0 else 1) +
                (if (sccid.asKnown() == null) 0 else 1) +
                (if (sid.asKnown() == null) 0 else 1) +
                (if (state.asKnown() == null) 0 else 1) +
                (if (ttclid.asKnown() == null) 0 else 1) +
                (if (twclid.asKnown() == null) 0 else 1) +
                (if (userAgent.asKnown() == null) 0 else 1) +
                (if (userAgentFullList.asKnown() == null) 0 else 1) +
                (if (utmCampaign.asKnown() == null) 0 else 1) +
                (if (utmContent.asKnown() == null) 0 else 1) +
                (if (utmMedium.asKnown() == null) 0 else 1) +
                (if (utmName.asKnown() == null) 0 else 1) +
                (if (utmSource.asKnown() == null) 0 else 1) +
                (if (utmTerm.asKnown() == null) 0 else 1) +
                (if (wbraid.asKnown() == null) 0 else 1)

        class Consent
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Consent]. */
                fun builder() = Builder()
            }

            /** A builder for [Consent]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(consent: Consent) = apply {
                    additionalProperties = consent.additionalProperties.toMutableMap()
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Consent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Consent = Consent(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): Consent = apply {
                if (validated) {
                    return@apply
                }

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
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Consent && additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "Consent{additionalProperties=$additionalProperties}"
        }

        class CustomProperties
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [CustomProperties]. */
                fun builder() = Builder()
            }

            /** A builder for [CustomProperties]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(customProperties: CustomProperties) = apply {
                    additionalProperties = customProperties.additionalProperties.toMutableMap()
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [CustomProperties].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): CustomProperties = CustomProperties(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): CustomProperties = apply {
                if (validated) {
                    return@apply
                }

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
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is CustomProperties &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() = "CustomProperties{additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is UserProperties &&
                adId == other.adId &&
                adsetId == other.adsetId &&
                campaignId == other.campaignId &&
                city == other.city &&
                clickid == other.clickid &&
                clid == other.clid &&
                companyName == other.companyName &&
                consent == other.consent &&
                country == other.country &&
                customProperties == other.customProperties &&
                dateOfBirth == other.dateOfBirth &&
                dclid == other.dclid &&
                email == other.email &&
                epik == other.epik &&
                externalId == other.externalId &&
                fbc == other.fbc &&
                fbclid == other.fbclid &&
                fbp == other.fbp &&
                firstName == other.firstName &&
                gadSource == other.gadSource &&
                gbraid == other.gbraid &&
                gclid == other.gclid &&
                gender == other.gender &&
                ip == other.ip &&
                irclickid == other.irclickid &&
                isBot == other.isBot &&
                jobTitle == other.jobTitle &&
                lastName == other.lastName &&
                liFatId == other.liFatId &&
                msclkid == other.msclkid &&
                ndclid == other.ndclid &&
                phoneNumber == other.phoneNumber &&
                qclid == other.qclid &&
                rdtCid == other.rdtCid &&
                referrer == other.referrer &&
                sacid == other.sacid &&
                sccid == other.sccid &&
                sid == other.sid &&
                state == other.state &&
                ttclid == other.ttclid &&
                twclid == other.twclid &&
                userAgent == other.userAgent &&
                userAgentFullList == other.userAgentFullList &&
                utmCampaign == other.utmCampaign &&
                utmContent == other.utmContent &&
                utmMedium == other.utmMedium &&
                utmName == other.utmName &&
                utmSource == other.utmSource &&
                utmTerm == other.utmTerm &&
                wbraid == other.wbraid &&
                zip == other.zip &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                adId,
                adsetId,
                campaignId,
                city,
                clickid,
                clid,
                companyName,
                consent,
                country,
                customProperties,
                dateOfBirth,
                dclid,
                email,
                epik,
                externalId,
                fbc,
                fbclid,
                fbp,
                firstName,
                gadSource,
                gbraid,
                gclid,
                gender,
                ip,
                irclickid,
                isBot,
                jobTitle,
                lastName,
                liFatId,
                msclkid,
                ndclid,
                phoneNumber,
                qclid,
                rdtCid,
                referrer,
                sacid,
                sccid,
                sid,
                state,
                ttclid,
                twclid,
                userAgent,
                userAgentFullList,
                utmCampaign,
                utmContent,
                utmMedium,
                utmName,
                utmSource,
                utmTerm,
                wbraid,
                zip,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UserProperties{adId=$adId, adsetId=$adsetId, campaignId=$campaignId, city=$city, clickid=$clickid, clid=$clid, companyName=$companyName, consent=$consent, country=$country, customProperties=$customProperties, dateOfBirth=$dateOfBirth, dclid=$dclid, email=$email, epik=$epik, externalId=$externalId, fbc=$fbc, fbclid=$fbclid, fbp=$fbp, firstName=$firstName, gadSource=$gadSource, gbraid=$gbraid, gclid=$gclid, gender=$gender, ip=$ip, irclickid=$irclickid, isBot=$isBot, jobTitle=$jobTitle, lastName=$lastName, liFatId=$liFatId, msclkid=$msclkid, ndclid=$ndclid, phoneNumber=$phoneNumber, qclid=$qclid, rdtCid=$rdtCid, referrer=$referrer, sacid=$sacid, sccid=$sccid, sid=$sid, state=$state, ttclid=$ttclid, twclid=$twclid, userAgent=$userAgent, userAgentFullList=$userAgentFullList, utmCampaign=$utmCampaign, utmContent=$utmContent, utmMedium=$utmMedium, utmName=$utmName, utmSource=$utmSource, utmTerm=$utmTerm, wbraid=$wbraid, zip=$zip, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TrackEventParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "TrackEventParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
