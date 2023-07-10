package com.cydeo.tests.day09_review_javafaker_driverUtils;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_Bing_Search {
    /*
    TC #1: Bing search
1- Open a chrome browser
2- Go to: https://bing.com
3- Write “apple” in search box
4- Verify title:

Expected: apple - Search

Use `configuration.properties` for the following:
1. The browser type
2. The URL
3. The search keyword
4. Make title verification dynamic. If search value changes, title
assertion should not fail.

     */
    WebDriver driver;
    @BeforeTest
    public void setupMethod(){
    //         TC #1: Bing search
    //1- Open a chrome browser
    //2- Go to: https://bing.com
       driver= WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       driver.get(ConfigurationReader.getProperty("bingURL"));

    }
    @Test
    public void bing_search_test() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@name='q']"));
        Thread.sleep(2000);
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Search
        //Expected: flowers - Search
        String actualTitle = driver.getTitle();

        //String expectedTitle = "apple - Search";
        //We are just making the expectedTitle dynamic based on the text we are searching.
        String expectedTitle = ConfigurationReader.getProperty("searchValue")+" - Search";

        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }


}
