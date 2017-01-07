package ua.javatests.adressbookweb.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.UserData;


public class UserDeletionTests extends BaseTest {

    @Test
    public void testUserDelete() {
        applic.getNavigationHelper().homePageLink();
        applic.getContactHelper().prepareUserListIfEmpty(new UserData("first name", "second name", "97654321", "asd@dfg", "group 1"));

        int sizeBefore = applic.getContactHelper().getUsersCount();

        applic.getContactHelper().deleteUser(1);
        applic.getNavigationHelper().homePageLink();


        int sizeAfter = applic.getContactHelper().getUsersCount();
        Assert.assertEquals(sizeBefore, sizeAfter+1);
    }

    @Test
    public void testDeleteAll(){
        applic.getNavigationHelper().homePageLink();
        applic.getContactHelper().selectAll();
        applic.getContactHelper().submitUserDelete();
        applic.getContactHelper().alertAcceptDelete();
    }
}
