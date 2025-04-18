package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSepecificationMethods;

public class ProductCartPage extends ProjectSepecificationMethods {
	
	@FindBy(xpath = "//a[contains(text(),'Nokia')]")
	WebElement mobileScroll;
	
	@FindBy(xpath = "//a[contains(text(),'Iphone')]")
	WebElement mobile;
	
	@FindBy(tagName = "h2")
	WebElement newProduct;
	
	@FindBy(xpath = "//div[@class='row']/div/a")
	WebElement cart;
	
	@FindBy(id="cartur")
	WebElement topcart;
	
	@FindBy(xpath = "(//tbody/tr/td)[2]")
	WebElement cartItem;
	
	@FindBy(xpath = "//a[text()='Home ']")
	WebElement home;
	
	@FindBy(xpath="//a[contains(text(),'z5')]")
	WebElement itemsecond;
		
	@FindBy(xpath = "//tbody[@id='tbodyid']/tr")
	List<WebElement> numofRows;
	
	@FindBy(id="tbodyid")
	WebElement tableonCart;

	public ProductCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	4_1
	
	public ProductCartPage usernameWait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
		return this;
	}
	
	public ProductCartPage scrollDown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(mobileScroll));
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", mobileScroll);
        return this; 
	}
	
	public NokiaProductPage clickonProduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//a[contains(text(),'Iphone')]"))));
        String pName = mobile.getText();
        mobile.click();
        return new NokiaProductPage(driver,pName); 
	}	

//	4_4
	
	public ProductCartPage clickonHome() {
		home.click();
		return this;
	}
//			call usernameWait(),then scrollDown() in testclass.
	
	public SecondProductPage secondCarted() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(text(),'z5')]")));
		itemsecond.click();
		return new SecondProductPage(driver);
	}
	
	public ProductCartPage verifyCount() {
		topcart.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(tableonCart));
		Assert.assertEquals(numofRows.size(), 2, "Number of Products in cart is not same");		
		return this;
	}
	
}
