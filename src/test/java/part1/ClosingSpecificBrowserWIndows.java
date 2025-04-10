package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class ClosingSpecificBrowserWIndows {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();

        Set<String> window = driver.getWindowHandles();

        for (String windID : window) {
            String closing = driver.switchTo().window(windID).getTitle();  // Here we're getting the title of the
            // windows which we want to close or to perform some actions and using switchTo to switch to that title
            System.out.println(closing);// printing the title of the window
            if (closing.equals("OrangeHRM") || closing.equals("Human Resources Management Software | OrangeHRM HR Software")) {
                driver.close();
            }
        }
    }


}
