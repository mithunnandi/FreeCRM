package com.CRM.qa.utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.CRM.qa.BaseClass.testbase;

public class WebEventListener extends testbase implements WebDriverEventListener {

	 public void beforeNavigateTo(final String url, final WebDriver driver) {
	        System.out.println("Before navigating to: '" + url + "'");
	    }
	    
	    public void afterNavigateTo(final String url, final WebDriver driver) {
	        System.out.println("Navigated to:'" + url + "'");
	    }
	    
	    public void beforeChangeValueOf(final WebElement element, final WebDriver driver) {
	        System.out.println("Value of the:" + element.toString() + " before any changes made");
	    }
	    
	    public void afterChangeValueOf(final WebElement element, final WebDriver driver) {
	        System.out.println("Element value changed to: " + element.toString());
	    }
	    
	    public void beforeClickOn(final WebElement element, final WebDriver driver) {
	        System.out.println("Trying to click on: " + element.toString());
	    }
	    
	    public void afterClickOn(final WebElement element, final WebDriver driver) {
	        System.out.println("Clicked on: " + element.toString());
	    }
	    
	    public void beforeNavigateBack(final WebDriver driver) {
	        System.out.println("Navigating back to previous page");
	    }
	    
	    public void afterNavigateBack(final WebDriver driver) {
	        System.out.println("Navigated back to previous page");
	    }
	    
	    public void beforeNavigateForward(final WebDriver driver) {
	        System.out.println("Navigating forward to next page");
	    }
	    
	    public void afterNavigateForward(final WebDriver driver) {
	        System.out.println("Navigated forward to next page");
	    }
	    
	    public void onException(final Throwable error, final WebDriver driver) {
	        System.out.println("Exception occured: " + error);
	        try {
	            testutils.takeScreenshotAtEndOfTest();
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void beforeFindBy(final By by, final WebElement element, final WebDriver driver) {
	        System.out.println("Trying to find Element By : " + by.toString());
	    }
	    
	    public void afterFindBy(final By by, final WebElement element, final WebDriver driver) {
	        System.out.println("Found Element By : " + by.toString());
	    }
	    
	    public void beforeScript(final String script, final WebDriver driver) {
	    }
	    
	    public void afterScript(final String script, final WebDriver driver) {
	    }
	    
	    public void beforeAlertAccept(final WebDriver driver) {
	    }
	    
	    public void afterAlertAccept(final WebDriver driver) {
	    }
	    
	    public void afterAlertDismiss(final WebDriver driver) {
	    }
	    
	    public void beforeAlertDismiss(final WebDriver driver) {
	    }
	    
	    public void beforeNavigateRefresh(final WebDriver driver) {
	    }
	    
	    public void afterNavigateRefresh(final WebDriver driver) {
	    }
	    
	    public void beforeChangeValueOf(final WebElement element, final WebDriver driver, final CharSequence[] keysToSend) {
	    }
	    
	    public void afterChangeValueOf(final WebElement element, final WebDriver driver, final CharSequence[] keysToSend) {
	    }
	    
	    public <X> void afterGetScreenshotAs(final OutputType<X> arg0, final X arg1) {
	    }
	    
	    public void afterGetText(final WebElement arg0, final WebDriver arg1, final String arg2) {
	    }
	    
	    public void afterSwitchToWindow(final String arg0, final WebDriver arg1) {
	    }
	    
	    public <X> void beforeGetScreenshotAs(final OutputType<X> arg0) {
	    }
	    
	    public void beforeGetText(final WebElement arg0, final WebDriver arg1) {
	    }
	    
	    public void beforeSwitchToWindow(final String arg0, final WebDriver arg1) {
	    }

}
