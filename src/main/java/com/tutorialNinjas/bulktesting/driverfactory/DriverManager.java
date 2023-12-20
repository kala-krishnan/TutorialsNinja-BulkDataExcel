package com.tutorialNinjas.bulktesting.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import io.github.bonigarcia.wdm.WebDriverManager;



public class DriverManager {
private  WebDriver driver=null;
//private static final Logger LOG=LogManager.getLogger(DriverManager.class);

	
	public  WebDriver launchBrowser() {
		try {
			String browserName="chrome";
			System.out.println("Printing driver value " +driver);
			if(driver == null)
			{
				System.out.println("one more time");
			switch (browserName) {
			
			case "chrome":
				WebDriverManager.chromedriver().driverVersion("115.0.5790.170").setup();
				driver= new ChromeDriver();
//				LOG.info("Launching browser:" +browser_Name);
				break;
			case "edge":
				driver = new EdgeDriver();
//				LOG.info("Launching browser:" +browser_Name);
				break;
				
			case "safari":
				System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
				SafariOptions options = new SafariOptions();
				options.setCapability("pageLoadStrategy", "normal");
				driver = new SafariDriver(options);
//				LOG.info("Launching browser:" +browser_Name);
				break;
			
				
			default:
			driver= new ChromeDriver();
//			LOG.info("Launching browser:" +browser_Name);
			break;
				
			}
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		return driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	

}
