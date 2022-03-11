package com.ttbbank.oneapp.framework.model.common;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillerReponse {
    Integer billerId;
    String billerCompCode;
    String billerNameEn;
    String billerNameTh;
    String billerGroupType;
    String billerShortName;
    String billerTaxId;
    String billerCategoryId;
    String sortId;
    String billerLogoPath;
}