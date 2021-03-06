package com.vytrack.base;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[contains(text(), 'Fleet')][@class='title title-level-1']")
    public WebElement fleet;

    @FindBy(xpath = "//span[.='Vehicles'][@class='title title-level-2']")
    public WebElement vehicles;

    @FindBy(className = "oro-subtitle")
    public WebElement pageName;

    @FindBy(xpath = "//li[@id='user-menu']/a")
    public WebElement accountHolderName;

    @FindBy(linkText = "Logout")
    public WebElement logOutButton;

    @FindBy(xpath = "//div[text() ='You do not have permission to perform this action.']")
    public WebElement noPermissionMessage;

    public void changeMenu(String menu1, String menu2) {
        String menu1X = "//span[contains(text(), '"+menu1+"')][@class='title title-level-1']";
        WebElement menu1El = Driver.getDriver().findElement(By.xpath(menu1X));

        String menu2X = "//span[.='"+menu2+"'][@class='title title-level-2']";
        WebElement menu2El = Driver.getDriver().findElement(By.xpath(menu2X));

        WebDriverWait wait =new WebDriverWait(Driver.getDriver(), 5);

        wait.until(ExpectedConditions.elementToBeClickable(menu1El));
        menu1El.click();

        wait.until(ExpectedConditions.elementToBeClickable(menu2El));
        menu2El.click();
    }

    public void logOut(){
        accountHolderName.click();
        logOutButton.click();
    }
}
