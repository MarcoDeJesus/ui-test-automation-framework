import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");

/*         Below code could be summarized as:
        new FirefoxOptions().setBinary(new FirefoxBinary(new File("src/main/resources/geckodriver")));*/
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        File geckoDriverFile = new File("src/main/resources/geckodriver");
        FirefoxBinary firefoxBinary = new FirefoxBinary(geckoDriverFile);
        firefoxOptions.setBinary(firefoxBinary);

        WebDriver driver = new FirefoxDriver();

        driver.get("http://automationpractice.com/index.php");
    }
}
