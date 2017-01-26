package ua.javatests.adressbookweb.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    private ContactHelper contactHelper;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }

    public void init() {
        startDriver();
        openURL("http://localhost/addressbook/group.php");

        contactHelper = new ContactHelper(wd);
        sessionHelper = new SessionHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        groupHelper = new GroupHelper(wd);

        sessionHelper.loginAddressbook("admin", "secret");
    }

    public void startDriver() {
        if (browser == BrowserType.FIREFOX) {
            wd = new FirefoxDriver();
        }
        else if (browser == BrowserType.CHROME) {
            wd = new ChromeDriver();
        }

        else {
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }


    public void stopDriver() {wd.quit();
    }

    public void openURL(String url) {
        wd.get(url);
    }

    public ContactHelper contact() {
        return contactHelper;
    }
    public GroupHelper group() {
        return groupHelper;
    }
    public NavigationHelper goTo() {
        return navigationHelper;
    }
    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
