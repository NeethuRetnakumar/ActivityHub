import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class test_activityhub {

    static WebDriver webDriver;

    public static void main(String[] args) throws InterruptedException {


        System.setProperty(
                "webdriver.chrome.driver",
                "./src/chromedriver2");

        // Open the Chrome browser
        webDriver = new ChromeDriver();

        webDriver.get("https://account.test.bbc.com/account/activity/");
        waitforaShortSpan(10);
        webDriver.findElement(By.cssSelector("#user-identifier-input")).sendKeys("displayname2@mailinator.com");
        webDriver.findElement(By.cssSelector("#password-input")).sendKeys("Password123");
        webDriver.findElement(By.cssSelector("#submit-button")).click();
        waitforaShortSpan(500);
        WebElement element = webDriver.findElement(By.cssSelector("#idcta-username"));
        Assert.assertTrue("Element not found",
                element.isDisplayed());
        Assert.assertTrue("Element found, but the text did not match as expected",
                element.getText().equalsIgnoreCase("di123"));

        // Closing the browser and WebDriver
        webDriver.close();
        webDriver.quit();

    }

    private static void waitforaShortSpan(int secondsToWait) {
        webDriver.manage().timeouts().implicitlyWait(secondsToWait, TimeUnit.SECONDS);
    }


}