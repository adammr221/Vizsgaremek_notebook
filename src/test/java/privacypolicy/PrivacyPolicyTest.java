package privacypolicy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PrivacyPolicyPage;
import testbase.baseTest;

public class PrivacyPolicyTest extends baseTest {

    @Test
    @DisplayName("TC10 The privacy policy page should contain the capters stored in the class PrivacyPolicyPage.")
    public void testCheckEachLineOfPrivacyPolicyTextFile(){
        PrivacyPolicyPage privacyPolicyPage = homePage.clickPrivacyPolicyBtnOnCookieBoxPopUp();
        homePage.takeScreenShot();
        privacyPolicyPage.SaveParagrahpsToTxtFile();
        homePage.clickAcceptOnPrivacyPolicy();
        Assertions.assertTrue(privacyPolicyPage.checkEachLineOfPrivacyPolicyTXT(privacyPolicyPage.PrivacyPolicyChapters));
    }


}
