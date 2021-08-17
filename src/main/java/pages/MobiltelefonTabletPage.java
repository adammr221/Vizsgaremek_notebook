package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MobiltelefonTabletPage {

    private final WebDriver DRIVER;
    private final By APPLE_CHECKBOX_FILTER = By.xpath("//label[contains(text(),'Apple')]");

    public MobiltelefonTabletPage (WebDriver webDriver){
        this.DRIVER = webDriver;
    }

    public ApplePhonePage clickAppleFilter(){
        DRIVER.findElement(APPLE_CHECKBOX_FILTER).click();
        return new ApplePhonePage(DRIVER);
    }



}
