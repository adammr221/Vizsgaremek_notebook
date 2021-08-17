package logout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import testbase.baseTest;

public class LogoutTest extends baseTest {

    @Test
    public void testSuccessfulLogout(){
        LoginPage loginPage = homePage.clickMyAccount();
        loginPage.setUsernameField("t.nagy.peter.mail@gmail.com");
        loginPage.setPasswordField("Wsp321.");
        MyAccountPage myAccountPage = loginPage.clickLogin();
        homePage.clickLogoutByHoverOverMyAccountBtn();
        homePage.ifPopupAppearedClickOnX();
        homePage.hoverOverMyAccountBtn();
        Assertions.assertTrue(homePage.getLogoutText().contains("Jelentkezz"));
    }
}
