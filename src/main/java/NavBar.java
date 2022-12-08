import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class NavBar extends BasePage {

    @FindBy(xpath="//a[string()='Admin']")
    private WebElement adminPageButton;
    @FindBy(xpath="//a[string()='PIM']")
    private WebElement pIMPageButton;


    public NavBar(WebDriver driver) {
        super(driver);
    }


    public AdminUserManagementPage goToUserManagement(){
        visibilityOf(adminPageButton).click();
        return new AdminUserManagementPage(driver);
    }

    public PIMPage goToPIM(){
        visibilityOf(pIMPageButton).click();
        return new PIMPage(driver);
    }

}
