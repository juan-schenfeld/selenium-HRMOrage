import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private WebDriver driver;
    protected LoginPage homePage;

    private void getDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(getChromeOptions());
        homePage = new LoginPage(driver);
    }

    @BeforeMethod
    public void setUp(){
        getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    private ChromeOptions getChromeOptions(){
        return new ChromeOptions()
                .setHeadless(true);
    }
}
