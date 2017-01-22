package ua.javatests.adressbookweb.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;
import ua.javatests.adressbookweb.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class GroupDeletionTests extends BaseTest {


    @BeforeMethod
    public void checkPreconditions() {
        applic.goTo().groupsPage();
        applic.group().prepareGroupList(new GroupData()
                .withGroupName("group 1").withHeader("header").withFooter("footer"));
    }

    @Test
    public void testGroupDeletion() {
        Groups listBefore = applic.group().all();
        GroupData deletedGroup = listBefore.iterator().next();

        applic.group().delete(deletedGroup);

        Groups listAfter = applic.group().all();
        assertThat(listBefore.size(), equalTo(listAfter.size() + 1));

        assertThat(listBefore.withOut(deletedGroup), equalTo(listAfter));
    }
}
