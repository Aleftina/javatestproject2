package ua.javatests.adressbookweb.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ua.javatests.adressbookweb.appmanager.ApplicationManager;

public class BaseTest {

    protected static final ApplicationManager applic = new ApplicationManager(BrowserType.FIREFOX);

    @BeforeSuite
    public void setUp() throws Exception {
        applic.init();
    }

    @AfterSuite
    public void tearDown() {
      //  applic.stopDriver();
    }

}
