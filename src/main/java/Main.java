import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Setup the System properties with ChromeDriver information.
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        // Create an instance of ChromeDriver.
        WebDriver driver = new ChromeDriver();

        // Open the Website to interact with.
        driver.get("http://automationpractice.com/index.php");

        // Wait
        Thread.sleep(1000);

        // Close current window.
        driver.close();
    }
}
