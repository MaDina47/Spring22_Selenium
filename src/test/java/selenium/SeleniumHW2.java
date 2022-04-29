package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumHW2 {
    /**
     * Testcase-1:
     * <p>
     * <p>
     * Verify "Keep me signed in" is NOT selected for messenger login page
     * <p>
     * Click "Log in" button
     * <p>
     * Verify "Incorrect email or phone number" is displayed
     * <p>
     * Verify "Continue" button is enabled
     */
    @Test
    public void homework2() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        String mssgLocator = "Messenger";
        By mesengerLocator = By.linkText(mssgLocator);
        WebElement messenferLink = driver.findElement(mesengerLocator);
        messenferLink.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        By checkBox = By.xpath("//input[@type='checkbox']");
        WebElement checkBoxEl = driver.findElement(checkBox);
        boolean checkBoxIsSelected = checkBoxEl.isSelected();
        Assert.assertTrue(!checkBoxIsSelected, "the checkbox is selected");
        //   Click "Log in" button
        By messengerLogIn = By.xpath("//button[@id='loginbutton']");
        WebElement messengerLogInEl = driver.findElement(messengerLogIn);
//      try {
//         Thread.sleep(2000);
//      } catch (InterruptedException e) {
//         e.printStackTrace();
//      }
        driver.findElement(By.xpath("//*[@id='close']")).click();
        messengerLogInEl.click();

        //Verify "Incorrect email or phone number" is displayed
        By emailOrPhone = By.xpath("//div[contains(text(),'Incorrect email')]");
        WebElement checkBoxEl1 = driver.findElement(emailOrPhone);
        boolean emailOrPhoneDisplayed = checkBoxEl1.isDisplayed();
        Assert.assertTrue(emailOrPhoneDisplayed, "Not displayed");

        By messangerLogin = By.id("loginbutton");
        WebElement messangerLoginLocator = driver.findElement(messangerLogin);
        boolean isEnabled = messangerLoginLocator.isEnabled(); // returns True
        Assert.assertTrue(isEnabled, "is not enabled");

    }

    /**
     * Testcase-2:
     * On Create new account page:
     *
     * Verify the "Sign Up" button is enabled when user lands on the form
     *
     * Enter the below details in Sign Up form EXCEPT DOB
     * First name
     * Last name
     * email
     * re-enter email
     * new password
     * click Sign Up
     * Verify "Please choose a gender. You can change who can see this later." is displayed
     */
    @Test
    public void SignUpButton() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        By fbCreateAccount = By.xpath("//a[@rel='async']");
        WebElement fbCreateAccountLk = driver.findElement(fbCreateAccount);

        fbCreateAccountLk.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//input[@aria-label='First name']")).sendKeys("Madina");
        driver.findElement(By.xpath("//input[@aria-label='Last name']")).sendKeys("B");
        driver.findElement(By.xpath("//input[@aria-label='Mobile number or email']")).sendKeys("madina@gmail.com");
        driver.findElement(By.xpath("//input[@aria-label='Re-enter email']")).sendKeys("madina@gmail.com");
        driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("111111");
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        By loc = By.xpath("//div[contains(text(),'der. You c')]");
        WebElement logInBtEl =  driver.findElement(loc);
        boolean isDispayed = logInBtEl.isDisplayed();
        Assert.assertTrue(isDispayed, "not displayed");




    }


}
