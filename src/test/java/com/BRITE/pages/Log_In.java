package com.BRITE.pages;

import com.BRITE.utilities.ConfigurationReader;
import com.BRITE.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Log_In {
    public Log_In() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "a[href='/web/database/selector']\n")
    public WebElement select;

    @FindBy(css = "a[href='/web?db=BriteErpDemo']")
    public WebElement BriteErpDemo;

    @FindBy(id = "login")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement LogIn;

    public void LogIn() {
        BriteErpDemo.click();
        email.sendKeys(ConfigurationReader.getProperty("userName"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        LogIn.click();
    }
}
