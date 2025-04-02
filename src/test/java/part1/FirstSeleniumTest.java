package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver driver; // Loading webdriver

    @BeforeClass // using this annotation everytime this will run before executing anything.
    public void setUp() {
        driver = new ChromeDriver(); // object for chromedriver
        driver.manage().window().maximize(); // Everytime when browser opens it will maximize the windows
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // Here URL comes where we
        // are targeting it to.
    }

    @AfterClass // Once whole suit has run then this will run basically to close the browser.
    public void tearDown() {
        //driver.quit(); // Will quite whole browser
        // driver.close(); // Will close only tab
    }

    @Test
    public void testLoginIntoApplication() throws InterruptedException {

        Thread.sleep(2000);
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        var password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        driver.findElement(By.tagName("button")).click();

        Thread.sleep(2000);

        String actualResult = driver.findElement(By.tagName("h6")).getText();

        String expectedResult = "Dashboard";
        Assert.assertEquals(actualResult, expectedResult);
        search();
    }

    public void search() throws InterruptedException {
        Thread.sleep(2000);

        WebElement search = driver.findElement(By.className("oxd-input"));
        search.sendKeys("Hello");
    }


}
