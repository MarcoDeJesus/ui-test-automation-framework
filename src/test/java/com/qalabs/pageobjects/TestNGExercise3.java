package com.qalabs.pageobjects;

import com.qalabs.common.BaseTest;
import org.mdejesus.spectral.WebDriverManager;
import org.mdejesus.spectral.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestNGExercise3 extends BaseTest {
    @Test
    public void validateGoogleUrl()  {
        driver.get("https://www.google.com.mx/");

        String expected = "https://www.google.com.mx/";

        String actual = driver.getCurrentUrl();

        assertEquals(actual, expected, "Url is incorrect.");
    }
}
