import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookDemo {
    public static void main(String[] args){
       // initialize the web driver
       WebDriver driver = new ChromeDriver();
        //Navigate to facebook page
        driver.get("http://www.facebook.com/");
        //Maximize the window
        driver.manage().window().maximize();
        //Verify homepage redirection
        if(driver.getTitle().contains("Facebook"))
        {
            System.out.println("Successfully redirected to Facebook homepage.");
        }
        else
        {
            System.out.println("Failed to redirect to Facebook homepage.");
        }
        //Click on "Create new account" button
        WebElement createAccountButton= driver.findElement(By.xpath("//a[contains(text(),'Create new account')]"));
        createAccountButton.click();

        //wait for the sign-up form to appear
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));

        // Fill in sign-up form
        driver.findElement(By.name("firstname")).sendKeys("Test");

        driver.findElement(By.name("lastname")).sendKeys("User");

        driver.findElement(By.name("reg_email_")).sendKeys("testuser@gmail.com");
        driver.findElement(By.name("reg_email_confirmation_")).sendKeys("testuser@gmail.com");

        driver.findElement(By.name("reg_passwd_")).sendKeys("StrongPassword123");


        // Select date of birth
        Select daySelect = new Select(driver.findElement(By.name("day")));
        daySelect.selectByVisibleText("29");

        Select monthSelect = new Select(driver.findElement(By.name("month")));
        monthSelect.selectByVisibleText("December");

        Select yearSelect = new Select(driver.findElement(By.name("year")));
        yearSelect.selectByVisibleText("1995");

        // Select gender
        driver.findElement(By.xpath("//input[@value='2']")).click();
        // value ='2' for Male, value='1' for Female

        // Click on "Sign Up" button
        driver.findElement(By.name("websubmit")).click();

        // Verify successful registration
        if (driver.getTitle().contains("Facebook")) {
            System.out.println("Successfully registered on Facebook.");
        } else {
            System.out.println("Failed to register on Facebook.");
        }

        // Close the browser
        driver.quit();


    }
}