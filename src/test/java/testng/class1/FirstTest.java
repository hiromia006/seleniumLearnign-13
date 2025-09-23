package testng.class1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTest {
    @Test
    public void check() {
        System.out.println("This is my first TestNG test case");
    }


}
