package login;

import org.junit.jupiter.api.*;
import pages.LoginPage;
import pages.MyAccountPage;
import testbase.baseTest;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest extends baseTest {

    @Test
    @DisplayName("TC3")
    @Order(1)
    public void testUnsuccessfulLogin(){
        homePage.navigate();
        LoginPage loginPage = homePage.clickMyAccount();
        loginPage.setUsernameField("t.nagy.peter.mail@gmail.com");
        loginPage.setPasswordField("Wsp123.");
        homePage.takeScreenShot();
        loginPage.clickLogin();
        Assertions.assertTrue(loginPage.getErrorText().contains("Hibás felhasználó név vagy jelszó"));
    }

    @Test
    @DisplayName("TC2")
    @Order(2)
    public void testSuccessfulLogin(){
        homePage.navigate();
        LoginPage loginPage = homePage.clickMyAccount();
        loginPage.setUsernameField("t.nagy.peter.mail@gmail.com");
        loginPage.setPasswordField("Wsp321.");
        homePage.takeScreenShot();
        MyAccountPage myAccountPage = loginPage.clickLogin();
        Assertions.assertTrue(myAccountPage.getWelcomeText().contains("Üdvözöllek"));
    }

}
