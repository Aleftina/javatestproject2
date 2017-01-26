package ua.javatests.adressbookweb.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

import java.util.Set;

import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends BaseTest {


    @Test
    public void testGroupCreation() {
        applic.goTo().groupsPage();
        Set<GroupData> listBefore = applic.group().all();

        GroupData group = new GroupData().withGroupName("group 1");
        applic.group().create(group);

        Set<GroupData> listAfter = applic.group().all();
        assertEquals(listBefore.size() + 1, listAfter.size());

        group.withId(listAfter.stream().mapToInt((g)->g.getId()).max().getAsInt());
        listBefore.add(group);
        assertEquals(listAfter, listBefore);
    }
    
    @Test  //(enabled = false)
    public void loopGroupCreation() {
        for (int i = 0; i < 3; i++) {
            testGroupCreation();
        }
    }

}
