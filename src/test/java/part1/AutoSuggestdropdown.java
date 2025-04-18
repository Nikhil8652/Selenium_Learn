package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestdropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.co.in/");
        driver.manage().window().maximize();

        driver.findElement(By.name("q")).sendKeys("selenium");
        Thread.sleep(5000);

        List<WebElement> options = driver.findElements(By.xpath("//ul[@role=\"listbox\"]//li//div[@role=\"option\"]"));

        System.out.println(options.size());

        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
            if (options.get(i).getText().equals("selenium")) {
                options.get(i).click();
                break;
            }
        }
    }
}
