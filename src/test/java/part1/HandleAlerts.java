package part1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //Normal alerts with OK button
        /*driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);
        Alert myAlert = driver.switchTo().alert();
        System.out.println(myAlert.getText());
        myAlert.accept();

         */

        //Confirmation ALert - OK & Cancel
       /* driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);

        //driver.switchTo().alert().accept();// Close Alert using OK button
        //driver.switchTo().alert().dismiss();//close alert using cancel button

        */

        //Prompt ALert - input box
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);
        Alert myPromptLAlert = driver.switchTo().alert();
        myPromptLAlert.sendKeys("Welcome");
        myPromptLAlert.accept();
    }
}
