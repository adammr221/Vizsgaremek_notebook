package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    private final WebDriver DRIVER;
    private final By WELCOME_TEXT = By.xpath("//h4[contains(text(),'Üdv')]");
    private final By ACCOUNT_INFORMATION_BTN = By.xpath("//li[@class='menu-item']//a[contains(@href,'ugyfelkapu/informacio')]");
    private final By FIRSTNAME_FIELD = By.xpath("//input[@id='tf_last_name']");
    private final By PASSWORD_FIELD = By.xpath("//input[@id='pw_password_reg']");
    private final By PASSWORD_AGAIN_FIELD = By.xpath("//input[@id='pw_password_re']");
    private final By SAVE_BTN = By.xpath("//input[@id='btn_registration']");
    private final By SUCCESSFUL_MODIFICATION_TEXT = By.xpath("//div[@class='success']//span");

    public MyAccountPage(WebDriver webDriver){
        this.DRIVER = webDriver;
    }

    public String getWelcomeText(){
        return DRIVER.findElement(WELCOME_TEXT).getText();
    }

    public void clickAccountInformation(){
        DRIVER.findElement(ACCOUNT_INFORMATION_BTN).click();
    }

    public void setFirstName(String name){
        DRIVER.findElement(FIRSTNAME_FIELD).clear();
        DRIVER.findElement(FIRSTNAME_FIELD).sendKeys(name);
    }

    public void setPassword(String psw){
        DRIVER.findElement(PASSWORD_FIELD).sendKeys(psw);
    }

    public void setPasswordAgain(String psw){
        DRIVER.findElement(PASSWORD_AGAIN_FIELD).sendKeys(psw);
    }

    public void clickSaveBtn(){
        DRIVER.findElement(SAVE_BTN).click();
    }

    public String getSuccessfulModificationText(){
        return DRIVER.findElement(SUCCESSFUL_MODIFICATION_TEXT).getText();
    }


}
