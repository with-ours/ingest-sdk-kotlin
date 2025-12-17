// File generated from our OpenAPI spec by Stainless.

package com.ours_privacy.api.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.ours_privacy.api.client.OursPrivacyClient
import com.ours_privacy.api.client.okhttp.OursPrivacyOkHttpClient
import com.ours_privacy.api.core.JsonValue
import com.ours_privacy.api.models.track.TrackEventParams
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ServiceParamsTest {

    private lateinit var client: OursPrivacyClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client = OursPrivacyOkHttpClient.builder().baseUrl(wmRuntimeInfo.httpBaseUrl).build()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun event() {
        val trackService = client.track()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

        trackService.event(
            TrackEventParams.builder()
                .token("x")
                .event("x")
                .defaultProperties(
                    TrackEventParams.DefaultProperties.builder()
                        .activeDuration(0.0)
                        .adId("ad_id")
                        .adsetId("adset_id")
                        .alart("alart")
                        .aleid("aleid")
                        .basisCid("basis_cid")
                        .browserLanguage("browser_language")
                        .browserName("browser_name")
                        .browserVersion("browser_version")
                        .campaignId("campaign_id")
                        .clickid("clickid")
                        .clid("clid")
                        .cpuArchitecture("cpu_architecture")
                        .currentUrl("current_url")
                        .dclid("dclid")
                        .deviceModel("device_model")
                        .deviceType("device_type")
                        .deviceVendor("device_vendor")
                        .duration(0.0)
                        .encoding("encoding")
                        .engineName("engine_name")
                        .engineVersion("engine_version")
                        .epik("epik")
                        .fbc("fbc")
                        .fbclid("fbclid")
                        .fbp("fbp")
                        .fv(true)
                        .gadSource("gad_source")
                        .gbraid("gbraid")
                        .gclid("gclid")
                        .host("host")
                        .iframe(true)
                        .imRef("im_ref")
                        .ip("ip")
                        .irclickid("irclickid")
                        .isBot("is_bot")
                        .liFatId("li_fat_id")
                        .msclkid("msclkid")
                        .ndclid("ndclid")
                        .newS(true)
                        .osName("os_name")
                        .osVersion("os_version")
                        .pageHash(0.0)
                        .pathname("pathname")
                        .qclid("qclid")
                        .rdtCid("rdt_cid")
                        .receivedAt("received_at")
                        .referrer("referrer")
                        .referringDomain("referring_domain")
                        .sacid("sacid")
                        .sccid("sccid")
                        .screenHeight(0.0)
                        .screenWidth(0.0)
                        .sessionCount(0.0)
                        .sid("sid")
                        .sr("sr")
                        .title("title")
                        .ttclid("ttclid")
                        .twclid("twclid")
                        .uafvl("uafvl")
                        .userAgent("user_agent")
                        .utmCampaign("utm_campaign")
                        .utmContent("utm_content")
                        .utmMedium("utm_medium")
                        .utmName("utm_name")
                        .utmSource("utm_source")
                        .utmTerm("utm_term")
                        .version("version")
                        .wbraid("wbraid")
                        .webview(true)
                        .build()
                )
                .distinctId("x")
                .email("x")
                .eventProperties(
                    TrackEventParams.EventProperties.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .externalId("x")
                .time(0.0)
                .userId("x")
                .userProperties(
                    TrackEventParams.UserProperties.builder()
                        .adId("ad_id")
                        .adsetId("adset_id")
                        .alart("alart")
                        .aleid("aleid")
                        .basisCid("basis_cid")
                        .campaignId("campaign_id")
                        .city("city")
                        .clickid("clickid")
                        .clid("clid")
                        .companyName("company_name")
                        .consent(
                            TrackEventParams.UserProperties.Consent.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .country("country")
                        .customProperties(
                            TrackEventParams.UserProperties.CustomProperties.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .dateOfBirth("date_of_birth")
                        .dclid("dclid")
                        .email("email")
                        .epik("epik")
                        .externalId("external_id")
                        .fbc("fbc")
                        .fbclid("fbclid")
                        .fbp("fbp")
                        .firstName("first_name")
                        .gadSource("gad_source")
                        .gbraid("gbraid")
                        .gclid("gclid")
                        .gender("gender")
                        .imRef("im_ref")
                        .ip("ip")
                        .irclickid("irclickid")
                        .isBot("is_bot")
                        .jobTitle("job_title")
                        .lastName("last_name")
                        .liFatId("li_fat_id")
                        .msclkid("msclkid")
                        .ndclid("ndclid")
                        .phoneNumber("phone_number")
                        .qclid("qclid")
                        .rdtCid("rdt_cid")
                        .referrer("referrer")
                        .referringDomain("referring_domain")
                        .sacid("sacid")
                        .sccid("sccid")
                        .sid("sid")
                        .state("state")
                        .ttclid("ttclid")
                        .twclid("twclid")
                        .userAgent("user_agent")
                        .userAgentFullList("user_agent_full_list")
                        .utmCampaign("utm_campaign")
                        .utmContent("utm_content")
                        .utmMedium("utm_medium")
                        .utmName("utm_name")
                        .utmSource("utm_source")
                        .utmTerm("utm_term")
                        .wbraid("wbraid")
                        .zip("zip")
                        .build()
                )
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
                .withRequestBody(matchingJsonPath("$.secretProperty", equalTo("42")))
        )
    }
}
