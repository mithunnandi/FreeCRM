package com.CRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.qa.BaseClass.testbase;

public class LoginClass extends testbase {
	// Page Factory
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	//@FindBy(name="password11") screenshot taken 
	WebElement passw;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginbtn;

	@FindBy(xpath = "//button[contains(text(),'signup']")
	WebElement signupbtn;

	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;

	public LoginClass()
//initialising page objects
	{
		PageFactory.initElements(driver, this);
	}

	public String validatepagetitle() {
		return driver.getTitle();
	}

	public boolean validateCRMImage() {
		return crmlogo.isDisplayed();
	}

	public Homepage login(String un, String pwd) {
		username.sendKeys(un);
		passw.sendKeys(pwd);
		loginbtn.click();

		return new Homepage();
	}

}
