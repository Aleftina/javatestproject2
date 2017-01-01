package ua.javatests.adressbookweb.tests;

import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;


public class GroupModificationsTests extends BaseTest{

    @Test
    public void testsGroupModification(){
        applic.getNavigationHelper().groupsLink();
        applic.getGroupHelper().prepareGroupListIfEmpty(new GroupData("group for modification", "header", "footer"));
        applic.getGroupHelper().selectFirstGroupInList();
        applic.getGroupHelper().initGroupModification();
        applic.getGroupHelper().fillNewGroupParameters(new GroupData("group modified", "header modified", "footer modified"));
        applic.getGroupHelper().submitGroupModification();
        applic.getNavigationHelper().returnGroupPageLink();
}
}
