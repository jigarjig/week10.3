package browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowseing {
    static String browser = "";  //
    static String baseurl = "https://www.saucedemo.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        // browser = "chrome";
        //browser = "edge";
        browser = "firefox";


        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.geco.driver", "src/drivers/geckodriver.exe"); //setting webriver
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "src/driver/msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println("not valid browser ");
        }
        driver.get(baseurl);// method to invoke url
        driver.manage().window().maximize();  //maximising windows
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  // timeout session
        String url = driver.getCurrentUrl();
        System.out.println("Current url" + url);  // printing url
        String source = driver.getPageSource();
        System.out.println("Page source" + source); // printing page source

        WebElement emailIDField = driver.findElement(By.id("user-name")); // storing  email/username
        emailIDField.sendKeys("standard_user");  //sendin key to email/username
        WebElement passwordField = driver.findElement(By.id("password"));  // storing password
        passwordField.sendKeys("secret_sauce");  // sending key to password
        driver.findElement(By.id("login-button")).click();  // clickin on login button

    }
    }