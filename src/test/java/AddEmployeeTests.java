import org.testng.annotations.Test;

public class AddEmployeeTests extends BaseTest{

    @Test
    public void testAddEmployeeWithCredentials(){
        homePage.defaultLogin().goToPIM().addEmployeePage()
                .fillFullName("Bruno", "Diaz")
                .clickLoginDetailsCheckbox().setUsername("bruno.diaz")
                .setId("999")
                .setPassword("Qwerty1@").confirmPassword("Qwerty1@")
                .clickSave();
    }

}
