package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

public class GroupDeletionTests extends BaseTest{

    @Test
    public void testGroupDeletion() {
        applic.getGroupHelper().prepareGroupListIfEmpty(new GroupData("group for empty list", "header", "footer"));
        int beforeGroups = applic.getGroupHelper().getGroupsCounter();

        applic.getGroupHelper().selectFirstGroupInList();
        applic.getGroupHelper().deleteFirstGroupInList();
        applic.getNavigationHelper().returnGroupPageLink();

        int afterGroups = applic.getGroupHelper().getGroupsCounter();
        Assert.assertEquals(beforeGroups, afterGroups+1);
    }
}
