package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhotoPage {

	WebDriver driver;
	public PhotoPage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	@FindBy(xpath="//a[@class='photos_menu']") WebElement PhotoXpath;
	public void NavigateToGallery()
	{
		
	    PhotoXpath.click();
	}
}
