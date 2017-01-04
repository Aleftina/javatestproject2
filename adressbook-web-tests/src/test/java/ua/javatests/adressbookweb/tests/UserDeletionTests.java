package ua.javatests.adressbookweb.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.UserData;

import java.util.List;


public class UserDeletionTests extends BaseTest {

    @Test
    public void testUserDelete() {
        applic.getNavigationHelper().homePageLink();
        createUserIfListIsEmpty();
        List<UserData> usersBefore = applic.getContactHelper().getUsersList();

        applic.getContactHelper().selectUser(1);
        applic.getContactHelper().submitUserDelete();
        applic.getContactHelper().alertAcceptDelete();
        applic.getNavigationHelper().homePageLink();

        List<UserData> usersAfter = applic.getContactHelper().getUsersList();
        Assert.assertEquals(usersAfter.size() + 1, usersBefore.size());
    }

    @Test
    public void testDeleteAll() {
        applic.getNavigationHelper().homePageLink();
        applic.getContactHelper().selectAll();
        applic.getContactHelper().submitUserDelete();
        applic.getContactHelper().alertAcceptDelete();
    }
}
