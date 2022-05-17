<h2> Automate Selenium Login With Java </h2>

Platform supporting Maven: [IntelliJ IDEA CE](https://www.jetbrains.com/idea/download/download-thanks.html?platform=mac&code=IIC)

1. Create a new Project

2. Choose [Maven](https://en.wikipedia.org/wiki/Apache_Maven#:~:text=Maven%20is%20a%20build%20automation,%2C%20Scala%2C%20and%20other%20languages.&text=Maven%20is%20built%20using%20a,application%20controllable%20through%20standard%20input.)

3. In Project SDK box, make sure you have latest version of java "JDK"

<p align="center">
	<img width="700px" src="https://github.com/kk289/Java-Automation-OpenBrowser/blob/master/OpenBrowser/Image/_1CreateProject.png" align="center"/>
</p>

4. Click Next, and give a name to your project, like "AutomateLoginProj"

5. Now create a package inside src/test/java/ and name it "mailLogin" then create a class inside it, name it "gmailLoginTest".


<h4> What is Maven? </h4>

"Maven is a build automation tool used primarily for Java projects. Maven can also be used to build and manage projects written in C#, Ruby, Scala, and other languages.

Maven addresses two aspects of building software: how software is built, and its dependencies. An XML file describes the software project being built, its dependencies on other external modules and components, the build order, directories, and required plug-ins. It comes with pre-defined targets for performing certain well-defined tasks such as compilation of code and its packaging. 

Maven dynamically downloads Java libraries and Maven plug-ins from one or more repositories such as the Maven 2 Central Repository, and stores them in a local cache. Maven projects are configured using a Project Object Model, which is stored in a [pom.xml](https://github.com/kk289/Automate-Selenium-Login-With-Java/blob/master/pom.xml) file."

An example of [pom.xml](https://github.com/kk289/Automate-Selenium-Login-With-Java/blob/master/pom.xml) file looks like: 

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>OpenBrowser</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.7</maven.compiler.source>
        <maven.compiler.target>1.7</maven.compiler.target>
    </properties>

    <dependencies>

       	<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java-->
       	<dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
            <scope>test</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-api -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-api</artifactId>
            <version>3.141.59</version>
            <scope>test</scope>
        </dependency>

	<!-- https://mvnrepository.com/artifact/org.testing -->
        <dependency>
	    <groupId>org.testng</groupId>
      	    <artifactId>testng</artifactId>
            <version>6.14.2</version>
      	    <scope>test</scope>
    	</dependency>

    	<dependency>
      	    <groupId>org.example</groupId>
      	    <artifactId>AutomationJava</artifactId>
      	    <version>1.0-SNAPSHOT</version>
      	    <scope>test</scope>
    	</dependency>

    	<dependency>
      	    <groupId>junit</groupId>
     	    <artifactId>junit</artifactId>
      	    <version>4.11</version>
      	    <scope>test</scope>
	</dependency>
	
   </dependencies>

</project>
```

9. Make sure to setup your "pom.xml" file like above. Just replace your pom.xml file with this [pom.xml](https://github.com/kk289/Automate-Selenium-Login-With-Java/blob/master/pom.xml)

10. Let's look at "gmailLoginTest" class:

## gmailLoginTest

```
package mailLogin;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class gmailLoginTest {

    @Test
    public void login() throws InterruptedException {

        // chromedriver
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.gmail.com");

        // email
        WebElement useremail = driver.findElement(By.id("identifierId"));
        useremail.sendKeys("kkjavatest@gmail.com",Keys.ENTER);
        Thread.sleep(3000);

        // password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Java12345",Keys.ENTER);
        Thread.sleep(5000);

        // Assertion...inbox..
        String actualUrl = "https://mail.google.com/mail/u/0/#inbox";
        String expectedUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

        if(actualUrl.equalsIgnoreCase(expectedUrl)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        //close
        driver.quit();
    }
}
```

<details>
	<SUMMARY><b>NOTE</b></SUMMARY>

Not only you can automate gmail login, but you can do other email address too, like yahoo, outlook etc. Make sure you provide correct website whenever you want to use yours' choice email address.

Also, Some people may get error on following code:

``` 
String path = System.getProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
```

I had issue on my Macbook where I couldnt use chromedriver just by mentioning its dependency on pom.xml file. I had to download the chromedriver manually and stored it in system to use Google Chrome Browser. You can check my [Java Automation- Open Browser](https://github.com/kk289/Java-Automation-OpenBrowser) where I have provided step by step process to setup chromedriver. Just check it if you find any issue while running this class. 

</details>
<br>

Let's run the "gmailLoginTest" class. We get following result: 

<p align="center">
	<img width="900px" src="Image/login1.png" align="center"/>
	<br>
	<br>
	<img width="900px" src="Image/login2.png" align="center"/>
	<br>
	<br>
	<img width="900px" src="Image/login3.png" align="center"/>
</p>

<br>

<b>The program run successfully. Thank you. Let me know if you have any questions.</b>
