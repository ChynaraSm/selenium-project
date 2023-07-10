package com.cydeo.tests.day10;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
 TC#1: Registration form confirmation
1. Open browser
2. Go to website: https://practice.cydeo.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10.Enter date of birth
11.Select Department/Office
12.Select Job Title
13.Select programming language from checkboxes
14.Click to sign up button
15.Verify success message “You’ve successfully completed registration.” is
displayed.
 */
public class T1_Registration_form_confirmation {
    @Test
    public void registration_form(){
        //    1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));
        //3. Enter first name
        WebElement inputFirstName=Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        inputFirstName.sendKeys("JANE");

        //4. Enter last name
        WebElement inputLastName=Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        inputLastName.sendKeys("DOE");

        //5. Enter username
        WebElement inputUserName=Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        inputUserName.sendKeys("janedoe58");


        //6. Enter email address
        WebElement inputEmail=Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        inputEmail.sendKeys("janedoe@example.com");


        //7. Enter password
        WebElement inputPassword=Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        inputPassword.sendKeys("1234567890");

        //8. Enter phone number
        WebElement inputPhone=Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));

        //9. Select a gender from radio buttons
        inputPhone.sendKeys("123-456-7890");
        WebElement radioButtonFemale=Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        radioButtonFemale.click();

        //10.Enter date of birth
        WebElement inputBirthday = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        inputBirthday.sendKeys("01/20/1980");


        //11.Select Department/Office
        Select departmentDropdown=new Select(Driver.getDriver().findElement(By.name("department")));
       // departmentDropdown.selectByVisibleText("Department of Engineering");
        departmentDropdown.selectByValue("DE");


        //12.Select Job Title
        Select jobTitleDropdown=new Select(Driver.getDriver().findElement(By.name("job_title")));
        jobTitleDropdown.selectByVisibleText("SDET");

        //13.Select programming language from checkboxes
        WebElement javaCheckbox=Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        javaCheckbox.click();

        //14.Click to sign up button
        WebElement signUpButton=Driver.getDriver().findElement(By.id("wooden_spoon"));
        signUpButton.click();

        //15.Verify success message “You’ve successfully completed registration.” is displayed.
        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//div[@role='alert']"));
        Assert.assertTrue(successMessage.isDisplayed());

        //Driver.closeDriver();
    }

}
