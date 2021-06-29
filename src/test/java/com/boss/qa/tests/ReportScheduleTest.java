package com.boss.qa.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.boss.qa.base.BaseTest;
import com.boss.qa.utils.CommonUtilities;
import com.boss.qa.utils.Constants;

public class ReportScheduleTest extends BaseTest {

	/*@BeforeClass
	public void cloud9ReportSetup() {

		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}*/

	@Test (priority = 1 ,enabled = true)
	public void verifyReportSchedulerForCloud9POSEmpProductivityReportWithFrequencyWeeklyAndPeriodBWTDTest()
			throws SQLException {

		reportSchedule = homePage.getCloud9ReportSchedule();

		reportSchedule.getCloud9POSEmpProductivityReportSchedulerWithFrequencyWeeklyAndPeriodBWTD();
		
		//reportSchedule.getCloud9POSEmpProductivityReportScheduler();
		
        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");
		
 
	}
	
	@Test (priority = 2 ,enabled = true)
	public void verifyReportSchedulerForCloud9POSEmpProductivityReportWithFrequencyMonthlyAndPeriodBMTDTest()
			throws SQLException {

		reportSchedule = homePage.getCloud9ReportSchedule();

		reportSchedule.getCloud9POSEmpProductivityReportSchedulerWithFrequencyMonthlyAndPeriodBMTD();
		
        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");
		
 
	}
	
	@Test (priority = 3 ,enabled = true)
	public void verifyReportSchedulerForCloud9POSEmpProductivityReportWithFrequencyQuarterlyAndPeriodBQTDTest()
			throws SQLException {

		reportSchedule = homePage.getCloud9ReportSchedule();
		

		reportSchedule.getCloud9POSEmpProductivityReportSchedulerWithFrequencyQuarterlyAndPeriodBQTD();
		
        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");
		
 
	}
	
	@Test (priority = 4 ,enabled = true)
	public void verifyReportSchedulerForCloud9POSEmpProductivityReportWithFrequencyYearlyAndPeriodBYTDTest()
			throws SQLException {

		reportSchedule = homePage.getCloud9ReportSchedule();

		reportSchedule.getCloud9POSEmpProductivityReportSchedulerWithFrequencyYearlyAndPeriodBYTD();
		
        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");		
 
	}


	@Test (priority = 5 , enabled = true)
	public void verifyReportSchedulerForCashReceiptsReportWithFrequencyWeeklyAndPeriodPBWTestTest() throws SQLException {

		reportSchedule = homePage.getCashReceiptsReport();
		
		reportSchedule.getCashReceiptReportSchedulerWithFrequencyWeeklyAndPeriodPBW();

        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");
		
	}
	
	@Test (priority = 6 , enabled = true)
	public void verifyReportSchedulerForCashReceiptsReportWithFrequencyMonthlyAndPeriodPBMTestTest() throws SQLException {

		reportSchedule = homePage.getCashReceiptsReport();
		
		reportSchedule.getCashReceiptReportSchedulerWithFrequencyMonthlyAndPeriodPBM();

        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");
		
	}

	
	@Test (priority = 7 , enabled = true)
	public void verifyReportSchedulerForCashReceiptsReportWithFrequencyQuarterlyAndPeriodPBQTestTest() throws SQLException {

		reportSchedule = homePage.getCashReceiptsReport();
		
		reportSchedule.getCashReceiptReportSchedulerWithFrequencyQuarterlyAndPeriodPBQ();

        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");
		
	}
	
	@Test (priority = 8 , enabled = true)
	public void verifyReportSchedulerForCashReceiptsReportWithFrequencyYearlyAndPeriodPBYTestTest() throws SQLException {

		reportSchedule = homePage.getCashReceiptsReport();
		
		reportSchedule.getCashReceiptReportSchedulerWithFrequencyYearlyAndPeriodPBY();

        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");
		
	}
	
	@Test (priority = 9 ,enabled = true)
	public void verifyReportSchedulerForCloud9POSEmpProductivityReportWithFiscalCalendarFrequencyOnceAndPeriodDateOfFireTodayTest()
			throws SQLException {

		reportSchedule = homePage.getCloud9ReportSchedule();

		reportSchedule.getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyOnceAndPeriodDateOfFireToday();
		
		//reportSchedule.getCloud9POSEmpProductivityReportScheduler();
		
        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");
		
 
	}
	
