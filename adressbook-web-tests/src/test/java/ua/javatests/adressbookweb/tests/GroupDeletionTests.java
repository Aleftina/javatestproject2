package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupDeletionTests extends BaseTest {


    @BeforeMethod
    public void checkPreconditions() {
        applic.goTo().groupsPage();
        applic.group().prepareGroupList(new GroupData()
                .withGroupName("group 1").withHeader("header").withFooter("footer"));
    }

    @Test
    public void testGroupDeletion() {
        List<GroupData> listBefore = applic.group().list();
        int index = listBefore.size() - 1;

        applic.group().delete(index);

        List<GroupData> listAfter = applic.group().list();
        Assert.assertEquals(listBefore.size(), listAfter.size() + 1);

        listBefore.remove(index);

        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        listBefore.sort(byId);
        listAfter.sort(byId);

        Assert.assertEquals(listBefore, listAfter);
    }
}
