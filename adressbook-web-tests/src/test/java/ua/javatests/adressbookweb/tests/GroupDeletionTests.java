package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

public class GroupDeletionTests extends BaseTest {

    @Test
    public void testGroupDeletion() {
        applic.getNavigationHelper().groupsLink();
        applic.getGroupHelper().prepareGroupListIfEmpty(new GroupData("group 1", "header", "footer"));
        int sizeBefore = applic.getGroupHelper().getGroupsCount();

        applic.getGroupHelper().deleteGroup(0);

        int sizeAfter = applic.getGroupHelper().getGroupsCount();
        Assert.assertEquals(sizeBefore, sizeAfter+1);
    }
}
