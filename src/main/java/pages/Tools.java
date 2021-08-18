package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.ByteArrayInputStream;

public class Tools {
    public static By IFRAME_AD_CANCEL_BTN = By.xpath("//*[name()='svg']/*[name()='path']");
    public static By IFRAME_AD_WINDOW = By.xpath("//*[@id='40371e65-2a02-4747-9017-c33fcd2157a9']//iframe");


    public static void ifPopupAppearedClickOnX(WebDriver DRIVER){
        try{
            DRIVER.switchTo().frame(DRIVER.findElement(IFRAME_AD_WINDOW));
            WebElement svgObject = DRIVER.findElement(IFRAME_AD_CANCEL_BTN);
            Actions builder = new Actions(DRIVER);
            builder.click(svgObject).build().perform();
        }catch (Exception e){
            System.out.println(e);
        }
    }

/*
    @Step("TakeScreenshot")
    public static void TakeScreenshot(WebDriver driver) {
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        System.out.println(driver.getCurrentUrl());
    }

 */

}
