package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BrowserHandlePractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/"); // Getting the link for URL opening it on browser

        driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("game"); //
        // Searching the element on the search box
        driver.findElement(By.xpath("//input[@type='submit']")).click();// Clicking on the search icon for the searchbox

        List<WebElement> links = driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']/a")); //
        // Using List we are finding the all the links available for it using xpath and find elements which has a
        // return type of WebElement and not String and storing the data into a variable.

        System.out.println("Total number of links: " + links.size()); // Using size() method for LIST will get the
        // total number of links

        for (WebElement clickLink : links) {
            clickLink.click(); // By for loop clicking on each links created WebElement clicLink(return type is
            // WebElement)
        }

        Set<String> Window = driver.getWindowHandles(); // Getting the Handles for all the browsers and storing it in
        // Set collection which String type data.

        for (String Switch : Window) {// Using for loop for switching the tabs and closing it
            String title = driver.switchTo().window(Switch).getTitle(); // getting the tile beacuse by this we can
            // easily know to which title page we want to switch and this will store title for all links
            System.out.println(title); // printing all the stored titles
            if (title.equals("Game of Thrones - Wikipedia")) { // condition that if title is equals to matched title
                // then close that perticular window
                driver.close(); // closing the tab
            }
        }
    }
}
