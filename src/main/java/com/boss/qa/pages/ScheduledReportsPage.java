package com.boss.qa.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.boss.qa.base.BasePage;
import com.boss.qa.utils.CommonUtilities;

public class ScheduledReportsPage extends BasePage{
	
	private WebDriver driver;
	CommonUtilities commonUtilities = new CommonUtilities(driver);
	
	@FindBy(xpath = "//li//span[@class='ui-messages-info-detail']")
	WebElement scheduledReportMessage;
	
	@FindBy(xpath = "//h1[normalize-space()='Scheduler']")
	WebElement scheduleText;
	
	@FindBy(css = "div[id='searchScheduleReportTable'] div:nth-child(2) div:nth-child(2)")
	WebElement scheduledReportLocation;
	
	@FindBy(xpath = "//div[@id='report-container']//div[2]//div[9]//a[3]")
	WebElement scheduledReportParamLink;
	
	@FindBy(xpath = "//h1[normalize-space()='Schedule Report Parameters']")
	WebElement scheduledReportParametersText;
	
	@FindBy(xpath = "//span[@id='j_idt201:0:paramScheduleReportDetailsField']")
	WebElement scheduledReportNameInParameters;
	
	@FindBy(xpath = "//span[@id='j_idt201:1:paramScheduleReportDetailsField']")
	WebElement scheduledReportCalendarTypeInParameters;
	
	@FindBy(xpath = "//span[@id='j_idt201:2:paramScheduleReportDetailsField']")
	WebElement scheduledReportFrequencyInParameters;
	
	@FindBy(xpath = "//span[@id='j_idt201:3:paramScheduleReportDetailsField']")
	WebElement scheduledReportReportStartDateInParameters;
	
	@FindBy(xpath = "//span[@id='j_idt201:4:paramScheduleReportDetailsField']")
	WebElement scheduledReportReportEndDateInParameters;
	
	@FindBy(xpath = "//span[@id='j_idt201:6:paramScheduleReportDetailsField']")
	WebElement scheduledReportTimeZoneInParameters;
	
	@FindBy(xpath = "//span[@id='j_idt210:0:paramScheduleReportParametersField']")
	WebElement scheduledReportPeriodInParameters;
	
	@FindBy(xpath = "//span[@id='j_idt210:1:paramScheduleReportParametersField']")
	WebElement scheduledReportStoreInParameters;
	
	@FindBy(xpath = "//span[@id='j_idt210:2:paramScheduleReportParametersField']")
	WebElement scheduledReportTransactiontypesInParameters;
	
	@FindBy(xpath = "//span[@id='j_idt219:0:paramScheduleReportDeliveryField']")
	WebElement scheduledReportReportFormatInParameters;
	
	@FindBy(xpath = "//span[@id='j_idt219:1:paramScheduleReportDeliveryField']")
	WebElement scheduledReportEmailRecipientsInParameters;
	
	@FindBy(xpath = "//span[@id='j_idt219:2:paramScheduleReportDeliveryField']")
	WebElement scheduledReportEmailGroupInParameters;
	
	@FindBy(xpath = "//span[@id='j_idt219:3:paramScheduleReportDeliveryField']")
	WebElement scheduledReportEmailSubjectInParameters;
	
	@FindBy(xpath = "//span[@id='j_idt219:4:paramScheduleReportDeliveryField']")
	WebElement scheduledReportEmailReportBodyInParameters;
	
	@FindBy(xpath = "//a[@onclick=\"hideDialog('paramScheduleReportDialog');return false;\"]")
	WebElement scheduledReportOkLinkToCloseParametersForm;

	


	

