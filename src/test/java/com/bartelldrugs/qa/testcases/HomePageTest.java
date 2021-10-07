package com.bartelldrugs.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bartelldrugs.qa.base.TestBase;
import com.bartelldrugs.qa.pages.HomePage;
import com.bartelldrugs.qa.pages.LoginPage;
import com.bartelldrugs.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage; // Reference variable

	String sheetName = "addPerson";

	// calling super class constructor from TestBase class
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization(); // calling initialization method from TestBase class
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1, enabled = true)
	public void verifyWelcomeUserTest() {
		boolean welcomeuser = homePage.verifyWelcomeUser();
		Assert.assertTrue(welcomeuser);
	}

	@Test(priority = 2, enabled = true)
	public void homePageTitleTest() {
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "Online Pharmacy | Bartell Drugs | Walk-In Medical Care", "Home Page tile is not matched");
	}

	@DataProvider
	public Object[][] getBartelldrugsTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 3, enabled = false, dataProvider = "getBartelldrugsTestData")
	public void validateAddNewPerson(String firstname, String lastname, String birthday, String email) {
		homePage.createNewAddPerson(firstname, lastname, birthday, email);
	}

	@AfterMethod
	public void tearDown() {
//		driver.quit();
	}
}
