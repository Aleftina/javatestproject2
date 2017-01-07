package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

public class GroupCreationTests extends BaseTest {

    @Test
    public void testGroupCreation() {
        applic.getNavigationHelper().groupsLink();
        int sizeBefore = applic.getGroupHelper().getGroupsCount();

        applic.getGroupHelper().createGroup(new GroupData("group 1", null, null));

        int sizeAfter = applic.getGroupHelper().getGroupsCount();
        Assert.assertEquals(sizeBefore+1, sizeAfter);

    }

    @Test
    public void loopGroupCreation() {
        for (int i = 0; i < 9; i++) {
            testGroupCreation();
        }
    }

}
