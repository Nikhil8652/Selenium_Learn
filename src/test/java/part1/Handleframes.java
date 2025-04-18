package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Handleframes {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();
        //driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome");

        //Frame1
        WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));


        driver.switchTo().frame(frame1); // passed frame as w webelement // switch to frame1


        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome");


        driver.switchTo().defaultContent(); // go back to page main page outside the frame
        //Frame2 switchTo from 1 to another
        WebElement frame2 = driver.findElement(By.xpath("//frame[@src=\"frame_2.html\"]")); // created the variable
        // with the frame2 name with type of WebElement

        driver.switchTo().frame(frame2); // switching to frame 2
        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Welcoem2");

        driver.switchTo().defaultContent(); // go back to main page

        //Frame3
        WebElement frame3 = driver.findElement(By.xpath("//frame[@src=\"frame_3.html\"]"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Java");


        //inner iframe - part of frame 3
        driver.switchTo().frame(0); // switching using the index only when u have 1 frame inside another main frame
        driver.findElement(By.xpath("//div[@id=\"i9\"]//div[@class=\"AB7Lab Id5V1\"]")).click();

    }
}
