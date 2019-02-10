package com.BRITE.tests.smoke_tests;

import com.BRITE.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class websiteHeadersTest extends TestBase {

    @Test
    public void websiteHeadersTest() throws InterruptedException {

        extentLogger = report.createTest("Website headers test");
        extentLogger.info("Logging to the application");
        pages.login().LogIn();
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));

        extentLogger.info("Verifying header for Discuss");
        assertEquals(pages.menu().header.getText(),"#Inbox");

        extentLogger.info("Clicking on Calendar");
        pages.menu().calender.click();
        wait.until(ExpectedConditions.titleIs("Meetings - Odoo"));

        extentLogger.info("Verifying header for Calendar");
        assertTrue(pages.menu().header.getText().contains("Meetings"));

        extentLogger.info("Clicking on Notes");
        pages.menu().notes.click();
        wait.until(ExpectedConditions.titleIs("Notes - Odoo"));

        extentLogger.info("Verifying header for Notes");
        assertEquals(pages.menu().header.getText(),"Notes");

        extentLogger.info("Clicking on Contacts");
        pages.menu().contacts.click();
        wait.until(ExpectedConditions.titleIs("Contacts - Odoo"));

        extentLogger.info("Verifying header for Contacts");
        assertEquals(pages.menu().header.getText(),"Contacts");


        extentLogger.info("Clicking on Manufacturing");
        pages.menu().manufacturing.click();
        wait.until(ExpectedConditions.titleIs("Manufacturing Orders - Odoo"));

        extentLogger.info("Verifying header for Manufacturing");
        assertEquals(pages.menu().header.getText(),"Manufacturing Orders");

        extentLogger.info("Clicking on Events");
        pages.menu().events.click();
        wait.until(ExpectedConditions.titleIs("Events - Odoo"));

        extentLogger.info("Verifying header for Events");
        assertEquals(pages.menu().header.getText(),"Events");

        extentLogger.info("Clicking on Employees");
        pages.menu().employees.click();
        wait.until(ExpectedConditions.titleIs("Employees - Odoo"));

        extentLogger.info("Verifying header for Employees");
        assertEquals(pages.menu().header.getText(),"Employees");

        extentLogger.info("Clicking on Leaves");
        pages.menu().leaves.click();
        wait.until(ExpectedConditions.titleIs("Leaves Summary - Odoo"));

        extentLogger.info("Verifying header for Leaves");
        assertEquals(pages.menu().header.getText(),"Leaves Summary");

        extentLogger.info("Clicking on Expenses");
        pages.menu().expenses.click();
        wait.until(ExpectedConditions.titleIs("My Expenses to Submit - Odoo"));

        extentLogger.info("Verifying header for Expenses");
        assertEquals(pages.menu().header.getText(),"My Expenses to Submit");

        extentLogger.info("Clicking on Maintenance");
        pages.menu().maintenance.click();
        wait.until(ExpectedConditions.titleIs("Maintenance Teams - Odoo"));

        extentLogger.info("Verifying header for Maintenance");
        assertEquals(pages.menu().header.getText(),"Maintenance Teams");

        extentLogger.info("Clicking on Dashboards");
        pages.menu().dashboards.click();
        wait.until(ExpectedConditions.titleIs("My Dashboard - Odoo"));

        extentLogger.info("Verifying message for Dashboards");
        assertTrue(driver.findElement(By.xpath("//div//div[@class='oe_empty_custom_dashboard']")).isDisplayed());

        extentLogger.info("Clicking on Website");
        pages.menu().website.click();
        wait.until(ExpectedConditions.titleIs("Home | Website localhost"));

        extentLogger.info("Verifying main header of website page");
        assertEquals(driver.findElement(By.xpath("//h1")).getText(),"Your Website Title");
        extentLogger.pass("Headers Test passed successfully");





    }
}
