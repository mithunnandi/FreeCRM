package com.CRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CRM.qa.BaseClass.testbase;
import com.CRM.qa.pages.Contactspage;
import com.CRM.qa.pages.Homepage;
import com.CRM.qa.pages.LoginClass;
import com.CRM.qa.utils.testutils;

public class Contactspagetest extends testbase {

	LoginClass loginpage;
	Homepage homepage;
	testutils testUtils;
	Contactspage contactspage;
	String sheetName="sheet2";

	public Contactspagetest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialisation();
		testUtils = new testutils();
		loginpage = new LoginClass();
		contactspage = new Contactspage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtils.switchtoframe();
		homepage.clickoncontacts();

	}

	@Test(priority = 1)
	public void verifycontactslabeltest() {
		Assert.assertTrue(contactspage.verifycontactslabel(), "Label missing");
	}

	@Test(priority = 2)
	public void selectsinglecontactstest() throws InterruptedException {
		contactspage.selectContactsbyname("aa aaa");
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void selectmultiplecontactstest() throws InterruptedException {
		contactspage.selectContactsbyname("a b");
		testUtils.ScrollDown();
		contactspage.selectContactsbyname("Alex DAN");
		Thread.sleep(3000);
	}
	
	@DataProvider
	public Object[][] testdata()
	{
	Object data[][]=testutils.gettestdata(sheetName);
	return data;
	}

	@Test(priority = 4,dataProvider="testdata")
	public void validatecreatenewcontact(String title,String firstname,String lastname,String company) throws InterruptedException  {
		
		homepage.Clickonnewcontactlink();
	contactspage.createnewcontact(title, firstname, lastname, company);
		
	//contactspage.createnewcontact("Mr.", "Tom", "Dick", "WFH");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
