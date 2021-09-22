package org.mdejesus.spectral;

import org.mdejesus.spectral.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LocatorsExerciseFourth {
    public static void main(String[] args) throws NotWebDriverImplementedException {
        WebDriver driver = WebDriverManager.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://es.wikipedia.org/wiki/Portada");

        System.out.println("HYPERLINKS WITH TEXT: Portada");
        WebElement linkTextPortada = driver.findElement(By.linkText("Portada"));
        System.out.println(linkTextPortada.getAttribute("href"));

        System.out.println();
        System.out.println("HYPERLINKS WITH TEXT: Página");
        List<WebElement> linkTextPaginas = driver.findElements(By.partialLinkText("Página"));
        for (WebElement linkTextPagina : linkTextPaginas) {
            System.out.println(linkTextPagina.getText());
            System.out.println(linkTextPagina.getAttribute("href"));
        }

        System.out.println();
        System.out.println("ALL BUTTONS FOUND BY TAG NAME.");
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        for (WebElement button : buttons) {
            System.out.println(button.getAttribute("title"));
        }

        driver.quit();
    }
}
