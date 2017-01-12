package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;
import ua.javatests.adressbookweb.model.UserData;

import java.util.List;

<<<<<<< HEAD
=======

public class UserModificationsTests extends BaseTest {
>>>>>>> eb148fa7caa377cac49cc675d246623161a24879

public class UserModificationsTests extends BaseTest {

    @Test(enabled = false)
    public void testUserInfoUpdate() {
        //prepare group, if empty
        applic.getNavigationHelper().groupsLink();
        applic.getGroupHelper().prepareGroupListIfEmpty(new GroupData("group 1", "preparation", null));
        //prepare contact, if empty
        applic.getNavigationHelper().homePageLink();
        applic.getContactHelper().prepareUserListIfEmpty(new UserData("name", "second name", "98765432", "sadasd@fsd.fsd", "group 1"));
        //modify contact
        List<UserData> beforeList = applic.getContactHelper().getUserList();
        UserData user = new UserData(beforeList.get(beforeList.size()-1).getId(), "Oleg modified", "Petrov modified", "0987654321", "zxcv@klkl.opop", null);
        applic.getContactHelper().modifyUser(beforeList.size()-1, user);
        applic.getNavigationHelper().homePageLink();
<<<<<<< HEAD
        //check lists and their sizes
        List<UserData> afterList = applic.getContactHelper().getUserList();
        beforeList.remove(beforeList.size()-1);
        beforeList.add(user);
        Assert.assertEquals(beforeList, afterList);
=======
        createUserIfListIsEmpty();
        List<UserData> usersBefore = applic.getContactHelper().getUsersList();

        applic.getContactHelper().selectUser(1);
        applic.getContactHelper().editUser(1);
        applic.getContactHelper().fillUserParameters(new UserData("Oleg modified", "Petrov modified", "0987654321", "zxcv@klkl.opop", null), false);
        applic.getContactHelper().submitUserUpdate();
        applic.getNavigationHelper().homePageLink();

        List<UserData> usersAfter = applic.getContactHelper().getUsersList();
        Assert.assertEquals(usersAfter, usersBefore);
>>>>>>> eb148fa7caa377cac49cc675d246623161a24879
    }
}

