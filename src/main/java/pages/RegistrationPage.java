package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    //Variables
    private final WebDriver DRIVER;
    private final By LAST_NAME_FIELD = By.xpath("//input[@id = 'tf_last_name']"); //Keresztnév
    private final By FIRST_NAME_FIELD = By.xpath("//input[@id = 'tf_first_name']"); //Vezetéknév
    private final By EMAIL_FIELD = By.xpath("//input[@id = 'tf_email_reg']");
    private final By PASSWORD_FIELD = By.xpath("//input[@id = 'pw_password_reg']");
    private final By PASSWORD2_FIELD = By.xpath("//input[@id = 'pw_password_re']");
    private final By ACCEPT_TERM_COND_BTN = By.xpath("//input[@id = 'adatvedelem_1']");
    private final By REGISTRATION_BTN = By.xpath("//input[@id='btn_registration']");


    //Constructor
    public RegistrationPage(WebDriver webDriver){
        this.DRIVER = webDriver;
    }

    public void setFirstname(String firstname){
        DRIVER.findElement(FIRST_NAME_FIELD).sendKeys(firstname);
    }

    public void setLastname(String lastname){
        DRIVER.findElement(LAST_NAME_FIELD).sendKeys(lastname);
    }

    public void setEmailField(String email){
        DRIVER.findElement(EMAIL_FIELD).sendKeys(email);
    }

    public void setPasswordField(String password){
        DRIVER.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    public void setPasswordField2(String password){
        DRIVER.findElement(PASSWORD2_FIELD).sendKeys(password);
    }

    public void AcceptTermsAndConditionsByRadioBtn(){
        WebElement AcceptTermCondRadioBtnElement = DRIVER.findElement(ACCEPT_TERM_COND_BTN);
        if (!AcceptTermCondRadioBtnElement.isSelected()){
            AcceptTermCondRadioBtnElement.click();
        }
    }

    public SuccessfulRegistrationPage clickRegistrationBtn(){
        DRIVER.findElement(REGISTRATION_BTN).click();
        return new SuccessfulRegistrationPage(DRIVER);
    }

}
