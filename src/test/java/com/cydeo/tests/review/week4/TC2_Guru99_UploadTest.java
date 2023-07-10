package com.cydeo.tests.review.week4;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2_Guru99_UploadTest {
@Test
    public void guru99_upload_test(){
    // TC: Guru99 Upload Test
    //1. Go to  “https://demo.guru99.com/test/upload”
    Driver.getDriver().get("https://demo.guru99.com/test/upload");
    //2. Upload file into Choose File

    WebElement chooseFile=Driver.getDriver().findElement(By.xpath("//input[@id='uploadfile_0']"));
    chooseFile.sendKeys("C:\\Users\\USER\\Downloads\\some-file.txt");

    BrowserUtils.sleep(1);
    //3. Click terms of service check box
    Driver.getDriver().findElement(By.xpath("//input[@id='terms']")).click();

    //4. Click Submit File button

    //5. Verify expected message appeared.
    Driver.getDriver().findElement(By.cssSelector("button#submitbutton")).click(); //#is for ---> id

    BrowserUtils.sleep(3);
    // Expected: “1 file
    WebElement resultMsg=Driver.getDriver().findElement(By.xpath("//center[.='1 file has been successfully uploaded.']"));
    // has been successfully uploaded.

    String actualMsg=resultMsg.getText();
    String expectedMsg="1 file\nhas been successfully uploaded.";

    Assert.assertEquals(actualMsg, expectedMsg, "Result Message verification failed ");
    BrowserUtils.sleep(2);

}


}
