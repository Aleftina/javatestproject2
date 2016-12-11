package ua.javatests.adressbookweb.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {

    private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void groupPageLink() {
        wd.findElement(By.linkText("group page")).click();
    }
    public void groupsLink() {
        wd.findElement(By.linkText("groups")).click();
    }
    public void homePageLink() {
        wd.findElementByLinkText("home").click();
    }
    public void addNewUserLink() {
        wd.findElement(By.linkText("add new")).click();
    }

}
