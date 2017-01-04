package ua.javatests.adressbookweb.tests;


import org.testng.Assert;
import org.testng.annotations.Test;


public class UserDeletionTests extends BaseTest {

    @Test
    public void testUserDelete() {
        applic.getNavigationHelper().homePageLink();
        //create user if empty list
        createUserIfListIsEmpty();
        int usersBefore = applic.getContactHelper().usersCounter();
        System.out.println("Users before" + usersBefore);
        //user delete test
        applic.getNavigationHelper().homePageLink();
        applic.getContactHelper().selectUser(1);
        applic.getContactHelper().submitUserDelete();
        applic.getContactHelper().alertAcceptDelete();
        applic.getNavigationHelper().homePageLink();
        int usersAfter = applic.getContactHelper().usersCounter();
        System.out.println("Users after" + usersAfter);
        Assert.assertEquals(usersAfter, usersBefore + 1);
    }

    @Test
    public void testDeleteAll(){
        applic.getNavigationHelper().homePageLink();
        applic.getContactHelper().selectAll();
        applic.getContactHelper().submitUserDelete();
        applic.getContactHelper().alertAcceptDelete();
    }
}
