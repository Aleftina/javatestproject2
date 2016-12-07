package ua.javatests.adressbookweb.tests;

import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.GroupData;

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
