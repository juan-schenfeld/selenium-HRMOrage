import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RemoveEmployeeTests extends BaseTest {

    @Test
    public void addAndDeleteEmployee(){
        String firstName = "Luke";
        String middleName = "";
        String lastName = "Skywalker";
        File photo = new File("src/test/resources/luke.skywalker.jpeg");
        var AddEmployeePage = homePage.defaultLogin().goToPIM().addEmployeePage()
                .setId("1000")
                .fillFullName(firstName, middleName, lastName).addPhoto(photo);
        var employeeDetailsPage = AddEmployeePage.clickSave();
        assertTrue(AddEmployeePage.theEmployeeHasAdded());
        assertEquals(employeeDetailsPage.getEmployeeFullName(), firstName + " " + lastName);

        employeeDetailsPage.goToPIM().deleteEmployee("1000");
    }


}
