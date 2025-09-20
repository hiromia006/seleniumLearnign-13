package selenium.class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class IframeTest {
    public static void main(String[] args) throws InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux"))
            System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        // Code to perform login test goes here
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/frames.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        System.out.println("Before Main Page Text print : " + driver.findElement(By.cssSelector("div[class='col-md-8 col-lg-8 col-xl-8'] p")).getText());

        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("a[title='back to Selenium Tutorial']")).click();
        Thread.sleep(2000);
        driver.navigate().back();

        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        System.out.println("After Main Page Text print : " + driver.findElement(By.cssSelector("a[title='back to Selenium Tutorial']")).getText());

        driver.quit();

    }
}
