package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        String expectedUrl="cydeo";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

        String expectedTitle="practice";
        String actualTitle=driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

    }



}
