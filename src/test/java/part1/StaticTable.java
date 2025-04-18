package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StaticTable {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        //1)Find total number for rows in a table
        int rows = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr")).size();
        System.out.println("Number of rows: " + rows);
        //2)Find total number of columns in table
        int coloum = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//th")).size();
        //int coloum = driver.findElements(By.tagName("th")).size();
        System.out.println("Total number of coloum:" + coloum);

        //3)Read data from specific row and column
        String a = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[4]//td[1]")).getText();
        System.out.println(a);

        //4)Read all the data from the table
        for (int r = 2; r <= rows; r++) {
            for (int c = 1; c <= coloum; c++) {
                String value =
                        driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[" + c + "]")).getText();
                System.out.println(value);
            }
        }
    }
}
