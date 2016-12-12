package ua.javatests.adressbookweb.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends BaseHelper {

//    private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void groupPageLink() {
        click(By.linkText("group page"));
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
