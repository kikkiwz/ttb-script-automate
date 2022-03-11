package com.tmb.automation.util;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.gson.Gson;
import com.itextpdf.text.DocumentException;
import com.tmb.automation.helper.ExportPdfTestcase;
import com.tmb.automation.helper.Reporter;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.model.ExportPdfTestcaseModel;
import com.tmb.automation.model.platform2.EmailListsModel;
import com.tmb.automation.util.platform2.Html;
import com.tmb.automation.util.platform2.LogsFilter;
import com.tmb.automation.util.platform2.SendEmail;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class BasePlatform2 extends Reporter {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public RequestSpecification httpRequest = RestAssured.given().relaxedHTTPSValidation();
    public JSONObject requestParams = new JSONObject();

    //@BeforeTest(alwaysRun = true)
    public void BeforeClass() throws MalformedURLException {
        File file = null;
        switch (Setting.BROWSER) {
            case IE:
                browserIe(file);
                break;
            case CHROME:
                browserChrome(file);
                break;
            case FIREFOX:
                break;
            case MICROSOFT_EDGE:
                browserEdge(file);
                break;
            case SAFARI:
                break;
            case OPERA:
                break;
        }

        if (Setting.BROWSER == Setting.BROWSER_TYPE.NON) return;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 40);
    }

    private void browserIe(File file) {
        file = new File(Setting.IE_DRIVER);
        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
        InternetExplorerOptions capabilityIE = new InternetExplorerOptions();
        capabilityIE.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        driver = new InternetExplorerDriver(capabilityIE);
    }

    private void browserChrome(File file) {
        file = new File(Setting.CH_DRIVER);
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        ChromeOptions capability = new ChromeOptions();
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        driver = new ChromeDriver(capability);
    }

    private void browserEdge(File file) {
        file = new File(Setting.EDGE_DRIVER);
        System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
        EdgeOptions capability = new EdgeOptions();
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        driver = new EdgeDriver(capability);
    }

    @AfterTest
    public void AfterClass() throws IOException, DocumentException {
        extent.flush();
        if (Setting.Config.IS_SEND_EMAIL) {
            sendEmail();
        }
        if (Setting.BROWSER == Setting.BROWSER_TYPE.NON) return;
        ExportPdfTestcase.addCoverPage(document);
        ExportPdfTestcase.addDemonstratedCapabilityPage(document);
        ExportPdfTestcase.addSystemAcceptancePage2(document);
        document.add(paragraphSummaryCase);
        ExportPdfTestcase.addSystemAcceptanceTitlePage(document);
        document.add(paragraphDemoStep);
        document.close();
        driver.quit();
    }

    private void sendEmail() throws IOException {
        String testResult = "";
        switch (Setting.AUTOMATE) {
            case API:
                for (int i = 0; i < dataTestcase.size() - 1; i++) {
                    String textColor = "#548235";
                    if (dataTestcase.get(i)[8].toString().toLowerCase().equals("pass")) {
                        textColor = "#548235";
                    } else {
                        textColor = "#D93C1A";
                    }

                    testResult += "<tr>\n" +
                            "            <td width=57 valign=top style='width:43.1pt;border:solid gray 1.0pt;\n" +
                            "  border-top:none;padding:0in 5.4pt 0in 5.4pt'>\n" +
                            "                <p class=MsoNormal align=center style='margin-bottom:0in;text-align:center;\n" +
                            "  line-height:normal'><span style='font-size:16.0pt;font-family:\"Cordia New\",sans-serif;\n" +
                            "  color:#595959'>" + (i + 1) + "</span></p>\n" +
                            "            </td>\n" +
                            "            <td width=638 valign=top style='width:6.65in;border-top:none;border-left:\n" +
                            "  none;border-bottom:solid gray 1.0pt;border-right:solid gray 1.0pt;padding:\n" +
                            "  0in 5.4pt 0in 5.4pt'>\n" +
                            "                <p class=MsoNormal style='margin-bottom:0in;line-height:normal'><span\n" +
                            "                        style='font-size:16.0pt;font-family:\"Cordia New\",sans-serif;color:#595959'>" + dataTestcase.get(i)[1].toString() + "\n" +
                            "                            </span></p>\n" +
                            "            </td>\n" +
                            "            <td width=294 valign=top style='width:220.2pt;border-top:none;border-left:\n" +
                            "  none;border-bottom:solid gray 1.0pt;border-right:solid gray 1.0pt;padding:\n" +
                            "  0in 5.4pt 0in 5.4pt'>\n" +
                            "                <p class=MsoNormal align=center style='margin-bottom:0in;text-align:center;\n" +
                            "  line-height:normal'><span style='font-size:16.0pt;font-family:\"Cordia New\",sans-serif;\n" +
                            "  color:#595959'>" + dataTestcase.get(i)[2].toString() + "</span></p>\n" +
                            "            </td>\n" +
                            "            <td width=102 valign=top style='width:76.5pt;border-top:none;border-left:\n" +
                            "  none;border-bottom:solid gray 1.0pt;border-right:solid gray 1.0pt;padding:\n" +
                            "  0in 5.4pt 0in 5.4pt'>\n" +
                            "                <p class=MsoNormal align=center style='margin-bottom:0in;text-align:center;\n" +
                            "  line-height:normal'><span style='font-size:16.0pt;font-family:\"Cordia New\",sans-serif;\n" +
                            "  color:" + textColor + "'>" + dataTestcase.get(i)[8].toString() + "</span></p>\n" +
                            "            </td>\n" +
                            "        </tr>";
                }
                break;
            case UI:
                for (int i = 0; i < testcaseResultList.size(); i++) {

                    String textColor = "#548235";
                    if (testcaseResultList.get(i).status.toString().toLowerCase().equals("pass")) {
                        textColor = "#548235";
                    } else {
                        textColor = "#D93C1A";
                    }

                    testResult += "<tr>\n" +
                            "            <td width=57 valign=top style='width:43.1pt;border:solid gray 1.0pt;\n" +
                            "  border-top:none;padding:0in 5.4pt 0in 5.4pt'>\n" +
                            "                <p class=MsoNormal align=center style='margin-bottom:0in;text-align:center;\n" +
                            "  line-height:normal'><span style='font-size:16.0pt;font-family:\"Cordia New\",sans-serif;\n" +
                            "  color:#595959'>" + (i + 1) + "</span></p>\n" +
                            "            </td>\n" +
                            "            <td width=638 valign=top style='width:6.65in;border-top:none;border-left:\n" +
                            "  none;border-bottom:solid gray 1.0pt;border-right:solid gray 1.0pt;padding:\n" +
                            "  0in 5.4pt 0in 5.4pt'>\n" +
                            "                <p class=MsoNormal style='margin-bottom:0in;line-height:normal'><span\n" +
                            "                        style='font-size:16.0pt;font-family:\"Cordia New\",sans-serif;color:#595959'>" + testcaseResultList.get(i).description + "\n" +
                            "                            </span></p>\n" +
                            "            </td>\n" +
                            "            <td width=294 valign=top style='width:220.2pt;border-top:none;border-left:\n" +
                            "  none;border-bottom:solid gray 1.0pt;border-right:solid gray 1.0pt;padding:\n" +
                            "  0in 5.4pt 0in 5.4pt'>\n" +
                            "                <p class=MsoNormal align=center style='margin-bottom:0in;text-align:center;\n" +
                            "  line-height:normal'><span style='font-size:16.0pt;font-family:\"Cordia New\",sans-serif;\n" +
                            "  color:#595959'>" + "Fixing" + "</span></p>\n" +
                            "            </td>\n" +
                            "            <td width=102 valign=top style='width:76.5pt;border-top:none;border-left:\n" +
                            "  none;border-bottom:solid gray 1.0pt;border-right:solid gray 1.0pt;padding:\n" +
                            "  0in 5.4pt 0in 5.4pt'>\n" +
                            "                <p class=MsoNormal align=center style='margin-bottom:0in;text-align:center;\n" +
                            "  line-height:normal'><span style='font-size:16.0pt;font-family:\"Cordia New\",sans-serif;\n" +
                            "  color:" + textColor + "'>" + testcaseResultList.get(i).status  + "</span></p>\n" +
                            "            </td>\n" +
                            "        </tr>";
                }
                break;
        }


        String htmlHeader = Html.getString(System.getProperty("user.dir") + "\\src\\main\\resources\\platform2\\html\\report_email_header.html");
        String htmlFooter = Html.getString(System.getProperty("user.dir") + "\\src\\main\\resources\\platform2\\html\\report_email_footer.html");

//        EmailListsModel emailListsModel = new Gson().fromJson(String.valueOf(GetJsonData.getEmailList()), EmailListsModel.class);
//        SendEmail serviceSendEmail = new SendEmail();
//        String to = String.join(", ", emailListsModel.to);
//        String cc = String.join(", ", emailListsModel.cc);
//
//        to = "cutterqa@gmail.com,sakchai.c@tcs.com";
//        cc = "singh.vivek@tcs.com,sunil.barik@tcs.com";
//        cc = "";
//        serviceSendEmail.SendEmail(to, cc, Setting.ExportPdfKey.TITLE_FILE, htmlHeader + testResult + htmlFooter, "/test-output/platform2/" + uiReportName);

    }

}
