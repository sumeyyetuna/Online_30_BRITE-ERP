package com.BRITE.tests.functional_tests;

import com.BRITE.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Contacts extends TestBase {

    @Test
    public void createContact() throws InterruptedException {
        extentLogger = report.createTest("Creating a new contact");
        extentLogger.info("Logging to the application");
        pages.login().LogIn();
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
        extentLogger.info("Opening contact menu");
        pages.menu().contacts.click();
        extentLogger.info("Clicking on create button");
        pages.contactsPage().create.click();
        extentLogger.info("Entering contact name");
        driver.findElement(By.xpath("//h1//input")).sendKeys("Contact1"+ Keys.ENTER);
        extentLogger.info("Clicking save button");
        driver.findElement(By.xpath("//div//button[@class='btn btn-primary btn-sm o_form_button_save']")).click();
        extentLogger.pass("Contact created successfully");

    }

    @Test
    public void deleteContact() throws InterruptedException {
        extentLogger = report.createTest("Deleting a contact");
        extentLogger.info("Logging to the application");
        pages.login().LogIn();
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
        extentLogger.info("Opening contact menu");
        pages.menu().contacts.click();
        extentLogger.info("Clicking on first contact from the list");
        driver.findElement(By.xpath("//div//div[@class='oe_kanban_global_click o_res_partner_kanban o_kanban_record']")).click();
        extentLogger.info("Clicking on Action");
        driver.findElement(By.xpath("//div//button[contains(text(),'Action')]")).click();
        extentLogger.info("Clicking on delete");
        driver.findElement(By.xpath("//li//a[contains(text(),'Delete')]")).click();
        extentLogger.info("Clicking on Ok to confirm you delete action ");
        driver.findElement(By.xpath("//button//span[contains(text(),'Ok')]")).click();
        extentLogger.pass("Contact deleted successfully");
    }

    @Test
    public void invalidContactCreation() {
        extentLogger = report.createTest("Creating an invalid contact error verification");
        extentLogger.info("Logging to the application");
        pages.login().LogIn();
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
        extentLogger.info("Opening contact menu");
        pages.menu().contacts.click();
        extentLogger.info("Clicking on create button");
        pages.contactsPage().create.click();
        extentLogger.info("Clicking save button");
        driver.findElement(By.xpath("//div//button[@class='btn btn-primary btn-sm o_form_button_save']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div//div[@class='o_notification_title']")).getText().equalsIgnoreCase("the following fields are invalid:"));
        extentLogger.pass("Verification passed  successfully");
    }

    @Test
    public void editContact() {
        extentLogger = report.createTest("Editing a contact information");
        extentLogger.info("Logging to the application");
        pages.login().LogIn();
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
        extentLogger.info("Opening contact menu");
        pages.menu().contacts.click();
        wait.until(ExpectedConditions.titleIs("Contacts - Odoo"));
        extentLogger.info("Clicking on first contact from the list");
        driver.findElement(By.xpath("//div//div[@class='oe_kanban_global_click o_res_partner_kanban o_kanban_record']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div//button[contains(text(),'Edit')]"))));
        extentLogger.info("Clicking on Edit");
        driver.findElement(By.xpath("//div//button[contains(text(),'Edit')]")).click();
        extentLogger.info("Changing address");
        driver.findElement(By.xpath("//div//input[@class='o_field_char o_field_widget o_input o_address_street']")).sendKeys("addChange");
        extentLogger.info("Clicking save button");
        driver.findElement(By.xpath("//div//button[@class='btn btn-primary btn-sm o_form_button_save']")).click();
        extentLogger.pass("Editing pass successfully");
    }
    @Test
    public void searchContact() {
        extentLogger = report.createTest("Searching for a contact");
        extentLogger.info("Logging to the application");
        pages.login().LogIn();
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
        extentLogger.info("Opening contact menu");
        pages.menu().contacts.click();
        wait.until(ExpectedConditions.titleIs("Contacts - Odoo"));
        extentLogger.info("Entering a search name");
        driver.findElement(By.xpath("//input[@class='o_searchview_input']")).sendKeys("zzz"+Keys.ENTER);
        extentLogger.info("Verifying seached contact is found");
        Assert.assertTrue(driver.findElement(By.xpath("//strong//span[contains(text(),'zzz')]")).isDisplayed());
        extentLogger.info("Searched product is found");
    }

}
