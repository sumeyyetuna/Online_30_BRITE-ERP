package com.BRITE.pages;

import com.BRITE.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Menu {
    public Menu() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//ol//li")
    public WebElement header;

    @FindBy(xpath = "//a[@href='/web#menu_id=115&action=120']//span[@class='oe_menu_text']")
    public WebElement discuss;

    @FindBy(xpath = "//a[@href='/web#menu_id=120&action=136']//span[@class='oe_menu_text']")
    public WebElement calender;

    @FindBy(xpath = "//a[@href='/web#menu_id=194&action=220']//span[@class='oe_menu_text']")
    public WebElement notes;

    @FindBy(xpath = "//a[@href='/web#menu_id=68&action=']//span[@class='oe_menu_text']")
    public WebElement contacts;

    @FindBy(xpath = "//a[@href='/web#menu_id=382&action=']//span[@class='oe_menu_text']")
    public WebElement website;

    @FindBy(xpath = "//a[@href='/web#menu_id=415&action=']//span[@class='oe_menu_text']")
    public WebElement manufacturing;

    @FindBy(xpath = "//a[@href='/web#menu_id=124&action=']//span[@class='oe_menu_text']")
    public WebElement events;

    @FindBy(xpath = "//a[@href='/web#menu_id=157&action=']//span[@class='oe_menu_text']")
    public WebElement employees;

    @FindBy(xpath = "//a[@href='/web#menu_id=295&action=']//span[@class='oe_menu_text']")
    public WebElement leaves;

    @FindBy(xpath = "//a[@href='/web#menu_id=388&action=']//span[@class='oe_menu_text']")
    public WebElement expenses;

    @FindBy(xpath = "//a[@href='/web#menu_id=165&action=']//span[@class='oe_menu_text']")
    public WebElement maintenance;

    @FindBy(xpath = "//a[@href='/web#menu_id=1&action=']//span[@class='oe_menu_text']")
    public WebElement dashboards;









}
