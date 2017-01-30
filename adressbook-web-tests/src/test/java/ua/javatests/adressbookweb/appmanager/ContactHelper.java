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
        type(By.name("mobile"), userData.getMobilePhone());
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
        //wd.findElement(By.cssSelector("a[href*='edit.php?id=" + i + "']")).click();
        wd.findElement(By.cssSelector(String.format("a[href*='edit.php?id=%s']",i))).click();
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
        //select(userData);
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
        List<WebElement> rows = wd.findElements(By.name("entry"));

      for (WebElement row : rows) {
          List<WebElement> cells = row.findElements(By.tagName("td"));
          int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
          String lastName = cells.get(1).getText();
          String name = cells.get(2).getText();
         // String address = cells.get(3).getText();
          String email = cells.get(4).getText();
          String[] phones =  cells.get(5).getText().split("\n");
          System.out.println("length = "+phones.length);
//          for (String str : phones) {
//              System.out.println("phone = " + str); //+" "+phones[1]+" "+phones[2]+" ");
//          }
          //-----old implement-n, by x-path
          //for (int j = 0; j < rows.size(); j++) {
            //int i = j + 2;
            //String lastName = String.valueOf(wd.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[" + i + "]/td[2]")).getText());
            //String name = String.valueOf(wd.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[" + i + "]/td[3]")).getText());
            //int id = Integer.parseInt(rows.get(j).findElement(By.tagName("input")).getAttribute("id"));
            //String allPhones = elements.get(j)
          //-------------
            contactsCache.add(new UserData().withId(id).withLastName(lastName).withName(name).withEmail(email)
                    .withHomePhone(phones[0])
                    .withMobilePhone(phones[1])
                    .withWorkPhone(phones[2]));
        }
        return new Contacts(contactsCache);
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }


    public UserData infoFromEditForm(UserData contact) {
        edit(contact);

        String name = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        wd.navigate().back();
        return new UserData().withId(contact.getId()).withLastName(lastname)
                .withName(name).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withEmail(email);
    }
}