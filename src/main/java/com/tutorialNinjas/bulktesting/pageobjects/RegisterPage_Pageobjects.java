package com.tutorialNinjas.bulktesting.pageobjects;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialNinjas.bulktesting.utility.ExcelDataMapUtils;

public class RegisterPage_Pageobjects {
	
	WebDriver driver;
	
	@FindBy(id="input-firstname")
	WebElement firstName;
	
	@FindBy(id="input-lastname")
	WebElement lastName;
	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-telephone")
	WebElement telephone;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(id="input-confirm")
	WebElement confirmPassword;
	
	@FindBy(xpath ="//label[normalize-space()='Yes']")
	WebElement subcribeYes;
	
	@FindBy(xpath ="//label[normalize-space()='No']")
	WebElement subcribeNo;
	
	@FindBy(name="agree")
	WebElement agreeValue;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueButton;
	
	String subcribeValue="Yes";
	
	@FindBy(xpath ="//div[@id='content']/form")
	List<WebElement> formData;
	
	@FindBy(id="content")
	WebElement successMessage;
	
	@FindBy(xpath = "//a//span[contains(@class,'caret')]")
	WebElement myAccountSelectBox;
	
	@FindBy(linkText = "Logout")
	WebElement logoutButton;
	
	@FindBy(className = "text-danger")
	WebElement errorMessage;
	
	String message="";
	public RegisterPage_Pageobjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterDetails(String keyoption,String sheetName) throws IOException, InterruptedException
	{
		
		List<Map<String, String>> excelRegisterList = ExcelDataMapUtils.batchXLdata(keyoption,sheetName);
		
		for(Map<String, String> data: excelRegisterList)
		{
		firstName.sendKeys(data.get("FirstName"));
		lastName.sendKeys(data.get("LastName"));
		email.sendKeys(data.get("email"));
		telephone.sendKeys(data.get("telephone"));
		password.sendKeys(data.get("password"));
		confirmPassword.sendKeys(data.get("confirmpassword"));
		if(data.get("subcribeValue") == "Yes")
		{
			subcribeYes.click();
		}
		else if(data.get("subcribeValue") == "No")
		{
			subcribeNo.click();
		}
		agreeValue.click();
		continueButton.click();
//		driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=account/register");
//		driver.navigate().refresh();
		Thread.sleep(2000);
//		clearWebElements(formData);
		message = successMessage.getText();
		
		}
		
		
	}
	public void clearWebElements(List<WebElement> formData)
	{
		for(WebElement formedData : formData)
		{
			formedData.clear();
		}
	}
	
	public void logoutSuccess() throws InterruptedException
	{
		myAccountSelectBox.click();
		Thread.sleep(3000);
		logoutButton.click();
//		Thread.sleep(2000);
		message = successMessage.getText();
		
	}
	
	public void enterInvalidDetails(String keyoption,String sheetName) throws IOException, InterruptedException
	{
		List<Map<String, String>> excelRegisterList = ExcelDataMapUtils.batchXLdata(keyoption,sheetName);
		for(Map<String, String> data: excelRegisterList)
		{
		firstName.sendKeys(data.get("FirstName"));
		lastName.sendKeys(data.get("LastName"));
		email.sendKeys(data.get("email"));
		telephone.sendKeys(data.get("telephone"));
		password.sendKeys(data.get("password"));
		confirmPassword.sendKeys(data.get("confirmpassword"));
		if(data.get("subcribeValue") == "Yes")
		{
			subcribeYes.click();
		}
		else if(data.get("subcribeValue") == "No")
		{
			subcribeNo.click();
		}
		agreeValue.click();
		continueButton.click();
		Thread.sleep(1000);
		message = errorMessage.getText();
	}}
	
	public String getMessage()
	{
		return message;
	}

}
