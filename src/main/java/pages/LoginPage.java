package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	private By userNameTextBox=By.name("username");
	private By passwordTextBox = By.name("password");
	private By loginButton=By.xpath("//button[contains(@class,'oxd-button oxd-button')]");
	
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		
	}
	
	
	public void enterUserName(String userName) {
		driver.findElement(userNameTextBox).sendKeys(userName);
		
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordTextBox).sendKeys(password);
		
	}
 
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
}
