package Git.Morele.Testing.Tests;

import Git.Morele.Testing.Components.NavigationMenu;
import Git.Morele.Testing.Pages.HomePage;
import Git.Morele.Testing.Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by simon on 10.03.2017.
 */
public class LoginTests extends TestConfiguration {
    HomePage homePage;
    String[] credentials = {"automationtesting@gmail.com","Automation123"};
    @Before
    public void runConf(){
        super.setUp();
    }


    @Before
    public void runHomepage() {
        homePage = new HomePage(driver);
        homePage.goTo();
    }

    @After
    public void tearDown(){
        driver.quit();
        }

    @Test
    public void CorrectLoginTest(){
        NavigationMenu menu = homePage.menu();
        LoginPage loginPage = menu.goToLoginPage();
        loginPage.logIn(credentials[0],credentials[1]);
        menu.AccountButtonText().contains("Witaj");
        menu.hoverMyAccount();
        menu.logOut();
        menu.AccountButtonText().contains("Zaloguj się");
    }
    @Test
    public void LoginWithoutUsernameTest(){
        LoginPage loginPage = homePage.menu().goToLoginPage();
        loginPage.logInWithoutLogin(credentials[1]);
        Assert.assertEquals("To pole nie może być puste!", loginPage.getUsernameMissedErrorText());
    }
    @Test
    public void LoginWithoutPasswordTest(){
        LoginPage loginPage = homePage.menu().goToLoginPage();
        loginPage.loginInWithoutPassword(credentials[1]);
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
        loginPage.logInWithWrongCred("simon17@gmail.com", credentials[1]);
        Assert.assertEquals("Dane logowania nie są poprawne. Zalogowanie nie powiodło się.", loginPage.getUncorrectLoginAlertText());
    }
    @Test
    public void LoginWithWrongPassword() {
        LoginPage loginPage = homePage.menu().goToLoginPage();
        loginPage.logInWithWrongCred(credentials[0], "pass123");
        Assert.assertEquals("Dane logowania nie są poprawne. Zalogowanie nie powiodło się.", loginPage.getUncorrectLoginAlertText());
    }



}


