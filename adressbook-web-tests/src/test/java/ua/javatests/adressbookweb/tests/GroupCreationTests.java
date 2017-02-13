package ua.javatests.adressbookweb.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;
import ua.javatests.adressbookweb.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends BaseTest {


    @DataProvider
    public Iterator<Object[]> validGroups(){
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{new GroupData().withGroupName("group1").withHeader("header1").withFooter("footer1")});
        list.add(new Object[]{new GroupData().withGroupName("group2").withHeader("header2").withFooter(" footer2")});
        list.add(new Object[]{new GroupData().withGroupName("group3").withHeader("header3").withFooter(" footer3")});
        return list.iterator();
     }

    @Test(dataProvider = "validGroups")
    public void testGroupCreation(GroupData group) {
        applic.goTo().groupsPage();
        Groups listBefore = applic.group().all();

        //GroupData group = new GroupData().withGroupName(name).withHeader(header).withFooter(footer);
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


    @Test (enabled = false)
    public void loopGroupCreation() {
        for (int i = 0; i < 3; i++) {
            //testGroupCreation();
        }
    }

}
