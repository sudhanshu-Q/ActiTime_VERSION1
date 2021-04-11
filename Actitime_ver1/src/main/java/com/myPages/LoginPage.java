/**
 * 
 */
package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * @author sudhanshu
 *
 */
public class LoginPage extends BasePage{
	
	private By username=By.name("username");
	private By password=By.name("pwd");
	private By loginButton=By.id("loginButton");
	private By header=By.xpath("//*[@class='header']");

	public WebElement getUsername() {
		return getElement(username);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public WebElement getLoginButton() {
		return getElement(loginButton);
	}

	public WebElement getHeader() {
		return getElement(header);
	}
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	public String getloginPageTutle()
	{
		return getPageTitle();
	}
	public String getLoginPageHeader()
	{
		 return getPageHeader(header);
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public Homepage doLogin(String username, String pwd) {
		getUsername().sendKeys(username);
		getPassword().sendKeys(pwd);
		getLoginButton().click();
		return getInstance(Homepage.class);
	}
	public void doLogin() {
		getUsername().sendKeys("");
		getPassword().sendKeys("");
		getLoginButton().click(); 
}

}