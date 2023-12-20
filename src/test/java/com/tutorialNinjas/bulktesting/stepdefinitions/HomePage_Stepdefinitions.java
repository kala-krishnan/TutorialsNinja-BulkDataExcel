package com.tutorialNinjas.bulktesting.stepdefinitions;

import com.tutorialNinjas.bulktesting.pageobjects.LandingPage_PageObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class HomePage_Stepdefinitions {
	
	TestContext testContext;
	LandingPage_PageObject landingPage;
	String actualTitle="";
	
	public HomePage_Stepdefinitions(TestContext testContext)
	{
		this.testContext = testContext;
		this.landingPage = testContext.pageManager.getLandingPage();
	}
	
	@Given("User launch the browser and user is in the Tutorial ninja home page")
	public void user_launch_the_browser_and_user_is_in_the_tutorial_ninja_home_page() {
		landingPage.launchHome();
	}

	@Then("User should redirect to the Tutorials Ninja Home Page")
	public void user_should_redirect_to_the_tutorials_ninja_home_page() {
		actualTitle = landingPage.getTitle();
		Assert.assertEquals("Your Store", actualTitle);
	}
	@When("User clicks register from myaccount dropdown")
	public void user_clicks_register_from_myaccount_dropdown() throws InterruptedException {
		landingPage.clickRegisterSelectBox();
	}
	@Then("User should redirect to the Tutorials Ninja register page")
	public void user_should_redirect_to_the_tutorials_ninja_register_page() {
		actualTitle = landingPage.getTitle();
		Assert.assertEquals("Register Account", actualTitle);
	}

	
	

}
