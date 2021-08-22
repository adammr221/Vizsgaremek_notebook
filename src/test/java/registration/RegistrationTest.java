package registration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.SuccessfulRegistrationPage;
import testbase.baseTest;

public class RegistrationTest extends baseTest {


    @Test
    @DisplayName("TC1 Succesful registration")
    public void testSuccessfulRegistration(){
        LoginPage loginPage = homePage.clickMyAccount();
        RegistrationPage registrationPage = loginPage.clickRegistration();
        registrationPage.setFirstname("Kiss");
        registrationPage.setLastname("Elek");
        registrationPage.setEmailField("elek.teszt.mail@gmail.com");
        registrationPage.AcceptTermsAndConditionsByRadioBtn();
        registrationPage.setPasswordField("Wsp331.");
        registrationPage.setPasswordField2("Wsp331.");
        SuccessfulRegistrationPage successfulRegistrationPage = registrationPage.clickRegistrationBtn();
        Assertions.assertTrue(successfulRegistrationPage.getAlertText().contains("Sikeres"));
    }




}
