package ua.javatests.adressbookweb.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import ua.javatests.adressbookweb.model.GroupData;

import java.util.ArrayList;
import java.util.List;


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

    public void submitDeleteGroup() {
        wd.findElement(By.name("delete")).click();
    }

    public void prepareGroupListIfEmpty(GroupData groupData) {
        if (groupsListNotEmpty() == false) {
            initGroupCreation();
            fillNewGroupParameters(groupData);
            submitNewGroup();
        }
    }

    public void selectGroup(int index) {
        if (groupsListNotEmpty() == true) {
            List<WebElement> groupsList = wd.findElements(By.name("selected[]"));

            if (!groupsList.get(index).isSelected()) {
                groupsList.get(index).click();
            } else {
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

    public int getGroupsCounter() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> getGroupList() {
        List<GroupData> groups = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element: elements) {
            String name = element.getText();
            GroupData group = new GroupData(name, null, null);
            groups.add(group);
        }
        return groups;
    }
}
