package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfulRegistrationPage {

    private final WebDriver DRIVER;
    private final By SUCCESS_ALERT_TEXT = By.xpath("//div[@class='success1']");
    private final By ALREADY_REGISTERED_TEXT = By.xpath("//div[@class='error']/ul/li");

    public SuccessfulRegistrationPage(WebDriver webDriver){
        this.DRIVER = webDriver;
    }

    private String getSuccessfulAlertText(){
        return DRIVER.findElement(SUCCESS_ALERT_TEXT).getText();
    }

    private String getAlreadyRegisteredText(){
        return DRIVER.findElement(ALREADY_REGISTERED_TEXT).getText();
    }

    //Screenshots are taken during test. see: Allure report
    public boolean isRegistrationSuccesful(){
        try {
            if (getSuccessfulAlertText().contains("Sikeres")){
                //System.out.println(getSuccessfulAlertText());
                return true;
            }
        }catch (Exception e){
            if (getAlreadyRegisteredText().contains("létezik")){
                //System.out.println(getAlreadyRegisteredText());
                return true;
            }
        }
        return false;
    }



}
