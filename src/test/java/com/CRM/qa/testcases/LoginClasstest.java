package com.CRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.qa.BaseClass.testbase;
import com.CRM.qa.pages.Homepage;
import com.CRM.qa.pages.LoginClass;

//calling consttuctor from super or base class to intialise the properties
public class LoginClasstest extends testbase {

	LoginClass loginpage;
	Homepage homepage;

	public LoginClasstest() {
		super(); //calling super or parent class constructor
	}

	@BeforeMethod
	public void setup() {
		initialisation();
		loginpage = new LoginClass();
	}

	@Test(priority = 1)
	public void loginpagetitle() {
		String title = loginpage.validatepagetitle();
		Assert.assertTrue(title.contains("CRMPRO"));
	}

	@Test(priority = 2)
	public void CRMlogotest() {
		boolean flag = loginpage.validateCRMImage();
		Assert.assertTrue(flag);

	}

	@Test(priority = 3)
	public void logintest() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
