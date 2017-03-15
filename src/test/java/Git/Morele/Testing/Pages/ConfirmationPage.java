package Git.Morele.Testing.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by simon on 15.03.2017.
 */
public class ConfirmationPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'cs-site')]")
    WebElement confirmationText;
    public ConfirmationPage(WebDriver driver){
        super.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getConfirmText(){
        return confirmationText.getText();
    }
}
