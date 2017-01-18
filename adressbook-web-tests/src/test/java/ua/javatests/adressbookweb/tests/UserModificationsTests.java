package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;
import ua.javatests.adressbookweb.model.UserData;

import java.util.List;
import java.util.Set;


public class UserModificationsTests extends BaseTest {

    @BeforeMethod
    public void checkPreconditions() {
        //prepare group, if empty
        applic.goTo().groupsPage();
        applic.group().prepareGroupList(new GroupData().withGroupName("group 1").withHeader("preparation"));
        //prepare contact, if empty
        applic.goTo().homePage();
        applic.contact().prepareUserList(new UserData().withLastName("last name").withName("name")
                .withMobile("98765432").withEmail("sadasd@fsd.fsd").withGroup("group 1"));
        applic.goTo().homePage();
    }

    @Test(enabled = false)
    public void testUserInfoUpdate() {

        List<UserData> beforeList = applic.contact().list();
        UserData user = new UserData().withId(beforeList.get(beforeList.size()-1).getId())
                .withLastName("Petrov modified").withName("Oleg modified")
                .withMobile("0987654321").withEmail("zxcv@klkl.opop");
        applic.contact().modifyUser(beforeList.size()-1, user);
        applic.goTo().homePage();
        //check lists and their sizes
        List<UserData> afterList = applic.contact().list();
        beforeList.remove(beforeList.size()-1);
        beforeList.add(user);
        Assert.assertEquals(beforeList, afterList);
    }


}

