package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.UserData;

import java.util.List;

public class UserCreationTests extends BaseTest {

    @Test
    public void testUserCreation() {
        applic.getNavigationHelper().homePageLink();
        List<UserData> usersBefore = applic.getContactHelper().getUsersList();

        applic.getNavigationHelper().addNewUserLink();
        applic.getContactHelper().fillUserParameters(new UserData("Oleg", "Petrov", "123254485", "asda@sadfsdl.ghj", "group for empty list"), true);
        applic.getContactHelper().submitNewUser();
        applic.getNavigationHelper().homePageLink();

        List<UserData> usersAfter = applic.getContactHelper().getUsersList();
        Assert.assertEquals(usersAfter.size(), usersBefore.size() + 1);
    }

    @Test
    public void loopCreation() {
        for (int i = 0; i < 10; i++) {
            testUserCreation();
        }

    }
}
