package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.Utility;

public class ProjectSepecificationMethods extends Utility{

	@BeforeSuite
	public void reportInitialization() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("C:\\Users\\arunc\\eclipse-workspace\\guviMiniProject1\\src\\test\\resources\\report\\Demoblaze.html");
		reporter.config().setReportName("Demo Blaze Test Report");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@BeforeClass
	public void testDetails() {
		test=extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}
	@Parameters("url")
	@BeforeMethod
	public void launchBrowser(String url) {
		openUrl(url);
	}
	
	@AfterMethod
	public void closeBrowser() {
		closeUrl();
	}
	
	@AfterSuite
	public void closeReport() {
		extent.flush();
	}
}
