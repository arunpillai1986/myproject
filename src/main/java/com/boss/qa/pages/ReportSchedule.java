package com.boss.qa.pages;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.boss.qa.base.BasePage;
import com.boss.qa.utils.CommonUtilities;

public class ReportSchedule extends BasePage {

	private WebDriver driver;
	CommonUtilities commonUtilities = new CommonUtilities(driver);

	@FindBy(xpath = "//h1[normalize-space()='Scheduler']")
	WebElement scheduleText;

	// step 1 locators
	
	
	@FindBy(xpath = "//input[@id='editReportName']")
	WebElement reportName;	
	
	@FindBy(xpath = "//span[@class='ui-message-error-detail']")
	WebElement reportNameBlankErrorMessage;	
	
	@FindBy(xpath = "//div[@id='reportRunDateMsg']//span[@class='ui-message-error-detail']")
	WebElement fiscalCalendarReportRunDateErrorMessage;

	@FindBy(xpath = "//h1//span[normalize-space()='Retail']")
	WebElement retailCalendarRadioButton;

	@FindBy(xpath = "//span[normalize-space()='Fiscal']")
	WebElement fiscalCalendarRadioButton;

	@FindBy(xpath = "//span[@id='select2-editReportFrequency-container']")
	WebElement frequencyDropdown;
	
	@FindBy(xpath = "//div[@class='selectize-input items full has-options has-items']")
	WebElement timeZoneField;
	
	
	@FindBy(xpath = "//div[@class='selectize-control input--select2 full-width single']//input")
	WebElement timeZoneFieldHasOption;
	
	@FindBy(xpath = "//div[@class='selectize-dropdown-content']//div[@class='option active']")
	WebElement timeZoneSelectValue;
	
	
	@FindBy(xpath = "//div[@class='selectize-input items full has-options has-items']/input")
	WebElement timeZoneFieldInput;
	
	
	
	@FindBy(xpath = "//div[@class='selectize-input items full has-options has-items']/input")
	WebElement timeZoneFieldClear;
		
	@FindBy(xpath = "//div[@id='editReportTimeZoneMsg']//span[@class='ui-message-error-detail']")
	WebElement timeZoneBlankErrorMessage;
	
	@FindBy(xpath = "//span[@id='select2-editReportFrequencyFiscal-container']")
	WebElement fiscalCalendarFrequencyDropdown;
	
	@FindBy(xpath = "//input[@id='editNumDays']")
	WebElement fiscalCalendarEveryDaysInputField;
	
	
	@FindBy(xpath = "//li[normalize-space()='Mon']")
	WebElement fiscalCalendarFrequencyDropdownWeeklyMondayOption;
	
	@FindBy(xpath = "//li[normalize-space()='Wed']")
	WebElement fiscalCalendarFrequencyDropdownWeeklyWedOption;
	
	
	@FindBy(xpath = "//li[normalize-space()='Fri']")
	WebElement fiscalCalendarFrequencyDropdownWeeklyFriOption;
	
	@FindBy(xpath = "//input[@id='editReportMonthlyOnCalendar']")
	WebElement fiscalCalendarFrequencyDropdownMonthlyDaysInput;
	
	@FindBy(xpath = "//select[@id='editReportMonthlyOn']")
	WebElement fiscalCalendarOnDropdown;
	
	
	@FindBy(xpath = "//span[@id='select2-editReportMonthlyOnDaysselect-container']")
	WebElement fiscalCalendarDaysDropdown;	
	
	
	@FindBy(xpath = "//li[@id='select2-editReportFrequency-result-hpho-BIZ_WEEKLY']")
	WebElement firstDayOfWeekOption;

	@FindBy(xpath = "//li[@id='select2-editReportFrequency-result-p9i8-BIZ_MONTHLY']")
	WebElement firstDayOfMonthOption;
	
	@FindBy(xpath = "//input[@id='reportRunDate']")
	WebElement reportRunDateForFiscal;	
	

	@FindBy(xpath = "//span[@id='select2-reportRunTimeselect-container']")
	WebElement runTime;

	@FindBy(xpath = "//input[@id='reportStartDate']")
	WebElement reportStartDate;
	
	@FindBy(xpath = "//div[@id='editReportStartDateMsg']//span[@class='ui-message-error-detail']")
	WebElement startDateFieldErrorMessage;
	
	@FindBy(xpath = "//div[@id='editReportEndDateMsg']")
	WebElement endDateFieldErrorMessage;
	
	@FindBy(xpath = "//div[@id='editReportTimeZoneMsg']//span[@class='ui-message-error-detail']")
	WebElement timeZoneFieldErrorMessage;
	
	@FindBy(xpath = "//input[@id='reportEndDate']")
	WebElement reportEndtDate;

	@FindBy(xpath = "//input[@id='edit-report-next-button']")
	WebElement nextButtonOfDetails;

	// step 2 locators

	@FindBy(xpath = "//div[@id='edit-report-period-retail']//b[@role='presentation']")
	WebElement periodDropdown;
	
	@FindBy(xpath = "//div[@id='edit-report-period-retail']//span[@role='combobox']")
	WebElement departmentListPeriodDropdown;
	
	
	@FindBy(xpath = "//div[@id='editReportPeriodMsg']//span[@class='ui-message-error-detail']")
	WebElement periodDropdownErrorMessage;
	
	@FindBy(xpath = "//span[@id='select2-editReportPeriodFiscal-container']")
	WebElement fiscalPeriodDropdown;
	
	@FindBy(xpath = "//input[@id='reportParamStartDate']")
	WebElement fiscalPeriodStartDate;
	
	@FindBy(xpath = "//input[@id='reportParamEndDate']")
	WebElement fiscalPeriodEndDate;
	
	@FindBy(xpath = "//input[@id='editLastXDays']")
	WebElement fiscalLastxdays;
	
	

	@FindBy(xpath = "//li[@id='select2-editReportPeriodselect-result-c5kb-BIZ_WTD']")
	WebElement businessWeekToDate;

	@FindBy(xpath = "//span[@id='select2-scheduleReportParams2par__comboall_storeselect-container']")
	WebElement storeInputBoxOfParameters;
	
	@FindBy(xpath = "//span[@id='select2-scheduleReportParams4par__comboall_storeselect-container']")
	WebElement storeInputBoxOfParametersForCashReceipts;
			

	@FindBy(xpath = "//span[@id='select2-scheduleReportParams3par__fileselect-container']")
	WebElement transactionTypesDropdown;
	
	@FindBy(xpath = "//span[@id='select2-scheduleReportParams6par__fileselect-container']")
	WebElement sortByDropdown;
	
	@FindBy(xpath = "//span[@id='select2-scheduleReportParams8par__fileselect-container']")
	WebElement reportTypeDropdown;
	
	@FindBy(xpath = "//div[@class='selectize-control input--select2 full-width multi plugin-remove_button']//div[@class='selectize-input items not-full']")
	WebElement clientInputBox;
	
	@FindBy(xpath = "//label[normalize-space()='Client']")
	WebElement clientLabel;
	
	
	@FindBy(xpath = "//span[@id='select2-scheduleReportParams7par__fileselect-container']")
	WebElement businessDayHourOffset;
	
	
	@FindBy(xpath = "//input[@id='edit-report-next-button-step2']")
	WebElement nextButtonOfParameters;

	// step 3 locators

	@FindBy(xpath = "//div[@id='editReportDelivery']//b[@role='presentation']")
	WebElement reportFormatDropdown;
	
	@FindBy(xpath = "//div[@id='editReportFormatMsg']//span[@class='ui-message-error-detail']")
	WebElement blankReportFormatErrorMessage;
	
	@FindBy(xpath = "//input[@id='editReportEmailRecipients']")
	WebElement emailRecipientsInputBox;
	
	@FindBy(xpath = "//div[@id='editReportEmailRecipientsMsg']//span[@class='ui-message-error-detail']")
	WebElement emailRecipientsErrorMessage;	

	@FindBy(xpath = "//span[normalize-space()='Include Me']")
	WebElement includeMeCheckBox;

	@FindBy(xpath = "//input[@id='editReportEmailGroup:select-selectized']")
	WebElement emailGroupInputBox;

	@FindBy(xpath = "//input[@id='editReportDeliveryStore:select-selectized']")
	WebElement storeInputBoxOfDelivery;
	
	@FindBy(xpath = "//input[@id='editReportEmailSubject']")
	WebElement emailSubjectDelivery;
	
	@FindBy(xpath = "//textarea[@id='editReportEmailBody']")
	WebElement emailBodyDelivery;
	
	
	@FindBy(xpath = "//input[@id='editReportEmailSubject']")
	WebElement emailSubjectInputField;
	
	@FindBy(xpath = "//div[@id='editReportEmailSubjectMsg']//span[@class='ui-message-error-detail']")
	WebElement emailSubjectErrorMessage;
	
	@FindBy(xpath = "//textarea[@id='editReportEmailBody']")
	WebElement emailBodyInputField;
	
	@FindBy(xpath = "//div[@id='editReportEmailBodyMsg']//span[@class='ui-message-error-detail']")
	WebElement emailBodyErrorMessage;
	

	@FindBy(xpath = "//input[@id='edit-report-submit-button']")
	WebElement submitButton;

	@FindBy(xpath = "//li//span[@class='ui-messages-info-detail']")
	WebElement scheduledReportMessage;
	
	@FindBy(xpath = "div[id='searchScheduleReportTable'] div:nth-child(2) div:nth-child(2)")
	WebElement scheduledReportLocation;
	
	@FindBy(xpath = "//div[@id='report-container']//div[2]//div[1]//ul[1]//li[1]//label[1]//span[1]")
	WebElement selectReportCheckboxFromScheduledReportPage;
	
	@FindBy(xpath = "//div[@id='report-container']//div[3]//div[1]//ul[1]//li[1]//label[1]//span[1]")
	WebElement selectSecondReportCheckboxFromScheduledReportPage;
		
	@FindBy(xpath = "//div[@class='results-row__col align-text status status-cancelled']")
	WebElement reportStatusCancelledTextOnScheduledReportPage;
	
	@FindBy(xpath = "//div[@class='results-row__col align-text status status-suspended']")
	WebElement reportStatusSuspendedTextOnScheduledReportPage;
	
	@FindBy(xpath = "//div[@class='results-row__col align-text status status-active']")
	WebElement reportStatusActiveTextOnScheduledReportPage;	
	
	@FindBy(xpath = "//input[@id='report-delete-button']")
	WebElement cancelButtonForSelectedReport;
	
	@FindBy(xpath = "//a[@onclick=\"hideDialog('confirmDeleteDialog');reportCancelAction();return false;\"]")
	WebElement confirmYesForCancelSelectedReport;
	
	@FindBy(xpath = "//a[@onclick=\"hideDialog('confirmSuspendDialog');reportSuspendAction();return false;\"]")
	WebElement confirmYesForSuspendSelectedReport;
	
	@FindBy(xpath = "//a[@onclick=\"hideDialog('confirmReactivateDialog');reportReactivateAction();return false;\"]")
	WebElement confirmYesForReactivateSelectedReport;
	
	@FindBy(xpath = "//a[normalize-space()='Ok']")
	WebElement okForReassignSelectedReport;	
	
	@FindBy(xpath = "//input[@id='report-suspend-button']")
	WebElement suspendButtonForSelectedReport;	
	
	@FindBy(xpath = "//input[@id='report-reassign-button']")
	WebElement reassignButtonForSelectedReport;	
	
	@FindBy(xpath = "//input[@id='report-reset-button']")
	WebElement resetButton;	
	
	@FindBy(xpath = "//span[@id='select2-reportRowsList-container']")
	WebElement reportPerPageDropdown;	
	
	@FindBy(xpath = "//span[@id='currentPageRecords']")
	WebElement currentPageRecords;	
	
	@FindBy(xpath = "//div[@class='tile b--gray-medium results-row mb1']")
	WebElement numberOfRowsInScheduledReportsPage;	
	
	@FindBy(xpath = "//div[@id='schedule-reports-table-footer-next-arrow']")
	WebElement reportNextPageArrow;
	
	@FindBy(xpath = "//div[@id='schedule-reports-table-footer-prev-arrow']")
	WebElement reportPrevPageArrow;	
	
	@FindBy(xpath = "//span[@id='select2-reportUserselect-container']")
	WebElement userSelectDropdownForReassign;	
	
	@FindBy(xpath = "//input[@id='report-reactivate-button']")
	WebElement reactivateButtonForSelectedReport;
	
	@FindBy(xpath = "//div[@id='report-container']//div[2]//div[9]//a[3]")
	WebElement scheduledReportParamLink;
	
	@FindBy(xpath = "//div[@id='report-container']//div[2]//div[9]//a[2]")
	WebElement scheduledReportEditLink;
	
	@FindBy(xpath = "//div[@id='report-container']//div[2]//div[8]")
	WebElement scheduledReportOwnerName;
	
	@FindBy(xpath = "//div[@id='report-container']//div[3]//div[8]")
	WebElement scheduledReportOwnerNameTwo;
	
	@FindBy(xpath = "//div[@id='report-container']//div[2]//div[9]//a[1]")
	WebElement scheduledReportRunLink;	
	
	@FindBy(xpath = "//div[@class='ui-dialog-content ui-widget-content ui-df-content']//iframe")
	WebElement iframeElement;
	
	// parameters locators
	
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
	
	@FindBy(xpath = "//span[@id='j_idt210:3:paramScheduleReportParametersField']")
	WebElement scheduledReportStoreInParametersForCashReceiptsReportAllParameters;
	
	@FindBy(xpath = "//span[@id='j_idt210:4:paramScheduleReportParametersField']")
	WebElement scheduledReportSortByParametersForCashReceiptsReportAllParameters;
	
	@FindBy(xpath = "//span[@id='j_idt210:5:paramScheduleReportParametersField']")
	WebElement scheduledReportOffSetParametersForCashReceiptsReportAllParameters;
	
	@FindBy(xpath = "//span[@id='j_idt210:6:paramScheduleReportParametersField']")
	WebElement scheduledReportReportTypeParametersForCashReceiptsReportAllParameters;
	
	@FindBy(xpath = "//span[@id='j_idt219:3:paramScheduleReportDeliveryField']")
	WebElement scheduledReportEmailGroupParametersForCashReceiptsReportAllParameters;
	
	@FindBy(xpath = "//span[@id='j_idt219:4:paramScheduleReportDeliveryField']")
	WebElement scheduledReportEmailSubjectParametersForCashReceiptsReportAllParameters;
	
	@FindBy(xpath = "//span[@id='j_idt219:5:paramScheduleReportDeliveryField']")
	WebElement scheduledReportEmailBodyParametersForCashReceiptsReportAllParameters;
	
	@FindBy(xpath = "//span[@id='j_idt219:2:paramScheduleReportDeliveryField']")
	WebElement scheduledReportStoreOnDeliveryParametersForCashReceiptsReportAllParameters;
	
   // Scheduled Reports page Locators
	
	@FindBy(xpath = "//a[normalize-space()='Help']")
	WebElement HelpButton;	
	
	@FindBy(linkText = "Help on This Page")
	WebElement helpOnThisPageLink;
	
	@FindBy(xpath = "//h1[normalize-space()='Scheduled Reports']")
	WebElement scheduleReportsTextOnHelpPage;	
	
	@FindBy(xpath = "//h1[normalize-space()='Business Objective:']")
	WebElement businessObjectiveTextOnHelpPage;	
	
	@FindBy(xpath = "//input[@id='reportName']")
	WebElement nameFieldForSearch;
	
	@FindBy(xpath = "//span[@id='select2-reportOwnerselect-container']")
	WebElement reportOwnerFieldForSearch;
	
