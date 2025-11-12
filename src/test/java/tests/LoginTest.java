package tests;

import base.BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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

    @AfterMethod
    public void tearDownTest(){
        tearDown();
    }




}
