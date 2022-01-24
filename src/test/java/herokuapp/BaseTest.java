package herokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import wep.pages.*;

import java.io.File;
import java.util.HashMap;


public abstract class BaseTest {

    protected WebDriver driver;
    protected ContextMenuPage contextMenuPage;
    protected DynamicControlPage dynamicControlPage;
    protected UploaderFilePage uploaderFilePage;
    protected iFramePage iFramePage;
    protected DownloadFilePage downloadFilePage;
    public static final File RESOURCE_PATH_FILE = new File("src/test/resources");
    public static final String ABSOLUTE_RESOURCE_PATH = RESOURCE_PATH_FILE.getAbsolutePath();


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-popup-blocking");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("-incognito");
        driver = new ChromeDriver(chromeOptions);
        //chromeOptions.addArguments("--headless");


        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", ABSOLUTE_RESOURCE_PATH);
        chromeOptions.setExperimentalOption("prefs", chromePrefs);


        contextMenuPage = new ContextMenuPage(driver);
        dynamicControlPage = new DynamicControlPage(driver);
        uploaderFilePage = new UploaderFilePage(driver);
        iFramePage = new iFramePage(driver);
        downloadFilePage = new DownloadFilePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