	@FindBy(xpath = "//li[@id='select2-reportOwnerselect-result-1i7t-All']")
	WebElement allOptionForReportOwner;
	
	@FindBy(xpath = "//li[@id='select2-reportOwnerselect-result-fxm8-pa3jas']")
	WebElement adminUser;	
	
	@FindBy(xpath = "//span[@id='select2-reportPeriodselect-container']")
	WebElement reportPeriodFieldForSearch;
	
	@FindBy(xpath = "//div[@class='selectize-input items not-full has-options']/input")
	WebElement reportScheduleStatusFieldForSearch;
	
	@FindBy(xpath = "//div[@class='selectize-input items not-full has-options has-items']/input")
	WebElement reportScheduleStatusFieldForSearchClear;
	
	@FindBy(xpath = "//input[@id='report-search-button']")
	WebElement searchButton;
	
	
	
	
	public ReportSchedule(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public String getBlankReportNameErrorMessage() {
		return reportNameBlankErrorMessage.getText();
    }

	public boolean verifyBlankReportNameErrorMessageDisplayed() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.textToBePresentInElement(reportNameBlankErrorMessage, "Report Name is required"));
		
		return reportNameBlankErrorMessage.isDisplayed();
    }
	
	public String getFiscalCalendarReportBlankRunDateErrorMessage() {
		return fiscalCalendarReportRunDateErrorMessage.getText();
    }

	public boolean verifyFiscalCalendarReportBlankRunDateErrorMessageDisplayed() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.textToBePresentInElement(fiscalCalendarReportRunDateErrorMessage, "Run Date is required"));
		
		return fiscalCalendarReportRunDateErrorMessage.isDisplayed();
    }
	
	public String getFiscalCalendarReportPastRunDateErrorMessage() {
		return fiscalCalendarReportRunDateErrorMessage.getText();
    }

	public boolean verifyFiscalCalendarReportPastRunDateErrorMessageDisplayed() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.textToBePresentInElement(fiscalCalendarReportRunDateErrorMessage, "Report Run Date/Time must be future"));
		
		return fiscalCalendarReportRunDateErrorMessage.isDisplayed();
    }
	
	public String getPastStartDateErrorMessage() {
		return startDateFieldErrorMessage.getText();
    }

	public boolean verifyPastStartDateErrorMessageDisplayed() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.textToBePresentInElement(startDateFieldErrorMessage, "Start Date cannot be past"));
		
		return startDateFieldErrorMessage.isDisplayed();
    }
	
	public String getBlankStartDateErrorMessage() {
		return startDateFieldErrorMessage.getText();
    }

	public boolean verifyBlankStartDateErrorMessageDisplayed() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.textToBePresentInElement(startDateFieldErrorMessage, "Start Date is required"));
		
		return startDateFieldErrorMessage.isDisplayed();
    }
	public String getEndDateBeforeStartDateErrorMessage() {
		return endDateFieldErrorMessage.getText();
    }

	public boolean verifyEndDateBeforeStartDateErrorMessageDisplayed() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.textToBePresentInElement(endDateFieldErrorMessage, "End Date should be after Start date"));
		
		return endDateFieldErrorMessage.isDisplayed();
    }
	
	public String getBlankTimeZoneErrorMessage() {
		return timeZoneFieldErrorMessage.getText();
    }

	public boolean verifyBlankTimeZoneErrorMessageDisplayed() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.textToBePresentInElement(timeZoneFieldErrorMessage, "Time Zone is required"));
		
		return timeZoneFieldErrorMessage.isDisplayed();
    }
	public String getBlankEmailSubjectErrorMessage() {
		return emailSubjectErrorMessage.getText();
    }

	public boolean verifyBlankEmailSubjectErrorMessageDisplayed() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.textToBePresentInElement(emailSubjectErrorMessage, "Email Subject is required"));
		
		return emailSubjectErrorMessage.isDisplayed();
    }
	
	public String getBlankEmailBodyErrorMessage() {
		return emailBodyErrorMessage.getText();
    }

	public boolean verifyBlankEmailBodyErrorMessageDisplayed() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.textToBePresentInElement(emailBodyErrorMessage, "Email Body is required"));
		
		return emailBodyErrorMessage.isDisplayed();
    }
	
	public String getBlankEmailRecipientsErrorMessage() {
		return emailRecipientsErrorMessage.getText();
    }

	public boolean verifyBlankEmailRecipientsErrorMessageDisplayed() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.textToBePresentInElement(emailRecipientsErrorMessage, "One of the following is required: Email Recipients, Email Group, or Store"));
		
		return emailRecipientsErrorMessage.isDisplayed();
    }
	
	public String getInvalidEmailRecipientsErrorMessage() {
		return emailRecipientsErrorMessage.getText();
    }

	public boolean verifInvalidEmailRecipientsErrorMessageDisplayed() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.textToBePresentInElement(emailRecipientsErrorMessage, "Invalid Email Address: arunkumarpi@cyabge"));
		
		return emailRecipientsErrorMessage.isDisplayed();
    }
	
	
	public String getBlankPeriodErrorMessage() {
		return periodDropdownErrorMessage.getText();
    }

	public boolean verifyBlankPeriodErrorMessageDisplayed() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.textToBePresentInElement(periodDropdownErrorMessage, "Report Period is required"));
		
		return periodDropdownErrorMessage.isDisplayed();
    }
	
	public String getBlankReportFormatErrorMessage() {
		return blankReportFormatErrorMessage.getText();
    }

	public boolean verifyBlankReportFormatErrorMessageDisplayed() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.textToBePresentInElement(blankReportFormatErrorMessage, "Report Format is required"));
		
		return blankReportFormatErrorMessage.isDisplayed();
    }
	
	public void getCloud9POSEmpProductivityReportSchedulerTest() throws SQLException{
		
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		// wait.until(ExpectedConditions.visibilityOfElementLocated(scheduleText));//

		Assert.assertTrue(scheduleText.isDisplayed());				


		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 35;
		
		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);
		
		
		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();		
		

		commonUtilities.scrollIntoView(driver, scheduleText);
		
		//commonUtilities.clickElementByJS(driver, periodDropdown);

		periodDropdown.click();		
		
		
		String periodText = "Business month to date";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
		
		
		/*try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);
		
		//commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, "EXCEL");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// emailRecipientsInputBox.sendKeys("arunkumarpi@cyabge.com");

		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();
		
		try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

	}
	
	//*************************************************************************
	
	public void getCloud9POSEmpProductivityReportSchedulerWithFrequencyWeeklyAndPeriodBWTD() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());

		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 16;

		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, periodDropdown);

		periodDropdown.click();

		String periodText = "Business month to date";
		
		String periodWeekText = "Business week to date";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
		
		periodDropdown.click();
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodWeekText);		
		
		String storeValue = "0 - All Data";
				
		storeInputBoxOfParameters.click();

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, storeValue);
		

		
		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();

		commonUtilities.selectReportFormat(driver, "EXCEL");	
		
		emailRecipientsInputBox.sendKeys("arunkumarpi@cyabge.com");

		
		//WebElement includeMeCheckBox;

		String emailGroupText = "Report group-300";
		
		emailGroupInputBox.sendKeys(emailGroupText,Keys.ENTER);

		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();

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

		String expectedReportname = "Cloud 9 POS Emp Productivity";

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

		Assert.assertEquals(actualEmailGroupOnParamters, expectedEmailGroupOnParamters,
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
		
		//==================

		String report_frequency = "BIZ_WEEKLY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "BIZ_WTD";
		String report_name = "Cloud 9 POS Emp Productivity";
		String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
		String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

		
		

		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

		commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newCurrentDate, newFutureDate);

	}

	
	public void getCloud9POSEmpProductivityReportSchedulerWithFrequencyMonthlyAndPeriodBMTD() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());

		frequencyDropdown.click();

		String frequencyText = "FIRST DAY OF MONTH";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, frequencyText);

		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 36;


		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, periodDropdown);

		periodDropdown.click();

		String periodText = "Business month to date";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
		
		String storeValue = "1-Test n/a";
		
        //commonUtilities.clickElementByJS(driver, storeInputBoxOfParameters);
		storeInputBoxOfParameters.click();
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, storeValue);
		
		storeInputBoxOfParameters.click();
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, storeValue);
		

		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();

		commonUtilities.selectReportFormat(driver, "PDF");
		
		emailRecipientsInputBox.sendKeys("arunkumarpi@cyabge.com");
		
		includeMeCheckBox.click();
		
		
		String storeText = "Test n/a-1";
		storeInputBoxOfDelivery.sendKeys(storeText,Keys.ENTER);


		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();
		

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

		String report_frequency = "BIZ_MONTHLY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "BIZ_MTD";
		String report_name = "Cloud 9 POS Emp Productivity";
		String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
		String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

		
		

		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

		commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newCurrentDate, newFutureDate);

	}


	public void getCloud9POSEmpProductivityReportSchedulerWithFrequencyQuarterlyAndPeriodBQTD() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());

		frequencyDropdown.click();

		String frequencyText = "FIRST DAY OF QUARTER";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, frequencyText);

		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 101;

		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);
		

		periodDropdown.click();

		String periodText = "Business quarter to date";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
		
		
		String transactionTypeText = "Sales Only";

		
		transactionTypesDropdown.click();
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, transactionTypeText);

        transactionTypesDropdown.click();
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, transactionTypeText);


		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, reportFormatDropdown);
		
		reportFormatDropdown.click();

		commonUtilities.selectReportFormat(driver, "EXCEL");
		
		
		reportFormatDropdown.click();

		commonUtilities.selectReportFormat(driver, "HTML");	
		
		emailRecipientsInputBox.sendKeys("arunkumarpi@cyabge.com");

		commonUtilities.scrollIntoView(driver, submitButton);		
		
		submitButton.click();

		driver.switchTo().defaultContent();
		

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

		String report_frequency = "BIZ_QUARTERLY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "BIZ_QTD";
		String report_name = "Cloud 9 POS Emp Productivity";
		String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
		String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

		
		

		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

		commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newCurrentDate, newFutureDate);

	}
	
	public void getCloud9POSEmpProductivityReportSchedulerWithFrequencyYearlyAndPeriodBYTD() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());

		frequencyDropdown.click();

		String frequencyText = "FIRST DAY OF YEAR";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, frequencyText);

		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 381;


		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, periodDropdown);

		periodDropdown.click();

		String periodText = "Business year to date";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);

		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();

		commonUtilities.selectReportFormat(driver, "EXCEL");

		emailRecipientsInputBox.sendKeys("arunkumarpi@cyabge.com");

		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

		String report_frequency = "BIZ_YEARLY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "BIZ_YTD";
		String report_name = "Cloud 9 POS Emp Productivity";
		String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
		String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

		
		

		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

		commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newCurrentDate, newFutureDate);

	}

//*************************************************************Cash******************************************************************************************************
	
	public void getCashReceiptReportSchedulerWithFrequencyWeeklyAndPeriodPBW() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());

		

		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 15;

		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, periodDropdown);

		periodDropdown.click();

		String periodText = "Prior business week";
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
		
        String storeValue = "1-Test n/a";
		
        storeInputBoxOfParametersForCashReceipts.click();
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, storeValue);  		
				
		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();

		commonUtilities.selectReportFormat(driver, "CSV");
		
		reportFormatDropdown.click();

		commonUtilities.selectReportFormat(driver, "PRN");
		
		String emaidId = "arunkumarpi@cyabge.com";

		emailRecipientsInputBox.sendKeys(emaidId);

		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

		String report_frequency = "BIZ_WEEKLY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "BIZ_PRIOR_WEEK";
		String report_name = "Cash Receipts Report";
		String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
		String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

	
		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cash Receipts Report' order by rowid desc LIMIT 1";

		
		commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newCurrentDate, newFutureDate);

	}

	
	public void getCashReceiptReportSchedulerWithFrequencyMonthlyAndPeriodPBM() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());

		frequencyDropdown.click();

		String frequencyText = "FIRST DAY OF MONTH";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, frequencyText);

		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 35;


		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, periodDropdown);

		periodDropdown.click();

		String periodText = "Prior business month";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
		
		String sortByText = "Rep";

		sortByDropdown.click();
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, sortByText);	
	
		commonUtilities.scrollIntoView(driver, businessDayHourOffset);
		
		String businessDayHourOffsetText = "6";

		businessDayHourOffset.click();
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, businessDayHourOffsetText);
		
		commonUtilities.scrollIntoView(driver, reportTypeDropdown);
		
		String reportType = "Day-Store";
		
		reportTypeDropdown.click();
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, reportType);	
	
		//commonUtilities.scrollIntoView(driver, clientInputBox);
        //String clientText = "US Retail";	
		
		//clientInputBox.click();
		//clientInputBox.sendKeys(clientText,Keys.RETURN);
		//clientInputBox.sendKeys(clientText);
		//clientInputBox.sendKeys(Keys.ENTER);

		//commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();

		commonUtilities.selectReportFormat(driver, "CSV");
		
		String emailId = "arunkumarpi@cyabge.com , arunpillai1986@gmail.com";

		emailRecipientsInputBox.sendKeys(emailId);		
		
		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();
		

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

		String report_frequency = "BIZ_MONTHLY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "BIZ_PRIOR_MONTH";
		String report_name = "Cash Receipts Report";
		String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
		String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

		
		

		//String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cash Receipts Report' order by rowid desc LIMIT 1";

		
		commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newCurrentDate, newFutureDate);

	}


	public void getCashReceiptReportSchedulerWithFrequencyQuarterlyAndPeriodPBQ() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());

		frequencyDropdown.click();

		String frequencyText = "FIRST DAY OF QUARTER";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, frequencyText);

		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 200;

		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);


		periodDropdown.click();

		String periodText = "Prior business quarter";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
		
		String sortByText = "Client";

		sortByDropdown.click();
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, sortByText);	
	
		commonUtilities.scrollIntoView(driver, businessDayHourOffset);
		
		String businessDayHourOffsetText = "12";

		businessDayHourOffset.click();
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, businessDayHourOffsetText);
		
		commonUtilities.scrollIntoView(driver, reportTypeDropdown);
		
		String reportType = "Store-Day";
		
		reportTypeDropdown.click();
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, reportType);	
	
		//commonUtilities.scrollIntoView(driver, clientInputBox);
        //String clientText = "US Retail";	
		
		//clientInputBox.click();
		//clientInputBox.sendKeys(clientText,Keys.RETURN);
		//clientInputBox.sendKeys(clientText);
		//clientInputBox.sendKeys(Keys.ENTER);

		//commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);
		
		String reportFormat = "CSV";
		
		String reportnewFormat = "PRN";

		reportFormatDropdown.click();

		commonUtilities.selectReportFormat(driver, reportFormat);
		
		reportFormatDropdown.click();

		commonUtilities.selectReportFormat(driver, reportnewFormat);
		
		//String emailId = "arunkumarpi@cyabge.com ";

		//emailRecipientsInputBox.sendKeys(emailId);
		
        String emailGroupText = "Report group-300";
		
		emailGroupInputBox.sendKeys(emailGroupText,Keys.ENTER);


		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();
		

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

		String report_frequency = "BIZ_QUARTERLY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "BIZ_PRIOR_QUARTER";
		String report_name = "Cash Receipts Report";
		String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
		String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

		
		

		//String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cash Receipts Report' order by rowid desc LIMIT 1";

		
		commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newCurrentDate, newFutureDate);

	}
	
	public void getCashReceiptReportSchedulerWithFrequencyYearlyAndPeriodPBY() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());

		frequencyDropdown.click();

		String frequencyText = "FIRST DAY OF YEAR";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, frequencyText);	
		
		commonUtilities.scrollIntoView(driver, runTime);
	
		String runTimeText = "07:00 AM";

		runTime.click();
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, runTimeText);	

		
		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 400;

		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		//commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, periodDropdown);

		periodDropdown.click();

		
		String periodText = "Prior business year";


		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
		
		String sortByText = "Rep";

		sortByDropdown.click();
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, sortByText);	
	
		commonUtilities.scrollIntoView(driver, businessDayHourOffset);
		
		String businessDayHourOffsetText = "23";

		businessDayHourOffset.click();
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, businessDayHourOffsetText);
		
		commonUtilities.scrollIntoView(driver, reportTypeDropdown);
		
		String reportType = "Day-Store";
		
		String reportNewType = "Standard";
		
		reportTypeDropdown.click();
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, reportType);	
		
        reportTypeDropdown.click();
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, reportNewType);	



		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();

		commonUtilities.selectReportFormat(driver, "CSV");

		// emailRecipientsInputBox.sendKeys("arunkumarpi@cyabge.com");
		
		String storeText = "Hawthorne Center-218028";
		storeInputBoxOfDelivery.sendKeys(storeText,Keys.ENTER);
		
		String storeSecondText = "Water Tower Place-218049";
		storeInputBoxOfDelivery.sendKeys(storeSecondText,Keys.ENTER);
		
		String storeThirdText = "Mall at ST. Matthews-218081";
		storeInputBoxOfDelivery.sendKeys(storeThirdText,Keys.ENTER);


		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

		String report_frequency = "BIZ_YEARLY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "BIZ_PRIOR_YEAR";
		String report_name = "Cash Receipts Report";
		
		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cash Receipts Report' order by rowid desc LIMIT 1";

		commonUtilities.databaseRecordVerificationWithOutTime(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name);

	}

	
//********************************************************Cash/******************************************************************************************************************
	
	//********************************************************Cloud9 Fiscal once******************************************************************************************************************
	
	
	public void getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyOnceAndPeriodDateOfFireToday() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());
		
		fiscalCalendarRadioButton.click();
		
		//fiscalCalendarFrequencyDropdown.click();
		
		//String fiscalCalendarFrequency = "ONCE";

		//commonUtilities.selectValuesFromScheduleReportDropdown(driver, fiscalCalendarFrequency);
		
		String tomorrowDate = commonUtilities.selectTomorrowDate();

		reportRunDateForFiscal.sendKeys(tomorrowDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		
		String periodText = "Yesterday";
		
		String periodNewText = "Today";

    	fiscalPeriodDropdown.click();
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
		
		fiscalPeriodDropdown.click();
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodNewText);

	
		//String storeValue = "0 - All Data";
				
		//storeInputBoxOfParameters.click();

		//commonUtilities.selectValuesFromScheduleReportDropdown(driver, storeValue);
	
		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();

		commonUtilities.selectReportFormat(driver, "EXCEL");	
		
		emailRecipientsInputBox.sendKeys("arunkumarpi@cyabge.com");


		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

		String report_frequency = "ONCE";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "DATE_OF";
		String report_name = "Cloud 9 POS Emp Productivity";
		String newTomorrowDate = commonUtilities.completeDateFormat(driver, tomorrowDate);

		System.out.println(newTomorrowDate);

		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

		commonUtilities.databaseRecordVerificationForFiscalCalendar(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newTomorrowDate);

	}

	
	public void getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyDailyAndPeriodYesterday() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());
		
		fiscalCalendarRadioButton.click();
		
		fiscalCalendarFrequencyDropdown.click();
		
		String fiscalCalendarFrequency = "DAILY";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, fiscalCalendarFrequency);
		
		
		
		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 35;
		
		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		
		String periodText = "Yesterday";
		
		//String periodNewText = "Date of fire (Today)";

    	fiscalPeriodDropdown.click();
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
		
		//fiscalPeriodDropdown.click();
		//commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodNewText);

	
		String storeValue = "1-Test n/a";
				
		storeInputBoxOfParameters.click();

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, storeValue);
		

		
		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();

		commonUtilities.selectReportFormat(driver, "PDF");	
		
		emailRecipientsInputBox.sendKeys("arunkumarpi@cyabge.com");


		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

		String report_frequency = "DAILY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "YESTERDAY";
		String report_name = "Cloud 9 POS Emp Productivity";
		String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
		String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

		
		

		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

		commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newCurrentDate, newFutureDate);


	}

	public void getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyWeeklyAndPeriodFixed() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());
		
		fiscalCalendarRadioButton.click();
		
		fiscalCalendarFrequencyDropdown.click();
		
		String fiscalCalendarFrequency = "WEEKLY";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, fiscalCalendarFrequency);
		
		
		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 35;
		
		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);
		
		fiscalCalendarFrequencyDropdownWeeklyMondayOption.click();


		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		
		String periodText = "Fixed";
		
		//String periodNewText = "Date of fire (Today)";

    	fiscalPeriodDropdown.click();
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
		
		fiscalPeriodStartDate.sendKeys(currnetDate);
		
		fiscalPeriodEndDate.sendKeys(futureDate);

	
		//String storeValue = "1-Test n/a";
				
		//storeInputBoxOfParameters.click();

		//commonUtilities.selectValuesFromScheduleReportDropdown(driver, storeValue);
	
		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();
		
		String reportFormat ="PDF";
		
		String reportNewFormat ="HTML";

		
		commonUtilities.selectReportFormat(driver, reportFormat);
		
		reportFormatDropdown.click();

		commonUtilities.selectReportFormat(driver, reportNewFormat);	
		
		String emailId ="arunkumarpi@cyabge.com";
		
		emailRecipientsInputBox.sendKeys(emailId);


		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

		String report_frequency = "WEEKLY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "FIXED";
		String report_name = "Cloud 9 POS Emp Productivity";
		String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
		String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

		
		

		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

		commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newCurrentDate, newFutureDate);


	}

	public void getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyMonthlyAndPeriodLastXDaysInclusiveofToday() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());
		
		fiscalCalendarRadioButton.click();
		
		fiscalCalendarFrequencyDropdown.click();
		
		String fiscalCalendarFrequency = "MONTHLY";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, fiscalCalendarFrequency);
		
		
		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 35;
		
		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);
				
		String monthlyDays = "2";

		fiscalCalendarFrequencyDropdownMonthlyDaysInput.sendKeys(monthlyDays);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		
		String periodText = "Last X Days (Inclusive of Today)";
		
		//String periodNewText = "Date of fire (Today)";

    	fiscalPeriodDropdown.click();
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
		
		String lastxdays = "2";
		
		fiscalLastxdays.sendKeys(lastxdays);;
	
		//String storeValue = "1-Test n/a";
				
		//storeInputBoxOfParameters.click();

		//commonUtilities.selectValuesFromScheduleReportDropdown(driver, storeValue);
	
		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();
		
		String reportFormat ="EXCEL";
	
		commonUtilities.selectReportFormat(driver, reportFormat);
				
		String emailId ="arunkumarpi@cyabge.com";
		
		emailRecipientsInputBox.sendKeys(emailId);


		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

		String report_frequency = "MONTHLY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "LAST_X_DAYS_INCLUSIVE";
		String report_name = "Cloud 9 POS Emp Productivity";
		String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
		String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

		
		

		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

		commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newCurrentDate, newFutureDate);


	}
	
	public void getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyMonthlyAndPeriodLastXDaysExclusiveofToday() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());
		
		fiscalCalendarRadioButton.click();
		
		fiscalCalendarFrequencyDropdown.click();
		
		String fiscalCalendarFrequency = "MONTHLY";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, fiscalCalendarFrequency);
		
		
		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 35;
		
		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);
				
		String monthlyDays = "2";

		fiscalCalendarFrequencyDropdownMonthlyDaysInput.sendKeys(monthlyDays);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		
		String periodText = "Last X Days (Exclusive of Today)";
		
		//String periodNewText = "Date of fire (Today)";

    	fiscalPeriodDropdown.click();
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
		
		String lastxdays = "3";
		
		fiscalLastxdays.sendKeys(lastxdays);;
	
		//String storeValue = "1-Test n/a";
				
		//storeInputBoxOfParameters.click();

		//commonUtilities.selectValuesFromScheduleReportDropdown(driver, storeValue);
	
		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();
		
		String reportFormat ="EXCEL";
	
		commonUtilities.selectReportFormat(driver, reportFormat);
				
		String emailId ="arunkumarpi@cyabge.com";
		
		emailRecipientsInputBox.sendKeys(emailId);


		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

		String report_frequency = "MONTHLY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "LAST_X_DAYS_EXCLUSIVE";
		String report_name = "Cloud 9 POS Emp Productivity";
		String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
		String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

		
		

		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

		commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newCurrentDate, newFutureDate);


	}

	
	//-------------------------
	
	
	public void getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyDailyAndPeriodLastWeek() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());
		
		fiscalCalendarRadioButton.click();
		
		fiscalCalendarFrequencyDropdown.click();
		
		String fiscalCalendarFrequency = "DAILY";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, fiscalCalendarFrequency);
		
		String everyDays = "2";
		
		fiscalCalendarEveryDaysInputField.sendKeys(everyDays);		
		
		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 35;
		
		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		
		String periodText = "Last Week";
		
		//String periodNewText = "Date of fire (Today)";

    	fiscalPeriodDropdown.click();
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
		
		//fiscalPeriodDropdown.click();
		//commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodNewText);

	
		String storeValue = "1-Test n/a";
				
		storeInputBoxOfParameters.click();

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, storeValue);
		

		
		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();
		
		
		String reportFormat = "PDF";		
		
		commonUtilities.selectReportFormat(driver, reportFormat);	
		
		String emailId = "arunkumarpi@cyabge.com";
		
		emailRecipientsInputBox.sendKeys(emailId);		
		
		includeMeCheckBox.click();

		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

		String report_frequency = "DAILY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "PRIOR_WEEK";
		String report_name = "Cloud 9 POS Emp Productivity";
		String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
		String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

		
		

		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

		commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newCurrentDate, newFutureDate);


	}

	public void getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyWeeklyAndPeriodLastMonth() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());
		
		fiscalCalendarRadioButton.click();
		
		fiscalCalendarFrequencyDropdown.click();
		
		String fiscalCalendarFrequency = "WEEKLY";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, fiscalCalendarFrequency);
		
        String everyDays = "2";
		
		fiscalCalendarEveryDaysInputField.sendKeys(everyDays);
		
        fiscalCalendarFrequencyDropdownWeeklyMondayOption.click();
		
		fiscalCalendarFrequencyDropdownWeeklyWedOption.click();
		
		fiscalCalendarFrequencyDropdownWeeklyFriOption.click();
		
		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 35;
		
		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		
		String periodText = "Last Month";
		
		//String periodNewText = "Date of fire (Today)";

    	fiscalPeriodDropdown.click();
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
	
		//String storeValue = "1-Test n/a";
				
		//storeInputBoxOfParameters.click();

		//commonUtilities.selectValuesFromScheduleReportDropdown(driver, storeValue);
	
		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();
		
		String reportFormat ="PDF";
		
		String reportNewFormat ="HTML";

		
		commonUtilities.selectReportFormat(driver, reportFormat);
		
		reportFormatDropdown.click();

		commonUtilities.selectReportFormat(driver, reportNewFormat);	
		
		String emailId ="arunkumarpi@cyabge.com";
		
		emailRecipientsInputBox.sendKeys(emailId);


		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

		String report_frequency = "WEEKLY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "PRIOR_MONTH";
		String report_name = "Cloud 9 POS Emp Productivity";
		String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
		String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

		
		

		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

		commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newCurrentDate, newFutureDate);


	}

	public void getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyMonthlyAndPeriodLastQuarter() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());
		
		fiscalCalendarRadioButton.click();
		
		fiscalCalendarFrequencyDropdown.click();
		
		String fiscalCalendarFrequency = "MONTHLY";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, fiscalCalendarFrequency);
		
		String monthlyDays = "2";

		fiscalCalendarFrequencyDropdownMonthlyDaysInput.sendKeys(monthlyDays);
		
        /*String everyDays = "2";
		
		fiscalCalendarEveryDaysInputField.sendKeys(everyDays);
		
		String OnDropdwonValue = "First";
		
		commonUtilities.selectValueFromDropDown(fiscalCalendarOnDropdown, OnDropdwonValue);
		
		fiscalCalendarDaysDropdown.click();		
		
		String fiscalCalendarDayDropdownDays = "Monday";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, fiscalCalendarDayDropdownDays);	*/	
		
		
		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 35;
		
		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		
		String periodText = "Last Quarter";
		
		//String periodText = "FIXED";

    	fiscalPeriodDropdown.click();
    	
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
	
		//String storeValue = "1-Test n/a";
				
		//storeInputBoxOfParameters.click();

		//commonUtilities.selectValuesFromScheduleReportDropdown(driver, storeValue);
	
		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();
		
		String reportFormat ="EXCEL";
	
		commonUtilities.selectReportFormat(driver, reportFormat);
				
		String emailId ="arunkumarpi@cyabge.com";
		
		emailRecipientsInputBox.sendKeys(emailId);


		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

		String report_frequency = "MONTHLY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "PRIOR_QUARTER";
		String report_name = "Cloud 9 POS Emp Productivity";
		String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
		String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

		
		

		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

		commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newCurrentDate, newFutureDate);


	}
	
	public void getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyMonthlyAndPeriodLastYear() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());
		
		fiscalCalendarRadioButton.click();
		
		fiscalCalendarFrequencyDropdown.click();
		
		String fiscalCalendarFrequency = "MONTHLY";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, fiscalCalendarFrequency);
		
		//String monthlyDays = "2";

		//fiscalCalendarFrequencyDropdownMonthlyDaysInput.sendKeys(monthlyDays);
		
        //String everyDays = "2";
		
		//fiscalCalendarEveryDaysInputField.sendKeys(everyDays);
		
		String OnDropdwonValue = "First";
		
		commonUtilities.selectValueFromDropDown(fiscalCalendarOnDropdown, OnDropdwonValue);
		
		fiscalCalendarDaysDropdown.click();		
		
		String fiscalCalendarDayDropdownDays = "Monday";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, fiscalCalendarDayDropdownDays);
		
		
		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 35;
		
		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		
		String periodText = "Last Year";
		
		//String periodText = "FIXED";

    	fiscalPeriodDropdown.click();
    	
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
	
		//String storeValue = "1-Test n/a";
				
		//storeInputBoxOfParameters.click();

		//commonUtilities.selectValuesFromScheduleReportDropdown(driver, storeValue);
	
		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();
		
		String reportFormat ="EXCEL";
	
		commonUtilities.selectReportFormat(driver, reportFormat);
				
		String emailId ="arunkumarpi@cyabge.com";
		
		emailRecipientsInputBox.sendKeys(emailId);


		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

		String report_frequency = "MONTHLY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "PRIOR_YEAR";
		String report_name = "Cloud 9 POS Emp Productivity";
		String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
		String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

		
		

		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

		commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newCurrentDate, newFutureDate);


	}

	
	public void getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyOnceAndPeriodCurrentWeek() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());
		
		fiscalCalendarRadioButton.click();
		
		//fiscalCalendarFrequencyDropdown.click();
		
		//String fiscalCalendarFrequency = "ONCE";

		//commonUtilities.selectValuesFromScheduleReportDropdown(driver, fiscalCalendarFrequency);
		
		String tomorrowDate = commonUtilities.selectTomorrowDate();

		reportRunDateForFiscal.sendKeys(tomorrowDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		
		String periodText = "Current Week";		

    	fiscalPeriodDropdown.click();
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
	
		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();

		commonUtilities.selectReportFormat(driver, "EXCEL");	
		
		emailRecipientsInputBox.sendKeys("arunkumarpi@cyabge.com");


		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

		String report_frequency = "ONCE";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "WTD";
		String report_name = "Cloud 9 POS Emp Productivity";
		String newTomorrowDate = commonUtilities.completeDateFormat(driver, tomorrowDate);

		System.out.println(newTomorrowDate);

		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

		commonUtilities.databaseRecordVerificationForFiscalCalendar(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newTomorrowDate);

	}

	
	public void getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyDailyAndPeriodCurrentMonth() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());
		
		fiscalCalendarRadioButton.click();
		
		fiscalCalendarFrequencyDropdown.click();
		
		String fiscalCalendarFrequency = "DAILY";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, fiscalCalendarFrequency);
		
		
		
		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 35;
		
		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		
		String periodText = "Current Month";
		

    	fiscalPeriodDropdown.click();
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
		
		//fiscalPeriodDropdown.click();
		//commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodNewText);

	
		String storeValue = "1-Test n/a";
				
		storeInputBoxOfParameters.click();

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, storeValue);
		

		
		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();

		commonUtilities.selectReportFormat(driver, "PDF");	
		
		emailRecipientsInputBox.sendKeys("arunkumarpi@cyabge.com");


		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

		String report_frequency = "DAILY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "MTD";
		String report_name = "Cloud 9 POS Emp Productivity";
		String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
		String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

		
		

		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

		commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newCurrentDate, newFutureDate);


	}
	
	
	public void getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyWeeklyAndPeriodCurrentQuarter() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());
		
		fiscalCalendarRadioButton.click();
		
		fiscalCalendarFrequencyDropdown.click();
		
		String fiscalCalendarFrequency = "WEEKLY";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, fiscalCalendarFrequency);
		
		
		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 35;
		
		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);
		
		fiscalCalendarFrequencyDropdownWeeklyMondayOption.click();


		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		
		String periodText = "Current Quarter";
		
    	fiscalPeriodDropdown.click();
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
	
		//String storeValue = "1-Test n/a";
				
		//storeInputBoxOfParameters.click();

		//commonUtilities.selectValuesFromScheduleReportDropdown(driver, storeValue);
	
		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();
		
		String reportFormat ="PDF";
		
		String reportNewFormat ="HTML";

		
		commonUtilities.selectReportFormat(driver, reportFormat);
		
		reportFormatDropdown.click();

		commonUtilities.selectReportFormat(driver, reportNewFormat);	
		
		String emailId ="arunkumarpi@cyabge.com";
		
		emailRecipientsInputBox.sendKeys(emailId);


		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

		String report_frequency = "WEEKLY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "QTD";
		String report_name = "Cloud 9 POS Emp Productivity";
		String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
		String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

		
		

		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

		commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newCurrentDate, newFutureDate);


	}
	
	public void getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyMonthlyAndPeriodCurrentYear() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());
		
		fiscalCalendarRadioButton.click();
		
		fiscalCalendarFrequencyDropdown.click();
		
		String fiscalCalendarFrequency = "MONTHLY";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, fiscalCalendarFrequency);
		
		
		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 35;
		
		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);
				
		String monthlyDays = "2";

		fiscalCalendarFrequencyDropdownMonthlyDaysInput.sendKeys(monthlyDays);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		
		String periodText = "Current Year";
		
    	fiscalPeriodDropdown.click();
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
	
		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();
		
		String reportFormat ="EXCEL";
	
		commonUtilities.selectReportFormat(driver, reportFormat);
				
		String emailId ="arunkumarpi@cyabge.com";
		
		emailRecipientsInputBox.sendKeys(emailId);


		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

		String report_frequency = "MONTHLY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "YTD";
		String report_name = "Cloud 9 POS Emp Productivity";
		String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
		String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

		
		

		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

		commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newCurrentDate, newFutureDate);


	}




