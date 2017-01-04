package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

public class GroupCreationTests extends BaseTest {

    @Test
    public void testGroupCreation() {
        applic.getNavigationHelper().groupsLink();
        int groupsBefore = applic.getGroupHelper().getGroupsCounter();

        applic.getGroupHelper().initGroupCreation();
        applic.getGroupHelper().fillNewGroupParameters(new GroupData("group 2", null, null));
        applic.getGroupHelper().submitNewGroup();
        applic.getNavigationHelper().returnGroupPageLink();

        int groupsAfter = applic.getGroupHelper().getGroupsCounter();
        Assert.assertEquals(groupsAfter, groupsBefore + 1);
    }

    @Test
    public void loopGroupCreation() {
        for (int i = 0; i<9 ;i++){
            testGroupCreation();
        }
    }

}
