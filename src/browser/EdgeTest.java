package browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class EdgeTest {
    public static void main(String[] args) {
        String baseurl = "https://www.saucedemo.com/"; // storing base url
        System.setProperty("webdriver.edge.driver", "src/driver/msedgedriver.exe"); //setting webdriver
        WebDriver driver = new EdgeDriver(); // creatin object of edge webdriver
        driver.get(baseurl); // method to invoke url

        driver.manage().window().maximize();  //maximising windows
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  // timeout session

        String title = driver.getTitle();
        System.out.println("Title of the page :" + title);  // printing title
        String url = driver.getCurrentUrl();
        System.out.println("Current url" + url);  // printing url
        String source = driver.getPageSource();
        System.out.println("page source :" + source); // printing page source


        WebElement emailIDField = driver.findElement(By.id("user-name")); //storing  email/username
        emailIDField.sendKeys("standard_user");  // sending key to email/username
        WebElement passwordField = driver.findElement(By.id("password")); // storing password
        passwordField.sendKeys("secret_sauce");  // sending key to password
        driver.findElement(By.id("login-button")).click();  // clicking on login button
    }
}


