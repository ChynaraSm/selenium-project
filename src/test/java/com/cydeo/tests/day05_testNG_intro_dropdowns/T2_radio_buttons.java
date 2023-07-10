package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T2_radio_buttons {
    public static void main(String[] args) throws InterruptedException {
    //        NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
    //TC #2: Radiobutton handling
    //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/radio_buttons");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    //2. Go to https://practice.cydeo.com/radio_buttons

    //3. Click to “Hockey” radio button

        WebElement hockeyRadioButton=driver.findElement(By.xpath("//input[@id='hockey']"));
    //4. Verify “Hockey” radio button is selected after clicking.
        Thread.sleep(1000);
        hockeyRadioButton.click();
    //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

        if (hockeyRadioButton.isSelected()){
            System.out.println("Button is selected. Verification PASSED!");
        }else{
            System.out.println("Button is NOT selected. Verification FAILED!");
        }
    }
}
