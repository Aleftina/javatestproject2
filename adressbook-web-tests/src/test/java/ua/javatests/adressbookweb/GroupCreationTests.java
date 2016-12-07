package ua.javatests.adressbookweb;

import org.testng.annotations.Test;

public class GroupCreationTests extends BaseTest {

    @Test
    public void testGroupCreation() {
        clickGroupLink();
        initGroupCreation();
        fillNewGroupParameters(new GroupData("group 1", "header", "footer"));
        submitNewGroup();
        goGroupPageLink();
    }
}
