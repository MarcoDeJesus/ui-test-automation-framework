package org.mdejesus.spectral;

import org.mdejesus.spectral.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginIntoFacebookAndSearchQAMinds {
    public static void main(String[] args) throws NotWebDriverImplementedException, InterruptedException {
        WebDriver driver = WebDriverManager.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");

        WebElement emailTextBox = driver.findElement(By.id("email"));
        emailTextBox.sendKeys("email@email.com");

        WebElement pass = driver.findElement(By.id("pass"));
        pass.sendKeys("12345");

        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();

        Thread.sleep(10000);

        WebElement searchTextBox = driver.findElement(By.xpath("//input[@type='search']"));
        searchTextBox.sendKeys("QA Minds");
        searchTextBox.sendKeys(Keys.ENTER);

        Thread.sleep(10000);

        driver.quit();
    }
}
