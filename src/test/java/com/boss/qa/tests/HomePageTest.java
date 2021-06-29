package com.boss.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.boss.qa.base.BaseTest;
import com.boss.qa.pages.HomePage;
import com.boss.qa.utils.Constants;


public class HomePageTest extends BaseTest {	

	
	@BeforeClass
	public void homeSetup() {
		
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	
	@Test
	public void verifyHomePageTitleTest() {
		
		String title = homePage.getHomePageTitle();
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE , "Home Page Title Not Matched");
		
	}
	
	@Test
	public void verifyLogoOnHomePage() {		
		
		Assert.assertTrue(homePage.getKWILogoTest(), " Logo not present");
		
	}
	
	
}
