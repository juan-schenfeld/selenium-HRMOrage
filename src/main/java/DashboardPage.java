import org.openqa.selenium.WebDriver;

public class DashboardPage extends NavBar {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean validateLogin(){
        return driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }
}
