import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddEmployeeTests extends BaseTest{

    @Test
    public void testAddEmployeeWithCredentials(){
        String firstName = "Bruno";
        String middleName = "";
        String lastName = "Diaz";

        File photo = new File("src/test/resources/bruno.diaz.jpg");
        var AddEmployeePage = homePage.defaultLogin().goToPIM().addEmployeePage()
                .fillFullName(firstName, middleName, lastName)
                .setId("999").addPhoto(photo)
                .clickLoginDetailsCheckbox().setUsername("bruno.diaz")
                .setPassword("Qwerty1@").confirmPassword("Qwerty1@");
        var employeeDetailsPage = AddEmployeePage.clickSave();
        assertTrue(AddEmployeePage.theEmployeeHasAdded());
        assertEquals(employeeDetailsPage.getEmployeeFullName(), firstName + " " + lastName);
    }

    @Test
    public void testAddEmployeeWithoutCredentials(){
        String firstName = "Luke";
        String middleName = "";
        String lastName = "Skywalker";
        File photo = new File("src/test/resources/luke.skywalker.jpeg");
        var AddEmployeePage = homePage.defaultLogin().goToPIM().addEmployeePage()
                .fillFullName(firstName, middleName, lastName)
                .setId("").addPhoto(photo);
        var employeeDetailsPage = AddEmployeePage.clickSave();
        assertTrue(AddEmployeePage.theEmployeeHasAdded());
        assertEquals(employeeDetailsPage.getEmployeeFullName(), firstName + " " + lastName);
    }

}
