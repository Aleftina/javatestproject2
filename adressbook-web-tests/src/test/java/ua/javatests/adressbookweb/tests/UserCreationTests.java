package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;
import ua.javatests.adressbookweb.model.UserData;

import java.util.HashSet;
import java.util.List;

public class UserCreationTests extends BaseTest {

    @BeforeMethod
    @Test
    public void checkPrecondition() {
        applic.goTo().groupsPage();
        applic.group().prepareGroupList(new GroupData().withGroupName("group 1").withHeader("preparation"));
        applic.goTo().homePage();
    }


    @Test
    public void testUserCreation() {
        List<UserData> listBefore = applic.contact().list();
        UserData user = new UserData().withLastName("Pupkin")
                .withName("Vasya").withMobile("123254485").withEmail("asda@sadfsdl.ghj").withGroup("group 1");
        applic.contact().create(user);
        //check lists and sizes
        List<UserData> listAfter = applic.contact().list();
        Assert.assertEquals(listBefore.size() + 1, listAfter.size());

        user.withId( listAfter.stream().max((us1, us2) -> Integer.compare(us1.getId(), us2.getId())).get().getId());
        listBefore.add(user);
        Assert.assertEquals(new HashSet<>(listBefore), new HashSet<>(listAfter));
    }

    @Test(enabled=false)
    public void loopCreation() {
        for (int i = 0; i < 10; i++) {
            testUserCreation();
        }
    }
}