	@Test (priority = 10 ,enabled = true)
	public void verifyReportSchedulerForCloud9POSEmpProductivityReportWithFiscalCalendarFrequencyDailyAndPeriodYesterdayTest()
			throws SQLException {

		reportSchedule = homePage.getCloud9ReportSchedule();

		reportSchedule.getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyDailyAndPeriodYesterday();
		
		//reportSchedule.getCloud9POSEmpProductivityReportScheduler();
		
        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");
		
 
	}
	
	@Test (priority = 11 ,enabled = true)
	public void verifyReportSchedulerForCloud9POSEmpProductivityReportWithFiscalCalendarFrequencyWeeklyAndPeriodFixedTest()
			throws SQLException {

		reportSchedule = homePage.getCloud9ReportSchedule();

		reportSchedule.getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyWeeklyAndPeriodFixed();
		
		//reportSchedule.getCloud9POSEmpProductivityReportScheduler();
		
        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");
		
 
	}

	@Test (priority = 12 ,enabled = true)
	public void verifyReportSchedulerForCloud9POSEmpProductivityReportWithFiscalCalendarFrequencyMonthlyAndPeriodLastXDaysInclusiveofTodayTest()
			throws SQLException {

		reportSchedule = homePage.getCloud9ReportSchedule();

		reportSchedule.getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyMonthlyAndPeriodLastXDaysInclusiveofToday();
		
		//reportSchedule.getCloud9POSEmpProductivityReportScheduler();
		
        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");
		
 
	}
	
	@Test (priority = 13 ,enabled = true)
	public void verifyReportSchedulerForCloud9POSEmpProductivityReportWithFiscalCalendarFrequencyMonthlyAndPeriodLastXDaysExclusiveofTodayTest()
			throws SQLException {

		reportSchedule = homePage.getCloud9ReportSchedule();

		reportSchedule.getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyMonthlyAndPeriodLastXDaysExclusiveofToday();
		
		//reportSchedule.getCloud9POSEmpProductivityReportScheduler();
		
        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");
		
 
	}

	@Test (priority = 14 ,enabled = true)
	public void verifyReportSchedulerForCloud9POSEmpProductivityReportWithFiscalCalendarFrequencyDailyAndPeriodLastWeekTest()
			throws SQLException {

		reportSchedule = homePage.getCloud9ReportSchedule();

		reportSchedule.getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyDailyAndPeriodLastWeek();
		
		//reportSchedule.getCloud9POSEmpProductivityReportScheduler();
		
        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");
		
 
	}
	
	@Test (priority = 15 ,enabled = true)
	public void verifyReportSchedulerForCloud9POSEmpProductivityReportWithFiscalCalendarFrequencyWeeklyAndPeriodLastMonthTest()
			throws SQLException {

		reportSchedule = homePage.getCloud9ReportSchedule();

		reportSchedule.getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyWeeklyAndPeriodLastMonth();
		
		//reportSchedule.getCloud9POSEmpProductivityReportScheduler();
		
        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");
		
 
	}

	@Test (priority = 16 ,enabled = true)
	public void verifyReportSchedulerForCloud9POSEmpProductivityReportWithFiscalCalendarFrequencyMonthlyAndPeriodLastQuarterTest()
			throws SQLException {

		reportSchedule = homePage.getCloud9ReportSchedule();

		reportSchedule.getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyMonthlyAndPeriodLastQuarter();
		
		//reportSchedule.getCloud9POSEmpProductivityReportScheduler();
		
        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");
		
 
	}

	@Test (priority = 17 ,enabled = true)
	public void verifyReportSchedulerForCloud9POSEmpProductivityReportWithFiscalCalendarFrequencyMonthlyAndPeriodLastYearTest()
			throws SQLException {

		reportSchedule = homePage.getCloud9ReportSchedule();

		reportSchedule.getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyMonthlyAndPeriodLastYear();
		
		//reportSchedule.getCloud9POSEmpProductivityReportScheduler();
		
        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");
		
 
	}

