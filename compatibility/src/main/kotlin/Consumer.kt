import com.oursprivacy.client.okhttp.OursPrivacyOkHttpClient
import com.oursprivacy.core.jsonMapper
import com.oursprivacy.models.track.TrackEventResponse

fun main() {
    check(System.getProperty("java.specification.version") == "1.8")
    val response = TrackEventResponse.builder().success(TrackEventResponse.Success.TRUE).build()
    val mapper = jsonMapper()
    check(mapper.readValue(mapper.writeValueAsString(response), TrackEventResponse::class.java) == response)
    val client = OursPrivacyOkHttpClient.builder().build()
    try {
        client.track()
        client.async().track()
    } finally {
        client.close()
    }
    println("Kotlin 1.8 consumer passed on Java 8")
}
