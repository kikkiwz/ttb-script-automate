package com.ttbbank.oneapp.framework.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Description {

    @JsonProperty("en")
    private String en;
    @JsonProperty("th")
    private String th;

    @JsonProperty("en")
    public void setEn(final String en) {
        this.en = en;
    }

    @JsonProperty("th")
    public void setTh(final String th) {
        this.th = th;
    }

    public String getEn() {
        return this.en;
    }

    public String getTh() {
        return this.th;
    }
    public Description(String unexpectedText) {

    }
    public Description() {
    }

    public Description(final String en, final String th) {
        this.en = en;
        this.th = th;
    }

    public String toString() {
        String var10000 = this.getEn();
        return "Description(en=" + var10000 + ", th=" + this.getTh() + ")";
    }
}
