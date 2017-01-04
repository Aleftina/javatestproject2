package ua.javatests.adressbookweb.tests;


import org.testng.Assert;
import org.testng.annotations.Test;


public class UserDeletionTests extends BaseTest {

    @Test
    public void testUserDelete() {
        applic.getNavigationHelper().homePageLink();
        createUserIfListIsEmpty();
        int usersBefore = applic.getContactHelper().usersCounter();

        applic.getContactHelper().selectUser(1);
        applic.getContactHelper().submitUserDelete();
        applic.getContactHelper().alertAcceptDelete();
        applic.getNavigationHelper().homePageLink();

        int usersAfter = applic.getContactHelper().usersCounter();
        Assert.assertEquals(usersAfter+1, usersBefore);
    }

    @Test
    public void testDeleteAll(){
        applic.getNavigationHelper().homePageLink();
        applic.getContactHelper().selectAll();
        applic.getContactHelper().submitUserDelete();
        applic.getContactHelper().alertAcceptDelete();
    }
}
