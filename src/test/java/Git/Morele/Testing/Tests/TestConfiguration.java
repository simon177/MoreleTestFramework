package Git.Morele.Testing.Tests;

import Git.Morele.Testing.Pages.HomePage;
import Git.Morele.Testing.Utility.Constant;
import Git.Morele.Testing.Utility.ExcelFilesHandle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by simon on 10.03.2017.
 */
public class TestConfiguration {
    WebDriver driver;
    HomePage homePage;
    String usernameFromFile;
    String passwordFromFile;


    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ExcelFilesHandle.getExcelFile(Constant.CredentialSheetPath,"CredentialsSheet");
        usernameFromFile=ExcelFilesHandle.getData(1,1);
        passwordFromFile=ExcelFilesHandle.getData(1,2);
    }

    public void goToHompage() {
        homePage = new HomePage(driver);
        homePage.goTo();
    }

}
