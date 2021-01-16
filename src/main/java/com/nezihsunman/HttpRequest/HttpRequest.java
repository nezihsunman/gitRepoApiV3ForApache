package com.nezihsunman.HttpRequest;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class HttpRequest {
    private static String basicAuth = "token " + "54ae23c509879a3bc7865face8a0246d81f1fdaa";

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
            throw new RuntimeException();
        }
    }
}
