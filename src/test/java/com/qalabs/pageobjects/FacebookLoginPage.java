package com.qalabs.pageobjects;

import com.qalabs.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookLoginPage extends BasePage {

    @FindBy(how = How.CSS, using = "img.fb_logo")
    private WebElement facebookLogo;

    @FindBy(how = How.ID, using = "email")
    private WebElement emailTextBox;

    @FindBy(how = How.NAME, using = "pass")
    private WebElement passwordTextBox;

    @FindBy(how = How.NAME, using = "login")
    private WebElement loginButton;

    public FacebookLoginPage(WebDriver driver) {
        super(driver, "https://www.facebook.com/");
    }

    public FacebookHomePage login(String email, String password){
        emailTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        loginButton.click();

        return new FacebookHomePage(driver);
    }

    @Override
    public boolean isLoaded(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(facebookLogo));
            logger.info("Facebook login page is loaded.");
            return true;
        }catch(RuntimeException exception){
            logger.error("Facebook login page was not loaded. "+ exception);
            return false;
        }
    }
}
