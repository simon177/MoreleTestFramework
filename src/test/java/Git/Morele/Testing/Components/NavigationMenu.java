package Git.Morele.Testing.Components;

import Git.Morele.Testing.Pages.HomePage;
import Git.Morele.Testing.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by simon on 10.03.2017.
 */
public class NavigationMenu {
    @FindBy(how= How.CLASS_NAME, using = "userAccount")
    WebElement accountButton;
    WebDriver driver;
    @FindBy(how=How.CLASS_NAME, using = "logout")
    WebElement logoutButton;

    public NavigationMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String AccountButtonText(){
        return accountButton.getText();
    }


    public LoginPage goToLoginPage(){
        accountButton.click();
        return new LoginPage(driver);
    }

    public void hoverMyAccount(){
        Actions action = new Actions(driver);
        action.moveToElement(accountButton).build().perform();
    }

    public HomePage logOut(){
        hoverMyAccount();
        logoutButton.click();
        return new HomePage(driver);
    }


}
