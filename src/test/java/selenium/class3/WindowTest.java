package selenium.class3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WindowTest {
    public static void main(String[] args) throws InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux"))
            System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        // Code to perform login test goes here
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Main Window Title: " + driver.getTitle());
        System.out.println("New Window URL: " + driver.getCurrentUrl());

        Thread.sleep(2000);
        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.tutorialspoint.com/selenium/practice/new-tab-sample.php");
        Thread.sleep(2000);
        System.out.println("New WINDOW Title: " + driver.getTitle());
        System.out.println("New WINDOW URL: " + driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(originalWindow);
        Thread.sleep(2000);


        driver.quit();


    }
}
