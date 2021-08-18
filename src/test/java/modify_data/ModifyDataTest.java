package modify_data;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
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
    public void testBrandFilter(){
        homePage.navigate();
        TakeScreenshot(driver);
        homePage.setSearchBar("pendrive");
        TakeScreenshot(driver);
        ResultPage resultPage = homePage.clickEnterToShowSearchResults();
        TakeScreenshot(driver);
        int NumberOfBrandsBeforeFilter = resultPage.getNumberOfBrands();
        resultPage.setBrandSearchBar("adata");
        int NumberOfBrandsAfterFilter = resultPage.getNumberOfBrands();
        resultPage.modifyBrandSearchBar("ki");
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

    @Step("TakeScreenshot")
    public void TakeScreenshot(WebDriver driver) {
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println(driver.getCurrentUrl());
    }
}
