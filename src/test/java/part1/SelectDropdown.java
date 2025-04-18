package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SelectDropdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        driver.manage().window().maximize();

        WebElement drpCountryele = driver.findElement(By.xpath("//select[@id='country']"));

        Select dropDown = new Select(drpCountryele);

        // select option from dropdown
        //selectByVisibleText()
        //selectByvalue()
        //selectByIndex()


        // Select Tag
        //dropDown.selectByVisibleText("France");// normal text

        //dropDown.selectByValue("japan"); // only if tag has value option

        //dropDown.selectByIndex(2); // from index

        // Validation - how many total number of options there in dropdown

        List<WebElement> options = dropDown.getOptions();
        System.out.println("Number of options in a dropdown :" + options.size());

        //printing the options
       /* for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }

        */

        for (WebElement op : options) {
            System.out.println(op.getText());
        }
    }
}
