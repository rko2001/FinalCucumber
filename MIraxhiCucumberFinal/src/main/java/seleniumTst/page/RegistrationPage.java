package seleniumTst.page;
import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumTst.utils.RegisterFormElements;
import seleniumTst.utils.WebDriverFactory;
import seleniumtest.utils.RegisterFormRepo;
import seleniumtest.utils.WebDriverFactory;

import static org.testng.Assert.assertEquals;


public class RegistrationPage {
    @FindBy(xpath = RegisterFormElements.maleLabel)
    WebElement genderM;
    @FindBy(xpath =RegisterFormElements.femaleLabel )
    WebElement getGenderF;
    @FindBy(xpath =RegisterFormElements.firstNameInput)

    WebElement firstName;
    @FindBy(xpath =RegisterFormElements.lastNameInput )
    WebElement lastName;
    @FindBy(xpath =RegisterFormElements.inEmail )
    WebElement email;
    @FindBy(xpath =RegisterFormElements.inPassword )
    WebElement password;
    @FindBy(xpath =RegisterFormElements.inRePassword )
    WebElement rePassword;

    @FindBy(xpath = RegisterFormElements.inCompany )
    WebElement company;
    @FindBy(xpath =RegisterFormElements.reButton )
    WebElement registerButtonInForm;
    @FindBy(xpath = RegisterFormElements.logOutA)
    WebElement logOut;
    @FindBy(css = "div.result")
    WebElement result;
    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver() , 3);

    public RegistrationPage() {
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(WebDriverFactory.getInstance().getDriver()), this);
    }
    public void fillInput(String label,String value){
        switch (label){
            case "firstName":
                firstName.sendKeys(value);
                break;
            case "lastName":
                lastName.sendKeys(value);
                break;
            case "company":
                company.sendKeys(value);
                break;
            case "email":
                email.sendKeys(value);
                break;
            case "password":
                password.sendKeys(value);
                rePassword.sendKeys(value);
                break;

        }

    }
    public void fillDate(String day,String month ,String year){
        Select dateDay=new Select(WebDriverFactory.getInstance().getDriver().findElement(By.xpath(RegisterFormElements.bDay)));
        dateDay.selectByVisibleText(day);
        Select dateMonth=new Select(WebDriverFactory.getInstance().getDriver().findElement(By.xpath(RegisterFormElements.bMonth)));
        dateMonth.selectByVisibleText(month);
        Select dateYear=new Select(WebDriverFactory.getInstance().getDriver().findElement(By.xpath(RegisterFormElements.bYear)));
        dateYear.selectByVisibleText(year);

    }
    public void clickButton(String name){
        switch (name){
            case "register":
                wait.until(ExpectedConditions.visibilityOf(registerButtonInForm));
                registerButtonInForm.click();
                break;
            case "logOut":
                wait.until(ExpectedConditions.visibilityOf(logOut));
                logOut.click();
                break;
        }
    }
    public void isRegCompleted(String text){
        assertEquals(result.getText(),text);
    }

}
