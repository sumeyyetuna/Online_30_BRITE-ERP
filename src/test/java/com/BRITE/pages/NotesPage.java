package com.BRITE.pages;

import com.BRITE.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NotesPage {

    public NotesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "button[data-view-type='list']")
    public WebElement listView;

    @FindBy(xpath = "//th[@class='o_column_sortable' and contains(text(),'Note Summary')]")
    public WebElement noteSummary;

    @FindBy(css = "button[data-view-type='kanban']")
    public WebElement kanbanView;

    @FindBy(xpath = "//span[@class='o_column_title']")
    public List<WebElement> kanbanTitle;
}
