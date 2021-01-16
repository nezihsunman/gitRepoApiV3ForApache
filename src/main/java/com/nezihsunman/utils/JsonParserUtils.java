package com.nezihsunman.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class JsonParserUtils {
    public static JSONArray inputStreamToJsonArray(InputStream inputStream) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        return (JSONArray) jsonParser.parse(
                new InputStreamReader(inputStream, "UTF-8"));
    }
    public static JSONObject inputStreamToJsonObject(InputStream inputStream) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        return (JSONObject) jsonParser.parse(
                new InputStreamReader(inputStream, "UTF-8"));
    }
}
