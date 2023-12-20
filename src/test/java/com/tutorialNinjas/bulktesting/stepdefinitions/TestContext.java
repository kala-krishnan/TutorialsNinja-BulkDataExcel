package com.tutorialNinjas.bulktesting.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.tutorialNinjas.bulktesting.driverfactory.DriverManager;
import com.tutorialNinjas.bulktesting.utility.CommonUtility;
import com.tutorialNinjas.bulktesting.utility.PageObjectManager;


public class TestContext {
	
	WebDriver driver;
	CommonUtility comUtils;
	DriverManager currentDriver= new DriverManager();
	public PageObjectManager pageManager;
	
	
	
	public TestContext()
	{
		 if(driver ==  null)
		 {
		driver = Hooks.getDriver();
		 }
		pageManager = new PageObjectManager(driver);
		comUtils = new CommonUtility();
		
	}
	

}
