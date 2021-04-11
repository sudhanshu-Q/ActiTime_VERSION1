/**
 * 
 */
package com.MyTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myPages.Homepage;
import com.myPages.LoginPage;

/**
 * @author sudhanshu
 *
 */
public class LoginTest extends BaseTest{
	
	@Test(priority=1)
	public void verifyloginPageTitleTest()
	{
	String title=page.getInstance(LoginPage.class).getPageTitle();
	Assert.assertEquals(title, "Please identify yourself");
	}
	@Test(priority=2)
	public void verifyLoginPageHeader()
	{
		String headerStr=page.getInstance(LoginPage.class).getLoginPageHeader();
		System.out.println("Heaser");
		Assert.assertEquals(headerStr, "DDDDD");
	}
	@Test(priority=3)
	public void doLoginTest()
	{
		Homepage homepage=page.getInstance(LoginPage.class).doLogin("admin", "manager");
		String homepageHeader=homepage.getLoginPageHeader();
System.out.println(homepageHeader);
Assert.assertEquals(homepageHeader, "dawda");
	}
}
