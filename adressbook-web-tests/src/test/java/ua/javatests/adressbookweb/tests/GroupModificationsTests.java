package ua.javatests.adressbookweb.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;
import ua.javatests.adressbookweb.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class GroupModificationsTests extends BaseTest {

    @BeforeMethod
    public void checkPreconditions() {
        applic.goTo().groupsPage();
        applic.group().prepareGroupList(new GroupData()
                .withGroupName("group 1").withHeader("header").withFooter("footer"));
    }

    @Test
    public void testsGroupModification() {
        Groups listBefore = applic.group().all();
        GroupData modifiedGroup = listBefore.iterator().next();

        GroupData group = new GroupData().withId(modifiedGroup.getId())
                .withGroupName("group modified").withHeader("header modified").withFooter("footer modified");

        applic.group().modify(group);

        Groups listAfter = applic.group().all();

        assertEquals(listBefore.size(), listAfter.size());
        assertThat(listBefore.without(modifiedGroup).withAdded(group), equalTo(listAfter));

    }
}
