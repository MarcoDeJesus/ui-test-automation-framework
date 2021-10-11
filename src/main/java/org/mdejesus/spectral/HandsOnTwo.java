package org.mdejesus.spectral;

import org.mdejesus.spectral.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandsOnTwo {
    public static void main(String[] args) throws NotWebDriverImplementedException, InterruptedException {
        WebDriver driver = WebDriverManager.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.espn.com.mx/");

        List<WebElement> leagues = driver.findElements(By.cssSelector("*[class~='league'] > div[class~='scoreboard']"));

            for(WebElement league : leagues){
                WebElement leagueName = league.findElement(By.cssSelector("h2[class~='scoreLabel_title']"));
                System.out.println("------------------------------------------------------------------------------");
                System.out.println("LEAGUE NAME: " + leagueName.getText());
                System.out.println("------------------------------------------------------------------------------");

                List<WebElement> winnerTeam = league.findElements(By.cssSelector("div > div > *[class='cscore_link'] > *[class='cscore_details'] > ul > li[class*='winner'] > div > div > span[class='cscore_name cscore_name--abbrev']"));
                List<WebElement> winnerTeamScore = league.findElements(By.cssSelector("div > div > *[class='cscore_link'] > *[class='cscore_details'] > ul > li[class*='winner'] > div > div[class='cscore_score update__score  ']"));
                System.out.println("    Winners: ");

                for(int i = 0; i < winnerTeam.size(); i++){
                    if(!winnerTeamScore.get(i).isDisplayed() || !winnerTeam.get(i).isDisplayed()){
                        WebElement rightArrowButton = driver.findElement(By.cssSelector("*[class='scores-next controls']"));
                        rightArrowButton.click();
                    }

                    System.out.println("       " + winnerTeam.get(i).getText() + "-" + winnerTeamScore.get(i).getText());
                }
            }

        driver.close();
    }
}
