package ua.javatests.adressbookweb.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupDeletionTests extends BaseTest{

    @Test
    public void testGroupDeletion() {
        applic.getNavigationHelper().groupsLink();
        applic.getGroupHelper().prepareGroupListIfEmpty(new GroupData("group for empty list", "header", "footer"));
        List<GroupData> beforeGroups = applic.getGroupHelper().getGroupList();

        applic.getGroupHelper().selectGroup(0);
        applic.getGroupHelper().submitDeleteGroup();
        applic.getNavigationHelper().returnGroupPageLink();

        List<GroupData> afterGroups = applic.getGroupHelper().getGroupList();
        Assert.assertEquals(beforeGroups.size(), afterGroups.size() + 1);
    }
}
