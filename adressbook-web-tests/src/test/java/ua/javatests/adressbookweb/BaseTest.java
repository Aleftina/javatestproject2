package ua.javatests.adressbookweb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
