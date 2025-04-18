package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HiddenElementDropdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));


//        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        username.sendKeys("Admin");
        password.sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement dashboard = driver.findElement(By.xpath("//h6[text()='Dashboard']"));

        String verify = dashboard.getText();
        if (verify.equals("Dashboard")) {
            System.out.println("Login successfully:" + verify);
        }

        driver.findElement(By.xpath("//span[text()='PIM']")).click();

        driver.findElement(By.xpath("(//div[@class='oxd-select-wrapper']//div[@class='oxd-select-text-input' and text" +
                "()='-- Select --'])[2]")).click();

        //Click on single dropdown
        //driver.findElement(By.xpath("//span[text()='Automaton Tester']")).click();


        //count  all the option in dropdown
        List<WebElement> allOptions = driver.findElements(By.xpath("//div[@role='listbox']//span"));
        System.out.println("Total number for optins: " + allOptions);

        //printing all the options


        for (WebElement op : allOptions) {
            System.out.println(op.getText());
        }
    }
}

