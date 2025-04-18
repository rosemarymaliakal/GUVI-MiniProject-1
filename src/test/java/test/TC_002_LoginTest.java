package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSepecificationMethods;
import pages.LoginPage;

public class TC_002_LoginTest extends ProjectSepecificationMethods {

	@BeforeTest
	public void setup() {
		testName="Login Test";
		testDescription="Testing Login Button is visiblity,clickable and Validating";
		testCategory="Sanity Test";
		testAuthor="Rosemary";
	}
	
	@Test
	
	public void loginButton() {
		LoginPage obj2 = new LoginPage(driver);
		
		obj2.visibleLogin();
		
		obj2.clickableLogin();
		
		obj2.clickLoginHome()
		.enterUsername("uniquejom")
		.enterPassword("jom")
		.clickLogIn()
		.validateLogin("uniquejom");
		
		
	}
}
