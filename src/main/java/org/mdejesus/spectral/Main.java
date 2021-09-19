package org.mdejesus.spectral;

import org.mdejesus.spectral.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException, NotWebDriverImplementedException {
        // Create an instance of ChromeDriver.
        WebDriver driver = WebDriverManager.getDriver("Firefox");

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
}
