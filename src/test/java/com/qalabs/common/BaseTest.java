package com.qalabs.common;

import org.mdejesus.spectral.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    @BeforeSuite
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser){
        try {
            driver = getDriver(browser);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (NotWebDriverImplementedException e) {
            e.printStackTrace();
        }
    }

    private static WebDriver getDriver(String browser) throws NotWebDriverImplementedException {
        File rootPath = new File("/home/marcodejesus/IdeaProjects/BPA-Agosto2021/ui-test-automation-framework/src/main/resources/");

        if(browser.equalsIgnoreCase("chrome")){
            File chromeFilePath = new File(rootPath, "chromedriver");
            System.setProperty("webdriver.chrome.driver", chromeFilePath.getPath());
            return new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            File firefoxFilePath = new File(rootPath,
                    "geckodriver");
            System.setProperty("webdriver.gecko.driver", firefoxFilePath.getPath());
            return new FirefoxDriver();
        }else{
            throw new NotWebDriverImplementedException("The Browser driver you're looking for is not implemented yet: " + browser);
        }
    }

    @AfterSuite
    public void tearDown(){
        driver.close();
    }
}
