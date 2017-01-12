package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

import java.util.Comparator;
import java.util.List;


public class GroupModificationsTests extends BaseTest {

    @Test
    public void testsGroupModification() {
        applic.getNavigationHelper().groupsLink();
        applic.getGroupHelper().prepareGroupListIfEmpty(new GroupData("group 1", "header", "footer"));

        List<GroupData> listBefore = applic.getGroupHelper().getGroupList();
        int lastElement = listBefore.size() - 1;

        applic.getGroupHelper().selectGroup(lastElement);
        GroupData group = new GroupData(listBefore.get(lastElement).getId(), "group modified", "header modified", "footer modified");
        applic.getGroupHelper().modifyGroup(group);

        List<GroupData> listAfter = applic.getGroupHelper().getGroupList();
        Assert.assertEquals(listBefore.size(), listAfter.size());

        listBefore.remove(lastElement);
        listBefore.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        listBefore.sort(byId);
        listAfter.sort(byId);
        Assert.assertEquals(listBefore, listAfter);
    }
}
