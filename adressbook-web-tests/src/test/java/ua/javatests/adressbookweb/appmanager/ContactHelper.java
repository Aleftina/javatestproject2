package ua.javatests.adressbookweb.appmanager;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

    public void selectUser(int i) {
        i += 2;
        System.out.println("i = "+i);
        WebElement d = wd.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[" + i + "]/td[1]"));
        if (!d.isSelected()) {
            d.click();
        }
    }

    public void editUser(int i) {
        i += 2;
        wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[" + i + "]/td[8]/a/img")).click();
    }

    public void delete(int i) {
        selectUser(i);
        submitDelete();
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
            System.out.println("selectAll already selected");
        }
    }

    public void prepareUserList(UserData userData) {
        Boolean emptyUserList = userListIsEmpty();
        if (emptyUserList == true) {
            create(userData);
        }
    }


    public void create(UserData userData) {
        addNewUserLink();
        fillUserParameters(userData, true);
        submitNewUser();
        returnHomePage();
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
}


