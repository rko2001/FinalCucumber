package seleniumTst.steps;
import cucumber.api.java.en.Given;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumTst.page.MyAccountPage;
import seleniumTst.utils.WebDriverFactory;
import seleniumtest.page.LogInPage;
import seleniumtest.page.MyAcountPage;
import seleniumtest.utils.WebDriverFactory;

public class MyAccountSteps {
    private static MyAccountPage myAcountPage;
    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver(), 3);

    public MyAccountSteps() {
        myAcountPage = new MyAccountPage();
    }
    @Given("^the field '(.+?)' has the value '(.+?)'$")
    public void theFieldFirstNameHasTheValueName(String input,String value) {
        myAcountPage.assertInputValues(input,value);
    }

    @Given("^the date corresponds to '(.+?)','(.+?)','(.+?)'$")
    public void theDateCorrespondsToMay(String day , String month ,String year) {
        myAcountPage.assertDate(day,month,year);
    }

    @Given("^Go to My Account$")
    public void goToMyAccount() {
        myAcountPage.clickMyAccount();
        wait.until(ExpectedConditions.visibilityOf(myAcountPage.newsletter));
    }

}
