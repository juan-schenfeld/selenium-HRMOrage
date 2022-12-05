import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath="input[name='username']")
    private WebElement usernameField;
    @FindBy(xpath="input[name='password']")
    private WebElement passwordField;
    @FindBy(xpath="button[type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void defaultLogin(){
        login("Admin", "admin123");
    }

}
