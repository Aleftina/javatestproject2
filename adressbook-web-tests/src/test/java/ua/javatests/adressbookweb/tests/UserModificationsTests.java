package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;
import ua.javatests.adressbookweb.model.UserData;

import java.util.List;


public class UserModificationsTests extends BaseTest {

    @Test
    public void testUserInfoUpdate() {
        applic.getNavigationHelper().groupsLink();
        applic.getGroupHelper().prepareGroupListIfEmpty(new GroupData("group 1", "preparation", null));

        applic.getNavigationHelper().homePageLink();
        applic.getContactHelper().prepareUserListIfEmpty(new UserData("name", "second name", "98765432", "sadasd@fsd.fsd", "group 1"));

        List<UserData> beforeList = applic.getContactHelper().getUserList();
        UserData user = new UserData(beforeList.get(beforeList.size()-1).getId(), "Oleg modified", "Petrov modified", "0987654321", "zxcv@klkl.opop", null);
        applic.getContactHelper().modifyUser(beforeList.size()-1, user);
        applic.getNavigationHelper().homePageLink();

        List<UserData> afterList = applic.getContactHelper().getUserList();

        beforeList.remove(beforeList.size()-1);
        System.out.println("before list after remove "+beforeList);
        beforeList.add(user);

        System.out.println("after list (expected) "+afterList);
        Assert.assertEquals(beforeList, afterList);
    }
}

