package com.cydeo.tests.week02_officeEvening.evening;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC001 {
    @Test
    public void testName() {
        //windows alt+insert--->?
//    TC001 As a user I should be able to click checkboxes
//  1-open a chrome browser

        WebDriverManager.chromedriver().setup();//this one is in bonigarcia
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//  2-goto
        driver.get("https://practice.cydeo.com/");

        //driver.findElement(By.xpath("//ul[@class='list-group']/li/a[.='Checkboxes']")).click();
        //  3-click Checkboxes
        clickElementForPractice(driver,"Checkboxes");

        //  4-verify title equals Checkboxes
        Assert.assertEquals(driver.getTitle(), "Checkboxes");
        //  5-click Checkbox 1
        WebElement checkbox1=driver.findElement(By.xpath("//form/input[@id='box1']"));
        checkbox1.click();

        //  6-verify the Checkbox 1 is selected
        Assert.assertTrue(checkbox1.isSelected());

        //  7-click Checkbox 2
        WebElement checkbox2=driver.findElement(By.xpath("//form/input[@id='box2']"));
        checkbox2.click();

        //  8-verify the Checkbox 2 is not selected
        Assert.assertFalse(checkbox2.isSelected());
        //close browser
        sleep(3);
        driver.close();
    }

    public static void clickElementForPractice(WebDriver driver, String elementName){
        String locator="//ul[@class='list-group']/li/a[.='"+elementName+"']";
        driver.findElement(By.xpath(locator)).click();

    }


    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (Exception e){

        }
    }



//





}
