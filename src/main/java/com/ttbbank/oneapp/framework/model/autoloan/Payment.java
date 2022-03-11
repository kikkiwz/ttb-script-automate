package com.ttbbank.oneapp.framework.model.autoloan;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "receiptpaiddate",
        "accountno",
        "contno",
        "receiptdate",
        "receiptno",
        "receiptamt",
        "receipttype",
        "receipttypedesc",
        "receiptstatus",
        "receiptstatusdesc",
        "flagereceipt",
        "pathereceipt",
        "seqno",
        "totalseq",
        "receiptdoccode"
})
@Getter
@Setter
@ToString
public class Payment {

    @JsonProperty("receiptpaiddate")
    private String receiptpaiddate;
    @JsonProperty("accountno")
    private String accountno;
    @JsonProperty("contno")
    private String contno;
    @JsonProperty("receiptdate")
    private String receiptdate;
    @JsonProperty("receiptno")
    private String receiptno;
    @JsonProperty("receiptamt")
    private Double receiptamt;
    @JsonProperty("receipttype")
    private String receipttype;
    @JsonProperty("receipttypedesc")
    private String receipttypedesc;
    @JsonProperty("receiptstatus")
    private String receiptstatus;
    @JsonProperty("receiptstatusdesc")
    private String receiptstatusdesc;
    @JsonProperty("flagereceipt")
    private String flagereceipt;
    @JsonProperty("pathereceipt")
    private String pathereceipt;
    @JsonProperty("seqno")
    private Integer seqno;
    @JsonProperty("totalseq")
    private Integer totalseq;
    @JsonProperty("receiptdoccode")
    private String receiptdoccode;


}