package logout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import testbase.baseTest;

public class LogoutTest extends baseTest {

    @Test
    @DisplayName("TC4 It should log out succesfully")
    public void testSuccessfulLogout(){
        LoginPage loginPage = homePage.clickMyAccount();
        loginPage.setUsernameField("t.nagy.peter.mail@gmail.com");
        loginPage.setPasswordField("Wsp321.");
        loginPage.clickLogin();
        homePage.clickLogoutByHoverOverMyAccountBtn();
        homePage.ifPopupAppearedClickOnX();
        homePage.hoverOverMyAccountBtn();
        Assertions.assertTrue(homePage.getLogoutText().contains("Jelentkezz"));
    }
}
