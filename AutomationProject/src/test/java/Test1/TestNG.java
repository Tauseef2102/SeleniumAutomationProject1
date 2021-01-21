package Test1;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelUtils;
import PageObject.HackerrankPageObjects;

public class TestNG{

	private static WebDriver driver = null;
	static ExcelUtils Excel;

	@BeforeTest
	public void setUpTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public static void Hackerrank() {
		String projectPath = System.getProperty("user.dir");
		Excel = new ExcelUtils(projectPath+"\\Excel\\data.xlsx", "Sheet1");
		String username = Excel.getCellData(1, 0);
		String password = Excel.getCellData(1, 1);

		HackerrankPageObjects loginPageObj = new HackerrankPageObjects(driver);

		driver.get("https://www.hackerrank.com/");

		loginPageObj.clickOnLoginbutton();

		loginPageObj.clickOnDeveloperLogin();

		loginPageObj.inputEmail(username);

		loginPageObj.inputPassword(password);

		loginPageObj.finalLoggingin();
		
	}

	@AfterTest
	public void tearDownTest() {
		//close Browser
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
	}

}
