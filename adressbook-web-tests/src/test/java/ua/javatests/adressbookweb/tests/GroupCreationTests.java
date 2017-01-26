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

        assertThat(listBefore.size() + 1, equalTo(applic.group().count()));
        Groups listAfter = applic.group().all();

        assertThat(listAfter, equalTo(listBefore
                .withAdded(group.withId(listAfter.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }

    @Test
    public void testBadGroupCreation() {
        applic.goTo().groupsPage();
        Groups listBefore = applic.group().all();

        GroupData group = new GroupData().withGroupName("group 1'");
        applic.group().create(group);

        assertThat(listBefore.size(), equalTo(applic.group().count()));
        Groups listAfter = applic.group().all();

        assertThat(listAfter, equalTo(listBefore));
    }


    @Test  //(enabled = false)
    public void loopGroupCreation() {
        for (int i = 0; i < 3; i++) {
            testGroupCreation();
        }
    }

}
