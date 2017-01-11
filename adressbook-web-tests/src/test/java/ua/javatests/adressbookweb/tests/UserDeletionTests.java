package ua.javatests.adressbookweb.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;
import ua.javatests.adressbookweb.model.UserData;

import java.util.List;


public class UserDeletionTests extends BaseTest {

    @Test
    public void testUserDelete() {
        applic.getNavigationHelper().groupsLink();
        applic.getGroupHelper().prepareGroupListIfEmpty(new GroupData("group 1", "preparation", null));

        applic.getNavigationHelper().homePageLink();
        applic.getContactHelper().prepareUserListIfEmpty(new UserData("first name", "second name", "97654321", "asd@dfg", "group 1"));
        List<UserData> listBefore = applic.getContactHelper().getUserList();

        applic.getContactHelper().deleteUser(listBefore.size()-1);
        applic.getNavigationHelper().homePageLink();

        List<UserData> listAfter = applic.getContactHelper().getUserList();
        Assert.assertEquals(listBefore.size(), listAfter.size()+1);

        listBefore.remove(listBefore.size()-1);
        Assert.assertEquals(listBefore, listAfter);
    }

    @Test
    public void testDeleteAll(){
        applic.getNavigationHelper().homePageLink();
        applic.getContactHelper().selectAll();
        applic.getContactHelper().submitUserDelete();
        applic.getContactHelper().alertAcceptDelete();
    }
}
