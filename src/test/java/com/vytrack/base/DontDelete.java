package com.vytrack.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DontDelete {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        String currentMonthText=localDate.getMonth().toString();
        System.out.println("currentMonth = " + currentMonthText);

        int currentDayNumber = localDate.getDayOfMonth();
        System.out.println("currentDay = " + currentDayNumber);

        int currentMonthNumber = localDate.getMonthValue();
        System.out.println("monthNumber = " + currentMonthNumber);
        
        int currentYear = localDate.getYear();
        System.out.println("currentYear = " + currentYear);

        boolean isLeapYear = localDate.isLeapYear();
        System.out.println("isLeapYear = " + isLeapYear);

        int lengthOfTheCurrentMonth = localDate.lengthOfMonth();
        System.out.println("lengthOfTheCurrentMonth = " + lengthOfTheCurrentMonth);

        String currentDayText = localDate.getDayOfWeek().toString();
        System.out.println("currentDayText = " + currentDayText);
        


    }
}
