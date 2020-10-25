package com.CRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.qa.BaseClass.testbase;
import com.CRM.qa.pages.Contactspage;
import com.CRM.qa.pages.Homepage;
import com.CRM.qa.pages.LoginClass;
import com.CRM.qa.utils.testutils;

//**Best Practices** test cases should be independent to avoid any caching issue-evry time open the browser,login and close the browser

public class Homepagetest extends testbase {
	LoginClass loginpage;
	Homepage homepage;
	testutils testUtils;
	Contactspage contactspage;

	public Homepagetest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialisation();
		testUtils = new testutils();
		loginpage = new LoginClass();
		contactspage = new Contactspage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyhomepagetitletest() {
		String homepagetitle = homepage.verifypagetitle();
		Assert.assertEquals(homepagetitle, "CRMPRO", "Home page title mismatch");

	}

	@Test(priority = 2)
	public void verifyusernametest() {
		testUtils.switchtoframe();
		Assert.assertTrue(homepage.verifyusernamelabel());

	}

	@Test(priority = 3)
	public void verifycontactslinktest() {
		testUtils.switchtoframe();
		contactspage = homepage.clickoncontacts();

	}

	@AfterMethod
	public void teardows() {
		driver.quit();
	}
}
