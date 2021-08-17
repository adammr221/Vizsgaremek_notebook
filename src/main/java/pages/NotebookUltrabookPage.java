package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotebookUltrabookPage {

    private final WebDriver DRIVER;
    private final By APPLE_NOTEBOOK_FILTER = By.xpath("//label[text()='Apple notebook']");

    public NotebookUltrabookPage (WebDriver webDriver){
        this.DRIVER = webDriver;
    }

    public AppleNotebookPage clickAppleNotebookFilter(){
        DRIVER.findElement(APPLE_NOTEBOOK_FILTER).click();
        return new AppleNotebookPage(DRIVER);
    }


}
