package com.cydeo.tests.week02_officeEvening.evening;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002 extends TestBase{


    @Test
    public void test002(){
        //  **  TC002 As a user I should be able to select my favorite color and sport
        //  1-open a chrome browser
        //  2-goto https://practice.cydeo.com/
        //  3-click Radio Buttons
        TC001.clickElementForPractice(driver,"Radio Buttons");
        //  4-verify title contains Radio buttons

        Assert.assertEquals(driver.getTitle(),"Radio buttons");

        //?? //label[.='Blue']/../input--> here we found label but since we need click on circle button not on color label we go to parent /.. and then back to input
        //  5-select the favorite color as Red
        WebElement red=clickAndReturn("Red");

        //  6-verify the Red is selected
        Assert.assertTrue(red.isSelected());
        //  7-select the favorite sport as Football
        //  8-verify the Football is selected

    }
    public WebElement clickAndReturn(String color){
        String locator="//label[.='"+color+"']/../input";
        WebElement element= driver.findElement(By.xpath(locator));
        element.click();
        return element;
    }

}
