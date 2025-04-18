package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSepecificationMethods;

public class PurchasePage extends ProjectSepecificationMethods {
	
	@FindBy(id="cartur")
	WebElement topcart;
	
	@FindBy(id="tbodyid")
	WebElement itemTable;
	
	@FindBy(xpath = "//button[contains(text(),'Place')]")
	WebElement order;

	@FindBy(id="orderModalLabel")
	WebElement orderModal;
	
	@FindBy(xpath="//label[text()='Name:']")
	WebElement name;
	
	@FindBy(xpath = "//label[text()='Country:']")
	WebElement countryName;
	
	@FindBy(xpath="//label[text()='City:']")
	WebElement cityName;
	
	@FindBy(xpath="//label[text()='Credit card:']")
	WebElement creditCard;
	
	@FindBy(xpath="//label[text()='Month:']")
	WebElement monthPurchase;
	
	@FindBy(xpath="//label[text()='Year:']")
	WebElement yearPurchase;
	
	@FindBy(xpath = "//button[text()='Purchase']")
	WebElement purchase;
	
	@FindBy(xpath = "//h2[contains(text(),'Thank')]")
	WebElement purchaseModal;
	
	@FindBy(id="name")
	WebElement nameInput;
	
	@FindBy(id="country")
	WebElement countryInput;
	
	@FindBy(id="city")
	WebElement cityInput;
	
	@FindBy(id="card")
	WebElement cardInput;
	
	@FindBy(id="month")
	WebElement monthInput;
	
	@FindBy(id="year")
	WebElement yearInput;
	
	
	@FindBy(xpath = "//button[text()='OK']")
	WebElement confirmPayment;
	
	public PurchasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public PurchasePage clickonCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("nameofuser")));
		WebElement cartButton=wait.until(ExpectedConditions.elementToBeClickable(topcart));
		cartButton.click();
		return this;
	}
	public PurchasePage clickonPlaceOrder() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(itemTable));
		order.click();
		return this;
	}
	
	public PurchasePage verifyPlaceorderModal() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(orderModal));
		Assert.assertTrue(orderModal.isDisplayed(),"Place order modal is not opened");
		Assert.assertEquals(orderModal.getText(),"Place order","Modal title is not correct");
		return this;
	}
	
	public PurchasePage verifyUserSection() {
		Assert.assertTrue(name.isDisplayed(),"Name section is not displayed");
		Assert.assertTrue(countryName.isDisplayed(),"Country section is not displayed");
		Assert.assertTrue(cityName.isDisplayed(),"City section is not displayed");
		Assert.assertTrue(creditCard.isDisplayed(),"credit card section is not displayed");
		Assert.assertTrue(monthPurchase.isDisplayed(),"Month section is not displayed");
		Assert.assertTrue(yearPurchase.isDisplayed(),"Year section is not displayed");
		return this;
	}
	
	public PurchasePage enterDetails(String username,String cname, String city, String credit, String month, String year) {
		nameInput.sendKeys(username);
		countryInput.sendKeys(cname);
		cityInput.sendKeys(city);
		cardInput.sendKeys(credit);
		monthInput.sendKeys(month);
		yearInput.sendKeys(year);
		
		purchase.click();
		return this;
	}
	
	public PurchasePage validatePurchase() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(purchaseModal));
		String purchaseText = purchaseModal.getText();
		Assert.assertTrue(purchaseText.contains("Thank you"), "Payment is not successful");
		return this;
	}
	
	
}
