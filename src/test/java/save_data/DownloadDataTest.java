package save_data;

import org.junit.jupiter.api.Test;
import pages.PrivacyPolicyPage;
import testbase.baseTest;

public class DownloadDataTest extends baseTest {

    @Test
    public void DownloadPrivacyPolicyAsPDF(){
        homePage.navigate();
        PrivacyPolicyPage privacyPolicyPage = homePage.clickPrivacyPolicyAtTheBottomOfTheWebPage();
        privacyPolicyPage.clickDownloadPrivacyPolicy();
    }
}
