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
        registrationPage.setFirstname("Kovács");
        registrationPage.setLastname("Áron");
        registrationPage.setEmailField("aronkovacs1975@gmail.com");
        registrationPage.AcceptTermsAndConditionsByRadioBtn();
        registrationPage.setPasswordField("Wsp0819.");
        registrationPage.setPasswordField2("Wsp0819.");
        homePage.takeScreenShot();
        SuccessfulRegistrationPage successfulRegistrationPage = registrationPage.clickRegistrationBtn();
        homePage.ifPopupAppearedClickOnX();
        homePage.takeScreenShot();
        Assertions.assertTrue(successfulRegistrationPage.isRegistrationSuccesful());
    }




}
