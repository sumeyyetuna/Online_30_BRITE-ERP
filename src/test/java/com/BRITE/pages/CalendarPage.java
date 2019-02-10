package com.BRITE.pages;

import com.BRITE.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {
    public CalendarPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//tr[@data-time='10:00:00']//td[@class='fc-widget-content']")
    public WebElement clock;

    @FindBy(xpath = "//a[@class='ui-state-default' and contains(text(),'6')]")
    public WebElement date;

    @FindBy(xpath = "//button[@type='button' and contains(text(),'Day')]")
    public WebElement dayButton;

    @FindBy(css = "input[class='o_input']")
    public WebElement inputText;


    @FindBy(css = "button[class='btn btn-sm btn-primary']")
    public WebElement create;

    @FindBy(xpath = "//div[@class='fc-time' and contains(text(),'')]")
    public WebElement page;

    @FindBy(css = "button[class='btn btn-sm btn-primary']>span")
    public WebElement edit;

    @FindBy(xpath = "//input[@placeholder='Select attendees...']")
    public WebElement selectAttendees;

    @FindBy(css = "button[class='btn btn-sm btn-primary']>span")
    public WebElement save;

    @FindBy(css = "div[name='partner_ids']")
    public WebElement attendees;

}
