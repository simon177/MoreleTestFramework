package Git.Morele.Testing.Pages;

import Git.Morele.Testing.Components.NavigationMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import javax.naming.directory.SearchResult;

/**
 * Created by simon on 13.03.2017.
 */
public class SearchResultPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//a[contains(@href, '/basket/add/584122')]")
    WebElement searchElement;
    public SearchResultPage(WebDriver driver){
        super.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public NavigationMenu menu(){
        return new NavigationMenu(driver);
    }

    public SearchResultPage addToCart(){
        searchElement.click();
        return new SearchResultPage(driver);
    }


}
