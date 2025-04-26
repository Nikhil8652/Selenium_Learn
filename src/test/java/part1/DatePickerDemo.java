package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DatePickerDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        //Switch to  frame
        driver.switchTo().frame(0);

        //sendkey method
        driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).sendKeys("04/05/2024");// mm/dd/yyyy

        //Method 2: Using date picker
        //expected data
        String year = "2025";
        String month = "May";
        String date = "20";

        //input field always accept string format even if input field is for number still it will take string input

        driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).click();// opens date picker

        //Select month and year
        while (true) {

            String currentMonth = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText();
            // actual month
            String currentyear = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText(); //
            // actual
            // year

            if (currentMonth.equals(month) && currentyear.equals(year)) {
                break;
            }
            driver.findElement(By.xpath("//span[text()=\"Next\"]")).click(); // Next button
        }
    }
}
