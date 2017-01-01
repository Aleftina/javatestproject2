package ua.javatests.adressbookweb.appmanager;

import org.openqa.selenium.*;

public class BaseHelper {

    protected WebDriver wd;

    public BaseHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String oldText = wd.findElement(locator).getAttribute("value");
            if (!(oldText.equals(text))) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected boolean isElementPresent(By locator) {
    try {
        wd.findElement(locator);
        return true;
    }
    catch (NoSuchElementException e){
        return false;
    }
    }

}
