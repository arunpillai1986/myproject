package com.boss.qa.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.boss.qa.pages.HomePage;
import com.boss.qa.pages.LoginPage;
import com.boss.qa.pages.ReportSchedule;
import com.boss.qa.pages.ScheduledReportsPage;

public class BaseTest {
	
	public WebDriver driver;
    public  BasePage basePage;
    public LoginPage loginPage;
    public HomePage homePage;
    public ReportSchedule reportSchedule;
    public ScheduledReportsPage scheduledReportsPage;
    public Properties prop;

	/*@BeforeTest
	public void setUp() {
		
		basePage = new BasePage();	
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage (driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}*/
    
    @BeforeMethod
	public void setUp() {
		
		basePage = new BasePage();	
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage (driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	

}
