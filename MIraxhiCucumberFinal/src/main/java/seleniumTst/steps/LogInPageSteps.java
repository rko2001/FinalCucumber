package seleniumTst.steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumTst.page.LogInPage;
import seleniumTst.utils.WebDriverFactory;
import seleniumtest.page.LogInPage;
import seleniumtest.page.NopHomePage;
import seleniumtest.utils.WebDriverFactory;

public class LogInPageSteps {
    private static LogInPage logInPage;
    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver(), 3);
    public LogInPageSteps() {
        logInPage = new LogInPage();
    }
    @Given("^go to '(.+?)'$")
    public void goToHttpsDemoNopcommerceCom( String url) {
        WebDriverFactory.getInstance().getDriver().navigate().to(url);

    }

    @Then("^click '(.+?)'$")
    public void clickLogIn(String button) {
        logInPage.clickButton(button);
    }

}
