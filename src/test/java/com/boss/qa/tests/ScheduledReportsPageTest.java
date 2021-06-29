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

public class ScheduledReportsPageTest extends BaseTest {

	/*@BeforeClass
	public void cloud9ReportSetup() {

		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}*/

	@Test (priority = 1 ,enabled = true)
	public void verifyDepartmentListReportParameterFromScheduledReportPageWithNoDatesPeriodTest() throws SQLException {

		reportSchedule = homePage.getDepartmentListReportSchedule();

		reportSchedule.getDepartmentLsitReportScheduler();
		
		scheduledReportsPage.getDepartmentListReportParameterFromScheduledReportPageWithNoDatesPeriod();
		
		//reportSchedule.getCloud9POSEmpProductivityReportScheduler();
		
       /* Assert.assertTrue(reportSchedule.getReportSuccessMessage(),"Report Scheduled successfully message not displayed");
		
        String actualMessage = reportSchedule.getReportSuccessMessageText();
		
		String expectedMessage = "Report Scheduled successfully";
		
		Assert.assertEquals(actualMessage, expectedMessage ,"Report Scheduled successfully text not matched ");*/
		
 
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
