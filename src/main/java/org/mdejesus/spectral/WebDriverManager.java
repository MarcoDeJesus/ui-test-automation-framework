package org.mdejesus.spectral;

import org.mdejesus.spectral.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class WebDriverManager {

    public static WebDriver getDriver(String browser) throws NotWebDriverImplementedException {
        File rootPath = new File("src/main/resources/");

        if(browser.equalsIgnoreCase("chrome")){
            File chromeFilePath = new File(rootPath, "chromedriver");
            System.setProperty("webdriver.chrome.driver", chromeFilePath.getPath());
            return new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            File firefoxFilePath = new File(rootPath, "geckodriver");
            System.setProperty("webdriver.gecko.driver", firefoxFilePath.getPath());
            return new FirefoxDriver();
        }else{
            throw new NotWebDriverImplementedException("The Browser driver you're looking for is not implemented yet: " + browser);
        }
    }
}
