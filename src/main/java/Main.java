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

        // Printing page title
        String pageTitle = driver.getTitle();
        System.out.println("PAGE TITLE: " + pageTitle);

        // Printing current url
        String currentUrl = driver.getCurrentUrl();
        System.out.println("CURRENT URL: " + currentUrl);

        // Printing source code
        String pageSource = driver.getPageSource();
        System.out.println("PAGE SOURCE: " + pageSource);

        // Close current window.
        driver.close();
    }
}
