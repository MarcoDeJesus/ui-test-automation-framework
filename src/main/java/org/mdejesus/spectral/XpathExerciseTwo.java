package org.mdejesus.spectral;

import org.mdejesus.spectral.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class XpathExerciseTwo {
    public static void main(String[] args) throws NotWebDriverImplementedException, InterruptedException {
        WebDriver driver = WebDriverManager.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com.mx/");

        List<WebElement> allHyperlinks = driver.findElements(By.xpath("//a"));

        System.out.println("ALL HYPERLINKS TEXT: ");
        for (WebElement hyperlink : allHyperlinks) {
            System.out.println(hyperlink.getText());
        }

        List<WebElement> allChildElementsOfHead = driver.findElements(By.xpath("//head/*"));

        System.out.println("ALL CHILD ELEMENTS CONTENT: ");
        for (WebElement child : allChildElementsOfHead) {
            System.out.println(child.getAttribute("innerHTML"));
        }

        Thread.sleep(10000);

        driver.close();
    }
}
