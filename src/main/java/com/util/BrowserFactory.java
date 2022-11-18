package com.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browserName, String appUrl)
	{
		if(browserName.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		}
		else if(browserName.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("WE do not support this browser.");
		}
		driver.manage().window().maximize();
	//	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	//	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(appUrl);
		return driver;
	}
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
}

