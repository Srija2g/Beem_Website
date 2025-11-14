package tests;

import base.BaseClass;
import org.testng.annotations.*;
import pages.LoginPage;

public class LoginTest extends BaseClass {
    LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        initializeDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void verifyRedirectionWhenClickedOnLoginButton(){
        loginPage.loginButtonClickable();
    }

    @Test
    public void tryLoginWithoutCredentials() throws InterruptedException {
        loginPage.loginWithoutCredentials();
    }

    @AfterClass
    public void tearDownTest(){
        tearDown();
    }
}
