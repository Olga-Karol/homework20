package wep.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;


public class DownloadFilePage extends BasePage{

    public static final String BASE_URL = "http://the-internet.herokuapp.com/download";
    public static final By LOCATOR = By.xpath("//div[@class='example']//h3[text()='File Downloader']");

    public DownloadFilePage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElementId = LOCATOR;
    }

    public void downloadFile(String fileName){
        driver.findElement(By.partialLinkText(fileName)).click();
    }

    public void removeDownloadedFile(String fileName){
        File pathToFile = new File("src/test/resources/" + fileName);
        pathToFile.delete();
    }
}
