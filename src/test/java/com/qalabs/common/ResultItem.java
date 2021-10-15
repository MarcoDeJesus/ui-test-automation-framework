package com.qalabs.common;

import com.qalabs.common.BaseElement;
import org.openqa.selenium.WebElement;

public class ResultItem extends BaseElement {

    public ResultItem(WebElement element){
        super(element);
    }

    private WebElement title(){
        return root;
    }

    public String getDescription(){
        return this.root.getText();
    }

    public String getTitle(){
        return this.title().getText();
    }

    public void click(){
        root.click();
    }

    @Override
    public String toString(){
        return String.format("%s\n", this.getDescription());
    }
}
