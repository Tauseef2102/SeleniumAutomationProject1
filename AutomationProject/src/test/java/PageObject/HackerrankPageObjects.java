package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HackerrankPageObjects {

	WebDriver driver = null;

	By homepage_login = By.xpath("//a[contains(text(),'Login')]\r\n");

	By developer_login = By.xpath("//body/div[@id='page']/div[@id='primary']/main[@id='main']/article[@id='post-175']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div[1]/a[1]");

	By input_email = By.className("input");

	By input_password = By.id("input-2");

	By final_login = By.xpath("//span[contains(text(),'Log In')]");

	public HackerrankPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	public void clickOnLoginbutton() {
		driver.findElement(homepage_login).click();
	}

	public void clickOnDeveloperLogin() {
		driver.findElement(developer_login).click();
	}

	public void inputEmail(String text) {
		driver.findElement(input_email).sendKeys(text);
	}

	public void inputPassword(String text) {
		driver.findElement(input_password).sendKeys(text);
	}

	public void finalLoggingin() {
		driver.findElement(final_login).click();
	}
}