//**********************************************************/Fiscal**********************************************************************************************

//**********************************************************Error  Verification **********************************************************************************************
	public void getCashReceiptReportSchedulerWithBlankReportNameErrorVerification()  {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());
		
		reportName.clear();
				
		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 15;

		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();
		
		commonUtilities.scrollIntoView(driver, scheduleText);
		

    }	
	
	public void getCashReceiptReportSchedulerWithBlankStartDateErrorVerification()  {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());
		
		int days = 15;

		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);
		
		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();
		
		

	}	
	
	public void getCashReceiptReportSchedulerWithPastStartDateErrorVerification()  {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());
		
		String pastDate = commonUtilities.selectPastDate(-1);
		reportStartDate.sendKeys(pastDate);
		
		int days = 15;

		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);
		
		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();
		
		commonUtilities.scrollIntoView(driver, scheduleText);
		

	}	

	public void getCashReceiptReportSchedulerWithEndDateBeforeStartDateErrorVerification()  {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());
		
		String pastDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(pastDate);
		
		String futureDate = commonUtilities.selectPastDate(-1);
		reportEndtDate.sendKeys(futureDate);
		
		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();
		
		commonUtilities.scrollIntoView(driver, scheduleText);
		

	}
	
	public void getCashReceiptReportSchedulerWithBlankEmailSubjectFieldErrorVerification()  {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());

		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 15;

		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		periodDropdown.click();

		String periodText = "Prior business week";
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
				
		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		reportFormatDropdown.click();
		
		String reportFormat = "CSV";

		commonUtilities.selectReportFormat(driver, reportFormat);
				
		String emaidId = "arunkumarpi@cyabge.com";

		emailRecipientsInputBox.sendKeys(emaidId);

		commonUtilities.scrollIntoView(driver, submitButton);
		
		emailSubjectInputField.clear();

		submitButton.click();
		

		
	}
	
	public void getCashReceiptReportSchedulerWithBlankEmailBodyFieldErrorVerification()  {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());

		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 15;

		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		periodDropdown.click();

		String periodText = "Prior business week";
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
				
		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		reportFormatDropdown.click();
		
		String reportFormat = "CSV";

		commonUtilities.selectReportFormat(driver, reportFormat);
				
		String emaidId = "arunkumarpi@cyabge.com";

		emailRecipientsInputBox.sendKeys(emaidId);

		commonUtilities.scrollIntoView(driver, submitButton);
		
		emailBodyInputField.clear();

		submitButton.click();
		

		
	}
	
	public void getCashReceiptReportSchedulerWithBlankEmailRecipientsFieldErrorVerification()  {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());

		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 15;

		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		periodDropdown.click();

		String periodText = "Prior business week";
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
				
		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		reportFormatDropdown.click();
		
		String reportFormat = "CSV";

		commonUtilities.selectReportFormat(driver, reportFormat);
		
		includeMeCheckBox.click();
	
		commonUtilities.scrollIntoView(driver, submitButton);
		
		submitButton.click();
		

		
	}
	
	public void getCashReceiptReportSchedulerWithInvalidEmailRecipientsErrorVerification()  {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());

		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 15;

		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		periodDropdown.click();

		String periodText = "Prior business week";
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
				
		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		reportFormatDropdown.click();
		
		String reportFormat = "CSV";

		commonUtilities.selectReportFormat(driver, reportFormat);
		
		String emaidId = "arunkumarpi@cyabge";

		emailRecipientsInputBox.sendKeys(emaidId);
			
		commonUtilities.scrollIntoView(driver, submitButton);
		
		submitButton.click();
		
		
	}
	
	public void getCashReceiptReportSchedulerWithFiscalCalendarBlankReportRunDateErrorVerification()  {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());
		
		fiscalCalendarRadioButton.click();
		
		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();
		
	}
	
	public void getCashReceiptReportSchedulerWithFiscalCalendarPastReportRunDateErrorVerification()  {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());
		
		fiscalCalendarRadioButton.click();
		
		String pastDate = commonUtilities.selectPastDate(-1);
		reportRunDateForFiscal.sendKeys(pastDate);
		
		//String pastDate = commonUtilities.selectTomorrowDate();

		//reportRunDateForFiscal.sendKeys(pastDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();
				

	}
	
	public void getCashReceiptReportSchedulerWithBlankPeriodErrorVerification()  {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());

		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 15;

		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();
				
		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();
		
		commonUtilities.scrollIntoView(driver, scheduleText);

	
	}

	public void getCashReceiptReportSchedulerWithBlankReportFormatErrorVerification()  {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());

		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 15;

		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		periodDropdown.click();

		String periodText = "Prior business week";
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
				
		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();	
			
		commonUtilities.scrollIntoView(driver, submitButton);
		
		submitButton.click();
		
		commonUtilities.scrollIntoView(driver, scheduleText);
		
	
	}
	
	public void getCashReceiptReportSchedulerWithBlankTimeZoneErrorVerification()  {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());

		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 15;

		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);
		
		timeZoneField.click();
		
		timeZoneFieldHasOption.sendKeys(Keys.BACK_SPACE);
		
		

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();	
		

	}	
