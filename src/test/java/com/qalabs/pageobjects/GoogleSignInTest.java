package com.qalabs.pageobjects;

import com.qalabs.common.BaseTest;
import com.qalabs.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class GoogleSignInTest extends BaseTest {
    private GoogleSignIn googleSignIn;
    private GoogleSignInDenied googleSignInDenied;

    @BeforeClass
    void initializeGoogleSignInPage(){
        this.googleSignIn = new GoogleSignIn(this.driver);
    }

    @Test
    public void openGoogleSignIn(){
        googleSignIn.open();
        Assert.assertTrue(googleSignIn.isLoaded());
    }

    @Test(dependsOnMethods = {"openGoogleSignIn"})
    void nextButtonShouldNotBeDisplayedAfterClickingOnIt() throws InterruptedException {
        googleSignIn.setEMail(PropertyReader.getProperty("selenium-configurations.properties", "EMAIL"));
        String googleSignNextInButtonText = googleSignIn.getNextButtonText();

        googleSignInDenied = googleSignIn.clickNext();
        googleSignInDenied.isLoaded();
        String googleDeniedNextInButtonText = googleSignInDenied.getNextButtonText();

        assertFalse(googleSignNextInButtonText.equals(googleDeniedNextInButtonText));
    }
}
