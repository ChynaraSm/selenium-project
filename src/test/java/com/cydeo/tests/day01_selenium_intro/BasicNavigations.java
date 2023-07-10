package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {
        //setup browser driver
        WebDriverManager.chromedriver().setup();

        // create instance of Chrome browser
        WebDriver driver=new ChromeDriver();

        //this line maximize my window

        //go to tesla.com
        driver.get("https://www.tesla.com");
        //get title
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();

       // System.out.println("driver.getTitle ="+driver.getTitle());

        String currentTitle=driver.getTitle();
        System.out.println("currentTitle= "+currentTitle);
        System.out.println("Current url= "+driver.getCurrentUrl());

        //Use navigate back(0 to go back
        driver.navigate().back();

        //stop execution for 3 seconds
        Thread.sleep(1000);

        driver.navigate().forward();

        //user refreshes the page using navigate refresh()

        Thread.sleep(1000);
        driver.navigate().refresh();

        Thread.sleep(1000);
        //navigate to google.com using navigate to
        driver.navigate().to("https://www.google.com");

        //get title

        //System.out.println("driver.getTitle ="+driver.getTitle());
        currentTitle=driver.getTitle();
        System.out.println("currentTitle= "+currentTitle);

        System.out.println("Current url= "+driver.getCurrentUrl());

        driver.close(); // close current tab

        //driver.quit(); // close everything

    }
}
