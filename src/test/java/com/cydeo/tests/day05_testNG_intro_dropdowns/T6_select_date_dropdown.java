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

public class T6_select_date_dropdown {
    //    TC #6: Selecting date on dropdown and verifying
    //1. Open Chrome browser
    //2. Go to https://practice.cydeo.com/dropdown
   WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");
    }
    @Test
    public void date_dropdown_test() throws InterruptedException {
     //WebElement monthDropdown=driver.findElement(By.xpath("//select[@id='year']"));
    // WebElement yearDropdown=driver.findElement(By.xpath("//select[@id='year']"));
    // Select select=new Select(yearDropdown);


    Select yearDropdown=new Select(driver.findElement(By.xpath("//select[@id='year']")));
    yearDropdown.selectByVisibleText("1933");
    String expectedYearValue="1933";
    String actualValue= driver.findElement(By.xpath("//select[@id='year']")).getText();
      //  Assert.assertTrue(actualValue.equalsIgnoreCase(expectedYearValue));

    Select monthDropdown=new Select(driver.findElement(By.xpath("//select[@id='month']")));
    monthDropdown.selectByValue("11");

    Select dayDropdown=new Select(driver.findElement(By.xpath("//select[@id='day']")));
    dayDropdown.selectByIndex(0);
        Thread.sleep(2000);

        //create expected values
        String expectedYear = "1933";
        String expectedMonth = "December";
        String expectedDay = "1";

        //getting actual values from browser
        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        //create assertions
        Assert.assertTrue(actualYear.equals(expectedYear), "ACTUAL YEAR NOT EQUAL EXPECTED YEAR!");
        Assert.assertEquals(actualMonth, expectedMonth);
        Assert.assertEquals(actualDay, expectedDay);



    }
    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }


    //3. Select “December 1st, 1933” and verify it is selected.
    //Select year using : visible text
    //Select month using : value attribute
    //Select day using : index number
}
