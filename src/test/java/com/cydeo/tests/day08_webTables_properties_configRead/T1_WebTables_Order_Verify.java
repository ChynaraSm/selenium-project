package com.cydeo.tests.day08_webTables_properties_configRead;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebOrderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_WebTables_Order_Verify {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //1. Create new test and make setups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to: https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

    @Test
    public void order_verify_name_test(){
//        TC #1: Web table practice
//1. Go to: https://practice.cydeo.com/web-tables
//2. Verify Bob’
        //below locator is locating Bob but it is not dynamic locator
        //        //table[@class='SampleTable']//tbody/tr[7]/td[2]
        //locate Bob's cell by using xpath locator

        WebElement bobCell=driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));
        System.out.println("Cell content: "+bobCell.getText() );
        //Expected: “Bob Martin”
        String expectedName="Bob Martin";
        String actualName=bobCell.getText();

        Assert.assertEquals(expectedName,actualName, "Names are not matching");
        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021

        //table[@class='SampleTable']
       //table[@class='SampleTable']//tbody/tr[7]/td[2]

        //WebElement bobsOrderDate=driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/../td[5]"));

        //locating sibling
        WebElement bobsOrderDate=driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]"));


        String expectedDate="12/31/2021";
        String actualDate=bobsOrderDate.getText();

        Assert.assertEquals(actualDate, expectedDate);

    }
    @Test
    public void test2_use_order_verify_method(){
        //call the utility method we created

        String alexandraGray=WebOrderUtils.returnOrderDate(driver, "Alexandra Gray");
        System.out.println("Alexandra Gray = "+alexandraGray);
        
        String bartFisher=WebOrderUtils.returnOrderDate(driver,"Bart Fisher");
        System.out.println("Bart Fisher = " + bartFisher);
    }

    @Test
    public void test3_use_order_verify_method(){
        //river,"Ned Stark","05/12/2021");
        WebOrderUtils.orderVerify(driver,"Ned Stark", "05/12/2021");

        //passed

    }


}
