package com.cydeo.tests.day04_findElements_checkedBoxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T3_Checkboxes {
    public static void main(String[] args) throws InterruptedException {
    //        TC#3: Checkboxes
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    //1. Go to https://practice.cydeo.com/checkboxes
        driver.get("https://practice.cydeo.com/checkboxes");

    //locate checkboxes 1 and 2
        WebElement checkbox1=driver.findElement(By.xpath("//input[@name='checkbox1']"));WebElement checkbox2=driver.findElement(By.xpath("//input[@name='checkbox2']"));

    //2. Confirm checkbox #1 is NOT selected by default
        System.out.println("checkbox1.isSelected(), is expecting false = " + checkbox1.isSelected());
    //3. Confirm checkbox #2 is SELECTED by default.
        System.out.println("checkbox2.isSelected(), is expecting true = " + checkbox2.isSelected());
    //4. Click checkbox #1 to select it.

        checkbox1.click();

    //5. Click checkbox #2 to deselect it.

        checkbox2.click();

    //6. Confirm checkbox #1 is SELECTED.
        Thread.sleep(1000);
        System.out.println("checkbox1.isSelected(), expecting true = " + checkbox1.isSelected());

        //7. Confirm checkbox #2 is NOT selected.
        System.out.println("checkbox2.isSelected(), expecting true = " + checkbox2.isSelected());

    driver.close();
    }
}
