package ua.javatests.adressbookweb.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends BaseHelper {
    //private FirefoxDriver wd;

    public SessionHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void loginAddressbook(String username, String password) {
        type(By.name("user"), username);
        type(By.name("pass"), password);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }
}

