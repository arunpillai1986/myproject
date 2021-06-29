package com.boss.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.boss.qa.base.BasePage;


public class LoginPage extends BasePage {
	
	
	private WebDriver driver;
	
	
	
	
	@FindBy(id = "username")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(xpath = "//button[@class='button--primary full-width mb2']")
	WebElement signInButton;
	
	

	// 1. By locators -- OR
	//By username = By.id("username");
	//By password = By.id("password");
	//By loginButton = By.xpath("//button[@class='button--primary full-width mb2']");
	

	// 2. create constructor of page class:
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;	
		
	}

	// 3. page actions:
		
		public String getLoginPageTitle() {
			return driver.getTitle();
		}	
		 
		public HomePage doLogin(String un, String pw) {
			
			username.sendKeys(un);
			password.sendKeys(pw);
			signInButton.click();	
			
			return new HomePage(driver);

		}
	
}
