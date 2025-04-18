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

public class SignupPage extends ProjectSepecificationMethods {
	
	@FindBy(id="signin2")
	WebElement signup;
	
	@FindBy(id="sign-username")
	WebElement signupUsername;
	
	@FindBy(id="sign-password")
	WebElement signupPassword;
	
	@FindBy(id="signInModalLabel")
	WebElement signupModal;
	
	@FindBy(xpath="(//div[@class='modal-footer']/button)[4]")
	WebElement clickSubmit;
	
	public SignupPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public SignupPage visibleSignup() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signupButton = wait.until(ExpectedConditions.elementToBeClickable(signup));
		Assert.assertTrue(signupButton.isDisplayed(), "Signup button is not visible");
		return this;
	}
	
	public SignupPage clickableSignup() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signupButton = wait.until(ExpectedConditions.elementToBeClickable(signup));
        Assert.assertTrue(signupButton.isEnabled(), "Signup button is not clickable");
        return this;
	}
	
	public SignupPage clickSignup() {
		 signup.click();
		 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement modal = wait1.until(ExpectedConditions.visibilityOf(signupModal));		 
		 Assert.assertTrue(modal.isDisplayed(), "Signup modal is NOT opened after clicking signup button");
		 return this;
	}
	
	public SignupPage validateSignup(String uname, String pwd) throws InterruptedException {
		signupUsername.sendKeys(uname);
		signupPassword.sendKeys(pwd);
		clickSubmit.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert=driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
				
		String signupText="Sign up successful.";
		Assert.assertEquals(alertText, signupText,"Signup failed");
		
		return this;
	}

}
