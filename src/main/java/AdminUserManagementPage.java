import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminUserManagementPage extends NavBar{

    @FindBy(xpath="//button[contains(string(), ' Add')]")
    private WebElement addUserButton;
    public AdminUserManagementPage(WebDriver driver) {
        super(driver);
    }

    public AddUserPage addUser(){
        visibilityOf(addUserButton).click();
        return new AddUserPage(driver);
    }


    public static class AddUserPage extends BasePage{

        @FindBy(xpath="//label[string()='User Role']/../../div[2]")
        private WebElement userRoleSelect;
        @FindBy(xpath="//label[string()='Employee Name']/../..//input")
        private WebElement employeeNameField;
        @FindBy(xpath="//label[string()='Status']/../../div[2]")
        private WebElement statusSelect;
        @FindBy(xpath="//label[string()='Username']/../..//input")
        private WebElement usernameField;
        @FindBy(xpath="//label[string()='Password']/../..//input")
        private WebElement passwordField;
        @FindBy(xpath="//label[string()='Confirm Password']/../..//input")
        private WebElement confirmPasswordField;
        @FindBy(xpath="//button[@type='submit']")
        private WebElement saveButton;

        public AddUserPage(WebDriver driver) {
            super(driver);
        }

        public AddUserPage selectUserRole(String  userRole){
            visibilityOf(userRoleSelect).click();
            driver.findElement(By.xpath("//div[@role='option']/span[contains(string(), '" + userRole +"')]")).click();
            return this;
        }

        public AddUserPage setEmployeeName(String employeeName){
            employeeNameField.sendKeys(employeeName);
            return this;
        }

        public AddUserPage setStatus(String  userStatus){
            visibilityOf(statusSelect).click();
            driver.findElement(By.xpath("//div[@role='option']/span[contains(string(), '" + userStatus +"')]")).click();
            return this;
        }

        public AddUserPage setUsername(String username){
            usernameField.sendKeys(username);
            return this;
        }

        public AddUserPage setPassword(String password){
            passwordField.sendKeys(password);
            return this;
        }

        public AddUserPage setConfirmPassword(String password){
            confirmPasswordField.sendKeys(password);
            return this;
        }

        public void clickSave(){
            saveButton.click();
        }




    }
}
