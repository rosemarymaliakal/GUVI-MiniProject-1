package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSepecificationMethods;
import pages.LoginPage;
import pages.LogoutPage;

public class TC_007_LogoutTest extends ProjectSepecificationMethods {
	
	@BeforeTest
	public void setup() {
		testName="Logout Test";
		testDescription="Testing Logout Button visiblity and redirection";
		testCategory="Sanity Test";
		testAuthor="Rosemary";
	}

	@Test
	
	public void LogoutTest() {
		LoginPage obj1 = new LoginPage(driver);
		obj1.clickLoginHome()
		.enterUsername("fghqw")
		.enterPassword("qwerty")
		.clickLogIn();
		
		LogoutPage obj2 = new LogoutPage(driver);
		obj2.visiblityLogout()
		.clickonLogout();
	}
}
