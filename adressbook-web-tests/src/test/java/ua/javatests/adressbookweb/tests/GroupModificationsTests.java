package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

import java.util.HashSet;
import java.util.List;


public class GroupModificationsTests extends BaseTest {

    @Test
    public void testsGroupModification() {
        applic.getNavigationHelper().groupsLink();
        applic.getGroupHelper().prepareGroupListIfEmpty(new GroupData("group 1", "header", "footer"));

        List<GroupData> listBefore = applic.getGroupHelper().getGroupList();
        int lastElement = listBefore.size()-1;

        applic.getGroupHelper().selectGroup(lastElement);
        GroupData group = new GroupData(listBefore.get(lastElement).getId(), "group modified", "header modified", "footer modified");
        applic.getGroupHelper().modifyGroup(group);

        List<GroupData> listAfter = applic.getGroupHelper().getGroupList();
        Assert.assertEquals(listBefore.size(), listAfter.size());

        listBefore.remove(lastElement);
        listBefore.add(group);
        Assert.assertEquals(new HashSet<Object>(listBefore), new HashSet<Object>(listAfter));
    }
}
