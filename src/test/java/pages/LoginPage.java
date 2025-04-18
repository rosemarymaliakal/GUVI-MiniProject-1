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

public class LoginPage extends ProjectSepecificationMethods {
	
	@FindBy(id="login2")
	WebElement login;
	
	@FindBy(id="logInModalLabel")
	WebElement loginModal;
	
	@FindBy(id="loginusername")
	WebElement username;
	
	@FindBy(id="loginpassword")
	WebElement password;
	

	@FindBy(xpath="//button[text()='Log in']")
	WebElement clickLogin;
	
	@FindBy(id = "nameofuser")
	WebElement userPage;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage visibleLogin() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(login));
		Assert.assertTrue(login.isDisplayed(),"Login button is not visible" );
		return this;
	}
	
	public LoginPage clickableLogin() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(login));
        Assert.assertTrue(loginButton.isEnabled(), "Login button is NOT clickable.");
       return this;
	}
	
	
	public LoginPage clickLoginHome() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(login));
		login.click();
		return this;
	}
	
	public LoginPage enterUsername(String userName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(loginModal));
		username.sendKeys(userName);
		return this;
	}
	
	public LoginPage enterPassword(String passWord) {
		password.sendKeys(passWord);
		return this;
	}
	
	public LoginPage clickLogIn() {
		clickLogin.click();
		return this;
	}
	
	
	public LoginPage validateLogin(String user) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement userPageText = wait.until(ExpectedConditions.visibilityOf(userPage));
		String originalText = userPageText.getText();
		Assert.assertTrue(originalText.contains(user),"Invalid Credentials");
		return this;
	}

}
