package com.qalabs.pageobjects;

import com.qalabs.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComposeEmailPage extends BasePage {

    @FindBy(how = How.CSS, using = ".aYF")
    private WebElement newMessageTitle;

    @FindBy(how = How.CSS, using = "div > span[class='gO aQY']")
    private WebElement toLink;

    @FindBy(how = How.NAME, using = "to")
    private WebElement toTextBox;

    @FindBy(how = How.NAME, using = "subjectbox")
    private WebElement subjectTextBox;

    @FindBy(how = How.CSS, using = "span[class='aB  gQ pB']")
    private WebElement bccLink;

    @FindBy(how = How.NAME, using = "bcc")
    private WebElement bccTextBox;

    @FindBy(how = How.CSS, using = "span[class='aB gQ pE']")
    private WebElement ccLink;

    @FindBy(how = How.NAME, using = "cc")
    private WebElement ccTextBox;

    @FindBy(how = How.CSS, using = "div[class='dC'] > div[class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
    private WebElement sendButton;

    @FindBy(how = How.CSS, using = "div[class='Am Al editable LW-avf tS-tW']")
    private WebElement messageTextBox;

    public ComposeEmailPage(WebDriver driver){
        super(driver, driver.getCurrentUrl());
    }

    public boolean isAllDefaultValuesDisplayed(){
        return isToLinkDisplayed() &&
                isSubjectTextBoxDisplayed() &&
                isCCLinkDisplayed() &&
                isBCCLinkDisplayed() &&
                isSendButtonDisplayed();
    }

    public boolean isCCTextBoxDisplayed(){
        ccLink.click();
        return ccTextBox.isDisplayed();
    }

    public boolean isBCCTextBoxDisplayed(){
        bccLink.click();
        return bccTextBox.isDisplayed();
    }

    public boolean isToLinkDisplayed(){
        toTextBox.click();
        boolean displayed = toLink.isDisplayed();
        logger.info("To Link is: " + (displayed ? "" : "not") + "displayed");
        return displayed;
    }

    public boolean isSubjectTextBoxDisplayed(){
        boolean displayed = subjectTextBox.isDisplayed();
        logger.info("Subject TextBox is: " + (displayed ? "" : "not") + "displayed");
        return displayed;
    }

    public boolean isCCLinkDisplayed(){
        boolean displayed = ccLink.isDisplayed();
        logger.info("CC Link is: " + (displayed ? "" : "not") + "displayed");
        return displayed;
    }

    public boolean isBCCLinkDisplayed(){
        boolean displayed = bccLink.isDisplayed();
        logger.info("BCC Link is: " + (displayed ? "" : "not") + "displayed");
        return displayed;
    }

    public boolean isSendButtonDisplayed(){
        boolean displayed = sendButton.isDisplayed();
        logger.info("Send Button is: " + (displayed ? "" : "not") + "displayed");
        return displayed;
    }

    public void sendEmail(String to, String subject, String message){

    }

    public void sendEmailWithCarbonCopy(String to, String cc, String subject, String message){

    }

    public void sendEmailWithBlindCarbonCopy(String to, String bcc, String subject, String message){

    }

    public void sendEmailWithCCAndBCC(String to, String cc, String bcc, String subject, String message){
        sendComposedEmail(to, cc, bcc, subject, message);
    }

    private void sendComposedEmail(String to, String cc, String bcc, String subject, String message){
        toTextBox.sendKeys(to);
        ccTextBox.sendKeys(cc);
        bccTextBox.sendKeys(bcc);
        subjectTextBox.sendKeys(subject);
        messageTextBox.sendKeys(message);
        sendButton.click();
    }

    @Override
    public boolean isLoaded(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(newMessageTitle));
            logger.info("Compose email popup loaded.");
            return true;
        }catch(RuntimeException exception){
            logger.info("Compose Email pop up is not loaded." + exception);
            return false;
        }
    }
}
