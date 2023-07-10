package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    //Create private a constructor to remove access to this object

    private Driver(){}
        /*
       We make WebDriver private because we want to close access from outside of the class
        We making it static because we will use it in a static method
         */

    private static WebDriver driver; //default value is null

    /*
    create a reusable utility method which will return the same driver instance once we call it. if an instance doesn't exist '
    */
    public static WebDriver getDriver(){
        /* Singleton pattern
        we will read our browser type from the configuration properties file. This way we can control which browser is opened from outside out code
         */
        if (driver==null){
            String browserType=ConfigurationReader.getProperty("browser");
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

            }

        }
        return driver;

        }
    public static void closeDriver(){
        if (driver!=null){
                /*
                This line will terminate the currently existing driver completely. it will not exist going forward.
                 */
            driver.close();
                /*
                we assigned the value back to "nulL" so that my singleton it will start over
                 */
            driver=null;
        }
    }

    /*
    Create a new Driver.closeDriver(); it will use quit() method to quit browser, and then set the driver value back to null
     */

}
