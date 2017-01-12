package ua.javatests.adressbookweb.tests;

<<<<<<< HEAD
=======
import org.openqa.selenium.WebElement;
>>>>>>> eb148fa7caa377cac49cc675d246623161a24879
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

<<<<<<< HEAD
import java.util.Comparator;
import java.util.List;

public class GroupDeletionTests extends BaseTest {
=======
import java.util.ArrayList;
import java.util.List;

public class GroupDeletionTests extends BaseTest{
>>>>>>> eb148fa7caa377cac49cc675d246623161a24879

    @Test
    public void testGroupDeletion() {
        applic.getNavigationHelper().groupsLink();
<<<<<<< HEAD
        applic.getGroupHelper().prepareGroupListIfEmpty(new GroupData("group 1", "header", "footer"));

        List<GroupData> listBefore = applic.getGroupHelper().getGroupList();
        int index = listBefore.size() - 1;

        applic.getGroupHelper().deleteGroup(index);

        List<GroupData> listAfter = applic.getGroupHelper().getGroupList();
        Assert.assertEquals(listBefore.size(), listAfter.size() + 1);

        listBefore.remove(index);

        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        listBefore.sort(byId);
        listAfter.sort(byId);

        Assert.assertEquals(listBefore, listAfter);

=======
        applic.getGroupHelper().prepareGroupListIfEmpty(new GroupData("group for empty list", "header", "footer"));
        List<GroupData> beforeGroups = applic.getGroupHelper().getGroupList();

        applic.getGroupHelper().selectGroup(0);
        applic.getGroupHelper().submitDeleteGroup();
        applic.getNavigationHelper().returnGroupPageLink();

        List<GroupData> afterGroups = applic.getGroupHelper().getGroupList();
        Assert.assertEquals(beforeGroups.size(), afterGroups.size() + 1);
>>>>>>> eb148fa7caa377cac49cc675d246623161a24879
    }
}
