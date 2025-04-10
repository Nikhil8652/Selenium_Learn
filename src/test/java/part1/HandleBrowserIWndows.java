package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandleBrowserIWndows {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();

        Set<String> window = driver.getWindowHandles();

        //Approach1
        List<String> windowList = new ArrayList<>(window);

       /* String parentID = windowList.get(0);
        String childID = windowList.get(1);


        //Switch to child window
        driver.switchTo().window(childID);
        System.out.println(driver.getTitle());

        //Switch to parent window
        driver.switchTo().window(parentID);
        System.out.println(driver.getTitle());

        */
        //Approach 2
        for (String windID : window) {
            String title = driver.switchTo().window(windID).getTitle();
            if (title.equals("OrangeHRM")) {
                System.out.println(driver.getCurrentUrl());
            }
        }

    }


}
