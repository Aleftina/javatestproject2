package ua.javatests.adressbookweb.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;
import ua.javatests.adressbookweb.model.UserData;

import java.util.List;


public class UserDeletionTests extends BaseTest {

    @Test(enabled = false)
    public void testUserDelete() {
        //prepare group, if empty
        applic.getNavigationHelper().groupsLink();
        applic.getGroupHelper().prepareGroupListIfEmpty(new GroupData("group 1", "preparation", null));
        //prepare contact, if empty
        applic.getNavigationHelper().homePageLink();
        applic.getContactHelper().prepareUserListIfEmpty(new UserData("lastname", "name", "97654321", "asd@dfg", "group 1"));
        List<UserData> listBefore = applic.getContactHelper().getUserList();
        //delete contact
        applic.getContactHelper().deleteUser(listBefore.size() - 1);
        applic.getNavigationHelper().homePageLink();
        //check lists and their sizes
        List<UserData> listAfter = applic.getContactHelper().getUserList();
        Assert.assertEquals(listBefore.size(), listAfter.size() + 1);

        UserData deletedUser = listBefore.get(listBefore.size() - 1);
        listAfter.add(deletedUser);
        Assert.assertEquals(listBefore, listAfter);

    }

    @Test
    public void testDeleteAll() {
        applic.getNavigationHelper().homePageLink();
        applic.getContactHelper().selectAll();
        applic.getContactHelper().submitUserDelete();
        applic.getContactHelper().alertAcceptDelete();
    }
}
