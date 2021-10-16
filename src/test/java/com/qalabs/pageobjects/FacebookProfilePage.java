package com.qalabs.pageobjects;

import com.qalabs.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class FacebookProfilePage extends BasePage {

    @FindBy(how = How.CSS, using = "div[data-pagelet='ProfileTabs'] div[role='tablist'] a[href*='&sk=about']")
    private WebElement aboutTab;

    @FindBy(how = How.CSS, using = "div[data-pagelet='ProfileTabs'] div[role='tablist'] a[href*='&sk=friends']")
    private WebElement friendsTab;

    @FindBy(how = How.CSS, using = "div[data-pagelet='ProfileTabs'] div[role='tablist'] a[href*='&sk=photos']")
    private WebElement photosTab;

    @FindBy(how = How.CSS, using = "div[data-pagelet='ProfileTabs'] div[role='tablist'] a[href*='/profile.php?id=']")
    private WebElement postTab;

    @FindBy(how = How.CSS, using = "div[data-pagelet='ProfileTimeline'] div > div[class='rq0escxv l9j0dhe7 du4w35lb']")
    private List<WebElement> timelinePosts;

    public FacebookProfilePage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
    }

    public List<FacebookTimelinePostedItem> getTimelinePosts(){

        List<FacebookTimelinePostedItem> facebookPosts = new ArrayList<>();

        for (WebElement post:timelinePosts) {
            FacebookTimelinePostedItem fbPost = new FacebookTimelinePostedItem(post);
            facebookPosts.add(fbPost);
        }

        return facebookPosts;
    }

    public void selectPosts(){
        postTab.click();
    }

    public void selectAbout(){
        driver.navigate().to(aboutTab.getAttribute("href"));
    }

    public void selectFriends(){
        friendsTab.click();
    }

    public void selectPhotos(){
        photosTab.click();
    }


}
