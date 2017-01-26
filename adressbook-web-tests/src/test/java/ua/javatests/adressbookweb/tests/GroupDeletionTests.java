package ua.javatests.adressbookweb.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

import java.util.Set;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertEquals;

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
        assertEquals(listBefore.size(), listAfter.size() + 1);

        listBefore.remove(deletedGroup);
        assertEquals(listBefore, listAfter);
    }
}
