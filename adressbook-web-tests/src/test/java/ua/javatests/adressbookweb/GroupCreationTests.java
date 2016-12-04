package ua.javatests.adressbookweb;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class GroupCreationTests {
    FirefoxDriver wd;

    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        openURL();
        loginAddressbook("admin", "secret");
    }

    @Test
    public void testGroupCreation() {
        clickGroupLink();
        initGroupCreation();
        fillNewGroupParameters(new GroupData("group 1", "header","footer"));
        submitNewGroup();
        goGroupPageLink();
    }
    @Test
    public void userCreation(){
        clickNewUser();
        fillUserParameters(new UserData("Oleg", "Petrov", "123254485", "asda@m..l"));
        submitNewUser();
        goHomeLink();

    }


    public void clickNewUser() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void fillUserParameters(UserData userData) {
        wd.findElementByName("firstname").sendKeys(userData.getFirstName());
        wd.findElementByName("lastname").sendKeys(userData.getLastName());
        wd.findElementByName("mobile").sendKeys(userData.getMobile());
        wd.findElementByName("email").sendKeys(userData.getEmail());
    }

    public void goHomeLink() {
        wd.findElementByLinkText("home").click();
    }

    public void submitNewUser() {
        wd.findElementByName("submit").click();
    }

    public void openURL(){
        wd.get("http://localhost/addressbook/group.php");
    }

    public void loginAddressbook(String username, String password){
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
}
    public void goGroupPageLink(){
        wd.findElement(By.linkText("group page")).click();
    }


    public void submitNewGroup() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillNewGroupParameters(GroupData groupData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getGroupName());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    public void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    public void clickGroupLink() {
        wd.findElement(By.linkText("groups")).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
