package ua.javatests.adressbookweb.tests;

import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.UserData;

public class UserCreationTests extends BaseTest{

    @Test
    public void testUserCreation() {
        applic.clickNewUser();
        applic.fillUserParameters(new UserData("Oleg", "Petrov", "123254485", "asda@sadfsdl"));
        applic.submitNewUser();
        applic.goHomeLink();
    }
}
