package herokuapp;

/*    Открыть iFrame
    Проверить, что текст внутри параграфа равен “Your content goes here.”*/

import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest{

    public void openPage(){
      iFramePage.open();
      Assert.assertTrue(iFramePage.isPageLoaded(), "Page doesn't open");
    }

    @Test
    public void checkEditorTextTest(){
        openPage();
        Assert.assertEquals(
                iFramePage.getEditorText(),
                "Your content goes here.",
                "Text does not match"
        );
    }
}
