package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register");

        driver.manage().window().maximize();

        //isDisplayed() --> tells whether element is display or not in true and false format
       /* WebElement display = driver.findElement(By.xpath("//img[@alt=\"nopCommerce demo store\"]"));
        System.out.println("status of logo" + display.isDisplayed());

        boolean display2 = driver.findElement(By.xpath("//img[@alt=\"nopCommerce demo store\"]")).isDisplayed();
        System.out.println(display2);

        */

        //isEnabled() ---> checks element is enabled or not (radio button or checkbox, button , dropdown)
       /* boolean enable = driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled();
        System.out.println(enable);

        */

        //isSelected() --> use to check if the element is selected or not radio or checkboxes
        boolean select = driver.findElement(By.xpath("//input[@id='gender-male']")).isSelected();
        System.out.println("Before selection of radio button-------------");
        System.out.println("Radio button is selected : " + select);

        driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        boolean selected = driver.findElement(By.xpath("//input[@id='gender-male']")).isSelected();
        System.out.println("After selection-------");
        System.out.println(selected);
    }
}
