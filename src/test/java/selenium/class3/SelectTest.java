package selenium.class3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SelectTest {
    public static void main(String[] args) throws InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux"))
            System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        // Code to perform login test goes here
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.id("gender")).click();
        Thread.sleep(2000);

        Select sl = new Select(driver.findElement(By.id("state")));
        sl.selectByIndex(4);
        Thread.sleep(2000);

        sl.selectByValue("NCR");
        Thread.sleep(2000);

        sl.selectByVisibleText("Uttar Pradesh");
        Thread.sleep(2000);

        List<WebElement> elements = sl.getOptions();
        for (WebElement el : elements) {
            System.out.println(el.getText());
        }


        Select city = new Select(driver.findElement(By.id("city")));
        city.selectByValue("Lucknow");
        Thread.sleep(2000);

        driver.quit();

    }
}
