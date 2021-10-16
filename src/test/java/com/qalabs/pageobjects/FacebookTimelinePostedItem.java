package com.qalabs.pageobjects;

import com.qalabs.common.BaseElement;
import org.openqa.selenium.WebElement;

public class FacebookTimelinePostedItem extends BaseElement {
    public FacebookTimelinePostedItem(WebElement root) {
        super(root);
    }

    public String getDescription(){
        return this.root.getText();
    }
}
