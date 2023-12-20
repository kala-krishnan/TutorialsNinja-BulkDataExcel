package com.tutorialNinjas.bulktesting.stepdefinitions;


import org.openqa.selenium.WebDriver;

import com.tutorialNinjas.bulktesting.driverfactory.DriverManager;

import io.cucumber.java.Before;

public class Hooks {
	
	public static WebDriver driver;
	DriverManager currentDriver= new DriverManager();
	
	 @Before
	    public void beforeScenario() {
	    	
	    	try {
	    	
	    	if(driver== null) {
	    		driver = currentDriver.launchBrowser();
	    		driver.manage().window().maximize();
	    	
	    	}
//	    	LOG.info("Browser is launched");
	    }
	    catch (Exception e) {
	    	e.printStackTrace();
	    }
	    }
	 public static WebDriver getDriver() {
			return driver;
		}
		

}
