package com.tmb.automation.autoloan.firstnative;

import com.tmb.automation.util.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import net.bytebuddy.build.ToStringPlugin;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

//import static javax.swing.plaf.synth.SynthGraphicsUtils.SynthIconWrapper.release;
//import static org.openqa.selenium.devtools.v89.dom.DOM.moveTo;

public class Android extends Base{

    int x;
    int y;




    @BeforeTest
    public void Setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"ANDROID");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"BEV5T18B22001532");
        capabilities.setCapability(MobileCapabilityType.VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME,"com.google.android.apps.fitness");
        URL url = new URL("http://127.0.0.1:8200");
        
    }

    @Test(description = "Simple test")
    public void simpletest(){
//        (new TouchAction(driver)).tap(926, 1428).perform();
//        (new TouchAction(driver))
//                .press({x= 486, y= 1873})
//  .moveTo({x: 522: y: 1075}
//
//
//  .release();
//                .perform();
    }
}
