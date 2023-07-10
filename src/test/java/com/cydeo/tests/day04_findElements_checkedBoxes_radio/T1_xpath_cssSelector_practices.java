package com.cydeo.tests.day04_findElements_checkedBoxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//        XPATH and CSS Selector PRACTICES
//TC #1: XPATH and cssSelector Practices
//1. Open Chrome browser
//2. Go to https://practice.cydeo.com/forgot_password
//3. Locate all the WebElements on the page using XPATH and/or CSS
//locator only (total of 6)
//a. “Home” link
//b. “Forgot password” header
//c. “E-mail” text
//d. E-mail input box
//e. “Retrieve password” button
//f. “Powered by Cydeo text
//4. Verify all web elements are displayed.
//First solve the task with using cssSelector only. Try to create 2 different
//cssSelector if possible
//Then solve the task using XPATH only. Try to create 2 different
//XPATH locator if possible
public class T1_xpath_cssSelector_practices {
    public static void main(String[] args) throws InterruptedException {
        //        XPATH and CSS Selector PRACTICES
        //TC #1: XPATH and cssSelector Practices
        //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    //2. Go to https://practice.cydeo.com/forgot_password

        driver.get("https://practice.cydeo.com/forgot_password");
     //3. Locate all the WebElements on the page using XPATH and/or CSS
    //locator only (total of 6)
    //a. “Home” link //locate home link using, cssSelector, syntax#1m clas attribute
    WebElement homeLink1=driver.findElement(By.className("nav-link"));
    WebElement homeLink2=driver.findElement(By.xpath("//a[@href='/']"));
     WebElement homeLink3=driver.findElement(By.cssSelector("a[class='nav-link']"));
    WebElement homeLink4=driver.findElement(By.cssSelector("a.nav-link"));

    //b. “Forgot password” header--> locate header using xpath, using text of h2
        WebElement header_ex1=driver.findElement(By.xpath("//h2[.='Forgot Password']"));
    //Locate header, using cssSelector, locate parent element and move down to h2
    WebElement header_ex2=driver.findElement(By.cssSelector("div[class='example']>h2"));
    WebElement header_ex3=driver.findElement(By.cssSelector("div.example>h2"));
    //c. “E-mail” text //locate the email by
        WebElement emailLabel_ex1=driver.findElement(By.xpath("//label[@for='email']"));
//label[.='E-mail']
        WebElement emailLabel_ex2=driver.findElement(By.xpath("//label[.='E-mail']"));

    //d. E-mail input box

        WebElement emailInput_ex1=driver.findElement(By.xpath("//input[@name='email']"));
        //use {contains(@attribute, 'value')] --> tagName[contains(@attribute, 'value')]
        WebElement emailInput_ex2=driver.findElement(By.xpath("//input[contains(@pattern, 'a-z')]"));
    //e. “Retrieve password” button

        WebElement retrievePasswordButton=driver.findElement(By.xpath("//button[@id='form_submit']"));

        //f. “Powered by Cydeo text

        WebElement poweredByCydeoText=driver.findElement(By.xpath("//div[@style='text-align: center;']"));

    //4. Verify all web elements are displayed.

        System.out.println("homeLink1.isDisplayed() = " + homeLink1.isDisplayed());

        System.out.println("header_ex1.isDisplayed() = " + header_ex1.isDisplayed());

        System.out.println("emailLabel_ex1.isDisplayed() = " + emailLabel_ex1.isDisplayed());

        System.out.println("emailInput_ex1.isDisplayed() = " + emailInput_ex1.isDisplayed());

        System.out.println("poweredByCydeoText.isDisplayed() = " + poweredByCydeoText.isDisplayed());

        System.out.println("retrievePasswordButton.isDisplayed() = " + retrievePasswordButton.isDisplayed());


        //First solve the task with using cssSelector only. Try to create 2 different
    //cssSelector if possible
    //Then solve the task using XPATH only. Try to create 2 different
    //XPATH locator if possible
    Thread.sleep(2000);
    driver.close();
    }
}
