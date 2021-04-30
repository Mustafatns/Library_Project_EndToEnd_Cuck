package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Books_Page {

    public Books_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h3[.='Book Management']")
    public WebElement title;

    @FindBy(xpath = "//a[@class=''btn btn-lg btn-outline btn-primary btn-sm add_book_btn]")
    public WebElement addBookButton;

    @FindBy(xpath = "//h5[.='Add Book']")
    public WebElement addBookTitle;
    @FindBy(xpath = "//input[@placeholder='Book Name']")
    public WebElement bookNameBox;

    @FindBy(xpath = "//input[@placeholder='ISBN']")
    public WebElement isbnBox;

    @FindBy(xpath = "//input[@placeholder='Year']")
    public WebElement yearBox;

    @FindBy(xpath = "//input[@placeholder='Author']")
    public WebElement authorBox;

    @FindBy(id = "book_group_id")
    public WebElement bookGroupDropdown;

    @FindBy(id = "description")
    public WebElement descriptionBox;

    @FindBy(xpath = "//button[.='Save changes']")
    public WebElement saveButton;







}
