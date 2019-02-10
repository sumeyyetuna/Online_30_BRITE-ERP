package com.BRITE.tests.functional_tests;

import com.BRITE.pages.DiscussPage;
import com.BRITE.pages.Log_In;
import com.BRITE.utilities.ConfigurationReader;
import com.BRITE.utilities.TestBase;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DiscussMenu extends TestBase {

    @Test
    public void generalMessagesTest(){


        WebDriverWait wait = new WebDriverWait(driver,20);
        extentLogger = report.createTest("Testing test case BRIT-625");
        extentLogger.info("Logging to the application");

        pages.login().LogIn();

        extentLogger.info("Clicking Manufacturing module");
        pages.menu().manufacturing.click();

        extentLogger.info("Clicking Discuss menu");
        pages.menu().discuss.click();

        DiscussPage discussPage = new DiscussPage();

        extentLogger.info("Clicking '+' button next to channels button");
        wait.until(ExpectedConditions.elementToBeClickable(discussPage.channels));
        discussPage.channels.click();


        wait.until(ExpectedConditions.elementToBeClickable(discussPage.create));
        discussPage.create.click();

        discussPage.channelName.sendKeys("general announcement");
        discussPage.save.click();

        extentLogger.info("Checking if 'general announcement' channel is displayed");
        Assert.assertEquals(discussPage.channelTitle.getText(),"general announcement");

        extentLogger .pass("Passed:general channel test");

    }

    @Test
    public void privateChannelTest(){


        WebDriverWait wait = new WebDriverWait(driver,10);
        extentLogger = report.createTest("Testing test case BRIT-1021");
        extentLogger.info("Logging to the application");

        pages.login().LogIn();

        extentLogger.info("Clicking Manufacturing module");
        pages.menu().manufacturing.click();

        extentLogger.info("Clicking Discuss menu");
        pages.menu().discuss.click();

        extentLogger.info("Creating a private messages channel");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[data-type='private']")));
        driver.findElement(By.cssSelector("span[data-type='private']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[class='o_input']")));
        driver.findElement(By.cssSelector("input[class='o_input']")).sendKeys("scrum_meeting" + Keys.ENTER);


        extentLogger.info("Checking if scrum meeting channel is displayed");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='o_mail_thread']")).isDisplayed());

        extentLogger.info("Typing a message");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@class='o_input o_composer_text_field' and contains(text(),'')]")));
        driver.findElement(By.xpath("//textarea[@class='o_input o_composer_text_field' and contains(text(),'')]")).
                sendKeys("Hello everyone"+Keys.ENTER);

        extentLogger.info("Checking scrum_meeting channel displays");
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='o_mail_thread']")).getText().contains("scrum_meeting"));

        extentLogger .pass("Passed:private channel test");

    }

    @Test
    public void textToSpecificUser(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        extentLogger = report.createTest("Testing test case BRIT-1006");
        extentLogger.info("Logging to the application");

        pages.login().LogIn();

        extentLogger.info("Clicking Manufacturing module");
        pages.menu().manufacturing.click();

        extentLogger.info("Clicking Discuss menu");
        pages.menu().discuss.click();

        extentLogger.info("Clicking a direct messages channel");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[data-type='dm']")));
        driver.findElement(By.cssSelector("span[data-type='dm']")).click();

        extentLogger.info("Choosing POSManager10 ");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-type='dm']>input[class='o_input ui-autocomplete-input']")));
        driver.findElement(By.cssSelector("div[data-type='dm']>input[class='o_input ui-autocomplete-input']")).sendKeys("posManager10");

        Actions actions = new Actions(driver);
        WebElement posmanager10 = driver.findElement(By.linkText("POSManager10"));
        actions.click(posmanager10).perform();

        extentLogger.info("Typing a message");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@class='o_input o_composer_text_field' and contains(text(),'')]")));
        driver.findElement(By.xpath("//textarea[@class='o_input o_composer_text_field' and contains(text(),'')]")).
                sendKeys("Hello POSManager10"+Keys.ENTER);
    }

}
