import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class GmailLoginTestCase {

    @Test
    public void login() throws InterruptedException {

        // firefoxdriver
        System.setProperty("webdriver.gecko.driver","/usr/local/bin/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.gmail.com");

        // email
        WebElement useremail = driver.findElement(By.id("identifierId"));
        useremail.sendKeys("danjer9@gmail.com",Keys.ENTER);
        Thread.sleep(4000);

        // pass
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Pass1234",Keys.ENTER);
        Thread.sleep(4000);

        // Assertion
        String actualUrl = "https://mail.google.com/mail/u/0/#inbox";
        String expectedUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

        if(actualUrl.equalsIgnoreCase(expectedUrl)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }        
        
    
    @Test
    public void login1() throws InterruptedException {
        
        // chromedriver
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://www.gmail.com");

        // email
        WebElement useremail = driver1.findElement(By.id("identifierId"));
        useremail.sendKeys("danjer9@gmail.com",Keys.ENTER);
        Thread.sleep(4000);

        // pass
        WebElement password = driver1.findElement(By.name("password"));
        password.sendKeys("Pass1234",Keys.ENTER);
        Thread.sleep(4000);

        // Assertion
        String actualUrl = "https://mail.google.com/mail/u/0/#inbox";
        String expectedUrl = driver1.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

        if(actualUrl.equalsIgnoreCase(expectedUrl)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }

}
