package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfulRegistrationPage {

    private final WebDriver DRIVER;
    private final By SUCCESS_ALERT_TEXT = By.xpath("//div[@class='success1']");

    public SuccessfulRegistrationPage(WebDriver webDriver){
        this.DRIVER = webDriver;
    }

    public String getAlertText(){
        return DRIVER.findElement(SUCCESS_ALERT_TEXT).getText();
    }
}
