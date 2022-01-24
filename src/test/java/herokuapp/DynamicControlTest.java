package herokuapp;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static wep.pages.DynamicControlPage.CHECKBOX;


public class DynamicControlTest extends BaseTest{

    private final By REMOVE_BUTTON = By.xpath("//form[@id='checkbox-example']//button[text()='Remove']");
    private final By ENABLE_BUTTON = By.xpath("//form[@id='input-example']/button[text()='Enable']");
    private final By INPUT_FIELD = By.xpath("//form[@id='input-example']/input");

   public void openPage(){
       dynamicControlPage.open();
       Assert.assertTrue(dynamicControlPage.isPageLoaded(), "Page doesn't open");
   }

    @Test
    public void removeCheckboxTest(){
        openPage();
        driver.findElement(REMOVE_BUTTON).click();
        dynamicControlPage.isElementAppeared();
        Assert.assertEquals(
                 dynamicControlPage.getMessageText(),
                "It's gone!",
                "Text doesn't appear or doesn't match"
                );
        Assert.assertFalse(dynamicControlPage.isElementDisplayed(CHECKBOX), "Checkbox is available");
    }

    @Test
    public void isInputDisabledTest(){
       openPage();
       Assert.assertFalse(driver.findElement(INPUT_FIELD).isEnabled(), "Input field is enable");
    }

    @Test
    public void enableInputTest(){
       openPage();
       driver.findElement(ENABLE_BUTTON).click();
       dynamicControlPage.isElementAppeared();
       Assert.assertEquals(
                dynamicControlPage.getMessageText(),
               "It's enabled!",
               "Text doesn't appear or doesn't match"
               );
       Assert.assertTrue(driver.findElement(INPUT_FIELD).isEnabled(), "Input field disable");
    }
}