	@Test (priority = 18 ,enabled = true)
	public void verifyReportSchedulerForCloud9POSEmpProductivityReportWithFiscalCalendarFrequencyOnceAndPeriodCurrentWeekTest()
			throws SQLException {

		reportSchedule = homePage.getCloud9ReportSchedule();

		reportSchedule.getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyOnceAndPeriodCurrentWeek();
		
		//reportSchedule.getCloud9POSEmpProductivityReportScheduler();
		
        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");
		
 
	}
	
	@Test (priority = 19 ,enabled = true)
	public void verifyReportSchedulerForCloud9POSEmpProductivityReportWithFiscalCalendarFrequencyDailyAndPeriodCurrentMonthTest()
			throws SQLException {

		reportSchedule = homePage.getCloud9ReportSchedule();

		reportSchedule.getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyDailyAndPeriodCurrentMonth();
		
		//reportSchedule.getCloud9POSEmpProductivityReportScheduler();
		
        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");
		
 
	}
	
	@Test (priority = 20 ,enabled = true)
	public void verifyReportSchedulerForCloud9POSEmpProductivityReportWithFiscalCalendarFrequencyWeeklyAndPeriodCurrentQuarterTest()
			throws SQLException {

		reportSchedule = homePage.getCloud9ReportSchedule();

		reportSchedule.getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyWeeklyAndPeriodCurrentQuarter();
		
		//reportSchedule.getCloud9POSEmpProductivityReportScheduler();
		
        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");
		
 
	}

	@Test (priority = 21 ,enabled = true)
	public void verifyReportSchedulerForCloud9POSEmpProductivityReportWithFiscalCalendarFrequencyMonthlyAndPeriodCurrentYearTest()
			throws SQLException {

		reportSchedule = homePage.getCloud9ReportSchedule();

		reportSchedule.getCloud9POSEmpProductivityReportSchedulerWithFiscalCalendarFrequencyMonthlyAndPeriodCurrentYear();
		
		//reportSchedule.getCloud9POSEmpProductivityReportScheduler();
		
        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");
		
 
	}


	
	@Test (priority = 22 ,enabled = true)
	public void verifyBlankReportNameErrorMessageTest() {

		reportSchedule = homePage.getCashReceiptsReport();

		reportSchedule.getCashReceiptReportSchedulerWithBlankReportNameErrorVerification();
		
		Assert.assertTrue(reportSchedule.verifyBlankReportNameErrorMessageDisplayed(), "Blank Report Name Error Message Not Displayed");
		
		String actualMessage = reportSchedule.getBlankReportNameErrorMessage();
		
		String expectedMessage = "Report Name is required";	
	
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Name Error Message Not Matched");
	}
	
	@Test (priority = 23 ,enabled = true)
	public void verifyBlankStartDateErrorMessageTest() {

		reportSchedule = homePage.getCashReceiptsReport();

		reportSchedule.getCashReceiptReportSchedulerWithBlankStartDateErrorVerification();
		
		Assert.assertTrue(reportSchedule.verifyBlankStartDateErrorMessageDisplayed(), "Blank Start Date Error Message Not Displayed");
		
		String actualMessage = reportSchedule.getBlankStartDateErrorMessage();
		
		String expectedMessage = "Start Date is required";	
	
		Assert.assertEquals(actualMessage, expectedMessage ,"Start Date is required Error Message Not Matched");
	}
	
	@Test (priority = 24 ,enabled = true)
	public void verifyPastStartDateErrorMessageTest() {

		reportSchedule = homePage.getCashReceiptsReport();

		reportSchedule.getCashReceiptReportSchedulerWithPastStartDateErrorVerification();
		
		Assert.assertTrue(reportSchedule.verifyPastStartDateErrorMessageDisplayed(), "Past Start Date Error Message Not Displayed");
		
		String actualMessage = reportSchedule.getPastStartDateErrorMessage();
		
		String expectedMessage = "Start Date cannot be past";	
	
		Assert.assertEquals(actualMessage, expectedMessage ,"Start Date cannot be past Error Message Not Matched");
	}
	
