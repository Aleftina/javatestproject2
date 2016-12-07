package ua.javatests.adressbookweb;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeletionTests extends BaseTest{

    @Test
    public void testGroupDeletion() {
        if (!applic.wd.findElement(By.name("selected[]")).isSelected()) {
            applic.wd.findElement(By.name("selected[]")).click();
        }
        applic.wd.findElement(By.name("delete")).click();
        applic.goGroupPageLink();
    }

}
