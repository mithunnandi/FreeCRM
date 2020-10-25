package com.CRM.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.qa.BaseClass.testbase;
import com.CRM.qa.pages.Contactspage;
import com.CRM.qa.pages.Homepage;
import com.CRM.qa.pages.LoginClass;
import com.CRM.qa.pages.Taskspage;
import com.CRM.qa.utils.testutils;

public class Taskspagetest extends testbase{
	LoginClass loginpage;
	Homepage homepage;
	testutils testUtils;
	Contactspage contactspage;
	Taskspage taskspage;

	public Taskspagetest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialisation();
		testUtils = new testutils();
		loginpage = new LoginClass();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtils.switchtoframe();
	

	}
@Test
public void validatecreatenewtask()
{ //homepage.clickontasks();
homepage.Clickonnewtasklink();
taskspage.createnewtask("QA Task");
	}

}
