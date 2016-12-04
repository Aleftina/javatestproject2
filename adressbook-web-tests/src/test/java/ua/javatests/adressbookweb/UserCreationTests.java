package ua.javatests.adressbookweb;

import org.junit.*;

public class UserCreationTests extends BaseTest{

    @Test
    public void testUserCreation() {
        clickNewUser();
        fillUserParameters(new UserData("Oleg", "Petrov", "123254485", "asda@m..l"));
        submitNewUser();
        goHomeLink();
    }
}
