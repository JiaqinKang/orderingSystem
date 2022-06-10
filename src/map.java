import java.awt.*;

public class map {
    OkHttpClient client = new OkHttpClient().newBuilder()
            .build();
    PageAttributes.MediaType mediaType = PageAttributes.MediaType.parse("text/plain");
    RequestBody body = RequestBody.create(mediaType, "");
    Request request = new Request.Builder()
            .url("https://maps.googleapis.com/maps/api/distancematrix/json?origins=Washington%2C%20DC&destinations=New%20York%20City%2C%20NY&units=imperial&key=YOUR_API_KEY")
            .method("GET", body)
            .build();
    Response response = client.newCall(request).execute();
}
