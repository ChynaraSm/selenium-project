package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T8_SelectFromNonSelectValue {
//    TC #8: Selecting value from non-select dropdown
//1. Open Chrome browser
//2. Go to https://practice.cydeo.com/dropdown
//3. Click to non-select dropdown
//4. Select Facebook from dropdown
//5. Verify title is “Facebook - Log In or Sign Up”
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
    public void selectNonSelectDropdown() throws InterruptedException {
        //locate the non-select dropdown
        WebElement websiteDropdown = driver.findElement(By.linkText("Dropdown link"));
        //Thread.sleep(1000);
        websiteDropdown.click();
        //Thread.sleep(1000);

        //4. Select Facebook from dropdown
        WebElement facebookLink = driver.findElement(By.linkText("Facebook"));
        facebookLink.click();
        Thread.sleep(3000);

        //5. Verify title is  "Facebook - log in or sign up"
        String expectedTitle = "Facebook - log in or sign up";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Titles are not equal!");
    }

}
