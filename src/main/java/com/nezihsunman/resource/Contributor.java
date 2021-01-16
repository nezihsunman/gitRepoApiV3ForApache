package com.nezihsunman.resource;

import org.json.simple.JSONObject;

public class Contributor {

    private final String loginName;
    private final String name;
    private final Long id;
    private final String company;
    private final String location;

    public Contributor(String login, Long id, String name, String company, String location) {
        this.loginName = login;
        this.id = id;
        this.name = name;
        this.company = company;
        this.location = location;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public static Contributor convert(JSONObject raw) {
        Long id = (Long) raw.get("id");
        String login = (String) raw.get("login");
        Long contributions = (Long) raw.get("contributions");
        String name = (String) raw.get("name");
        String company = (String) raw.get("company");
        String location = (String) raw.get("location");
        return new Contributor(login, id, name, company, location);
    }

    @Override
    public String toString() {
        return "user:" + loginName + '\'' +
                ", name='" + name + '\'' +
                ", company:" + company + '\'' +
                ", location: " + location + '\'';
    }
}
