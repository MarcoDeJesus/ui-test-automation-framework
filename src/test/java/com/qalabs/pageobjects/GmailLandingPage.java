package com.qalabs.pageobjects;

import com.qalabs.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GmailLandingPage extends BasePage {

    @FindBy(how = How.CSS, using = "[class='gb_tc']")
    private WebElement gmailLogo;

    @FindBy(how = How.CSS, using = "table > tbody td[role='heading']")
    private List<WebElement> inboxMainTabs;

    @FindBy(how = How.CSS, using = "div[class='aKz']")
    private List<WebElement> inboxMainTabsText;

    @FindBy(how = How.CSS, using = ".xY.a4W")
    private List<WebElement> allEmailDescription;

    @FindBy(how = How.CSS, using = ".xW.xY")
    private List<WebElement> allEmailDates;

    @FindBy(how = How.CSS, using = "div.nH.aqK > div.Cq.aqL > div > div > div:nth-child(5) > div")
    private WebElement refreshButton;

    @FindBy(how = How.CLASS_NAME, using = "gbii")
    private WebElement profileButton;

    @FindBy(how = How.CSS, using = ".aic")
    private WebElement composeButton;

    @FindBy(how = How.CSS, using = "[id=':5l']")
    private WebElement sentLink;

    @FindBy(how = How.CSS, using = "div[class='aio UKr6le'] span[class='nU n1'] a[class='J-Ke n0'][href*='mail/u/0/#inbox'")
    private WebElement inboxLink;

    public GmailLandingPage(WebDriver driver){
        super(driver, driver.getCurrentUrl());
    }

    public ProfilePopupPage showProfilePopup(){
        profileButton.click();

        return new ProfilePopupPage(driver);
    }

    public ComposeEmailPage composeEmail(){
        composeButton.click();

        return new ComposeEmailPage(driver);
    }

    public GmailSentPage clickOnSentEmails(){
        sentLink.click();

        return new GmailSentPage(driver);
    }

    public List<String> getAllEmailDates(){
        List<String> emailDates = new ArrayList<>();

        for(WebElement emailDate : allEmailDates){
            emailDates.add(emailDate.getText());
        }
        return emailDates;
    }

    public List<String> getAllEmailDescription(){
        List<String> emailDescriptions = new ArrayList<>();

        for(WebElement emailDescription : allEmailDescription){
            emailDescriptions.add(emailDescription.getText());
        }
        return emailDescriptions;
    }

    public List<String> getTabNames(){
        List<String> tabNames = new ArrayList<>();

        for(WebElement tab : inboxMainTabsText){
            tabNames.add(tab.getText());
        }
        return tabNames;
    }

    public boolean isRefreshButtonDisplayed(){
        return refreshButton.isDisplayed();
    }

    public boolean isProfileButtonDisplayed(){
        return profileButton.isDisplayed();
    }

    public boolean isComposeButtonDisplayed(){
        return composeButton.isDisplayed();
    }

    public void clickOnInbox(){
        inboxLink.click();
    }

    @Override
    public boolean isLoaded(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(gmailLogo));
            logger.info("Gmail landing page was loaded.");
            return true;
        }catch (RuntimeException exception){
            logger.info("Gmail landing page was not loaded: " + exception);
            return false;
        }
    }
}
