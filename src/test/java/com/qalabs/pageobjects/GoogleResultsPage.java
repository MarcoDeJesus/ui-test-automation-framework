package com.qalabs.pageobjects;

import com.qalabs.common.BasePage;
import com.qalabs.common.ResultItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GoogleResultsPage extends BasePage {

    @FindBy(how = How.NAME, using = "q")
    private WebElement searchBox;

    @FindBy(how = How.CLASS_NAME, using = "Tg7LZd")
    private WebElement searchButton;

    @FindBy(how = How.CSS, using = ".tF2Cxc h3[class*='LC20lb']")
    private List<WebElement> results;

    @FindBy(how = How.ID, using = "pnnext")
    private WebElement nextButton;

    @FindBy(how = How.ID, using = "pnprev")
    private WebElement prevButton;

    @FindBy(how = How.ID, using = "logo")
    private WebElement googleLogo;

    public GoogleResultsPage(WebDriver driver){
        super(driver, driver.getCurrentUrl());
    }

    public GoogleResultsPage search(String searchTxt){
        searchBox.clear();
        searchBox.sendKeys(searchTxt);
        searchButton.click();
        return new GoogleResultsPage(driver);
    }

    public String currentSearch(){
        return driver.getTitle();
    }

    public List<ResultItem> getResults() {
        List<ResultItem> resultItems = new ArrayList<>();

        for(int i=0; i< results.size(); i++){
            ResultItem resultItem = new ResultItem(results.get(i));
            resultItems.add(resultItem);
        }

        return resultItems;
    }

    public void nextResultPage(){
        nextButton.click();
    }

    public void prevResultPage(){
        prevButton.click();
    }

    @Override
    public boolean isLoaded(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(googleLogo));
            logger.info("Google Results page loaded: " + currentSearch());
            return true;
        }catch (RuntimeException exception){
            logger.error("Google Results page was not loaded: " + exception);
            return false;
        }
    }
}
