package com.cydeo.tests.review.week3;

import com.cydeo.tests.base.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaFakerPractice extends TestBase {
    private Object BrowserUtils;

    // TC: Java Faker practice
    // 1. Open Chrome browser
    // 2. Go to https://practice.cydeo.com/login
    // 3. Enter username using java faker
    // 4. Enter password using java faker
    // 5. Click to Login button
    // 6. Verify text displayed on page
    //    Expected: "Your username is invalid!"
    @Test
    public void java_faker_test(){
        // TC: Java Faker practice
        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/login
        Faker faker=new Faker();


         driver.get("https://practice.cydeo.com/login");
        // 3. Enter username using java faker
     WebElement username = driver.findElement(By.name("username"));
       username.sendKeys(faker.name().username());

        // 4. Enter password using java faker
        WebElement password = driver.findElement(By.name("password"));
       password.sendKeys(faker.internet().password());

        // 5. Click to Login button

        WebElement loginRtn1=driver.findElement(By.id("wooden_spoon"));
        loginRtn1.click();

        //
        // BrowserUtils.sleep(6);

        // 6. Verify text displayed on page

        //    Expected: "Your username is invalid!"

        System.out.println(faker.chuckNorris().fact().replaceAll("Chuck Norris", "Alisher"));
    }
}
