package com.cybertek.tests.day4_findElements_checkBoxes_Radio;

import com.cybertek.Utilities.WebDriverFactory_VyTrack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Practice_CybertekForgotPassword {

    public static void main(String[] args) {

        //TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory_VyTrack.getDriver("chrome");

        //2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
        //a. “Home” link
        WebElement homeLink = driver.findElement(By.cssSelector("a.nav-link"));

        //b. “Forgot password” header
        WebElement header = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        //c. “E-mail” text
        WebElement emailLabel = driver.findElement(By.xpath("//label[@for='email']"));

        //d. E-mail input box
        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));

        //e. “Retrieve password” button
        WebElement retrievePasswordButton = driver.findElement(By.cssSelector("button.radius"));

        //f. “Powered by Cybertek School” text
        WebElement linkText = driver.findElement(By.xpath("//a[.='Cybertek School']"));
        WebElement poweredByDiv = driver.findElement(By.xpath("//div[@style = 'text-align: center;']"));

        //4. Verify all WebElements are displayed.
        //.isDisplayed --> returns true if given web element is displayed
        //.isDisplayed --> returns flase if given web element is NOT displayed
        if (homeLink.isDisplayed() && emailLabel.isDisplayed() && header.isDisplayed()
                && emailInput.isDisplayed() && retrievePasswordButton.isDisplayed()
                && poweredByDiv.isDisplayed()){
            System.out.println("ALL WEB ELEMENTS ARE DISPLAYED. VERIFICATION PASSED!");
        }else {
            System.out.println("One or more of the web elements are not displayed. Verification FAILED!!!");
        }



    }

}
