package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSepecificationMethods;
import pages.LoginPage;
import pages.ProductCartPage;
import pages.PurchasePage;

public class TC_006_PurchaseFunctionTest extends ProjectSepecificationMethods {
	
	@BeforeTest
	public void setup() {
		testName="Purchase Function Test";
		testDescription="Testing Purchase validation details and Payment";
		testCategory="Sanity Test";
		testAuthor="Rosemary";
	}
	
	@Test
	public void PurchaseTest() {
		LoginPage obj1 = new LoginPage(driver);
		obj1.clickLoginHome()
		.enterUsername("uniquejom")
		.enterPassword("jom")
		.clickLogIn();
		
		ProductCartPage obj2 = new ProductCartPage(driver);
		obj2.usernameWait()
		.scrollDown()
		.clickonProduct() 
		.clickonCart();

		PurchasePage obj3 = new PurchasePage(driver);
		obj3.clickonCart()
		.clickonPlaceOrder()
		.verifyPlaceorderModal()
		.verifyUserSection()
		.enterDetails("rogi", "India", "Hyderabad", "City", "May", "2026")
		.validatePurchase();
	}

}
