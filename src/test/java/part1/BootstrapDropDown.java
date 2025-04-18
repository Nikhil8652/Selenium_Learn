package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class BootstrapDropDown {
    public static void main(String[] agrs) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");

        driver.manage().window().maximize();

        //Select single option
        driver.findElement(By.xpath("//button[contains(@class,\"multiselect\")]")).click();
        driver.findElement(By.xpath("//input[@value=\"Java\"]")).click();

        //capture all options and find out the size
        List<WebElement> totalNunDropdown = driver.findElements(By.xpath("//ul[contains(@class,\"multiselect\")]//label"));

        System.out.println("Num of dropdowns:" + totalNunDropdown.size());
//

        //Printing all the options from dropdown
        for (WebElement tN : totalNunDropdown) {
            System.out.println(tN.getText());
        }

        //Select Multiple options
        for (WebElement tN : totalNunDropdown) {
            if (tN.getText().equals("Java") || tN.getText().equals("Python")) {
                tN.click();
            }
        }
    }
}
