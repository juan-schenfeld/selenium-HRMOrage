import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavBar extends BasePage {

    @FindBy(xpath="//a[contains(@href, 'viewAdminModule')]")
    private WebElement adminPageButton;
    public NavBar(WebDriver driver) {
        super(driver);
    }


    public AdminUserManagementPage goToUserManagement(){
        visibilityOf(adminPageButton).click();
        return new AdminUserManagementPage(driver);
    }

}
