package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;


public class AppLaunchTest extends BaseTest {


    @Test
    public void verifyValidLogin() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoginScreen();
        loginPage.login("9995555555", "258814");
        System.out.println("Login flow executed successfully.");
    }
}