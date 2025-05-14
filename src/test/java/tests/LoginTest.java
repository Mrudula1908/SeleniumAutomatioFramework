package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test
	public void testValidLogin() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName("Admin");
		loginpage.enterPassword("admin123");
		loginpage.clickLogin();
		System.out.println("title of the page is : " +driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
	}
	
	

}
