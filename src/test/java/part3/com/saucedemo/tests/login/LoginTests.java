package part3.com.saucedemo.tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.com.saucedemo.base.BaseTest;

public class LoginTests extends BaseTest {
    @Test
    public void testLoginErrorMessage() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("xyz121");
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains("Epic sadface"));
    }
}
