// File generated from our OpenAPI spec by Stainless.

package com.oursprivacy.models.experiments

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.oursprivacy.core.BaseDeserializer
import com.oursprivacy.core.BaseSerializer
import com.oursprivacy.core.Enum
import com.oursprivacy.core.ExcludeMissing
import com.oursprivacy.core.JsonField
import com.oursprivacy.core.JsonMissing
import com.oursprivacy.core.JsonValue
import com.oursprivacy.core.allMaxBy
import com.oursprivacy.core.checkRequired
import com.oursprivacy.core.getOrThrow
import com.oursprivacy.errors.OursPrivacyInvalidDataException
import java.util.Collections
import java.util.Objects

@JsonDeserialize(using = ExperimentAssignmentResponse.Deserializer::class)
@JsonSerialize(using = ExperimentAssignmentResponse.Serializer::class)
class ExperimentAssignmentResponse
private constructor(
    private val unionMember0: UnionMember0? = null,
    private val unionMember1: UnionMember1? = null,
    private val _json: JsonValue? = null,
) {

    fun unionMember0(): UnionMember0? = unionMember0

    fun unionMember1(): UnionMember1? = unionMember1

    fun isUnionMember0(): Boolean = unionMember0 != null

    fun isUnionMember1(): Boolean = unionMember1 != null

    fun asUnionMember0(): UnionMember0 = unionMember0.getOrThrow("unionMember0")

    fun asUnionMember1(): UnionMember1 = unionMember1.getOrThrow("unionMember1")

    fun _json(): JsonValue? = _json

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```kotlin
     * import com.oursprivacy.core.JsonValue
     *
     * val result: String? = experimentAssignmentResponse.accept(object : ExperimentAssignmentResponse.Visitor<String?> {
     *     override fun visitUnionMember0(unionMember0: UnionMember0): String? = unionMember0.toString()
     *
     *     // ...
     *
     *     override fun unknown(json: JsonValue?): String? {
     *         // Or inspect the `json`.
     *         return null
     *     }
     * })
     * ```
     *
     * @throws OursPrivacyInvalidDataException if [Visitor.unknown] is not overridden in [visitor]
     *   and the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            unionMember0 != null -> visitor.visitUnionMember0(unionMember0)
            unionMember1 != null -> visitor.visitUnionMember1(unionMember1)
            else -> visitor.unknown(_json)
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
    fun validate(): ExperimentAssignmentResponse = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitUnionMember0(unionMember0: UnionMember0) {
                    unionMember0.validate()
                }

                override fun visitUnionMember1(unionMember1: UnionMember1) {
                    unionMember1.validate()
                }
            }
        )
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
        accept(
            object : Visitor<Int> {
                override fun visitUnionMember0(unionMember0: UnionMember0) = unionMember0.validity()

                override fun visitUnionMember1(unionMember1: UnionMember1) = unionMember1.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExperimentAssignmentResponse &&
            unionMember0 == other.unionMember0 &&
            unionMember1 == other.unionMember1
    }

    override fun hashCode(): Int = Objects.hash(unionMember0, unionMember1)

    override fun toString(): String =
        when {
            unionMember0 != null -> "ExperimentAssignmentResponse{unionMember0=$unionMember0}"
            unionMember1 != null -> "ExperimentAssignmentResponse{unionMember1=$unionMember1}"
            _json != null -> "ExperimentAssignmentResponse{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ExperimentAssignmentResponse")
        }

    companion object {

        fun ofUnionMember0(unionMember0: UnionMember0) =
            ExperimentAssignmentResponse(unionMember0 = unionMember0)

        fun ofUnionMember1(unionMember1: UnionMember1) =
            ExperimentAssignmentResponse(unionMember1 = unionMember1)
    }

    /**
     * An interface that defines how to map each variant of [ExperimentAssignmentResponse] to a
     * value of type [T].
     */
    interface Visitor<out T> {

        fun visitUnionMember0(unionMember0: UnionMember0): T

        fun visitUnionMember1(unionMember1: UnionMember1): T

        /**
         * Maps an unknown variant of [ExperimentAssignmentResponse] to a value of type [T].
         *
         * An instance of [ExperimentAssignmentResponse] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OursPrivacyInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OursPrivacyInvalidDataException("Unknown ExperimentAssignmentResponse: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<ExperimentAssignmentResponse>(ExperimentAssignmentResponse::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ExperimentAssignmentResponse {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<UnionMember0>())?.let {
                            ExperimentAssignmentResponse(unionMember0 = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<UnionMember1>())?.let {
                            ExperimentAssignmentResponse(unionMember1 = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> ExperimentAssignmentResponse(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer :
        BaseSerializer<ExperimentAssignmentResponse>(ExperimentAssignmentResponse::class) {

        override fun serialize(
            value: ExperimentAssignmentResponse,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.unionMember0 != null -> generator.writeObject(value.unionMember0)
                value.unionMember1 != null -> generator.writeObject(value.unionMember1)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ExperimentAssignmentResponse")
            }
        }
    }

    class UnionMember0
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val experimentId: JsonField<String>,
        private val inExperiment: JsonField<InExperiment>,
        private val success: JsonField<Success>,
        private val variantId: JsonField<String>,
        private val experimentKey: JsonField<String>,
        private val experimentName: JsonField<String>,
        private val isControl: JsonField<Boolean>,
        private val redirect: JsonField<String>,
        private val type: JsonField<String>,
        private val variantName: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("experiment_id")
            @ExcludeMissing
            experimentId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("in_experiment")
            @ExcludeMissing
            inExperiment: JsonField<InExperiment> = JsonMissing.of(),
            @JsonProperty("success") @ExcludeMissing success: JsonField<Success> = JsonMissing.of(),
            @JsonProperty("variant_id")
            @ExcludeMissing
            variantId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("experiment_key")
            @ExcludeMissing
            experimentKey: JsonField<String> = JsonMissing.of(),
            @JsonProperty("experiment_name")
            @ExcludeMissing
            experimentName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("is_control")
            @ExcludeMissing
            isControl: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("redirect")
            @ExcludeMissing
            redirect: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonField<String> = JsonMissing.of(),
            @JsonProperty("variant_name")
            @ExcludeMissing
            variantName: JsonField<String> = JsonMissing.of(),
        ) : this(
            experimentId,
            inExperiment,
            success,
            variantId,
            experimentKey,
            experimentName,
            isControl,
            redirect,
            type,
            variantName,
            mutableMapOf(),
        )

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun experimentId(): String = experimentId.getRequired("experiment_id")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun inExperiment(): InExperiment = inExperiment.getRequired("in_experiment")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun success(): Success = success.getRequired("success")

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
        fun isControl(): Boolean? = isControl.getNullable("is_control")

        /**
         * Redirect destination for redirect (split-URL) variants — a same-domain relative path or
         * an absolute https:// URL. Present only when the assigned variant is a redirect; absent
         * for on-page (DOM-modification) variants. Read it straight off the payload and issue the
         * redirect server-side.
         *
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun redirect(): String? = redirect.getNullable("redirect")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun type(): String? = type.getNullable("type")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun variantName(): String? = variantName.getNullable("variant_name")

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
         * Returns the raw JSON value of [inExperiment].
         *
         * Unlike [inExperiment], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("in_experiment")
        @ExcludeMissing
        fun _inExperiment(): JsonField<InExperiment> = inExperiment

        /**
         * Returns the raw JSON value of [success].
         *
         * Unlike [success], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("success") @ExcludeMissing fun _success(): JsonField<Success> = success

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
         * Returns the raw JSON value of [isControl].
         *
         * Unlike [isControl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("is_control") @ExcludeMissing fun _isControl(): JsonField<Boolean> = isControl

        /**
         * Returns the raw JSON value of [redirect].
         *
         * Unlike [redirect], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("redirect") @ExcludeMissing fun _redirect(): JsonField<String> = redirect

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

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
             * Returns a mutable builder for constructing an instance of [UnionMember0].
             *
             * The following fields are required:
             * ```kotlin
             * .experimentId()
             * .inExperiment()
             * .success()
             * .variantId()
             * ```
             */
            fun builder() = Builder()
        }

        /** A builder for [UnionMember0]. */
        class Builder internal constructor() {

            private var experimentId: JsonField<String>? = null
            private var inExperiment: JsonField<InExperiment>? = null
            private var success: JsonField<Success>? = null
            private var variantId: JsonField<String>? = null
            private var experimentKey: JsonField<String> = JsonMissing.of()
            private var experimentName: JsonField<String> = JsonMissing.of()
            private var isControl: JsonField<Boolean> = JsonMissing.of()
            private var redirect: JsonField<String> = JsonMissing.of()
            private var type: JsonField<String> = JsonMissing.of()
            private var variantName: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(unionMember0: UnionMember0) = apply {
                experimentId = unionMember0.experimentId
                inExperiment = unionMember0.inExperiment
                success = unionMember0.success
                variantId = unionMember0.variantId
                experimentKey = unionMember0.experimentKey
                experimentName = unionMember0.experimentName
                isControl = unionMember0.isControl
                redirect = unionMember0.redirect
                type = unionMember0.type
                variantName = unionMember0.variantName
                additionalProperties = unionMember0.additionalProperties.toMutableMap()
            }

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

            fun inExperiment(inExperiment: InExperiment) = inExperiment(JsonField.of(inExperiment))

            /**
             * Sets [Builder.inExperiment] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inExperiment] with a well-typed [InExperiment] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun inExperiment(inExperiment: JsonField<InExperiment>) = apply {
                this.inExperiment = inExperiment
            }

            fun success(success: Success) = success(JsonField.of(success))

            /**
             * Sets [Builder.success] to an arbitrary JSON value.
             *
             * You should usually call [Builder.success] with a well-typed [Success] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun success(success: JsonField<Success>) = apply { this.success = success }

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

            fun isControl(isControl: Boolean?) = isControl(JsonField.ofNullable(isControl))

            /**
             * Alias for [Builder.isControl].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun isControl(isControl: Boolean) = isControl(isControl as Boolean?)

            /**
             * Sets [Builder.isControl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isControl] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isControl(isControl: JsonField<Boolean>) = apply { this.isControl = isControl }

            /**
             * Redirect destination for redirect (split-URL) variants — a same-domain relative path
             * or an absolute https:// URL. Present only when the assigned variant is a redirect;
             * absent for on-page (DOM-modification) variants. Read it straight off the payload and
             * issue the redirect server-side.
             */
            fun redirect(redirect: String?) = redirect(JsonField.ofNullable(redirect))

            /**
             * Sets [Builder.redirect] to an arbitrary JSON value.
             *
             * You should usually call [Builder.redirect] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun redirect(redirect: JsonField<String>) = apply { this.redirect = redirect }

            fun type(type: String?) = type(JsonField.ofNullable(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<String>) = apply { this.type = type }

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
             * Returns an immutable instance of [UnionMember0].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```kotlin
             * .experimentId()
             * .inExperiment()
             * .success()
             * .variantId()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): UnionMember0 =
                UnionMember0(
                    checkRequired("experimentId", experimentId),
                    checkRequired("inExperiment", inExperiment),
                    checkRequired("success", success),
                    checkRequired("variantId", variantId),
                    experimentKey,
                    experimentName,
                    isControl,
                    redirect,
                    type,
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
        fun validate(): UnionMember0 = apply {
            if (validated) {
                return@apply
            }

            experimentId()
            inExperiment().validate()
            success().validate()
            variantId()
            experimentKey()
            experimentName()
            isControl()
            redirect()
            type()
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
            (if (experimentId.asKnown() == null) 0 else 1) +
                (inExperiment.asKnown()?.validity() ?: 0) +
                (success.asKnown()?.validity() ?: 0) +
                (if (variantId.asKnown() == null) 0 else 1) +
                (if (experimentKey.asKnown() == null) 0 else 1) +
                (if (experimentName.asKnown() == null) 0 else 1) +
                (if (isControl.asKnown() == null) 0 else 1) +
                (if (redirect.asKnown() == null) 0 else 1) +
                (if (type.asKnown() == null) 0 else 1) +
                (if (variantName.asKnown() == null) 0 else 1)

        class InExperiment @JsonCreator private constructor(private val value: JsonField<Boolean>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<Boolean> = value

            companion object {

                val TRUE = of(true)

                fun of(value: Boolean) = InExperiment(JsonField.of(value))
            }

            /** An enum containing [InExperiment]'s known values. */
            enum class Known {
                TRUE
            }

            /**
             * An enum containing [InExperiment]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [InExperiment] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TRUE,
                /**
                 * An enum member indicating that [InExperiment] was instantiated with an unknown
                 * value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    TRUE -> Value.TRUE
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OursPrivacyInvalidDataException if this class instance's value is a not a
             *   known member.
             */
            fun known(): Known =
                when (this) {
                    TRUE -> Known.TRUE
                    else -> throw OursPrivacyInvalidDataException("Unknown InExperiment: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * @throws OursPrivacyInvalidDataException if this class instance's value does not have
             *   the expected primitive type.
             */
            fun asBoolean(): Boolean =
                _value().asBoolean()
                    ?: throw OursPrivacyInvalidDataException("Value is not a Boolean")

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OursPrivacyInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): InExperiment = apply {
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

                return other is InExperiment && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class Success @JsonCreator private constructor(private val value: JsonField<Boolean>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TRUE,
                /**
                 * An enum member indicating that [Success] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    TRUE -> Value.TRUE
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OursPrivacyInvalidDataException if this class instance's value is a not a
             *   known member.
             */
            fun known(): Known =
                when (this) {
                    TRUE -> Known.TRUE
                    else -> throw OursPrivacyInvalidDataException("Unknown Success: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * @throws OursPrivacyInvalidDataException if this class instance's value does not have
             *   the expected primitive type.
             */
            fun asBoolean(): Boolean =
                _value().asBoolean()
                    ?: throw OursPrivacyInvalidDataException("Value is not a Boolean")

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OursPrivacyInvalidDataException if any value type in this object doesn't
             *   match its expected type.
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

            return other is UnionMember0 &&
                experimentId == other.experimentId &&
                inExperiment == other.inExperiment &&
                success == other.success &&
                variantId == other.variantId &&
                experimentKey == other.experimentKey &&
                experimentName == other.experimentName &&
                isControl == other.isControl &&
                redirect == other.redirect &&
                type == other.type &&
                variantName == other.variantName &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                experimentId,
                inExperiment,
                success,
                variantId,
                experimentKey,
                experimentName,
                isControl,
                redirect,
                type,
                variantName,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UnionMember0{experimentId=$experimentId, inExperiment=$inExperiment, success=$success, variantId=$variantId, experimentKey=$experimentKey, experimentName=$experimentName, isControl=$isControl, redirect=$redirect, type=$type, variantName=$variantName, additionalProperties=$additionalProperties}"
    }

    class UnionMember1
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val inExperiment: JsonField<InExperiment>,
        private val success: JsonField<Success>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("in_experiment")
            @ExcludeMissing
            inExperiment: JsonField<InExperiment> = JsonMissing.of(),
            @JsonProperty("success") @ExcludeMissing success: JsonField<Success> = JsonMissing.of(),
        ) : this(inExperiment, success, mutableMapOf())

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun inExperiment(): InExperiment = inExperiment.getRequired("in_experiment")

        /**
         * @throws OursPrivacyInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun success(): Success = success.getRequired("success")

        /**
         * Returns the raw JSON value of [inExperiment].
         *
         * Unlike [inExperiment], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("in_experiment")
        @ExcludeMissing
        fun _inExperiment(): JsonField<InExperiment> = inExperiment

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
             * Returns a mutable builder for constructing an instance of [UnionMember1].
             *
             * The following fields are required:
             * ```kotlin
             * .inExperiment()
             * .success()
             * ```
             */
            fun builder() = Builder()
        }

        /** A builder for [UnionMember1]. */
        class Builder internal constructor() {

            private var inExperiment: JsonField<InExperiment>? = null
            private var success: JsonField<Success>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(unionMember1: UnionMember1) = apply {
                inExperiment = unionMember1.inExperiment
                success = unionMember1.success
                additionalProperties = unionMember1.additionalProperties.toMutableMap()
            }

            fun inExperiment(inExperiment: InExperiment) = inExperiment(JsonField.of(inExperiment))

            /**
             * Sets [Builder.inExperiment] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inExperiment] with a well-typed [InExperiment] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun inExperiment(inExperiment: JsonField<InExperiment>) = apply {
                this.inExperiment = inExperiment
            }

            fun success(success: Success) = success(JsonField.of(success))

            /**
             * Sets [Builder.success] to an arbitrary JSON value.
             *
             * You should usually call [Builder.success] with a well-typed [Success] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * Returns an immutable instance of [UnionMember1].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```kotlin
             * .inExperiment()
             * .success()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): UnionMember1 =
                UnionMember1(
                    checkRequired("inExperiment", inExperiment),
                    checkRequired("success", success),
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
        fun validate(): UnionMember1 = apply {
            if (validated) {
                return@apply
            }

            inExperiment().validate()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        internal fun validity(): Int =
            (inExperiment.asKnown()?.validity() ?: 0) + (success.asKnown()?.validity() ?: 0)

        class InExperiment @JsonCreator private constructor(private val value: JsonField<Boolean>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<Boolean> = value

            companion object {

                val FALSE = of(false)

                fun of(value: Boolean) = InExperiment(JsonField.of(value))
            }

            /** An enum containing [InExperiment]'s known values. */
            enum class Known {
                FALSE
            }

            /**
             * An enum containing [InExperiment]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [InExperiment] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                FALSE,
                /**
                 * An enum member indicating that [InExperiment] was instantiated with an unknown
                 * value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    FALSE -> Value.FALSE
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OursPrivacyInvalidDataException if this class instance's value is a not a
             *   known member.
             */
            fun known(): Known =
                when (this) {
                    FALSE -> Known.FALSE
                    else -> throw OursPrivacyInvalidDataException("Unknown InExperiment: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * @throws OursPrivacyInvalidDataException if this class instance's value does not have
             *   the expected primitive type.
             */
            fun asBoolean(): Boolean =
                _value().asBoolean()
                    ?: throw OursPrivacyInvalidDataException("Value is not a Boolean")

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OursPrivacyInvalidDataException if any value type in this object doesn't
             *   match its expected type.
             */
            fun validate(): InExperiment = apply {
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

                return other is InExperiment && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class Success @JsonCreator private constructor(private val value: JsonField<Boolean>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TRUE,
                /**
                 * An enum member indicating that [Success] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    TRUE -> Value.TRUE
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OursPrivacyInvalidDataException if this class instance's value is a not a
             *   known member.
             */
            fun known(): Known =
                when (this) {
                    TRUE -> Known.TRUE
                    else -> throw OursPrivacyInvalidDataException("Unknown Success: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * @throws OursPrivacyInvalidDataException if this class instance's value does not have
             *   the expected primitive type.
             */
            fun asBoolean(): Boolean =
                _value().asBoolean()
                    ?: throw OursPrivacyInvalidDataException("Value is not a Boolean")

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OursPrivacyInvalidDataException if any value type in this object doesn't
             *   match its expected type.
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

            return other is UnionMember1 &&
                inExperiment == other.inExperiment &&
                success == other.success &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(inExperiment, success, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "UnionMember1{inExperiment=$inExperiment, success=$success, additionalProperties=$additionalProperties}"
    }
}
