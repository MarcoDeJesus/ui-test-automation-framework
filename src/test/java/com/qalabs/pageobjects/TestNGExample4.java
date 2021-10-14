package com.qalabs.pageobjects;

import com.qalabs.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class TestNGExample4 extends BaseTest {
    @Test(description = "Open google page", alwaysRun=true, groups = {"regression"})
    @Parameters({"baseUrl"})
    public void openGoogle(@Optional("https://www.google..mx/")String baseUrl) {
        driver.get("https://www.google.com.mx/");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl,  "Didn't get expected google url");
    }

    @Test(description = "Search selenium in google search box",
            dependsOnMethods = {"openGoogle"}, groups = {"regression"})
    public void searchSelenium(){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.sendKeys(Keys.ENTER);
        List<WebElement> results = driver.findElements(By.xpath("//h3[contains(@class,'LC20lb')]"));
        Assert.assertTrue(results.size() > 0, "Didn't get any result");
    }
}
