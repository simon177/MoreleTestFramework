package Git.Morele.Testing.Components;

import Git.Morele.Testing.Pages.HomePage;
import Git.Morele.Testing.Pages.LoginPage;
import Git.Morele.Testing.Pages.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by simon on 10.03.2017.
 */
public class NavigationMenu {
    WebDriver driver;
    @FindBy(how= How.CLASS_NAME, using = "userAccount")
    WebElement accountButton;
    @FindBy(how = How.XPATH, using = "//li[contains(@class, 'logout')]/a")
    WebElement logoutButton;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'autocompl default')]//input")
    WebElement searchInput;
    @FindBy(how = How.XPATH, using = "//button[contains(@class,'btn btn-searchCategory btn-block dropdown-button')]")
    WebElement searchdropdown;
    @FindBy(how = How.XPATH, using ="//div[contains(@class, 'list')]/ul/li")
    List<WebElement> webElementList;
    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'btn btn-primary btnSearch')]//i[contains(@class, 'icon-morele-search')]")
    WebElement searchButton;





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


    public SearchResultPage searchFor(String product, String section) {
        searchdropdown.click();
        dropdownHandler(section);
        searchInput.sendKeys(product);
        searchButton.click();
        return new SearchResultPage(driver);
    }

    public void dropdownHandler(String section){
        for(int i=0; i<webElementList.size();i++){
            System.out.println(webElementList.get(i).getText());
            if (webElementList.get(i).getText().equals(section)){
                String choice = webElementList.get(i).getAttribute("data-value");
                driver.findElement(By.xpath("//div[contains(@class,'list')]/ul/li[contains(@data-value, '"+choice+"')]")).click();
                break;
            }
            }
        }

    }

