package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyCartPage {
    private final WebDriver DRIVER;
    private final By DELETE_PRODUCT_FROM_CART = By.xpath("//button[@class='delete']");
    private final By EMPTY_CART_TEXT = By.xpath("//p[text()='A kosarad üres']");

    public MyCartPage(WebDriver DRIVER) {
        this.DRIVER = DRIVER;
    }

    public void clickOnDeleteOnItem(){
        DRIVER.findElement(DELETE_PRODUCT_FROM_CART).click();
    }

    public String getYourCartIsEmptyText(){
        WebElement element = DRIVER.findElement(EMPTY_CART_TEXT);
        return element.getText();
    }


}
