package com.CRM.qa.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.CRM.qa.utils.WebEventListener;
import com.CRM.qa.utils.testutils;

public class testbase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener; 

	public testbase() { // reading config.properties file

		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\LENOVO\\Tracing\\FreeCRMTest"
					+ "\\src\\main\\java\\com\\CRM\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initialisation() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\\\selenium-java\\\\Chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("IEDriver")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\LENOVO\\Downloads\\Compressed\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		e_driver= new EventFiringWebDriver(driver);
		//Creating object of WebEventListener class and registering it with EventFiriningWebDriver
		eventlistener =new WebEventListener();
		e_driver.register(eventlistener);
		driver=e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(testutils.PADE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(testutils.IMPLICT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
