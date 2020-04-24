package com.vytrack.tests.component_tests.activities;

import com.vytrack.base.TestBase;
import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


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

        BrowserUtils.waitElementToBeClickable(calendarEventsPage.createCalendarEvents);
        calendarEventsPage.createCalendarEvents.click();

        calendarEventsPage.startDate.click();

        calendarEventsPage.chooseFutureDate();

        BrowserUtils.wait(3);

        assertEquals(calendarEventsPage.startDate.getAttribute("value"),
                calendarEventsPage.endDate.getAttribute("value"));

        calendarEventsPage.startDate.click();

        calendarEventsPage.chooseTodaysDate();

        assertEquals(calendarEventsPage.startDate.getAttribute("value"),
                calendarEventsPage.endDate.getAttribute("value"));

    }

    /*
    Test-2:	Date Time, End time auto adjust
    1.	Log in as Valid user
    2.	Go to Activities -> Calendar Events
    3.	Click on create new calendar event
    4.	Change the start time to any other time
    5.	Verify that end time changes exactly 1 hours later
     */

    @Test
    public void futureTimeTest(){
        test = report.createTest("Future Time Test");

        test.info("Log in as a driver by using username: "+usernameDriver+" and password: "+password );
        loginPage.login(usernameDriver, password);

        test.info("Going to Calendar Events page");
        BrowserUtils.waitForUIOverlay();
        basePage.changeMenu("Activities", "Calendar Events");

        test.info("Clicking on Create Calendar Events Button");
        calendarEventsPage.createCalendarEvents.click();

        test.info("Clicking on start time");
        calendarEventsPage.startTime.click();

        test.info("Choosing a different start time");
        calendarEventsPage.chooseDifferentStartTime();

        test.info("Verifying end time is one hour later than start time");
        assertEquals(calendarEventsPage.checkTheTimeDifference(), 1);
    }

    /*
    Test-3:	Date Time, End date/time auto adjust
    1.	Log in as Valid user
    2.	Go to Activities -> Calendar Events
    3.	Click on create new calendar event
    4.	Change the start time to 11.30 PM
    5.	Verify that end date shows tomorrows date
    6.	Verify that end time is 12:30 AM
     */

    @Test
    public void NextDayTest(){
        test = report.createTest("Next Day Test");

        test.info("Log in as a driver by using username: "+usernameDriver+" and password: "+password );
        loginPage.login(usernameDriver, password);

        test.info("Going to Calendar Events page");
        BrowserUtils.waitForUIOverlay();
        basePage.changeMenu("Activities", "Calendar Events");

        test.info("Clicking on Create Calendar Events Button");
        BrowserUtils.waitForUIOverlay();
        calendarEventsPage.createCalendarEvents.click();

        test.info("Clicking on start time");
        calendarEventsPage.startTime.click();

        calendarEventsPage.chooseDifferentStartTime("11:30 PM");




    }
}
