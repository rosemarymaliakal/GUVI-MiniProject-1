package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSepecificationMethods;
import pages.LoginPage;
import pages.ProductPage;

public class TC_003_ProductCategoriesDisplayTest extends ProjectSepecificationMethods {

	@BeforeTest
	public void setup() {
		testName="HomePageDisplay Test";
		testDescription="Testing Categories, Menus and Logo in Homepage";
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
		
		ProductPage obj2 = new ProductPage(driver);
		
		obj2.displayUsername("uniquexyz");
		
		obj2.displayHome()
		.displayContact()
		.displayAbout()
		.displayCart()
		.displayLogout()
		.displayWelcomeuser();
		
		obj2.displayphone()
		.displaylaptop()
		.displaymonitors();
		
		obj2.displaylogo();
		
		
	}
}
