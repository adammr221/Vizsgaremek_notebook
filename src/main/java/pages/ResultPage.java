package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



import java.util.ArrayList;
import java.util.List;

public class ResultPage {

    private final WebDriver DRIVER;
    private final By BRAND_SEARCH_BAR = By.xpath("//input[@class='prefixbox-value-filter-search form-control']");
    private final By BRAND_ELEMENTS = By.xpath("//div[@class='brand prefixbox-filter-container prefixbox-filter-count-9']//div[@class='prefixbox-value-filter-values ']//div[@class='prefixbox-value-filter-value ']");
    private final By BRAND_NAME = By.xpath(".//label//span[@class='prefixbox-filter-text']");
    private final By PRODUCT = By.xpath("//*[contains(text(),'További részletek')] ");

    public ResultPage(WebDriver DRIVER) {
        this.DRIVER = DRIVER;
    }

    public int getNumberOfBrands(){
        List<WebElement> numberOfBrands = DRIVER.findElements(BRAND_ELEMENTS);
        return numberOfBrands.size();
    }


    private List<String> getBrandName(){
        WebElement base = DRIVER.findElement(BRAND_ELEMENTS);
        List<WebElement> brandElements = base.findElements(BRAND_NAME);
        List<String> brandNames = new ArrayList<>();
        for (WebElement name : brandElements ) {
            brandNames.add(name.getText().toLowerCase());
        }
        return brandNames;
    }

    public boolean checkBrandNamesIncludeSearchedSubString(String searchedSubString){
        boolean checker = true;
        for (String name : getBrandName()) {
            if (!name.contains(searchedSubString)){
                checker = false;
                break;
            }
        }
        return checker;
    }

    public void setBrandSearchBar(String input){
        DRIVER.findElement(BRAND_SEARCH_BAR).sendKeys(input);
    }

    public void modifyBrandSearchBar(String input){
        DRIVER.findElement(BRAND_SEARCH_BAR).clear();
        DRIVER.findElement(BRAND_SEARCH_BAR).sendKeys(input);
    }

    public ProductDescriptionPage clickFirstProduct(){
        WebElement btn = DRIVER.findElement(PRODUCT);
        JavascriptExecutor jse = (JavascriptExecutor)DRIVER;
        jse.executeScript("arguments[0].click()",btn);
        return new ProductDescriptionPage(DRIVER);
    }

}
