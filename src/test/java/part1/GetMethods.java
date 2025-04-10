package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class GetMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);

        //Gets the title of the URL
        String title = driver.getTitle();
        System.out.println(title);

        //getCurrentUrl() - return current url
        String currrenturl = driver.getCurrentUrl();
        System.out.println(currrenturl);

        //getPageSource() - returns the source code of the page
        // System.out.println(driver.getPageSource());

        //getzwindowHandle() - returns ID of the single browser window
        String window = driver.getWindowHandle();
        System.out.println("window: " + window);

        //getzwindowHandles() - returns ID of the multiple browser windows
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        Set<String> windows = driver.getWindowHandles();
        System.out.println("windows: " + windows);
    }
}
