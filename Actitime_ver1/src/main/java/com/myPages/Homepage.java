package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage extends BasePage {

	private By header=By.xpath("//*[@class='header']");
	
	public WebElement getHeader() {
		return getElement(header);
	}
	public String getloginPageTutle()
	{
		return getPageTitle();
	}
	public String getLoginPageHeader()
	{
		return getPageHeader(header);
	}
	
	
	public Homepage(WebDriver driver) {
		super(driver);
	}
	

}
