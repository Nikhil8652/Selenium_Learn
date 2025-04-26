package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TablePractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();

        //Select the first dropdown
        WebElement dropdown1 = driver.findElement(By.xpath("//select[@name=\"fromPort\"]"));

        Select dropone = new Select(dropdown1);
        dropone.selectByValue("Philadelphia");

        WebElement dropdown2 = driver.findElement(By.xpath("//select[@name=\"toPort\"]"));

        Select droptwo = new Select(dropdown2);
        droptwo.selectByValue("Rome");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //table[@class="table"]//tr//td[6]
        List<WebElement> table = driver.findElements(By.xpath("//table[@class=\"table\"]//tr//td[6]"));
        System.out.println("Table size :" + table.size());

//        String arr = Arrays.toString(new int[5]);
        List<String> rowData = new ArrayList<>(); // use this to store the value in arraylist since element is list
        // collection so use ArrayList()

//        for (int i = 0; i < table.size(); i++) {
//            System.out.println(table.get(i).getText());  // storing values (e.g., 0, 2, 4, 6, 8)
//        }

        for (WebElement webElement : table) {
            String cellText = webElement.getText();  // use 'i' to get each element or create a variable and use
            // advance for loop
            rowData.add(cellText);                    // store to list this way we can store data in arraylist

        }
//        for (String data : rowData) {
//            System.out.println(data);
//        }
//        Collections.sort(rowData); // sorting the arraylist not array since we have worked on arrayList
//        System.out.println(rowData);

        Collections.sort(rowData);
        System.out.println(rowData);
//        for (String data : rowData) {
//            if (data.contains("$200.98")) {
//                System.out.println("Match found: " + data);
//                driver.findElement(By.xpath("//table[@class=\"table\"]//tr[3]//td[1]//input[@type=\"submit\"]")).click();
//                // Optional: perform action or break
//            }
//        }

        if (rowData.contains("$200.98")) {
            driver.findElement(By.xpath("//table[@class=\"table\"]//tr[3]//td[1]//input[@type=\"submit\"]")).click();
        }


    }
}
