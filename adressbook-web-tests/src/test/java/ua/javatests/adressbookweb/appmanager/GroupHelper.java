package ua.javatests.adressbookweb.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ua.javatests.adressbookweb.model.GroupData;

import java.util.ArrayList;
import java.util.List;


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

    public void deleteGroup(int index) {
        selectGroup(index);
        click(By.name("delete"));
        returnGroupPageLink();
    }

    public void prepareGroupListIfEmpty(GroupData groupData) {
        if (checkGroupsListNotEmpty() == false) {
            createGroup(groupData);
        }
    }

    public void selectGroup(int index) {
        List<WebElement> list = wd.findElements(By.name("selected[]"));

        if (checkGroupsListNotEmpty() == true) {
            if (! list.get(index).isSelected()) {
                //click(By.name("selected[]"));
                list.get(index).click();
            }
            else {
                Assert.assertTrue(wd.findElement(By.name("selected[]")).isSelected());
                System.out.println("group is already selected");
            }
        }
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

    public int getGroupsCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> getGroupList() {
        List<GroupData> list = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element: elements){
            String groupName = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData(id, groupName, null, null);
            list.add(group);
        }
        return list;
    }
}
