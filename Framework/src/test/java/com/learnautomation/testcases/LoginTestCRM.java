package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class LoginTestCRM extends BaseClass {//we use here inheritence approaches
	
	
	/*
	 * WebDriver driver;
	 * 
	 * @BeforeClass public void setup() {
	 * driver=BrowserFactory.startApplication(driver, "Chrome",
	 * "https://ui.freecrm.com/");
	 * 
	 * }
	 */
	
	
	@Test
	public void loginApp()
	{
	  loggers=report.createTest("Login Test CRM");
		//here logger give response all the activity about test fail,pass etc..
		//ExcelDataProvider excel=new ExcelDataProvider();
		//excel.getStringData("Login", 0, 0);
		//System.out.println(driver.getTitle());
		//we use here actually abstraction java features
		//we use here inherit the LoginPage functionality
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		
			loggers.info("This is Starting application");	
		//loginpage.loginToCRM("Selenium_50", "Abcd@123456");
		//we use here username and password from excel sheet
		loginpage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		loggers.pass("successfully");
	
	}
	/*
	 * @AfterClass public void tearDown() { BrowserFactory.quitBrowser(driver); }
	 */
	
}
