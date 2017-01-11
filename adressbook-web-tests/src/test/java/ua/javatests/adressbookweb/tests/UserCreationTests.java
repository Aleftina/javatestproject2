package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;
import ua.javatests.adressbookweb.model.UserData;

import java.util.HashSet;
import java.util.List;

public class UserCreationTests extends BaseTest {

    @Test
    public void testUserCreation() {
        applic.getNavigationHelper().groupsLink();
        applic.getGroupHelper().prepareGroupListIfEmpty(new GroupData("group 1", "preparation", null));

        applic.getNavigationHelper().homePageLink();
        List<UserData> listBefore = applic.getContactHelper().getUserList();


        applic.getContactHelper().createUser(new UserData("Oleg", "Petrov", "123254485", "asda@sadfsdl.ghj", "group 1"));

        List<UserData> listAfter = applic.getContactHelper().getUserList();
        System.out.println("list before size = "+listBefore.size());
        System.out.println("list after size = "+listAfter.size());
        Assert.assertEquals(listBefore.size() + 1, listAfter.size());
        int maxId = 0;
        int posList = 0;
        for (int i =0; i< listBefore.size(); i++){
            System.out.println("listBefore  = "+listBefore.get(i).toString());
            int id = Integer.parseInt(listAfter.get(i).getId());
            if (id > maxId){
                maxId = id;
                posList = i;
            }
        }
        System.out.println("max Id = "+maxId);
        System.out.println("max Id pos in a list  = "+posList);
        for (int i =0; i< listAfter.size(); i++){

            System.out.println("listAfter  = "+listAfter.get(i).toString());
            listAfter.get(i).getId();

        }
        listAfter.remove(posList);
        Assert.assertEquals(new HashSet<>(listBefore), new HashSet<>(listAfter));
    }

    @Test
    public void loopCreation() {
        for (int i = 0; i < 10; i++) {
            testUserCreation();
        }

    }
}
