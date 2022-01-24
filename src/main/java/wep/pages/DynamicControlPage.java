package wep.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControlPage extends BasePage{

    public static final String BASE_URL = "http://the-internet.herokuapp.com/dynamic_controls";
    public static final By CHECKBOX = By.id("checkbox");
    private static final By MESSAGE = By.cssSelector("p#message");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public DynamicControlPage(WebDriver driver) {
        super(driver);
        this.baseUrl = BASE_URL;
        this.basePageElementId = CHECKBOX;
    }

    public boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("There is no element on the page");
        }
        return false;
    }

    public boolean isElementAppeared() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE));
        } catch (NoSuchElementException e) {
            System.out.println("The element didn't appear");
        }
        return false;
    }

    public String getMessageText() {
        return driver.findElement(MESSAGE).getText();
    }
}
