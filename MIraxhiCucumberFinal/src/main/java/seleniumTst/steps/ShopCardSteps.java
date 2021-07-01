package seleniumTst.steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumTst.page.ShoppingCardPage;
import seleniumTst.utils.WebDriverFactory;
import seleniumtest.page.RegistrationPage;
import seleniumtest.page.ShoppingCardPage;
import seleniumtest.utils.WebDriverFactory;


public class ShopCardSteps {
    private static ShoppingCardPage shoppingCardPage;
    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver(), 3);
    public ShopCardSteps() {
        shoppingCardPage = new ShoppingCardPage();
    }
    @Given("^The subtotals and the total match$")
    public void theSubtotalsAndTheTotalMatch() {
        shoppingCardPage.checkTotal();
    }

    @Given("^we go to shopping card page$")
    public void weGoToShoppingCardPage() throws InterruptedException {
        shoppingCardPage.goToCardPage();
    }

    @Then("^delete '(\\d+)' elements from the shopping Card$")
    public void deleteElementsFromTheShoppingCard(int arg0) {
        shoppingCardPage.deleteElementsFromCard(arg0);
    }

    @Then("^Quit$")
    public void quit() {
        shoppingCardPage.quit();
    }

}
