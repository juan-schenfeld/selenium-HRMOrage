import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath="//input[@name='username']")
    private WebElement usernameField;
    @FindBy(xpath="//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath="//button[@type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public DashboardPage login(String username, String password){
        visibilityOf(usernameField).sendKeys(username);
        visibilityOf(passwordField).sendKeys(password);
        loginButton.click();
        return new DashboardPage(driver);
    }

    public DashboardPage defaultLogin(){
        return login("Admin", "admin123");
    }

}
