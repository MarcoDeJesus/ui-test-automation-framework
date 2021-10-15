package com.qalabs.pageobjects;

import com.qalabs.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class POMExample1Test extends BaseTest {

    private GoogleMainPage google;
    private GoogleResultsPage resultsPage;

    @BeforeClass
    public void initializeGooglePage(){
        this.google = new GoogleMainPage(this.driver);
        this.resultsPage = null;
    }

    @Test
    public void openGoogle(){
        google.open();
        Assert.assertTrue(google.isLoaded());
    }

    @Test(description = "Search something in google", dependsOnMethods = {"openGoogle"})
    public void searchInGoogle(){
        String expected = "Matrix - Buscar con Google";

        this.resultsPage = this.google.searchInGoogle("Matrix");
        String actual = resultsPage.currentSearch();

        //assertTrue(this.resultsPage.isLoaded());
        assertEquals(actual, expected, "Incorrect Search url.");
    }

    @Test(description = "Search something again", dependsOnMethods = {"searchInGoogle"})
    public void performNewSearch(){
        String expected = "Die Hard 4.0 - Buscar con Google";

        this.resultsPage = this.resultsPage.search("Die Hard 4.0");
        String actual = resultsPage.currentSearch();

        //assertTrue(this.resultsPage.isLoaded());
        assertEquals(actual, expected, "Incorrect Search url.");
    }

    @Test(description = "Click next button", dependsOnMethods = {"performNewSearch"})
    public void clickNextResults(){
        String expected = "Die Hard 4.0 - Buscar con Google";

        this.resultsPage.nextResultPage();
        String actual = driver.getTitle();

        //assertTrue(this.resultsPage.isLoaded());
        assertEquals(actual, expected, "Page title is incorrect.");
    }

    @Test(description = "Click prev button", dependsOnMethods = {"clickNextResults"})
    public void clickPrevResults(){
        String expected = "Die Hard 4.0 - Buscar con Google";

        this.resultsPage.prevResultPage();
        String actual = driver.getTitle();

        //assertTrue(this.resultsPage.isLoaded());
        assertEquals(actual, expected, "Page title is incorrect.");
    }

    @Test(description = "Search first result found", dependsOnMethods = {"clickPrevResults"})
    public void selectFirstResult(){
        String expected = "Live Free or Die Hard - Wikipedia, la enciclopedia libre";

        String actual = resultsPage.getResults().get(0).getTitle();

        assertEquals(actual, expected, "Incorrect Title.");
    }
}
