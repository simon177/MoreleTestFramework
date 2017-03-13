package Git.Morele.Testing.Tests;

import Git.Morele.Testing.Pages.SearchResultPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by simon on 13.03.2017.
 */
public class CartTest extends TestConfiguration {

    @BeforeClass
    public void runConf() throws IOException {
        super.setUp();
    }


    @BeforeMethod
    public void runHomepage() {
        super.goToHompage();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void addingToAcartTest(){
        SearchResultPage resultPage = homePage.menu().searchFor("Intel Core i5", "Komputery");
        resultPage.addToCart();

    }
}
