package mailLogin;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class GmailLoginTestCases {

    @Test
    public void login() throws InterruptedException {

        // chromedriver
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.gmail.com");

        // email
        WebElement useremail = driver.findElement(By.id("identifierId"));
        useremail.sendKeys("danjer9@gmail.com",Keys.ENTER);
        Thread.sleep(2000);

        // pass
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Java12345",Keys.ENTER);
        Thread.sleep(2000);

        // Assertion
        String actualUrl = "https://mail.google.com/mail/u/0/#inbox";
        String expectedUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

        if(actualUrl.equalsIgnoreCase(expectedUrl)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        // Exit
        driver.quit();
    }
}
