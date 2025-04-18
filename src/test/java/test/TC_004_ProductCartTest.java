package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSepecificationMethods;
import pages.LoginPage;
import pages.NokiaProductPage;
import pages.ProductCartPage;
import pages.SecondProductPage;

public class TC_004_ProductCartTest extends ProjectSepecificationMethods {
	
	@BeforeTest
	public void setup() {
		testName="ProductCart Test";
		testDescription="Testing the redirection to product, Product details,adding to cart and Cart count";
		testCategory="Sanity Test";
		testAuthor="Rosemary";
	}
	
	@Test
	public void HomepageDislay() {
		LoginPage obj1 = new LoginPage(driver);
		obj1.clickLoginHome()
		.enterUsername("uniquexyz")
		.enterPassword("xyz")
		.clickLogIn();
		
		ProductCartPage obj2 = new ProductCartPage(driver);
		obj2.usernameWait()
		.scrollDown()
		.clickonProduct().getProductName().productDetails() 
		.productPrice()
		.clickonCart()
		.clickonMainCart()
		.verifyingCart();
	
		
		obj2.clickonHome()
		.usernameWait()
		.scrollDown()
		.secondCarted();
		
		SecondProductPage obj4 = new SecondProductPage(driver);
		obj4.waitForProductDisplay()
		.clickonCart();
		
		obj2.verifyCount();
		
		
	}
}
