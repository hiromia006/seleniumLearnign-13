package selenium.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class LinkTest {
    public static void main(String[] args) throws InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux"))
            System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        // Code to perform login test goes here
        WebDriver driver = new FirefoxDriver();
        driver.get("https://parabank.parasoft.com/parabank/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Pag Tittle" + driver.getTitle());

        driver.findElement(By.linkText("Register")).click();
        Thread.sleep(3000);

        driver.findElement(By.partialLinkText("login info?")).click();
        Thread.sleep(3000);

        List<WebElement> elements = driver.findElements(By.tagName("a"));
        for (WebElement el : elements) {
            System.out.println(el.getText() +"   URL: "+ el.getAttribute("href"));
        }

        driver.quit();
    }
}
