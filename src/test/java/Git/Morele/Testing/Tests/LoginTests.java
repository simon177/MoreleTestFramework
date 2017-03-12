package Git.Morele.Testing.Tests;

import Git.Morele.Testing.Components.NavigationMenu;
import Git.Morele.Testing.Pages.AfterLoginPage;
import Git.Morele.Testing.Pages.HomePage;
import Git.Morele.Testing.Pages.LoginPage;
import Git.Morele.Testing.Utility.Constant;
import Git.Morele.Testing.Utility.ExcelFilesHandle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by simon on 10.03.2017.
 */
public class LoginTests extends TestConfiguration {
    HomePage homePage;

    @BeforeClass
    public void runConf() throws IOException {
        super.setUp();
    }


    @BeforeMethod
    public void runHomepage() {
        homePage = new HomePage(driver);
        homePage.goTo();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        }

    @Test
    public void CorrectLoginTest() {
        LoginPage loginPage = homePage.menu().goToLoginPage();
        AfterLoginPage userbase = loginPage.logIn(usernameFromFile,passwordFromFile);
        Assert.assertTrue(userbase.menu().AccountButtonText().contains("Witaj"));
        System.out.println(userbase.menu().AccountButtonText());
        userbase.menu().hoverMyAccount();
        userbase.menu().logOut();
        System.out.println(homePage.menu().AccountButtonText());
        Assert.assertTrue(homePage.menu().AccountButtonText().contains("Zaloguj się"));
    }
   @Test
    public void LoginWithoutUsernameTest(){
        LoginPage loginPage = homePage.menu().goToLoginPage();
        loginPage.logInWithoutLogin(passwordFromFile);
        Assert.assertEquals("To pole nie może być puste!", loginPage.getUsernameMissedErrorText());
    }
    @Test
    public void LoginWithoutPasswordTest(){
        LoginPage loginPage = homePage.menu().goToLoginPage();
        loginPage.loginInWithoutPassword(usernameFromFile);
        Assert.assertEquals("To pole nie może być puste!", loginPage.getPasswordMissedErrorText());
    }
    @Test
    public void LoginWithoutBothTest(){
        LoginPage loginPage = homePage.menu().goToLoginPage();
        loginPage.logInWithoutBoth();
        Assert.assertEquals("To pole nie może być puste!", loginPage.getUsernameMissedErrorText());
        Assert.assertEquals("To pole nie może być puste!", loginPage.getPasswordMissedErrorText());
    }
    @Test
    public void LoginWithWrongUsername() {
        LoginPage loginPage = homePage.menu().goToLoginPage();
        loginPage.logInWithWrongCred("simon17@gmail.com", passwordFromFile);
        Assert.assertEquals("Dane logowania nie są poprawne. Zalogowanie nie powiodło się.", loginPage.getUncorrectLoginAlertText());
    }
    @Test
    public void LoginWithWrongPassword() {
        LoginPage loginPage = homePage.menu().goToLoginPage();
        loginPage.logInWithWrongCred(usernameFromFile, "pass123");
        Assert.assertEquals("Dane logowania nie są poprawne. Zalogowanie nie powiodło się.", loginPage.getUncorrectLoginAlertText());
    }
}



