package herokuapp;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest{

    public static final String LOADED_FILE_NAME = "test.txt";

    public void openPage(){
        uploaderFilePage.open();
        Assert.assertTrue(uploaderFilePage.isPageLoaded(), "Page doesn't open");
    }

    @Test
    public void uploadFileTest(){
        openPage();
        uploaderFilePage.uploadFileProcess();
        uploaderFilePage.isFileUploaded();
        Assert.assertEquals(
                uploaderFilePage.getFileName(),
                LOADED_FILE_NAME,
                "File name on page doesn't match to loaded file name"
        );
    }
}
