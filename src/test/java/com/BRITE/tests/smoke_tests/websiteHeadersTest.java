package com.BRITE.tests.smoke_tests;

import com.BRITE.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class websiteHeadersTest extends TestBase {

    @Test
    public void websiteHeadersTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        extentLogger = report.createTest("Website headers test");
        extentLogger.info("Logging to the application");
        pages.login().LogIn();

        extentLogger.info("Clicking on Discuss");
        pages.menu().discuss.click();

        extentLogger.info("Verifying header for Discuss");
        assertEquals(pages.menu().header.getText(),"#Inbox");
        Thread.sleep(5000);
        extentLogger.info("Clicking on Calendar");
        pages.menu().calender.click();

        LocalDate currentDate = LocalDate.now();
        int dom = currentDate.getDayOfMonth();
        int week = (dom>=1 && dom<8)?(dom>=8 && dom<15)?(dom>=15 && dom<22)?(dom>=22 && dom<29)? 1:2:3:4:5;

        Thread.sleep(5000);
        extentLogger.info("Verifying header for Calendar");
        assertEquals(pages.menu().header.getText(),"Meetings (Week "+week+")");
        Thread.sleep(5000);
        extentLogger.info("Clicking on Notes");
        pages.menu().notes.click();
        Thread.sleep(5000);
        extentLogger.info("Verifying header for Notes");
        assertEquals(pages.menu().header.getText(),"Notes");
        Thread.sleep(5000);
        extentLogger.info("Clicking on Contacts");
        pages.menu().contacts.click();
        Thread.sleep(5000);
        extentLogger.info("Verifying header for Contacts");
        assertEquals(pages.menu().header.getText(),"Contacts");
        Thread.sleep(5000);
        extentLogger.info("Clicking on Manufacturing");
        pages.menu().manufacturing.click();
        Thread.sleep(5000);
        extentLogger.info("Verifying header for Manufacturing");
        assertEquals(pages.menu().header.getText(),"Manufacturing Orders");
        Thread.sleep(5000);
        extentLogger.info("Clicking on Events");
        pages.menu().events.click();
        Thread.sleep(5000);
        extentLogger.info("Verifying header for Events");
        assertEquals(pages.menu().header.getText(),"Events");
        Thread.sleep(5000);
        extentLogger.info("Clicking on Employees");
        pages.menu().employees.click();
        Thread.sleep(5000);
        extentLogger.info("Verifying header for Employees");
        assertEquals(pages.menu().header.getText(),"Employees");
        Thread.sleep(5000);
        extentLogger.info("Clicking on Leaves");
        pages.menu().leaves.click();
        Thread.sleep(5000);
        extentLogger.info("Verifying header for Leaves");
        assertEquals(pages.menu().header.getText(),"Leaves Summary");
        Thread.sleep(5000);
        extentLogger.info("Clicking on Expenses");
        pages.menu().expenses.click();
        Thread.sleep(5000);
        extentLogger.info("Verifying header for Expenses");
        assertEquals(pages.menu().header.getText(),"My Expenses to Submit");
        Thread.sleep(5000);
        extentLogger.info("Clicking on Maintenance");
        pages.menu().maintenance.click();
        Thread.sleep(5000);
        extentLogger.info("Verifying header for Maintenance");
        assertEquals(pages.menu().header.getText(),"Maintenance Teams");
        Thread.sleep(5000);
        extentLogger.info("Clicking on Website");
        pages.menu().website.click();
        Thread.sleep(5000);
        extentLogger.info("Verifying main header of website page");
        assertEquals(driver.findElement(By.xpath("//h1")).getText(),"Your Website Title");
        extentLogger.pass("Headers Test passed successfully");





    }
}
