package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class PracticeDropdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
        driver.manage().window().maximize();

        WebElement dropdown = driver.findElement(By.xpath("//select[@id='country-list']"));

        //Task 1
        //Select dropdown1 = new Select(dropdown);
        //dropdown1.selectByValue("1"); // option for value when there is option available

        List<WebElement> dropdown1 = driver.findElements(By.xpath("//select[@id='country-list']"));
        System.out.println("Totol number of options:" + dropdown1);

        for (WebElement op : dropdown1) {
            System.out.println(op.getText());
        }

    }
}
