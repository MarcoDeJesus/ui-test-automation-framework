package com.qalabs.pageobjects;

import com.qalabs.common.BaseTest;
import com.qalabs.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class GmailTest extends BaseTest {

    private GmailLoginPage gmailLoginPage;
    private GmailPasswordPage gmailPasswordPage;
    private GmailLandingPage gmailLandingPage;
    private ProfilePopupPage profilePopupPage;
    private ComposeEmailPage composeEmailPage;
    private GmailSentPage gmailSentPage;

    @BeforeClass
    public void initializeGmailPage(){
        this.gmailLoginPage = new GmailLoginPage(this.driver);
    }

    @Test
    public void openGmail(){
        gmailLoginPage.open();
        assertTrue(gmailLoginPage.isLoaded());
    }

    @Test(dependsOnMethods = {"openGmail"})
    public void login(){
        String propertyFile = "selenium-configurations.properties";
        String gmailAccount = PropertyReader.getProperty(propertyFile, "GMAIL");
        String gmailPassword = PropertyReader.getProperty(propertyFile, "GMAIL_PASSWORD");

        gmailPasswordPage = gmailLoginPage.enterGmailAccount(gmailAccount);
        gmailPasswordPage.isLoaded();

        gmailLandingPage = gmailPasswordPage.loginWithPassword(gmailPassword);

        assertTrue(gmailLandingPage.isLoaded());
    }

    @DataProvider(name = "inboxTabs")
    public Object[][] inboxTabs(){
        return new Object[][]{{"Primary"}, {"Social"}, {"Promotions"}};
    }

    @Test(dependsOnMethods = {"login"},
        dataProvider = "inboxTabs"
    )
    public void inboxMainTabsShouldHave(String inboxTab){
        gmailLandingPage.isLoaded();

        List<String> tabs = gmailLandingPage.getTabNames();

        assertTrue(tabs.contains(inboxTab));
    }

    @Test(dependsOnMethods = {"login"})
    public void validateRefreshButtonIsDisplayed(){
        assertTrue(gmailLandingPage.isRefreshButtonDisplayed());
    }

    @Test(dependsOnMethods = {"login"})
    public void validateProfileButtonIsDisplayed(){
        assertTrue(gmailLandingPage.isProfileButtonDisplayed());
    }

    @Test(dependsOnMethods = {"login"})
    public void validateComposeButtonIsDisplayed(){
        assertTrue(gmailLandingPage.isComposeButtonDisplayed());
    }

    @Test(dependsOnMethods = {"validateProfileButtonIsDisplayed"})
    public void validateProfileNameAndEmail(){
        profilePopupPage = gmailLandingPage.showProfilePopup();

        profilePopupPage.isLoaded();

        assertTrue(profilePopupPage.isProfileNameDisplayed());
        assertTrue(profilePopupPage.isEmailDisplayed());
    }

    @Test(dependsOnMethods = {"validateComposeButtonIsDisplayed", "validateProfileNameAndEmail"})
    public void validateComposeEditorIsDisplayed(){
        composeEmailPage = gmailLandingPage.composeEmail();

        assertTrue(composeEmailPage.isLoaded());
    }

    @Test(dependsOnMethods = {"validateComposeEditorIsDisplayed"})
    public void validateDefaultFieldsAreDisplayed(){
        assertTrue(composeEmailPage.isAllDefaultValuesDisplayed());
    }

    @Test(dependsOnMethods = {"validateDefaultFieldsAreDisplayed"})
    public void validateCCFieldIsShownWhenClickedCCLink(){
        assertTrue(composeEmailPage.isCCTextBoxDisplayed());
    }

    @Test(dependsOnMethods = {"validateDefaultFieldsAreDisplayed"})
    public void validateBCCFieldIsShownWhenClickedBCCLink(){
        assertTrue(composeEmailPage.isBCCTextBoxDisplayed());
    }

    @Test(dependsOnMethods = {"validateCCFieldIsShownWhenClickedCCLink", "validateBCCFieldIsShownWhenClickedBCCLink"})
    public void sendEmail(){
        String to = "danielauto1990@gmail.com";
        String cc = "danielauto1990@gmail.com";
        String bcc = "danielauto1990@gmail.com";
        String subject = "Daniel this is a test!";
        String message = "This is fine.";

        composeEmailPage.sendEmailWithCCAndBCC(to, cc, bcc, subject, message);
    }

    @Test(dependsOnMethods = {"sendEmail"})
    public void validateEmailIsSent(){
        gmailSentPage = new GmailSentPage(driver);
        gmailSentPage.loadPage();
        gmailSentPage.isLoaded();

        assertEquals(gmailSentPage.getLastEmailSentText(), "Daniel this is a test!", "Text is not correct.");
    }

    @Test(dependsOnMethods = {"validateEmailIsSent"})
    public void validateInboxEmailsHaveDescriptionAndDate(){
        gmailLandingPage.clickOnInbox();

        gmailLandingPage.getAllEmailDescription().stream().forEach(Assert::assertNotNull);
        gmailLandingPage.getAllEmailDates().stream().forEach(Assert::assertNotNull);
    }
}
