package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
/**
 * 
 * @author sudhanshu
 *
 */
public class BasePage extends Page{
	/**
	 * 
	 * @param driver
	 */
	public BasePage(WebDriver driver) {
		super(driver);

	}
	/**
	 * Method overriding
	 */
	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}
	/**
	 * Method overriding
	 */
	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}
	/**
	 * Method overriding
	 */
	@Override
	public WebElement getElement(By locator) {
		WebElement element=null;
		try {
			waitForElementPresent(locator);
			element=driver.findElement(locator);
			return element;

		} catch (Exception e) {
			System.out.println("some error occurred"+locator.toString());
			e.printStackTrace();
		}
		return element;
	}
	/**
	 * Method overriding
	 */
	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println("Some errro occurred"+locator.toString());
		}
		/**
		 * Method overriding
		 */
	}
	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			System.out.println("Some error occuredd"+title);
			e.printStackTrace();
		}

	}

}
