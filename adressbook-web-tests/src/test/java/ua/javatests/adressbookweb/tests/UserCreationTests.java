package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.Contacts;
import ua.javatests.adressbookweb.model.GroupData;
import ua.javatests.adressbookweb.model.UserData;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserCreationTests extends BaseTest {

    @BeforeMethod
    public void checkPrecondition() {
        applic.goTo().groupsPage();
        applic.group().prepareGroupList(new GroupData().withGroupName("group 1").withHeader("preparation"));
        applic.goTo().homePage();
    }

    @Test
    public void testUserCreation() {
        Contacts listBefore = applic.contact().all();

        UserData user = new UserData().withLastName("Pupkin")
                .withName("Vasya").withMobilePhone("123254485").withEmail("asda@sadfsdl.ghj").withGroup("group 1");

        applic.contact().create(user);
        assertThat(listBefore.size() + 1, equalTo(applic.contact().count()));

        Contacts listAfter = applic.contact().all();

        assertThat(listBefore.withAdded(user
                .withId(listAfter.stream().mapToInt((usr) -> usr.getId()).max().getAsInt())), equalTo(listAfter));
    }

    @Test (enabled=false)
    public void loopCreation() {
        for (int i = 0; i < 100; i++) {
            testUserCreation();
        }
    }
}
