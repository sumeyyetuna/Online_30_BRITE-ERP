package com.BRITE.tests.functional_tests;

import com.BRITE.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Manufacturing extends TestBase {
    @Test
    public void errorAccessManufOrdersInfo()  {
        extentLogger = report.createTest("Accessing information of manufacturing order");
        extentLogger.info("Logging to the application");
        pages.login().LogIn();
        extentLogger.info("Opening manufacturing menu");
        pages.menu().manufacturing.click();
        wait.until(ExpectedConditions.titleIs("Manufacturing Orders - Odoo"));
        extentLogger.info("Clicking on first order from the list");
        driver.findElement(By.xpath("//tr//td[2]")).click();
        extentLogger.info("Verifying error message");
        System.out.println(driver.findElement(By.xpath("//h4")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//h4")).getText().equalsIgnoreCase("Odoo Server Error - Access Error"));
        extentLogger.pass("Error message verified");

    }

    @Test
    public void manufOrderSeachByID() {
        extentLogger = report.createTest("Search manufacturing order bu ID");
        extentLogger.info("Logging to the application");
        pages.login().LogIn();
        extentLogger.info("Opening manufacturing menu");
        pages.menu().manufacturing.click();
        wait.until(ExpectedConditions.titleIs("Manufacturing Orders - Odoo"));
        extentLogger.info("Entering search name MO/00095 in search box");
        driver.findElement(By.xpath("//input[@class='o_searchview_input']")).sendKeys("MO/00095"+ Keys.ENTER);
        extentLogger.info("Verifying product is displayed");
        Assert.assertTrue(driver.findElement(By.xpath("//td[2]")).isDisplayed());
    }

    @Test
    public void productSearch() {
        extentLogger = report.createTest("Product search");
        extentLogger.info("Logging to the application");
        pages.login().LogIn();
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
        extentLogger.info("Opening manufacturing menu");
        pages.menu().manufacturing.click();
        wait.until(ExpectedConditions.titleIs("Manufacturing Orders - Odoo"));
        extentLogger.info("Clicking on Products");
        pages.manufacturing().products.click();
        wait.until(ExpectedConditions.titleIs("Products - Odoo"));

        extentLogger.info("Inputing 'apple' in search box");
        driver.findElement(By.xpath("//div//input[@class='o_searchview_input']")).sendKeys("acsone", Keys.ENTER);
        extentLogger.info("Verifying that any relevant products containg that name found");
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='o_pager_limit']")).isDisplayed());
        extentLogger.pass("Product found");
    }
    @Test
    public void ordersReport() throws InterruptedException {
        extentLogger = report.createTest("Manufacturing Orders Graphics Test");
        extentLogger.info("Logging to the application");
        pages.login().LogIn();
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));

        extentLogger.info("Clicking on Manufacturing");
        pages.menu().manufacturing.click();
        wait.until(ExpectedConditions.titleIs("Manufacturing Orders - Odoo"));

        extentLogger.info("Clicking on Manufacturing Orders");
        pages.manufacturing().manufactoring_Orders_Report.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='o_graph']//div[@class='o_graph_svg_container']"))));

        extentLogger.info("Searching for a spacific report: 'MO/00095'");
        driver.findElement(By.xpath("//input[@class='o_searchview_input']")).sendKeys("MO/00095"+Keys.ENTER);

        extentLogger.info("Veriying Graphic is Displayed");
        driver.findElement(By.xpath("//div[@class='o_graph']//div[@class='o_graph_svg_container']")).isDisplayed();
        extentLogger.pass("Verified");
    }
    @Test
    public void quantityToProduceGraphic() {
        extentLogger = report.createTest("Quantity to Produce Graphics Test");
        extentLogger.info("Logging to the application");
        pages.login().LogIn();
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));

        extentLogger.info("Clicking on Manufacturing");
        pages.menu().manufacturing.click();
        wait.until(ExpectedConditions.titleIs("Manufacturing Orders - Odoo"));

        extentLogger.info("Clicking on Manufacturing Orders");
        pages.manufacturing().manufactoring_Orders_Report.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='o_graph']//div[@class='o_graph_svg_container']"))));

        extentLogger.info("Clicking on Measures");
        driver.findElement(By.xpath("//div//button[@class='btn btn-primary btn-sm dropdown-toggle']")).click();

        extentLogger.info("Clicking on 'Quantity to Produce");
        driver.findElement(By.xpath("//a[contains(text(),'Quantity To Produce')]")).click();

        extentLogger.info("Veriying Graphic is Displayed");
        driver.findElement(By.xpath("//div[@class='o_graph']//div[@class='o_graph_svg_container']")).isDisplayed();
        extentLogger.pass("Verified");

    }
}
