package com.BRITE.pages;

import com.BRITE.utilities.Driver;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiscussPage {
    public DiscussPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h4[@class='o_mail_open_channels']")
    public WebElement channels;

    @FindBy(xpath = "//button[@type='button' and contains(text(),'Create')]")
    public  WebElement create;

    @FindBy(name = "name")
    public WebElement channelName;

    @FindBy(xpath = "//button[@accesskey='s']")
    public WebElement save;

    @FindBy(xpath = "//span[@name='name']")
    public WebElement channelTitle;
}
