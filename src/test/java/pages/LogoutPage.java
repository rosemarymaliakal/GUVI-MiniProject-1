package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSepecificationMethods;

public class LogoutPage extends ProjectSepecificationMethods {

	@FindBy(id="logout2")
	WebElement logoutButton;
	
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public LogoutPage visiblityLogout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement logoutelement = wait.until(ExpectedConditions.visibilityOf(logoutButton));
		Assert.assertTrue(logoutelement.isDisplayed(), "Logout button is not visible");
		return this;
	}
	
	public LogoutPage clickonLogout() {
		logoutButton.click();
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("index.html"),"Not redirected to home page after Logout");
		return this;
	}

}
