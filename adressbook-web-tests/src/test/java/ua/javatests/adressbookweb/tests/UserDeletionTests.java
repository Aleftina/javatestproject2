package ua.javatests.adressbookweb.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.Contacts;
import ua.javatests.adressbookweb.model.GroupData;
import ua.javatests.adressbookweb.model.UserData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;


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
        Contacts listBefore = applic.contact().all();
        UserData deletedUser = listBefore.iterator().next();

        applic.contact().delete(deletedUser);
        applic.goTo().homePage();
        //check lists and their sizes
        Contacts listAfter = applic.contact().all();
        assertEquals(listBefore.size(), listAfter.size() + 1);

        //listBefore.remove(deletedUser);
        //listAfter.add(deletedUser);
        assertThat(listBefore, equalTo(listAfter.withAdded(deletedUser)));
    }

    @Test
    public void testDeleteAll() {
        applic.goTo().homePage();
        applic.contact().selectAll();
        applic.contact().submitDelete();
        applic.contact().alertAcceptDelete();
    }
}
