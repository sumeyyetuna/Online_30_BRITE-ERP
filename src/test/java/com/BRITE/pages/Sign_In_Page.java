package com.BRITE.pages;

import com.BRITE.utilities.ConfigurationReader;
import com.BRITE.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sign_In_Page {
    public Sign_In_Page() {PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//a[@href='/web/login']")
    public WebElement signIn;

    public void open() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    public void signIn() {
        signIn.click();
    }
}
