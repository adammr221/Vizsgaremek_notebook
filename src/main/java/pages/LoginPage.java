package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    //Variables
    private final WebDriver DRIVER;
    private final By REGISTRATION_BTN = By.xpath("//*[@class='btn' and text()='Regisztráció']");
    private final By LOGIN_BTN = By.xpath("//input[@class='btn-fld login-btn']");
    private final By USERNAME_FIELD = By.xpath("//input[@id='LoginModeltf_login_email']");
    private final By PASSWORD_FIELD = By.xpath("//input[@id='LoginModelpw_login_password']");
    private final By ERROR_MESSAGE = By.xpath("//*[@class='error']//ul//li");

    //Constructor
    public LoginPage(WebDriver webDriver){
        this.DRIVER = webDriver;
    }

    public RegistrationPage clickRegistration(){
        DRIVER.findElement(REGISTRATION_BTN).click();
        return new RegistrationPage(DRIVER);
    }

    public MyAccountPage clickLogin(){
        DRIVER.findElement(LOGIN_BTN).click();
        return new MyAccountPage(DRIVER);
    }

    public void setUsernameField(String username){
        DRIVER.findElement(USERNAME_FIELD).clear();
        DRIVER.findElement(USERNAME_FIELD).sendKeys(username);
    }

    public void setPasswordField(String password){
        DRIVER.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    public String getErrorText(){
        return DRIVER.findElement(ERROR_MESSAGE).getText();
    }






}
