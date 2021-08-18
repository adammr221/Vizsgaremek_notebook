package modify_data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ResultPage;
import pages.Tools;
import testbase.baseTest;

import javax.tools.Tool;

public class ModifyDataTest extends baseTest {
    @Test
    public void testBrandFilter(){
        homePage.navigate();
        homePage.setSearchBar("pendrive");
        ResultPage resultPage = homePage.clickEnterToShowSearchResults();
        Tools.TakeScreenshot(driver);
        int NumberOfBrandsBeforeFilter = resultPage.getNumberOfBrands();
        resultPage.setBrandSearchBar("adata");
        Tools.TakeScreenshot(driver);
        int NumberOfBrandsAfterFilter = resultPage.getNumberOfBrands();
        resultPage.modifyBrandSearchBar("ki");
        Tools.TakeScreenshot(driver);
        Assumptions.assumeTrue(NumberOfBrandsAfterFilter < NumberOfBrandsBeforeFilter);
        Assertions.assertTrue(resultPage.checkBrandNamesIncludeSearchedSubString("ki"));
    }

    /*
    @Test
    public void testModifyRegisteredName(){
        homePage.navigate();
        LoginPage loginPage = homePage.clickMyAccount();
        loginPage.setUsernameField("t.nagy.peter.mail@gmail.com");
        loginPage.setPasswordField("Wsp321.");
        MyAccountPage myAccountPage = loginPage.clickLogin();
        homePage.ifPopupAppearedClickOnX();
        myAccountPage.clickAccountInformation();
        myAccountPage.setFirstName("Áron");
        myAccountPage.setPassword("Wsp321.");
        myAccountPage.setPasswordAgain("Wsp321.");
        myAccountPage.clickSaveBtn();
        String ExpectedResult = "Az adatokat sikeresen módosítottuk!";
        Assertions.assertEquals(ExpectedResult, myAccountPage.getSuccessfulModificationText());
    }

     */
}
