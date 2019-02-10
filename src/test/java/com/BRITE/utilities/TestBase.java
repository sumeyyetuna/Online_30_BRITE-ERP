package com.BRITE.utilities;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;
    protected Pages pages;

    protected static ExtentReports report;
    private static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentLogger;
    protected WebDriverWait wait;


    @BeforeMethod(alwaysRun = true)
    public void setupMethod() {
        driver = Driver.getDriver();
        pages = new Pages();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
        driver.get(ConfigurationReader.getProperty("url"));
        driver.manage().window().fullscreen();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result) throws IOException {
        // if any test fails, it can detect it,
        // take a screen shot at the point and attach to report
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotLocation = BrowserUtils.getScreenshot(result.getName());
            extentLogger.fail(result.getName());
            extentLogger.addScreenCaptureFromPath(screenshotLocation);
            extentLogger.fail(result.getThrowable());

        } else if (result.getStatus() == ITestResult.SKIP) {
            extentLogger.skip("Test Case Skipped: " + result.getName());
        }
        Driver.closeDriver();
    }

    @BeforeTest(alwaysRun = true)
    public void setUpTest() {
        report = new ExtentReports();
        // this is our custom location of the report that will be generated
        // report will be generated in the current project inside folder: test-output
        // report file name: report.html
        String filePath = System.getProperty("user.dir") + "/test-output/report.html";

//        windows users pls correct ur path:
//        String filePath = System.getProperty("user.dir") + "\\test-output\\report.html";

        // initialize the htmlReporter with the path to the report
        htmlReporter = new ExtentHtmlReporter(filePath);

        // we attach the htmlreport to our report
        report.attachReporter(htmlReporter);

        report.setSystemInfo("Environment", "Staging");
        report.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));

        report.setSystemInfo("QA Engineer", "Admiral Kunkka");

        htmlReporter.config().setDocumentTitle("BRITE-ERP");
        htmlReporter.config().setReportName("Smoke Test");

//        htmlReporter.config().setTheme(Theme.DARK);

    }










    @AfterTest(alwaysRun = true)
    public void tearDownTest() {
        report.flush();
    }
}
