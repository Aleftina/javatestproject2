package ua.javatests.adressbookweb.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends BaseTest{

    @Test
    public void testGroupDeletion() {
        applic.getGroupHelper().deleteSelectedGroup();
        applic.getNavigationHelper().groupPageLink();
    }
}
