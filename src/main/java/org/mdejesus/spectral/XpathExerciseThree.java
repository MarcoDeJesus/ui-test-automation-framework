package org.mdejesus.spectral;

import org.mdejesus.spectral.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class XpathExerciseThree {
    public static void main(String[] args) throws NotWebDriverImplementedException, InterruptedException {
        WebDriver driver = WebDriverManager.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com.mx/");

        WebElement firstDivChildOfBody = driver.findElement(By.xpath("//body/div[1]"));
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("FIRST DIV CHILD OF BODY :");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println(firstDivChildOfBody.getText());

        WebElement lastDivChildOfBody = driver.findElement(By.xpath("//body/div[last()]"));
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("LAST DIV CHILD OF BODY: ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println(lastDivChildOfBody.getText());

        // "//*[contains(@role, 'navigation')]"
        WebElement roleAttributeWithNavigation = driver.findElement(By.xpath("//*[@role='navigation']"));
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("ROLE ATTRIBUTE WITH NAVIGATION: ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println(roleAttributeWithNavigation.getText());

        // "//*[@class='nav-title']"
        WebElement classAttributeWithNav = driver.findElement(By.xpath("//*[contains(@class, 'nav')]"));
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("CLASS ATTRIBUTE WITH NAV: ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println(classAttributeWithNav.getText());

        // "//*[@type='submit'][@class='nav-input nav-progressive-attribute']"
        WebElement submitTypeAttributeWithNavInputClass = driver.findElement(By.xpath("//*[@type='submit'][contains(@class, 'nav-input')]"));
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("SUBMIT TYPE ATTRIBUTE WITH NAV-INPUT CLASS: ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println(submitTypeAttributeWithNavInputClass.getText());

        Thread.sleep(10000);

        driver.close();
    }
}
