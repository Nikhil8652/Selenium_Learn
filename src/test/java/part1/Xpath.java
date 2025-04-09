package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.opencart.com.gr/");
        //Xpath with single attribute
        //driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("hello");

        //Xpath with multiple attribute
//        driver.findElement(By.xpath("//input[@name='search' and @placeholder='Search']")).sendKeys("hello");
//        driver.findElement(By.xpath("//input[@name='search' or @placeholder='Search']")).sendKeys("hello");


        //Xpath with text() -- innertext
        //driver.findElement((By.xpath("//a[text()='Desktops']"))).click();
//        boolean innertext = driver.findElement(By.xpath("//h3[text()='Featured']")).isDisplayed();
//        System.out.println(innertext);

//        String value = driver.findElement(By.xpath("//h3[text()='Featured']")).getText();
//        System.out.println(value);


        //Xpath with contains method
        // driver.findElement(By.xpath("//input[contains(@placeholder,'Sea')]")).sendKeys("hhelo");

        //Xpath with starts-with method
        //driver.findElement(By.xpath("//input[starts-with(@placeholder,'Sea')]")).sendKeys("hhelo");

        // if we want to use dynamic handling with xpath
        // Then we can use the contains method or starts-with or OR method

        //Chained Xpath
        boolean imagestatus = driver.findElement((By.xpath("//div[@id='logo']/h1/a"))).isDisplayed();
        System.out.println(imagestatus);
    }
}
