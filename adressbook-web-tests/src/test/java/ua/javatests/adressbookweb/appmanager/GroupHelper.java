package ua.javatests.adressbookweb.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
<<<<<<< HEAD
=======
import org.openqa.selenium.firefox.FirefoxDriver;
>>>>>>> eb148fa7caa377cac49cc675d246623161a24879
import org.testng.Assert;
import ua.javatests.adressbookweb.model.GroupData;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD

=======
>>>>>>> eb148fa7caa377cac49cc675d246623161a24879


public class GroupHelper extends BaseHelper {

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

<<<<<<< HEAD
    public void deleteGroup(int index) {
        selectGroup(index);
        click(By.name("delete"));
        returnGroupPageLink();
    }

    public void prepareGroupListIfEmpty(GroupData groupData) {
        if (checkGroupsListNotEmpty() == false) {
            createGroup(groupData);
=======
    public void submitDeleteGroup() {
        wd.findElement(By.name("delete")).click();
    }

    public void prepareGroupListIfEmpty(GroupData groupData) {
        if (groupsListNotEmpty() == false) {
            initGroupCreation();
            fillNewGroupParameters(groupData);
            submitNewGroup();
>>>>>>> eb148fa7caa377cac49cc675d246623161a24879
        }
    }

    public void selectGroup(int index) {
<<<<<<< HEAD
        List<WebElement> list = wd.findElements(By.name("selected[]"));

        if (checkGroupsListNotEmpty() == true) {
            if (! list.get(index).isSelected()) {
                //click(By.name("selected[]"));
                list.get(index).click();
            }
            else {
=======
        if (groupsListNotEmpty() == true) {
            List<WebElement> groupsList = wd.findElements(By.name("selected[]"));

            if (!groupsList.get(index).isSelected()) {
                groupsList.get(index).click();
            } else {
>>>>>>> eb148fa7caa377cac49cc675d246623161a24879
                Assert.assertTrue(wd.findElement(By.name("selected[]")).isSelected());
                System.out.println("group is already selected");
            }
        }
    }

    public Boolean groupsListNotEmpty() {
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

<<<<<<< HEAD
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
=======
    public int getGroupsCounter() {
>>>>>>> eb148fa7caa377cac49cc675d246623161a24879
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> getGroupList() {
<<<<<<< HEAD
        List<GroupData> list = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element: elements){
            String groupName = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData(id, groupName, null, null);
            list.add(group);
        }
        return list;
=======
        List<GroupData> groups = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element: elements) {
            String name = element.getText();
            GroupData group = new GroupData(name, null, null);
            groups.add(group);
        }
        return groups;
>>>>>>> eb148fa7caa377cac49cc675d246623161a24879
    }
}
