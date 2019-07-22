package com.ccsia.demo.model.params;

import com.ccsia.demo.model.business.ApplyInfo;

public class ApplicantParams {

    private String client_id;
    private String access_token;
    private String title;
    private ApplyInfo content;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ApplyInfo getContent() {
        return content;
    }

    public void setContent(ApplyInfo content) {
        this.content = content;
    }
}
