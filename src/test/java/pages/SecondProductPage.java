package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSepecificationMethods;

public class SecondProductPage extends ProjectSepecificationMethods {

	@FindBy(tagName = "h2")
	WebElement secondItem;
	
	@FindBy(xpath = "//a[contains(text(),'cart')]")
	WebElement cartButton;
	
	public SecondProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public SecondProductPage waitForProductDisplay() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(secondItem));
		return this;
	}
	
	public SecondProductPage clickonCart() {
		cartButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		alert.accept();
		return this;
	}
	
	
}
