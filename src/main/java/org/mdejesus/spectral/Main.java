package org.mdejesus.spectral;

import org.mdejesus.spectral.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException, NotWebDriverImplementedException {
        // Create an instance of ChromeDriver.
        WebDriver driver = getDriver("Firefox");

        // Waiting for a page to be loaded.
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        // Open the Website to interact with.
        driver.get("https://www.youtube.com/");

        // Find search bar element through XPATH= //input[@id='search']
        WebElement searchBar = driver.findElement(By.xpath("//input[@id='search']"));

        // Check if element is displayed and enabled
        if(searchBar.isDisplayed() && searchBar.isEnabled()){

            // Type Selenium
            searchBar.sendKeys("Selenium");

            // Find search button element: ID = search-icon-legacy
            WebElement searchButton = driver.findElement(By.id("search-icon-legacy"));
            // Click button
            searchButton.click();
        }

        // Wait 5 seconds
        Thread.sleep(5000);

        // Close current window.
        driver.close();
    }

    public static WebDriver getDriver(String browser) throws NotWebDriverImplementedException {
        File rootPath = new File("src/main/resources/");

        if(browser.equalsIgnoreCase("chrome")){
            File chromeFilePath = new File(rootPath, "chromedriver");
            System.setProperty("webdriver.chrome.driver", chromeFilePath.getPath());
            return new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            File firefoxFilePath = new File(rootPath, "geckodriver");
            System.setProperty("webdriver.gecko.driver", firefoxFilePath.getPath());
            return new FirefoxDriver();
        }else{
            throw new NotWebDriverImplementedException("The Browser driver you're looking for is not implemented yet: " + browser);
        }

    }
}
