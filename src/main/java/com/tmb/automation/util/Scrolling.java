package com.tmb.automation.util;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Scrolling extends Base {

	public void ScrollDown() {
		Dimension dimension=appiumDriver.manage().window().getSize();
		Double scrollHeightStart=dimension.getHeight()*0.5;
		int scrollStart=scrollHeightStart.intValue();		
		Double scrollHeightEnd=dimension.getHeight()*0.1;
		int scrollEnd=scrollHeightEnd.intValue();
		
		
		new TouchAction((PerformsTouchActions) appiumDriver).longPress(PointOption.point(0,scrollStart))
        .moveTo(PointOption.point(0,scrollEnd)).release()
        .perform();
		
			}
	
	public List<WebElement> ViewElement(String Xpath){
		return appiumDriver.findElements(By.xpath(Xpath));
		
	}
	
	public void ScrolltillElementintoDisplay(String xpath) {
		 System.out.println("Inside Scrolling--- and size is--"+ViewElement(xpath).size());
		 if(ViewElement(xpath).size()==0) {
			 while (ViewElement(xpath).size()==0) {
				  System.out.println("Scrolling---"+ViewElement(xpath).size());	
				  ScrollDown();
			  }
			 System.out.println(ViewElement(xpath).get(0).isDisplayed());
			 while (!ViewElement(xpath).get(0).isDisplayed()) {
				  System.out.println("Scrolling till display--"+ViewElement(xpath).size());	
				  ScrollDown();
			  }
			 System.out.println("Scrolling completed on display ---"+ViewElement(xpath).size()); 
		 }
		 else {
			 while (!ViewElement(xpath).get(0).isDisplayed() ) {
				  System.out.println("Scrolling till display--"+ViewElement(xpath).size());	
				  ScrollDown();
			  }
			 System.out.println("Scrolling completed on display ---"+ViewElement(xpath).size()); 
		 
	  
	  
	}
	}

}
