package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandleChecbox {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        //1)select specific checkbox
        //driver.findElement(By.xpath("//input[@id='sunday']")).click();

        //2)select all check boxex
        List<WebElement> checboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));

//        for (int i = 0; i < checboxes.size(); i++) {
//            checboxes.get(i).click();
//        }

      /*  for (WebElement check : checboxes) {
            check.click();
        }

       */

        //3)select last 3 checkboxes

        for (int i = 4; i < checboxes.size(); i++) {
            checboxes.get(i).click();
        }
    }
}
