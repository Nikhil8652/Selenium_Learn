package part1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;

public class NavigationCommands {
    public static void main(String[] args) throws MalformedURLException {
        WebDriver driver = new ChromeDriver();
        // driver.get("https://demo.nopcommerce.com/");  // accepts URL only in the string format

        //URL myurl = new URL("https://demo.nopcommerce.com/");
        //driver.navigate().to(myurl);

        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.navigate().back(); // go back to url
        System.out.println(driver.getCurrentUrl());

        driver.navigate().forward(); // go to forward url
        System.out.println(driver.getCurrentUrl());

        driver.navigate().refresh();// refresh the page or reload the page
    }
}
