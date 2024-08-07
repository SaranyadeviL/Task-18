import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JQueryDemo {
    public static void main(String[] args) {
        //initialize the web browser
        WebDriver driver=new ChromeDriver();
        //Maximize the window
        driver.manage().window().maximize();
        //Navigate the website
        driver.get("http://jqueryui.com/droppable/");
        // Switch to the frame containing the draggable elements
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        // Find the source and target elements
        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.xpath("//div[@id='droppable']"));

        // Perform the drag and drop operation
        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceElement, targetElement).build().perform();

        // Switch back to the default content
        driver.switchTo().defaultContent();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));


        // Verify the color property of the target element's CSS

        String targetColor=targetElement.getCssValue("background-color");
        System.out.println(targetElement.getCssValue("background-color"));
        if (targetColor.equals("rgba(255, 250, 144, 1)"))
        {
            System.out.println("Drag and drop operation successful - Target element color changed!");
        }
        else
        {
            System.out.println("Drag and drop operation failed - Target element color did not change!");
        }

        // Verify the text of the target element
        String targetText = targetElement.getText();
        if (targetText.equals("Dropped!"))
        {
            System.out.println("Text of the target element changed to 'Dropped!' - Verification successful!");
        }
        else
        {
            System.out.println("Text of the target element did not change to 'Dropped!' - Verification failed!");
        }

        // Close the browser
        driver.quit();


    }
}
