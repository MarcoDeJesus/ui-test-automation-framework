package org.mdejesus.spectral;

import org.mdejesus.spectral.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandsOnThree {
    public static void main(String[] args) throws NotWebDriverImplementedException, InterruptedException {
        WebDriver driver = WebDriverManager.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.inaturalist.org/");

        WebElement moreList = driver.findElement(By.id("header-more-dropdown-toggle"));

        Actions actions = new Actions(driver);
        actions.moveToElement(moreList);

        WebElement placesLink = driver.findElement(By.cssSelector("li > a[href*='places']"));
        actions.moveToElement(placesLink);

        actions.click().build().perform();

        WebElement searchBox = driver.findElement(By.id("q"));
        searchBox.sendKeys("Bosque los Colomos");

        WebElement searchButton = driver.findElement(By.name("commit"));
        searchButton.click();

        WebElement searchResultOption = driver.findElement(By.xpath("//a[contains(@href,'/places/bosque-los-colomos-ja-mx')]"));
        searchResultOption.click();

        List<WebElement> allCategoryLinks = driver.findElements(By.cssSelector(".taxon_links a"));
        List<String> hrefsCategoryLinks = new ArrayList<>();

        for(WebElement categoryLink : allCategoryLinks){
            hrefsCategoryLinks.add(categoryLink.getAttribute("href"));
        }

        for(int i=0; i < allCategoryLinks.size(); i++){
            driver.navigate().to(hrefsCategoryLinks.get(i));

            List<WebElement> elementsFromSubCategory = driver.findElements(By.cssSelector(".guide_taxa .comname"));

            if(elementsFromSubCategory.size() > 0){
                System.out.println(elementsFromSubCategory.get(0).getText());
            }else{
                List<WebElement> noFound = driver.findElements(By.cssSelector(".taxon_links a"));
                System.out.println("Category: "+ noFound.get(i).getText() +". Elementos no encontrados.");
            }
        }

        driver.close();
    }
}
