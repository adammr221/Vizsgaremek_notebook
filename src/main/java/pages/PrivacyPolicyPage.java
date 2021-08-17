package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class PrivacyPolicyPage {

    private final WebDriver DRIVER;
    private final By PARAGRAPHS = By.xpath("//div[@class='pages-content']//h2");
    private final By DOWNLOAD_PRIVACY_POLICY = By.xpath("//p//a[contains(@href,'pdf')]");

    public final String[] PrivacyPolicyChapters = {"Adatkezelő", "Adatkezelés célja", "Szolgáltatás(ok) hirdetése, információ nyújtása érintettek számára",
            "Érintettek köre", "Kötelezően megadandó adatok köre", "Gyermekek", "Adatfeldolgozó igénybevételéről szóló tájékoztatás",
            "Az adatok megismerésére jogosultak köre", "Automata döntéshozatal", "Harmadik féltől kapott adatok kezelése", "Az érintettek jogai", "Adatok nyilvánosságra hozatala",
            "Adattovábbítás harmadik országba vagy nemzetközi szervezet részére", "Adatbiztonsági intézkedésekről szóló tájékoztatás", "Analitikai Szolgáltatások", "Google Analytics",
            "Google Adwords", "Facebook", "Böngészők cookie kezelése", "Alkalmazott jogszabályok", "Jogorvoslat"};

    public PrivacyPolicyPage(WebDriver webDriver){
        this.DRIVER = webDriver;
    }

    public void SaveParagrahpsToTxtFile(){
        List<WebElement> paragraphs = DRIVER.findElements(PARAGRAPHS);
        createTextFile(paragraphs);
    }

    private void createTextFile(List<WebElement> input){
        try {
            File file = new File("paragraphs_of_privacy_policy.txt");
            FileWriter fileWriter = new FileWriter(file);
            for (WebElement title : input) {
                fileWriter.write(title.getText() + "\n");
            }
            fileWriter.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }


    public Boolean checkEachLineOfPrivacyPolicyTXT(String[] chapters){
        boolean checker = true;
        boolean innerChecker = false;
        try {
            File file = new File("paragraphs_of_privacy_policy.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if (line.equals(" ")){ break; }
                for (String chapter : chapters) {
                    innerChecker = line.contains(chapter);
                    if (innerChecker) { break; }
                }
                if (!innerChecker){
                    checker = false;
                    scanner.close();
                    return checker;
                }
            }
            scanner.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return checker;
    }

    public void clickDownloadPrivacyPolicy(){
        WebElement btn = DRIVER.findElement(DOWNLOAD_PRIVACY_POLICY);
        JavascriptExecutor jse = (JavascriptExecutor)DRIVER;
        jse.executeScript("arguments[0].click()",btn);
        //DRIVER.findElement(DOWNLOAD_PRIVACY_POLICY).click();
    }

}
