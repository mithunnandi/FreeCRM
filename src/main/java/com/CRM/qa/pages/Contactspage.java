package com.CRM.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.CRM.qa.BaseClass.testbase;

public class Contactspage extends testbase {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement Contactslabel;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(xpath="//tbody/tr[8]/td[2]/input[3]")
	WebElement company;

	public Contactspage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifycontactslabel() {
		return Contactslabel.isDisplayed();
	}

	public void selectContactsbyname(String name) {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//a[text()='" + name + "']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}

	
		

	public void createnewcontact(String title, String ftname, String lname, String comp) {
		// TODO Auto-generated method stub
	
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstname.sendKeys(ftname);
		lastname.sendKeys(lname);
		company.sendKeys(comp);
		WebElement SaveBtn=driver.findElement(By.xpath("//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]"));
		SaveBtn.click();
	}
		
	}

