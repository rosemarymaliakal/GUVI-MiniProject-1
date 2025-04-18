package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSepecificationMethods;
import pages.SignupPage;

public class TC_001_SignupTest extends ProjectSepecificationMethods {
	
	@BeforeTest
	public void setup() {
		testName="Signup Test";
		testDescription="Testing Signup Button is visiblity,clickable,Modal opening";
		testCategory="Sanity Test";
		testAuthor="Rosemary";
	}
	

	@Test
	
	public void signupTest() throws InterruptedException {
		SignupPage obj1 = new SignupPage(driver);
		
		obj1.visibleSignup()
		
		.clickableSignup()
		
		.clickSignup()
		
		.validateSignup("uniquejom", "jom");
		
	}

}
