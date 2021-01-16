package com.nezihsunman.resource;

import org.json.simple.JSONObject;

public class Contributors {

    private final String loginName;
    private final Long id;
    private final Long contributions;

    public Contributors(String login, Long id, Long contributions) {
        this.loginName = login;
        this.id = id;
        this.contributions = contributions;
    }

    public Long getContributions() {
        return contributions;
    }

    public String getLoginName() {
        return loginName;
    }

    public Long getId() {
        return id;
    }

    public static Contributors convert(JSONObject raw) {
        Long id = (Long) raw.get("id");
        String login = (String) raw.get("login");
        Long contributions = (Long) raw.get("contributions");
        return new Contributors(login, id, contributions);
    }

}
