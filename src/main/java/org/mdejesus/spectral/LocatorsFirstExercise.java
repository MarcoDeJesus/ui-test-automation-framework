package org.mdejesus.spectral;

import org.mdejesus.spectral.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorsFirstExercise {
    public static void main(String[] args) throws NotWebDriverImplementedException {
        WebDriver driver = WebDriverManager.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.mercadolibre.com.mx/");

        WebElement searchBox = driver.findElement(By.name("as_word"));
        searchBox.sendKeys("PS4");

        WebElement searchButton = driver.findElement(By.className("nav-search-btn"));
        searchButton.click();

        WebElement firstResult = driver.findElements(By.className("ui-search-item__title")).get(0);
        firstResult.click();

        driver.quit();
    }
}
