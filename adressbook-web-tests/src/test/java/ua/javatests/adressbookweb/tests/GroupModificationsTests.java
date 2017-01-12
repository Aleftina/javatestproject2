package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

<<<<<<< HEAD
import java.util.Comparator;
import java.util.List;
=======
import java.util.List;

>>>>>>> eb148fa7caa377cac49cc675d246623161a24879


public class GroupModificationsTests extends BaseTest {

    @Test
    public void testsGroupModification() {
        applic.getNavigationHelper().groupsLink();
<<<<<<< HEAD
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
=======
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
>>>>>>> eb148fa7caa377cac49cc675d246623161a24879
}
