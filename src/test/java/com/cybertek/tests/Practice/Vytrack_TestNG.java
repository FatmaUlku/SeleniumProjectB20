package com.cybertek.tests.Practice;

import com.cybertek.tests.Utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Vytrack_TestNG {

    WebDriver driver;

    @BeforeMethod
    public void setDriver(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Go to QA environment VyTrack:
        driver.get("https://qa2.vytrack.com");

    }

    @Test
    public void vyTrackLogin() throws InterruptedException {
        //login to QA environment
        //Username:
        driver.findElement(By.name("_username")).sendKeys("user170");

        //Password:
        driver.findElement(By.name("_password")).sendKeys("UserUser123" + Keys.ENTER);

        //Login:
        //driver.findElement(By.name("_submit")).click();

        //confirm login successful:
        Thread.sleep(5000);

        String expectedHomePageTitle = "Dashboard";
        String actualHomePageTitle = driver.getTitle();
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle, "Login failed");

    }

    @Test
    public void vyTrackFleetVehicles() throws InterruptedException {
        //Calling login method:
        vyTrackLogin();

        //Drop-down menu by clicking on it
        driver.findElement(By.xpath("//span[@class='title title-level-1']")).click();

        Thread.sleep(5000);

        //Find and click on vehicle odometer:
        driver.findElement(By.xpath("//span[.='Vehicle Odometer']")).click();

        Thread.sleep(5000);

        //Verify driver has navigated to the vehicle odometer page overview:
        String expectedVehicleOdometerTitle = "Vehicle Odometer - Entities - System - Car - Entities - System";
        String actualVehicleOdometerTitle = driver.getTitle();

        Thread.sleep(3000);

        Assert.assertEquals(actualVehicleOdometerTitle, expectedVehicleOdometerTitle, "Navigation to vehicle odometer Failed!");

    }

    @AfterMethod
    public void driverTearDown() throws InterruptedException {
        //Closing driver after every test:
        Thread.sleep(3000);
        driver.close();

    }

}