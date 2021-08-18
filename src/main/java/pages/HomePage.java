package pages;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
    //Variables
    private final WebDriver DRIVER;
    private final By MY_ACCOUNT_BTN = By.xpath("//span[text()='Fiókom']");
    private final By LOGOUT_BTN = By.xpath("//li[@class='logout']//a");
    private final By LOGOUT_TEXT = By.xpath("//*[@class='not-logged-content'][contains(text(),'Jelentkezz be')]");
    private final String IFRAME_ID = "bhr-iframe-consent-form";
    private final By IFRAME_AD_CANCEL_BTN = By.xpath("//*[name()='svg']/*[name()='path']");
    private final By IFRAME_AD_WINDOW = By.xpath("//*[@id='40371e65-2a02-4747-9017-c33fcd2157a9']//iframe");
    private final By NOTEBOOK_ULTRABOOK_BTN = By.xpath("//li[@data-id='1']");
    private final By MOBILTELEFON_TABLET_BTN = By.xpath("//li[@data-id='2']");
    private final By PRIVACY_POLICY_ACCEPT_BTN = By.xpath("//span[contains(text(), 'Elfogadom')]");
    private final By PRIVACY_POLICY_BTN = By.xpath("//*[@id='cookiebox']//a");
    private final By PRIVACY_POLICY_AT_BOTTOM_OF_WEBPAGE_BTN = By.xpath("//br//following::a[contains(text(),'Adatkezelési tájékoztató')]");
    private final By SUBSCRIPTION_FIRST_NAME_FIELD = By.xpath("//input[@name='FNAME']");
    private final By SUBSCRIPTION_LAST_NAME_FIELD = By.xpath("//input[@name='LNAME']");
    private final By SUBSCRIPTION_EMAIL_FIELD = By.xpath("//input[@name='EMAIL']");
    private final By SUBSCRIPTION_ACCEPT_PRIVACY_POLICY = By.xpath("//input[@id='adatvedelem']");
    private final By SUBSCRIPTION_BTN = By.xpath("//button[@name='subscribe']");
    private final By SEARCH_BAR = By.xpath("//input[@id='pf-desktop-ac']");
    private List<String> SubscriptionAlertTextList = new ArrayList<>();




    //Constructor
    public HomePage(WebDriver webDriver){
        this.DRIVER = webDriver;
    }

    public LoginPage clickMyAccount(){
        click(MY_ACCOUNT_BTN);
        return new LoginPage(DRIVER);
    }

    public void clickLogoutByHoverOverMyAccountBtn(){
        hoverOverElement(MY_ACCOUNT_BTN);
        click(LOGOUT_BTN);
    }

    public String getLogoutText(){
        hoverOverElement(MY_ACCOUNT_BTN);
        return DRIVER.findElement(LOGOUT_TEXT).getText();
    }

    public void hoverOverMyAccountBtn(){
        hoverOverElement(MY_ACCOUNT_BTN);
    }

    public void clickExitOnInterestedInPromotionsPopup(){
        DRIVER.switchTo().frame(IFRAME_ID);
        click(IFRAME_AD_CANCEL_BTN);
    }

    public void ifPopupAppearedClickOnX(){
        try{
            DRIVER.switchTo().frame(DRIVER.findElement(IFRAME_AD_WINDOW));
            WebElement svgObject = DRIVER.findElement(IFRAME_AD_CANCEL_BTN);
            Actions builder = new Actions(DRIVER);
            builder.click(svgObject).build().perform();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public NotebookUltrabookPage clickNotebookUltrabookBtn(){
        click(NOTEBOOK_ULTRABOOK_BTN);
        return new NotebookUltrabookPage(DRIVER);
    }

    public MobiltelefonTabletPage clickMobiltelefonTabletBtn(){
        click(MOBILTELEFON_TABLET_BTN);
        return new MobiltelefonTabletPage(DRIVER);
    }

    public PrivacyPolicyPage clickPrivacyPolicyBtnOnCookieBoxPopUp(){
        click(PRIVACY_POLICY_BTN);
        return new PrivacyPolicyPage(DRIVER);
    }

    public PrivacyPolicyPage clickPrivacyPolicyAtTheBottomOfTheWebPage(){
        WebElement btn = DRIVER.findElement(PRIVACY_POLICY_AT_BOTTOM_OF_WEBPAGE_BTN);
        JavascriptExecutor jse = (JavascriptExecutor)DRIVER;
        jse.executeScript("arguments[0].click()",btn);
        return new PrivacyPolicyPage(DRIVER);
    }

    public void clickAcceptOnPrivacyPolicy(){
        click(PRIVACY_POLICY_ACCEPT_BTN);
    }


    public void SubscriptionForNewsLetter(){
        String[][] input = SaveJsonFileContentInArray("input_data_test.json");
        int NumOfUsers = input.length;
        for (int i = 0; i < NumOfUsers; i++) {
            DRIVER.findElement(SUBSCRIPTION_FIRST_NAME_FIELD).sendKeys(input[i][0]);
            DRIVER.findElement(SUBSCRIPTION_LAST_NAME_FIELD).sendKeys(input[i][1]);
            DRIVER.findElement(SUBSCRIPTION_EMAIL_FIELD).sendKeys(input[i][2]);
            click(SUBSCRIPTION_ACCEPT_PRIVACY_POLICY);
            click(SUBSCRIPTION_BTN);
            SubscriptionAlertTextList.add(AlertTextForSubscription());
            clickOkOnSubscriptionAlert();
            navigate();
        }
    }

    private String[][] SaveJsonFileContentInArray(String input){
        try {
            Reader reader = Files.newBufferedReader(Paths.get(input));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode parser = objectMapper.readTree(reader);
            int NumOfUsers = parser.path("users").size();
            String[][] users = new String[NumOfUsers][3]; //[firstname,lastname,e-mail]
            int i = 0;
            for(JsonNode user : parser.path("users")){
                    users[i][0] = user.path("name").path("firstName").asText();
                    users[i][1] = user.path("name").path("lastName").asText();
                    users[i][2] = user.path("email").asText();
                    i++;
            }
            reader.close();
            return users;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    private String AlertTextForSubscription(){
        WebDriverWait wait = new WebDriverWait(DRIVER, 15);
        wait.until(ExpectedConditions.alertIsPresent());
        return DRIVER.switchTo().alert().getText();
    }

    public Boolean AreAllSubscriptionSuccessful(){
        for (String message : SubscriptionAlertTextList) {
            if (!message.contains("Sikeresen feliratkoztál hírlevelünkre!")){
                return false;
            }
        }
        return true;
    }

    public void clickOkOnSubscriptionAlert(){
        WebDriverWait wait = new WebDriverWait(DRIVER, 15);
        wait.until(ExpectedConditions.alertIsPresent());
        DRIVER.switchTo().alert().accept();
    }

    public void setSearchBar(String input){
        //WebDriverWait wait = new WebDriverWait(DRIVER, 30);
        //wait.until(ExpectedConditions.elementToBeClickable(SEARCH_BAR));
        DRIVER.findElement(SEARCH_BAR).sendKeys(input);
    }

    public ResultPage clickEnterToShowSearchResults(){
        DRIVER.findElement(SEARCH_BAR).sendKeys(Keys.ENTER);
        return new ResultPage(DRIVER);
    }

    //Methods for generic purposes

    public void navigate(){
        DRIVER.get("https://www.notebook.hu/");
    }

    private void click(By xpath){
        DRIVER.findElement(xpath).click();
    }

    public void hoverOverElement(By xpath){
        Actions actions = new Actions(DRIVER);
        actions.moveToElement(DRIVER.findElement(xpath)).perform();
    }




}
