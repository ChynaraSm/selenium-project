package com.cydeo.tests.base;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

    //This class is the parent of all Test classes
    //we will update this class based on what you are keep writing in your most test classes
    //instead of writing in all test classes, you can just write in this class
    //and you can extend this class from any class
    //this class is abstract because we don't want to create any object using this class


public abstract class TestBase {
    protected WebDriver driver;
    @BeforeMethod
    public void setup(){
        // 1. Open Chrome browser
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // After we implement Driver class singleton design pattern in our project,
        // we will not need above codes instead we will determine common line of codes from most test
        // methods to implement in this class

        // We can use this class for navigating to the page
        // Driver.getDriver.get("URL of app");

    }
    @AfterMethod
    public void tearDownMethod(){driver.quit();}
}
