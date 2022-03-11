package com.ttbbank.oneapp.framework.model.autoloan;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Headers {
    @JsonProperty("idrequest")
    private String idrequest;
    @JsonProperty("trgappln")
    private String trgappln;
    @JsonProperty("srcsrvnm")
    private String srcsrvnm;
    @JsonProperty("serviename")
    private String serviename;
    @JsonProperty("acqnum")
    private String acqnum;
    @JsonProperty("cldatein")
    private String cldatein;
    @JsonProperty("cltimein")
    private String cltimein;
    @JsonProperty("hdnrec")
    private String hdnrec;
    @JsonProperty("hdmrec")
    private String hdmrec;
    @JsonProperty("hdrrjcd")
    private String hdrrjcd;
    @JsonProperty("hdrind")
    private String hdrind;
    @JsonProperty("hdrcd1")
    private String hdrcd1;
    @JsonProperty("hdree1")
    private String hdree1;
    @JsonProperty("referenenum")
    private String referenenum;
}
