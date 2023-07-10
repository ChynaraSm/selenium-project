package com.cydeo.tests.review.week4;

import com.cydeo.pages.VytrackLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC3_VytrackLoginTest {
    // TC: Vytrack app login test as Driver
    // 1- Open a chrome browser
    // 2- Go to: https://qa3.vytrack.com/user/login
    // 3. Enter username User1
    // 4. Enter password UserUser123
    // 5. Click to Login button

    VytrackLoginPage vytrackLoginPage;

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
        vytrackLoginPage = new VytrackLoginPage();
    }


    @Test
    public void vytrack_driver_login_test(){

        // Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));

        // VytrackLoginPage vytrackLoginPage = new VytrackLoginPage();

//        vytrackLoginPage.userName.sendKeys(ConfigurationReader.getProperty("driver_username"));
//        vytrackLoginPage.password.sendKeys(ConfigurationReader.getProperty("driver_password"));
//        vytrackLoginPage.loginBtn.click();

        vytrackLoginPage.loginAsDriver();


    }

    @Test
    public void vytrack_salesmanager_login_test(){

        // VytrackLoginPage vytrackLoginPage = new VytrackLoginPage();
        vytrackLoginPage.loginAsSalesmanager();

    }


    @Test
    public void vytrack_storemanager_login_test(){

        vytrackLoginPage.loginAsStoremanager();

    }

    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }
}
