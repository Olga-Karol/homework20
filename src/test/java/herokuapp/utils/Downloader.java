package herokuapp.utils;

import herokuapp.BaseTest;

import java.io.File;

public class Downloader extends BaseTest {

    public static boolean isFileDownloaded(String downloadedFileName) throws InterruptedException {
        boolean found = false;
        for (int i = 0; i < 10; i++) {
            File folder = new File(ABSOLUTE_RESOURCE_PATH);
            File[] listOfFiles = folder.listFiles();
            File f = null;
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile()) {
                    String fileName = listOfFile.getName();
                    System.out.println("File " + listOfFile.getName());
                    if (fileName.matches(downloadedFileName)) {
                        f = new File(fileName);
                        found = true;
                    }
                }
            }
            if (found) {
                break;
            }
            Thread.sleep(1000);
        }
        return found;
    }
}
