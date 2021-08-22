package modify_data;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ResultPage;
import pages.Tools;
import testbase.baseTest;

import javax.tools.Tool;
import java.io.ByteArrayInputStream;

public class ModifyDataTest extends baseTest {
    @Test
    @DisplayName("TC7 It tests the brand filter by entering a brand and then modifying it with a sub brand.")
    public void testBrandFilter(){
        homePage.navigate();
        homePage.setSearchBar("pendrive");
        ResultPage resultPage = homePage.clickEnterToShowSearchResults();
        int NumberOfBrandsBeforeFilter = resultPage.getNumberOfBrands();
        resultPage.setBrandSearchBar("adata");
        homePage.takeScreenShot();
        int NumberOfBrandsAfterFilter = resultPage.getNumberOfBrands();
        resultPage.modifyBrandSearchBar("ki");
        homePage.takeScreenShot();
        Assumptions.assumeTrue(NumberOfBrandsAfterFilter < NumberOfBrandsBeforeFilter);
        Assertions.assertTrue(resultPage.checkBrandNamesIncludeSearchedSubString("ki"));
    }


    @Test
    @DisplayName("TC6 It should modify the first name of the user.")
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
        homePage.takeScreenShot();
        myAccountPage.clickSaveBtn();
        homePage.takeScreenShot();
        String ExpectedResult = "Az adatokat sikeresen módosítottuk!";
        Assertions.assertEquals(ExpectedResult, myAccountPage.getSuccessfulModificationText());
    }


}
