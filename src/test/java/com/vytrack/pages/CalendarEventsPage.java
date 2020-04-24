package com.vytrack.pages;

import com.vytrack.base.BasePage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.LocalDate;
import java.util.*;


public class CalendarEventsPage extends BasePage {

    @FindBy(xpath = "//a[@title='Create Calendar event']")
    public WebElement createCalendarEvents;

    @FindBy(xpath = "//input[starts-with(@id, 'date_selector_oro_calendar_event_form_start-uid')]")
    public WebElement startDate;

    @FindBy(xpath = "//input[contains(@id, 'date_selector_oro_calendar_event_form_end-uid')]")
    public WebElement endDate;


    @FindBy(xpath = "//input[contains(@id, 'time_selector_oro_calendar_event_form_start-uid')]")
    public WebElement startTime;

    @FindBy(xpath = "//input[contains(@id, 'time_selector_oro_calendar_event_form_end-uid')]")
    public WebElement endTime;

    //li[contains(@class, 'ui-timepicker')]

    @FindBy(xpath = "//li[contains(@class, 'ui-timepicker')]")
    public List<WebElement> listOfTimesEl;


    LocalDate localDate = LocalDate.now();
    int currentDayNumber = localDate.getDayOfMonth();
    int lengthOfTheCurrentMonth = localDate.lengthOfMonth();
    int currentYear = localDate.getYear();
    int currentMonthNumber = localDate.getMonthValue();

    public void chooseFutureDate() {
        Select select;
        String xpath;
        WebElement futureDayToBeChosen;
        if (currentDayNumber < lengthOfTheCurrentMonth) {
            xpath = "//td/a[text()='" + (currentDayNumber + 1) + "']";
            futureDayToBeChosen = Driver.getDriver().findElement(By.xpath(xpath));
            futureDayToBeChosen.click();
        } else if (currentMonthNumber < 12) {
            WebElement monthDropDown = Driver.getDriver().findElement(By.className("ui-datepicker-month"));
            select = new Select(monthDropDown);
            select.selectByIndex(currentMonthNumber);// this will choose the next month
            xpath = "//td/a[text()='1']";
            futureDayToBeChosen = Driver.getDriver().findElement(By.xpath(xpath));
            futureDayToBeChosen.click();
        } else {
            WebElement yearDropDown = Driver.getDriver().findElement(By.className("ui-datepicker-year"));
            select = new Select(yearDropDown);
            select.selectByVisibleText("" + (currentYear + 1));
            xpath = "//td/a[text()='1']";
            futureDayToBeChosen = Driver.getDriver().findElement(By.xpath(xpath));
            futureDayToBeChosen.click();
        }
    }

    public void chooseTodaysDate() {
        Select select;
        WebElement yearDropDown = Driver.getDriver().findElement(By.className("ui-datepicker-year"));
        select = new Select(yearDropDown);
        select.selectByVisibleText("" + (currentYear));
        WebElement monthDropDown = Driver.getDriver().findElement(By.className("ui-datepicker-month"));
        select = new Select(monthDropDown);
        select.selectByIndex(currentMonthNumber - 1);
        String xpath = "//td/a[text()='" + (currentDayNumber) + "']";
        WebElement currentDay = Driver.getDriver().findElement(By.xpath(xpath));
        currentDay.click();
    }

    public void chooseDifferentStartTime() {

        String selectedTime = startTime.getAttribute("value");

        for (WebElement element : listOfTimesEl) {

            if (!element.getAttribute("value").equals(selectedTime)) {
                element.click();
                break;
            }

        }

    }

    public void chooseDifferentStartTime(String time) {
        String xpath = "//li[contains(@class, 'ui-timepicker')][text()='"+time+"']";
        Driver.getDriver().findElement(By.xpath(xpath)).click();
    }

        public int checkTheTimeDifference () {
            int startTime = Integer.parseInt(this.startTime.getAttribute("value").split(":")[0]);
            int endTime = Integer.parseInt(this.endTime.getAttribute("value").split(":")[0]);

            if (startTime == 12) {
                startTime = 0;
            }
            return endTime - startTime;
        }

    }




