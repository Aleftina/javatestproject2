package ua.javatests.adressbookweb.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;
import ua.javatests.adressbookweb.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertEquals;

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
        assertThat(listBefore.size(), equalTo(applic.group().count() + 1));

        Groups listAfter = applic.group().all();
        assertThat(listBefore.without(deletedGroup), equalTo(listAfter));
    }
}
