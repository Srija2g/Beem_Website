package tests;

import base.BaseClass;
import org.testng.annotations.*;
import pages.LoginPage;

public class LoginTest extends BaseClass {
    LoginPage loginPage;

    @BeforeMethod
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

    @Test
    public void tryLoginWithValidCredentials(){
        loginPage.loginWithValidCredentials();
    }

    @Test
    public void tryLoginWithInvalidCredentials(){
        loginPage.loginWithInvalidCredentials();
    }

    @AfterMethod
    public void tearDownTest(){
        tearDown();
    }
}
