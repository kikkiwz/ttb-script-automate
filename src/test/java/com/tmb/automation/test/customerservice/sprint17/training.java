package com.tmb.automation.test.customerservice.sprint17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.List;

public class training {

    @Test
    public  static void test(){
        System.setProperty("webdriver.chrome.driver","C://Users//Admin//Downloads//chromedriver_win32//chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/java/");
        List<WebElement>course = (List<WebElement>) driver.findElement(By.xpath("//a[@href='default.asp']/following::a[@class='w3-bar-item w3-button'][contains(title,'')]"));

        for(WebElement ele:course){
            String value = ele.getText();
            if(value.equals("PHP")){
                System.out.println("PHP");
                break;
            }
        }

    }


}
