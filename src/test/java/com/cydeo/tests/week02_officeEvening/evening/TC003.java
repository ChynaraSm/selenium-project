package com.cydeo.tests.week02_officeEvening.evening;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003 extends TestBase{

    @Test
    public void test003(){
        //  TC003 As a user I should be able to see default option as Select a State
        /*
        WE CAN DELETE SETUP STEP BECAUSE WE DID IN THE TESTBASE CLASS
         */
        //  1-open a chrome browser
        //  2-goto https://practice.cydeo.com/dropdown
        //  3-click dropdown
        TC001.clickElementForPractice(driver,"Dropdown");
        //  4-verify default option Select a State

        WebElement stateElement = driver.findElement(By.xpath("//select[@id='state']"));
        Select select=new Select(stateElement);
     String actualText = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualText,"Select a State");
        //in order to use select we need find select tag


    }

}
