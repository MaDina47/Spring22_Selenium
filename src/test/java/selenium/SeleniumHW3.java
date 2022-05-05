package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


public class SeleniumHW3 {

    @Test
    public void homework3() {
        /**
         * TC-1:  darksky.net
         * Verify correct temperature value is displayed after changing temperature units
         */
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window();
        driver.get("https://www.darksky.net");

        By temp = By.xpath("//span[@class='summary swap']");
        String tempValue = driver.findElement(temp).getText();
        System.out.println(tempValue);
        String[] newstr = tempValue.split("˚");
        //System.out.println(Arrays.toString(newstr));
        String newStr1 = newstr[0];
        //System.out.println(newStr1);
        double newInt = Integer.parseInt(newStr1);
        System.out.println(newInt);

        driver.findElement(By.xpath("//div[contains(@class,'selectric-units')]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'selectric-open')]//li[@class='last']")).click();

        By temp1 = By.xpath("//span[@class='summary swap']");
        String tempValue1 = driver.findElement(temp).getText();
        System.out.println("\n" + tempValue1);
        String[] newStr = tempValue1.split("˚");
        //System.out.println(Arrays.toString(newStr));
        String newSt1 = newStr[0];
        //System.out.println(newSt1);
        double newInt1 = Integer.parseInt(newSt1);
        System.out.println(Math.round(newInt1));

        double tV = (newInt-32) * 5/9;
        System.out.println(Math.round(tV));

        Assert.assertEquals(Math.round(newInt1), Math.round(tV),"not true");
        driver.quit();
    }

    @Test
    public void HW3_TC2() {
        /**
         * TC-2: facebook.com
         * Verify current date is selected in the dropdown when user lands on the Create new account form
         */
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//a[@rel='async']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        By monthLocator = By.xpath("//*[@id='month']//option[@selected='1']");
        String month = driver.findElement(monthLocator).getText();
        //System.out.println(month);
        By dayLocator = By.xpath("//select[@aria-label='Day']//option[@selected='1']");
        String day = driver.findElement(dayLocator).getText();
        //System.out.println(day);
        By yearLocator = By.xpath("//select[@aria-label='Year']//option[@selected='1']");
        String year = driver.findElement(yearLocator).getText();
        //System.out.println(year);
//        ArrayList currentDate = new ArrayList<>(Arrays.asList(month,day,year));
//        System.out.println(currentDate);
        String newDate = month + ", " + day + ", " + year;
        System.out.println(newDate);
        Date td = new Date();
        SimpleDateFormat today = new SimpleDateFormat("MMM, d, yyyy");
        Assert.assertEquals(newDate, today.format(td), "not equal");
        driver.quit();
    }
        @Test
        public void HW3_TC3() {
            /**
             * TC-3: https://classroomessentialsonline.com/
             * Verify user lands on Economy Church Chairs page after clicking the option from Church Chairs
             */
            System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.classroomessentialsonline.com");

            By locator = By.xpath("//a[contains(@class, '-subMenu is-') and @href='/church-chairs/']");
            WebElement hover = driver.findElement(locator);
            Actions action = new Actions(driver);
            action.moveToElement(hover).perform();

            //get title
            String getText = driver.findElement(By.xpath("//a[@href='/economy-church-chairs/']")).getText();
            System.out.println(getText);

            // get href url
            String getTx = driver.findElement(By.xpath("//a[@href='/economy-church-chairs/']")).getAttribute("href");
            System.out.println(getTx);

            driver.findElement(By.xpath("//a[@href='/economy-church-chairs/']")).click();

            String url = driver.getCurrentUrl();
            System.out.println(url);

            String getText1 = driver.findElement(By.xpath("//h1[@class='page-heading']")).getText();
            System.out.println(getText1);


            Assert.assertEquals(getTx,url, "page doesn't match");

            Assert.assertEquals(getText,getText1,"page doesn't match");

            driver.quit();
        }

}
