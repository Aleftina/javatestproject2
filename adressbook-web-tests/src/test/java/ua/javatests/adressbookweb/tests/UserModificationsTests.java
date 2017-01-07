package ua.javatests.adressbookweb.tests;

import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.UserData;


public class UserModificationsTests extends BaseTest {

    @Test
    public void testUserInfoUpdate() {
        applic.getNavigationHelper().homePageLink();
        applic.getContactHelper().prepareUserListIfEmpty(new UserData("name", "second name", "98765432", "sadasd@fsd.fsd", "group 1"));
        applic.getContactHelper().modifyUser(1, new UserData("Oleg modified", "Petrov modified", "0987654321", "zxcv@klkl.opop", null));
        applic.getNavigationHelper().homePageLink();
    }
}

