package ua.javatests.adressbookweb.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ua.javatests.adressbookweb.appmanager.ApplicationManager;

public class BaseTest {

    protected final ApplicationManager applic = new ApplicationManager();

    @AfterMethod
    public void tearDown() {
        applic.stop();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        applic.init();
    }

}
