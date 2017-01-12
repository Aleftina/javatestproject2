package ua.javatests.adressbookweb.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;
import ua.javatests.adressbookweb.appmanager.ApplicationManager;
import ua.javatests.adressbookweb.model.GroupData;
import ua.javatests.adressbookweb.model.UserData;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

public class BaseTest {

    protected static final ApplicationManager applic = new ApplicationManager(BrowserType.CHROME);

    @BeforeSuite
    public void setUp() throws Exception {
        applic.init();
    }

    @AfterSuite
    public void tearDown() {
        applic.stopDriver();
    }

}
