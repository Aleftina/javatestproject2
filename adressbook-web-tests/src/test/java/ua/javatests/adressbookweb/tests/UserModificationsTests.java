package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.UserData;


public class UserModificationsTests extends BaseTest{

    @Test
    public void testUserInfoUpdate() {
        applic.getNavigationHelper().homePageLink();
        createUserIfListIsEmpty();
        int usersBefore = applic.getContactHelper().usersCounter();

        applic.getContactHelper().editUser(1);
        applic.getContactHelper().fillUserParameters(new UserData("Oleg modified","Petrov modified","0987654321","zxcv@klkl.opop", null), false);
        applic.getContactHelper().submitUserUpdate();
        applic.getNavigationHelper().homePageLink();

        int usersAfter = applic.getContactHelper().usersCounter();
        Assert.assertEquals(usersAfter, usersBefore);


    }
}

