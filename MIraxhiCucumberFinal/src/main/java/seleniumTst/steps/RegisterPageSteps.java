package seleniumTst.steps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumTst.page.RegistrationPage;
import seleniumTst.utils.WebDriverFactory;
import seleniumtest.page.LogInPage;
import seleniumtest.page.RegistrationPage;
import seleniumtest.utils.WebDriverFactory;

public class RegisterPageSteps {
    private static RegistrationPage registrationPage;
    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver(), 3);
    public RegisterPageSteps() {
        registrationPage = new RegistrationPage();
    }
    @And("^we type '(.+?)' in the '(.+?)' input$")
    public void weTypeNameInTheFirstNameInput(String value,String label) {
        registrationPage.fillInput(label,value);
    }

    @And("^we fill the date with '(.+?)','(.+?)','(.+?)' in the dropDowns$")
    public void weFillTheDateWithMayInTheDropDowns(String day,String month,String year ) {
        registrationPage.fillDate(day,month,year);
    }

    @And("^we click '(.+?)' button$")
    public void weClickRegisterButton(String name) {
        registrationPage.clickButton(name);
    }

    @Then("^check if following text '(.+?)' is shown$")
    public void checkIfFollowingTextIsShown(String text) throws InterruptedException {

        registrationPage.isRegCompleted(text);

    }

}
