package ua.javatests.adressbookweb.tests;

import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;
import ua.javatests.adressbookweb.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends BaseTest {


    @Test
    public void testGroupCreation() {
        applic.goTo().groupsPage();
        Groups listBefore = applic.group().all();

        GroupData group = new GroupData().withGroupName("group 1");
        applic.group().create(group);

        Groups listAfter = applic.group().all();
        assertThat(listBefore.size() + 1, equalTo(listAfter.size()));

        assertThat(listAfter, equalTo(listBefore
                .withAdded(group.withId(listAfter.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }
    
    @Test  //(enabled = false)
    public void loopGroupCreation() {
        for (int i = 0; i < 3; i++) {
            testGroupCreation();
        }
    }

}
