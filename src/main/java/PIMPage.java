import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class PIMPage extends NavBar{

    @FindBy(xpath="//button[contains(string(), ' Add')]")
    private WebElement addEmployeeButton;

    public PIMPage(WebDriver driver) {
        super(driver);
    }

    public AddEmployeePage addEmployeePage(){
        visibilityOf(addEmployeeButton).click();
        return new AddEmployeePage(driver);
    }

    public static class AddEmployeePage extends NavBar {

        @FindBy(name="firstName")
        private WebElement firstNameField;
        @FindBy(name="middleName")
        private WebElement middleNameField;
        @FindBy(name="lastName")
        private WebElement lastNameField;
        @FindBy(xpath="//label[string()='Employee Id']/../../div[2]/input")
        private WebElement idField;
        @FindBy(xpath="//input[@type='checkbox']/..")
        private WebElement createLoginCredentialsCheckbox;

        @FindBy(xpath="//label[string()='Username']/../..//input")
        private WebElement usernameField;
        @FindBy(xpath="//label[string()='Password']/../..//input")
        private WebElement passwordField;
        @FindBy(xpath="//label[string()='Confirm Password']/../..//input")
        private WebElement confirmPasswordField;
        @FindBy(xpath="//input[@type='file']")
        private WebElement photoInput;
        @FindBy(xpath="//button[@type='submit']")
        private WebElement saveButton;

        @FindBy(xpath="//label[string()='Enabled']/input")
        private WebElement enableSwitch;
        @FindBy(xpath="//label[string()='Disabled']/input")
        private WebElement disableSwitch;


        public AddEmployeePage(WebDriver driver) {
            super(driver);
        }

        public AddEmployeePage fillFullName(String firstname, String lastname){
            sendKeys(firstNameField,firstname);
            sendKeys(lastNameField,lastname);
            return this;
        }
        public AddEmployeePage fillFullName(String firstname,String middleName, String lastname){
            fillFullName(firstname, lastname);
            sendKeys(middleNameField,middleName);
            return this;
        }

        public AddEmployeePage setId(String  id){
            sendKeys(idField, id);
            return this;
        }

        public AddEmployeePage clickLoginDetailsCheckbox(){
            click(createLoginCredentialsCheckbox);
            return this;
        }

        public AddEmployeePage setUsername(String username){
            sendKeys(usernameField,username);
            return this;
        }

        public AddEmployeePage setStatusEnabled(){
            click(enableSwitch);
            return this;
        }

        public AddEmployeePage setStatusDisabled(){
            click(disableSwitch);
            return this;
        }

        public AddEmployeePage setPassword(String password){
            sendKeys(passwordField,password);
            return this;
        }

        public AddEmployeePage confirmPassword(String password){
            sendKeys(confirmPasswordField,password);
            return this;
        }

        public AddEmployeePage addPhoto(File photo){
            photoInput.sendKeys(photo.getAbsolutePath());
            return this;
        }

        public boolean theEmployeeHasAdded(){
            return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlContains("pim/viewPersonalDetails/empNumber"));
        }

        public EmployeePersonalDetailsPage clickSave(){
            click(saveButton);
            return new EmployeePersonalDetailsPage(driver);
        }

    }
}
