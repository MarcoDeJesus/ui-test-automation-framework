package com.qalabs.pageobjects;

import org.mdejesus.spectral.WebDriverManager;
import org.mdejesus.spectral.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestNGExercise1 {
    @Test
    public void validateGoogleUrl() throws NotWebDriverImplementedException {
        WebDriver driver = WebDriverManager.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.google.com.mx/");

        String expected = "https://www.google.com.mx/?gws_rd=ssl";

        String actual = driver.getCurrentUrl();

        assertEquals(actual, expected, "Url is incorrect.");
    }
}