	@Test (priority = 25 ,enabled = true)
	public void verifyEndDateBeforeStartDateErrorMessageTest() {

		reportSchedule = homePage.getCashReceiptsReport();

		reportSchedule.getCashReceiptReportSchedulerWithEndDateBeforeStartDateErrorVerification();
		
		Assert.assertTrue(reportSchedule.verifyEndDateBeforeStartDateErrorMessageDisplayed(), "End Date Before Start Date Error Message Not Displayed");
		
		String actualMessage = reportSchedule.getEndDateBeforeStartDateErrorMessage();
		
		String expectedMessage = "End Date should be after Start date";	
	
		Assert.assertEquals(actualMessage, expectedMessage ,"End Date Before Start Date Error Message Not Matched");
	}
	
	@Test (priority = 26 ,enabled = true)
	public void verifyBlankEmailSubjectFieldErrorMessageTest() {

		reportSchedule = homePage.getCashReceiptsReport();

		reportSchedule.getCashReceiptReportSchedulerWithBlankEmailSubjectFieldErrorVerification();
		
		Assert.assertTrue(reportSchedule.verifyBlankEmailSubjectErrorMessageDisplayed(), "Email Subject is required Error Message Not Displayed");
		
		String actualMessage = reportSchedule.getBlankEmailSubjectErrorMessage();
		
		String expectedMessage = "Email Subject is required";	
	
		Assert.assertEquals(actualMessage, expectedMessage ,"Email Subject is required Error Message Not Matched");
	}
	
	@Test (priority = 27 ,enabled = true)
	public void verifyBlankEmailBodyFieldErrorMessageTest() {

		reportSchedule = homePage.getCashReceiptsReport();

		reportSchedule.getCashReceiptReportSchedulerWithBlankEmailBodyFieldErrorVerification();
		
		Assert.assertTrue(reportSchedule.verifyBlankEmailBodyErrorMessageDisplayed(), "Email Body is required Error Message Not Displayed");
		
		String actualMessage = reportSchedule.getBlankEmailBodyErrorMessage();
		
		String expectedMessage = "Email Body is required";	
	
		Assert.assertEquals(actualMessage, expectedMessage ,"Email Body is required Error Message Not Matched");
	}
	
	@Test (priority = 28 ,enabled = true)
	public void verifyBlankEmailRecipientsFieldErrorMessageTest() {

		reportSchedule = homePage.getCashReceiptsReport();

		reportSchedule.getCashReceiptReportSchedulerWithBlankEmailRecipientsFieldErrorVerification();
		
		Assert.assertTrue(reportSchedule.verifyBlankEmailRecipientsErrorMessageDisplayed(), "One of the following is required: Email Recipients, Email Group, or Store Error Message Not Displayed");
		
		String actualMessage = reportSchedule.getBlankEmailRecipientsErrorMessage();
		
		String expectedMessage = "One of the following is required: Email Recipients, Email Group, or Store";	
	
		Assert.assertEquals(actualMessage, expectedMessage ,"One of the following is required: Email Recipients, Email Group, or Store Error Message Not Matched");
	}
	
	@Test (priority = 29 ,enabled = true)
	public void verifyInvalidEmailRecipientsErrorMessageTest() {

		reportSchedule = homePage.getCashReceiptsReport();

		reportSchedule.getCashReceiptReportSchedulerWithInvalidEmailRecipientsErrorVerification();
		
		Assert.assertTrue(reportSchedule.verifInvalidEmailRecipientsErrorMessageDisplayed(), "Invalid Email Address: arunkumarpi@cybage Error Message Not Displayed");
		
		String actualMessage = reportSchedule.getInvalidEmailRecipientsErrorMessage();
		
		String expectedMessage = "Invalid Email Address: arunkumarpi@cyabge";	
			
		Assert.assertEquals(actualMessage, expectedMessage ,"Invalid Email Address: arunkumarpi@cybage Error Message Not Matched");
		
	}
	
