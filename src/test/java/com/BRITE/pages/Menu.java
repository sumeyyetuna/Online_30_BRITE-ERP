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

    @FindBy(css = "[data-menu='115']")
    public WebElement discuss;

    @FindBy(css = "[data-menu='120']")
    public WebElement calender;

    @FindBy(css = "[data-menu='194']")
    public WebElement notes;

    @FindBy(css = "[data-menu='68']")
    public WebElement contacts;

    @FindBy(xpath = "//span[contains(text(),'Website')]")
    public WebElement website;

    @FindBy(css = "[data-menu='124']")
    public WebElement events;

    @FindBy(id = "//a[@data-menu='157']")
    public WebElement employees;

    @FindBy(xpath = "//*[@data-menu='295']")
    public WebElement leaves;









}
