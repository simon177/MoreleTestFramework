package Git.Morele.Testing.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import sun.rmi.runtime.Log;

/**
 * Created by simon on 10.03.2017.
 */
//Automationtesting@gmail.com
//Automation123
public class LoginPage extends BasePage {
    @FindBy(how = How.CSS, using = "#username")
    WebElement username;
    @FindBy(how = How.CSS, using = "#password")
    WebElement password;
    @FindBy(how = How.XPATH, using = "//button[contains(@class,'btn btn-red btn-lg btn-block')]")
    WebElement logInButton;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'form-item-validate installment-box-nb required checkEmail checkIllegalCharacters line-margin')]//div[contains(@class, 'error')]")
    WebElement userNameMissed;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'form-item-validate installment-box-nb required line-margin')]//div[contains(@class, 'error')]")
    WebElement passwordMissed;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'alert alert-danger')]")
    WebElement uncorrectLogin;

    public LoginPage(WebDriver driver) {
        super.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AfterLoginPage logIn(String userLogin, String userPassword){
        username.sendKeys(userLogin);
        password.sendKeys(userPassword);
        logInButton.click();
        return new AfterLoginPage(driver);
    }

    public LoginPage logInWithWrongCred(String userLogin, String userPassword){
        username.sendKeys(userLogin);
        password.sendKeys(userPassword);
        logInButton.click();
        return this;
    }


    public LoginPage logInWithoutLogin(String userPassword){
        password.sendKeys(userPassword);
        logInButton.click();
        return this;
    }
    public LoginPage loginInWithoutPassword(String userLogin){
        username.sendKeys(userLogin);
        logInButton.click();
        return this;
    }

    public LoginPage logInWithoutBoth(){
        logInButton.click();
        return this;
    }



    public String getUsernameMissedErrorText(){
        return userNameMissed.getText();
    }

    public String getPasswordMissedErrorText(){
        return passwordMissed.getText();
    }

    public String getUncorrectLoginAlertText(){
        return uncorrectLogin.getText();
    }


}