	@Test (priority = 30 ,enabled = true)
	public void verifyFiscalCalendarBlankReportRunDateErrorMessageTest() {

		reportSchedule = homePage.getCashReceiptsReport();

		reportSchedule.getCashReceiptReportSchedulerWithFiscalCalendarBlankReportRunDateErrorVerification();
		
		Assert.assertTrue(reportSchedule.verifyFiscalCalendarReportBlankRunDateErrorMessageDisplayed(), "Run Date is required Error Message Not Displayed");
		
		String actualMessage = reportSchedule.getFiscalCalendarReportBlankRunDateErrorMessage();
		
		String expectedMessage = "Run Date is required";	
			
		Assert.assertEquals(actualMessage, expectedMessage ,"Run Date is required Error Message Not Matched");
		
	}
	
	@Test (priority = 31 ,enabled = true)
	public void verifyFiscalCalendarPastReportRunDateErrorMessageTest() {

		reportSchedule = homePage.getCashReceiptsReport();

		reportSchedule.getCashReceiptReportSchedulerWithFiscalCalendarPastReportRunDateErrorVerification();
		
		Assert.assertTrue(reportSchedule.verifyFiscalCalendarReportPastRunDateErrorMessageDisplayed(), "Report Run Date/Time must be future Error Message Not Displayed");
		
		String actualMessage = reportSchedule.getFiscalCalendarReportPastRunDateErrorMessage();
		
		String expectedMessage = "Report Run Date/Time must be future";	
			
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Run Date/Time must be future Error Message Not Matched");
		
	}
	
	@Test (priority = 32 ,enabled = true)
	public void verifyReportBlankPeriodErrorMessageTest() {

		reportSchedule = homePage.getCashReceiptsReport();

		reportSchedule.getCashReceiptReportSchedulerWithBlankPeriodErrorVerification();
		
		Assert.assertTrue(reportSchedule.verifyBlankPeriodErrorMessageDisplayed(), "Report Period is required Error Message Not Displayed");
		
		String actualMessage = reportSchedule.getBlankPeriodErrorMessage();
		
		String expectedMessage = "Report Period is required";	
			
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Period is required Error Message Not Matched");
		
	}
	
	@Test (priority = 33 ,enabled = true)
	public void verifyReportBlankReportFormatErrorMessageTest() {

		reportSchedule = homePage.getCashReceiptsReport();

		reportSchedule.getCashReceiptReportSchedulerWithBlankReportFormatErrorVerification();
		
		Assert.assertTrue(reportSchedule.verifyBlankReportFormatErrorMessageDisplayed(), "Report Format is required Error Message Not Displayed");
		
		String actualMessage = reportSchedule.getBlankReportFormatErrorMessage();
		
		String expectedMessage = "Report Format is required";
			
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Format is required Error Message Not Matched");
		
	}
	
	@Test (priority = 34 ,enabled = true)
	public void verifyBlankTimeZoneErrorMessageTest() {

		reportSchedule = homePage.getCashReceiptsReport();

		reportSchedule.getCashReceiptReportSchedulerWithBlankTimeZoneErrorVerification();
		
		/*Assert.assertTrue(reportSchedule.verifyBlankTimeZoneErrorMessageDisplayed(), "Time Zone is required Error Message Not Displayed");
		
		String actualMessage = reportSchedule.getBlankTimeZoneErrorMessage();
		
		String expectedMessage = "Time Zone is required";	
	
		Assert.assertEquals(actualMessage, expectedMessage ,"Time Zone is required Error Message Not Matched");*/
	}
	
	@Test (priority = 35 ,enabled = true)
	public void verifyReportSchedulerForDepartmentListReportTest() throws SQLException {

		reportSchedule = homePage.getDepartmentListReportSchedule();

		reportSchedule.getDepartmentLsitReportScheduler();
		
		//reportSchedule.getCloud9POSEmpProductivityReportScheduler();
		
        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");
		
 
	}
	
	@Test (priority = 36 ,enabled = true)
	public void verifyReportSchedulerForCloud9POSEmpProductivityReportUpdateTest()
			throws SQLException {

		reportSchedule = homePage.getCloud9ReportSchedule();

		reportSchedule.getCloud9POSEmpProductivityReportSchedulerUpdateFunctionality();
		
        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Schedule updated successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Schedule updated successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Schedule updated successfully text not matched ");		
 
	}
	
