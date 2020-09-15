package com.cybertek.tests.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    public WebDriver driver;

    public static WebDriver getDriver(String browserType){

        if (browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        } else if (browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        } else {
            System.out.println("Given browser does not exist. Driver = null");
            return null;
        }

    }

    public void getScreenShot(WebDriver driver, String screenShotName) throws IOException {

        //Calling getScreenShotAs method to create new img file:
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //copying file to new location:
        FileUtils.copyFile(srcFile, new File("/Users/mohammadafzal/Desktop/Zain School/" + screenShotName));

    }

}
