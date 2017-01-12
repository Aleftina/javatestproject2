package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

<<<<<<< HEAD
import java.util.Comparator;
=======
>>>>>>> eb148fa7caa377cac49cc675d246623161a24879
import java.util.List;

public class GroupCreationTests extends BaseTest {

    @Test
    public void testGroupCreation() {
        applic.getNavigationHelper().groupsLink();
<<<<<<< HEAD
        List<GroupData> listBefore = applic.getGroupHelper().getGroupList();
=======
        List<GroupData> groupsBefore = applic.getGroupHelper().getGroupList();

        applic.getGroupHelper().initGroupCreation();
        applic.getGroupHelper().fillNewGroupParameters(new GroupData("group 3", null, null));
        applic.getGroupHelper().submitNewGroup();
        applic.getNavigationHelper().returnGroupPageLink();

        List<GroupData> groupsAfter = applic.getGroupHelper().getGroupList();
        Assert.assertEquals(groupsAfter.size(), groupsBefore.size() + 1);
    }
>>>>>>> eb148fa7caa377cac49cc675d246623161a24879

        GroupData group = new GroupData("group 1", null, null);
        applic.getGroupHelper().createGroup(group);

        List<GroupData> listAfter = applic.getGroupHelper().getGroupList();
        Assert.assertEquals(listBefore.size() + 1, listAfter.size());

        listBefore.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        listBefore.sort(byId);
        listAfter.sort(byId);
        Assert.assertEquals(listBefore, listAfter);

    }
    
    @Test(enabled = false)
    public void loopGroupCreation() {
        for (int i = 0; i < 9; i++) {
            testGroupCreation();
        }
    }

}
