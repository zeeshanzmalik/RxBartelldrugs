package com.bartelldrugs.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bartelldrugs.qa.base.TestBase;
import com.bartelldrugs.qa.pages.HomePage;
import com.bartelldrugs.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage; // Reference variable
	
	// calling super class constructor from TestBase class
	public LoginPageTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp(){
		initialization(); // calling initialization method from TestBase class
		loginPage = new LoginPage(); // LoginPage Object reference 
	}
	
	
	@Test(priority=2)
	public void loginTest() throws InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
		System.out.println("login successfull");
		
	}
	
	@Test(priority=1, enabled=true)
	public void validateBartellImageTest() {
		boolean flag = loginPage.validateBartellImage();
		Assert.assertTrue(flag);
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
}
