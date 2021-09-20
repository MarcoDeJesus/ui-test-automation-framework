package org.mdejesus.spectral;

import org.mdejesus.spectral.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class SearchOnWikipedia {
    public static void main(String[] args) throws NotWebDriverImplementedException, InterruptedException {
        WebDriver driver = WebDriverManager.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");

        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys("Selenium");

        Thread.sleep(1000);

        WebElement firstOptionFromDropdown = driver.findElement(By.xpath("//*[@id=\"typeahead-suggestions\"]/div/a[1]"));
        firstOptionFromDropdown.click();

        List<WebElement> paragraphWithSearchTopic = driver.findElements(By.xpath("//p[contains(text(), 'Selenium')]"));
        WebElement firstHeading = driver.findElement(By.tagName("h1"));

        System.out.println("CURRENT URL: " + driver.getCurrentUrl());
        System.out.println("SEARCH TOPIC: " + firstHeading.getText());
        System.out.println("TOTAL NUMBER OF <p> ELEMENTS THAT CONTAINS THE SEARCH TOPICS IN THEIR TEXT IS: " + paragraphWithSearchTopic.size());

        List<WebElement> anchorsWithSearchTopic = driver.findElements(By.xpath("//a[contains(text(), 'Selenium')]"));

        Map<String, WebElement> links = new LinkedHashMap<>();

        for (WebElement anchor : anchorsWithSearchTopic){
            links.put(anchor.getAttribute("href"), anchor);
        }

        System.out.println("TOTAL NUMBER OF <a> ELEMENTS THAT CONTAINS THE SEARCH TOPICS IN THEIR TEXT IS: " + links.size());

        for(Map.Entry<String, WebElement> link : links.entrySet()){
            try{
                if(link.getKey() != null)
                    driver.navigate().to(link.getKey());

                System.out.println("CURRENT URL: " + driver.getCurrentUrl());
                System.out.println("SEARCH TOPIC FROM TITLE PAGE: " + driver.getTitle());
            }catch (WebDriverException ex){
                System.out.println("PAGE IS NOT AVAILABLE");
            }
        }

        Thread.sleep(5000);

        driver.quit();
    }
}
