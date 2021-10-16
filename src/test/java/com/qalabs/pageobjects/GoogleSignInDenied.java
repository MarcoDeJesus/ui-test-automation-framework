package com.qalabs.pageobjects;

import com.qalabs.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSignInDenied extends BasePage {
    @FindBy(how = How.CSS, using = "button[type='button'] span")
    private WebElement tryAgainButton;

    @FindBy(how = How.CSS, using = "div.daaWTb button > div.VfPpkd-RLmnJb")
    private WebElement createAccount;

    public GoogleSignInDenied(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    public String currentSearch(){
        return driver.getTitle();
    }

    public String getNextButtonText(){
        return tryAgainButton.getText();
    }

    @Override
    public boolean isLoaded(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 3);
            //wait.until(ExpectedConditions.textToBePresentInElement(tryAgainButton, "Volver"));
            wait.until(ExpectedConditions.invisibilityOfElementWithText(By.cssSelector("button[type='button'] span"), "Siguiente"));
            logger.info("Google Results page loaded: " + currentSearch());
            return true;
        }catch (RuntimeException exception){
            logger.error("Google Results page was not loaded: " + exception);
            return false;
        }
    }
}
