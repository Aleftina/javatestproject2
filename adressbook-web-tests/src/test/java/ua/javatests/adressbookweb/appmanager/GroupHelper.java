package ua.javatests.adressbookweb.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ua.javatests.adressbookweb.model.GroupData;


public class GroupHelper extends BaseHelper{

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void submitNewGroup() {
        click(By.name("submit"));
    }

    public void fillNewGroupParameters(GroupData groupData) {
        type(By.name("group_name"), groupData.getGroupName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteFirstGroupInList() {
        selectFirstGroupInList();
        click(By.name("delete"));
        returnGroupPageLink();
    }

    public void prepareGroupListIfEmpty(GroupData groupData) {
        if (checkGroupsListNotEmpty() == false) {
            createGroup(groupData);
        }
    }

    public void selectFirstGroupInList() {
        if (checkGroupsListNotEmpty() == true) {
            if (!wd.findElement(By.name("selected[]")).isSelected()) {
                click(By.name("selected[]"));
            }
            else {
                Assert.assertTrue(wd.findElement(By.name("selected[]")).isSelected());
                System.out.println("group is already selected");
            }
        }
        System.out.println("Groups list is empty");
    }

    public Boolean checkGroupsListNotEmpty() {
        if (!isElementPresent(By.name("selected[]"))) {
            return false;
        }
        return true;
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void createGroup(GroupData groupData) {
        initGroupCreation();
        fillNewGroupParameters(groupData);
        submitNewGroup();
        returnGroupPageLink();
    }

    public void modifyGroup(GroupData groupData) {
        initGroupModification();
        fillNewGroupParameters(groupData);
        submitGroupModification();
        returnGroupPageLink();
    }

    public void returnGroupPageLink() {
        click(By.linkText("group page"));
    }
}