//********************************************DepartmentLsit Report**********************************************************************************************************
	
	public void getDepartmentLsitReportScheduler() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());

		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 16;

		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, periodDropdown);

		departmentListPeriodDropdown.click();

		String periodText = "N/A - report doesn�t take dates";
		
		commonUtilities.selectValuesFromScheduleReportDropdownForDepartmentListPeriod(driver, periodText);
		//commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
		
		//periodDropdown.click();

		//String periodTextNew = "N/A - report doesn�t take dates";
		
		//commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodTextNew);
						
		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		reportFormatDropdown.click();

		commonUtilities.selectReportFormat(driver, "EXCEL");	
		
		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

		String report_frequency = "BIZ_WEEKLY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "NA";
		String report_name = "Department List";
		String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
		String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

		
		

		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Department List' order by rowid desc LIMIT 1";

		commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newCurrentDate, newFutureDate);

	}
	
	
	public void getCloud9POSEmpProductivityReportSchedulerUpdateFunctionality() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());

		frequencyDropdown.click();

		String frequencyText = "FIRST DAY OF YEAR";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, frequencyText);

		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 381;


		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, periodDropdown);

		periodDropdown.click();

		String periodText = "Business quarter to date";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);

		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();

		commonUtilities.selectReportFormat(driver, "EXCEL");

		emailRecipientsInputBox.sendKeys("arunkumarpi@cyabge.com");

		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));
		
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

		String expectedReportname = "Cloud 9 POS Emp Productivity";

		Assert.assertEquals(actualReportname, expectedReportname, "Report not present in scheduled location");

		// getReportScheduledParamForCloud9POSEmpProductivity();
		
		scheduledReportEditLink.click();
		
		//commonUtilities.clickElementByJS(driver, scheduledReportParam);
		
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.switchTo().frame(iframeElement);

		//wait.until(ExpectedConditions.textToBePresentInElement(scheduledReportParametersText, "Schedule Report Parameters"));		
		
        Assert.assertTrue(scheduleText.isDisplayed(), "Scheduler Text not displayed on edit modal");
		
		
		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();
		
		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, periodDropdown);

		periodDropdown.click();

		String periodTextUpdate = "Business year to date";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodTextUpdate);

		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();
		
		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Schedule updated successfully"));
		
		
		String report_frequency = "BIZ_YEARLY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "BIZ_YTD";
		String report_name = "Cloud 9 POS Emp Productivity";
		String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
		String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

		commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newCurrentDate, newFutureDate);

	}
	
	public void getCloud9POSEmpProductivityReportSchedulerUpdateTimeZoneFunctionality() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());

		frequencyDropdown.click();

		String frequencyText = "FIRST DAY OF YEAR";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, frequencyText);

		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
		int days = 381;


		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, periodDropdown);

		periodDropdown.click();

		String periodText = "Business quarter to date";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);

		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();

		commonUtilities.selectReportFormat(driver, "EXCEL");

		emailRecipientsInputBox.sendKeys("arunkumarpi@cyabge.com");

		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));
		
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

		String expectedReportname = "Cloud 9 POS Emp Productivity";

		Assert.assertEquals(actualReportname, expectedReportname, "Report not present in scheduled location");

		// getReportScheduledParamForCloud9POSEmpProductivity();
		
		scheduledReportEditLink.click();
		
		//commonUtilities.clickElementByJS(driver, scheduledReportParam);
		
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.switchTo().frame(iframeElement);

		//wait.until(ExpectedConditions.textToBePresentInElement(scheduledReportParametersText, "Schedule Report Parameters"));		
		
        Assert.assertTrue(scheduleText.isDisplayed(), "Scheduler Text not displayed on edit modal");
        
        
        
        timeZoneField.click();
		
		timeZoneFieldHasOption.sendKeys(Keys.BACK_SPACE); 
		
        String timeZoneValue = "America";
		
		timeZoneFieldHasOption.sendKeys(timeZoneValue);
		
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		timeZoneSelectValue.click();
		
		
		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();
		
		commonUtilities.scrollIntoView(driver, scheduleText);

		// commonUtilities.clickElementByJS(driver, periodDropdown);

		periodDropdown.click();

		String periodTextUpdate = "Business year to date";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodTextUpdate);

		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();
		
		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Schedule updated successfully"));
		
		
		String report_frequency = "BIZ_YEARLY";
		String report_timeZone = "America/New_York";
		String report_period = "BIZ_YTD";
		String report_name = "Cloud 9 POS Emp Productivity";
		String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
		String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

		commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
				report_period, report_name, newCurrentDate, newFutureDate);

	}

//*************************Schedule Report Cases*****************************************************************************************************************************
	
public void getDepartmentListReportParameterFromScheduledReportPageWithNoDatesPeriod() throws SQLException {
		
	
	WebDriverWait wait = new WebDriverWait(driver, 20);

	wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

	Assert.assertTrue(scheduleText.isDisplayed());

	String currnetDate = commonUtilities.selectCurrentDate();
	reportStartDate.sendKeys(currnetDate);
	
	int days = 16;

	String futureDate = commonUtilities.selectFutureDate(days);
	reportEndtDate.sendKeys(futureDate);

	commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
	nextButtonOfDetails.click();

	commonUtilities.scrollIntoView(driver, scheduleText);

	// commonUtilities.clickElementByJS(driver, periodDropdown);

	departmentListPeriodDropdown.click();

	String periodText = "N/A - report doesn�t take dates";
	
	commonUtilities.selectValuesFromScheduleReportDropdownForDepartmentListPeriod(driver, periodText);
	//commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
	
	//periodDropdown.click();

	//String periodTextNew = "N/A - report doesn�t take dates";
	
	//commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodTextNew);
					
	commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

	nextButtonOfParameters.click();

	commonUtilities.scrollIntoView(driver, scheduleText);

	reportFormatDropdown.click();

	commonUtilities.selectReportFormat(driver, "EXCEL");	
	
	commonUtilities.scrollIntoView(driver, submitButton);

	submitButton.click();

	driver.switchTo().defaultContent();

	wait.until(
			ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

	String report_frequency = "BIZ_WEEKLY";
	String report_timeZone = "Asia/Calcutta";
	String report_period = "NA";
	String report_name = "Department List";
	String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
	String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

	String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Department List' order by rowid desc LIMIT 1";

	commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
			report_period, report_name, newCurrentDate, newFutureDate);
	

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

		String expectedReportnameOnParamters = "Department List";

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

		String expectedPeriodOnParamters = "N/A - report doesn�t take dates";

		Assert.assertEquals(actualPeriodOnParamters, expectedPeriodOnParamters,
				"Period not matched in Parameters Form");


		scheduledReportOkLinkToCloseParametersForm.click();



	}


