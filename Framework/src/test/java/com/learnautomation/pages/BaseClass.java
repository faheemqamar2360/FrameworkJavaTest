package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest loggers;
	@BeforeSuite
	public void setUpSuite()
	{
	 excel=new ExcelDataProvider();
	 config=new ConfigDataProvider();
	 
	 ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/reports/crm"+Helper.getCurrentDateTime()+".html"));
	 report = new ExtentReports();
	 report.attachReporter(extent);
	}
	
	@BeforeClass
	public void setup() {
		//<<<<we use here now direct data from config file>>>>
		//driver=BrowserFactory.startApplication(driver, "Chrome", "https://ui.freecrm.com/");
		driver=BrowserFactory.startApplication(driver, config.getBrowser(),config.getStagingURL());

	}
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);
			try {
				loggers.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				System.out.println("This test pass");
			}
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			try {
				loggers.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				System.out.println("This test failed");
				
			}

		}
		report.flush();
		
	}
	
}
