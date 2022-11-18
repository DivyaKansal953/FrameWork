package com.testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.PhotoPage;
import com.util.BrowserFactory;
import com.util.Helper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PhotoTest extends BaseClass {

	@Test
	public void Home()
	{
		
		logger = report.createTest("Launching the URL.");
        
	    PhotoPage photopage = PageFactory.initElements(driver,PhotoPage.class);
	    System.out.println("Title is "+driver.getTitle());
	    logger.info("Starting Application.");
	    logger.pass("Launched Successfully.");
	    photopage.NavigateToGallery();
	   
	    
	    Helper.captureScreenshot(driver);
	    
	}
	
}