public void getCondensedFlashReportParameterFromScheduledReportPageWithOneDatesPeriod() throws SQLException {
		
	
	WebDriverWait wait = new WebDriverWait(driver, 20);

	wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

	Assert.assertTrue(scheduleText.isDisplayed());

	String currnetDate = commonUtilities.selectCurrentDate();
	reportStartDate.sendKeys(currnetDate);
	
	int days = 16;

	String futureDate = commonUtilities.selectFutureDate(days);
	reportEndtDate.sendKeys(futureDate);

	commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
	nextButtonOfDetails.click();

	commonUtilities.scrollIntoView(driver, scheduleText);

	// commonUtilities.clickElementByJS(driver, periodDropdown);
	
	periodDropdown.click();

	String periodText = "Yesterday";

	commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
	
	periodDropdown.click();

	String periodTextUpdate = "Today";

	commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodTextUpdate);

	//commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
	
	//periodDropdown.click();

	//String periodTextNew = "N/A - report doesn�t take dates";
	
	//commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodTextNew);
					
	commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

	nextButtonOfParameters.click();

	commonUtilities.scrollIntoView(driver, scheduleText);

	reportFormatDropdown.click();

	commonUtilities.selectReportFormat(driver, "CSV");	
	
	commonUtilities.scrollIntoView(driver, submitButton);

	submitButton.click();

	driver.switchTo().defaultContent();

	wait.until(
			ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

	String report_frequency = "BIZ_WEEKLY";
	String report_timeZone = "Asia/Calcutta";
	String report_period = "DATE_OF";
	String report_name = "Condensed Flash Report";
	String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
	String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

	String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Condensed Flash Report' order by rowid desc LIMIT 1";

	commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
			report_period, report_name, newCurrentDate, newFutureDate);
	

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

		String expectedReportname = "Condensed Flash Report";

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

		String expectedReportnameOnParamters = "Condensed Flash Report";

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

		String expectedPeriodOnParamters = "Today";

		Assert.assertEquals(actualPeriodOnParamters, expectedPeriodOnParamters,
				"Period not matched in Parameters Form");


		scheduledReportOkLinkToCloseParametersForm.click();



	}

public void getInvMovementStyleColorArtiReportParameterFromScheduledReportPageWithTwoDatesPeriod() throws SQLException {
		
	
	WebDriverWait wait = new WebDriverWait(driver, 20);

	wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

	Assert.assertTrue(scheduleText.isDisplayed());

	frequencyDropdown.click();

	String frequencyText = "FIRST DAY OF MONTH";

	commonUtilities.selectValuesFromScheduleReportDropdown(driver, frequencyText);

	String currnetDate = commonUtilities.selectCurrentDate();
	reportStartDate.sendKeys(currnetDate);
	
	int days = 35;


	String futureDate = commonUtilities.selectFutureDate(days);
	reportEndtDate.sendKeys(futureDate);

	commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
	nextButtonOfDetails.click();

	commonUtilities.scrollIntoView(driver, scheduleText);

	// commonUtilities.clickElementByJS(driver, periodDropdown);

	periodDropdown.click();

	String periodText = "Prior business month";

	commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
	
					
	commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

	nextButtonOfParameters.click();

	commonUtilities.scrollIntoView(driver, scheduleText);

	reportFormatDropdown.click();
	
	String reportValue = "EXCEL";

	commonUtilities.selectReportFormat(driver, reportValue);	
	
	commonUtilities.scrollIntoView(driver, submitButton);

	submitButton.click();

	driver.switchTo().defaultContent();

	wait.until(
			ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

	String report_frequency = "BIZ_MONTHLY";
	String report_timeZone = "Asia/Calcutta";
	String report_period = "BIZ_PRIOR_MONTH";
	String report_name = "Inv. Movement Style-Color-Arti";
	String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
	String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

	String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Inv. Movement Style-Color-Arti' order by rowid desc LIMIT 1";

	commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
			report_period, report_name, newCurrentDate, newFutureDate);
	

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

		String expectedReportname = "Inv. Movement Style-Color-Arti";

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

		String expectedReportnameOnParamters = "Inv. Movement Style-Color-Arti";

		Assert.assertEquals(actualReportnameOnParamters, expectedReportnameOnParamters,
				"Report name not matched in Parameters Form");

		String actualCalendarTypeOnParamters = scheduledReportCalendarTypeInParameters.getText();

		String expectedCalendarTypeOnParamters = "Retail";

		Assert.assertEquals(actualCalendarTypeOnParamters, expectedCalendarTypeOnParamters,
				"CalendarType not matched in Parameters Form");

		String actualFrequencyOnParamters = scheduledReportFrequencyInParameters.getText();

		String expectedFrequencyOnParamters = "MONTHLY";

		Assert.assertEquals(actualFrequencyOnParamters, expectedFrequencyOnParamters,
				"Frequency not matched in Parameters Form");

		String actualTimeZoneOnParamters = scheduledReportTimeZoneInParameters.getText();

		String expectedTimeZoneOnParamters = "Asia/Calcutta";

		Assert.assertEquals(actualTimeZoneOnParamters, expectedTimeZoneOnParamters,
				"TimeZone not matched in Parameters Form");

		String actualPeriodOnParamters = scheduledReportPeriodInParameters.getText();

		String expectedPeriodOnParamters = "Prior business month";

		Assert.assertEquals(actualPeriodOnParamters, expectedPeriodOnParamters,
				"Period not matched in Parameters Form");


		scheduledReportOkLinkToCloseParametersForm.click();



	}

	
