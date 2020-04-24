package com.vytrack.pages;

import com.vytrack.base.BasePage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.*;


public class CalendarEventsPage extends BasePage {

    @FindBy(xpath = "//a[@title='Create Calendar event']")
    public WebElement createCalendarEvents;

    @FindBy(xpath = "//input[starts-with(@id, 'date_selector_oro_calendar_event_form_start-uid')]")
    public WebElement startDate;

    @FindBy(xpath = "//input[contains(@id, 'date_selector_oro_calendar_event_form_end-uid')]")
    public WebElement endDate;










    LocalDate localDate = LocalDate.now();
    int currentDayNumber = localDate.getDayOfMonth();
    int lengthOfTheCurrentMonth = localDate.lengthOfMonth();
    int currentYear = localDate.getYear();
    int currentMonthNumber = localDate.getMonthValue();
//    String currentMonthText=localDate.getMonth().toString();
//    boolean isLeapYear = localDate.isLeapYear();
//    String currentDayText = localDate.getDayOfWeek().toString();

    public void chooseFutureDate() {
        Select select;
        String xpath;
        WebElement futureDayToBeChosen;
//        List<WebElement> numberOfDaysEl = Driver.getDriver().findElements(By.xpath("//td/a"));
//        int lengthOfTheCurrentMonth = numberOfDaysEl.size();
        if (currentDayNumber < lengthOfTheCurrentMonth) {
            xpath = "//td/a[text()='" + (currentDayNumber + 1) + "']";
            futureDayToBeChosen = Driver.getDriver().findElement(By.xpath(xpath));
            futureDayToBeChosen.click();
        } else if (currentMonthNumber < 12)  {
            WebElement monthDropDown = Driver.getDriver().findElement(By.className("ui-datepicker-month"));
            select = new Select(monthDropDown);
//            List<WebElement> monthsEl = select.getOptions();
//            List<String> monthsText = BrowserUtils.getElementsText(monthsEl);
//            Map<Integer, String> monthsMap = new HashMap<>();
//            for (int i = 0; i < 12; i++) {
//                monthsMap.put(i + 1, monthsText.get(i));
//            }

//            WebElement selectedMonth = select.getFirstSelectedOption();
//            String selectedMonthText = selectedMonth.getText();
//            int currentMonthNumber = 0; // not index
//            for (int i = 1; i <= 12; i++) {
//                if (monthsMap.get(i).equals(selectedMonthText)) {
//                    currentMonthNumber = i; // not index
//                    break;
//                }
//            }

            //since selectByIndex() method selects based on 0 count, we don't need to say "currentMonthNumber+1"

                select.selectByIndex(currentMonthNumber);// this will choose the next month
                xpath = "//td/a[text()='1']";
                futureDayToBeChosen = Driver.getDriver().findElement(By.xpath(xpath));
                futureDayToBeChosen.click();
            } else {
                WebElement yearDropDown = Driver.getDriver().findElement(By.className("ui-datepicker-year"));
                select = new Select(yearDropDown);
//                WebElement selectedYear=select.getFirstSelectedOption();
//                String selectedYearText = selectedYear.getText();
//                String nextyear = ""+(Integer.parseInt(selectedYearText)+1);
                select.selectByVisibleText(""+(currentYear+1));
                xpath = "//td/a[text()='1']";
                futureDayToBeChosen = Driver.getDriver().findElement(By.xpath(xpath));
                futureDayToBeChosen.click();

            }
        }

    public void chooseTodaysDate() {
        Select select;
        WebElement yearDropDown = Driver.getDriver().findElement(By.className("ui-datepicker-year"));
        select = new Select(yearDropDown);
        select.selectByVisibleText(""+(currentYear));
        WebElement monthDropDown = Driver.getDriver().findElement(By.className("ui-datepicker-month"));
        select = new Select(monthDropDown);
        select.selectByIndex(currentMonthNumber-1);
        String xpath = "//td/a[text()='" + (currentDayNumber) + "']";
        WebElement currentDay = Driver.getDriver().findElement(By.xpath(xpath));
        currentDay.click();
    }


    }



