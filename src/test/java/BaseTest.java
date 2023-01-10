import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    private RemoteWebDriver driver;
    protected LoginPage homePage;
    private ChromeOptions options;

    private void getDriver(String remote){
        if(!remote.equals("false")){
            getRemoteDriver();
        } else {
            getLocalDriver();
        }
    }
    private void getLocalDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        homePage = new LoginPage(driver);
    }

    private void getRemoteDriver(){
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/"), getChromeOptions("false"));
            driver.setFileDetector(new LocalFileDetector());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        homePage = new LoginPage(driver);
    }

    @BeforeMethod
    @Parameters({"remote","headless"})
    public void setUp(@Optional(value = "false") String remote, @Optional(value = "false") String headless){
        options = getChromeOptions(headless);
        getDriver(remote);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    private ChromeOptions getChromeOptions(String headless){
        ChromeOptions options = new ChromeOptions();
        if (!headless.equals("false")){
            options.setHeadless(true);
        }
        return options;
    }
}
