package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocatorsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com.gr/");

        //name
        //driver.findElement(By.name("search")).sendKeys("mac");

        //id
        //boolean logoDisplayStatus = driver.findElement(By.id("logo")).isDisplayed();
        //System.out.println(logoDisplayStatus);

        //LinkText and PartialText
        //driver.findElement(By.linkText("Tablets")).click();

        //PartialText
        //driver.findElement(By.partialLinkText("Tab")).click();

        //Classname
//        List<WebElement> headerlinks = driver.findElements(By.className("hidden-md"));
//        System.out.println("Total number of header links:" + headerlinks.size());

        //tagName
        //List<WebElement> links = driver.findElements(By.tagName("a"));
        //System.out.println("Total links" + links.size());


        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Images number: " + images.size());
    }


}
