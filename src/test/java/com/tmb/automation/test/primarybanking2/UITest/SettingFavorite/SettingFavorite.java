//package com.tmb.automation.test.primarybanking2.UITest.SettingFavorite;
//
//import com.ttbbank.oneapp.framework.BaseScenario;
//import com.ttbbank.oneapp.framework.OneAppElementKeys;
//import com.ttbbank.oneapp.framework.TtbTestContext;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;
//
//public class SettingFavorite extends BaseScenario {
//
//    WebDriver webConText;
//
//
//    @Test
//    public void goToFavoriteListScreen(){
//
//        TtbTestContext ttbTestContext = getTtbTestContext();
//        ttbTestContext.waitUntilVisible(OneAppElementKeys.MORE_BUTTON);
//        ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON).click();
//
//        ttbTestContext.findElement(OneAppElementKeys.SETTING_TAB);
//        ttbTestContext.findElement(OneAppElementKeys.SETTING_TAB).click();
//
//        enterPin();
//
//        (new WebDriverWait(ttbTestContext.getDriver(), 30000))
//                .until(ExpectedConditions
//                        .invisibilityOfElementLocated(By.xpath("//div[@class=loading_loadingBox__2m_2X)]")));
//        scrollToBottom();
//
//        ttbTestContext.waitUntilVisible(OneAppElementKeys.PRIMARY_BANKING2_SETTING_FAV_FAVORITE_MENU);
//        ttbTestContext.findElement(OneAppElementKeys.PRIMARY_BANKING2_SETTING_FAV_FAVORITE_MENU).click();
//
//
//
//
//
//
//
//
//
//    }
//
//    @Test
//    public void addFavoriteViaTransferSuccess(){
//
//    }
//}
