package com.qalabs.pageobjects;

import com.qalabs.common.BaseTest;
import com.qalabs.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GmailNegativeTest extends BaseTest {

    private GmailLoginPage gmailLoginPage;
    private GmailPasswordPage gmailPasswordPage;

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
    public void validateWrongEmail() {
        String propertyFile = "selenium-configurations.properties";
        String gmailAccount = PropertyReader.getProperty(propertyFile, "INCORRECT_GMAIL_ACCOUNT");

        gmailLoginPage.enterGmailAccount(gmailAccount);

        assertEquals(gmailLoginPage.getErrorMessage(), "No pudimos encontrar tu Cuenta de Google", "Incorrect message.");
    }

    @Test(dependsOnMethods = {"openGmail"})
    public void validateWrongPassword(){
        String propertyFile = "selenium-configurations.properties";
        String gmailAccount = PropertyReader.getProperty(propertyFile, "GMAIL");

        gmailPasswordPage = gmailLoginPage.enterGmailAccount(gmailAccount);
        gmailPasswordPage.isLoaded();

        gmailPasswordPage.loginWithPassword("Wrong password");

        assertEquals(gmailPasswordPage.getErrorMessage(), "La contraseña es incorrecta. Vuelve a intentarlo o haz clic en \"¿Olvidaste la contraseña?\" para restablecerla.", "Incorrect message.");
    }
}
