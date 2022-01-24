package herokuapp;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ContextMenuTest extends BaseTest {

    public void openPage(){
        contextMenuPage.open();
        Assert.assertTrue(contextMenuPage.isPageLoaded(), "Page doesn't open");
    }

    @Test
    public void checkAlertTextTest() {
        openPage();
        contextMenuPage.rightClick();
        contextMenuPage.isAlertDisplayed();
        Assert.assertEquals(
                contextMenuPage.getAlertText(),
                "You selected a context menu",
                "Alert text does not match"
        );
    }
}
