package ua.javatests.adressbookweb.appmanager;


import org.openqa.selenium.firefox.FirefoxDriver;
import ua.javatests.adressbookweb.model.UserData;

public class ContactHelper {

    private FirefoxDriver wd;

    public ContactHelper(FirefoxDriver wd){
        this.wd = wd;
    }

    public void fillUserParameters(UserData userData) {
        wd.findElementByName("firstname").sendKeys(userData.getFirstName());
        wd.findElementByName("lastname").sendKeys(userData.getLastName());
        wd.findElementByName("mobile").sendKeys(userData.getMobile());
        wd.findElementByName("email").sendKeys(userData.getEmail());
    }

    public void submitNewUser() {
        wd.findElementByName("submit").click();
    }
}
