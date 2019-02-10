package com.BRITE.tests.functional_tests;

import com.BRITE.pages.CalendarPage;
import com.BRITE.pages.DiscussPage;
import com.BRITE.pages.Log_In;
import com.BRITE.utilities.ConfigurationReader;
import com.BRITE.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Calendar extends TestBase {

    @Test
    public void calendarEventTest() throws InterruptedException {


        WebDriverWait wait = new WebDriverWait(driver,30);
        extentLogger = report.createTest("Testing test case BRIT-1385");
        extentLogger.info("Logging to the application");

        pages.login().LogIn();

        extentLogger.info("Clicking Manufacturing module");
        pages.menu().manufacturing.click();

        extentLogger.info("Clicking Calendar menu");
        pages.menu().calender.click();

        CalendarPage calendarPage = new CalendarPage();
        extentLogger.info("Clicking 'day' button on the top of the page");
        wait.until(ExpectedConditions.elementToBeClickable(calendarPage.dayButton));
        calendarPage.dayButton.click();

        Actions actions =new Actions(driver);

        extentLogger.info("Clicking 6th of february");
        calendarPage.date.click();

        extentLogger.info("Clicking '10:00' o'clock to create a note on the calendar");
        wait.until(ExpectedConditions.elementToBeClickable(calendarPage.clock));
        actions.click(calendarPage.clock).perform();

        calendarPage.inputText.sendKeys("scrum meeting");
        calendarPage.create.click();

        extentLogger.info("Checking if created event is displayed");
        System.out.println(calendarPage.clock.getText());

        extentLogger .pass("Passed: calendar event test");

    }

    @Test
    public void attendeeAssign() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,20);
        extentLogger = report.createTest("Testing test case BRIT-1401");
        extentLogger.info("Logging to the application");

        CalendarPage calendarPage = new CalendarPage();

        pages.login().LogIn();

        extentLogger.info("Clicking Manufacturing module");
        pages.menu().manufacturing.click();

        extentLogger.info("Clicking Calendar menu");
        wait.until(ExpectedConditions.elementToBeClickable(pages.menu().calender));
        pages.menu().calender.click();

        extentLogger.info("Clicking 'day' button on the top of the page");
        wait.until(ExpectedConditions.elementToBeClickable(calendarPage.dayButton));
        calendarPage.dayButton.click();

        Actions actions =new Actions(driver);

        extentLogger.info("Clicking 6th of february");
        calendarPage.date.click();

        extentLogger.info("Clicking '10:00' o'clock to create a note on the calendar");
        wait.until(ExpectedConditions.elementToBeClickable(calendarPage.clock));
        actions.click(calendarPage.clock).perform();

        extentLogger.info("Editing the note");
        wait.until(ExpectedConditions.elementToBeClickable(calendarPage.edit));
        calendarPage.edit.click();

        extentLogger.info("Selecting attendees ");
        calendarPage.selectAttendees.sendKeys("McDonalds"+ Keys.ENTER);

        extentLogger.info("Saving the note");
        calendarPage.save.click();


        extentLogger .pass("Passed: attendee assign test");
    }

}
