package com.nezihsunman.resource;

import org.json.simple.JSONObject;

public class Repository {

    private final Double id;
    private final String repoName;
    private final String full_name;
    private final Long forks_count;

    public Repository(Double id, String name, String full_name, Long forks_count) {
        this.id = id;
        this.repoName = name;
        this.full_name = full_name;
        this.forks_count = forks_count;
    }

    public Long getForksCount() {
        return forks_count;
    }

    public String getRepoName() {
        return repoName;
    }

    public static Repository convert(JSONObject raw) {
        Double id = Double.valueOf((Long) raw.get("id"));
        String name = (String) raw.get("name");
        String full_name = (String) raw.get("full_name");
        Long forks_count = (Long) raw.get("forks_count");
        return new Repository(id, name, full_name, forks_count);
    }

    @Override
    public String toString() {
        return "repo:'" + repoName + '\'' +
                ", forks_count:'" + forks_count + '\'' + " ";
    }
}
