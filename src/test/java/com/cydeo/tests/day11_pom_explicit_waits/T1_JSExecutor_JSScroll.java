package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T1_JSExecutor_JSScroll {
    @Test
    public void scroll_using_js_executor(){
//        TC #1: Scroll using JavascriptExecutor
//1- Open a chrome browser
//2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");

//3- Scroll down to “Cydeo” link

        WebElement cydeoLink=Driver.getDriver().findElement(By.linkText("CYDEO"));
//4- Scroll up to “Home” link
        WebElement homeLink=Driver.getDriver().findElement(By.linkText("Home"));

// Create javasciptExecutor ot be used later
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();

        BrowserUtils.sleep(2);
        js.executeScript("arguments[0].scrollIntoView(true)",cydeoLink,homeLink );
//5- Use below provided JS method only
//JavaScript method to use : arguments[0].scrollIntoView(true)
//Note: You need to locate the links as web elements and pass them as
//arguments into executeScript() method

        BrowserUtils.sleep(2);
        js.executeScript("arguments[1].scrollIntoView(true)",cydeoLink,homeLink );
    }
}
