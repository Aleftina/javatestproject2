package ua.javatests.adressbookweb.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ua.javatests.adressbookweb.appmanager.ApplicationManager;
import ua.javatests.adressbookweb.model.UserData;

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

    public void createUserIfListIsEmpty() {
        Boolean emptyUserList = applic.getContactHelper().userListIsEmpty();
        System.out.println(" empty user list = "+emptyUserList);
        if (emptyUserList == true) {
            applic.getNavigationHelper().addNewUserLink();
            applic.getContactHelper().fillUserParameters(new UserData("Name", "LastNamme", "mobile", "email", "group 2"), true );
            applic.getContactHelper().submitNewUser();}
        else {
            System.out.println("user list is not empty");
        }

    }
//
//    public void createUser() {
//        applic.getNavigationHelper().addNewUserLink();
//        applic.getContactHelper().fillUserParameters(new UserData("Oleg", "Petrov", "123254485", "asda@sadfsdl.ghj", "group 1"), true);
//        applic.getContactHelper().submitNewUser();
//    }
}
