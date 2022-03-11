package com.tmb.automation.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tmb.automation.util.Base;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports createInstance(String fileName) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);

		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(fileName);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "TCS Team");
		extent.setSystemInfo("Organization", "TMB Bank");
		extent.setSystemInfo("Build no", "W2A-1234");
		return extent;
	}

	public static String screenshotPath;
	public static String screenshotName;
	public static String screenpath;

	public static void captureScreenshot() {
		Base obj = new Base();
		File scrFile = null;
		try {
			scrFile = obj.getfile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		String path1 = System.getProperty("user.dir");
		screenpath = Helper.getUserDir() + "/reports/" + screenshotName;
//		System.out.println(screenpath);
		
		try {
			FileUtils.copyFile(scrFile, new File(Helper.getUserDir() + "/reports/" + screenshotName));
		} catch (IOException e) {
			Log.logger.debug(e.getMessage());
			e.printStackTrace();
		
		}
	}
	
	public static void captureScreenshotMobile(WebDriver driver) {
		//Create folder with timestamp
		//copy screenshot to this folder
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		//String time = dateFormat.format(new Date());
		Date time = new Date();
//		File dir = new File(Helper.getUserDir()+"/target/"+time);
		
		try {
			Path path = Paths.get(Helper.getUserDir()+"/reports/");
			Files.createDirectories(path);
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			screenshotName = time.toString().replace(":", "_").replace(" ", "_") + ".jpg";
			String path1 = System.getProperty("user.dir");
			screenpath = Helper.getUserDir() + "/reports/" + screenshotName;
			FileUtils.copyFile(file, new File(Helper.getUserDir()+"/reports/"+screenshotName));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
