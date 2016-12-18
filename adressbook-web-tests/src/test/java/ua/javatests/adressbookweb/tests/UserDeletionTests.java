package ua.javatests.adressbookweb.tests;


import org.testng.annotations.Test;


public class UserDeletionTests extends BaseTest {

    @Test
    public void testUserDelete() {
        //delete user by id
        applic.getNavigationHelper().homePageLink();
        applic.getContactHelper().selectUserById("63");
        applic.getContactHelper().submitUserDelete();
        applic.getContactHelper().alertAcceptDelete();
        applic.getNavigationHelper().homePageLink();
    }
}
