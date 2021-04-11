package com.myPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author sudhanshu
 *
 */
public abstract class Page {

/**
 * Creating a variable for webdriver and wait
 */
	WebDriver driver;
	WebDriverWait wait;
	final static Logger log=Logger.getLogger(Page.class);

	//Creating a constructor for abstract Page class
/**
 * 
 * @param driver
 */
	public Page(WebDriver driver) {
		this.driver=driver;
		log.debug("Calling driver in Page :"+driver.manage().toString());
		this.wait=new WebDriverWait(driver, 15);
	}

	//Creating abstract methods without implementation only declaration
	/**
	 * 
	 * @return
	 */
	public abstract String getPageTitle();
	public abstract String getPageHeader(By locator);
	public abstract WebElement getElement(By locator);
	public abstract void waitForElementPresent(By locator); 
	public abstract void waitForPageTitle(String title);

	/**
	 * 
	 * @param PageClass
	 * @return
	 */
	public <TPage extends BasePage> TPage getInstance(Class<TPage> PageClass) {

		try {
			log.debug("Generic Lib to get instance of driver :"+PageClass.getTypeName());
			return PageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}
		catch (Exception e) {
			log.error("Error Occurred :"+e.getMessage());
			e.getStackTrace();
			return null;
		}
	}
}



