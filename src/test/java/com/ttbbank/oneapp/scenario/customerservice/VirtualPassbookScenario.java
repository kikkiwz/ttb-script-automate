package com.ttbbank.oneapp.scenario.customerservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.framework.client.OneAppClient;
import com.ttbbank.oneapp.framework.client.TmbServiceResponse;
import com.ttbbank.oneapp.framework.model.customerservice.ViewPassbookResponse;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class VirtualPassbookScenario extends BaseScenario {


    @Test(groups = "Customer Service Virtual Passbook", dependsOnGroups = {"Enter Home Screen Dev Latest","Enter Service Screen Dev Latest"})
    public void virtualPassBook() throws IOException {
        OneAppClient client = getOneAppClient();
        Map<String, String> eqParams = new HashMap<>();
        eqParams.put("service_type_id", "EPB");
        TmbServiceResponse<ViewPassbookResponse> response = client.get("/apis/customer/viewVirtualPassbook", eqParams, ViewPassbookResponse.class);
        System.out.println("response : " + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response));

        TtbTestContext ttbTestContext = getTtbTestContext();
        if(ttbTestContext.isIos()){
            //iOS DEFECT, have to click apply and come back then we can click passbook item.
            WebElement applyServicePageButton = ttbTestContext.findElement(OneAppElementKeys.TAB_APPLY);
            applyServicePageButton.click();
            ttbTestContext.waitUntilVisible(OneAppElementKeys.DEPOSIT_SERVICE_BUTTON);
            WebElement documentServicePageButton = ttbTestContext.findElement(OneAppElementKeys.DOCUMENT_SERVICE_PAGE_BUTTON);
            documentServicePageButton.click();
            WebElement passBookServiceButton= ttbTestContext.findElement(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
            passBookServiceButton.click();
            WebElement passBookItem0= ttbTestContext.findElement(OneAppElementKeys.PASSBOOK_ITEM_0);
            passBookItem0.click();
            WebElement viewPassBookButton = ttbTestContext.findElement(OneAppElementKeys.VIEW_PASSBOOK_BUTTON);
            viewPassBookButton.click();
            ttbTestContext.waitUntilVisible(OneAppElementKeys.PRODUCT_NAME_PASSBOOK_LABEL);
            return;
        }
        WebElement passBookServiceButton= ttbTestContext.findElement(OneAppElementKeys.PASSBOOK_SERVICE_BUTTON);
        passBookServiceButton.click();
        WebElement passBookItem0= ttbTestContext.findElement(OneAppElementKeys.PASSBOOK_ITEM_0);
        passBookItem0.click();
        WebElement viewPassBookButton = ttbTestContext.findElement(OneAppElementKeys.VIEW_PASSBOOK_BUTTON);
        viewPassBookButton.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRODUCT_NAME_PASSBOOK_LABEL);
    }


}
