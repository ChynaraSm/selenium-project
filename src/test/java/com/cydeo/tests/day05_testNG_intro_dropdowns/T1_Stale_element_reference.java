package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T1_Stale_element_reference {
    public static void main(String[] args) throws InterruptedException {
    //        XPATH PRACTICES

    //TC #1: StaleElementReferenceException handling
    //1. Open Chrome
      WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/add_remove_elements/");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    //3. Click to “Add Element” button
        WebElement addElementButton=driver.findElement(By.xpath("//button[.='Add Element']"));

        addElementButton.click();
        Thread.sleep(1000);
    //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton=driver.findElement(By.xpath("//button[.='Delete']"));
        System.out.println("deleteButton.isDisplayed(), is expecting true = " + deleteButton.isDisplayed());

        Thread.sleep(2000);

        //5. Click to “Delete” button.
        deleteButton.click();
    //6. Verify “Delete” button is NOT displayed after clicking.
       //use try/catch to handle and verify
        try {
            System.out.println("deleteButton.isDisplayed(), expecting false = " + deleteButton.isDisplayed());
        }catch(StaleElementReferenceException e){
            System.out.println("-->StaleElementRefrenceException happened due to element being deleted from the page. ");
            System.out.println("Which concludes our test case -PASSING!-");
            System.out.println("deleteButton.isDisplayed()=false");
        }//USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
        //driver.close();
    }
}
