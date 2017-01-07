package ua.javatests.adressbookweb.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import ua.javatests.adressbookweb.appmanager.ApplicationManager;
import ua.javatests.adressbookweb.model.GroupData;
import ua.javatests.adressbookweb.model.UserData;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

public class BaseTest {

    protected final ApplicationManager applic = new ApplicationManager(BrowserType.CHROME);

    @AfterMethod
    public void tearDown() {
        applic.stopDriver();
    }

    @BeforeClass
    public void setUp() throws Exception {
        applic.init();
    }

//    @BeforeMethod
//    public void prepareGroup(){
//        applic.getNavigationHelper().groupsLink();
//        applic.getGroupHelper().prepareGroupListIfEmpty(new GroupData("group 1", null, null));
//    }
}
