package com.cydeo.tests.day10;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {
    @Test
    public void uploading_test(){
    //        TC #2 Upload Test
    //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");

    //2. Find some small file from your computer, and get the path of it.
        String path="C:\\Users\\USER\\Desktop\\file.txt";
    //3. Upload the file.Use sendKeys() method and pass the path as a string
        WebElement chooseFileButton=Driver.getDriver().findElement(By.id("file-upload"));

        BrowserUtils.sleep(2);
        chooseFileButton.sendKeys(path);

        WebElement uploadButton=Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();

        //4. Assert:
    //-File uploaded text is displayed on the
        WebElement fileUploadedHeader=Driver.getDriver().findElement(By.xpath("//h3[.='File Uploaded!']"));
        Assert.assertTrue(fileUploadedHeader.isDisplayed(), "Header is not displayed");


    }
}
