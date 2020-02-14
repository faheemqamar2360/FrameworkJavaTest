package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//Screenshot, alerts, frames, windows, sync issue, jaascript executor
	public static String captureScreenshot(WebDriver driver)//why we use static because we call direct to function
	//otherwise if we don't use static than we  need to create again Helper class object
	{
		//we capture the screen shot as a file during running time test
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/screenshots/CRM"+getCurrentDateTime()+".png";
		
		
		try {
			FileHandler.copy(src, new File(screenshotPath));
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot"+e.getMessage());
		}
		return screenshotPath;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentDate=new Date();
		return customFormat.format(currentDate);
	}
	
	

}
