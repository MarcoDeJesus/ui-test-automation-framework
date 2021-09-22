package org.mdejesus.spectral;

import org.mdejesus.spectral.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LocatorsSecondExercise {
    public static void main(String[] args) throws NotWebDriverImplementedException {
        WebDriver driver = WebDriverManager.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        driver.get("https://www.google.com.mx/");

        WebElement searchTextBox = driver.findElement(By.id("ThisIdIsInvalid"));

        driver.close();
    }
}
