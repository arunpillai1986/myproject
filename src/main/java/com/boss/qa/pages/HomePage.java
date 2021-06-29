package com.boss.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.boss.qa.base.BasePage;

public class HomePage extends BasePage {
	
	private WebDriver driver;

	
	@FindBy(xpath = "//img[@alt='KWI logo']")
	WebElement logo;
	
	@FindBy(xpath = "//span[normalize-space()='Reporting & Analysis']")
	WebElement reportingAndAnalysis;
	
	@FindBy(xpath = "//a[normalize-space()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath = "//span[normalize-space()='My Favorites']")
	WebElement myFavorites;	
	
	@FindBy(xpath = "//a[normalize-space()='Schedule Reports']")
	WebElement scheduledReportsPageUnderMyFavorites;	
	
	
	@FindBy(linkText = "Sales Performance Reports")
	WebElement salesPerformanceReportLink;
	
	@FindBy(linkText = "Items Reports")
	WebElement itemsReportsLink;
	
	@FindBy(linkText = "Sales Performance Reports")
	WebElement SalesPerformanceReportsLink;	
	
	@FindBy(linkText = "Inventory Reports")
	WebElement InventoryReportsLink;	
	
	@FindBy(xpath = "//body/div/div[@id='cssmenu']/ul/li[@class='section-menu has-sub active open']/ul/li[2]/a[1]")
	WebElement hierarchyOption;
	
	@FindBy(xpath = "//body/div/div[@id='cssmenu']/ul/li[@class='section-menu has-sub active open']/ul/li[3]/a[1]")
	WebElement salesOption;	
	
	@FindBy(xpath = "//body/div/div[@id='cssmenu']/ul/li[@class='section-menu has-sub active open']/ul/li[5]/a[1]")
	WebElement distributionsOption;		
	
	
	@FindBy(linkText = "Finance Reports")
	WebElement financeReportstLink;
	
	@FindBy(xpath = "//body/div/div[@id='cssmenu']/ul/li[@class='section-menu has-sub active open']/ul/li[1]/a[1]")
	WebElement employeeOption;
	
	@FindBy(xpath = "//span[normalize-space()='Sales Audit']")
	WebElement salesAuditOption;
	
	@FindBy(xpath = "//body/div/div[@id='cssmenu']/ul/li[@class='section-menu has-sub open']/ul/li[2]/a[1]")
	WebElement cashOption;		
	
	@FindBy(xpath = "//span[normalize-space()='Cloud 9 POS Emp Productivity']")
	WebElement cloud9POSEMPProductivity;
	
	@FindBy(xpath = "//span[normalize-space()='Cash Receipts Report']")
	WebElement cashReceiptsReport;
	
	@FindBy(xpath = "//span[normalize-space()='Department List']")
	WebElement departmentListReport;	
	
	@FindBy(xpath = "//span[normalize-space()='Condensed Flash Report']")
	WebElement condensedFlashReport;	
	
	@FindBy(xpath = "//span[normalize-space()='Inv. Movement Style-Color-Arti']")
	WebElement invMovementStyleColorArtiReport;	
	
	
	@FindBy(xpath = "//a[normalize-space()='Schedule']")
	WebElement scheduleReportLink;
	
	@FindBy(xpath = "//div[@class='ui-dialog-content ui-widget-content ui-df-content']//iframe")
	WebElement iframeElement;
	

	public HomePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;		
	}

	
	public boolean getKWILogoTest() {
			return logo.isDisplayed();
	}	
		 
		
	public String getHomePageTitle() {
			return driver.getTitle();
	}
	
	
	
	public ReportSchedule getCloud9ReportSchedule() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(reportingAndAnalysis));
		
		Actions action = new Actions(driver);
		action.moveToElement(reportingAndAnalysis).build().perform();
		salesPerformanceReportLink.click();
		employeeOption.click();
		cloud9POSEMPProductivity.click();
		scheduleReportLink.click();
		
		//WebElement iframeElement = driver.findElement(By.xpath("//div[@class='ui-dialog-content ui-widget-content ui-df-content']//iframe"));
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeElement));
		driver.switchTo().frame(iframeElement);

		//driver.navigate().to("http://dendevapp1.kligerweiss.net/schedule-reports/?createSchedule=true&reportShellScript=emp_productivity.rptdesign&repName=Cloud%209%20POS%20Emp%20Productivity");
        return new ReportSchedule(driver);
	}
	
        public ReportSchedule getCashReceiptsReport() {
        
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(reportingAndAnalysis));
        			
		Actions action = new Actions(driver);
		action.moveToElement(reportingAndAnalysis).build().perform();
		financeReportstLink.click();
		salesAuditOption.click();
		cashOption.click();
		cashReceiptsReport.click();
		scheduleReportLink.click();		
		
		//WebElement iframeElement = driver.findElement(By.xpath("//div[@class='ui-dialog-content ui-widget-content ui-df-content']//iframe"));
		//WebDriverWait wait = new WebDriverWait(driver, 40);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeElement));
		driver.switchTo().frame(iframeElement);
		
		//driver.navigate().to("http://dendevapp1.kligerweiss.net/schedule-reports/?createSchedule=true&reportShellScript=emp_productivity.rptdesign&repName=Cloud%209%20POS%20Emp%20Productivity");
        return new ReportSchedule(driver);
	}
        
        public ReportSchedule getDepartmentListReportSchedule() {
    		
    		WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(reportingAndAnalysis));
    		
    		Actions action = new Actions(driver);
    		action.moveToElement(reportingAndAnalysis).build().perform();
    		itemsReportsLink.click();    		
    		hierarchyOption.click();
    		departmentListReport.click();
    		scheduleReportLink.click();
   		    driver.switchTo().frame(iframeElement);

            return new ReportSchedule(driver);
    	}
        
        public ReportSchedule getCondensedFlashReportSchedule() {
    		
    		WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(reportingAndAnalysis));
    		
    		Actions action = new Actions(driver);
    		action.moveToElement(reportingAndAnalysis).build().perform();
    		SalesPerformanceReportsLink.click();
    		salesOption.click();
    		condensedFlashReport.click();    		
    		scheduleReportLink.click();
   		    driver.switchTo().frame(iframeElement);

            return new ReportSchedule(driver);
    	}
        
       public ReportSchedule getInvMovementStyleColorArtiReportSchedule() {
    		
    		WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(reportingAndAnalysis));
    		
    		Actions action = new Actions(driver);
    		action.moveToElement(reportingAndAnalysis).build().perform();
    		
    		InventoryReportsLink.click();
    		distributionsOption.click();
    		invMovementStyleColorArtiReport.click();
    		scheduleReportLink.click();
   		    driver.switchTo().frame(iframeElement);

            return new ReportSchedule(driver);
    	}
       
       public ReportSchedule getScheduledReportsPage() {
   		
   		WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(myAccount));
   		
   		Actions action = new Actions(driver);
   		action.moveToElement(myAccount).build().perform();
   		action.moveToElement(myFavorites).build().perform();  		
   		scheduledReportsPageUnderMyFavorites.click();
   		
        return new ReportSchedule(driver);
   	}
	
}
