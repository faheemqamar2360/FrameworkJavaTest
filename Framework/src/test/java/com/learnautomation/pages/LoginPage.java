package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)//create the constructor
	{
		this.driver=ldriver;
	}
	@FindBy(name="email") WebElement uname;
	@FindBy(name="password") WebElement pass;
	@FindBy(xpath="//*[@id='ui']/div/div/form/div/div[3]") WebElement loginButton;
	
	public void loginToCRM(String usernameApplication, String passwordApplication)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		uname.sendKeys(usernameApplication);
		pass.sendKeys(passwordApplication);
		loginButton.click();
	}
}