	@Test (priority = 37 ,enabled = true)
	public void verifyReportSchedulerForCloud9POSEmpProductivityReportUpdateTimeZoneTest()
			throws SQLException {

		reportSchedule = homePage.getCloud9ReportSchedule();

		reportSchedule.getCloud9POSEmpProductivityReportSchedulerUpdateTimeZoneFunctionality();
		
        Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Schedule updated successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Schedule updated successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Schedule updated successfully text not matched ");		
 
	}
	
	
//*******************************************Scheduled Report Page Module Cases***********************************************************************************************
	
	@Test (priority = 38 ,enabled = true)
	public void verifyDepartmentListReportParameterFromScheduledReportPageWithNoDatesPeriodTest() throws SQLException {

		reportSchedule = homePage.getDepartmentListReportSchedule();

		reportSchedule.getDepartmentListReportParameterFromScheduledReportPageWithNoDatesPeriod();
		
	}
	
	@Test (priority = 39 ,enabled = true)
	public void verifyCondensedFlashReportParameterFromScheduledReportPageWithOneDatesPeriodTest() throws SQLException {

		reportSchedule = homePage.getCondensedFlashReportSchedule();

		reportSchedule.getCondensedFlashReportParameterFromScheduledReportPageWithOneDatesPeriod();
		
 
	}

	@Test (priority = 40 ,enabled = true)
	public void verifyInvMovementStyleColorArtiReportParameterFromScheduledReportPageWithTwoDatesPeriodTest() throws SQLException {

		reportSchedule = homePage.getInvMovementStyleColorArtiReportSchedule();

		reportSchedule.getInvMovementStyleColorArtiReportParameterFromScheduledReportPageWithTwoDatesPeriod();
 
	}
	
	@Test (priority = 41 ,enabled = true)
	public void verifyReportScheduledForCashReceiptsReportUpdateTest() throws SQLException {

		reportSchedule = homePage.getCashReceiptsReport();

		reportSchedule.getCashReceiptsReportSchedulerUpdate();
		
	}
	
	@Test (priority = 42 ,enabled = true)
	public void verifyReportScheduledSearchByReportNameTest() throws SQLException {

		reportSchedule = homePage.getScheduledReportsPage();
		
		String reportName = "Cash Receipts Report";

		reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportName(reportName);

	}
	
	
	@Test (priority = 43 ,enabled = true)
	public void verifyReportScheduledSpecificSearchByReportOwnerTest() throws SQLException {

		reportSchedule = homePage.getScheduledReportsPage();
		
		String reportName = "Cloud 9 POS Emp Productivity";

		String reportOwnerName = "pa3jas";
		
		String reportPeriod = "MONTHLY";
		
		String reportStatus = "Active";
		
		reportSchedule.scheduledReportsPageSpecificSearchFunctioanlityBasedOnReportOwner(reportName,reportOwnerName, reportPeriod,reportStatus);

	}
	
	@Test (priority = 44 ,enabled = true)
	public void verifyReportScheduledAllReportSearchByReportOwnerTest() throws SQLException {

		reportSchedule = homePage.getScheduledReportsPage();
		
		String reportOwnerName = "pa3jas";
	
		reportSchedule.scheduledReportsPageAllReportSearchFunctioanlityBasedOnReportOwner(reportOwnerName);

	}
//////////////////////
	@Test (priority = 44 ,enabled = true)
	public void verifyReportScheduledSearchByPeriodOnceTest() throws SQLException {

		reportSchedule = homePage.getScheduledReportsPage();

		String reportPeriod = "ONCE";
		
		reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnPeriod(reportPeriod);

	}
	
	@Test (priority = 45 ,enabled = true)
	public void verifyReportScheduledSearchByPeriodDailyTest() throws SQLException {

		reportSchedule = homePage.getScheduledReportsPage();

		String reportPeriod = "DAILY";
		
		reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnPeriod(reportPeriod);

	}
	
