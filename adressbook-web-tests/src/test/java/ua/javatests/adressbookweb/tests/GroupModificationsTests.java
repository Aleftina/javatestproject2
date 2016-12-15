package ua.javatests.adressbookweb.tests;

import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;


public class GroupModificationsTests extends BaseTest{

    @Test
    public void testsGroupModification(){
        applic.getNavigationHelper().groupsLink();
        applic.getGroupHelper().selectFirstGroupInList();
        applic.getGroupHelper().initGroupModification();
        applic.getGroupHelper().fillNewGroupParameters(new GroupData("new group name", "new header", "new footer"));
        applic.getGroupHelper().submitGroupModification();
        applic.getNavigationHelper().returnGroupPageLink();
}
}
