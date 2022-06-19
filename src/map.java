//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.RequestBody;
//import okhttp3.Response;
//
//import java.awt.*;
//
//public class map {
//    String api = configs.getGoogleMapAPIKey();
//
//
//    OkHttpClient client = new OkHttpClient().newBuilder()
//            .build();
//    PageAttributes.MediaType mediaType = PageAttributes.MediaType.parse("text/plain");
//    RequestBody body = RequestBody.create(mediaType, "");
//    Request request = new Request.Builder()
//            .url("https://maps.googleapis.com/maps/api/distancematrix/json?origins=Washington%2C%20DC&destinations=New%20York%20City%2C%20NY&units=imperial&key=" + api)
//            .method("GET", body)
//            .build();
//    Response response = client.newCall(request).execute();
//
//
//}
