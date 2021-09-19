package org.mdejesus.spectral;

import org.mdejesus.spectral.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SearchSomethingInGoogle {
    public static void main(String[] args) throws NotWebDriverImplementedException, InterruptedException {
        WebDriver driver = WebDriverManager.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");

        assert driver.getCurrentUrl().equals("https://www.google.com/") : "Incorrect website.";

        WebElement searchTextBox = driver.findElement(By.name("q"));
        searchTextBox.sendKeys("Clase Demo - Bootcamp de Selenium Webdriver con Java. \"Mi Primer Script\"");
        searchTextBox.sendKeys(Keys.ENTER);

        Thread.sleep(5000);

        driver.close();
    }
}
