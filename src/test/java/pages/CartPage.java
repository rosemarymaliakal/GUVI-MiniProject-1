package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSepecificationMethods;

public class CartPage extends ProjectSepecificationMethods{
	
	@FindBy(xpath = "//td[contains(text(),'Sony')]/following-sibling::td/a")
	WebElement deleteCart;
	
	@FindBy(xpath = "//tbody[@id='tbodyid']/tr")
	List<WebElement> numofRows;
	
	@FindBy(id="tbodyid")
	WebElement cartTable;
	
	@FindBy(xpath="//tr[@class='success']/td[3]")
	List<WebElement> priceList;
	
	@FindBy(id="totalp")
	WebElement totalPrice;
	
	@FindBy(xpath = "//tr[@class='success']/td[4]/a")
	WebElement deleteItem;
	
	@FindBy(xpath = "//tr[@class='success']/td[2]")
	WebElement itemName;
	
	@FindBy(xpath = "//td[contains(text(),'Iphone')]")
	WebElement itemonCart;
	
	@FindBy(id="tbodyid")
	WebElement tableonCart;
	
	@FindBy(xpath = "//td[contains(text(),'Iphone')]")
	WebElement mobile;
	
	String productName="";
	
	public CartPage(WebDriver driver, String productName) {
		this.driver=driver;
		this.productName=productName;
		PageFactory.initElements(driver, this);
	}
	
	public CartPage verifyingCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(tableonCart));
		String cartText = itemonCart.getText();
		Assert.assertEquals(cartText, productName); //how to use productName in getProductName()
		return this;
	}
	
	public CartPage clickonDelete() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(cartTable));
		int beforeCount = numofRows.size();
		deleteCart.click();
		wait.until(ExpectedConditions.invisibilityOf(deleteCart));
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.invisibilityOf(deleteCart));
		int originalCount = numofRows.size();
		int expectedCount = beforeCount -1;
		Assert.assertEquals(originalCount,expectedCount, "Delete items in cart is not possible");
		return this;
	}
	
	public CartPage verifyTotalPrice() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(cartTable));
		int expectedTotal = 0;
        for (WebElement price : priceList) {
            expectedTotal += Integer.parseInt(price.getText().trim());
        }
        
        int actualTotal = Integer.parseInt(totalPrice.getText().trim());
        Assert.assertEquals(actualTotal, expectedTotal, "Total price and expected price are not same");
		return this;
	}
	
	public CartPage verifyClearingCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(cartTable));
//		String item = itemName.getText();
		deleteItem.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		boolean itemDeleted = wait1.until(ExpectedConditions.invisibilityOf(mobile));
		Assert.assertTrue(itemDeleted,"Product was not removed from cart");
		return this;
	}
}
