package ua.javatests.adressbookweb.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ua.javatests.adressbookweb.appmanager.ApplicationManager;

public class BaseTest {

    protected final ApplicationManager applic = new ApplicationManager(BrowserType.CHROME);

    @AfterMethod
    public void tearDown() {
        applic.stopDriver();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        applic.init();
    }
}
