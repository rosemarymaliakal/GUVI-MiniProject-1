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

public class ProductPage extends ProjectSepecificationMethods{
	@FindBy(id="nameofuser")
	WebElement nameOfUser;
	
	@FindBy(xpath = "//div[@id='navbarExample']/ul/li/a")
	WebElement homeElement;
	
	@FindBy(linkText = "Contact")
	WebElement contactElement;
	
	@FindBy(linkText = "About us")
	WebElement aboutElement;
	
	@FindBy(linkText = "Cart")
	WebElement cartElement;
	
	@FindBy(id = "logout2")
	WebElement logoutElement;
	
	@FindBy(linkText = "Phones")
	WebElement phone;
	
	@FindBy(linkText = "Laptops")
	WebElement laptops;
	
	@FindBy(linkText = "Monitors")
	WebElement monitors;
	
	@FindBy(id="nava")
	WebElement logo;
	
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public ProductPage displayUsername(String username) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement userVisible = wait.until(ExpectedConditions.visibilityOf(nameOfUser));
		String userText = userVisible.getText();
		String originalText="Welcome "+username;
		Assert.assertEquals(userText, originalText, "Home page not contains welcome user");
		return this;
	}
		
	public ProductPage displayHome() {
		Assert.assertTrue(homeElement.isDisplayed(),"Home is not visible");
		return this;
	}
	
	public ProductPage displayContact() {
		Assert.assertTrue(contactElement.isDisplayed(), "contact is not visible");
		return this;
	}
	
	public ProductPage displayAbout() {
		Assert.assertTrue(aboutElement.isDisplayed(), "About us is not visible");
		return this;
	}
	
	public ProductPage displayCart() {
		Assert.assertTrue(cartElement.isDisplayed(), "Cart is not visible");
		return this;
	}
	
	public ProductPage displayLogout() {
		Assert.assertTrue(logoutElement.isDisplayed(), "Logout is not visible");
		return this;
	}
	
	public ProductPage displayWelcomeuser() {
		Assert.assertTrue(nameOfUser.isDisplayed(), "Welcome user is not visible");	
		return this;
	}

	
	public ProductPage displayphone() {
		Assert.assertTrue(phone.isDisplayed(), "Phone is not displayed");
		return this;
	}
	
	public ProductPage displaylaptop() {
		Assert.assertTrue(laptops.isDisplayed(), "Laptop is not displayed");
		return this;
	}
	
	public ProductPage displaymonitors() {
		Assert.assertTrue(monitors.isDisplayed(),"Monitors is not displayed" );
		return this;
	}
	
	public ProductPage displaylogo() {
		Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed on homepage");
		return this;
	}
}
