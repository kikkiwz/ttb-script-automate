 package com.ttbbank.oneapp.runner.lending;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.scenario.lending.LendingIOSScenario;
import com.ttbbank.oneapp.scenario.lending.iosUtil.ExReport;
import com.ttbbank.oneapp.scenario.lending.iosUtil.Lib;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

 public class LendingIOSRunner extends LendingIOSScenario {

     /**
      * Setup method to initial iOS or Android Driver and Extent Report
      * @param deviceProfile
      * @throws MalformedURLException
      */
     @Parameters({"DeviceProfile"})
     @BeforeTest(alwaysRun = true)
     public void setUp(@Optional String deviceProfile)  throws MalformedURLException {
         System.out.println("Call setUp()");
 //        PhrasesConfigServiceMongoDb phrase = new PhrasesConfigServiceMongoDb();
         Lib.deviceProfile = deviceProfile;
         Lib.dataProfile = ExReport.testName;
 //        System.out.println(Lib.deviceProfile);
 //        System.out.println(Lib.data.getString("config."+ Lib.data.getString(Lib.dataProfile+".rm") + ".card_number1"));
         if (!Lib.deviceProfile.isEmpty()){
             Lib.testWithDeviceProfile1(deviceProfile);
             ttbTestContext = new TtbTestContext(Lib.driver);
 //            testWithDeviceProfile(deviceProfile);
 //            System.out.println(getTtbTestContext().getDriver().getPlatformName());
         }
         else {Assert.fail(Lib.deviceProfile + " is not found!");}
         if (Lib.dataProfile.isEmpty()){Assert.fail(Lib.dataProfile + " is not found!");}
         TtbTestContext ttbTestContext = getTtbTestContext();
         if (Lib.driver==null){
             Lib.driver = getTtbTestContext().getDriver();
         }
         ExReport.setDriver(Lib.driver);
         Lib.printConfigVariables(Lib.driver);
     }

     @AfterTest(alwaysRun = true)
     public void teardown() {
         ExReport.printReportMessage("Finish");
 /*        try {
             if (ttbTestContext.isAndroid()) {
                 ((AndroidDriver<?>) Lib.driver).openNotifications();
             } else if (ttbTestContext.isIos()) {
                 ((IOSDriver<?>) Lib.driver).shake();
             }
         } catch (Exception e) {
         }*/
         Lib.driverQuit();
     }
 }
