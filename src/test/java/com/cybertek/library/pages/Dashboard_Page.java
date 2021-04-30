package com.cybertek.library.pages;

import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard_Page {

    public Dashboard_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='menu_item']/li[1]/a/span[1]")
    public WebElement dashTitle;

    @FindBy(xpath = "//span[.='Books']")
    public WebElement booksButton;


    public String dashTitleText() throws InterruptedException {
        BrowserUtils.waitForVisibility( dashTitle,1);
        return dashTitle.getText();
    }

}
