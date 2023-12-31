package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebDriverWaitPage1 {
    public WebDriverWaitPage1(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (xpath = "//button[.='Start']")
    public WebElement startBtn;

    @FindBy (id = "loading")
    public WebElement loadingBar;

    @FindBy (xpath = "//input[@placeholder='Enter username']")
    public WebElement username;

    @FindBy (xpath = "//input[@placeholder='Enter password']")
    public WebElement password;

    @FindBy (xpath = "//button[.='Submit']")
    public WebElement submitBtn;

    @FindBy (id = "flash")
    public WebElement errorMsg;
}
