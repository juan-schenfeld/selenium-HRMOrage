import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeePersonalDetailsPage extends NavBar{

    @FindBy(xpath="//img[@alt='profile picture']/../../..//h6")
    private WebElement fullNameText;
    @FindBy(name="firstName")
    private WebElement employeeFirsNameField;
    @FindBy(name="middleName")
    private WebElement employeeMiddleNameField;
    @FindBy(name="lastName")
    private WebElement employeeLastNameField;

    public EmployeePersonalDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getEmployeeFullName(){
        String fullName = "";
        int iterations = 0;
        while (fullName.equals("") || iterations<20){
            iterations++;
            fullName = getText(fullNameText);
        }
        return fullName;
    }
}
