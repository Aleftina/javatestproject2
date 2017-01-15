package ua.javatests.adressbookweb.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {


    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void groupsPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    public void homePage() {
        wd.findElement(By.linkText("home")).click();
    }
}
