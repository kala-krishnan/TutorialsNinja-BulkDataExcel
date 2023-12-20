package com.tutorialNinjas.bulktesting.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LandingPage_PageObject {
	
	WebDriver driver;
	
	@FindBy(xpath = "//a//span[contains(@class,'caret')]")
	WebElement myAccountSelectBox;
	
	@FindBy(xpath ="//a[normalize-space()='Register']")
	WebElement registerClick;
	String title="";
	
	
	
	public LandingPage_PageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void launchHome()
	{
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		title = driver.getTitle();
	}
 
	public void clickRegisterSelectBox() throws InterruptedException
	{
		System.out.println("Driver in select box" +driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement myAccountSelectBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a//span[contains(@class,'caret')]")));
		myAccountSelectBox.click();
		Thread.sleep(3000);
		registerClick.click();
		title =driver.getTitle();
		
		
	}
	public String getTitle()
	{
		return title;
	}

}
