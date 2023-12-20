package com.tutorialNinjas.bulktesting.stepdefinitions;

import java.io.IOException;

import com.tutorialNinjas.bulktesting.pageobjects.LandingPage_PageObject;
import com.tutorialNinjas.bulktesting.pageobjects.RegisterPage_Pageobjects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class RegisterPage_Stepdefinitions {
	
	TestContext testContext;
	RegisterPage_Pageobjects registerPage;
	LandingPage_PageObject landingPage;
	String message;
	
	public RegisterPage_Stepdefinitions(TestContext testContext)
	{
		this.testContext = testContext;
		registerPage = testContext.pageManager.getRegisterPage();
		landingPage= testContext.pageManager.getLandingPage();
	}
	
	@Given("The user is in the register page")
	public void the_user_is_in_the_register_page() {
		System.out.println("The user is in register page");
	}

	@When("the user clicks continue button after giving the details using {string} and {string}")
	public void the_user_clicks_continue_button_after_giving_the_details_using_and(String string, String string2) throws IOException, InterruptedException {
		registerPage.enterDetails(string,string2);
	}

	@Then("the user has to be registered successfully")
	public void the_user_has_to_be_registered_successfully() {
		message = registerPage.getMessage();
		Assert.assertEquals("Your Account Has Been Created!", message);
	}
	@When("the user clicks logout option from MyAccount")
	public void the_user_clicks_logout_option_from_my_account() throws InterruptedException {
		registerPage.logoutSuccess();
	}

	@Then("the user has to be logged out successfully")
	public void the_user_has_to_be_logged_out_successfully() {
		message = registerPage.getMessage();
		Assert.assertEquals("Account Logout", message);
	}
	@Given("The user is in the register page for invalid scenario")
	public void the_user_is_in_the_register_page_for_invalid_scenario() throws InterruptedException {
		landingPage.clickRegisterSelectBox();
	}
	

	@When("the user clicks continue button after giving invalid details using {string} and {string}")
	public void the_user_clicks_continue_button_after_giving_invalid_details_using_and(String string, String string2) throws IOException, InterruptedException {
		registerPage.enterInvalidDetails(string, string2);
	}

	@Then("the user should not be registered")
	public void the_user_should_not_be_registered() {
		message = registerPage.getMessage();
		System.out.println("The error Message are " +message);
	}

}
