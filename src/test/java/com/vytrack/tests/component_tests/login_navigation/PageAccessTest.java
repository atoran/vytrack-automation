package com.vytrack.tests.component_tests.login_navigation;

import com.vytrack.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PageAccessTest extends TestBase {

   /*
   TEST CASE: Vehicle contracts test store manager
    1.	Login to Vytrack as a store manager
    2.	Verify that you can access Vehicle contracts page
    */

    @Test
    public void VehicleContractsTestStoreManager(){
        test = report.createTest("Vehicle contracts test for Store Manager");

        test.info("Log in as store manager by using username: "+usernameStoreManager +" and password: "+password);
        loginPage.login(usernameStoreManager, password);

        test.info("Going to vehicles contract page");
        BrowserUtils.waitForUIOverlay();
        basePage.changeMenu("Fleet", "Vehicle Contracts");

        test.info("Verifying page name is equal to All Vehicle Contract");
        wait.until(ExpectedConditions.textToBePresentInElement(basePage.pageName, "All Vehicle Contract"));
        assertEquals(basePage.pageName.getText(), "All Vehicle Contract");
    }

    /*
    TEST CASE: Vehicle contracts test sales manager
    1.	Login to Vytrack as a sales manager
    2.	Verify that you can access Vehicle contracts page
     */
    @Test
    public void VehicleContractsTestSalesManager(){
        test = report.createTest("Vehicle contracts test for Sales Manager");

        test.info("Log in as sales manager by using username: "+usernameSalesManager +" and password: "+password);
        loginPage.login(usernameSalesManager, password);

        test.info("Going to vehicles contract page");
        BrowserUtils.waitForUIOverlay();
        basePage.changeMenu("Fleet", "Vehicle Contracts");

        test.info("Verifying page name is equal to All Vehicle Contract");
        wait.until(ExpectedConditions.textToBePresentInElement(basePage.pageName, "All Vehicle Contract"));
        assertEquals(basePage.pageName.getText(), "All Vehicle Contract");
    }

    /*
    TEST CASE: Vehicle contracts test store manager
    1.	Login to Vytrack as a driver
    2.	Verify that you cannot access Vehicle contracts page
    3.	Message You do not have permission to perform this action. should be displayed

     */
    @Test
    public void VehicleContractsTestDriver(){
        test = report.createTest("Vehicle contracts test for Driver");

        test.info("Log in as Driver by using username: "+usernameDriver +" and password: "+password);
        loginPage.login(usernameDriver, password);

        test.info("Going to vehicles contract page");
        BrowserUtils.waitForUIOverlay();
        basePage.changeMenu("Fleet", "Vehicle Contracts");

        test.info("Verifying that Message You do not have permission to perform this action. should be displayed");
        assertTrue(basePage.noPermissionMessage.isDisplayed());
        assertEquals(basePage.noPermissionMessage.getText(),"You do not have permission to perform this action.");
    }


}
