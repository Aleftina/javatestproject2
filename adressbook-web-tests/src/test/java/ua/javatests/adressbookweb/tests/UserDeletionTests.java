package ua.javatests.adressbookweb.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;
import ua.javatests.adressbookweb.model.UserData;

import java.util.Set;


public class UserDeletionTests extends BaseTest {

    @BeforeMethod
    public void checkPreconditions() {
        applic.goTo().groupsPage();
        applic.group().prepareGroupList(new GroupData()
                .withGroupName("group 1").withHeader("preparation"));

        applic.goTo().homePage();
        applic.contact().prepareUserList(new UserData().withLastName("lastname")
                .withName("name").withMobile("97654321").withEmail("asd@dfg").withGroup("group 1"));
        applic.goTo().homePage();
    }

    @Test
    public void testUserDelete() {
        Set<UserData> listBefore = applic.contact().all();
        UserData deletedUser = listBefore.iterator().next();

        applic.contact().delete(deletedUser);
        applic.goTo().homePage();
        //check lists and their sizes
        Set<UserData> listAfter = applic.contact().all();
        Assert.assertEquals(listBefore.size(), listAfter.size() + 1);

       // listBefore.remove(deletedUser);
        listAfter.add(deletedUser);
        Assert.assertEquals(listBefore, listAfter);
    }

    @Test
    public void testDeleteAll() {
        applic.goTo().homePage();
        applic.contact().selectAll();
        applic.contact().submitDelete();
        applic.contact().alertAcceptDelete();
    }
}