	@Test (priority = 46 ,enabled = true)
	public void verifyReportScheduledSearchByPeriodWeeklyTest() throws SQLException {

		reportSchedule = homePage.getScheduledReportsPage();

		String reportPeriod = "WEEKLY";
		
		reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnPeriod(reportPeriod);

	}
	
	@Test (priority = 47 ,enabled = true)
	public void verifyReportScheduledSearchByPeriodMonthlyTest() throws SQLException {

		reportSchedule = homePage.getScheduledReportsPage();

		String reportPeriod = "MONTHLY";
		
		reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnPeriod(reportPeriod);

	}
	
	@Test (priority = 48 ,enabled = true)
	public void verifyReportScheduledSearchByPeriodQuarterlyTest() throws SQLException {

		reportSchedule = homePage.getScheduledReportsPage();

		String reportPeriod = "QUARTERLY";
		
		reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnPeriod(reportPeriod);

	}
	
	@Test (priority = 49 ,enabled = true)
	public void verifyReportScheduledSearchByPeriodYearlyTest() throws SQLException {

		reportSchedule = homePage.getScheduledReportsPage();

		String reportPeriod = "YEARLY";
		
		reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnPeriod(reportPeriod);

	}

	@Test 
	public void verifyReportScheduledSearchByActiveStatusTest() throws SQLException {

		reportSchedule = homePage.getScheduledReportsPage();

		String reportScheduleStatus = "Active";
		
		reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportScheduleStatus(reportScheduleStatus);

	}
	
	@Test 
	public void verifyReportScheduledSearchByCancelledStatusTest() throws SQLException {

		reportSchedule = homePage.getScheduledReportsPage();

		String reportScheduleStatus = "Cancelled";
		
		reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportScheduleStatus(reportScheduleStatus);

	}
	
	@Test 
	public void verifyReportScheduledSearchBySuspendedStatusTest() throws SQLException {

		reportSchedule = homePage.getScheduledReportsPage();

		String reportScheduleStatus = "Suspended";
		
		reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportScheduleStatus(reportScheduleStatus);

	}
	
	@Test 
	public void verifyReportSchedulerForCancelActiveReportTest() throws SQLException {
		
		reportSchedule = homePage.getScheduledReportsPage();
		
		String reportName = "Cloud 9 POS Emp Productivity";

		//reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportName(reportName);

		String reportScheduleStatus = "Active";

		//reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportScheduleStatus(reportScheduleStatus);
		
		reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportNameAndStatus(reportName,reportScheduleStatus);

		reportSchedule.getCancelReportFunctionality();
		
	}
	
	@Test 
	public void verifyReportSchedulerForSuspendActiveReportTest() throws SQLException {
		
		reportSchedule = homePage.getScheduledReportsPage();
		
		String reportName = "Cloud 9 POS Emp Productivity";

		//reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportName(reportName);

		String reportScheduleStatus = "Active";

		//reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportScheduleStatus(reportScheduleStatus);
		
		reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportNameAndStatus(reportName,reportScheduleStatus);
		
		reportSchedule.getSuspendReportFunctionality();
		
	}
	
	
	@Test 
	public void verifyReportSchedulerForCancelSuspendedReportTest() throws SQLException {
		
		reportSchedule = homePage.getScheduledReportsPage();
		
		String reportNameOld = "Cloud 9 POS Emp Productivity";

		String reportScheduleStatusOld = "Active";
		
		reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportNameAndStatus(reportNameOld,reportScheduleStatusOld);

		reportSchedule.getSuspendReportBasicFunctionality();
		
		String reportName = "Cloud 9 POS Emp Productivity";

		//reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportName(reportName);

		String reportScheduleStatus = "Suspended";

		//reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportScheduleStatus(reportScheduleStatus);
		
		reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportNameAndStatus(reportName,reportScheduleStatus);

		reportSchedule.getCancelSuspendedReportFunctionality();
		
	}
	
