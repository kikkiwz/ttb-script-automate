package com.ttbbank.oneapp.framework.client;

public class Status {
    private String code;
    private String message;
    private String service;
    private Description description;

    public void setCode(final String code) {
        this.code = code;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setService(final String service) {
        this.service = service;
    }

    public void setDescription(final Description description) {
        this.description = description;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getService() {
        return this.service;
    }

    public Description getDescription() {
        return this.description;
    }

    public Status() {
    }

    public Status(final String code, final String message, final String service, final Description description) {
        this.code = code;
        this.message = message;
        this.service = service;
        this.description = description;
    }
}
