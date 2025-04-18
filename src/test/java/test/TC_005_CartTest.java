package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSepecificationMethods;
import pages.CartPage;
import pages.LoginPage;
import pages.PurchasePage;

public class TC_005_CartTest extends ProjectSepecificationMethods {
	
	
	@BeforeTest
	public void setup() {
		testName="Cart Test";
		testDescription="Testing Cart after deletion and Price after modification";
		testCategory="Sanity Test";
		testAuthor="Rosemary";
	}

	@Test
	
	public void CartTest() {
		LoginPage obj1 = new LoginPage(driver);
		obj1.clickLoginHome()
		.enterUsername("uniquejom")
		.enterPassword("jom")
		.clickLogIn();

		PurchasePage obj2 = new PurchasePage(driver);
		obj2.clickonCart();
		
		CartPage obj3 = new CartPage(driver, null);
		
		obj3.clickonDelete();
				
		obj3.verifyTotalPrice();
		
		obj3.verifyClearingCart();
	}
}
