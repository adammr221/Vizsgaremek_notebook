package read_multipage_list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MobiltelefonTabletPage;
import pages.ApplePhonePage;
import testbase.baseTest;

import java.util.List;

public class ReadMultiPageListTest extends baseTest {

    @Test
    @DisplayName("TC8 All result must include the filtered brand.")
    public void MultiPageAppleProductFilterTest(){
        MobiltelefonTabletPage mobiltelefonTabletPage = homePage.clickMobiltelefonTabletBtn();
        homePage.clickAcceptOnPrivacyPolicy();
        ApplePhonePage applePhonePage = mobiltelefonTabletPage.clickAppleFilter();
        List<String> ListOfTheNameOfApplePhones = applePhonePage.elementCollector(3);
        Assumptions.assumeTrue(applePhonePage.isResultMoreThan36(ListOfTheNameOfApplePhones)); //There are 36 items on one page.
        Assertions.assertTrue(applePhonePage.doesResultIncludeStringApple(ListOfTheNameOfApplePhones));
    }
}
