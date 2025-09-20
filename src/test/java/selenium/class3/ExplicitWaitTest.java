package selenium.class3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitTest {
    public static void main(String[] args) throws InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux"))
            System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        // Code to perform login test goes here
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");
        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));

//        driver.findElement(By.cssSelector("button[onclick='showAlert()']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button[onclick='showAlert()']")))).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@onclick='myDesk()']")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("button[onclick='myPromp()']")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Test Prompt Alert");
        Thread.sleep(2000);
        System.out.println("Alert text is: " + promptAlert.getText());
        promptAlert.accept();
        Thread.sleep(2000);


        driver.quit();


    }
}
