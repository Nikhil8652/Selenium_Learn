package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class PracticeDynamicPages {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        List<WebElement> pages = driver.findElements(By.xpath("//ul[@class=\"pagination\"]//li")); // Use this if
        // only for few pages it will get the total number of pages from this
        System.out.println(pages.size()); // checking how many pages are there
        for (int p = 1; p <= pages.size(); p++) {// loop till the page
            if (p > 1) { // u cannot click on 1st page siince it is already clicked
                driver.findElement(By.xpath("//ul[@class=\"pagination\"]//*[text()=" + p + "]")).click(); // When
                // passinf value in xpath use + operator
                Thread.sleep(3000); // waiting for 3s to click on page
//                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='productTable']//tbody//tr")));

            }

            int noOfRows = driver.findElements(By.xpath("//table[@id=\"productTable\"]//tbody//tr")).size(); //
            // getting the total number of tables rows
            System.out.println(noOfRows); // printing the total count for rows

            for (int i = 1; i <= noOfRows; i++) {// loop till rows
                String name =
                        driver.findElement(By.xpath("//table[@id=\"productTable\"]//tbody//tr[" + i + "]/td[2]")).getText(); // freezing td because we only want rows not coloumn data

                String price =
                        driver.findElement(By.xpath("//table[@id=\"productTable\"]//tbody//tr[" + i + "]/td[3]")).getText();

                driver.findElement(By.xpath("//table[@id=\"productTable\"]//tbody//tr[" + i + "]//td[4]//input[@type" +
                        "=\"checkbox\"]")).click(); // clicking the checkboxes

                System.out.println(name + "\t" + price); // printing the extracted data from the table
            }
        }


    }
}
