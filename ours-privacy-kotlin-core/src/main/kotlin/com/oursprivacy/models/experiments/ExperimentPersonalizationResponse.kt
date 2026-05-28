// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.models.experiments

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.oursprivacy.core.Enum
import com.oursprivacy.core.ExcludeMissing
import com.oursprivacy.core.JsonField
import com.oursprivacy.core.JsonMissing
import com.oursprivacy.core.JsonValue
import com.oursprivacy.core.checkKnown
import com.oursprivacy.core.checkRequired
import com.oursprivacy.core.toImmutable
import com.oursprivacy.errors.OursPrivacyInvalidDataException
import java.util.Collections
import java.util.Objects

class ExperimentPersonalizationResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val personalizations: JsonField<List<Personalization>>,
    private val success: JsonField<Success>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("personalizations")
        @ExcludeMissing
        personalizations: JsonField<List<Personalization>> = JsonMissing.of(),
        @JsonProperty("success") @ExcludeMissing success: JsonField<Success> = JsonMissing.of(),
    ) : this(personalizations, success, mutableMapOf())

    /**
     * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun personalizations(): List<Personalization> = personalizations.getRequired("personalizations")

    /**
     * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun success(): Success = success.getRequired("success")

    /**
     * Returns the raw JSON value of [personalizations].
     *
     * Unlike [personalizations], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("personalizations")
    @ExcludeMissing
    fun _personalizations(): JsonField<List<Personalization>> = personalizations

    /**
     * Returns the raw JSON value of [success].
     *
     * Unlike [success], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("success") @ExcludeMissing fun _success(): JsonField<Success> = success

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
         * Returns a mutable builder for constructing an instance of
         * [ExperimentPersonalizationResponse].
         *
         * The following fields are required:
         * ```kotlin
         * .personalizations()
         * .success()
         * ```
         */
        fun builder() = Builder()
    }

    /** A builder for [ExperimentPersonalizationResponse]. */
    class Builder internal constructor() {

        private var personalizations: JsonField<MutableList<Personalization>>? = null
        private var success: JsonField<Success>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(experimentPersonalizationResponse: ExperimentPersonalizationResponse) =
            apply {
                personalizations =
                    experimentPersonalizationResponse.personalizations.map { it.toMutableList() }
                success = experimentPersonalizationResponse.success
                additionalProperties =
                    experimentPersonalizationResponse.additionalProperties.toMutableMap()
            }

        fun personalizations(personalizations: List<Personalization>) =
            personalizations(JsonField.of(personalizations))

        /**
         * Sets [Builder.personalizations] to an arbitrary JSON value.
         *
         * You should usually call [Builder.personalizations] with a well-typed
         * `List<Personalization>` value instead. This method is primarily for setting the field to
         * an undocumented or not yet supported value.
         */
        fun personalizations(personalizations: JsonField<List<Personalization>>) = apply {
            this.personalizations = personalizations.map { it.toMutableList() }
        }

        /**
         * Adds a single [Personalization] to [personalizations].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addPersonalization(personalization: Personalization) = apply {
            personalizations =
                (personalizations ?: JsonField.of(mutableListOf())).also {
                    checkKnown("personalizations", it).add(personalization)
                }
        }

        fun success(success: Success) = success(JsonField.of(success))

        /**
         * Sets [Builder.success] to an arbitrary JSON value.
         *
         * You should usually call [Builder.success] with a well-typed [Success] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun success(success: JsonField<Success>) = apply { this.success = success }

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
         * Returns an immutable instance of [ExperimentPersonalizationResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```kotlin
         * .personalizations()
         * .success()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ExperimentPersonalizationResponse =
            ExperimentPersonalizationResponse(
                checkRequired("personalizations", personalizations).map { it.toImmutable() },
                checkRequired("success", success),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OursPrivacyInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): ExperimentPersonalizationResponse = apply {
        if (validated) {
            return@apply
        }

        personalizations().forEach { it.validate() }
        success().validate()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    internal fun validity(): Int =
        (personalizations.asKnown()?.sumOf { it.validity().toInt() } ?: 0) +
            (success.asKnown()?.validity() ?: 0)

    class Personalization
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val assignedAt: JsonField<Double>,
        private val experimentId: JsonField<String>,
        private val variantId: JsonField<String>,
        private val experimentKey: JsonField<String>,
        private val experimentName: JsonField<String>,
        private val variantName: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("assigned_at")
            @ExcludeMissing
            assignedAt: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("experiment_id")
            @ExcludeMissing
            experimentId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("variant_id")
            @ExcludeMissing
            variantId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("experiment_key")
            @ExcludeMissing
            experimentKey: JsonField<String> = JsonMissing.of(),
            @JsonProperty("experiment_name")
            @ExcludeMissing
            experimentName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("variant_name")
            @ExcludeMissing
            variantName: JsonField<String> = JsonMissing.of(),
        ) : this(
            assignedAt,
            experimentId,
            variantId,
            experimentKey,
            experimentName,
            variantName,
            mutableMapOf(),
        )

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun assignedAt(): Double = assignedAt.getRequired("assigned_at")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun experimentId(): String = experimentId.getRequired("experiment_id")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun variantId(): String = variantId.getRequired("variant_id")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun experimentKey(): String? = experimentKey.getNullable("experiment_key")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun experimentName(): String? = experimentName.getNullable("experiment_name")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun variantName(): String? = variantName.getNullable("variant_name")

        /**
         * Returns the raw JSON value of [assignedAt].
         *
         * Unlike [assignedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("assigned_at")
        @ExcludeMissing
        fun _assignedAt(): JsonField<Double> = assignedAt

        /**
         * Returns the raw JSON value of [experimentId].
         *
         * Unlike [experimentId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("experiment_id")
        @ExcludeMissing
        fun _experimentId(): JsonField<String> = experimentId

        /**
         * Returns the raw JSON value of [variantId].
         *
         * Unlike [variantId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("variant_id") @ExcludeMissing fun _variantId(): JsonField<String> = variantId

        /**
         * Returns the raw JSON value of [experimentKey].
         *
         * Unlike [experimentKey], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("experiment_key")
        @ExcludeMissing
        fun _experimentKey(): JsonField<String> = experimentKey

        /**
         * Returns the raw JSON value of [experimentName].
         *
         * Unlike [experimentName], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("experiment_name")
        @ExcludeMissing
        fun _experimentName(): JsonField<String> = experimentName

        /**
         * Returns the raw JSON value of [variantName].
         *
         * Unlike [variantName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("variant_name")
        @ExcludeMissing
        fun _variantName(): JsonField<String> = variantName

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
             * Returns a mutable builder for constructing an instance of [Personalization].
             *
             * The following fields are required:
             * ```kotlin
             * .assignedAt()
             * .experimentId()
             * .variantId()
             * ```
             */
            fun builder() = Builder()
        }

        /** A builder for [Personalization]. */
        class Builder internal constructor() {

            private var assignedAt: JsonField<Double>? = null
            private var experimentId: JsonField<String>? = null
            private var variantId: JsonField<String>? = null
            private var experimentKey: JsonField<String> = JsonMissing.of()
            private var experimentName: JsonField<String> = JsonMissing.of()
            private var variantName: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(personalization: Personalization) = apply {
                assignedAt = personalization.assignedAt
                experimentId = personalization.experimentId
                variantId = personalization.variantId
                experimentKey = personalization.experimentKey
                experimentName = personalization.experimentName
                variantName = personalization.variantName
                additionalProperties = personalization.additionalProperties.toMutableMap()
            }

            fun assignedAt(assignedAt: Double) = assignedAt(JsonField.of(assignedAt))

            /**
             * Sets [Builder.assignedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.assignedAt] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun assignedAt(assignedAt: JsonField<Double>) = apply { this.assignedAt = assignedAt }

            fun experimentId(experimentId: String) = experimentId(JsonField.of(experimentId))

            /**
             * Sets [Builder.experimentId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.experimentId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun experimentId(experimentId: JsonField<String>) = apply {
                this.experimentId = experimentId
            }

            fun variantId(variantId: String) = variantId(JsonField.of(variantId))

            /**
             * Sets [Builder.variantId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.variantId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun variantId(variantId: JsonField<String>) = apply { this.variantId = variantId }

            fun experimentKey(experimentKey: String?) =
                experimentKey(JsonField.ofNullable(experimentKey))

            /**
             * Sets [Builder.experimentKey] to an arbitrary JSON value.
             *
             * You should usually call [Builder.experimentKey] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun experimentKey(experimentKey: JsonField<String>) = apply {
                this.experimentKey = experimentKey
            }

            fun experimentName(experimentName: String?) =
                experimentName(JsonField.ofNullable(experimentName))

            /**
             * Sets [Builder.experimentName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.experimentName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun experimentName(experimentName: JsonField<String>) = apply {
                this.experimentName = experimentName
            }

            fun variantName(variantName: String?) = variantName(JsonField.ofNullable(variantName))

            /**
             * Sets [Builder.variantName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.variantName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun variantName(variantName: JsonField<String>) = apply {
                this.variantName = variantName
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
             * Returns an immutable instance of [Personalization].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```kotlin
             * .assignedAt()
             * .experimentId()
             * .variantId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Personalization =
                Personalization(
                    checkRequired("assignedAt", assignedAt),
                    checkRequired("experimentId", experimentId),
                    checkRequired("variantId", variantId),
                    experimentKey,
                    experimentName,
                    variantName,
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
        fun validate(): Personalization = apply {
            if (validated) {
                return@apply
            }

            assignedAt()
            experimentId()
            variantId()
            experimentKey()
            experimentName()
            variantName()
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
            (if (assignedAt.asKnown() == null) 0 else 1) +
                (if (experimentId.asKnown() == null) 0 else 1) +
                (if (variantId.asKnown() == null) 0 else 1) +
                (if (experimentKey.asKnown() == null) 0 else 1) +
                (if (experimentName.asKnown() == null) 0 else 1) +
                (if (variantName.asKnown() == null) 0 else 1)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Personalization &&
                assignedAt == other.assignedAt &&
                experimentId == other.experimentId &&
                variantId == other.variantId &&
                experimentKey == other.experimentKey &&
                experimentName == other.experimentName &&
                variantName == other.variantName &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                assignedAt,
                experimentId,
                variantId,
                experimentKey,
                experimentName,
                variantName,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Personalization{assignedAt=$assignedAt, experimentId=$experimentId, variantId=$variantId, experimentKey=$experimentKey, experimentName=$experimentName, variantName=$variantName, additionalProperties=$additionalProperties}"
    }

    class Success @JsonCreator private constructor(private val value: JsonField<Boolean>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<Boolean> = value

        companion object {

            val TRUE = of(true)

            fun of(value: Boolean) = Success(JsonField.of(value))
        }

        /** An enum containing [Success]'s known values. */
        enum class Known {
            TRUE
        }

        /**
         * An enum containing [Success]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Success] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            TRUE,
            /** An enum member indicating that [Success] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                TRUE -> Value.TRUE
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OursPrivacyInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                TRUE -> Known.TRUE
                else -> throw OursPrivacyInvalidDataException("Unknown Success: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * @throws OursPrivacyInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asBoolean(): Boolean =
            _value().asBoolean() ?: throw OursPrivacyInvalidDataException("Value is not a Boolean")

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
        fun validate(): Success = apply {
            if (validated) {
                return@apply
            }

            known()
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
        internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Success && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExperimentPersonalizationResponse &&
            personalizations == other.personalizations &&
            success == other.success &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(personalizations, success, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ExperimentPersonalizationResponse{personalizations=$personalizations, success=$success, additionalProperties=$additionalProperties}"
}
