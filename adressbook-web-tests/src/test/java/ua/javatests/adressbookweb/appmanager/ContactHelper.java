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

    public void selectUser(int i) {
        i++;
        WebElement d = wd.findElement(By.xpath(".//*[@id='maintable']/tbody/tr["+i+"]/td[1]"));
        if (!d.isSelected()) {
            d.click();
        }
    }

    public void editUser(int i) {
        i++;
        wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[" + i + "]/td[8]/a/img")).click();
    }

    public boolean checkFirstItemIsAdminUser() {
        String s = wd.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[3]")).getText();
        System.out.println("s=" + s);
        if (s.equals("admin"))
            return true;
        else return false;
    }

    public Boolean userListIsEmpty() {
        if (! isElementPresent(By.xpath(".//*[@id='maintable']/tbody/tr[2]"))) {
         return true;
        }
        else {return false;}
    }

    public void submitNewUser() {
        click(By.name("submit"));
    }

    public void submitUserUpdate() {
        click(By.name("update"));
    }

    public void selectAll() {
        if (isElementPresent(By.id("MassCB"))) {
            if (!wd.findElement(By.id("MassCB")).isSelected()) {
                click(By.id("MassCB"));
            }
            System.out.println("select all already selected");
        }
    }

    public void alertAcceptDelete() {
        Alert a = new WebDriverWait(wd, 2).until(ExpectedConditions.alertIsPresent());
        if (a != null) {
            System.out.println("alert is present");
            wd.switchTo().alert().accept();
        }
    }

    public int usersCounter() {
        return wd.findElements(By.name("selected[]")).size();
    }
}