public void getCashReceiptsReportSchedulerUpdate() throws SQLException {

	WebDriverWait wait = new WebDriverWait(driver, 20);

	wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

	Assert.assertTrue(scheduleText.isDisplayed());

	String currnetDate = commonUtilities.selectCurrentDate();
	reportStartDate.sendKeys(currnetDate);
	
	int days = 15;

	String futureDateOld = commonUtilities.selectFutureDate(days);
	reportEndtDate.sendKeys(futureDateOld);

	commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
	nextButtonOfDetails.click();

	commonUtilities.scrollIntoView(driver, scheduleText);

	// commonUtilities.clickElementByJS(driver, periodDropdown);

	periodDropdown.click();

	String periodText = "Prior business week";
	
	commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
	
    /*String storeValue = "1-Test n/a";
	
    storeInputBoxOfParametersForCashReceipts.click();
	
	commonUtilities.selectValuesFromScheduleReportDropdown(driver, storeValue);  
	
	String sortByText = "Rep";

	sortByDropdown.click();
	
	commonUtilities.selectValuesFromScheduleReportDropdown(driver, sortByText);	

	commonUtilities.scrollIntoView(driver, businessDayHourOffset);
	
	String businessDayHourOffsetText = "6";

	businessDayHourOffset.click();
	
	commonUtilities.selectValuesFromScheduleReportDropdown(driver, businessDayHourOffsetText);
	
	commonUtilities.scrollIntoView(driver, reportTypeDropdown);
	
	String reportType = "Day-Store";
	
	reportTypeDropdown.click();
	
	commonUtilities.selectValuesFromScheduleReportDropdown(driver, reportType);	

*/	commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

	nextButtonOfParameters.click();

	commonUtilities.scrollIntoView(driver, scheduleText);

	// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

	reportFormatDropdown.click();

	commonUtilities.selectReportFormat(driver, "CSV");
	
	reportFormatDropdown.click();

	commonUtilities.selectReportFormat(driver, "PRN");
	
	String emaidId = "arunkumarpi@cyabge.com";

	emailRecipientsInputBox.sendKeys(emaidId);
	
	/*String emailGroupText = "Report group-300";
	
	emailGroupInputBox.sendKeys(emailGroupText,Keys.ENTER);
	
	String storeText = "Test n/a-1";
	storeInputBoxOfDelivery.sendKeys(storeText,Keys.ENTER);
	
*/		
	includeMeCheckBox.click();	

	commonUtilities.scrollIntoView(driver, submitButton);

	submitButton.click();

	driver.switchTo().defaultContent();

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

	String expectedReportname = "Cash Receipts Report";

	Assert.assertEquals(actualReportname, expectedReportname, "Report not present in scheduled location");

	// getReportScheduledParamForCloud9POSEmpProductivity();
	
	scheduledReportEditLink.click();
	
	//commonUtilities.clickElementByJS(driver, scheduledReportParam);
	
	try {
		Thread.sleep(8000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	driver.switchTo().frame(iframeElement);

	//wait.until(ExpectedConditions.textToBePresentInElement(scheduledReportParametersText, "Schedule Report Parameters"));		
	
    Assert.assertTrue(scheduleText.isDisplayed(), "Scheduler Text not displayed on edit modal");
	
	
	frequencyDropdown.click();

	String frequencyText = "FIRST DAY OF MONTH";

	commonUtilities.selectValuesFromScheduleReportDropdown(driver, frequencyText);

	reportEndtDate.clear();
	
	int daysupdate = 36;

	String futureDate = commonUtilities.selectFutureDate(daysupdate);
	reportEndtDate.sendKeys(futureDate);

	commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
	nextButtonOfDetails.click();

	commonUtilities.scrollIntoView(driver, scheduleText);

	// commonUtilities.clickElementByJS(driver, periodDropdown);

	periodDropdown.click();

	String periodTextUpdate = "Prior business month";
	
	commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodTextUpdate);
	
    String storeValue = "1-Test n/a";
	
    storeInputBoxOfParametersForCashReceipts.click();
	
	commonUtilities.selectValuesFromScheduleReportDropdown(driver, storeValue);  
	
	String sortByText = "Rep";

	sortByDropdown.click();
	
	commonUtilities.selectValuesFromScheduleReportDropdown(driver, sortByText);	

	commonUtilities.scrollIntoView(driver, businessDayHourOffset);
	
	String businessDayHourOffsetText = "6";

	businessDayHourOffset.click();
	
	commonUtilities.selectValuesFromScheduleReportDropdown(driver, businessDayHourOffsetText);
	
	commonUtilities.scrollIntoView(driver, reportTypeDropdown);
	
	String reportType = "Day-Store";
	
	reportTypeDropdown.click();
	
	commonUtilities.selectValuesFromScheduleReportDropdown(driver, reportType);	


	commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

	nextButtonOfParameters.click();

	commonUtilities.scrollIntoView(driver, scheduleText);

	// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

	reportFormatDropdown.click();

	commonUtilities.selectReportFormat(driver, "CSV");
	
	/*emailRecipientsInputBox.clear();
	String emaidIdUpdate = "arunpillai1986@gmail.com";

	emailRecipientsInputBox.sendKeys(emaidIdUpdate);
*/	
    String emailGroupText = "Report group-300";
	
	emailGroupInputBox.sendKeys(emailGroupText,Keys.ENTER);
	
	String storeText = "Test n/a-1";
	storeInputBoxOfDelivery.sendKeys(storeText,Keys.ENTER);
	
	includeMeCheckBox.click();	
	
	emailSubjectDelivery.clear();
	
	String emailSubjectText = "Cash Receipts Report email subject test";
	
	emailSubjectDelivery.sendKeys(emailSubjectText);

	emailBodyDelivery.clear();
	
	String emailBodyText = "Cash Receipts Report email body test";

	emailBodyDelivery.sendKeys(emailBodyText);
	
	commonUtilities.scrollIntoView(driver, submitButton);

	submitButton.click();

	driver.switchTo().defaultContent();
	
	wait.until(
			ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Schedule updated successfully"));
	

   Assert.assertTrue(getReportSuccessMessage(), "Schedule updated successfully message not displayed");

   String actualMessageUpdate = getReportSuccessMessageText();

   String expectedMessageUpdate = "Schedule updated successfully";

   Assert.assertEquals(actualMessageUpdate, expectedMessageUpdate, "Schedule updated successfully text not matched ");


	try {
		Thread.sleep(20000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	String actualReportnameUpdate = scheduledReportLocation.getText();

	String expectedReportnameUpdate = "Cash Receipts Report";

	Assert.assertEquals(actualReportnameUpdate, actualReportnameUpdate, "Report not present in scheduled location");

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

	String expectedReportnameOnParamters = "Cash Receipts Report";

	Assert.assertEquals(actualReportnameOnParamters, expectedReportnameOnParamters,
			"Report name not matched in Parameters Form");

	String actualCalendarTypeOnParamters = scheduledReportCalendarTypeInParameters.getText();

	String expectedCalendarTypeOnParamters = "Retail";

	Assert.assertEquals(actualCalendarTypeOnParamters, expectedCalendarTypeOnParamters,
			"CalendarType not matched in Parameters Form");

	String actualFrequencyOnParamters = scheduledReportFrequencyInParameters.getText();

	String expectedFrequencyOnParamters = "MONTHLY";

	Assert.assertEquals(actualFrequencyOnParamters, expectedFrequencyOnParamters,
			"Frequency not matched in Parameters Form");

	String actualTimeZoneOnParamters = scheduledReportTimeZoneInParameters.getText();

	String expectedTimeZoneOnParamters = "Asia/Calcutta";

	Assert.assertEquals(actualTimeZoneOnParamters, expectedTimeZoneOnParamters,
			"TimeZone not matched in Parameters Form");

	String actualPeriodOnParamters = scheduledReportPeriodInParameters.getText();

	String expectedPeriodOnParamters = "Prior business month";

	Assert.assertEquals(actualPeriodOnParamters, expectedPeriodOnParamters,
			"Period not matched in Parameters Form");

	String actualStoreOnParamters = scheduledReportStoreInParametersForCashReceiptsReportAllParameters.getText();

	String expectedStoreOnParamters = "1";
	
    Assert.assertEquals(actualStoreOnParamters, expectedStoreOnParamters, "Store not matched in Parameters Form");

	
	String actualSortByOnParamters = scheduledReportSortByParametersForCashReceiptsReportAllParameters.getText();

	String expectedSortByOnParamters = "R";

	Assert.assertEquals(actualSortByOnParamters, expectedSortByOnParamters,
			"SortBy not matched in Parameters Form");
	
	
	String actualOffSetOnParamters = scheduledReportOffSetParametersForCashReceiptsReportAllParameters.getText();

	String expectedOffSetOnParamters = "6";

	Assert.assertEquals(actualOffSetOnParamters, expectedOffSetOnParamters,
			"OffSet not matched in Parameters Form");
	
	String actualReportTypeOnParamters = scheduledReportReportTypeParametersForCashReceiptsReportAllParameters.getText();

	String expectedReportTypeOnParamters = "2";

	Assert.assertEquals(actualReportTypeOnParamters, expectedReportTypeOnParamters,
			"Report Type not matched in Parameters Form");
	
	
	String actualReportFormatOnParamters = scheduledReportReportFormatInParameters.getText();

	String expectedReportFormatOnParamters = "CSV";

	Assert.assertEquals(actualReportFormatOnParamters, expectedReportFormatOnParamters,
			"Report Format not matched in Parameters Form");

	String actualEmailRecipientsOnParamters = scheduledReportEmailRecipientsInParameters.getText();

	String expectedEmailRecipientsOnParamters = "arunkumarpi@cyabge.com";

	Assert.assertEquals(actualEmailRecipientsOnParamters, expectedEmailRecipientsOnParamters,
			"Email Recipients not matched in Parameters Form");
	
	String actualStoreOnDeliveryOnParamters = scheduledReportStoreOnDeliveryParametersForCashReceiptsReportAllParameters.getText();

	String expectedStoreOnDeliveryOnParamters = "1";

	Assert.assertEquals(actualStoreOnDeliveryOnParamters, expectedStoreOnDeliveryOnParamters,
			"Store On Delivery not matched in Parameters Form");

	String actualEmailGroupOnParamters = scheduledReportEmailGroupParametersForCashReceiptsReportAllParameters.getText();

	String expectedEmailGroupOnParamters = "300";

	Assert.assertEquals(actualEmailGroupOnParamters, expectedEmailGroupOnParamters,
			"Email Group not matched in Parameters Form");

	String actualEmailSubjectOnParamters = scheduledReportEmailSubjectParametersForCashReceiptsReportAllParameters.getText();

	String expectedEmailSubjectOnParamters = "Cash Receipts Report email subject test";

	Assert.assertEquals(actualEmailSubjectOnParamters, expectedEmailSubjectOnParamters,
			"Email Subject not matched in Parameters Form");

	String actualEmailReportBodyOnParamters = scheduledReportEmailBodyParametersForCashReceiptsReportAllParameters.getText();

	String expectedEmailReportBodyOnParamters = "Cash Receipts Report email body test";

	Assert.assertEquals(actualEmailReportBodyOnParamters, expectedEmailReportBodyOnParamters,
			"Email Report Body not matched in Parameters Form");

	scheduledReportOkLinkToCloseParametersForm.click();
	
	
	//==================

	String report_frequency = "BIZ_MONTHLY";
	String report_timeZone = "Asia/Calcutta";
	String report_period = "BIZ_PRIOR_MONTH";
	String report_name = "Cash Receipts Report";
	String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
	String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

	
	

	String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cash Receipts Report' order by rowid desc LIMIT 1";

	commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
			report_period, report_name, newCurrentDate, newFutureDate);

}


	public void scheduledReportsPageSearchFunctioanlityBasedOnReportName(String reportName) {

		String reportNameForSearch = reportName;
		nameFieldForSearch.sendKeys(reportNameForSearch);
		searchButton.click();

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		commonUtilities.searchReportNameInReportScheduledTable(driver, reportNameForSearch);

	}
	
	public void scheduledReportsPageSearchFunctioanlityBasedOnReportNameAndStatus(String reportName,String reportScheduleStatus) {

		String reportNameForSearch = reportName;
        String reportScheduleStatusForSearch = reportScheduleStatus;	
        
		nameFieldForSearch.sendKeys(reportNameForSearch);
        reportScheduleStatusFieldForSearch.sendKeys(reportScheduleStatusForSearch,Keys.ENTER);
			
		searchButton.click();

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void scheduledReportsPageSearchFunctioanlityBasedOnReportNameAndTwoStatus(String reportName,String reportScheduleStatus,String reportScheduleStatusTwo) {

		String reportNameForSearch = reportName;
        String reportScheduleStatusForSearch = reportScheduleStatus;	
        String reportScheduleStatusForSearchTwo = reportScheduleStatusTwo;	

        
		nameFieldForSearch.sendKeys(reportNameForSearch);
		
		//reportScheduleStatusFieldForSearchClear.sendKeys(Keys.BACK_SPACE);

        reportScheduleStatusFieldForSearch.sendKeys(reportScheduleStatusForSearch,Keys.ENTER);
        
        nameFieldForSearch.click();
        
        reportScheduleStatusFieldForSearchClear.sendKeys(reportScheduleStatusForSearchTwo,Keys.ENTER);
        
        //reportScheduleStatusFieldForSearch.sendKeys(reportScheduleStatusForSearchTwo,Keys.ENTER);
			
		searchButton.click();

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void scheduledReportsPageSearchFunctioanlityBasedOnReportOwner(String reportOwnerName) {
		
		String reportOwnerNameForSearch = reportOwnerName;
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
         reportOwnerFieldForSearch.click();
		
		commonUtilities.selectValuesFromReportOwnerDropdownOfScheduleReportPage(driver , reportOwnerNameForSearch );
		
		searchButton.click();
			
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		commonUtilities.searchReportOwnerInReportScheduledTable(driver, reportOwnerNameForSearch);

	}

   public void scheduledReportsPageSpecificSearchFunctioanlityBasedOnReportOwner(String reportName, String reportOwnerName,String reportPeriod,String reportStatus) {
		
		String reportNameForSearch = reportName;
		String reportOwnerNameForSearch = reportOwnerName;
		String reportPeriodForSearch = reportPeriod;
		String reportScheduleStatusForSearch = reportStatus;
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		nameFieldForSearch.sendKeys(reportNameForSearch);
		
		reportOwnerFieldForSearch.click();
		
		commonUtilities.selectValuesFromReportOwnerDropdownOfScheduleReportPage(driver , reportOwnerNameForSearch );
		
		reportPeriodFieldForSearch.click();
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver , reportPeriodForSearch);
		
		reportScheduleStatusFieldForSearch.sendKeys(reportScheduleStatusForSearch,Keys.ENTER);
		
		searchButton.click();
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		commonUtilities.searchReportNameInReportScheduledTable(driver, reportNameForSearch);

		commonUtilities.searchReportOwnerInReportScheduledTable(driver, reportOwnerNameForSearch);
		
		commonUtilities.searchReportStatusInReportScheduledTable(driver, reportScheduleStatusForSearch);
		
		commonUtilities.searchReportPeriodRunScheduleInReportScheduledTable(driver, reportPeriodForSearch);

	}
   
   public void scheduledReportsPageAllReportSearchFunctioanlityBasedOnReportOwner(String reportOwnerName) {
		
		String reportOwnerNameForSearch = reportOwnerName;

		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		reportOwnerFieldForSearch.click();
		
		commonUtilities.selectValuesFromReportOwnerDropdownOfScheduleReportPage(driver , reportOwnerNameForSearch );
		
		
		searchButton.click();
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		commonUtilities.searchReportOwnerInReportScheduledTable(driver, reportOwnerNameForSearch);
		
	}
   public void scheduledReportsPageAllReportSearchFunctioanlityBasedOnAdmin() {
		
		//String reportOwnerNameForSearch = reportOwnerName;

		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		reportOwnerFieldForSearch.click();
		
		allOptionForReportOwner.click();
		//commonUtilities.selectValuesFromReportOwnerALLDropdownOfScheduleReportPage(driver , reportOwnerNameForSearch );
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String ownerAll = "ALL";
		
		
		// ALL options available means user has admin right
		Assert.assertEquals(reportOwnerFieldForSearch.getText(), ownerAll);
		
		reportOwnerFieldForSearch.click();
		
		adminUser.click();
		
		searchButton.click();
		
		String adminUsername = "pa3jas";
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		commonUtilities.searchReportOwnerInReportScheduledTable(driver, adminUsername);
		
	}

  
   
   public void scheduledReportsPageSearchFunctioanlityBasedOnPeriod(String reportPeriod) {
		
		String reportPeriodForSearch = reportPeriod;
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		reportPeriodFieldForSearch.click();
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver , reportPeriodForSearch);
		
		searchButton.click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		commonUtilities.searchReportPeriodRunScheduleInReportScheduledTable(driver, reportPeriodForSearch);

	}
   
   public void scheduledReportsPageSearchFunctioanlityBasedOnReportNameAndPeriod(String reportName,String reportPeriod) {
		
		
		String reportNameForSearch = reportName;
		
		String reportPeriodForSearch = reportPeriod;
       
		nameFieldForSearch.sendKeys(reportNameForSearch);
		
        reportPeriodFieldForSearch.click();
		
		commonUtilities.selectValuesFromScheduleReportDropdown(driver , reportPeriodForSearch);
					
		searchButton.click();
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
   public void scheduledReportsPageSearchFunctioanlityBasedOnReportScheduleStatus(String reportScheduleStatus) {
		
	   String reportScheduleStatusForSearch = reportScheduleStatus;		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		reportScheduleStatusFieldForSearch.sendKeys(reportScheduleStatusForSearch,Keys.ENTER);
		
		searchButton.click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		commonUtilities.searchReportStatusInReportScheduledTable(driver, reportScheduleStatusForSearch);

	}
   
	public void getCancelReportFunctionality() {

		selectReportCheckboxFromScheduledReportPage.click();
		cancelButtonForSelectedReport.click();
		confirmYesForCancelSelectedReport.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report cancelled successfully"));

		Assert.assertTrue(getReportSuccessMessage(), "Report cancelled successfully message not displayed");

		String actualMessage = getReportSuccessMessageText();

		String expectedMessage = "Report cancelled successfully";

		Assert.assertEquals(actualMessage, expectedMessage, "Report cancelled successfully text not matched ");
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		nameFieldForSearch.clear();
		
		reportScheduleStatusFieldForSearchClear.sendKeys(Keys.BACK_SPACE);
		
		String reportNameNew = "Cloud 9 POS Emp Productivity";

		//scheduledReportsPageSearchFunctioanlityBasedOnReportName(reportNameNew);
		
		String reportScheduleStatusNew = "Cancelled";

		//scheduledReportsPageSearchFunctioanlityBasedOnReportScheduleStatus(reportScheduleStatusNew);
		
		scheduledReportsPageSearchFunctioanlityBasedOnReportNameAndStatus(reportNameNew,reportScheduleStatusNew);

		String actualReportStatus = reportStatusCancelledTextOnScheduledReportPage.getText();

		String expectedReportStatus = "Cancelled";	
		
		Assert.assertEquals(actualReportStatus, expectedReportStatus, "Cancelled text not matched ");
		
		selectReportCheckboxFromScheduledReportPage.click();

		Assert.assertTrue(reassignButtonForSelectedReport.isEnabled(), "Reassign  Button Not Enabled For Report");

		Assert.assertFalse(cancelButtonForSelectedReport.isEnabled(), "Cancel Button Enabled For Report");

		Assert.assertFalse(suspendButtonForSelectedReport.isEnabled(), "Suspend Button Enabled For Report");

		Assert.assertFalse(reactivateButtonForSelectedReport.isEnabled(), "Reactive Button Enabled For Report");

	}   
	
	public void getSuspendReportFunctionality() {

		selectReportCheckboxFromScheduledReportPage.click();
		
		suspendButtonForSelectedReport.click();
		
		confirmYesForSuspendSelectedReport.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report suspended Successfully"));

		Assert.assertTrue(getReportSuccessMessage(), "Report suspended Successfully message not displayed");

		String actualMessage = getReportSuccessMessageText();

		String expectedMessage = "Report suspended Successfully";

		Assert.assertEquals(actualMessage, expectedMessage, "Report suspended Successfully text not matched ");
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		nameFieldForSearch.clear();
		
		reportScheduleStatusFieldForSearchClear.sendKeys(Keys.BACK_SPACE);
		
		String reportNameNew = "Cloud 9 POS Emp Productivity";

		//scheduledReportsPageSearchFunctioanlityBasedOnReportName(reportNameNew);
		
		String reportScheduleStatusNew = "Suspended";

		//scheduledReportsPageSearchFunctioanlityBasedOnReportScheduleStatus(reportScheduleStatusNew);
		
		scheduledReportsPageSearchFunctioanlityBasedOnReportNameAndStatus(reportNameNew,reportScheduleStatusNew);

		
		Assert.assertTrue(scheduledReportEditLink.isEnabled(), "Edit Button Enabled For Report");
		
		Assert.assertTrue(scheduledReportRunLink.isEnabled(), "Run Button Enabled For Report");

		
		String actualReportStatus = reportStatusSuspendedTextOnScheduledReportPage.getText();

		String expectedReportStatus = "Suspended";	
		
		Assert.assertEquals(actualReportStatus, expectedReportStatus, "Suspended text not matched ");
		
		selectReportCheckboxFromScheduledReportPage.click();

		Assert.assertTrue(reassignButtonForSelectedReport.isEnabled(), "Reassign  Button Not Enabled For Report");

		Assert.assertTrue(cancelButtonForSelectedReport.isEnabled(), "Cancel Button Not Enabled For Report");

		Assert.assertTrue(reactivateButtonForSelectedReport.isEnabled(), "Reactive Button Not Enabled For Report");
		
		Assert.assertFalse(suspendButtonForSelectedReport.isEnabled(), "Suspend Button Enabled For Report");
	}  
	
	public void getSuspendReportBasicFunctionality() {

		selectReportCheckboxFromScheduledReportPage.click();
		
		suspendButtonForSelectedReport.click();
		
		confirmYesForSuspendSelectedReport.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report suspended Successfully"));

		Assert.assertTrue(getReportSuccessMessage(), "Report suspended Successfully message not displayed");

		String actualMessage = getReportSuccessMessageText();

		String expectedMessage = "Report suspended Successfully";

		Assert.assertEquals(actualMessage, expectedMessage, "Report suspended Successfully text not matched ");
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		nameFieldForSearch.clear();
		
		reportScheduleStatusFieldForSearchClear.sendKeys(Keys.BACK_SPACE);
		
	}
	
	public void getCancelSuspendedReportFunctionality() {

		selectReportCheckboxFromScheduledReportPage.click();
		cancelButtonForSelectedReport.click();
		confirmYesForCancelSelectedReport.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report cancelled successfully"));

		Assert.assertTrue(getReportSuccessMessage(), "Report cancelled successfully message not displayed");

		String actualMessage = getReportSuccessMessageText();

		String expectedMessage = "Report cancelled successfully";

		Assert.assertEquals(actualMessage, expectedMessage, "Report cancelled successfully text not matched ");
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		nameFieldForSearch.clear();
		
		reportScheduleStatusFieldForSearchClear.sendKeys(Keys.BACK_SPACE);
		
		String reportNameNew = "Cloud 9 POS Emp Productivity";
	
		String reportScheduleStatusNew = "Cancelled";
		
		scheduledReportsPageSearchFunctioanlityBasedOnReportNameAndStatus(reportNameNew,reportScheduleStatusNew);

		String actualReportStatus = reportStatusCancelledTextOnScheduledReportPage.getText();

		String expectedReportStatus = "Cancelled";	
		
		Assert.assertEquals(actualReportStatus, expectedReportStatus, "Cancelled text not matched ");
		
		selectReportCheckboxFromScheduledReportPage.click();

		Assert.assertTrue(reassignButtonForSelectedReport.isEnabled(), "Reassign  Button Not Enabled For Report");

		Assert.assertFalse(cancelButtonForSelectedReport.isEnabled(), "Cancel Button Enabled For Report");

		Assert.assertFalse(suspendButtonForSelectedReport.isEnabled(), "Suspend Button Enabled For Report");

		Assert.assertFalse(reactivateButtonForSelectedReport.isEnabled(), "Reactive Button Enabled For Report");

	}   

	public void getReactivateSuspendedReportFunctionality() {

		selectReportCheckboxFromScheduledReportPage.click();
		
		reactivateButtonForSelectedReport.click();
		
		confirmYesForReactivateSelectedReport.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report activated Successfully"));

		Assert.assertTrue(getReportSuccessMessage(), "Report activated Successfully message not displayed");

		String actualMessage = getReportSuccessMessageText();

		String expectedMessage = "Report activated Successfully";

		Assert.assertEquals(actualMessage, expectedMessage, "Report activated Successfully text not matched ");
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		nameFieldForSearch.clear();
		
		reportScheduleStatusFieldForSearchClear.sendKeys(Keys.BACK_SPACE);
		
		String reportNameNew = "Cloud 9 POS Emp Productivity";

		//scheduledReportsPageSearchFunctioanlityBasedOnReportName(reportNameNew);
		
		String reportScheduleStatusNew = "Active";

		//scheduledReportsPageSearchFunctioanlityBasedOnReportScheduleStatus(reportScheduleStatusNew);
		
		scheduledReportsPageSearchFunctioanlityBasedOnReportNameAndStatus(reportNameNew,reportScheduleStatusNew);

		
		Assert.assertTrue(scheduledReportEditLink.isEnabled(), "Edit Button Enabled For Report");
		
		Assert.assertTrue(scheduledReportRunLink.isEnabled(), "Run Button Enabled For Report");

		
		String actualReportStatus = reportStatusActiveTextOnScheduledReportPage.getText();

		String expectedReportStatus = "Active";	
		
		Assert.assertEquals(actualReportStatus, expectedReportStatus, "Active text not matched ");
		
		selectReportCheckboxFromScheduledReportPage.click();

		Assert.assertTrue(reassignButtonForSelectedReport.isEnabled(), "Reassign  Button Not Enabled For Report");

		Assert.assertTrue(cancelButtonForSelectedReport.isEnabled(), "Cancel Button Not Enabled For Report");

		Assert.assertFalse(reactivateButtonForSelectedReport.isEnabled(), "Reactive Button Enabled For Report");
		
		Assert.assertTrue(suspendButtonForSelectedReport.isEnabled(), "Suspend Button Not Enabled For Report");

	}   

	public void getReassignSingleReportFunctionality() {

		selectReportCheckboxFromScheduledReportPage.click();
		
		reassignButtonForSelectedReport.click();
		
		userSelectDropdownForReassign.click();
		
		String userforReassign = "pa3runner";
		
		commonUtilities.selectValuesFromReportOwnerDropdownForSelectUserOfScheduleReportPage(driver, userforReassign);

		okForReassignSelectedReport.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "1 Report(s) assigned successfully"));

		Assert.assertTrue(getReportSuccessMessage(), "1 Report(s) assigned successfully message not displayed");

		String actualMessage = getReportSuccessMessageText();

		String expectedMessage = "1 Report(s) assigned successfully";

		Assert.assertEquals(actualMessage, expectedMessage, "1 Report(s) assigned successfully");
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		reportOwnerFieldForSearch.click();
		
		String allReportOwnerSearch = "All";
	
		commonUtilities.selectValuesFromReportOwnerDropdownForSelectUserOfScheduleReportPage(driver , allReportOwnerSearch );

		searchButton.click();
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String actualReportOwnerName = scheduledReportOwnerName.getText();

		String expectedReportOwnerName = "pa3runner";	
		
		Assert.assertEquals(actualReportOwnerName, expectedReportOwnerName, "Report Owner text not matched ");
	
	}   
	
	public void getReassignMultipleReportFunctionality() {

		selectReportCheckboxFromScheduledReportPage.click();
		
		selectSecondReportCheckboxFromScheduledReportPage.click();
		
		reassignButtonForSelectedReport.click();
		
		userSelectDropdownForReassign.click();
		
		String userforReassign = "pa3runner";
		
		commonUtilities.selectValuesFromReportOwnerDropdownForSelectUserOfScheduleReportPage(driver, userforReassign);

		okForReassignSelectedReport.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "2 Report(s) assigned successfully"));

		Assert.assertTrue(getReportSuccessMessage(), "2 Report(s) assigned successfully message not displayed");

		String actualMessage = getReportSuccessMessageText();

		String expectedMessage = "2 Report(s) assigned successfully";

		Assert.assertEquals(actualMessage, expectedMessage, "2 Report(s) assigned successfully");
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		reportOwnerFieldForSearch.click();
		
		String allReportOwnerSearch = "All";
	
		commonUtilities.selectValuesFromReportOwnerDropdownForSelectUserOfScheduleReportPage(driver , allReportOwnerSearch );

		searchButton.click();
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String actualReportOwnerName = scheduledReportOwnerName.getText();

		String expectedReportOwnerName = "pa3runner";	
		
		Assert.assertEquals(actualReportOwnerName, expectedReportOwnerName, "Report Owner text not matched ");
		
		String actualReportOwnerNameTwo = scheduledReportOwnerNameTwo.getText();

		String expectedReportOwnerNameTwo = "pa3runner";	
		
		Assert.assertEquals(actualReportOwnerNameTwo, expectedReportOwnerNameTwo, "Report Owner text not matched ");
	
	}   
	
	public void getResetButtonFunctionality() {
	
		reportPerPageDropdown.click();
		
		String reportPerPageNumber = "5";
		
		commonUtilities.selectValuesFromReportOwnerDropdownForSelectUserOfScheduleReportPage(driver , reportPerPageNumber );
		
		selectReportCheckboxFromScheduledReportPage.click();
		
		commonUtilities.scrollIntoView(driver, reportNextPageArrow);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(reportNextPageArrow).click().build().perform();

		//reportNextPageArrow.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resetButton.click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertFalse(selectReportCheckboxFromScheduledReportPage.isSelected(), "Report check box selected ");

		String actualReportName = nameFieldForSearch.getText();

		String expectedReportName = "";	
		
		Assert.assertEquals(actualReportName, expectedReportName, "Report Owner text not matched ");
		
		String actualReportPeriod = reportPeriodFieldForSearch.getText();

		String expectedReportPeriod = "ALL";	
		
		Assert.assertEquals(actualReportPeriod, expectedReportPeriod, "Report Owner text not matched ");
	
	}   

	public void getScheduledReportsPaginationFunctionality() {
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		reportPerPageDropdown.click();
		
		String reportPerPageNumber = "5";
		
		commonUtilities.selectValuesFromReportOwnerDropdownForSelectUserOfScheduleReportPage(driver , reportPerPageNumber );
		
		String numberOfReport = reportPerPageDropdown.getText();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//numberOfRowsInScheduledReportsPage.click();
		
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='tile b--gray-medium results-row mb1']")); 
		 
		int numberOfRowsForReport = rows.size();
		
		String numberOfReportCount = Integer.toString(numberOfRowsForReport);
		
		Assert.assertEquals(numberOfReport, numberOfReportCount, "Reports count not matched ");
		
		String actualCurrentPageRecordsBeforeNextButtonClick = currentPageRecords.getText();
		
		commonUtilities.scrollIntoView(driver, reportNextPageArrow);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(reportNextPageArrow).click().build().perform();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String actualCurrentPageRecords = currentPageRecords.getText();
		
		String expectedCurrentPageRecords = "6 - 10";
		
		Assert.assertEquals(actualCurrentPageRecords, expectedCurrentPageRecords, "Current Page Records Count Not Matched After Next Click");
		
		actions.moveToElement(reportPrevPageArrow).click().build().perform();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        String actualCurrentPageRecordsAfterPrevButtonClick = "1 - 5";
		
		Assert.assertEquals(actualCurrentPageRecordsBeforeNextButtonClick, actualCurrentPageRecordsAfterPrevButtonClick, "Current Page Records Count Not Matched After Prev Click");
	
	}   
	
