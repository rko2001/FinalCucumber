package seleniumTst.page;
import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumTst.utils.MyAccountElements;
import seleniumTst.utils.RegisterFormElements;
import seleniumTst.utils.WebDriverFactory;
import seleniumtest.utils.DriverUtils;
import seleniumtest.utils.MyAccountRepo;
import seleniumtest.utils.RegisterFormRepo;
import seleniumtest.utils.WebDriverFactory;

import java.time.Year;

import static org.testng.Assert.assertEquals;

public class MyAccountPage {
    @FindBy(xpath = MyAccountElements.inEmail)
    WebElement inEmail;
    @FindBy(xpath = MyAccountElements.inPassword)
    WebElement inPassword;
    @FindBy(xpath = MyAccountElements.logInBtn)
    WebElement logInBtn;
    @FindBy(xpath = MyAccountElements.logOutA)
    WebElement logOut;
    @FindBy(xpath = MyAccountElements.myAccountA)
    WebElement myAcount;
    @FindBy(xpath = "//input[@value=('M')]")
    WebElement inputMale;
    @FindBy(xpath = "//input[@value=('F')]")
    WebElement inputFeMale;
    @FindBy(xpath = MyAccountElements.firstNameInput)
    WebElement firstName;
    @FindBy(xpath = MyAccountElements.lastNameInput)
    WebElement lastName;
    @FindBy(xpath = MyAccountElements.inEmail)
    WebElement email;
    @FindBy(xpath = MyAccountElements.inCompany)
    WebElement company;
    @FindBy(xpath = MyAccountElements
            .newsletter)
    public WebElement newsletter;


    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver(), 3);

    public MyAccountPage() {
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(WebDriverFactory.getInstance().getDriver()), this);
    }

    public void assertInputValues(String input, String value) {
        switch (input) {
            case "lastName":
                assertEquals(lastName.getAttribute("value"), value);
                break;

            case "firstName":
                assertEquals(firstName.getAttribute("value"), value);
                break;

            case "company":
                assertEquals(company.getAttribute("value"), value);

                break;

            case "email":
                assertEquals(email.getAttribute("value"), value);

                break;
            case "password":
                assertEquals(inPassword.getAttribute("value"), value);
                break;
        }


    }

    public void assertDate(String day, String month, String year) {
        Select dateDay = new Select(WebDriverFactory.getInstance().getDriver().findElement(By.xpath(RegisterFormElements.bDay)));
        assertEquals(dateDay.getFirstSelectedOption().getText(), day);
        Select dateMonth = new Select(WebDriverFactory.getInstance().getDriver().findElement(By.xpath(RegisterFormElements.bMonth)));
        assertEquals(dateMonth.getFirstSelectedOption().getText(), month);
        Select dateYear = new Select(WebDriverFactory.getInstance().getDriver().findElement(By.xpath(RegisterFormElements.bYear)));
        assertEquals(dateYear.getFirstSelectedOption().getText(), year);
    }

    public void clickMyAccount() {
        myAcount.click();

    }
}
