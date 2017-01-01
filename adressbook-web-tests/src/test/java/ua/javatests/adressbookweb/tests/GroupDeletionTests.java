package ua.javatests.adressbookweb.tests;

import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

public class GroupDeletionTests extends BaseTest{

    @Test
    public void testGroupDeletion() {
        applic.getGroupHelper().prepareGroupListIfEmpty(new GroupData("group for empty list", "header", "footer"));
        applic.getGroupHelper().selectFirstGroupInList();
        applic.getGroupHelper().deleteFirstGroupInList();
        applic.getNavigationHelper().returnGroupPageLink();
    }
}
