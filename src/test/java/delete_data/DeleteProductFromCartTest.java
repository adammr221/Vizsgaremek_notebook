package delete_data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MyCartPage;
import pages.ProductDescriptionPage;
import pages.ResultPage;
import testbase.baseTest;

public class DeleteProductFromCartTest extends baseTest {

    @Test
    @DisplayName("TC5 It should delete a Led monitor from the cart.")
    public void testDeleteProductFromCart(){
        homePage.setSearchBar("Led monitor");
        ResultPage resultPage = homePage.clickEnterToShowSearchResults();
        homePage.takeScreenShot();
        ProductDescriptionPage productDescriptionPage = resultPage.clickFirstProduct();
        productDescriptionPage.clickAddToCart();
        homePage.takeScreenShot();
        String succesfullyAddedCart = productDescriptionPage.getSuccessfulAddedToCartText();
        productDescriptionPage.closeCartPopup();
        homePage.ifPopupAppearedClickOnX();
        MyCartPage myCartPage = productDescriptionPage.clickMyCartByHoverOverCart();
        myCartPage.clickOnDeleteOnItem();
        homePage.takeScreenShot();
        Assumptions.assumeTrue(succesfullyAddedCart.contains("sikeresen a kosárba tettük!"));
        Assertions.assertTrue(myCartPage.getYourCartIsEmptyText().contains("kosarad üres"));
    }
}
