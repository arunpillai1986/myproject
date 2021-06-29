package com.boss.qa.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.boss.qa.base.BasePage;
import com.boss.qa.base.BaseTest;
import com.boss.qa.pages.LoginPage;
import com.boss.qa.utils.Constants;


public class LoginPageTest extends BaseTest {
	
	
	@Test
	public void verifyLoginPageTitleTest() {
		
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE , "Login Page Title Not Matched");
		
	}
	
	@Test
	public void verifyLoginTest() {
		
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	
}
