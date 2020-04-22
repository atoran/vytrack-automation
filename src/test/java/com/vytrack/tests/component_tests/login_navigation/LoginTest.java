package com.vytrack.tests.component_tests.login_navigation;


import com.vytrack.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest extends TestBase {
    /*
    TEST CASE: Login test (positive)
    1.	Login to Vytrack as a store manager
    2.	Verify name of the store manager is displayed on top right
    3.	Verify Dashboad page is open
    4.	Log out
    5.	Login to Vytrack as a sales manager
    6.	Verify Dashboad page is open
    7.	A different name should be displayed on top right
    8.	Log out
    9.	Login to Vytrack as a driver
    10.	Verify Dashboad/Quick Launchpad page is open
    11.	A different name should be displayed on top right
     */

    @Test
    public void positive(){
        test = report.createTest("Log In Test - Positive Scenario");
// TODO Login	to	Vytrack	as	a	store	manager
        loginPage.login(usernameStoreManager, password);
// TODO Verify	name	of	the	store	manager is	displayed	on	top	right
       assertTrue(basePage.accountHolderName.isDisplayed());
       String storeManagerName = basePage.accountHolderName.getText();
// TODO  Verify	Dashboard	page	is	open
        assertEquals(driver.getTitle(), "Dashboard");
// TODO  Log out
        BrowserUtils.waitForUIOverlay();
        basePage.logOut();
// TODO  Login	to	Vytrack	as	a	sales manager
        loginPage.login(usernameSalesManager, password);
// TODO Verify	Dashboad	page	is	open
        assertEquals(driver.getTitle(), "Dashboard");
// TODO  A different	name	should	be	displayed	on	top	right
        String salesManagerName = basePage.accountHolderName.getText();
        assertNotEquals(salesManagerName, storeManagerName);
// TODO Log	out
        BrowserUtils.waitForUIOverlay();
        basePage.logOut();
// TODO Login	to	Vytrack	as	a	driver
        loginPage.login(usernameDriver, password);
// TODO Verify	Dashboard/Quick	Launchpad	page	is	open
        assertEquals(driver.getTitle(), "Dashboard");
        assertEquals(basePage.pageName.getText(), "Quick Launchpad");
// TODO A different	name	should	be	displayed	on	top	right
        String driverName = basePage.accountHolderName.getTagName();
        assertNotEquals(driverName, salesManagerName);
    }
}
