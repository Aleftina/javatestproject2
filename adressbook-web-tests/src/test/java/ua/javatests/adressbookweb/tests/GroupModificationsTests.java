package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

import java.util.Set;


public class GroupModificationsTests extends BaseTest {

    @BeforeMethod
    public void checkPreconditions() {
        applic.goTo().groupsPage();
        applic.group().prepareGroupList(new GroupData()
                .withGroupName("group 1").withHeader("header").withFooter("footer"));
    }

    @Test
    public void testsGroupModification() {
        Set<GroupData> listBefore = applic.group().all();
        GroupData modifiedGroup = listBefore.iterator().next();

        GroupData group = new GroupData().withId(modifiedGroup.getId())
                .withGroupName("group modified").withHeader("header modified").withFooter("footer modified");

        applic.group().modify(group);

        Set<GroupData> listAfter = applic.group().all();
        Assert.assertEquals(listBefore.size(), listAfter.size());

        listBefore.remove(modifiedGroup);
        listBefore.add(group);

        Assert.assertEquals(listBefore, listAfter);
    }
}
