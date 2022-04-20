package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UseSelenium {
     @Test
    public void useSeleniumLib(){
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
    }
}
