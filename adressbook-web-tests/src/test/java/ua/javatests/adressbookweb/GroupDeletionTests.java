package ua.javatests.adressbookweb;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeletionTests extends BaseTest{

    @Test
    public void testGroupDeletion() {
        if (!wd.findElement(By.name("selected[]")).isSelected()) {
            wd.findElement(By.name("selected[]")).click();
        }
        wd.findElement(By.name("delete")).click();
        goGroupPageLink();
    }

}
