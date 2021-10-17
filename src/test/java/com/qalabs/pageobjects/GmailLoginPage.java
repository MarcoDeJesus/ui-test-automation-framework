package com.qalabs.pageobjects;

import com.qalabs.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginPage extends BasePage {

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

    @FindBy(how = How.CLASS_NAME, using = "o6cuMc")
    private WebElement errorMessage;

    public GmailLoginPage(WebDriver driver){
        super(driver, "https://www.gmail.com");
    }

    public GmailPasswordPage enterGmailAccount(String gmailAccount){
        emailTextBox.clear();
        emailTextBox.sendKeys(gmailAccount);
        nextButton.click();

        return new GmailPasswordPage(driver);
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }
    @Override
    public boolean isLoaded(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(googleLogo));
            logger.info("Gmail page has been loaded.");
            return true;
        }catch (RuntimeException exception){
            logger.info("Gmail page has not been loaded.");
            return false;
        }
    }
}
