package com.cydeo.tests.review.week3;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindowsPractice extends TestBase {
    // TC : Windows handle practice
    //    1. Open browser
    //    2. Go to website: https://demoqa.com/browser-windows
    //    3. Click on New Tab button
    //    4. Click on New Window button
    //    5. Click on New Window Message button
    //    6. Store parent window handle id in a variable
    //    7. Store all window handle ids in to a Set
    //    9. Print out each window title

    @Test
    public void multiple_windows_handling_test(){
        // TC : Windows handle practice
        //    1. Open browser
        //    2. Go to website: https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/browser-windows");

        //    3. Click on New Tab button
        driver.findElement(By.id("tabButton")).click();

        //    4. Click on New Window button
        driver.findElement(By.id("tabButton")).click();
        BrowserUtils.sleep(2);
        //    5. Click on New Window Message button
        //driver.findElement(By.xpath("//div[.='New Window Message']")).click();


        //    6. Store parent window handle id in a variable
        String parentWindowHandle=driver.getWindowHandle();
        BrowserUtils.sleep(2);
        //    7. Store all window handle ids in to a Set
        Set<String> allWindowHandles=driver.getWindowHandles();
        System.out.println("allWindowHandles.size() = " + allWindowHandles.size());

        //    9. Print out each window title
//        for (String eachWindow : allWindowHandles){
//            System.out.println("eachWindow = " + eachWindow);
//            driver.switchTo().window("eachWindow");
//            System.out.println("driver.getTitle() = " + driver.getTitle());
//        }


    }
}
