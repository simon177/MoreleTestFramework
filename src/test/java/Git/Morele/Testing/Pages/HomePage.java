package Git.Morele.Testing.Pages;

import Git.Morele.Testing.Components.NavigationMenu;
import Git.Morele.Testing.Utility.Constant;
import org.openqa.selenium.WebDriver;

/**
 * Created by simon on 10.03.2017.
 */
public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super.driver = driver;
    }

    public HomePage goTo(){
        driver.get(Constant.LINK);
        return this;
    }

    public NavigationMenu menu(){
        return new NavigationMenu(driver);
    }
}
