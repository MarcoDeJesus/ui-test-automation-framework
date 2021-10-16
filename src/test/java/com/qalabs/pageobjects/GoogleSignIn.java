package com.qalabs.pageobjects;

import com.qalabs.common.BasePage;
import com.qalabs.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSignIn extends BasePage {

    @FindBy(how = How.ID, using = "identifierId")
    private WebElement emailTextBox;

    @FindBy(how = How.CSS, using = ".PrDSKc > button")
    private WebElement forgetLink;

    @FindBy(how = How.CSS, using = "a[jsname='JFyozc']")
    private WebElement moreOptions;

    @FindBy(how = How.CSS, using = "button[type='button'] span")
    private WebElement nextButton;

    @FindBy(how = How.ID, using = "logo")
    private WebElement googleLogo;

    @FindBy(how = How.CLASS_NAME, using = "jGAaxb")
    private WebElement showPassword;

    public GoogleSignIn(WebDriver driver) {
        super(driver, PropertyReader.getProperty("selenium-configurations.properties", "URL"));

    }

    public GoogleSignInDenied clickNext(){
        nextButton.click();
        return new GoogleSignInDenied(driver);
    }
    public void setEMail(String in){
        emailTextBox.sendKeys(in);
    }
    public void clickForgotEmail(){
        forgetLink.click();
    }
    public void clickMoreOptions(){
     moreOptions.click();
    }

    public String getNextButtonText(){
        return nextButton.getText();
    }

    public String currentSearch(){
        return driver.getTitle();
    }

    @Override
    public boolean isLoaded(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(googleLogo));
            logger.info("Google Results page loaded: " + currentSearch());
            return true;
        }catch (RuntimeException exception){
            logger.error("Google Results page was not loaded: " + exception);
            return false;
        }
    }
}
