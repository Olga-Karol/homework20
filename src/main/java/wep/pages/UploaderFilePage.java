package wep.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class UploaderFilePage extends BasePage{

    public static final String BASE_URL = "http://the-internet.herokuapp.com/upload";
    private static final By UPLOAD_BUTTON = By.id("file-submit");
    private static final By CHOOSE_FILE_BUTTON = By.id("file-upload");
    private static final By FILE_NAME = By.id("uploaded-files");
    public static final File RESOURCE_PATH_FILE = new File("src/test/resources/test.txt");
    public static final String ABSOLUTE_RESOURCE_PATH = RESOURCE_PATH_FILE.getAbsolutePath().trim();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


    public UploaderFilePage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElementId = UPLOAD_BUTTON;
    }

    public void uploadFileProcess(){
        driver.findElement(CHOOSE_FILE_BUTTON).sendKeys(ABSOLUTE_RESOURCE_PATH);
        driver.findElement(UPLOAD_BUTTON).click();
    }

    public boolean isFileUploaded(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(FILE_NAME));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public String getFileName(){
        return driver.findElement(FILE_NAME).getText();
    }
}
