package com.qalabs.pageobjects;

import com.qalabs.common.BasePage;
import org.checkerframework.checker.nullness.compatqual.KeyForDecl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GmailSentPage extends BasePage {

    @FindBy(how = How.CSS, using = "[class='gb_kf gb_mf']")
    private WebElement searchXButton;

    @FindBy(how = How.CSS, using = "")
    private List<WebElement> allSentEmails;

    //@FindBy(how = How.XPATH, using = "//div[@class='ae4 UI nH oy8Mbf Zs']//table[@class='F cf zt']//span/span[contains(text(),'Daniel this is a test!')]")
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'ae4 UI nH oy8Mbf')]//table[@class='F cf zt']//span/span[contains(text(),'Daniel this is a test!')]")
    private WebElement lastEmailSentText;

    public GmailSentPage(WebDriver driver){
        super(driver, "https://mail.google.com/mail/u/0/#sent");
    }

    public String getLastEmailSentText(){
            return lastEmailSentText.getText();
    }

    public void loadPage(){
        driver.get("https://mail.google.com/mail/u/0/#sent");
    }

    @Override
    public boolean isLoaded(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            //wait.until(ExpectedConditions.invisibilityOf());
            //wait.until(ExpectedConditions.textToBePresentInElement(searchBox, "in:sent"));
            wait.until(ExpectedConditions.visibilityOf(searchXButton));
            logger.info("Sent page is loaded.");
            return true;
        }catch (RuntimeException exception){
            logger.info("Sent page was not loaded. " + exception);
            return false;
        }
    }

}
