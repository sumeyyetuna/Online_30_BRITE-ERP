package com.BRITE.pages;

import com.BRITE.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Manafacturing_Page {
    public Manafacturing_Page() {
        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(css = "//a[@data-menu='415']")
    public WebElement manufactoring_Menu;

    @FindBy(xpath = "//a[@data-menu='431']")
    public  WebElement manufactoring_Orders;

    @FindBy(xpath = "//span[contains(text(),'Unbuild Orders')]")
    public WebElement unbuild_Orders;

    @FindBy(xpath = "//span[contains(text(),'Products')]")
    public WebElement products;

    @FindBy(xpath = "//a[@data-menu='436']")
    public WebElement bills_Of_Materials;

    @FindBy(xpath = "//a[@data-menu='433']")
    public WebElement manufactoring_Orders_Report;

}
