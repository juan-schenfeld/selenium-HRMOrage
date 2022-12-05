import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest{

    @Test
    public void testDefaultLogin(){
        boolean logged = homePage.defaultLogin().validateLogin();
        assertTrue(logged);
    }
}
