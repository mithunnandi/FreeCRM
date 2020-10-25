package com.CRM.qa.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.file.*;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.CRM.qa.BaseClass.testbase;

public class testutils extends testbase {
private static final String FileUtils = null;
public static long PADE_LOAD_TIMEOUT=40;
public static long IMPLICT_WAIT=10;

public static String TESTDATA="C:\\Users\\LENOVO\\Tracing\\FreeCRMTest\\src\\main\\java\\com\\CRM\\qa\\testdata\\testdataCRM_contact.xlsx";
static Workbook book;
static org.apache.poi.ss.usermodel.Sheet sheet;

public void switchtoframe()
{ driver.switchTo().frame("mainpanel");
	}

public void ScrollDown() {
	// TODO Auto-generated method stub
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
	
}

public static Object[][] gettestdata(String sheetname)
{ FileInputStream file=null;
	try {
		file=new FileInputStream(TESTDATA);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		book=WorkbookFactory.create(file);
	} catch (EncryptedDocumentException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
sheet=book.getSheet(sheetname);
Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
for(int i=0;i<sheet.getLastRowNum();i++)
{for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
	data[i][k]=sheet.getRow(i+1).getCell(k).toString();
}
	}
return data;
}
public static void takeScreenshotAtEndOfTest () throws IOException
{
	File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
String currentDir= System.getProperty("user.dir");


org.apache.commons.io.FileUtils.copyFile(scrFile,new File(currentDir+"/screenshots/" +System.currentTimeMillis()+".png"));
}

}
