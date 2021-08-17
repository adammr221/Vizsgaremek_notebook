package login;

import org.junit.jupiter.api.*;
import pages.LoginPage;
import pages.MyAccountPage;
import testbase.baseTest;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest extends baseTest {

    @Test
    @Order(1)
    public void testUnsuccessfulLogin(){
        homePage.navigate();
        LoginPage loginPage = homePage.clickMyAccount();
        loginPage.setUsernameField("t.nagy.peter.mail@gmail.com");
        loginPage.setPasswordField("Wsp123.");
        loginPage.clickLogin();
        Assertions.assertTrue(loginPage.getErrorText().contains("Hibás felhasználó név vagy jelszó"));
    }

    @Test
    @Order(2)
    public void testSuccessfulLogin(){
        homePage.navigate();
        LoginPage loginPage = homePage.clickMyAccount();
        loginPage.setUsernameField("t.nagy.peter.mail@gmail.com");
        loginPage.setPasswordField("Wsp321.");
        MyAccountPage myAccountPage = loginPage.clickLogin();
        Assertions.assertTrue(myAccountPage.getWelcomeText().contains("Üdvözöllek"));
    }

}
