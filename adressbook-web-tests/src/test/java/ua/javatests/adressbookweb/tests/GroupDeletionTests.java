package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

import java.util.Set;

public class GroupDeletionTests extends BaseTest {


    @BeforeMethod
    public void checkPreconditions() {
        applic.goTo().groupsPage();
        applic.group().prepareGroupList(new GroupData()
                .withGroupName("group 1").withHeader("header").withFooter("footer"));
    }

    @Test
    public void testGroupDeletion() {
        Set<GroupData> listBefore = applic.group().all();
        GroupData deletedGroup = listBefore.iterator().next();

        applic.group().delete(deletedGroup);

        Set<GroupData> listAfter = applic.group().all();
        Assert.assertEquals(listBefore.size(), listAfter.size() + 1);

        listBefore.remove(deletedGroup);
        Assert.assertEquals(listBefore, listAfter);
    }
}
