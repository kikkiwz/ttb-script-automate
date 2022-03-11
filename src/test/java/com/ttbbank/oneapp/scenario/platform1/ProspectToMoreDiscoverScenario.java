package com.ttbbank.oneapp.scenario.platform1;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Objects;

public class ProspectToMoreDiscoverScenario extends Platform1Base {

    private final String titleMore = "Discover More";
    private final String titleWidgetLibrary = "Widgets Library";

    @Test(groups = "Prospect walk through Group", priority = 1)
    public void testProspectGotoDiscoverMore() throws IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        setScenario("Prospect - Discover More: 1.Walk through Discover More");
        addLogInfo("Start Testing");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.MORE_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON).click();
        addLogInfo("Customer clicks bottom navigation button \"More\"");

        String pageMoreTitle = ttbTestContext.findElement(OneAppElementKeys.MORE_HEADER_TITLE).getText();
        evaluateAssertEqual(pageMoreTitle, titleMore, "Land to More screen");

        scrollToBottom();
        evaluateAssertTrueWithImg(ttbTestContext.ViewElement(OneAppElementKeys.LOGOUT_BUTTON).isEmpty(), "No logout button");

    }


    @Test(groups = "Prospect walk through Group", priority = 2)
    public void testProspectGoToWidgetLibrary() throws IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        setScenario("Prospect - Discover More: 24.Navigate to widget library screen");
        addLogInfo("Start Testing");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.MORE_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.WIDGET_LIBRARY_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY_BUTTON).click();

        String pageTitle = ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY).getText();
        evaluateAssertEqualWithImg(pageTitle, titleWidgetLibrary, "Land to widget library");

        if (ttbTestContext.isAndroid()) {
            int positionAppTracking = ttbTestContext.findElement(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM).getLocation().getY();
            int positionTtbProduct = ttbTestContext.findElement(OneAppElementKeys.TTB_PRODUCTS_WIDGET_ITEM).getLocation().getY();
            int positionHighLight = ttbTestContext.findElement(OneAppElementKeys.HIGHLIGHT_CAMPAIGN_WIDGET_ITEM).getLocation().getY();
            int positionFundSearch = ttbTestContext.findElement(OneAppElementKeys.FUND_SEARCH_WIDGET_ITEM).getLocation().getY();
            addLogInfo("Widgets are ordering as");
            evaluateAssertTrue(positionAppTracking < positionTtbProduct, "1. Application Tracking");
            evaluateAssertTrue(positionTtbProduct < positionHighLight, "2. All ttb products");
            evaluateAssertTrue(positionHighLight < positionFundSearch, "3. Highlighted Campaign");
            evaluateAssertTrue(positionHighLight < positionFundSearch, "4. Fund Search");
        }
        // Back to Discover More
        ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();

    }

    @Test(groups = "Prospect walk through Group", priority = 2)
    public void testProspectGoToWidgetLibraryClickBackShouldNavigateToMoreScreen() throws IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        setScenario("Prospect - Discover More: 25.Widgets library back to More screen");
        addLogInfo("Start Testing");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.MORE_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.WIDGET_LIBRARY_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY_BUTTON).click();
        addLogInfo("Customer clicks widgets library on More screen");

        String pageTitle = ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY).getText();
        evaluateAssertEqual(pageTitle, titleWidgetLibrary, "Land to widget library");

        evaluateAssertTrueWithImg(ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).isDisplayed(), "Display '<' on widget library screen");
        ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();

        String pageMoreTitle = ttbTestContext.findElement(OneAppElementKeys.MORE_HEADER_TITLE).getText();
        evaluateAssertEqual(pageMoreTitle, titleMore, "Back to More screen (display the same screen position/scroll location when there is a transition between screens)");

        if (ttbTestContext.isAndroid()) {
            ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY_BUTTON).click();
            ttbTestContext.back();
            Assert.assertEquals(pageMoreTitle, titleMore);
        }

    }

    @Test(groups = "Prospect walk through Group", priority = 3)
    public void testProspectClickWidgetApplicationTrackingShouldNavigateToWidgetDetail() throws IOException {
        checkClickNavigateToWidgetDetail(
                OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM,
                "Manage Everything About Your Car");
    }

    @Test(groups = "Prospect walk through Group", priority = 4)
    public void testProspectClickWidgetTtbProductsShouldNavigateToWidgetDetail() throws IOException {
        checkClickNavigateToWidgetDetail(
                OneAppElementKeys.TTB_PRODUCTS_WIDGET_ITEM,
                "All ttb products");
    }

    @Test(groups = "Prospect walk through Group", priority = 5)
    public void testProspectClickWidgetHighlightCampaignShouldNavigateToWidgetDetail() throws IOException {
        checkClickNavigateToWidgetDetail(
                OneAppElementKeys.HIGHLIGHT_CAMPAIGN_WIDGET_ITEM,
                "Highlight Campaign");
    }

    @Test(groups = "Prospect walk through Group", priority = 6)
    public void testProspectClickFundSearchShouldNavigateToWidgetDetail() throws IOException {
        checkClickNavigateToWidgetDetail(
                OneAppElementKeys.FUND_SEARCH_WIDGET_ITEM,
                "Fund Search");
    }

    @Test(groups = "Prospect walk through Group", priority = 7)
    public void testProspectClickBackFromWidgetApplicationTrackingShouldNavigateToWidgetLibrary() throws IOException {
        checkNavigateBackToWidgetLibraryScreen(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM, "Manage Everything About Your Car");
    }

    @Test(groups = "Prospect walk through Group", priority = 8)
    public void testProspectClickBackFromWidgetTtbProductsShouldNavigateToWidgetLibrary() throws IOException {
        checkNavigateBackToWidgetLibraryScreen(OneAppElementKeys.TTB_PRODUCTS_WIDGET_ITEM, "All ttb products");
    }

    @Test(groups = "Prospect walk through Group", priority = 9)
    public void testProspectClickBackFromWidgetHighlightCampaignShouldNavigateToWidgetLibrary() throws IOException {
        checkNavigateBackToWidgetLibraryScreen(OneAppElementKeys.HIGHLIGHT_CAMPAIGN_WIDGET_ITEM, "Highlight Campaign");
    }

    @Test(groups = "Prospect walk through Group", priority = 10)
    public void testProspectClickBackFromWidgetFundSearchShouldNavigateToWidgetLibrary() throws IOException {
        checkNavigateBackToWidgetLibraryScreen(OneAppElementKeys.FUND_SEARCH_WIDGET_ITEM, "Fund Search");
    }

    @Test(groups = "Prospect walk through Group", priority = 11)
    public void testProspectClickButtonAddToHomepageFromWidgetApplicationTrackingShouldShowBottomSheet() throws IOException {
        checkClickAddToHomepageShowBottomSheet(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM, "Manage Everything About Your Car");
    }

    @Test(groups = "Prospect walk through Group", priority = 12)
    public void testProspectClickButtonAddToHomepageFromWidgetTtbProductShouldShowBottomSheet() throws IOException {
        checkClickAddToHomepageShowBottomSheet(OneAppElementKeys.TTB_PRODUCTS_WIDGET_ITEM, "All ttb products");
    }

    @Test(groups = "Prospect walk through Group", priority = 13)
    public void testProspectClickButtonAddToHomepageFromWidgetHighlightCampaignShouldShowBottomSheet() throws IOException {
        checkClickAddToHomepageShowBottomSheet(OneAppElementKeys.HIGHLIGHT_CAMPAIGN_WIDGET_ITEM, "Highlight Campaign");
    }

    @Test(groups = "Prospect walk through Group", priority = 14)
    public void testProspectClickButtonAddToHomepageFromWidgetFundSearchShouldShowBottomSheet() throws IOException {
        checkClickAddToHomepageShowBottomSheet(OneAppElementKeys.FUND_SEARCH_WIDGET_ITEM, "Fund Search");
    }

    @Test(groups = "Prospect walk through Group", priority = 15)
    public void testProspectAppTrackingClickBottomSheetButtonAddToHomepageFromButtonAddToHomepageShouldNavigateToTNCScreen() {
        checkOpenBottomSheetFromAddToHomepage(OneAppElementKeys.APPLICATION_TRACKING_WIDGET_ITEM, "Manage Everything About Your Car");
    }

    @Test(groups = "Prospect walk through Group", priority = 16)
    public void testProspectTtbProductClickBottomSheetButtonAddToHomepageFromButtonAddToHomepageShouldNavigateToTNCScreen() {
        checkOpenBottomSheetFromAddToHomepage(OneAppElementKeys.TTB_PRODUCTS_WIDGET_ITEM, "All ttb products");
    }

    @Test(groups = "Prospect walk through Group", priority = 17)
    public void testProspectHighlightCampaignClickBottomSheetButtonAddToHomepageFromButtonAddToHomepageShouldNavigateToTNCScreen() {
        checkOpenBottomSheetFromAddToHomepage(OneAppElementKeys.HIGHLIGHT_CAMPAIGN_WIDGET_ITEM, "Highlight Campaign");
    }

    @Test(groups = "Prospect walk through Group", priority = 18)
    public void testProspectFunSearchClickBottomSheetButtonAddToHomepageFromButtonAddToHomepageShouldNavigateToTNCScreen() {
        checkOpenBottomSheetFromAddToHomepage(OneAppElementKeys.FUND_SEARCH_WIDGET_ITEM, "Fund Search");
    }

    @Test(groups = "Prospect walk through Group", priority = 19)
    public void testProspectGoToSettingScreenCancelRegisterTTBOnBottomSheet() throws IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        setScenario("Prospect - Discover More: 36.Customer clicks \"Settings\" menu Should show bottom sheet that requires customer to register ttb touch");
        addLogInfo("Start Testing");

        ttbTestContext.waitUntilVisible(OneAppElementKeys.MORE_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON).click();
        addLogInfo("Customer clicks \"Settings\" menu on More screen");

        ttbTestContext.findElement(OneAppElementKeys.SETTING_TAB).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        evaluateAssertTrueWithImg(ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_CARD).isDisplayed(), "Show bottom sheet that requires customer to register ttb touch ");
        String registerTitleText = ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE_REGISTER).getText();
        evaluateAssertEqual(registerTitleText, "Only available for ttb touch customer");
        String registerDescriptionText = ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION_REGISTER).getText();
        evaluateAssertEqual(registerDescriptionText, "Please register application to use this function or service.");
        String registerButtonText = ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB).getText();
        evaluateAssertEqual(registerButtonText, "Register ttb touch");


        //Scenario 37
        setScenario("Prospect - Discover More: 37.Close bottom sheet that requires customer to register ttb touch");
        addLogInfo("Start Testing");
        ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_CLOSE_BUTTON).click();

        evaluateAssertTrue(ttbTestContext.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD).isEmpty(), "Click 'X' at bottom sheet that requires customer to register ttb touch - Back to More screen ");

        if (ttbTestContext.isAndroid()) {
            ttbTestContext.findElement(OneAppElementKeys.SETTING_TAB).click();
            ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
            ttbTestContext.back();

            evaluateAssertTrue(ttbTestContext.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD).isEmpty(), "Click back on android device - Back to More screen ");

        }
    }

    @Test(groups = "Prospect walk through Group", priority = 20)
    public void testProspectGoToSettingMenuCancelRegisterTTBOnTermsAndConditionsScreen() throws IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        setScenario("Prospect - Discover More: 38.Navigate to activation flow (T&C screen)");
        addLogInfo("Start Testing");

        ttbTestContext.waitUntilVisible(OneAppElementKeys.MORE_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON).click();
        ttbTestContext.findElement(OneAppElementKeys.SETTING_TAB).click();
        addLogInfo("Customer clicks \"Settings\" menu on More screen");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB_BUTTON_MORE).click();
        addLogInfo("Click 'Register ttb touch' at bottom sheet");

        ttbTestContext.waitUntilVisible(OneAppElementKeys.TERM_AND_CONDITION);
        evaluateAssertEqualWithImg(ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CONDITION).getText(), "Terms and Conditions");


        //Scenario 39
        setScenario("Prospect - Discover More: 39.Click '<' on T&C screen should back to More screen");
        addLogInfo("Start Testing");
        ttbTestContext.findElement(OneAppElementKeys.HEADER_SCREEN_BACK_BUTTON).click();
        addLogInfo("Click '<' on T&C screen");
        String pageTitle = ttbTestContext.findElement(OneAppElementKeys.MORE_HEADER_TITLE).getText();
        evaluateAssertEqual(pageTitle, titleMore, "Back to More screen");

        if (ttbTestContext.isAndroid()) {

            ttbTestContext.findElement(OneAppElementKeys.SETTING_TAB).click();
            ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
            ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB_BUTTON_MORE).click();
            ttbTestContext.waitUntilVisible(OneAppElementKeys.TERM_AND_CONDITION);
            ttbTestContext.back();
            evaluateAssertEqual(pageTitle, titleMore, "Click back on android device - Back to more screen");
        }
    }

    @Test(groups = "Prospect walk through Group", priority = 21)
    public void testProspectCloseAppGuideBottomSheetShouldDisplayMoreScreen() throws IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        setScenario("Prospect - Discover More: 40.Clicks \"App guide\" menu should display modal app guide, link to ttb website");
        addLogInfo("Start Testing");

        ttbTestContext.waitUntilVisible(OneAppElementKeys.MORE_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON).click();

        ttbTestContext.findElement(OneAppElementKeys.APP_GUIDE_BUTTON).click();
        addLogInfo("Customer clicks \"App guide\" menu on More screen");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.CLOSE_APP_GUIDE_BUTTON);
        evaluateAssertEqualWithImg(ttbTestContext.findElement(OneAppElementKeys.MORE_LINKAGE_TITLE).getText(), "App Guide");

        //Scenario 41
        setScenario("Prospect - Discover More: 41.Click '<' on top left of the modal should back to More screen");
        addLogInfo("Start Testing");
        ttbTestContext.findElement(OneAppElementKeys.CLOSE_APP_GUIDE_BUTTON).click();
        addLogInfo("Click '<' on top left of the modal");
        evaluateAssertTrue(ttbTestContext.ViewElement(OneAppElementKeys.BOTTOMSHEET_WEBVIEW).isEmpty(), "Back to More screen");
        if (ttbTestContext.isAndroid()) {
            ttbTestContext.findElement(OneAppElementKeys.APP_GUIDE_BUTTON).click();
            ttbTestContext.waitUntilVisible(OneAppElementKeys.CLOSE_APP_GUIDE_BUTTON);
            ttbTestContext.back();
            evaluateAssertTrue(ttbTestContext.ViewElement(OneAppElementKeys.BOTTOMSHEET_WEBVIEW).isEmpty(), "Click back on android device - Back to More screen");
        }
    }

    @Test(groups = "Prospect walk through Group", priority = 22)
    public void testProspectClickLinkInsideAppGuideShouldDisplayBackArrowButton() throws IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        setScenario("Prospect - Discover More: 42.Click link inside App guide should navigate to details screen");
        addLogInfo("Start Testing");

        ttbTestContext.waitUntilVisible(OneAppElementKeys.MORE_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON).click();
        ttbTestContext.findElement(OneAppElementKeys.APP_GUIDE_BUTTON).click();
        addLogInfo("Customer clicks \"App guide\" menu on More screen");

        ttbTestContext.waitUntilVisible(OneAppElementKeys.APP_GUIDE_START);
        ttbTestContext.findElement(OneAppElementKeys.APP_GUIDE_START).click();
        ttbTestContext.findElement(OneAppElementKeys.APP_GUIDE_REGISTER_AT_BRANCHES).click();
        addLogInfo("Click link inside website");
        WebElement backButtonBottomSheet = ttbTestContext.findElement(OneAppElementKeys.BACK_TNC_BUTTON);

        addLogInfo("Navigate to details screen");
        evaluateAssertTrueWithImg(backButtonBottomSheet.isDisplayed(),"Display '<' on top left of the modal");

        setScenario("Prospect - Discover More: 43. Click '<' on top left of the modal should back to app guide main screen");
        addLogInfo("Start Testing");
        ttbTestContext.findElement(OneAppElementKeys.BACK_TNC_BUTTON).click();
        addLogInfo("Click '<' on top left of the modal");
        WebElement appGuideTitle = ttbTestContext.findElement(OneAppElementKeys.MORE_LINKAGE_TITLE);
        evaluateAssertTrueWithImg(appGuideTitle.isDisplayed(),"Navigate back to app guide main screen");

        //Back to Discover More
        ttbTestContext.findElement(OneAppElementKeys.MORE_LINKAGE_CLOSE).click();
    }


    @Test(groups = "Prospect walk through Group", priority = 23)
    public void testProspectGoToTermsAndConditionScreen() throws IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        setScenario("Prospect - Discover More: 44. Clicks \"Terms and Conditions\" menu should Navigate to terms & conditions screen");
        addLogInfo("Start Testing");

        ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.MORE_HEADER_TITLE);
        ttbTestContext.findElement(OneAppElementKeys.MORE_TNC_BUTTON).click();
        addLogInfo("Customer clicks \"Terms and Conditions\" menu on More screen");
        if (ttbTestContext.isAndroid()) {
            ttbTestContext.waitUntilVisible(OneAppElementKeys.TERM_AND_CON_TITLE_SCREEN);
            String pageTitle = ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_TITLE_SCREEN).getText();
            evaluateAssertEqualWithImg(pageTitle, "Terms and Conditions", "Navigate to terms & conditions screen");
        } else {
            ttbTestContext.waitUntilVisible(OneAppElementKeys.TERM_AND_CONDITION);
            String pageTitle = ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CONDITION).getText();
            evaluateAssertEqualWithImg(pageTitle, "Terms and Conditions", "Navigate to terms & conditions screen");
        }
        //Back to Discover More
        ttbTestContext.findElement(OneAppElementKeys.BACK_TNC_BUTTON).click();
    }

    @Test(groups = "Prospect walk through Group", priority = 24)
    public void testProspectGoToTermsAndConditionScreenBackToMoreDiscoverScreen() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        setScenario("Prospect - Discover More: 45. Click '<' on T&C screen should back to More screen");
        addLogInfo("Start Testing");

        ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.MORE_HEADER_TITLE);
        ttbTestContext.findElement(OneAppElementKeys.MORE_TNC_BUTTON).click();
        if (ttbTestContext.isAndroid()) {
            ttbTestContext.waitUntilVisible(OneAppElementKeys.TERM_AND_CON_TITLE_SCREEN);
            String pageTncTitle = ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CON_TITLE_SCREEN).getText();
            evaluateAssertEqual(pageTncTitle, "Terms and Conditions", "Navigate to terms & conditions screen");
        } else {
            ttbTestContext.waitUntilVisible(OneAppElementKeys.TERM_AND_CONDITION);
            String pageTncTitle = ttbTestContext.findElement(OneAppElementKeys.TERM_AND_CONDITION).getText();
            evaluateAssertEqual(pageTncTitle, "Terms and Conditions", "Navigate to terms & conditions screen");
        }

        ttbTestContext.findElement(OneAppElementKeys.BACK_TNC_BUTTON).click();
        addLogInfo("Click '<' on T&C screen");
        String pageTitle = ttbTestContext.findElement(OneAppElementKeys.MORE_HEADER_TITLE).getText();
        evaluateAssertEqual(pageTitle, titleMore, "Back to More screen");

        if (ttbTestContext.isAndroid()) {
            ttbTestContext.findElement(OneAppElementKeys.MORE_TNC_BUTTON).click();
            ttbTestContext.waitUntilVisible(OneAppElementKeys.TERM_AND_CON_TITLE_SCREEN);
            ttbTestContext.back();
            evaluateAssertEqual(pageTitle, titleMore, "Click back on android device - Back to More screen");
        }
    }

    @Test(groups = "Prospect walk through Group", priority = 25)
    public void testProspectMoreScreenClickPrivacyAndSecurityShouldDisplayModelPrivacy() throws IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        setScenario("Prospect - Discover More: 46.Clicks \"Privacy and Security\" menu should display modal data privacy, link to ttb website");
        addLogInfo("Start Testing");

        ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON).click();
        ttbTestContext.findElement(OneAppElementKeys.MORE_PRIVACY_SECURITY_BUTTON).click();
        addLogInfo("Customer clicks \"Privacy and Security\" menu on More screen");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_PRIVACY_TITLE);
        String bottomSheetTitle = ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_PRIVACY_TITLE).getText();
        evaluateAssertEqualWithImg(bottomSheetTitle, "Privacy and Security", "Display modal data privacy, link to ttb website");

        //Back to Discover More
        ttbTestContext.findElement(OneAppElementKeys.MORE_LINKAGE_CLOSE).click();
    }

    @Test(groups = "Prospect walk through Group", priority = 26)
    public void testProspectMoreScreenCloseShouldCloseModelPrivacy() {
        TtbTestContext ttbTestContext = getTtbTestContext();
        setScenario("Prospect - Discover More: 47.Click 'X' on top right of the modal should close modal and back to More screen");
        addLogInfo("Start Testing");

        ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON).click();
        ttbTestContext.findElement(OneAppElementKeys.MORE_PRIVACY_SECURITY_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_PRIVACY_X_ICON);

        ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_PRIVACY_X_ICON).click();
        addLogInfo("Click 'X' on top right of the modal");

        String pageTitle = ttbTestContext.findElement(OneAppElementKeys.MORE_HEADER_TITLE).getText();
        evaluateAssertEqual(pageTitle, titleMore, "Close modal and back to More screen");

        if (ttbTestContext.isAndroid()) {
            ttbTestContext.findElement(OneAppElementKeys.MORE_PRIVACY_SECURITY_BUTTON).click();
            ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_PRIVACY_TITLE);
            ttbTestContext.back();
            evaluateAssertEqual(pageTitle, titleMore, "Click back on android device - close modal and back to More screen");
        }
    }
