package save_data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AppleNotebookPage;
import pages.NotebookUltrabookPage;
import testbase.baseTest;


public class ProductFilterTest extends baseTest {

    @Test
    @DisplayName("TC11 The page must contain elements that match the filter criteria.")
    public void FilterAppleNotebooksTest(){
        NotebookUltrabookPage notebookUltrabookPage = homePage.clickNotebookUltrabookBtn();
        AppleNotebookPage appleNotebookPage = notebookUltrabookPage.clickAppleNotebookFilter();
        appleNotebookPage.saveProductNameAndPriceAsTxt();
        Assertions.assertTrue(appleNotebookPage.CheckEachLineOfTextFile("macbook", "name_and_price.txt" ));
    }


}
