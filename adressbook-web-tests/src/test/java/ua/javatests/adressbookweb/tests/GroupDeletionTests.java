package ua.javatests.adressbookweb.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends BaseTest{

    @Test
    public void testGroupDeletion() {
        applic.getGroupHelper().selectFirstGroupInList();
        applic.getGroupHelper().deleteFirstGroupInList();
        applic.getNavigationHelper().returnGroupPageLink();
    }
}
