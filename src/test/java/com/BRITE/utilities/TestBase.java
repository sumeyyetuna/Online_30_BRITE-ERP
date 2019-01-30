package com.BRITE.utilities;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;
//    protected Pages pages;

    protected static ExtentReports report;
    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentLogger;

    @BeforeMethod
    public void setupMethod(){
        driver = Driver.getDriver();
        driver.manage().window().fullscreen();
//        pages = new Pages();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) throws IOException{
        if(result.getStatus() == ITestResult.FAILURE){
            String screenshotLocation = BrowserUtils.getScreenshot(result.getName());
            extentLogger.fail(result.getName());
            extentLogger.addScreenCaptureFromPath(screenshotLocation);
            extentLogger.fail(result.getThrowable());
        }else if (result.getStatus()==ITestResult.SKIP){
            extentLogger.skip("test Case Skipped: "+result.getName());
        }
        Driver.closeDriver();
    }
}
