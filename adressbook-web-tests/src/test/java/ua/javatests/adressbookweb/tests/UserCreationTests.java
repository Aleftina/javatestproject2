package ua.javatests.adressbookweb.tests;

import org.testng.annotations.Test;
import ua.javatests.adressbookweb.model.UserData;

public class UserCreationTests extends BaseTest {

    @Test
    public void testUserCreation() {
        applic.getNavigationHelper().addNewUserLink();
        applic.getContactHelper().fillUserParameters(new UserData("Oleg", "Petrov", "123254485", "asda@sadfsdl.ghj","group for empty list"), true);
        applic.getContactHelper().submitNewUser();
        applic.getNavigationHelper().homePageLink();
    }

    @Test
    public void loopCreation(){
        for (int i = 0; i<10 ; i++){
            testUserCreation();
        }

    }
}
