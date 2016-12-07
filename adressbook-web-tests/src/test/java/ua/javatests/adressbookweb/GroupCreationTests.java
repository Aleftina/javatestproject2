package ua.javatests.adressbookweb;

import org.testng.annotations.Test;

public class GroupCreationTests extends BaseTest {

    @Test
    public void testGroupCreation() {
        applic.clickGroupLink();
        applic.initGroupCreation();
        applic.fillNewGroupParameters(new GroupData("group 1", "header", "footer"));
        applic.submitNewGroup();
        applic.goGroupPageLink();
    }
}
