package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;
import ua.javatests.adressbookweb.model.UserData;

public class UserCreationTests extends BaseTest {

    @Test
    public void testUserCreation() {
        applic.getNavigationHelper().groupsLink();
        applic.getGroupHelper().prepareGroupListIfEmpty(new GroupData("group 1", null, null));

        applic.getNavigationHelper().homePageLink();
        int sizeBefore = applic.getContactHelper().getUsersCount();

        applic.getContactHelper().createUser(new UserData("Oleg", "Petrov", "123254485", "asda@sadfsdl.ghj", "group 1"));

        int sizeAfter = applic.getContactHelper().getUsersCount();
        Assert.assertEquals(sizeBefore + 1, sizeAfter);
    }

    @Test
    public void loopCreation() {
        for (int i = 0; i < 10; i++) {
            testUserCreation();
        }

    }
}
