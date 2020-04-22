package com.vytrack.tests.smoke_tests;


import com.vytrack.base.TestBase;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VehiclesPage;
import com.vytrack.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MenuOptionsTest extends TestBase {


    /*
    Test Case: Driver
    1. Login	to	Vytrack	as	a	driver
    2. Navigate	to	Fleet	-> Vehicles,verify	page	title	Car	- Entities	- System	- Car	- Entities	-
    System,	page	name	Cars
    3. Navigate	to	Customers	à Accounts,	verify	page	title	Accounts	- Customers,	verify	page
    name	Accounts
    4. Navigate	to	Customers	à Contacts,	verify	page	title	Contacts - Customers,	verify	page	name
    Contacts
    5. Navigate	to	Activities	à Calendar	Events,	verify	page	title	Calendar	Events	- Activities,	page
    name	Calendar	Events
     */


    @Test
    public void driver() {

        test = report.createTest("Smoke test for Driver Account");

//TODO   Login	to	Vytrack	as	a	driver
        loginPage.login(usernameDriver, password);
//TODO Navigate to Fleet->Vehicles, verify page title	Car	- Entities - System - Car - Entities -System, page	name Cars
        basePage.changeMenu("Fleet", "Vehicles");
        wait.until(ExpectedConditions.titleContains("Car"));
        assertEquals(driver.getTitle(),"Car - Entities - System - Car - Entities - System");
        assertEquals(basePage.pageName.getText(), "Cars");
//TODO Navigate	to	Customers-> Accounts, verify	page title Accounts - Customers, verify	page name Accounts
        basePage.changeMenu("Customers", "Accounts");
        wait.until(ExpectedConditions.titleContains("Accounts - Customers"));
        assertEquals(driver.getTitle(), "Accounts - Customers");
        assertEquals(basePage.pageName.getText(), "Accounts");
//TODO Navigate	to	Customers-> Contacts,	verify	page title Contacts - Customers, verify	page name Contacts
        basePage.changeMenu("Customers", "Contacts");
        wait.until(ExpectedConditions.titleContains("Contacts - Customers"));
        assertEquals(driver.getTitle(), "Contacts - Customers");
        assertEquals(basePage.pageName.getText(), "Contacts");
//TODO Navigate	to Activities->Calendar	Events, verify	page title Calendar	Events - Activities, page name Calendar	Events
        basePage.changeMenu("Activities", "Calender Events");
        wait.until(ExpectedConditions.titleContains("Calender Events - Activities"));
        assertEquals(driver.getTitle(), "Calender Events - Activities");
        assertEquals(basePage.pageName.getText(), "Calender Events");
    }

    /*
    Test case: store manager
    1. Login	to	Vytrack	as	a	store	manager
    2. Navigate	to	Dashboards	à Dashboard,	verify	page	title	Dashboard	- Dashboards,	verify
    page	name	Dashboard
    3. Navigate	to	Fleet	à Vehicles,	verify	page	title	All	- Car	- Entities	- System	- Car	- Entities	-
    System,	page	name	All	Cars
    4. Navigate	to	Customers	à Accounts,	verify	page	title	All - Accounts	– Customers, verify
    page	name	All	Accounts
    5. Navigate	to	Customers	à Contacts,	verify	page	title	All - Contacts - Customers,	verify	page
    name	All	Contacts
    6. Navigate	to	Sales	à Opportunities,	verify	page	title	Open	Opportunities	- Opportunities	-
    Sales,	verify page	name	Open	Opportunities
    7. Navigate	to	Activities	à Calls	verify	page	title	All	- Calls - Activities,	page	name	All	Calls
    8. Navigate	to	Activities	à Calendar	Events,	verify	page	title	Calendar	Events	- Activities,	page
    name	All	Calendar	Events
     */

    @Test
    public void storeManager() {
        test = report.createTest("Smoke test for Store Manager Account");
//TODO Login to	Vytrack	as a store manager
        loginPage.login(usernameStoreManager, password);

//TODO Navigate	to Dashboards->Dashboard, verify page title	Dashboard - Dashboards,	verify page	name Dashboard
        BrowserUtils.waitForUIOverlay();
        basePage.changeMenu("Dashboards", "Dashboard");
        wait.until(ExpectedConditions.titleContains("Dashboard - Dashboards"));
        assertEquals(driver.getTitle(), "Dashboard - Dashboards");
        assertEquals(basePage.pageName.getText(),"Dashboard");

//TODO Navigate to Fleet  Vehicles, verify page title All - Car - Entities - System - Car - Entities - System, page name All Cars
        BrowserUtils.waitForUIOverlay();
        basePage.changeMenu("Fleet", "Vehicles");
        wait.until(ExpectedConditions.titleContains("All"));
        assertEquals(driver.getTitle(), "All - Car - Entities - System - Car - Entities - System");
        assertEquals(basePage.pageName.getText(),"All Cars");

//TODO Navigate to Customers  Accounts, verify page title All - Accounts – Customers, verify page name All Accounts
        BrowserUtils.waitForUIOverlay();
        basePage.changeMenu("Customers", "Accounts");
        wait.until(ExpectedConditions.titleContains("All - Accounts"));
        assertEquals(driver.getTitle(), "All - Accounts - Customers");
        assertEquals(basePage.pageName.getText(),"All Accounts");
//TODO Navigate to Customers  Contacts, verify page title All - Contacts - Customers, verify page name All Contacts
        BrowserUtils.waitForUIOverlay();
        basePage.changeMenu("Customers", "Contacts");
        wait.until(ExpectedConditions.titleContains("All - Contacts"));
        assertEquals(driver.getTitle(), "All - Contacts - Customers");
        assertEquals(basePage.pageName.getText(),"All Contacts");

//TODO Navigate to Sales  Opportunities, verify page title Open Opportunities - Opportunities - Sales, verify page name Open Opportunities
        BrowserUtils.waitForUIOverlay();
        basePage.changeMenu("Sales", "Opportunities");
        wait.until(ExpectedConditions.titleContains("Open Opportunities - Opportunities - Sales"));
        assertEquals(driver.getTitle(), "Open Opportunities - Opportunities - Sales");
        assertEquals(basePage.pageName.getText(),"Open Opportunities");

//TODO Navigate to Activities  Calls verify page title All - Calls - Activities, page name All Calls
        BrowserUtils.waitForUIOverlay();
        basePage.changeMenu("Activities", "Calls");
        wait.until(ExpectedConditions.titleContains("All - Calls - Activities"));
        assertEquals(driver.getTitle(), "All - Calls - Activities");
        assertEquals(basePage.pageName.getText(),"All Calls");

//TODO Navigate to Activities  Calendar Events, verify page title Calendar Events - Activities, page name All Calendar Events
        BrowserUtils.waitForUIOverlay();
        basePage.changeMenu("Activities", "Calendar Events");
        wait.until(ExpectedConditions.titleContains("All - Calendar Events - Activities"));
        assertEquals(driver.getTitle(), "All - Calendar Events - Activities");
        assertEquals(basePage.pageName.getText(),"All Calendar Events");

    }
}
