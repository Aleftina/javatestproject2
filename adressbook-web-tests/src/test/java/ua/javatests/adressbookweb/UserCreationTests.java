package ua.javatests.adressbookweb;

import org.testng.annotations.Test;

public class UserCreationTests extends BaseTest{

    @Test
    public void testUserCreation() {
        applic.clickNewUser();
        applic.fillUserParameters(new UserData("Oleg", "Petrov", "123254485", "asda@sadfsdl"));
        applic.submitNewUser();
        applic.goHomeLink();
    }
}
