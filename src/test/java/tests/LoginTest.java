package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;

public class LoginTest extends BaseTest{
	
	@DataProvider(name="getExcelData")
		public Object[][] getLoginData() throws IOException{
		String filePath =System.getProperty("user.dir")+ "/TestData/Testdata.xlsx";
		ExcelUtils.loadExcel(filePath, "sheet1");
		int rowCount=ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount-1][2];//rowcount-1 means it removes the heading line and we know we have 2 coloums username and password so giving it as 2
		for(int i=1;i<rowCount;i++) {
			
			data[i-1][0]=ExcelUtils.getCellData(i, 0);//it will get the username
			data[i-1][1]=ExcelUtils.getCellData(i, 1);//it will get the password
			
		}
		ExcelUtils.closeExcel();
		return data;
			
			
		}
	
	//we can use directly the username and password with out Excel
	@DataProvider(name="LoginData2")
	public Object[][] getData()
	{
		return new Object[][] {
			{"user","pass1"},
			{"user1","pass2"},
			{"user2","pass3"}
		};
	}
	
	
	//@Test(dataProvider = "LoginData2")
	@Parameters({"userName","password"})
	@Test
	public void testValidLogin(String userName,String password) {
		
		test=ExtentReportManager.createTest("Login Test"+userName);
		LoginPage loginpage = new LoginPage(driver);
		test.info("Navigating to URL...");
		test.info("Adding Credentials....");
		//loginpage.enterUserName("Admin");
		//loginpage.enterPassword("admin123");
		loginpage.enterUserName(userName);
		loginpage.enterPassword(password);
		
		test.info("CLick on the Login BUtton.....");
		loginpage.clickLogin();
		System.out.println("title of the page is : " +driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
		test.pass("Verified Succesfully...");
		
	}
	
	

}
