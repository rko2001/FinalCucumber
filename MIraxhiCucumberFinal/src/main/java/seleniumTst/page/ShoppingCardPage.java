package seleniumTst.page;
import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import seleniumTst.utils.DashboardElements;
import seleniumTst.utils.DriverUtils;
import seleniumTst.utils.WebDriverFactory;
import seleniumtest.utils.DashboardRepo;
import seleniumtest.utils.DriverUtils;
import seleniumtest.utils.WebDriverFactory;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class ShoppingCardPage {
    public static WebDriver driver= DriverUtils.getDriver();
    private static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getInstance().getDriver(), 3);

    public ShoppingCardPage() {
        PageFactory.initElements(new WebDriverExtensionFieldDecorator(WebDriverFactory.getInstance().getDriver()), this);
    }
    public void goToCardPage() throws InterruptedException {
        Thread.sleep(3000);
        Actions actions=new Actions(driver);
        WebElement card=driver.findElement(By.xpath("//span[@class=\"cart-label\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",card);
        actions.moveToElement(card).build().perform();
        WebElement goToCard= driver.findElement(By.xpath("//button[text()=\"Go to cart\"]"));
        WebElement wait=new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()=\"Go to cart\"]"))));
        assertTrue(goToCard.isDisplayed());
        goToCard.click();
    }
    public void deleteElementsFromCard(int n){
        ArrayList<WebElement> removeBtns= (ArrayList<WebElement>) driver.findElements(By.xpath(DashboardElements.removeBtns));
        int cont=removeBtns.size();
        for(int i=0 ;i<n;i++){
            removeBtns.get(i).click();

        }

    }
    public void checkTotal(){
        List<WebElement> b2uttons=driver.findElements(By.xpath("//div[@class=\"common-buttons\"]//button[@type=\"submit\"]"));
        WebElement estimate=driver.findElement(By.xpath("//div[@class=\"common-buttons\"]//a"));
        AssertJUnit.assertTrue(b2uttons.get(0).isDisplayed());
        AssertJUnit.assertTrue(b2uttons.get(1).isDisplayed());
        AssertJUnit.assertTrue(estimate.isDisplayed());
        List<WebElement> subTotals=driver.findElements(By.xpath("//table[@class=\"cart\"]//td//span[@class=\"product-subtotal\"]"));
        Float total= Float.parseFloat(removeFirst(removeComma(driver.findElement(By.xpath("//span[@class=\"value-summary\"]//strong")).getText())));
        assertEquals(total+"",sum(subTotals)+"");
    }
    String removeFirst(String str)
    {

        StringBuilder sb = new StringBuilder(str);
        sb.deleteCharAt(0);
        return sb.toString();
    }
    float sum(List<WebElement> list){
        int sum = 0;
        for(WebElement a:list){
            sum+=Float.parseFloat(removeFirst(removeComma(a.getText())));
        }
        return sum;
    }
    String removeComma(String str){
        return str.replaceAll(",","");
    }
    public int getNrElements(){
        List<WebElement> newList = driver.findElements(By.xpath("//button[@class=\"remove-btn\"]"));
        return newList.size();
    }
    public void quit(){
        WebDriverFactory.getInstance().quit();
    }

}
