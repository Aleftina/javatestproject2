package ua.javatests.adressbookweb.tests;

import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

public class GroupCreationTests extends BaseTest {

    @Test
    public void testGroupCreation() {
        applic.getNavigationHelper().groupsLink();
        applic.getGroupHelper().initGroupCreation();
        applic.getGroupHelper().fillNewGroupParameters(new GroupData("group 1", null, null));
        applic.getGroupHelper().submitNewGroup();
        applic.getNavigationHelper().returnGroupPageLink();
    }
}
