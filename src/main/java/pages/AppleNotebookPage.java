package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AppleNotebookPage {

    private final WebDriver DRIVER;
    private final By PRODUCT_ITEMS = By.xpath("//*[@class='item-new']");
    private final By PRODUCT_NAME = By.xpath("./div/div[@class='item-title']/a");
    private final By PRODUCT_PRICE_SPECIAL = By.xpath("./div/div[@class='item-price tbl-container']/div[@class='price-box tbl-cell']/p[@class='special-price']/span");
    private final By PRODUCT_PRICE_REGULAR = By.xpath("./div/div[@class='item-price tbl-container']/div[@class='price-box tbl-cell']/p[@class='regular-price']/span");
    private final By PRODUCT_PRICE_OLD_CHECK_CLASS = By.xpath("./div/div[@class='item-price tbl-container']/div[@class='price-box tbl-cell']/p[2]");

    public AppleNotebookPage (WebDriver webDriver){
        this.DRIVER = webDriver;
    }

    public void saveProductNameAndPriceAsTxt(){
        List<WebElement> filteredProductItems = DRIVER.findElements(PRODUCT_ITEMS);
        List<String> nameAndPriceList = new ArrayList<>();
        for (WebElement productItem : filteredProductItems) {
            if(isDiscounted(productItem, PRODUCT_PRICE_OLD_CHECK_CLASS)){
                nameAndPriceList.add(productItem.findElement(PRODUCT_NAME).getText());
                nameAndPriceList.add(productItem.findElement(PRODUCT_PRICE_SPECIAL).getText());
            }else {
                nameAndPriceList.add(productItem.findElement(PRODUCT_NAME).getText());
                nameAndPriceList.add(productItem.findElement(PRODUCT_PRICE_REGULAR).getText());
            }
        }
        createTextFile(nameAndPriceList);
    }

    private Boolean isDiscounted(WebElement item, By xpath ){
        Boolean output = true;
        String className = item.findElement(xpath).getAttribute("class");
        if (className.equals("regular-price")){
            output = false;
        }
        return output;
    }

    private void createTextFile(List<String> input){
        try {
            File file = new File("name_and_price.txt");
            FileWriter fileWriter = new FileWriter(file);
            for (int i = 0; i < input.size(); i++) {
                if ((i % 2) != 0){
                    fileWriter.write(input.get(i) + "\n");
                }else {
                    fileWriter.write(input.get(i) + " ");
                }
            }
            fileWriter.close();
        }catch(Exception e){
            System.out.println("An error occurred.");
        }
    }


    public Boolean CheckEachLineOfTextFile(String productName, String path){
        Boolean checker = true;
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine().toLowerCase();
                if (!line.contains(productName)){
                    checker = false;
                    break;
                }
            }
        }catch (FileNotFoundException e){
            System.out.println(e);
        }
        return checker;
    }

}
