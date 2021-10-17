package com.qalabs.pageobjects;

import com.qalabs.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePopupPage extends BasePage {

    @FindBy(how = How.CSS, using = "[class='gb_Ha gbip gb_eb'][title='Profile']")
    private WebElement imageProfile;

    @FindBy(how = How.CSS, using = "[class='gb_lb gb_mb']")
    private WebElement profileName;

    @FindBy(how = How.CLASS_NAME, using = "gb_nb")
    private WebElement email;

    public ProfilePopupPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    public String getProfileName(){
        return profileName.getText();
    }

    public String getEmail(){
        return email.getText();
    }

    public boolean isProfileNameDisplayed(){
        return profileName.isDisplayed();
    }

    public boolean isEmailDisplayed(){
        return email.isDisplayed();
    }

    @Override
    public boolean isLoaded() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(imageProfile));
            logger.info("Popup shown.");
            return true;
        }catch(RuntimeException exception){
            logger.info("Popup not shown.");
            return false;
        }
    }
}
