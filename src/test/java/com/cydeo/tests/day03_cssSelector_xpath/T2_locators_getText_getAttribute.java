package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_locators_getText_getAttribute {
    public static void main(String[] args) {
        //        TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/

        driver.get("https://login1.nextbasecrm.com/");
        //3- Verify “remember me” label text is as expected:

        //Expected: Remember me on this computer
        WebElement rememberMeBox=driver.findElement(By.className("login-item-checkbox-label"));


        String expectedLabel="Remember me on this computer";

        String actualLabel=rememberMeBox.getText();
        if (actualLabel.equals(expectedLabel)){
            System.out.println("Label verifications PASSED!");
        }else{
            System.out.println("Label verifications FAILED");
        }

        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?

        WebElement forgotPasswordLink=driver.findElement(By.className("login-link-forgot-pass"));

        String expectedForgotPasswordText="FORGOT YOUR PASSWORD?";
        String actualForgotPasswordText=forgotPasswordLink.getText();

        if (actualForgotPasswordText.equals(expectedForgotPasswordText)){
            System.out.println("Forgot Password Text verifications passed");
        }else{
            System.out.println("actualForgotPasswordText = " + actualForgotPasswordText);
            System.out.println("expectedForgotPasswordText = " + expectedForgotPasswordText);
            System.out.println("Forgot Password Text verifications failed");
        }
        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes

        String expectedInHref="forgot_password=yes";
        String actualHrefValue=forgotPasswordLink.getAttribute("href");

        if (actualHrefValue.contains(expectedInHref)){
            System.out.println("HREF attribute value is as expected. PASSED!");
        }else{
            System.out.println("HREF attribute value is NOT as expected. FAILED");
        }

        //PS: Inspect and decide which locator you should be using to locate web
        //elements.



    }
}
