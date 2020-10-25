package com.CRM.qa.pages;

import org.openqa.selenium.By;
import com.CRM.qa.BaseClass.testbase;

public class Taskspage extends testbase{
	
	
	
	
	
	public void createnewtask(String tit)
	{
		driver.findElement(By.xpath("//input[@id='title']")).sendKeys(tit);
		driver.findElement(By.xpath("//body[1]/table[2]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/fieldset[1]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")).click();
		
		
	}

}
