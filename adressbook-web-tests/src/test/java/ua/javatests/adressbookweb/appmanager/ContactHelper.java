package ua.javatests.adressbookweb.appmanager;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ua.javatests.adressbookweb.model.Contacts;
import ua.javatests.adressbookweb.model.UserData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillUserParameters(UserData userData, Boolean creation) {
        type(By.name("firstname"), userData.getName());
        type(By.name("lastname"), userData.getLastName());
        type(By.name("mobile"), userData.getMobile());
        type(By.name("email"), userData.getEmail());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(userData.getGroup());
        } else Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

    public void submitDelete() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void alertAcceptDelete() {
        Alert a = new WebDriverWait(wd, 2).until(ExpectedConditions.alertIsPresent());
        if (a != null) {
            System.out.println("alert is present");
            wd.switchTo().alert().accept();
        }
    }

    public void selectUserById(int i) {
        i += 2;
        WebElement d = wd.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[" + i + "]/td[1]"));
        if (!d.isSelected()) {
            d.click();
        }
    }

    private void select(UserData user) {
        int i = user.getId();
        WebElement d = wd.findElement(By.cssSelector("input[id='" + i + "']"));
        if (!d.isSelected()) {
            d.click();
        }
    }

    public void editUserById(int i) {
        i += 2;
        wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[" + i + "]/td[8]/a/img")).click();
    }

    public void edit(UserData user) {
        int i = user.getId();
        wd.findElement(By.cssSelector("a[href*='edit.php?id=" + i + "']")).click();
    }

    public void deleteById(int i) {
        selectUserById(i);
        submitDelete();
        alertAcceptDelete();
        contactsCache = null;
    }

    public void delete(UserData user) {
        select(user);
        submitDelete();
        alertAcceptDelete();
        contactsCache = null;
    }

    public void modify(UserData userData) {
        select(userData);
        edit(userData);
        fillUserParameters(userData, false);
        contactsCache = null;
        submitUserUpdate();
    }

    public void create(UserData userData) {
        addNewUserLink();
        fillUserParameters(userData, true);
        submitNewUser();
        contactsCache = null;
        returnHomePage();
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
            System.out.println("selectAll already selected");
        }
    }

    public void prepareUserList(UserData userData) {
        Boolean emptyUserList = userListIsEmpty();
        if (emptyUserList == true) {
            create(userData);
        }
    }

    public void returnHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public List<UserData> list() {
        List<UserData> list = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.name("entry"));

        for (int j = 0; j < elements.size(); j++) {
            int i = j + 2;
            String lastName = String.valueOf(wd.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[" + i + "]/td[2]")).getText());
            String name = String.valueOf(wd.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[" + i + "]/td[3]")).getText());
            int id = Integer.parseInt(elements.get(j).findElement(By.tagName("input")).getAttribute("id"));

            list.add(new UserData().withId(id).withLastName(lastName).withName(name));
        }
        return list;
    }

    private Contacts contactsCache = null;

    public Contacts all() {
        if (contactsCache != null) {
            return new Contacts(contactsCache);
        }
        contactsCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));

        for (int j = 0; j < elements.size(); j++) {
            int i = j + 2;
            String lastName = String.valueOf(wd.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[" + i + "]/td[2]")).getText());
            String name = String.valueOf(wd.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[" + i + "]/td[3]")).getText());
            int id = Integer.parseInt(elements.get(j).findElement(By.tagName("input")).getAttribute("id"));

            contactsCache.add(new UserData().withId(id).withLastName(lastName).withName(name));
        }
        return new Contacts(contactsCache);
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }


}