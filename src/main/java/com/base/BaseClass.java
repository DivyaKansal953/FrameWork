package com.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.util.BrowserFactory;
import com.util.ConfigDataProvider;
//import com.util.ExcelDataProvider;
import com.util.Helper;


public class BaseClass {

	public WebDriver driver;
	//public ExcelDataProvider excel;
	private static final Logger s_logger = LoggerFactory.getLogger(BaseClass.class);
	public ConfigDataProvider config;
	public ExtentReports report;
	public static ExtentTest logger;
	@BeforeSuite
	public void setUpSuite()
	{
		Reporter.log("Setting up reports and Test is getting ready", true);
		//excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		String path = System.getProperty("user.dir")+"/Test-Reports/zeeReport"+Helper.getCurrentDateTime()+".html";
		ExtentSparkReporter extent = new ExtentSparkReporter(path);
	    report = new ExtentReports();
	    report.attachReporter(extent);
	    Reporter.log("Setting Done- Test can be Started", true);
	    try {
			FileUtils.cleanDirectory(new File("Screenshots"));
			FileUtils.cleanDirectory(new File("Test-Reports"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@BeforeClass
	public void setup()
	{
		Reporter.log("Trying to start Browser and getting Application ready.", true);
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());
		Reporter.log("Browser and Application is up and running.", true);
	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
		
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		Reporter.log("Test is about to End", true);
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
	       
		}

		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		   
		}
		report.flush();
		Reporter.log("Test Completed>>> Reports Generated.", true);
	}
}
