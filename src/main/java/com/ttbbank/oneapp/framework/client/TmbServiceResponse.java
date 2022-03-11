package com.ttbbank.oneapp.framework.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class TmbServiceResponse<T> {
    @JsonProperty("status")
    private Status status;
    @JsonProperty("data")
    private T data;

    public Status getStatus() {
        return this.status;
    }

    public T getData() {
        return this.data;
    }

    @JsonProperty("status")
    public void setStatus(final Status status) {
        this.status = status;
    }

    @JsonProperty("data")
    public void setData(final T data) {
        this.data = data;
    }

    public String toString() {
        Status var10000 = this.getStatus();
        return "TmbServiceResponse(status=" + var10000 + ", data=" + this.getData() + ")";
    }

}