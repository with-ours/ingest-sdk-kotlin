import com.oursprivacy.client.OursPrivacyClient;
import com.oursprivacy.client.okhttp.OursPrivacyOkHttpClient;
import com.oursprivacy.core.ObjectMappers;
import com.oursprivacy.models.track.TrackEventResponse;

public final class JavaConsumer {
    public static void main(String[] args) throws Exception {
        if (!"1.8".equals(System.getProperty("java.specification.version"))) {
            throw new AssertionError("Expected Java 8");
        }
        TrackEventResponse response = TrackEventResponse.Companion.builder()
                .success(TrackEventResponse.Success.Companion.getTRUE()).build();
        String json = ObjectMappers.jsonMapper().writeValueAsString(response);
        if (!response.equals(ObjectMappers.jsonMapper().readValue(json, TrackEventResponse.class))) {
            throw new AssertionError("JSON round trip failed");
        }
        OursPrivacyClient client = OursPrivacyOkHttpClient.Companion.builder().build();
        try {
            if (client.track() == null || client.async().track() == null) {
                throw new AssertionError("Client construction failed");
            }
        } finally {
            client.close();
        }
        System.out.println("Java consumer passed on Java 8");
    }
}
