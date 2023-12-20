package com.tutorialNinjas.bulktesting.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(plugin = {"pretty","html:target/cucumber.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"json:target/cucumber.json",
		"junit:target/JUNITReports/reports.xml"},
		monochrome=true,
		publish = true, //console output color
		features = "src/test/resources/feature", //location of feature files
		glue= {"com.tutorialNinjas.bulktesting.stepdefinitions"} )
public class RunnerFile {

}
