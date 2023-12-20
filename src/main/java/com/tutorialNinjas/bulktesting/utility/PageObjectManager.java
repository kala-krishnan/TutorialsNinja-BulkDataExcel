package com.tutorialNinjas.bulktesting.utility;

import org.openqa.selenium.WebDriver;

import com.tutorialNinjas.bulktesting.pageobjects.LandingPage_PageObject;
import com.tutorialNinjas.bulktesting.pageobjects.RegisterPage_Pageobjects;

public class PageObjectManager {
	WebDriver driver;
	
	LandingPage_PageObject landingPage;
	RegisterPage_Pageobjects registerPage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	public LandingPage_PageObject getLandingPage() {
		
		if(landingPage == null)
		{
			landingPage = new LandingPage_PageObject(driver);
		}
		return landingPage;
	}

	public RegisterPage_Pageobjects getRegisterPage() {
		
		if(registerPage == null)
		{
			registerPage = new RegisterPage_Pageobjects(driver);
		}
		return registerPage;
	}
}
