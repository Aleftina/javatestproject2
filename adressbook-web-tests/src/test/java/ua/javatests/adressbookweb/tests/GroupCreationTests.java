package ua.javatests.adressbookweb.tests;

import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

public class GroupCreationTests extends BaseTest {

    @Test
    public void testGroupCreation() {
        applic.getNavigationHelper().groupsLink();
        applic.getGroupHelper().createGroup(new GroupData("group 1", null, null));
    }

    @Test
    public void loopGroupCreation() {
        for (int i = 0; i < 9; i++) {
            testGroupCreation();
        }
    }

}
