package ua.javatests.adressbookweb.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.Contacts;
import ua.javatests.adressbookweb.model.GroupData;
import ua.javatests.adressbookweb.model.UserData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


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

    @Test
    public void testUserInfoUpdate() {

        Contacts beforeList = applic.contact().all();
        UserData modifiedUser = beforeList.iterator().next();
        UserData user = new UserData().withId(modifiedUser.getId())
                .withLastName("Petrov modified").withName("Oleg modified")
                .withMobile("0987654321").withEmail("zxcv@klkl.opop");

        applic.contact().modify(user);
        applic.goTo().homePage();
        //check lists and their sizes
        Contacts afterList = applic.contact().all();
        assertEquals(beforeList.size(), afterList.size());
        assertThat(beforeList.without(modifiedUser).withAdded(user), equalTo(afterList));
    }


}

