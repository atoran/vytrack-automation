package com.vytrack.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.vytrack.pages.*;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected SoftAssert softAssert;

    protected String url;
    protected String usernameDriver;
    protected String usernameStoreManager;
    protected String usernameSalesManager;
    protected String password;

    protected ExtentReports report;
    private ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    protected Select select;

    protected BasePage basePage;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected VehiclesPage vehiclesPage;
    protected AccountsPage accountsPage;
    protected ContactsPage contactsPage;

    @BeforeMethod
    public void setUp(){

        report = new ExtentReports();
        String path = System.getProperty("user.dir") +"/test-output/report.html";
        htmlReporter = new ExtentHtmlReporter(path);
        htmlReporter.config().setReportName("Vytrack Automated Tests");
        report.attachReporter(htmlReporter);
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));

        driver= Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);
        softAssert = new SoftAssert();

        url = ConfigurationReader.getProperty("url");
        usernameDriver = ConfigurationReader.getProperty("usernameDriver");
        usernameStoreManager =  ConfigurationReader.getProperty("usernameStoreManager");
        usernameSalesManager = ConfigurationReader.getProperty("usernameSalesManager");
        password = ConfigurationReader.getProperty("password");

        driver.get(url);

        basePage = new DashboardPage();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        vehiclesPage = new VehiclesPage();
        accountsPage = new AccountsPage();
        contactsPage = new ContactsPage();

    }

    @AfterMethod
    public void tearDownMethod(ITestResult iTestResult) throws IOException {
        // ITestResult gives information about current test: name, status
        // check if the test failed
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            // tell extent report that the test failed
            test.fail(iTestResult.getName());

            // take screen shot of the screen and save location
            String screenshot = BrowserUtils.getScreenshot(iTestResult.getName());
            // show path to screenshot
            test.addScreenCaptureFromPath(screenshot);
        }


        Driver.closeDriver();
        softAssert.assertAll();
    }

    @AfterSuite
    public void tearDownSuite(){
        report.flush();
    }

}
