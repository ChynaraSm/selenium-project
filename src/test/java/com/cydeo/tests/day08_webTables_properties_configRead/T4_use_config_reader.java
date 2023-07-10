package com.cydeo.tests.day08_webTables_properties_configRead;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_use_config_reader {
    /*
    TC #4: Google search
1- Open a chrome browser
2- Go to: https://google.com
3- Write “apple” in search box
4- Verify title:
Expected: apple - Google Search

     */
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //1. Create new test and make setups
        String browserType = ConfigurationReader.getProperty("browser");

        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to: https://google.com
        driver.get(ConfigurationReader.getProperty("googleURL"));
        //driver.get("https://google.com");
    }

    @Test
    public void google_search_test(){
        // 3- Write “apple” in search box
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@name='q']"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);


        String expectedTitle = ConfigurationReader.getProperty("searchValue") +" - Google Search";
        BrowserUtils.sleep(2);
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

    }


}
