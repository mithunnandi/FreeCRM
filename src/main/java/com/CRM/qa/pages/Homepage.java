package com.CRM.qa.pages;

import java.sql.Time;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CRM.qa.BaseClass.testbase;

public class Homepage extends testbase {

	@FindBy(xpath = "//td[contains(text(),'User: Demo User ')]")
	@CacheLookup//create temporary memoy to store element for fast exectuion
	WebElement usernamevalidation;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactslink;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	// @FindBy(xpath =
	// "/html/body/table[1]/tbody/tr[3]/td[1]/div/div/ul/li[4]/ul/li[1]/a")
	WebElement newcontactlink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealslink;

	@FindBy(xpath = "//a[contains(text(),'Forms')]")
	WebElement Formslink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement Taskslink;

	// @FindBy(xpath="//a[contains(text(),'New Task')]")
	@FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[6]/ul/li[1]/a")
	WebElement newtasklink;
	// Constructor of the page to initialise the page objects

	public Homepage() {
		PageFactory.initElements(driver, this);

	}

	public String verifypagetitle() {
		return driver.getTitle();
	}

	public boolean verifyusernamelabel() {
		return usernamevalidation.isDisplayed();
	}

	public Contactspage clickoncontacts() {
		contactslink.click();
		return new Contactspage();

	}

	public Dealspage clickondeals() {
		dealslink.click();
		return new Dealspage();

	}

	public Formspage clickonforms() {
		Formslink.click();
		return new Formspage();

	}

	public Taskspage clickontasks() {
		Taskslink.click();
		return new Taskspage();

	}

	public void Clickonnewcontactlink() throws InterruptedException

	{
		// Actions action = new Actions(driver);
		  //action.moveToElement(contactslink).build().perform();
		Actions builder = new Actions(driver);
		builder.moveToElement(contactslink).build().perform();
		builder.moveToElement(newcontactlink).click().perform();
		/*
		 * WebDriverWait wait = new WebDriverWait(driver,5);
		 * wait.until(ExpectedConditions.visibilityOf(newcontactlink));
		 * wait.until(ExpectedConditions.elementToBeClickable(newcontactlink));
		 */

		
		 
		 

		newcontactlink.click();

	}

	public void Clickonnewtasklink() {
		Actions action = new Actions(driver);
		action.moveToElement(Taskslink).build().perform();
		newtasklink.click();

	}

}
