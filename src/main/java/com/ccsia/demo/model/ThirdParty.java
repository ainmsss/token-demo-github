package com.ccsia.demo.model;

public class ThirdParty {

    private String id;

    private String client_id;

    private String client_secret;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public ThirdParty(String client_id) {
        this.client_id = client_id;
    }
}
