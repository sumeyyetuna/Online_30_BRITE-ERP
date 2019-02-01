package com.BRITE.pages;

import com.BRITE.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends Menu {
    public ContactsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default o_button_import']")
    public WebElement contactImport;

    @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement contactSearch;

}
