package ua.javatests.adressbookweb.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ua.javatests.adressbookweb.model.GroupData;


public class GroupHelper extends BaseHelper{

    public GroupHelper(FirefoxDriver wd) {
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

    public void deleteSelectedGroup() {
        if (!wd.findElement(By.name("selected[]")).isSelected()) {
            click(By.name("selected[]"));
        }
        click(By.name("delete"));
    }
}
