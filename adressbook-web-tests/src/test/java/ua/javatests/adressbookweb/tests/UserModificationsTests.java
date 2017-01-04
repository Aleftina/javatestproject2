package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.UserData;

import java.util.List;


public class UserModificationsTests extends BaseTest {

    @Test
    public void testUserInfoUpdate() {
        applic.getNavigationHelper().homePageLink();
        createUserIfListIsEmpty();
        List<UserData> usersBefore = applic.getContactHelper().getUsersList();

        applic.getContactHelper().selectUser(1);
        applic.getContactHelper().editUser(1);
        applic.getContactHelper().fillUserParameters(new UserData("Oleg modified", "Petrov modified", "0987654321", "zxcv@klkl.opop", null), false);
        applic.getContactHelper().submitUserUpdate();
        applic.getNavigationHelper().homePageLink();

        List<UserData> usersAfter = applic.getContactHelper().getUsersList();
        Assert.assertEquals(usersAfter, usersBefore);
    }
}

