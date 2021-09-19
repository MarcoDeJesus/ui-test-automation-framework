import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Setup the System properties with ChromeDriver information.
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        // Create an instance of ChromeDriver.
        WebDriver driver = new ChromeDriver();

        // Open the Website to interact with.
        driver.get("https://www.google.com/");

        // Printing initial site url.
        String currentUrl = driver.getCurrentUrl();
        System.out.println("CURRENT URL: " + currentUrl);

        // Navigating to a different site and printing url.
        driver.navigate().to("https://www.facebook.com/");
        currentUrl = driver.getCurrentUrl();
        System.out.println("CURRENT URL: " + currentUrl);

        // Navigating to a different site and printing url.
        driver.navigate().to("https://www.espn.com/");
        currentUrl = driver.getCurrentUrl();
        System.out.println("CURRENT URL: " + currentUrl);

        // Moving backward twice and print current url.
        driver.navigate().back();
        driver.navigate().back();
        currentUrl = driver.getCurrentUrl();
        System.out.println("CURRENT URL: " + currentUrl);

        // Moving forward once and print current url.
        driver.navigate().forward();
        currentUrl = driver.getCurrentUrl();
        System.out.println("CURRENT URL: " + currentUrl);

        // Asserting that current url is Facebook - DO NOT FORGET TO ENABLE ASSERTIONS FROM YOUR IDEA CONFIGURATION
        // VM options =  -ea
        // VM options =  -enableassertions
        assert currentUrl.equals("https://www.facebook.com/") : "Page is incorrect.";
        /*
        assert line could be replaced with a if statement.
         if (!currentUrl.equals("https://www.facebook.com/")) throw new AssertionError("Page is incorrect.");
        * */

        // Refreshing the url
        driver.navigate().refresh();
        currentUrl = driver.getCurrentUrl();
        System.out.println("CURRENT URL: " + currentUrl);

        // Close current window.
        driver.close();
    }
}
