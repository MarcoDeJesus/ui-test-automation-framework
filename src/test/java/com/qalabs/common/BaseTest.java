package com.qalabs.common;

import org.mdejesus.spectral.exceptions.NotWebDriverImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
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
        //https://stackoverflow.com/questions/38684175/how-to-click-allow-on-show-notifications-popup-using-selenium-webdriver

        File rootPath = new File("/home/marcodejesus/IdeaProjects/BPA-Agosto2021/ui-test-automation-framework/src/main/resources/");

        if(browser.equalsIgnoreCase("chrome")){
            // https://chromedriver.chromium.org/capabilities
            // https://peter.sh/experiments/chromium-command-line-switches/

            Map<String, Object> prefs = new HashMap<String, Object>();
            //add key and value to map as follows to switch off browser notification
            //Pass the argument 1 to allow and 2 to block
            prefs.put("profile.default_content_setting_values.notifications", 2);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);

            File chromeFilePath = new File(rootPath, "chromedriver");
            System.setProperty("webdriver.chrome.driver", chromeFilePath.getPath());
            return new ChromeDriver(options);
        }else if(browser.equalsIgnoreCase("firefox")){
            //https://searchfox.org/mozilla-central/source/browser/app/profile/firefox.js#571

            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("permissions.default.desktop-notification", 1);
            DesiredCapabilities capabilities=DesiredCapabilities.firefox();
            capabilities.setCapability(FirefoxDriver.PROFILE, profile);

            File firefoxFilePath = new File(rootPath,"geckodriver");
            System.setProperty("webdriver.gecko.driver", firefoxFilePath.getPath());
            return new FirefoxDriver(capabilities);
        }else{
            throw new NotWebDriverImplementedException("The Browser driver you're looking for is not implemented yet: " + browser);
        }
    }

    @AfterSuite
    public void tearDown(){
        driver.close();
    }
}
