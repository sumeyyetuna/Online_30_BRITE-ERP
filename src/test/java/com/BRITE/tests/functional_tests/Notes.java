package com.BRITE.tests.functional_tests;

import com.BRITE.pages.CalendarPage;
import com.BRITE.pages.Log_In;
import com.BRITE.pages.NotesPage;
import com.BRITE.utilities.BrowserUtils;
import com.BRITE.utilities.ConfigurationReader;
import com.BRITE.utilities.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Notes extends TestBase {

    @Test
    public void readNotes() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver,30);
        extentLogger = report.createTest("Testing test case BRIT-1688");
        extentLogger.info("Logging to the application");

        pages.login().LogIn();

        extentLogger.info("Clicking Manufacturing module");
        pages.menu().manufacturing.click();

//        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(pages.menu().notes));
        pages.menu().notes.click();

        NotesPage notesPage = new NotesPage();

        extentLogger.info("Page should display kanban view ");

        extentLogger.info("Checking if the page displays This week's notes");
        List <String> actualMembers = BrowserUtils.getElementsText(notesPage.kanbanTitle);
        Assert.assertTrue(actualMembers.contains("This Week"));

        extentLogger.info("Clicking for list view");
        wait.until(ExpectedConditions.elementToBeClickable(notesPage.listView));
        notesPage.listView.click();

        wait.until(ExpectedConditions.elementToBeClickable(notesPage.noteSummary));
        Assert.assertEquals(notesPage.noteSummary.getText(),"Note Summary");

        extentLogger .pass("Passed: read notes test");
    }


}
