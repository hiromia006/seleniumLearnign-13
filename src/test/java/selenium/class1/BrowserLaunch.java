package selenium.class1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch {
    public static void main(String[] args) {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux"))
            System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/downloads/");

        driver.quit();
    }
}
