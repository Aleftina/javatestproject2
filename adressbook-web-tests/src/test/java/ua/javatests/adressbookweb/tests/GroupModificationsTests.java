package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

import java.util.List;


public class GroupModificationsTests extends BaseTest{

    @Test
    public void testsGroupModification(){
        applic.getNavigationHelper().groupsLink();
        applic.getGroupHelper().prepareGroupListIfEmpty(new GroupData("group for modification", "header", "footer"));
        List<GroupData> groupsBefore = applic.getGroupHelper().getGroupList();

        applic.getGroupHelper().selectGroup(1);
        applic.getGroupHelper().initGroupModification();
        applic.getGroupHelper().fillNewGroupParameters(new GroupData("group modified", "header modified", "footer modified"));
        applic.getGroupHelper().submitGroupModification();
        applic.getNavigationHelper().returnGroupPageLink();

        List<GroupData> groupsAfter = applic.getGroupHelper().getGroupList();
        Assert.assertEquals(groupsBefore.size(), groupsAfter.size());
}
}
