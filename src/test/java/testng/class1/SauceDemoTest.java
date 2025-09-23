package testng.class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SauceDemoTest {
    @Test
    public void checkTittleShouldSucceed() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux"))
            System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        // Code to perform login test goes here
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        String tittle = driver.getTitle();
        Assert.assertEquals(tittle, "Swag Labs", "Tittle  match");
        System.out.println("Title is: " + tittle);

        driver.quit();
    }


    @Test
    public void varifyLoginWithoutUsernameShouldFail() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux"))
            System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        // Code to perform login test goes here
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText().trim();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required", "Error message match");
        System.out.println("Error message is: " + errorMessage);

        driver.quit();
    }

    @Test
    public void varifyLoginWithoutPasswordShouldFail() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux"))
            System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        // Code to perform login test goes here
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.id("user-name")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText().trim();
        Assert.assertEquals(errorMessage, "Epic sadface: Password is required", "Error message match");
        System.out.println("Error message is: " + errorMessage);

        driver.quit();
    }

    @Test
    public void varifyLoginWithoutBlankCredentialShouldFail() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux"))
            System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        // Code to perform login test goes here
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText().trim();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required", "Error message match");
        System.out.println("Error message is: " + errorMessage);

        driver.quit();
    }

    @Test
    public void validateStandardUserLoginShouldSucceed() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux"))
            System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        // Code to perform login test goes here
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();

        String logout = driver.findElement(By.id("logout_sidebar_link")).getText().trim();
        Assert.assertEquals(logout, "Logout", "Logout text match");

        driver.quit();
    }

    @Test
    public void testProblemUserLoginShouldSucceed() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux"))
            System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        // Code to perform login test goes here
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();

        String logout = driver.findElement(By.id("logout_sidebar_link")).getText().trim();
        Assert.assertEquals(logout, "Logout", "Logout text match");

        driver.quit();
    }
}
