package com.tmb.automation.helper;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentListeners implements ITestListener {

	private static String fileName = Helper.getUserDir() + "/reports/"
			+ new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".html";
	private static ExtentReports extent = ExtentManager.createInstance(fileName);
	private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	public static WebDriver driver;
	 
	
	public void onTestStart(ITestResult result) {

		ExtentTest child = parentTest.get().createNode(result.getMethod().getMethodName());
		test.set(child);

	}

	public void onTestSuccess(ITestResult result) {
		if (ExtentListeners.getDriver()!=null){
		try {

			//ExtentManager.captureScreenshot();
			
			ExtentManager.captureScreenshotMobile(ExtentListeners.getDriver());
			test.get().pass("<b>" + "<font color=" + "green>" + "Screenshot of success" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenpath).build());
		}
		
		catch (IOException e)
		{

		}
		}

		String description = result.getMethod().getDescription();
		String logText = "<b>" + "TEST CASE:- " + description.toUpperCase() + " PASSED" + "</b>";
		// extent.createTest(logText);
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		((ExtentTest) test.get()).pass(m);

	}

	public void onTestFailure(ITestResult result) {

		String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		test.get()
				.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
						+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>"
						+ " \n");

		if (ExtentListeners.getDriver()!=null){
		try {

			ExtentManager.captureScreenshotMobile(ExtentListeners.getDriver());;
			test.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenpath).build());
		}
		catch (IOException e) {

		}
		
		}
		String failureLogg = "TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		test.get().log(Status.FAIL, m);

	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		test.get().skip(m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		ExtentTest parent = extent.createTest(context.getAllTestMethods()[0].getInstance().getClass().getSimpleName());
		System.out.println("class name " + getClass().getName());
		extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
		parentTest.set(parent);
	}

	public synchronized void onFinish(ITestContext context) {

		if (extent != null) {

			extent.flush();
			Log.logger.debug("Report Created "+fileName);
			if (Boolean.parseBoolean(Helper.getProperties("flag_open_report"))) {
				File htmlFile = new File(fileName);
				try {
					Desktop.getDesktop().browse(htmlFile.toURI());
				} catch (Exception e) {
//					e.printStackTrace();
				}
			}
			System.out.println(".");
		}

	}
	 public static WebDriver getDriver() {
	        return driver;
	    }

	    public static void setDriver(WebDriver driver) {
	        Log.logger.debug("ExtentListeners.driver = driver");
	        ExtentListeners.driver = driver;
	    }

}
