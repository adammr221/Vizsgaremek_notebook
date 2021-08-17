package privacypolicy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.PrivacyPolicyPage;
import testbase.baseTest;

public class PrivacyPolicyTest extends baseTest {

    @Test
    public void testCheckEachLineOfPrivacyPolicyTextFile(){
        PrivacyPolicyPage privacyPolicyPage = homePage.clickPrivacyPolicyBtnOnCookieBoxPopUp();
        privacyPolicyPage.SaveParagrahpsToTxtFile();
        homePage.clickAcceptOnPrivacyPolicy();
        Assertions.assertTrue(privacyPolicyPage.checkEachLineOfPrivacyPolicyTXT(privacyPolicyPage.PrivacyPolicyChapters));
    }


}
