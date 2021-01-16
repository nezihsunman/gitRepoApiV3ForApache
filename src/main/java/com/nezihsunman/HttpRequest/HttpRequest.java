package com.nezihsunman.HttpRequest;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class HttpRequest {
    private static String basicAuth = "token " + "757b55e6c08ad07e5942711bdbdfcb758c96ef70 ";

    public static InputStream sendHttpRequest(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Authorization", basicAuth);
        httpURLConnection.setRequestProperty("accept", "application/vnd.github.v3+json");
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            return httpURLConnection.getInputStream();
        } else {
            throw new RuntimeException("Http error" + responseCode);
        }
    }
}
