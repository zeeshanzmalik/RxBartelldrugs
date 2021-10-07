package com.bartelldrugs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bartelldrugs.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - Web Elements
	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(id = "submit")
	WebElement loginBtn;

	@FindBy(xpath = "//img[contains(@class, 'desktop-logo')]")
	WebElement bartellLogo;

	// Initializing page factory
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	public boolean validateBartellImage() {
		return bartellLogo.isDisplayed();
	}

	public HomePage login(String emails, String pwd) {
		email.sendKeys(emails);
		password.sendKeys(pwd);
		loginBtn.click();

		return new HomePage();
	}
	
}