	public ScheduledReportsPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;		
	}
	
	public boolean getReportSuccessMessage() {
		 return scheduledReportMessage.isDisplayed();
	}

	public String getReportSuccessMessageText() {
		 return scheduledReportMessage.getText();
	}
	
	public void getDepartmentListReportParameterFromScheduledReportPageWithNoDatesPeriod() throws SQLException {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));
		
		//==================
		
		Assert.assertTrue(getReportSuccessMessage(), "Report Scheduled successfully message not displayed");

		String actualMessage = getReportSuccessMessageText();

		String expectedMessage = "Report Scheduled successfully";

		Assert.assertEquals(actualMessage, expectedMessage, "Report Scheduled successfully text not matched ");

		// wait.until(ExpectedConditions.elementToBeClickable(scheduledReportLocation));

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String actualReportname = scheduledReportLocation.getText();

		String expectedReportname = "Department List";

		Assert.assertEquals(actualReportname, expectedReportname, "Report not present in scheduled location");

		// getReportScheduledParamForCloud9POSEmpProductivity();
		scheduledReportParamLink.click();

		// commonUtilities.clickElementByJS(driver, scheduledReportParam);

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// wait.until(ExpectedConditions.textToBePresentInElement(scheduledReportParametersText,
		// "Schedule Report Parameters"));

		Assert.assertTrue(scheduledReportParametersText.isDisplayed(),
				"Schedule Report Parameters not displayed on Parameters Form");

		String actualReportnameOnParamters = scheduledReportNameInParameters.getText();

		String expectedReportnameOnParamters = "Cloud 9 POS Emp Productivity";

		Assert.assertEquals(actualReportnameOnParamters, expectedReportnameOnParamters,
				"Report name not matched in Parameters Form");

		String actualCalendarTypeOnParamters = scheduledReportCalendarTypeInParameters.getText();

		String expectedCalendarTypeOnParamters = "Retail";

		Assert.assertEquals(actualCalendarTypeOnParamters, expectedCalendarTypeOnParamters,
				"CalendarType not matched in Parameters Form");

		String actualFrequencyOnParamters = scheduledReportFrequencyInParameters.getText();

		String expectedFrequencyOnParamters = "WEEKLY";

		Assert.assertEquals(actualFrequencyOnParamters, expectedFrequencyOnParamters,
				"Frequency not matched in Parameters Form");

		String actualTimeZoneOnParamters = scheduledReportTimeZoneInParameters.getText();

		String expectedTimeZoneOnParamters = "Asia/Calcutta";

		Assert.assertEquals(actualTimeZoneOnParamters, expectedTimeZoneOnParamters,
				"TimeZone not matched in Parameters Form");

		String actualPeriodOnParamters = scheduledReportPeriodInParameters.getText();

		String expectedPeriodOnParamters = "Business week to date";

		Assert.assertEquals(actualPeriodOnParamters, expectedPeriodOnParamters,
				"Period not matched in Parameters Form");

		String actualStoreOnParamters = scheduledReportStoreInParameters.getText();

		String expectedStoreOnParamters = "0";

		Assert.assertEquals(actualStoreOnParamters, expectedStoreOnParamters, "Store not matched in Parameters Form");

		String actualTransactiontypesOnParamters = scheduledReportTransactiontypesInParameters.getText();

		String expectedTransactiontypesOnParamters = "SC";

		Assert.assertEquals(actualTransactiontypesOnParamters, expectedTransactiontypesOnParamters,
				"Transaction types not matched in Parameters Form");

		String actualReportFormatOnParamters = scheduledReportReportFormatInParameters.getText();

		String expectedReportFormatOnParamters = "XLS";

		Assert.assertEquals(actualReportFormatOnParamters, expectedReportFormatOnParamters,
				"Report Format not matched in Parameters Form");

		String actualEmailRecipientsOnParamters = scheduledReportEmailRecipientsInParameters.getText();

		String expectedEmailRecipientsOnParamters = "arunkumarpi@cyabge.com";

		Assert.assertEquals(actualEmailRecipientsOnParamters, expectedEmailRecipientsOnParamters,
				"Email Recipients not matched in Parameters Form");
		
		String actualEmailGroupOnParamters = scheduledReportEmailGroupInParameters.getText();

		String expectedEmailGroupOnParamters = "300";

		Assert.assertEquals(actualEmailRecipientsOnParamters, expectedEmailRecipientsOnParamters,
				"Email Recipients not matched in Parameters Form");

		String actualEmailSubjectOnParamters = scheduledReportEmailSubjectInParameters.getText();

		String expectedEmailSubjectOnParamters = "Cloud 9 POS Emp Productivity";

		Assert.assertEquals(actualEmailSubjectOnParamters, expectedEmailSubjectOnParamters,
				"Email Subject not matched in Parameters Form");

		String actualEmailReportBodyOnParamters = scheduledReportEmailReportBodyInParameters.getText();

		String expectedEmailReportBodyOnParamters = "Below is the requested report";

		Assert.assertEquals(actualEmailReportBodyOnParamters, expectedEmailReportBodyOnParamters,
				"Email Report Body not matched in Parameters Form");

		scheduledReportOkLinkToCloseParametersForm.click();



	}
	

}
