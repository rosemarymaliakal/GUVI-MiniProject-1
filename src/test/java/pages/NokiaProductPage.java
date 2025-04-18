package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSepecificationMethods;

public class NokiaProductPage extends ProjectSepecificationMethods {
	
	@FindBy(tagName = "h2")
	WebElement pageHeading;
	
	@FindBy(tagName = "h3")
	WebElement price;
	
	@FindBy(xpath = "//div[@id='more-information']/p")
	WebElement description;
	
	@FindBy(xpath = "//a[contains(text(),'cart')]")
	WebElement cartButton;
	
	@FindBy(id="cartur")
	WebElement topcart;
	
	@FindBy(id="tbodyid")
	WebElement tableonCart;
	
	
	
	String pName="";
	String productName="";
	
	public NokiaProductPage(WebDriver driver, String pName) {
		this.driver=driver;
		this.pName=pName; 
		PageFactory.initElements(driver,this); 
	}
	
//	4_1
	
	public NokiaProductPage getProductName() {
		productName = pageHeading.getText(); //clarify??
		Assert.assertTrue(productName.contains(pName), "Redirected to a different product page");
		return this;
	}
	
//	4_2
	
	public NokiaProductPage productDetails() {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(description));
		String actualInfo = "It comes with 1GB of RAM. The phone packs 16GB of internal storage cannot be expanded. As far as the cameras are concerned, the Apple iPhone 6 packs a 8-megapixel primary camera on the rear and a 1.2-megapixel front shooter for selfies.";
		String productInfo = description.getText();
		Assert.assertTrue(productInfo.equalsIgnoreCase(actualInfo),"Product description is not accurate");
		return this;
	}
	
	public NokiaProductPage productPrice() {
		String mobilePrice = price.getText();
		String actualPrice = "790";
		Assert.assertTrue(mobilePrice.contains(actualPrice), "Mobile price is not same");
		return this;
	}
	
	//4_3
	
	public NokiaProductPage clickonCart() {
		cartButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		alert.accept();
		return this;
	}
	
	
	public CartPage clickonMainCart() {
		topcart.click();
		return new CartPage(driver,productName);
	}
	
	
	///after clicking on main cart, it is going to main page, so have to add below method in ProductCartPage ???
//	public CartPage verifyingCart() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOf(tableonCart));
//		String cartText = itemonCart.getText();
//		Assert.assertEquals(cartText, productName); //how to use productName in getProductName()
//		return Cartthis;
//	}
	
}
