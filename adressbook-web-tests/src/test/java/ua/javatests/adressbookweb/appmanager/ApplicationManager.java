package ua.javatests.adressbookweb.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    FirefoxDriver wd;

    private ContactHelper contactHelper;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;

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
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    public void stopDriver() {wd.quit();
    }

    public void openURL(String url) {
        wd.get(url);
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
