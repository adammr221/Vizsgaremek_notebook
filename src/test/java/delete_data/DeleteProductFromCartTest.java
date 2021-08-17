package delete_data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import pages.MyCartPage;
import pages.ProductDescriptionPage;
import pages.ResultPage;
import testbase.baseTest;

public class DeleteProductFromCartTest extends baseTest {

    @Test
    public void testDeleteProductFromCart(){
        homePage.setSearchBar("Led monitor");
        ResultPage resultPage = homePage.clickEnterToShowSearchResults();
        ProductDescriptionPage productDescriptionPage = resultPage.clickFirstProduct();
        productDescriptionPage.clickAddToCart();
        String succesfullyAddedCart = productDescriptionPage.getSuccessfulAddedToCartText();
        productDescriptionPage.closeCartPopup();
        homePage.ifPopupAppearedClickOnX();
        MyCartPage myCartPage = productDescriptionPage.clickMyCartByHoverOverCart();
        myCartPage.clickOnDeleteOnItem();
        Assumptions.assumeTrue(succesfullyAddedCart.contains("sikeresen a kosárba tettük!"));
        Assertions.assertTrue(myCartPage.getYourCartIsEmptyText().contains("kosarad üres"));
    }
}
