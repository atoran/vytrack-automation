package com.vytrack.tests.component_tests.activities;

import com.vytrack.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import org.testng.annotations.Test;

public class DateAndTimeTests extends TestBase {

    /*
    Test-1: Date Time, End date auto adjust
    1.	Log in as Valid user
    2.	Go to -> Calendar Events
    3.	Click on create new calendar event
    4.	Change the start date to future date
    5.	Verify that end date changes to the same date
    6.	Change back the start date to today’s date
    7.	Verify that end date changes back to today’s date
     */
    @Test
    public void futureDateTest(){
        test = report.createTest("Future Date Test");

        loginPage.login(usernameDriver, password);

        basePage.changeMenu("Activities", "Calendar Events");

        BrowserUtils.waitForUIOverlay();
        calendarEventsPage.createCalendarEvents.click();

        calendarEventsPage.startDate.click();
    }


}
