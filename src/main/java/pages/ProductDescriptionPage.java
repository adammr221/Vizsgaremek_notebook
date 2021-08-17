package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ProductDescriptionPage {
    private final WebDriver DRIVER;
    private final By ADD_TO_CART = By.xpath("//button[@class='btn_cart frm-button']");
    private final By SUCCESSFULLY_ADDED_CART_TEXT = By.xpath("//div[@class='popup_top_cell']//span[@class='text']");
    private final By CART_POPUP_CLOSE_BTN = By.xpath("//div[@class='popup_top_cell close']//button");
    private final By CART_BTN = By.xpath("//span[contains(text(),'Kosaram')]");
    private final By CHECK_CART = By.xpath("//a[contains(text(),'Kosár megtekintése')]");

    public ProductDescriptionPage(WebDriver DRIVER) {
        this.DRIVER = DRIVER;
    }

    public void clickAddToCart(){
        DRIVER.findElement(ADD_TO_CART).click();
    }

    public String getSuccessfulAddedToCartText(){
        return DRIVER.findElement(SUCCESSFULLY_ADDED_CART_TEXT).getText();
    }

    public void closeCartPopup(){
        DRIVER.findElement(CART_POPUP_CLOSE_BTN).click();
    }

    public MyCartPage clickMyCartByHoverOverCart(){
        Actions actions = new Actions(DRIVER);
        actions.moveToElement(DRIVER.findElement(CART_BTN)).perform();
        DRIVER.findElement(CHECK_CART).click();
        return new MyCartPage(DRIVER);
    }



}
