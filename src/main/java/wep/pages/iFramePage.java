package wep.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class iFramePage extends BasePage{

    public static final String BASE_URL = "http://the-internet.herokuapp.com/iframe";
    private static final String IFRAME_ID = "Bmce_0_ifr";
    private static final By IFRAME = By.id(IFRAME_ID);
    private static final By IFRAME_TEXT_FIELD = By.id("tinymce");
    WebDriverWait explicitlyWait = new WebDriverWait(driver, Duration.ofSeconds(5));


    public iFramePage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
    }

    @Override
    public boolean isPageLoaded() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(IFRAME));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public String getEditorText(){
      driver.switchTo().frame(IFRAME_ID);
      String text = driver.findElement(IFRAME_TEXT_FIELD).getText();
      driver.switchTo().defaultContent();
      return text;
    }
}
