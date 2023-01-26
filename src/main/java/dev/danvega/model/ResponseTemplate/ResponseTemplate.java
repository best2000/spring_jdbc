package dev.danvega.model.ResponseTemplate;

import jdk.jshell.Snippet;

public class ResponseTemplate {

    private ResponseTemplateStatus status;
    private Object data;

    public ResponseTemplate(ResponseTemplateStatus status, Object data) {
        this.status = status;
        this.data = data;
    }

    public ResponseTemplateStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseTemplateStatus status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
