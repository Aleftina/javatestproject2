package ua.javatests.adressbookweb.appmanager;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ua.javatests.adressbookweb.model.GroupData;
import ua.javatests.adressbookweb.model.UserData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillUserParameters(UserData userData, Boolean creation) {
        type(By.name("firstname"), userData.getFirstName());
        type(By.name("lastname"), userData.getLastName());
        type(By.name("mobile"), userData.getMobile());
        type(By.name("email"), userData.getEmail());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(userData.getGroup());
        } else Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

    public void submitUserDelete() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void alertAcceptDelete() {
        Alert a = new WebDriverWait(wd, 2).until(ExpectedConditions.alertIsPresent());
        if (a != null) {
            System.out.println("alert is present");
            wd.switchTo().alert().accept();
        }
    }

    public void selectUserById(String id) {
        if (isElementPresent(By.id(id))) {
            if (!wd.findElement(By.id(id)).isSelected()) {
                click(By.id(id));
            }
        } else {
            System.out.println("No element with id = " + id);
        }
    }

    public void selectUser(int i) {
        i += 2;
        WebElement d = wd.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[" + i + "]/td[1]"));
        if (!d.isSelected()) {
            d.click();
        }
    }

    public void editUser(int i) {
        i+=2;
        wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[" + i + "]/td[8]/a/img")).click();
    }

    public void deleteUser(int i) {
        selectUser(i);
        submitUserDelete();
        alertAcceptDelete();
    }

    public void modifyUser(int i, UserData userData) {
        selectUser(i);
        editUser(i);
        fillUserParameters(userData, false);
        submitUserUpdate();
    }

    public Boolean userListIsEmpty() {
        //if (! isElementPresent(By.name("#maintable tr[2]"))) {
        if (!isElementPresent(By.xpath(".//*[@id='maintable']/tbody/tr[2]"))) {
            return true;
        } else {
            return false;
        }
    }

    public void submitNewUser() {
        click(By.name("submit"));
    }

    public void submitUserUpdate() {
        click(By.name("update"));
    }

    public void addNewUserLink() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void selectAll() {
        if (isElementPresent(By.id("MassCB"))) {
            if (!wd.findElement(By.id("MassCB")).isSelected()) {
                click(By.id("MassCB"));
            }
            System.out.println("select all already selected");
        }
    }

    public void prepareUserListIfEmpty(UserData userData) {
        Boolean emptyUserList = userListIsEmpty();
        System.out.println(" empty user list = " + emptyUserList);
        if (emptyUserList == true) {
            createUser(userData);
            returnHomePage();
        }
    }


    public void createUser(UserData userData) {
        addNewUserLink();
        fillUserParameters(userData, true);
        submitNewUser();
        returnHomePage();
    }

    public void returnHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public int getUsersCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<UserData> getUserList() {
        List<UserData> list = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String userInfo = element.getText(); //.split(" ");
            List<String> userData = new ArrayList<>();
            System.out.println("String user list = " + userInfo.toString());
            String id = element.findElement(By.tagName("input")).getAttribute("id");

            //for (String userItem: userInfo) {
                //userData.add(userItem);
            //}

            //list.add(new UserData(id, userInfo[1], userInfo[0], null, null, null));
            list.add(new UserData(id, userInfo, null, null, null, null));

                //userData.add(userInfo[i])

        }
        System.out.println("list size = " + elements.size());
        return list;
    }




    public List<GroupData> getGroupList() {
        List<GroupData> list = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element: elements){
            String name = element.getText();
            list.add(new GroupData(name, null, null));
        }
        return list;
    }
}


