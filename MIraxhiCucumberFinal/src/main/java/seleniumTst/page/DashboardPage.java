package seleniumTst.page;
import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import seleniumTst.utils.DashboardElements;
import seleniumTst.utils.WebDriverFactory;
import seleniumtest.utils.DashboardRepo;
import seleniumtest.utils.DriverUtils;
import seleniumtest.utils.WebDriverFactory;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class DashboardPage {
    @FindBy(xpath = DashboardElements.computersA)
    public WebElement computerA;
    @FindBy(xpath = DashboardElements.notebooksA)
    public WebElement netbooksA;
    @FindBy(xpath = DashboardElements.Gb16)
    WebElement Gb16;
    @FindBy(xpath = DashboardElements.inWishlistQty)
    WebElement wishQty;
    @FindBy(xpath = DashboardElements.inCardQuantity)
    WebElement cardQty;


    //    @FindBy(xpath = DashboardRepo.toShoppingCardButtons)
//    List<WebElement> itemsToCard;
//    @FindBy(xpath = DashboardRepo.toWishlistButtons)
//    List<WebElement> itemsToWish;
    @FindBy(className ="item-box" )
    List<WebElement> items;
    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver(), 5);

    public DashboardPage() {
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(WebDriverFactory.getInstance().getDriver()), this);
    }

    public void verifyTitle(String title) {
        assertEquals(WebDriverFactory.getInstance().getDriver().getTitle(), title);
    }

    public void tickPreference(String name) throws InterruptedException {
        switch (name) {
            case "16GB":
                //  if(Gb16.isSelected()){
                Gb16.click();
                //waitFor16ItemTobeInvisible();
                Thread.sleep(2000);
                break;
            //   }
            //else {
            // Gb16.click();
            //    waitFor16ItemTobevisible();
            // items=DriverUtils.getDriver().findElements(By.className("item-box"));
            //  }



        }
