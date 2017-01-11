package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends BaseTest {

    @Test
    public void testGroupDeletion() {
        applic.getNavigationHelper().groupsLink();
        applic.getGroupHelper().prepareGroupListIfEmpty(new GroupData("group 1", "header", "footer"));

        List<GroupData> listBefore = applic.getGroupHelper().getGroupList();
        int index = listBefore.size()-1;

        applic.getGroupHelper().deleteGroup(index);

        List<GroupData> listAfter = applic.getGroupHelper().getGroupList();
        Assert.assertEquals(listBefore.size(), listAfter.size()+1);

        listBefore.remove(index);
        Assert.assertEquals(listBefore, listAfter);

    }
}
