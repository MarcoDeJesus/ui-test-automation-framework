package org.mdejesus.spectral;

import org.mdejesus.spectral.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HansOnOne {
    public static void main(String[] args) throws NotWebDriverImplementedException, InterruptedException {
        WebDriver driver = WebDriverManager.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com.mx");

        WebElement searchTextBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchTextBox.sendKeys("Nintendo Switch");
        searchTextBox.submit();
        //searchTextBox.sendKeys(Keys.ENTER);

        /*
            Finding the input element:
            Xpath: //li[@id="p_89/Nintendo Switch"]/span/a/div/label/input
            CSS Selector: li[id='p_89/Nintendo Switch'] > span > a > div > label > input[type=checkbox]
        */

        // Finding the <i> element, which is above the <input> element
        // WebElement nintendoSwitchCheckBox = driver.findElement(By.xpath("//li[@id=\"p_89/Nintendo Switch\"]/span/a/div/label/i"));
        //WebElement nintendoSwitchCheckBox = driver.findElement(By.cssSelector("li[id='p_89/Nintendo Switch'] > span > a > div > label > i"));

        //nintendoSwitchCheckBox.click();
        //nintendoSwitchCheckBox.click();

        // Finding the <label> element to be clicked
        WebElement nintendoSwitchLabel = driver.findElement(By.cssSelector("#p_89\\/Nintendo\\ Switch > span > a > span"));
        nintendoSwitchLabel.click();

        WebElement fourStarsLink = driver.findElement(By.xpath("//i[@class='a-icon a-icon-star-medium a-star-medium-4']"));
        fourStarsLink.click();

        WebElement orderByElement = driver.findElement(By.cssSelector(".a-dropdown-container"));
        orderByElement.click();

        WebElement lowestToHighest = driver.findElement(By.xpath("//a[@id='s-result-sort-select_1']"));
        lowestToHighest.click();

        // Long xpath: "//*[@id='search']/div[1]/div[1]/div/span[3]/div[2]/div[1]/div/span/div/div/div[2]/div[2]/div/div/div[1]/h2/a/span"
        List<WebElement> lowestPriceElement = driver.findElements(By.cssSelector("span[class='a-size-medium a-color-base a-text-normal']"));
        System.out.println("Product with the lowest price: " + lowestPriceElement.get(0).getText());

        driver.close();
    }
}
