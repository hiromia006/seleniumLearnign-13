package selenium.class_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsTest {
    public static void main(String[] args) throws InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux"))
            System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        // Code to perform login test goes here
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/droppable.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        Actions action = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        action.dragAndDrop(source, target).build().perform();

        Thread.sleep(2000); // Just to visually confirm the action

        action.moveToElement(target).build().perform();
        Thread.sleep(2000); // Just to visually confirm the action


        action.contextClick(target).build().perform();
        Thread.sleep(2000); // Just to visually confirm the action


        action.clickAndHold(target).build().perform();
        Thread.sleep(2000); // Just to visually confirm the action




        driver.quit();
    }
}
