package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

import java.util.List;

public class GroupCreationTests extends BaseTest {

    @Test
    public void testGroupCreation() {
        applic.getNavigationHelper().groupsLink();
        List<GroupData> groupsBefore = applic.getGroupHelper().getGroupList();

        applic.getGroupHelper().initGroupCreation();
        applic.getGroupHelper().fillNewGroupParameters(new GroupData("group 3", null, null));
        applic.getGroupHelper().submitNewGroup();
        applic.getNavigationHelper().returnGroupPageLink();

        List<GroupData> groupsAfter = applic.getGroupHelper().getGroupList();
        Assert.assertEquals(groupsAfter.size(), groupsBefore.size() + 1);
    }

    @Test
    public void loopGroupCreation() {
        for (int i = 0; i<9 ;i++){
            testGroupCreation();
        }
    }

}
