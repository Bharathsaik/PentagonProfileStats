package org.pentagonprofilestats.testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pentagonprofilestats.pageObjects.PPSHomePageObjects;
import org.pentagonprofilestats.pageObjects.PPSResultDisplayPageObjects;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTestCase {
    WebDriver driver;
    PPSHomePageObjects homeObj;

    @BeforeClass
    public void driverSetup(){
        driver = new ChromeDriver();
        driver.get("https://kashishbarnwal2611.github.io/PentagonProfileStats/");
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void refresh(){
        driver.navigate().refresh();
    }

    public PPSHomePageObjects getPPPHomePageObjects(){
        return new PPSHomePageObjects(driver, 10);
    }

    public PPSResultDisplayPageObjects getPPSResultDisplayPageObjects(){
        return new PPSResultDisplayPageObjects(driver, 10);
    }


    @AfterClass
    public void close(){
        if(driver != null){
            driver.quit();
        }
    }
}
