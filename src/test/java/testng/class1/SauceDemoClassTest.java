package testng.class1;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoClassTest extends BaseClassTest {
    @Test(priority = 0)
    public void checkTittleShouldSucceed() {
        Assert.assertEquals(driver.getTitle(), "Swag Labs", "Tittle  match");
    }


    @Test(priority = 1)
    public void varifyLoginWithoutUsernameShouldFail() {
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText().trim();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required", "Error message match");
        System.out.println("Error message is: " + errorMessage);
    }

    @Test(priority = 2)
    public void varifyLoginWithoutPasswordShouldFail() {
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText().trim();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service", "Error message match");
    }

    @Test(priority = 3)
    public void varifyLoginWithoutBlankCredentialShouldFail() {
        driver.findElement(By.id("login-button")).click();
        String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText().trim();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service", "Error message match");
    }

    @Test(priority = 4)
    public void validateStandardUserLoginShouldSucceed() {
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();

        String logout = driver.findElement(By.id("logout_sidebar_link")).getText().trim();
        Assert.assertEquals(logout, "Logout", "Logout text match");
        driver.findElement(By.id("logout_sidebar_link")).click();

    }

    @Test(priority = 5)
    public void testProblemUserLoginShouldSucceed() throws InterruptedException {
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys("problem_user");

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();

        Thread.sleep(1000); // Just to see the menu open
        String logout = driver.findElement(By.id("logout_sidebar_link")).getText().trim();
        Assert.assertEquals(logout, "Logout", "Logout text match");

    }
}
