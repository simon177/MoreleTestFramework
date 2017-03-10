package Git.Morele.Testing.Pages;

import Git.Morele.Testing.Components.NavigationMenu;
import org.openqa.selenium.WebDriver;

/**
 * Created by simon on 10.03.2017.
 */
public class HomePage extends BasePage {
    private static final String LINK = "https://www.morele.net/";

    public HomePage(WebDriver driver){
        super.driver = driver;
    }

    public HomePage goTo(){
        driver.get(LINK);
        return this;
    }

    public NavigationMenu menu(){
        return new NavigationMenu(driver);
    }
}
