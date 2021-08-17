package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class ApplePhonePage  {

    private final WebDriver DRIVER;
    private final By CLICK_SECOND_PAGE = By.xpath("//div[@class='pager']//a[text()='2']");
    private final By NAMES_OF_APPLE_PHONES = By.xpath("//div[@class='item-title']//a");


    public ApplePhonePage(WebDriver webDriver){
        this.DRIVER = webDriver;
    }

    public List<String> elementCollector(int numberOfPages){
        List<String> applePhonesList = new ArrayList<>();
        for (int i = 0; i < numberOfPages; i++) { //addig iterál ahány oldal van.
            List<WebElement> filteredProductItems = DRIVER.findElements(NAMES_OF_APPLE_PHONES);
            for (WebElement item : filteredProductItems) {
                applePhonesList.add(item.getText());
            }
            if (i+2 <= numberOfPages){
                clickNextPage(i+2);
            }
            Tools.ifPopupAppearedClickOnX(DRIVER);
        }
        return applePhonesList;
    }

    private void clickNextPage(int page){
            DRIVER.findElement(By.xpath("//div[@class='pager']//a[text()='"+ page +"']")).click();
    }


    public Boolean doesResultIncludeStringApple(List<String> list){
        Boolean checker = true;
        for (String element : list) {
            if (!element.contains("Apple")){
                checker = false;
            }
        }
        return checker;
    }

    public Boolean isResultMoreThan36(List<String> list){
        if (list.size() > 36){
            return true;
        }
        return false;
    }

}
