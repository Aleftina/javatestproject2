package ua.javatests.adressbookweb.appmanager;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.javatests.adressbookweb.model.UserData;

public class ContactHelper extends BaseHelper {

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void fillUserParameters(UserData userData) {
        type(By.name("firstname"), userData.getFirstName());
        type(By.name("lastname"), userData.getLastName());
        type(By.name("mobile"), userData.getMobile());
        type(By.name("email"), userData.getEmail());
    }

    public void submitNewUser() {
        click(By.name("submit"));
    }

    public void submitUserDelete() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
        alertAcceptDelete();
    }

    public void alertAcceptDelete() {
        Alert a = new WebDriverWait(wd, 20).until(ExpectedConditions.alertIsPresent());
        if (a != null) {
            System.out.println("alert is present");
            wd.switchTo().alert().accept();
        }
//          else {
//            try {
//                throw new Throwable();
//            } catch (Throwable throwable) {
//                throwable.printStackTrace();
//            }
//        }
//        {

    }

    public void selectUserById(String id) {
        if (!wd.findElement(By.id(id)).isSelected()) {
          click(By.id(id));
        }
    }

    public void editFirstUserInListIfNotAdmin() {
        if (checkFirstItemIsAdminUser() == false) {
            getEditUserElement(2).click();
        } else getEditUserElement(3).click();
    }

    public WebElement getEditUserElement(final int i) {
        return wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[" + i + "]/td[8]/a/img"));
    }

    public boolean checkFirstItemIsAdminUser() {
        String s = wd.findElement(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[3]")).getText();
        System.out.println("s=" + s);
        if (s.equals("admin"))
            return true;
        else return false;
    }

    public void submitUserUpdate() {
        wd.findElement(By.name("update")).click();
    }
}


