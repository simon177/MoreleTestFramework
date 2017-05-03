package Git.Morele.Testing.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by simon on 02.05.2017.
 */
public class ProductPage extends BasePage
{
    @FindBy(how= How.CLASS_NAME, using = "page-title")
    WebElement pageTitle;
    @FindBy(how=How.CLASS_NAME, using = "add-to-basket")
    WebElement addToCartButton;
    @FindBy(how=How.XPATH, using = "//button[contains(@class,'btn btn-red confirm')]")
    WebElement skipButton;
    public ProductPage(WebDriver driver){
        super.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getElementTitle(){
        return pageTitle.getText();
}
    public ProductPage addToAcart(){
        addToCartButton.click();
        return this;
    }
    public ConfirmationPage goToBasket(){
        skipButton.click();
        return new ConfirmationPage(driver);
    }

}
