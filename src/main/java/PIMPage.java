import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    @FindBy(xpath="//button[contains(string(),'Delete Selected')]")
    private WebElement deleteSelectedButton;
    @FindBy(xpath="//button[contains(string(), ' Yes, Delete ')]")
    private WebElement confirmDeletionButton;
    @FindBy(xpath="//div[contains(string(), 'Employee Id')]/../div/input")
    private WebElement employeeIdField;
    @FindBy(xpath="//button[string()=' Search ']")
    private WebElement searchButton;

    public PIMPage(WebDriver driver) {
        super(driver);
    }

    public AddEmployeePage addEmployeePage(){
        visibilityOf(addEmployeeButton).click();
        return new AddEmployeePage(driver);
    }


    public PIMPage searchEmployeeById(String id){
        sendKeys(employeeIdField, id);
        click(searchButton);
        return this;
    }
    public PIMPage deleteEmployee(String id){
        searchEmployeeById(id);
        presenceOfElementLocated(By.xpath("//div[contains(string(), '"+ id +"')]/../../div/div/div/label/span/i ")).click();
        click(deleteSelectedButton);
        click(confirmDeletionButton);
        return this;
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
            sendKeys(idField, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, id);
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
