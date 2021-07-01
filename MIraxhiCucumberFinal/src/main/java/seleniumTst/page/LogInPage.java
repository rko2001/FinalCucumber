package seleniumTst.page;
import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumTst.utils.LogInElements;
import seleniumTst.utils.WebDriverFactory;
import seleniumtest.utils.LogInElements;
import seleniumtest.utils.WebDriverFactory;


public class LogInPage {
    @FindBy(xpath = LogInElements.registerButton)
    WebElement registerButton;
    @FindBy(xpath = LogInElements.logInA)
    WebElement logInA;
    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver() , 3);

    public LogInPage() {
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(WebDriverFactory.getInstance().getDriver()), this);
    }
    public void clickButton(String buttonName){
        switch (buttonName){
            case "logIn":
                wait.until(ExpectedConditions.visibilityOf(logInA));
                logInA.click();
                break;
            case "register":
                wait.until(ExpectedConditions.visibilityOf(registerButton));
                registerButton.click();
                break;
        }
    }

}
