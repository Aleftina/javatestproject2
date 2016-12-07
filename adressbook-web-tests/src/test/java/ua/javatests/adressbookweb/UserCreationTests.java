package ua.javatests.adressbookweb;

import org.openqa.selenium.By;

import org.testng.annotations.Test;



public class UserCreationTests extends BaseTest{

    @Test
    public void testUserCreation() {

        clickNewUser();
        fillUserParameters(new UserData("Oleg", "Petrov", "123254485", "asda@sadfsdl"));
//        wd.findElement(By.name("firstname")).click();
//        wd.findElement(By.name("firstname")).clear();
//        wd.findElement(By.name("firstname")).sendKeys("Olya");
//        wd.findElement(By.name("lastname")).click();
//        wd.findElement(By.name("lastname")).clear();
//        wd.findElement(By.name("lastname")).sendKeys("Shemelina");
//        wd.findElement(By.name("mobile")).click();
//        wd.findElement(By.name("mobile")).clear();
//        wd.findElement(By.name("mobile")).sendKeys("09709876543");
//        wd.findElement(By.name("email")).click();
//        wd.findElement(By.name("email")).clear();
//        wd.findElement(By.name("email")).sendKeys("qwe@sdfsd.df");
      //  wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
        submitNewUser();
        goHomeLink();
    }
}
