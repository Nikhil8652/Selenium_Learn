package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DynamicPaginationTable {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com.gr/admin/index.php?route=common/login");
        driver.manage().window().maximize();

        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("demo");

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("demo");

        driver.findElement(By.cssSelector(".btn")).click();

        driver.findElement(By.xpath("//li[@id=\"menu-customer\"]//a[@class=\"parent collapsed\"]")).click(); //
        // parent customer element
        driver.findElement(By.xpath("//ul[@id=\"collapse33\"]//a[contains(text(),'Customers')]")).click(); //clicking
        // on the sub menu of the customer class

        String s = driver.findElement(By.xpath("//div[@class=\"col-sm-6 text-right\"]")).getText(); // number of
        // pages message
        System.out.println(s);

        int total_pages = Integer.parseInt(s.substring(s.indexOf("(") + 1, s.indexOf("Pages") - 1)); // getting the
        // total number of pages and converting it to integers
        System.out.println(total_pages);

        //driver.findElements(By.xpath("//ul[@class=\\\"pagination"]//*[text()=\" + p +\"))
        // ul[@class=\"pagination\"]//*[text()=" + p +"

        //repeating pages
        for (int p = 1; p < total_pages; p++) { // clicking on the each page
            if (p > 1) {
                WebElement active_page = driver.findElement(By.xpath("//ul[@class=\"pagination\"]//*[text()=" + p +
                        "]")); // not to click on 1st page checking
                active_page.click();
                Thread.sleep(3000);
            }

            // reading data from perticular page
            int noOfRows = driver.findElements(By.xpath("//table[@class=\"table table-bordered table-hover\"]//tbody//tr")).size();
            for (int r = 1; r <= noOfRows; r++) {
                String customerName = driver.findElement(By.xpath("//table[@class=\"table table-bordered " +
                        "table-hover\"]//tbody//tr[" + r + "]//td[2]")).getText();
                String customerEmail = driver.findElement(By.xpath("//table[@class=\"table table-bordered " +
                        "table-hover\"]//tbody//tr[" + r + "]//td[3]")).getText();

                System.out.println(customerName + "\t" + customerEmail);
            }
        }
    }
}
