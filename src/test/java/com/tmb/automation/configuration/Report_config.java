package com.tmb.automation.configuration;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.BeforeSuite;

public class Report_config {
	
	
	@BeforeSuite
	public void Reportdetials()
	{
		
		String  date=new SimpleDateFormat("dd_MM_yyyy@HH.mm.ss").format(Calendar.getInstance().getTime());
		System.setProperty("extent.reporter.html.start", "true");
        System.setProperty("extent.reporter.html.config", "src/test/resources/html-config.xml");
        System.setProperty("extent.reporter.html.out", "test-output/HtmlReport/TestReport@"+date+".html");
	}
	
	

}
