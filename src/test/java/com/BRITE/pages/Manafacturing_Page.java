package com.BRITE.pages;

import com.BRITE.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Manafacturing_Page extends Menu {
    public Manafacturing_Page() {
        PageFactory.initElements(Driver.getDriver(), this);}

//    @FindBy(css = "//a[@data-menu='415']")
//    public WebElement manufactoring_Menu;

    @FindBy(xpath = "//a[@href='/web#menu_id=431&action=592']//span[@class='oe_menu_text']")
    public  WebElement manufactoring_Orders;

    @FindBy(xpath = "//a[@href='/web#menu_id=438&action=605']//span[@class='oe_menu_text']")
    public WebElement unbuild_Orders;

    @FindBy(xpath = "//a[@href='/web#menu_id=437&action=603']//span[@class='oe_menu_text']")
    public WebElement products;

    @FindBy(xpath = "//a[@href='/web#menu_id=436&action=600']//span[@class='oe_menu_text']")
    public WebElement bills_Of_Materials;

    @FindBy(xpath = "//a[@href='/web#menu_id=433&action=596']//span[@class='oe_menu_text']")
    public WebElement manufactoring_Orders_Report;

}
