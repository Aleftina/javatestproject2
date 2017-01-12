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

<<<<<<< HEAD
    public void alertAcceptDelete() {
        Alert a = new WebDriverWait(wd, 2).until(ExpectedConditions.alertIsPresent());
        if (a != null) {
            System.out.println("alert is present");
            wd.switchTo().alert().accept();
        }
    }

=======
>>>>>>> eb148fa7caa377cac49cc675d246623161a24879
    public void selectUser(int i) {
        i += 2;
        WebElement d = wd.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[" + i + "]/td[1]"));
        if (!d.isSelected()) {
            d.click();
        }
    }

    public void editUser(int i) {
<<<<<<< HEAD
        i += 2;
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
=======
        i++;
        wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[" + i + "]/td[8]/a/img")).click();
    }

    public Boolean userListIsEmpty() {
        if (! isElementPresent(By.xpath(".//*[@id='maintable']/tbody/tr[2]"))) {
         return true;
>>>>>>> eb148fa7caa377cac49cc675d246623161a24879
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
            System.out.println("selectAll already selected");
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

    public void alertAcceptDelete() {
        Alert a = new WebDriverWait(wd, 2).until(ExpectedConditions.alertIsPresent());
        if (a != null) {
            System.out.println("alert is present");
            wd.switchTo().alert().accept();
        }
    }

<<<<<<< HEAD
    public void createUser(UserData userData) {
        addNewUserLink();
        fillUserParameters(userData, true);
        submitNewUser();
        returnHomePage();
    }

    public void returnHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public List<UserData> getUserList() {
        List<UserData> list = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.name("entry"));

        //for (WebElement element : elements) {
        for (int j = 0; j < elements.size(); j++) {
           // String[] userInfo = null;//element.getText().split(" ");
            int i = j+2;
            String lastName = String.valueOf(wd.findElement(By.xpath(".//*[@id='maintable']/tbody/tr["+i+"]/td[2]")).getText());
            String name = String.valueOf(wd.findElement(By.xpath(".//*[@id='maintable']/tbody/tr["+i+"]/td[3]")).getText());
            int id = Integer.parseInt(elements.get(j).findElement(By.tagName("input")).getAttribute("id"));

            list.add(new UserData(id, lastName, name, null, null, null));
        }
        return list;
    }
}

=======
    public int usersCounter() {
        return wd.findElements(By.name("selected[]")).size();
    }
>>>>>>> eb148fa7caa377cac49cc675d246623161a24879

    public List<UserData> getUsersList() {
        List<UserData> usersList = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.name("selected[]"));
        for (WebElement element: elements) {
            String name = element.getText();
            UserData user = new UserData(name, null, null, null, null);
            usersList.add(user);
        }
        return usersList;
    }
}