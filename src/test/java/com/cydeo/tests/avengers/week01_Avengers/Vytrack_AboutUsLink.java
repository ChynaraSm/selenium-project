package com.cydeo.tests.avengers.week01_Avengers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Vytrack_AboutUsLink {
    //https://vytrack.com/
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://vytrack.com/");


       WebElement aboutUsLink= driver.findElement(By.linkText("About us"));

       if(aboutUsLink.isDisplayed()){
           System.out.println("About us test is displayed");
       }else{
           System.out.println("About us test is failed");
       }

        driver.close();

    }


}
