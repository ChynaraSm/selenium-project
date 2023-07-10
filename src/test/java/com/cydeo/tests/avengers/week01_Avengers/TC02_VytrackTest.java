package com.cydeo.tests.avengers.week01_Avengers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TC02_VytrackTest {
    // https://vytrack.com/
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        //Setup the browser driver
        WebDriverManager.chromedriver().setup();

        driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://vytrack.com/");

    }
    @Test
    public void vytrack_aboutUs_link_test(){
        //verify that user can login
        WebElement aboutUsLink=driver.findElement(By.xpath("(//a[@href='https://vytrack.com/about-us/'])[1]"));

        aboutUsLink.click();

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="about-us";

        Assert.assertTrue(actualUrl.contains(expectedUrl),"about us link url verification failed" );


    }
    @Test
    public void vytrack_login_hidden_password_test(){
        //As a user I should be able to see the password's type is password (hidden as default)
        //1-setup the browser driver
        //2.go to https://vytrack.com
        //3.click login label

        driver.findElement(By.xpath("(//a[text()='LOGIN'])[1]")).click();

        //4 login to application with username as user1 and password as UserUser123
        //BrowserUtils.sleep(3000);
        WebElement userName=driver.findElement(By.id("prependedInput"));
        //5-Verify the password is hidden

        userName.sendKeys("user1");

        WebElement password=driver.findElement(By.name("_password"));
        //password.sendKeys("UserUser123");

        String actualPasswordAttributeValue=password.getAttribute("type");
        String expectedPasswordAttributeValue="password";
        Assert.assertEquals(actualPasswordAttributeValue, expectedPasswordAttributeValue,"Password hidden verification failed");

    }
    @Test
    public void vytrack_all_links_test(){
        //TC05 as a user i should be able to see Home, about us , our approach

        List<WebElement> allTopLinks=driver.findElements(By.xpath("//ul[@id='top-menu']/li/a"));
        for (WebElement eachLink : allTopLinks){
            System.out.println("eachLink.getText() = " + eachLink.getText());
            Assert.assertTrue(eachLink.isDisplayed());
        }
    }


    @AfterMethod
    public void teardownMethod(){
        //you can write here another line of codes to look at you all
        //test methods to decide which line of codes are common
       driver.quit();
    }
}
