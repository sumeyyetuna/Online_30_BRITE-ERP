package com.BRITE.tests.smoke_tests;

import com.BRITE.utilities.TestBase;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class MasterDataTests extends TestBase {

    @Test
    public void createProductTest() throws InterruptedException {

        extentLogger = report.createTest("Manufacturing Product Creation Test");
        extentLogger.info("Logging to the application");
        pages.login().LogIn();
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));

        extentLogger.info("Clicking on Manufacturing");
        pages.menu().manufacturing.click();
        wait.until(ExpectedConditions.titleIs("Manufacturing Orders - Odoo"));

        extentLogger.info("Clicking on Products");
        pages.manufacturing().products.click();
        wait.until(ExpectedConditions.titleIs("Products - Odoo"));

        extentLogger.info("Clicking on Create");
        driver.findElement(By.xpath("//div//button[@accesskey='c']")).click();
        wait.until(ExpectedConditions.titleIs("New - Odoo"));

        extentLogger.info("Entering Product Name");
       driver.findElement(By.name("name")).sendKeys("First Product");

        extentLogger.info("Saving a Product");
        driver.findElement(By.xpath("//div//button[@accesskey='s']")).click();


        extentLogger.pass("Product created");

    }

    @Test
    public void searchAProduct() throws InterruptedException {

        extentLogger = report.createTest("Manufacturing Product Search");
        extentLogger.info("Logging to the application");
        pages.login().LogIn();
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));

        extentLogger.info("Clicking on Manufacturing");
        pages.menu().manufacturing.click();
        wait.until(ExpectedConditions.titleIs("Manufacturing Orders - Odoo"));

        extentLogger.info("Clicking on Products");
        pages.manufacturing().products.click();
        wait.until(ExpectedConditions.titleIs("Products - Odoo"));

        extentLogger.info("Inputing 'acsone' in search box");
       driver.findElement(By.xpath("//div//input[@class='o_searchview_input']")).sendKeys("acsone", Keys.ENTER);
        extentLogger.pass("Product found");

    }

    @Test
    public void createBillsOfMaterials() throws InterruptedException {

        extentLogger = report.createTest("Manufacturing Bills of Materials creation");
        extentLogger.info("Logging to the application");
        pages.login().LogIn();
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));

        extentLogger.info("Clicking on Manufacturing");
        pages.menu().manufacturing.click();
        wait.until(ExpectedConditions.titleIs("Manufacturing Orders - Odoo"));

        extentLogger.info("Clicking on Bills of Material");
        pages.manufacturing().bills_Of_Materials.click();
        wait.until(ExpectedConditions.titleIs("Bills of Materials - Odoo"));

        extentLogger.info("Clicking on Create");
        driver.findElement(By.xpath("//div//button[@accesskey='c']")).click();
        wait.until(ExpectedConditions.titleIs("New - Odoo"));

        extentLogger.info("Inputing a name");
        driver.findElement(By.xpath("//div[@name='product_tmpl_id']//div//input[@class='o_input ui-autocomplete-input']")).sendKeys("new product"+Keys.ENTER);


        extentLogger.info("Clicking Save");
        driver.findElement(By.xpath("//div//button[@accesskey='s']")).click();
        extentLogger.pass("Created");
    }

    @Test
    public void ordersGraphics() throws InterruptedException {
        extentLogger = report.createTest("Manufacturing Orders Graphics Test");
        extentLogger.info("Logging to the application");
        pages.login().LogIn();
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));

        extentLogger.info("Clicking on Manufacturing");
        pages.menu().manufacturing.click();
        wait.until(ExpectedConditions.titleIs("Manufacturing Orders - Odoo"));

        extentLogger.info("Clicking on Manufacturing Orders");
        pages.manufacturing().manufactoring_Orders_Report.click();
        wait.until(ExpectedConditions.titleIs("Manufacturing Orders - Odoo"));

        extentLogger.info("Veriying Graphic is Displayed");
        driver.findElement(By.xpath("//div[@class='o_graph']//div[@class='o_graph_svg_container']")).isDisplayed();
        extentLogger.pass("Verified");
    }
}
