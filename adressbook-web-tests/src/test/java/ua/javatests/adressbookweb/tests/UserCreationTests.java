package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;
import ua.javatests.adressbookweb.model.UserData;

import java.util.HashSet;
import java.util.List;

public class UserCreationTests extends BaseTest {

    @Test(enabled=false)
    public void testUserCreation() {
        //prepare group, if empty
        applic.getNavigationHelper().groupsLink();
        applic.getGroupHelper().prepareGroupListIfEmpty(new GroupData("group 1", "preparation", null));
        //create user
        applic.getNavigationHelper().homePageLink();
        List<UserData> listBefore = applic.getContactHelper().getUserList();
        UserData user = new UserData("Pupkin", "Vasya", "123254485", "asda@sadfsdl.ghj", "group 1");
        applic.getContactHelper().createUser(user);
        //check lists and sizes
        List<UserData> listAfter = applic.getContactHelper().getUserList();
        Assert.assertEquals(listBefore.size() + 1, listAfter.size());

        user.setId( listAfter.stream().max((us1, us2) -> Integer.compare(us1.getId(), us2.getId())).get().getId());
        listBefore.add(user);
        Assert.assertEquals(new HashSet<>(listBefore), new HashSet<>(listAfter));
    }

    @Test
    public void loopCreation() {
        for (int i = 0; i < 10; i++) {
            testUserCreation();
        }
    }
}
