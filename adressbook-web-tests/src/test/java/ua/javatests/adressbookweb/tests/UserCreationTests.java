package ua.javatests.adressbookweb.tests;

import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;
import ua.javatests.adressbookweb.model.UserData;

public class UserCreationTests extends BaseTest {

    @Test
    public void testUserCreation() {
        applic.getNavigationHelper().groupsLink();
        applic.getGroupHelper().prepareGroupListIfEmpty(new GroupData("group 1", null, null));

        applic.getNavigationHelper().homePageLink();
        applic.getContactHelper().createUser(new UserData("Oleg", "Petrov", "123254485", "asda@sadfsdl.ghj", "group 1"));
    }

    @Test
    public void loopCreation() {
        for (int i = 0; i < 10; i++) {
            testUserCreation();
        }

    }
}
