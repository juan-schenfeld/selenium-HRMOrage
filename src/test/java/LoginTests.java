import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest{

    @Test
    public void defaultLogin(){
        boolean logged = homePage.defaultLogin().validateLogin();
        assertTrue(logged);
    }






}
