package Test1;

import java.io.IOException;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import PageObject.HackerrankPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelUtils;

public class ExtentReport_TestNG {
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver=null;
	ExtentTest test1;
	
	@BeforeSuite
	public void setUp(){
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@BeforeTest
	public void setUpTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();

	}

	@Test
	public void test1() throws IOException {
		test1 = extent.createTest("Hackerrank Login Test1","This is a test to validate Hackerrank Login function");
		
		test1.log(Status.INFO, "Starting Test Case");
		String projectPath = System.getProperty("user.dir");
		ExcelUtils Excel = new ExcelUtils(projectPath+"\\Excel\\data.xlsx", "Sheet1");
		String username = Excel.getCellData(1, 0);
		String password = Excel.getCellData(1, 1);
		//go to Hackerrank
		driver.get("https://www.hackerrank.com/");
		test1.pass("Navigate to hackerrank.com");
		HackerrankPageObjects loginPageObj = new HackerrankPageObjects(driver);
		//Opening the login page
		
		loginPageObj.clickOnLoginbutton();
		test1.pass("Clicked on the login button in Homepage");
		
		loginPageObj.clickOnDeveloperLogin();
		test1.pass("Clicked on the login Button for Developers");
		
		loginPageObj.inputEmail(username);
		test1.pass("Entered Email id");
		
		loginPageObj.inputPassword(password);
		test1.pass("Entered Password");
		
		loginPageObj.finalLoggingin();
		test1.pass("Clicked on the login Button");
        
	}

	@AfterTest
	public void tearDownTest() {
		//close Browser
		driver.close();
		driver.quit();
		test1.info("Test Completed Successfully");
		System.out.println("Test Completed Successfully");
	}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
}
