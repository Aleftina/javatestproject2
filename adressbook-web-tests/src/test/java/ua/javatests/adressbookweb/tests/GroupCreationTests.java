package ua.javatests.adressbookweb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

import java.util.Set;

public class GroupCreationTests extends BaseTest {

    @Test
    public void testGroupCreation() {
        applic.goTo().groupsPage();
        Set<GroupData> listBefore = applic.group().all();

        GroupData group = new GroupData().withGroupName("group 1");
        applic.group().create(group);

        Set<GroupData> listAfter = applic.group().all();
        Assert.assertEquals(listBefore.size() + 1, listAfter.size());

        group.withId(listAfter.stream().mapToInt((g)-> g.getId()).max().getAsInt());
        listBefore.add(group);
//        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
//        listBefore.sort(byId);
//        listAfter.sort(byId);
        Assert.assertEquals(listBefore, listAfter);

    }
    
    @Test(enabled=false)
    public void loopGroupCreation() {
        for (int i = 0; i < 9; i++) {
            testGroupCreation();
        }
    }

}
