package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {

        //1-Setting up web driver manager
        WebDriverManager.chromedriver().setup();

        //2- create the instance of the Chrome browser driver
        WebDriver driver=new ChromeDriver();

        //3-test if the driver and browse are working as expected
        driver.get("https://www.google.com");


    }


}
