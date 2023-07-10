package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T2_to_T6_Actions_Practices {

    @BeforeMethod
    public void setupMethod(){
        //1. Go to https://practice.cydeo.com/drag_and_drop_circles
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
    }
    @AfterMethod
    public void tearDownMethod(){
        BrowserUtils.sleep(3);

        Driver.closeDriver();
    }
    @Test
    public void test2_default_value_verifications(){
//TC2 #: Drag and drop default value verification
    WebElement bigCircle=Driver.getDriver().findElement(By.id("droptarget"));

//2. Verify big circle default text is as below.
        String expectedText="Drag the small circle here.";
        String actualBigCircleText=bigCircle.getText();
//3. Assert:
//-Text in big circle changed to: “Drag the small circle here.”
        Assert.assertTrue(actualBigCircleText.equals(expectedText));

    }
    @Test
    public void test3_drop_into_the_big_circle(){
        //TC3 #: Drag and drop into the big circle
//1. Go to https://practice.cydeo.com/drag_and_drop_circles-->BeforeMethod
   WebElement bigCircle=Driver.getDriver().findElement(By.id("droptarget"));
//2. Drag and drop the small circle to bigger circle.
   WebElement smallCircle=Driver.getDriver().findElement(By.id("draggable"));

   //Locating circle web elements
        Actions actions=new Actions(Driver.getDriver());
        actions.dragAndDrop(smallCircle,bigCircle).perform();
//3. Assert:
//-Text in big circle changed to: “You did great!”


        //this one diff approach
//        actions.clickAndHold(smallCircle)
//                .pause(1000)
//                .moveToElement(bigCircle)
//                .pause(1000)
//                .release()
//                .perform();

        String expectedText="You did great!";
        String actualBigCircleText=bigCircle.getText();
//3. Assert:
//-Text in big circle changed to: “Drag the small circle here.”
        Assert.assertTrue(actualBigCircleText.equals(expectedText));

    }

    @Test
    public void test4_click_and_hold_smallCircle(){
        //TC4 #: Click and hold
//1. Go to https://practice.cydeo.com/drag_and_drop_circles
//2. Click and hold the small circle.
//3. Assert:
//-Text in big circle changed to: “Drop here.”
//Locating circle web elements
    WebElement bigCircle=Driver.getDriver().findElement(By.id("droptarget"));
    WebElement smallCircle=Driver.getDriver().findElement(By.id("draggable"));


  Actions actions=new Actions(Driver.getDriver());

//3. Assert:
//-Text in big circle changed to: “Drop here.”
        WebElement cydeoLink=Driver.getDriver().findElement(By.linkText("CYDEO"));
        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(cydeoLink)
                .pause(1000)
                .perform();

        String expectedText="Drop here.";
        String actualBigCircleText=bigCircle.getText();

        Assert.assertTrue(actualBigCircleText.equals(expectedText));

    }

    @Test
    public void test5_drag_and_drop_outside_ofBigCircle(){
        //TC5 #: Drag and drop outside of the big circle
    //1. Go to https://practice.cydeo.com/drag_and_drop_circles

        WebElement bigCircle=Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle=Driver.getDriver().findElement(By.id("draggable"));

        //2. Drag and drop the small circle to bigger circle.
        //3. Assert:
        //-Text in big circle changed to: “Try again!”

        Actions actions=new Actions(Driver.getDriver());


        WebElement cydeoLink=Driver.getDriver().findElement(By.linkText("CYDEO"));
        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(cydeoLink)
                .pause(1000)
                .release()
                .perform();

        String expectedText="Try again!";
        String actualBigCircleText=bigCircle.getText();

        Assert.assertTrue(actualBigCircleText.equals(expectedText));

    }

    @Test
    public void test6_drag_and_hover(){
        //TC6 #: Drag and hover
    //1. Go to https://practice.cydeo.com/drag_and_drop_circles
    //2. Drag the small circle on top of the big circle, hold it, and verify.
    //3. Assert:
    //-Text in big circle changed to: “Now drop...”

        WebElement bigCircle=Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle=Driver.getDriver().findElement(By.id("draggable"));


        Actions actions=new Actions(Driver.getDriver());


        WebElement cydeoLink=Driver.getDriver().findElement(By.linkText("CYDEO"));
        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(cydeoLink)
                .pause(1000)
                .moveToElement(bigCircle)
                .perform();

        String expectedText="Now drop...";
        String actualBigCircleText=bigCircle.getText();

        Assert.assertTrue(actualBigCircleText.equals(expectedText));

    }

}


