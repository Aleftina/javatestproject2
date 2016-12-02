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
        fillNewGroupParameters();
        submitNewGroup();
        goGroupPageLink();
    }

    public void openURL() {
        wd.get("http://localhost/addressbook/group.php");
    }

    public void loginAddressbook(String username, String password) {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    public void goGroupPageLink() {
        wd.findElement(By.linkText("group page")).click();
    }

    public void submitNewGroup() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillNewGroupParameters() {
        GroupData groupData = new GroupData();
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.groupName);
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.header);
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.footer);
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
}
