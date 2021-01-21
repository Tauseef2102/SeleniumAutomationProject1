package Test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.HackerrankPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelUtils;

public class HackerrankLoginPageTest {

	private static WebDriver driver=null;
	private static HackerrankPageObjects loginPageObj;
	private static ExcelUtils Excel;
	public static void main(String[] args) {
		HackerrankLoginTest();
	}

	public static void HackerrankLoginTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		String projectPath = System.getProperty("user.dir");
		Excel = new ExcelUtils(projectPath+"\\Excel\\data.xlsx", "Sheet1");
		String username = Excel.getCellData(1, 0);
		String password = Excel.getCellData(1, 1);

		loginPageObj = new HackerrankPageObjects(driver);

		driver.get("https://www.hackerrank.com/");

		loginPageObj.clickOnLoginbutton();

		loginPageObj.clickOnDeveloperLogin();

		loginPageObj.inputEmail(username);

		loginPageObj.inputPassword(password);

		loginPageObj.finalLoggingin();

		driver.close();

	}
}
