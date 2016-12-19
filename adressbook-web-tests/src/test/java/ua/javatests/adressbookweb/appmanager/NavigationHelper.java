package ua.javatests.adressbookweb.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {


    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void returnGroupPageLink() {
        click(By.linkText("group page"));
    }

    public void groupsLink() {
        wd.findElement(By.linkText("groups")).click();
    }
    //public void homePageLink() {
//        wd.findElementByLinkText("home").click();
//    }
    public void homePageLink() {
        wd.findElement(By.linkText("home")).click();
    }

    public void addNewUserLink() {
        wd.findElement(By.linkText("add new")).click();
    }

}
