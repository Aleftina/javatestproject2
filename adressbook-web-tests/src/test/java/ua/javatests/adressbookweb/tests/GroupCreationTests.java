package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends BaseTest {

    @Test
    public void testGroupCreation() {
        applic.getNavigationHelper().groupsLink();
        List<GroupData> listBefore = applic.getGroupHelper().getGroupList();

        GroupData group = new GroupData("group 0", null, null);

        applic.getGroupHelper().createGroup(group);

        List<GroupData> listAfter = applic.getGroupHelper().getGroupList();
        Assert.assertEquals(listBefore.size()+1, listAfter.size());

        group.setId(listAfter.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        listBefore.add(group);
        Assert.assertEquals(new HashSet<>(listBefore), new HashSet<>(listAfter));

    }


    @Test
    public void loopGroupCreation() {
        for (int i = 0; i < 9; i++) {
            testGroupCreation();
        }
    }

}
