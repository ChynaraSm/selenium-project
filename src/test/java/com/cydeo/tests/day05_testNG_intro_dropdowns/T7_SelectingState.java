package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T7_SelectingState {
//    TC #7: Selecting state from State dropdown and verifying result
//1. Open Chrome browser
//2. Go to http://practice.cybertekschool.com/dropdown
//3. Select Illinois
//4. Select Virginia
//5. Select California
//6. Verify final selected option is California.
//Use all Select options. (visible text, value, index)
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
public void dropdown_task7() throws InterruptedException {
    //TC #7: Selecting state from State dropdown and verifying result

    //locate the dropdown and create select object
    Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

    //Use all Select options. (visible text, value, index)
    //3. Select Illinois
    Thread.sleep(2000);
    stateDropdown.selectByVisibleText("Illinois");

    //4. Select Virginia
    Thread.sleep(2000);
    stateDropdown.selectByValue("VA");

    //5. Select California
    Thread.sleep(2000);
    stateDropdown.selectByIndex(5);

    //6. Verify final selected option is California.
    String expectedOptionText = "California";
    String actualOptionText = stateDropdown.getFirstSelectedOption().getText();

    //assertion
    Assert.assertEquals(actualOptionText, expectedOptionText, "STATE DROPDOWN VALUE IS NOT AS EXPECTED!");
}
}