public void getScheduledReportsHelpFunctionality() {
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		Actions action = new Actions(driver);
   		action.moveToElement(HelpButton).build().perform();
   		
   		String parentHandle = driver.getWindowHandle(); // get the current window handle
   		helpOnThisPageLink.click(); // click some link that opens a new window

   		for (String winHandle : driver.getWindowHandles()) {
   		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
   		}

   		//code to do something on new window
		Assert.assertTrue(scheduleReportsTextOnHelpPage.isDisplayed(),"Scheduled Reports Text Not Displayed On Help Page");
		Assert.assertTrue(businessObjectiveTextOnHelpPage.isDisplayed(),"Scheduled Reports Text Not Displayed On Help Page");
  		
   		driver.close(); // close newly opened window when done with it
   		driver.switchTo().window(parentHandle); // switch back to the original window
 
	}   

   
//*********************************************************Backup*************************************************************************************************************	
	//*************************************************************Cash2******************************************************************************************************
	
		public void getCashReceiptReportSchedulerWithFrequencyWeeklyAndPeriodBWTD1() throws SQLException {

			WebDriverWait wait = new WebDriverWait(driver, 20);

			wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

			Assert.assertTrue(scheduleText.isDisplayed());

			// frequencyDropdown.click();

			// String frequencyText = "FIRST DAY OF WEEK";

			// commonUtilities.selectValuesFromScheduleReportDropdown(driver,
			// frequencyText);

			String currnetDate = commonUtilities.selectCurrentDate();
			reportStartDate.sendKeys(currnetDate);
			
			int days = 35;

			String futureDate = commonUtilities.selectFutureDate(days);
			reportEndtDate.sendKeys(futureDate);

			commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
			nextButtonOfDetails.click();

			commonUtilities.scrollIntoView(driver, scheduleText);

			// commonUtilities.clickElementByJS(driver, periodDropdown);

			periodDropdown.click();

			String periodText = "Business month to date";
			
			String periodWeekText = "Business week to date";

			commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
			
			periodDropdown.click();
			
			commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodWeekText);
			
			
			commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

			nextButtonOfParameters.click();

			commonUtilities.scrollIntoView(driver, scheduleText);

			// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

			reportFormatDropdown.click();

			commonUtilities.selectReportFormat(driver, "CSV");

			// emailRecipientsInputBox.sendKeys("arunkumarpi@cyabge.com");

			commonUtilities.scrollIntoView(driver, submitButton);

			submitButton.click();

			driver.switchTo().defaultContent();

			wait.until(
					ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

			String report_frequency = "BIZ_WEEKLY";
			String report_timeZone = "Asia/Calcutta";
			String report_period = "BIZ_WTD";
			String report_name = "Cash Receipts Report";
			String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
			String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

			
			

			//String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

			String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cash Receipts Report' order by rowid desc LIMIT 1";

			
			commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
					report_period, report_name, newCurrentDate, newFutureDate);

		}

		
		public void getCashReceiptReportSchedulerWithFrequencyMonthlyAndPeriodBMTD1() throws SQLException {

			WebDriverWait wait = new WebDriverWait(driver, 20);

			wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

			Assert.assertTrue(scheduleText.isDisplayed());

			frequencyDropdown.click();

			String frequencyText = "FIRST DAY OF MONTH";

			commonUtilities.selectValuesFromScheduleReportDropdown(driver, frequencyText);

			String currnetDate = commonUtilities.selectCurrentDate();
			reportStartDate.sendKeys(currnetDate);
			
			int days = 35;


			String futureDate = commonUtilities.selectFutureDate(days);
			reportEndtDate.sendKeys(futureDate);

			commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
			nextButtonOfDetails.click();

			commonUtilities.scrollIntoView(driver, scheduleText);

			// commonUtilities.clickElementByJS(driver, periodDropdown);

			periodDropdown.click();

			String periodText = "Business month to date";

			commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);

			commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

			nextButtonOfParameters.click();

			commonUtilities.scrollIntoView(driver, scheduleText);

			// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

			reportFormatDropdown.click();

			commonUtilities.selectReportFormat(driver, "CSV");

			// emailRecipientsInputBox.sendKeys("arunkumarpi@cyabge.com");

			commonUtilities.scrollIntoView(driver, submitButton);

			submitButton.click();

			driver.switchTo().defaultContent();
			

			wait.until(
					ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

			String report_frequency = "BIZ_MONTHLY";
			String report_timeZone = "Asia/Calcutta";
			String report_period = "BIZ_MTD";
			String report_name = "Cash Receipts Report";
			String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
			String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

			
			

			//String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

			String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cash Receipts Report' order by rowid desc LIMIT 1";

			
			commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
					report_period, report_name, newCurrentDate, newFutureDate);

		}


		public void getCashReceiptReportSchedulerWithFrequencyQuarterlyAndPeriodBQTD1() throws SQLException {

			WebDriverWait wait = new WebDriverWait(driver, 20);

			wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

			Assert.assertTrue(scheduleText.isDisplayed());

			frequencyDropdown.click();

			String frequencyText = "FIRST DAY OF QUARTER";

			commonUtilities.selectValuesFromScheduleReportDropdown(driver, frequencyText);

			String currnetDate = commonUtilities.selectCurrentDate();
			reportStartDate.sendKeys(currnetDate);
			
			int days = 200;

			String futureDate = commonUtilities.selectFutureDate(days);
			reportEndtDate.sendKeys(futureDate);

			commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
			nextButtonOfDetails.click();

			commonUtilities.scrollIntoView(driver, scheduleText);
			


			// commonUtilities.clickElementByJS(driver, periodDropdown);

			periodDropdown.click();

			String periodText = "Business quarter to date";

			commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);
			
			

			commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

			nextButtonOfParameters.click();

			commonUtilities.scrollIntoView(driver, scheduleText);

			// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

			reportFormatDropdown.click();

			commonUtilities.selectReportFormat(driver, "CSV");

			// emailRecipientsInputBox.sendKeys("arunkumarpi@cyabge.com");

			commonUtilities.scrollIntoView(driver, submitButton);

			submitButton.click();

			driver.switchTo().defaultContent();
			

			wait.until(
					ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

			String report_frequency = "BIZ_QUARTERLY";
			String report_timeZone = "Asia/Calcutta";
			String report_period = "BIZ_QTD";
			String report_name = "Cash Receipts Report";
			String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
			String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

			
			

			//String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";
			
			String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cash Receipts Report' order by rowid desc LIMIT 1";

			
			commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
					report_period, report_name, newCurrentDate, newFutureDate);

		}
		
		public void getCashReceiptReportSchedulerWithFrequencyYearlyAndPeriodBYTD1() throws SQLException {

			WebDriverWait wait = new WebDriverWait(driver, 20);

			wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

			Assert.assertTrue(scheduleText.isDisplayed());

			frequencyDropdown.click();

			String frequencyText = "FIRST DAY OF YEAR";

			commonUtilities.selectValuesFromScheduleReportDropdown(driver, frequencyText);

			String currnetDate = commonUtilities.selectCurrentDate();
			reportStartDate.sendKeys(currnetDate);
			
			int days = 400;


			String futureDate = commonUtilities.selectFutureDate(days);
			reportEndtDate.sendKeys(futureDate);

			commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
			nextButtonOfDetails.click();

			commonUtilities.scrollIntoView(driver, scheduleText);

			// commonUtilities.clickElementByJS(driver, periodDropdown);

			periodDropdown.click();

			String periodText = "Business year to date";

			commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);

			commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

			nextButtonOfParameters.click();

			commonUtilities.scrollIntoView(driver, scheduleText);

			// commonUtilities.clickElementByJS(driver, reportFormatDropdown);

			reportFormatDropdown.click();

			commonUtilities.selectReportFormat(driver, "CSV");

			// emailRecipientsInputBox.sendKeys("arunkumarpi@cyabge.com");

			commonUtilities.scrollIntoView(driver, submitButton);

			submitButton.click();

			driver.switchTo().defaultContent();

			wait.until(
					ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));

			String report_frequency = "BIZ_YEARLY";
			String report_timeZone = "Asia/Calcutta";
			String report_period = "BIZ_YTD";
			String report_name = "Cash Receipts Report";
			String newCurrentDate = commonUtilities.completeDateFormat(driver, currnetDate);
			String newFutureDate = commonUtilities.completeDateFormat(driver, futureDate);

			
			

			//String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

			String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cash Receipts Report' order by rowid desc LIMIT 1";

			commonUtilities.databaseRecordVerification(driver, queryString, report_frequency, report_timeZone,
					report_period, report_name, newCurrentDate, newFutureDate);

		}

		
	//********************************************************Cash/******************************************************************************************************************
		
	public void getCloud9POSEmpProductivityReportScheduler() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		// wait.until(ExpectedConditions.visibilityOfElementLocated(scheduleText));//

		Assert.assertTrue(scheduleText.isDisplayed());
				
		//frequencyDropdown.click();
		
		//String frequencyText = "FIRST DAY OF WEEK";

		//commonUtilities.selectValuesFromScheduleReportDropdown(driver, frequencyText);

		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
		
        int days = 35;
		
		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);		
 

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);
		nextButtonOfDetails.click();		
		

		commonUtilities.scrollIntoView(driver, scheduleText);
		
		//commonUtilities.clickElementByJS(driver, periodDropdown);

		periodDropdown.click();
		
		String periodText = "Business month to date";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);

		commonUtilities.scrollIntoView(driver, nextButtonOfParameters);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, scheduleText);
		
		//commonUtilities.clickElementByJS(driver, reportFormatDropdown);

		reportFormatDropdown.click();
		
		commonUtilities.selectReportFormat(driver, "EXCEL");

		// emailRecipientsInputBox.sendKeys("arunkumarpi@cyabge.com");

		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();
		
		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));
		
		Assert.assertTrue(getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");
		
		//wait.until(ExpectedConditions.elementToBeClickable(scheduledReportLocation));
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        String actualReportname = scheduledReportLocation.getText();
        
        String expectedReportname = "Cloud 9 POS Emp Productivity";
		
		Assert.assertEquals(actualReportname, expectedReportname ,"Report not present in scheduled location");		
		
		//getReportScheduledParamForCloud9POSEmpProductivity();		
		scheduledReportParamLink.click();
		
		//commonUtilities.clickElementByJS(driver, scheduledReportParam);
		
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//wait.until(ExpectedConditions.textToBePresentInElement(scheduledReportParametersText, "Schedule Report Parameters"));		
		
        Assert.assertTrue(scheduledReportParametersText.isDisplayed(), "Schedule Report Parameters not displayed on Parameters Form");
		
        String actualReportnameOnParamters = scheduledReportNameInParameters.getText();
        
        String expectedReportnameOnParamters = "Cloud 9 POS Emp Productivity";
        
		Assert.assertEquals(actualReportnameOnParamters, expectedReportnameOnParamters ,"Report name not matched in Parameters Form");
		
        String actualCalendarTypeOnParamters = scheduledReportCalendarTypeInParameters.getText();
        
        String expectedCalendarTypeOnParamters = "Retail";
        
		Assert.assertEquals(actualCalendarTypeOnParamters, expectedCalendarTypeOnParamters ,"CalendarType not matched in Parameters Form");
		
        String actualFrequencyOnParamters = scheduledReportFrequencyInParameters.getText();
        
        String expectedFrequencyOnParamters = "WEEKLY";
        
		Assert.assertEquals(actualFrequencyOnParamters, expectedFrequencyOnParamters ,"Frequency not matched in Parameters Form");
				
        String actualTimeZoneOnParamters = scheduledReportTimeZoneInParameters.getText();
        
        String expectedTimeZoneOnParamters = "Asia/Calcutta";
        
		Assert.assertEquals(actualTimeZoneOnParamters, expectedTimeZoneOnParamters ,"TimeZone not matched in Parameters Form");
		
        String actualPeriodOnParamters = scheduledReportPeriodInParameters.getText();
        
        String expectedPeriodOnParamters = "Business month to date";
        
		Assert.assertEquals(actualPeriodOnParamters, expectedPeriodOnParamters ,"Period not matched in Parameters Form");
		
        String actualStoreOnParamters = scheduledReportStoreInParameters.getText();
        
        String expectedStoreOnParamters = "[test]";
        
		Assert.assertEquals(actualStoreOnParamters, expectedStoreOnParamters ,"Store not matched in Parameters Form");
		
        String actualTransactiontypesOnParamters = scheduledReportTransactiontypesInParameters.getText();
        
        String expectedTransactiontypesOnParamters = "[test]";
        
		Assert.assertEquals(actualTransactiontypesOnParamters, expectedTransactiontypesOnParamters ,"Transaction types not matched in Parameters Form");
		
        String actualReportFormatOnParamters = scheduledReportReportFormatInParameters.getText();
        
        String expectedReportFormatOnParamters = "XLS";
        
		Assert.assertEquals(actualReportFormatOnParamters, expectedReportFormatOnParamters ,"Report Format not matched in Parameters Form");
		
        String actualEmailRecipientsOnParamters = scheduledReportEmailRecipientsInParameters.getText();
        
        String expectedEmailRecipientsOnParamters = "rmathew@kwi.com";
        
		Assert.assertEquals(actualEmailRecipientsOnParamters, expectedEmailRecipientsOnParamters ,"Email Recipients not matched in Parameters Form");
		
        String actualEmailSubjectOnParamters = scheduledReportEmailSubjectInParameters.getText();
        
        String expectedEmailSubjectOnParamters = "";
        
		Assert.assertEquals(actualEmailSubjectOnParamters, expectedEmailSubjectOnParamters ,"Email Subject not matched in Parameters Form");
		
		String actualEmailReportBodyOnParamters = scheduledReportEmailReportBodyInParameters.getText();
        
        String expectedEmailReportBodyOnParamters = "Below is the requested report";
        
		Assert.assertEquals(actualEmailReportBodyOnParamters, expectedEmailReportBodyOnParamters ,"Email Report Body not matched in Parameters Form");
		
		scheduledReportOkLinkToCloseParametersForm.click();
		
		
		String report_frequency = "BIZ_WEEKLY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "BIZ_MTD";
		String report_name = "Cloud 9 POS Emp Productivity";
		
		
		//String currnetDate = commonUtilities.selectCurrentDate();

		//String futureDate = commonUtilities.selectFutureDate();
			
		
		String newCurrentDate = commonUtilities.completeDateFormat(driver , currnetDate);
		
		String newFutureDate = commonUtilities.completeDateFormat(driver , futureDate);
		
		
		

		
		//====

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://192.9.200.201:3306/pandora?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false",
				"apillai", "OKzOHKu0R5HGv3nL");

		Statement stmt = conn.createStatement();

		String query = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cloud 9 POS Emp Productivity' order by rowid desc LIMIT 1";

		ResultSet rs = stmt.executeQuery(query);

		boolean status = false;

		while (rs.next()) {

			String frequency = rs.getString("type_rscd"); 
			String timeZone = rs.getString("tz_rscd");
			String period = rs.getString("period_rscd");
			String name = rs.getString("name_rscd");
			String startDate = rs.getString("start_rscd");
			String endDate = rs.getString("end_rscd");

			
			 
			 
			
			Assert.assertEquals(report_frequency, frequency, "Frequency value not matched");
			Assert.assertEquals(report_timeZone, timeZone, "timezone value not matched");
			Assert.assertEquals(report_period, period, "period value not matched");
			Assert.assertEquals(report_name, name, "report name value not matched");
			Assert.assertEquals(newCurrentDate, startDate, "start date value not matched");
			Assert.assertEquals(newFutureDate, endDate, "end date value not matched");


			if (report_frequency.equals(frequency) && report_timeZone.equals(timeZone) && report_period.equals(period)
					&& report_name.equals(name) && newCurrentDate.equals(startDate) && newFutureDate.equals(endDate) ) {

				System.out.println(" Record Found In Table ");
				status = true;
				break;

			}

		}

		if (status == false) {

			System.out.println("Record found");

		}
		
		Assert.assertTrue(status, "Record Not Found In Table");

		conn.close();
	}

	public void getCashReceiptsReportScheduler() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());
		
		String frequencyText = "DAILY";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, frequencyText);

		//commonUtilities.scrollIntoView(driver, runTime);

		//runTime.click();
		
		//String runTimeText = "04:00 AM";

		//commonUtilities.selectValuesFromScheduledReportDropdown(driver, runTimeText);

		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);

		//System.out.println(reportStartDate.getText());
		
		int days = 35;

		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);

		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, periodDropdown);

		periodDropdown.click();

		// commonUtilities.scrollIntoView(periodDropdown);
		
		String periodText = "Business month to date";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, reportFormatDropdown);

		reportFormatDropdown.click();
		
		commonUtilities.selectReportFormat(driver, "CSV");
		
		String emailIdText = "arunkumarpi@cyabge.com";

		emailRecipientsInputBox.sendKeys(emailIdText);

		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));
		
		String report_frequency = "BIZ_WEEKLY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "BIZ_MTD";
		String report_name = "Cash Receipts Report";
		
        String newCurrentDate = commonUtilities.completeDateFormat(driver , currnetDate);                    
		String newFutureDate = commonUtilities.completeDateFormat(driver , futureDate);
		
		
		

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://192.9.200.201:3306/pandora?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false",
				"apillai", "OKzOHKu0R5HGv3nL");

		Statement stmt = conn.createStatement();
		
		//String query = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cash Receipts Report' order by rowid desc LIMIT 1";

		String query = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cash Receipts Report' order by rowid desc LIMIT 1";


		//String query = "select type_rscd, tz_rscd , period_rscd , name_rscd from report_schedule where name_rscd = 'Cash Receipts Report' order by rowid desc LIMIT 1";

		ResultSet rs = stmt.executeQuery(query);

		boolean status = false;

		while (rs.next()) {

			String frequency = rs.getString("type_rscd"); 
			String timeZone = rs.getString("tz_rscd");
			String period = rs.getString("period_rscd");
			String name = rs.getString("name_rscd");
			String startDate = rs.getString("start_rscd");
			String endDate = rs.getString("end_rscd");

			
			 
			 


			if (report_frequency.equals(frequency) && report_timeZone.equals(timeZone) && report_period.equals(period)
					&& report_name.equals(name) && newCurrentDate.equals(startDate) && newFutureDate.equals(endDate) ) {

				System.out.println(" Record Found In Table ");
				status = true;
				break;
			

			}

		}

		if (status == false) {

			System.out.println("Record not found in table");

		}
		
		Assert.assertTrue(status, "Record Not Found In Table");

		conn.close();


	}
	
	public boolean getReportSuccessMessage() {
		 return scheduledReportMessage.isDisplayed();
	}

	public String getReportSuccessMessageText() {
		 return scheduledReportMessage.getText();
	}
	
	public String getReportScheduledName() {
		 return scheduledReportLocation.getText();
	}
	
	public void getReportScheduledParamForCloud9POSEmpProductivity() {
		
		if(scheduledReportLocation.getText().equals("Cloud 9 POS Emp Productivity")) {
			
			scheduledReportParamLink.click();
			
		}
		  
	}
	
    public void getReportScheduledParamForCashReceiptsReport() {
		
		if(scheduledReportLocation.getText().equals("Cash Receipts Report")) {
			
			scheduledReportParamLink.click();
		}
		  
	}
	

	public void getReportSchedulerForRetailCalendar() {
		// commonUtilities.switchToFrameOfReportScheduler();
		//commonUtilities.selectValueFromDropDown(frequencyDropdown, "FIRST DAY OF WEEK");
		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);
	}
	
	public void getCashReceiptsReportScheduler2() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());
		
		String frequencyText = "DAILY";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, frequencyText);

		//commonUtilities.scrollIntoView(driver, runTime);

		//runTime.click();
		
		//String runTimeText = "04:00 AM";

		//commonUtilities.selectValuesFromScheduleReportDropdown(driver, runTimeText);

		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);

		//System.out.println(reportStartDate.getText());
		
        int days = 35;


		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		commonUtilities.scrollIntoView(driver, nextButtonOfDetails);

		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, periodDropdown);

		periodDropdown.click();

		// commonUtilities.scrollIntoView(periodDropdown);
		
		String periodText = "Business month to date";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, reportFormatDropdown);

		reportFormatDropdown.click();
		
		commonUtilities.selectReportFormat(driver, "CSV");
		
		String emailIdText = "arunkumarpi@cyabge.com";

		emailRecipientsInputBox.sendKeys(emailIdText);

		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();
		  
		
		

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));
		
		String report_frequency = "BIZ_WEEKLY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "BIZ_MTD";
		String report_name = "Cash Receipts Report";
		
        //String newCurrentDate = commonUtilities.completeDateFormat(driver , currnetDate);
        
        
        String newDate = commonUtilities.addHoursToDate(4);
        String newCurrentDate = commonUtilities.completeDateFormat(driver , newDate);       
        
        
		String newFutureDate = commonUtilities.completeDateFormat(driver , futureDate);
		
		
		

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://192.9.200.201:3306/pandora?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"apillai", "OKzOHKu0R5HGv3nL");

		Statement stmt = conn.createStatement();
		
		//String query = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cash Receipts Report' order by rowid desc LIMIT 1";

		String query = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cash Receipts Report' order by rowid desc LIMIT 1";


		//String query = "select type_rscd, tz_rscd , period_rscd , name_rscd from report_schedule where name_rscd = 'Cash Receipts Report' order by rowid desc LIMIT 1";

		ResultSet rs = stmt.executeQuery(query);

		boolean status = false;

		while (rs.next()) {

			String frequency = rs.getString("type_rscd"); 
			String timeZone = rs.getString("tz_rscd");
			String period = rs.getString("period_rscd");
			String name = rs.getString("name_rscd");
			String startDate = rs.getString("start_rscd");
			String endDate = rs.getString("end_rscd");

			
			 
			 


			if (report_frequency.equals(frequency) && report_timeZone.equals(timeZone) && report_period.equals(period)
					&& report_name.equals(name) && newCurrentDate.equals(startDate) && newFutureDate.equals(endDate) ) {

				System.out.println(" Record Found In Table ");
				status = true;
				break;
			

			}

		}

		if (status == false) {

			System.out.println("Record not found in table");

		}
		
		Assert.assertTrue(status, "Record Not Found In Table");

		conn.close();


	}
	
	public void getCashReceiptsReportScheduler3() throws SQLException {

		WebDriverWait wait = new WebDriverWait(driver, 40);

		wait.until(ExpectedConditions.textToBePresentInElement(scheduleText, "Scheduler"));

		Assert.assertTrue(scheduleText.isDisplayed());
		
		String frequencyText = "DAILY";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, frequencyText);

		commonUtilities.scrollIntoView(driver, runTime);

		runTime.click();
		
		String runTimeText = "04:00 AM";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, runTimeText);

		String currnetDate = commonUtilities.selectCurrentDate();
		reportStartDate.sendKeys(currnetDate);

		//System.out.println(reportStartDate.getText());
		
		int days = 35;

		String futureDate = commonUtilities.selectFutureDate(days);
		reportEndtDate.sendKeys(futureDate);

		//commonUtilities.scrollIntoView(driver, nextButtonOfDetails);

		nextButtonOfDetails.click();

		commonUtilities.scrollIntoView(driver, periodDropdown);

		periodDropdown.click();

		// commonUtilities.scrollIntoView(periodDropdown);
		
		String periodText = "Business month to date";

		commonUtilities.selectValuesFromScheduleReportDropdown(driver, periodText);

		nextButtonOfParameters.click();

		commonUtilities.scrollIntoView(driver, reportFormatDropdown);

		reportFormatDropdown.click();
		
		commonUtilities.selectReportFormat(driver, "CSV");
		
		String emailIdText = "arunkumarpi@cyabge.com";

		emailRecipientsInputBox.sendKeys(emailIdText);

		commonUtilities.scrollIntoView(driver, submitButton);

		submitButton.click();

		driver.switchTo().defaultContent();

		wait.until(
				ExpectedConditions.textToBePresentInElement(scheduledReportMessage, "Report Scheduled successfully"));
		
		String report_frequency = "BIZ_WEEKLY";
		String report_timeZone = "Asia/Calcutta";
		String report_period = "BIZ_MTD";
		String report_name = "Cash Receipts Report";
		
        //String newCurrentDate = commonUtilities.completeDateFormat(driver , currnetDate);
        
        
        String newDate = commonUtilities.addHoursToDate(4);
        String newCurrentDate = commonUtilities.completeDateFormat(driver , newDate);      
        
        
		String newFutureDate = commonUtilities.completeDateFormat(driver , futureDate);
		
		
		
		
		String queryString = "select type_rscd, tz_rscd , period_rscd , name_rscd , start_rscd , end_rscd from report_schedule where name_rscd = 'Cash Receipts Report' order by rowid desc LIMIT 1";

		
		commonUtilities.databaseRecordVerification(driver , queryString, report_frequency ,report_timeZone , report_period , report_name , newCurrentDate ,newFutureDate);

	

	}



}
