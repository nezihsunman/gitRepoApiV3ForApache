package com.nezihsunman.Apis;

public class APIs {
    public static final String GET_URL = "https://api.github.com/orgs/apache/repos";
    public static final String GET_URL2 = "https://api.github.com/repos/apache/";
    public static final String GET_URL3 = "https://api.github.com/users/";

    public static String generateUrlForContributors(String contributorsName) {
        return APIs.GET_URL2 + contributorsName + "/contributors";
    }

    public static String generateUrlForUserName(String username) {
        return APIs.GET_URL3 + username;
    }
}
