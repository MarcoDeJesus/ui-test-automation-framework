package org.mdejesus.spectral;

import org.mdejesus.spectral.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LocatorsThirdExerciseHomework {
    public static void main(String[] args) throws NotWebDriverImplementedException {
        WebDriver driver = WebDriverManager.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.nasa.gov/");

        System.out.println("HYPERLINKS WITH TEXT: MISSION");
        List<WebElement> missionLinks = driver.findElements(By.xpath("//a[contains(text(), 'Mission')]"));
        for (WebElement mission: missionLinks ) {
            System.out.println(mission.getAttribute("href"));
        }

        System.out.println("HYPERLINKS WITH TEXT: NASA TV");
        List<WebElement> nasaTVLinks = driver.findElements(By.xpath("//a[contains(text(), 'NASA TV')]"));
        for (WebElement nasaTVLink: nasaTVLinks ) {
            System.out.println(nasaTVLink.getAttribute("href"));
        }

        System.out.println("HYPERLINKS WITH TEXT: Mars");
        List<WebElement> marsLinks = driver.findElements(By.xpath("//a[contains(text(), 'Mars')]"));
        for (WebElement marsLink: marsLinks ) {
            System.out.println(marsLink.getAttribute("href"));
        }

        System.out.println("ELEMENTS OF WITH INPUT TAG NAME.");
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        for (WebElement input: inputs ) {
            System.out.println(input.getAttribute("value"));
        }

        driver.quit();
    }
}
