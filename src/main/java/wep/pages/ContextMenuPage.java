package wep.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContextMenuPage extends BasePage{

    public static final String BASE_URL = "http://the-internet.herokuapp.com/context_menu";
    private static final String CLICKABLE_AREA_ID = "hot-spot";
    private static final By CLICKABLE_AREA = By.id(CLICKABLE_AREA_ID);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

    public ContextMenuPage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElementId = CLICKABLE_AREA;
    }

    public void rightClick() {
        try {
            Actions action = new Actions(driver);
            WebElement clickableArea = driver.findElement(By.id(CLICKABLE_AREA_ID));
            action.moveToElement(clickableArea).contextClick().perform();
            System.out.println("Successfully Right clicked on the element");
        } catch (StaleElementReferenceException e) {
            System.out.println("There is no element on the page");
        }
    }

    public boolean isAlertDisplayed(){
        try {
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public String getAlertText(){
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        return alertText;
    }

}
