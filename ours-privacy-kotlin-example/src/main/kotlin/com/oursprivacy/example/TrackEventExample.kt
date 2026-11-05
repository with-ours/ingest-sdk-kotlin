// Send one track event to Ours Privacy and print the result.
//
// Run from the repository root with your Source token:
//   export OURS_PRIVACY_TOKEN=your-source-token
//   ./gradlew :ours-privacy-kotlin-example:run -Pexample=TrackEvent
// Events go to production unless OURS_PRIVACY_BASE_URL is set.
// Sample values only. Do not put personal or health data in event properties.
package com.oursprivacy.example

import com.oursprivacy.client.okhttp.OursPrivacyOkHttpClient
import com.oursprivacy.core.JsonValue
import com.oursprivacy.models.track.TrackEventParams
import kotlin.system.exitProcess

fun main() {
    val token = System.getenv("OURS_PRIVACY_TOKEN")
    if (token.isNullOrEmpty()) {
        System.err.println("Set OURS_PRIVACY_TOKEN to your Source token")
        exitProcess(1)
    }

    val client = OursPrivacyOkHttpClient.fromEnv()

    val params =
        TrackEventParams.builder()
            .token(token)
            .event("Example Signup") // must be allowed on your Source
            .externalId("example-user-123") // your own identifier for this visitor
            .eventProperties(
                TrackEventParams.EventProperties.builder()
                    .putAdditionalProperty("plan", JsonValue.from("starter"))
                    .putAdditionalProperty("quantity", JsonValue.from(1))
                    .build()
            )
            .build()

    val response = client.track().event(params)
    println("tracked: ${response.success()}")

    client.close()
}
