package seleniumTst.steps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumTst.page.DashboardPage;
import seleniumTst.utils.WebDriverFactory;
import seleniumtest.page.DashboardPage;
import seleniumtest.page.MyAcountPage;
import seleniumtest.utils.WebDriverFactory;


public class DashboardSteps {
    private static DashboardPage dashboardPage;
    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver(), 3);

    public DashboardSteps() {
        dashboardPage = new DashboardPage();
    }

    @Given("^we hover over '(.+?)'$")
    public void weHoverOverComputers(String aTag) {
        Actions actions = new Actions(WebDriverFactory.getInstance().getDriver());
        switch (aTag) {
            case "computers":
                actions.moveToElement(dashboardPage.computerA).build().perform();
                break;
        }
    }

    @Then("^we click '(.+?)' dropdown$")
    public void weClickNotebooksDropdown(String name) {
        switch (name) {
            case "notebooks":
                wait.until(ExpectedConditions.visibilityOf(dashboardPage.netbooksA));
                dashboardPage.netbooksA.click();
                break;
        }

    }

    @Then("^we verify that the current page title is '(.+?)'$")
    public void weVerifyThatTheCurrentPageTitleIsNopCommerceDemoStoreNotebooks(String string) {
        dashboardPage.verifyTitle(string);
    }

    @Then("^we set the pageSize to '(.+?)'$")
    public void weSetThePageSizeTo(String size) {
        dashboardPage.setPageSize(size);
    }

    @Given("^the number of elements is '(\\d+)'$")
    public void theNumberOfElementsIs(int num) {
        dashboardPage.verifyNumberOfItems(num);

    }
}
