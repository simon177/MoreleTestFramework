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
    @FindBy(how = How.XPATH, using = "(//div[@class='addToBasket']/a)[1]")
    WebElement addFirstToBasket;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class, 'full-name hidden-xs')]/a)[1]")
    WebElement firstElTitle;
    public SearchResultPage(WebDriver driver){
        super.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public NavigationMenu menu(){
        return new NavigationMenu(driver);
    }

    public ConfirmationPage addToCart(){
        addFirstToBasket.click();
        return new ConfirmationPage(driver);
    }

    public ProductPage clickFirstElement(){
        firstElTitle.click();
        return new ProductPage(driver);
    }


    public String getElementTitle(){
        return firstElTitle.getText();
    }


}