	@Test 
	public void verifyReportSchedulerForReactivateSuspendedReportTest() throws SQLException {
		
        reportSchedule = homePage.getScheduledReportsPage();
		
		String reportNameOld = "Cloud 9 POS Emp Productivity";

		String reportScheduleStatusOld = "Active";
		
		reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportNameAndStatus(reportNameOld,reportScheduleStatusOld);

		reportSchedule.getSuspendReportBasicFunctionality();
		
		String reportName = "Cloud 9 POS Emp Productivity";

		//reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportName(reportName);

		String reportScheduleStatus = "Suspended";

		//reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportScheduleStatus(reportScheduleStatus);
		
		reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportNameAndStatus(reportName,reportScheduleStatus);
		
		reportSchedule.getReactivateSuspendedReportFunctionality();
		
	}
	
	@Test 
	public void verifyReportSchedulerForReassignSingleReportTest() throws SQLException {
		
        reportSchedule = homePage.getScheduledReportsPage();
		
		String reportName = "Cloud 9 POS Emp Productivity";

		String reportScheduleStatus = "Active";
		
		reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportNameAndStatus(reportName,reportScheduleStatus);

		reportSchedule.getReassignSingleReportFunctionality();
		
	}
	
	@Test 
	public void verifyReportSchedulerForReassignMultipleReportTest() throws SQLException {
		
        reportSchedule = homePage.getScheduledReportsPage();
		
		String reportName = "Cloud 9 POS Emp Productivity";

		String reportScheduleStatus = "Active";
		
		String reportScheduleStatusTwo = "Suspended";
		
		reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportNameAndTwoStatus(reportName,reportScheduleStatus,reportScheduleStatusTwo);

		reportSchedule.getReassignMultipleReportFunctionality();
		
	}
	
	@Test 
	public void verifyReportSchedulerForResetButtonTest() throws SQLException {
		
        reportSchedule = homePage.getScheduledReportsPage();
		
		String reportName = "Cash Receipts Report";
		
        String reportPeriod = "WEEKLY";
		
		//reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnPeriod(reportPeriod);
		
		reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportNameAndPeriod(reportName,reportPeriod);
		
		reportSchedule.getResetButtonFunctionality();
		
	}
	
	@Test 
	public void verifyReportSchedulerForPaginationTest() throws SQLException {
		
        reportSchedule = homePage.getScheduledReportsPage();
		
		/*String reportName = "Cash Receipts Report";
		
        String reportPeriod = "WEEKLY";
		
		//reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnPeriod(reportPeriod);
		
		reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportNameAndPeriod(reportName,reportPeriod);
		*/
		reportSchedule.getScheduledReportsPaginationFunctionality();
		
	}
	
	@Test 
	public void verifyReportSchedulerForHelpTest() throws SQLException {
		
        reportSchedule = homePage.getScheduledReportsPage();
		
		/*String reportName = "Cash Receipts Report";
		
        String reportPeriod = "WEEKLY";
		
		//reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnPeriod(reportPeriod);
		
		reportSchedule.scheduledReportsPageSearchFunctioanlityBasedOnReportNameAndPeriod(reportName,reportPeriod);
		*/
		reportSchedule.getScheduledReportsHelpFunctionality();
	}
	
	@Test 
	public void verifyReportScheduledSpecificSearchByAdminTest() throws SQLException {

		reportSchedule = homePage.getScheduledReportsPage();
		
		String reportName = "Cloud 9 POS Emp Productivity";

		String reportOwnerName = "pa3jas";
		
		String reportPeriod = "MONTHLY";
		
		String reportStatus = "Active";
		
		reportSchedule.scheduledReportsPageSpecificSearchFunctioanlityBasedOnReportOwner(reportName,reportOwnerName, reportPeriod,reportStatus);

	}
	
	@Test 
	public void verifyReportScheduledAllReportSearchByAdminTest() throws SQLException {

		reportSchedule = homePage.getScheduledReportsPage();
		
		String reportOwnerName = "pa3jas";
	
		reportSchedule.scheduledReportsPageAllReportSearchFunctioanlityBasedOnReportOwner(reportOwnerName);

	}

	@Test (enabled = false)
	public void verifyReportSchedulerForCashReceiptsReportTest2() throws SQLException {

		reportSchedule = homePage.getCashReceiptsReport();

		reportSchedule.getCashReceiptsReportScheduler2();
		
		Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");

	}
	
	

}
