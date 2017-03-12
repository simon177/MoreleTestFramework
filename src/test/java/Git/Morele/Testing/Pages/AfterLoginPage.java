package Git.Morele.Testing.Pages;

import Git.Morele.Testing.Components.NavigationMenu;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by simon on 10.03.2017.
 */
public class AfterLoginPage extends BasePage {

    public AfterLoginPage(WebDriver driver){
        super.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public NavigationMenu menu(){
        return new NavigationMenu(driver);
    }

}
