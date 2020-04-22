package com.vytrack.tests.component_tests.activities;

import com.vytrack.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class aa extends TestBase {

    @Test
    public void test() {
        driver.get("http://te.dev.secureci.com/Exercise1.html");
        List <WebElement> links= driver.findElements(By.xpath("//area[@href]"));

        Set<String> hrefText = new HashSet<>();

        for (WebElement link : links) {
            hrefText.add(link.getAttribute("href"));
        }


        for (String s : hrefText) {
            driver.get(s);
            System.out.println(driver.findElement(By.tagName("h1")).getText());
            System.out.println(driver.getCurrentUrl());
            Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("You clicked on map link"));
        }
    }
}
