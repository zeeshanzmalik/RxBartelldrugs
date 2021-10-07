package com.bartelldrugs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bartelldrugs.qa.base.TestBase;

public class HomePage extends TestBase {
	// Page Factory - Web Elements

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/strong[1]")
	WebElement welcomeUsr;
	
	@FindBy(xpath = "//a[contains(text(),'Add a Person')]")
	WebElement addPersonBtn;
	
	@FindBy(xpath = "//label[contains(text(),'Young Adult (Age 13-17)')]")
	WebElement radioBtn;
	
	@FindBy(xpath = "//input[@id='firstname']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='lastname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='dateOfBirth']")
	WebElement dateOfBD;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement mail;
	
	@FindBy(xpath = "//input[@id='confirmEmail']")
	WebElement confirmmail;
	
	@FindBy(xpath = "//button[@id='submit']")
	WebElement submitBtn;
	
	// Initializing page factory
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public boolean verifyWelcomeUser() {
		return welcomeUsr.isDisplayed();

	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	
	public void createNewAddPerson(String ftName, String ltName, String dOB, String email) {
		addPersonBtn.click();
		radioBtn.click();
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		dateOfBD.sendKeys(dOB);
		mail.sendKeys(email);
		submitBtn.click();
	}
}
