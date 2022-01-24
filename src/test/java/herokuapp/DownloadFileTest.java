package herokuapp;

import org.testng.Assert;
import org.testng.annotations.Test;

import static herokuapp.utils.Downloader.isFileDownloaded;

public class DownloadFileTest extends BaseTest{

    public static final String DOWNLOADED_FILE_NAME = "sample.png";

    public void openPage(){
        downloadFilePage.open();
        Assert.assertTrue(downloadFilePage.isPageLoaded(), "Page doesn't open");
    }

    @Test
    public void downloadFileTest() throws InterruptedException {
        openPage();
        downloadFilePage.downloadFile(DOWNLOADED_FILE_NAME);
        Assert.assertTrue(
                isFileDownloaded(DOWNLOADED_FILE_NAME),
                "Downloaded file is not found"
        );
        downloadFilePage.removeDownloadedFile(DOWNLOADED_FILE_NAME);
    }
}

