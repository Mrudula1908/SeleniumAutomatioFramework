package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	@FindBy(name="username")
	WebElement userNameTextBox;
	@FindBy(name="password")
	WebElement passwordTextBox;
	@FindBy(xpath="//button[contains(@class,'oxd-button oxd-button')]")
	WebElement loginButton;
	
	//private By userNameTextBox=By.name("username");
	//private By passwordTextBox = By.name("password");
	//private By loginButton=By.xpath("//button[contains(@class,'oxd-button oxd-button')]");
	
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	public void enterUserName(String userName) {
		userNameTextBox.sendKeys(userName);
		//driver.findElement(userNameTextBox).sendKeys(userName);
		
	}
	
	public void enterPassword(String password) {
		passwordTextBox.sendKeys(password);
		//driver.findElement(passwordTextBox).sendKeys(password);
		
	}
 
	public void clickLogin() {
		loginButton.click();
	//driver.findElement(loginButton).click();
	}
}
