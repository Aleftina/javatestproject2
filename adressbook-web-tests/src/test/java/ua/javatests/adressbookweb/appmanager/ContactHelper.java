package ua.javatests.adressbookweb.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ua.javatests.adressbookweb.model.UserData;

public class ContactHelper extends BaseHelper {

    public ContactHelper(FirefoxDriver wd){
        super(wd);
    }

    public void fillUserParameters(UserData userData) {
        type(By.name("firstname"), userData.getFirstName());
        type(By.name("lastname"), userData.getLastName());
        type(By.name("mobile"),userData.getMobile());
        type(By.name("email"),userData.getEmail());
    }

    public void submitNewUser() {
        click(By.name("submit"));
    }
}
