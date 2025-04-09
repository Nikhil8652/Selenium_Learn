package part1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocators {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        //tag id         tag#id
        //driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirts");
        //driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("T-shirts");

        //tag classname   tag.classname
        //driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("hello");
        //driver.findElement(By.cssSelector(".search-box-text")).sendKeys("hello");

        //tag attribute   tag[attribute="value"]
        //driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("hello");
        //driver.findElement(By.cssSelector("[placeholder='Search store']")).sendKeys("hello");

        //tag class attribute
        //driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("hello");
        //driver.findElement(By.cssSelector(".search-box-text[name='q']")).sendKeys("hello");

    }
}