//
//    @Test(groups = "Prospect walk through Group", priority = 27)
//    public void testProspectMoreScreenClickHelpAndSupportShouldShowServicePageTabContactTTB() {
//        TtbTestContext ttbTestContext = getTtbTestContext();
//
//        ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON).click();
//        ttbTestContext.findElement(OneAppElementKeys.MORE_HELP_SUPPORT_BUTTON).click();
//
//        ttbTestContext.waitUntilVisible(OneAppElementKeys.SERVICE_PAGE_CONTACT_TTB_TITLE);
//
//        WebElement titleContact = ttbTestContext.findElement(OneAppElementKeys.SERVICE_PAGE_CONTACT_TTB_TITLE);
//        WebElement contactNumber = ttbTestContext.findElement(OneAppElementKeys.SERVICE_PAGE_CONTACT_TTB_PHONE_NUMBER);
//        WebElement titleOtherChannel = ttbTestContext.findElement(OneAppElementKeys.SERVICE_PAGE_CONTACT_TTB_OTHER_CHANNELS);
//
//        Assert.assertTrue(titleContact.isDisplayed());
//        Assert.assertTrue(contactNumber.isDisplayed());
//        Assert.assertTrue(titleOtherChannel.isDisplayed());
//        Assert.assertEquals(titleContact.getText(), "ttb contact center");
//        Assert.assertTrue(contactNumber.toString().contains("1428"));
//        Assert.assertEquals(titleOtherChannel.getText(), "Other Channels");
//    }
//
//    @Test(groups = "Prospect More No Internet Group", priority = 28)
//    public void testProspectNoInternetConnectionShouldDisplayBottomSheetInternet() throws InterruptedException {
//        TtbTestContext ttbTestContext = getTtbTestContext();
//        if (ttbTestContext.isAndroid()) {
//            ttbTestContext.waitUntilVisible(OneAppElementKeys.MORE_BUTTON);
//            ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON).click();
//            enableDataNetWorkAndroid(false);
//            Thread.sleep(5000);
//            Assert.assertNotEquals(((AndroidDriver) driver).getConnection().getBitMask(), 4);
//
//            checkClickItemShowBottomSheetInternetConnection(OneAppElementKeys.APP_GUIDE_BUTTON);
//            checkClickItemShowBottomSheetInternetConnection(OneAppElementKeys.MORE_TNC_BUTTON);
//            checkClickItemShowBottomSheetInternetConnection(OneAppElementKeys.MORE_PRIVACY_SECURITY_BUTTON);
//            checkClickItemShowBottomSheetInternetConnection(OneAppElementKeys.MORE_HELP_SUPPORT_BUTTON);
//            checkClickItemShowBottomSheetInternetConnection(OneAppElementKeys.SETTING_TAB);
//
//            enableDataNetWorkAndroid(true);
//            Thread.sleep(5000);
//            Assert.assertEquals(((AndroidDriver) driver).getConnection().getBitMask(), 4);
//        }
//    }

    public void checkClickNavigateToWidgetDetail(String cardItem, String title) throws IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        setScenario(String.format("Prospect - Discover More: 26.Navigate to widget \"%s\" details screen", title));
        addLogInfo("Start Testing");

        ttbTestContext.waitUntilVisible(OneAppElementKeys.MORE_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.WIDGET_LIBRARY_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY_BUTTON).click();
        addLogInfo("Customer clicks widgets library on More screen");
        ttbTestContext.waitUntilVisible(cardItem);
        ttbTestContext.findElement(cardItem).click();
        addLogInfo(String.format("Click widgets \"%s\"", title));

        if (ttbTestContext.isAndroid()) {
            ttbTestContext.waitUntilVisible(OneAppElementKeys.WIDGET_LIBRARY_TITLE_CARD);
            String cardTitleText = ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY_TITLE_CARD).getText();
            evaluateAssertEqualWithImg(cardTitleText, title, String.format("Navigate to widget %s details screen", title));
        }
        //Back to Discover More
        ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();
        ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();

    }

    public void checkNavigateBackToWidgetLibraryScreen(String cardItem, String title) throws IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        setScenario(String.format("Prospect - Discover More: 27.Navigate back from \"%s\" to widget library screen", title));
        addLogInfo("Start Testing");

        ttbTestContext.waitUntilVisible(OneAppElementKeys.MORE_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.WIDGET_LIBRARY_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY_BUTTON).click();
        ttbTestContext.waitUntilVisible(cardItem);
        ttbTestContext.findElement(cardItem).click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.WIDGET_LIBRARY_TITLE_CARD);
        evaluateAssertTrueWithImg(ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).isDisplayed(), "Display '<' on details screen");
        ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();

        String pageTitle = ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY).getText();
        evaluateAssertEqual(pageTitle, titleWidgetLibrary, "Click < - back to widget library screen");

        if (ttbTestContext.isAndroid()) {
            ttbTestContext.waitUntilVisible(cardItem);
            ttbTestContext.findElement(cardItem).click();
            ttbTestContext.back();

            evaluateAssertEqual(pageTitle, titleWidgetLibrary, "Tab back on Android device - back to widget library screen");
        }
        //Back to Discover More
        ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();

    }

    public void checkClickAddToHomepageShowBottomSheet(String cardItem, String title) throws IOException {
        TtbTestContext ttbTestContext = getTtbTestContext();
        setScenario(String.format("Prospect - Discover More: 28. Clicks \"Add to Homepage\" button in %s. Should show bottom sheet that requires customer to register ttb touch ", title));
        addLogInfo("Start Testing");

        ttbTestContext.waitUntilVisible(OneAppElementKeys.MORE_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.WIDGET_LIBRARY_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY_BUTTON).click();
        ttbTestContext.waitUntilVisible(cardItem);
        ttbTestContext.findElement(cardItem).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.BUTTON_ADD_TO_HOMEPAGE);

        ttbTestContext.findElement(OneAppElementKeys.BUTTON_ADD_TO_HOMEPAGE).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
        evaluateAssertTrueWithImg(ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_CARD).isDisplayed(), "Show bottom sheet that requires customer to register ttb touch ");
        String registerTitleText = ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE_REGISTER).getText();
        evaluateAssertEqual(registerTitleText, "Only available for ttb touch customer");
        String registerDescriptionText = ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION_REGISTER).getText();
        evaluateAssertEqual(registerDescriptionText, "Please register application to use this function or service.");
        String registerButtonText = ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB).getText();
        evaluateAssertEqual(registerButtonText, "Register ttb touch");


        setScenario(String.format("Prospect - Discover More: 29.Click 'X' or swipe down at bottom sheet that requires customer to register ttb touch should back to %s detail", title));
        addLogInfo("Start Testing");
        ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_CLOSE_BUTTON).click();
        addLogInfo("Click 'X' or swipe down at bottom sheet that requires customer to register ttb touch");
        evaluateAssertTrueWithImg(ttbTestContext.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD).isEmpty(), "Click 'X' - Close bottom sheet and back to widget detail screen");

        if (ttbTestContext.isAndroid()) {
            ttbTestContext.findElement(OneAppElementKeys.BUTTON_ADD_TO_HOMEPAGE).click();
            ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
            ttbTestContext.back();
            addLogInfo("Tap back on android device");

            evaluateAssertTrueWithImg(ttbTestContext.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD).isEmpty(), "Tab back on android - Close bottom sheet and back to widget detail screen");
        }

        //Back to Discover More
        ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();
        ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();

    }

    public void checkOpenBottomSheetFromAddToHomepage(String cardItem, String title) {
        //Scenario 30
        TtbTestContext ttbTestContext = getTtbTestContext();
        setScenario(String.format("Prospect - Discover More: 30. \"%s\" widget navigate to activation flow (T&C screen)", title));
        addLogInfo("Start Testing");

        ttbTestContext.waitUntilVisible(OneAppElementKeys.MORE_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.MORE_BUTTON).click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.WIDGET_LIBRARY_BUTTON);
        ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY_BUTTON).click();

        ttbTestContext.waitUntilVisible(cardItem);
        ttbTestContext.findElement(cardItem).click();

        ttbTestContext.waitUntilVisible(OneAppElementKeys.BUTTON_ADD_TO_HOMEPAGE);

        ttbTestContext.findElement(OneAppElementKeys.BUTTON_ADD_TO_HOMEPAGE).click();
        addLogInfo("clicks button \"Add to Homepage\"");
        ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);

        ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB_BUTTON_WIDGET_LIRBARY).click();
        addLogInfo("Click 'Register ttb touch' at bottom sheet");

        if (ttbTestContext.isAndroid()) {
            ttbTestContext.findElement(OneAppElementKeys.BUTTON_BACK_TNC_WIDGET_LIBRARY).click();
        } else {
            ttbTestContext.findElement(OneAppElementKeys.TERMS_AND_CONDITIONS_BACK_BUTTON).click();
        }

        String pageTitle = ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY).getText();
        evaluateAssertEqual(pageTitle, titleWidgetLibrary, String.format("Click '<' - Back to widget %s detail screen", title));

        if (ttbTestContext.isAndroid()) {
            ttbTestContext.findElement(OneAppElementKeys.BUTTON_ADD_TO_HOMEPAGE).click();
            ttbTestContext.waitUntilVisible(OneAppElementKeys.BOTTOMSHEET_CARD);
            ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB_BUTTON_WIDGET_LIRBARY).click();

            ttbTestContext.waitUntilVisible(OneAppElementKeys.HEADER_SCREEN_TITLE);
            ttbTestContext.back();

            evaluateAssertEqual(pageTitle, titleWidgetLibrary, String.format("Click back on android device - Back to widget %s detail screen", title));
        }

        //Back to Discover More
        ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();
        ttbTestContext.findElement(OneAppElementKeys.WIDGET_LIBRARY_BACK_BUTTON).click();
    }


    public void checkClickItemShowBottomSheetInternetConnection(String item) throws InterruptedException {
        if (Objects.equals(item, OneAppElementKeys.SETTING_TAB)) {
            ttbTestContext.findElement(OneAppElementKeys.SETTING_TAB).click();
            ttbTestContext.findElement(OneAppElementKeys.REGISTER_TTB_BUTTON_MORE).click();
        } else {
            ttbTestContext.findElement(item).click();
        }

        String bottomSheetTitle = ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_TITLE).getText();
        String bottomSheetDesc = ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_DESCRIPTION).getText();
        Assert.assertEquals(bottomSheetTitle, "No Internet Connection Found");
        Assert.assertEquals(bottomSheetDesc, "Please check your connection and try again.");
        ttbTestContext.findElement(OneAppElementKeys.BOTTOMSHEET_BUTTON).click();
        Thread.sleep(1000);
        Assert.assertEquals(ttbTestContext.ViewElement(OneAppElementKeys.BOTTOMSHEET_CARD), Collections.emptyList());
    }
}
