package com.boss.qa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.boss.qa.base.BasePage;

public class CommonUtilities extends BasePage {

	public WebDriver driver;

	public CommonUtilities(WebDriver driver) {
		this.driver = driver;
	}

	public void selectValueFromDropDown(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public String selectCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
		Date today = Calendar.getInstance().getTime();
		String date = dateFormat.format(today);
		return date;

	}
	
	public String selectTomorrowDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");  
		Calendar cal = Calendar.getInstance();    
		//cal.setTime( dateFormat.parse(untildate));    
		cal.add( Calendar.DATE, 1 );    
		String tomorrowDate=dateFormat.format(cal.getTime());  
		return tomorrowDate;

	}
	
	public String selectPastDate(int number) {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");  
		Calendar cal = Calendar.getInstance();    
		cal.add( Calendar.DATE, number );    
		String yesterdayDate=dateFormat.format(cal.getTime());  
		return yesterdayDate;

	}

	public String selectFutureDate(int days) {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, days);
		String newDate = dateFormat.format(cal.getTime());
		return newDate;

	}

	public void scrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	
	public void clickElementByJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);

	}

	public void selectValuesFromScheduleReportDropdown(WebDriver driver, String value) {

		List<WebElement> choicelist = driver
				.findElements(By.xpath("//ul[@class='select2-results__options']/li[@class='select2-results__option']"));

		for (int i = 0; i < choicelist.size(); i++) {

			String text = choicelist.get(i).getText();

			if (text.equals(value)) {
				choicelist.get(i).click();
				break;
			}
		}
	}

	public void selectValuesFromScheduleReportDropdownForDepartmentListPeriod(WebDriver driver, String value) {

		List<WebElement> choicelist = driver
				.findElements(By.xpath("//ul[@class='select2-results__options']/li[@class='select2-results__option select2-results__option--highlighted']"));

		for (int i = 0; i < choicelist.size(); i++) {

			String text = choicelist.get(i).getText();

			if (text.equals(value)) {
				choicelist.get(i).click();
				break;
			}
		}
	}
	public void selectStoreValues(WebDriver driver, String value) {

		List<WebElement> storeOption = driver
				.findElements(By.xpath("//div[@class='selectize-dropdown-content']/div[@class='option']"));

		for (WebElement option : storeOption) {

			if (option.getText().equalsIgnoreCase(value)) {
				option.click();
				break;
			}

		}

	}
	
	/*public void selectStoreValues(WebDriver driver) {

		driver.findElement(By.xpath("//div[@class='selectize-dropdown-content']/div[@class='option'][1]")).click();
	}*/
	
	

	public void selectEmailGroupValues(WebDriver driver, String value) {

		List<WebElement> storeOption = driver
				.findElements(By.xpath("//div[@class='selectize-dropdown-content']/div[@class='option']"));

		for (WebElement option : storeOption) {

			if (option.getText().equalsIgnoreCase(value)) {
				option.click();
				break;
			}

		}

	}

	public void selectReportFormat(WebDriver driver, String value) {

		List<WebElement> storeOption = driver
				.findElements(By.xpath("//ul[@class='select2-results__options']/li[@class='select2-results__option']"));

		for (WebElement option : storeOption) {

			if (option.getText().equalsIgnoreCase(value)) {
				option.click();
				break;
			}

		}

	}

	public String completeDateFormat(WebDriver driver, String dateVlaue) {

		String newDate = null;
		@SuppressWarnings("deprecation")
		Date dtDob = new Date(dateVlaue);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			newDate = sdf.format(dtDob);
		} catch (Exception e) {
		}

		return newDate;

	}

	public String addHoursToDate(int hours) {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		Date today = Calendar.getInstance().getTime();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		Date dateAddedHour = calendar.getTime();
		String todayDate = dateFormat.format(dateAddedHour);
		return todayDate;
	}

	public void databaseRecordVerification(WebDriver driver, String queryString, String report_frequency,
			String report_timeZone, String report_period, String report_name, String newCurrentDate,
			String newFutureDate) throws SQLException {

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://192.9.200.201:3306/pandora?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false",
				"apillai", "OKzOHKu0R5HGv3nL");

		Statement stmt = conn.createStatement();

		String query = queryString;

		ResultSet rs = stmt.executeQuery(query);

		boolean status = false;

		while (rs.next()) {

			String frequency = rs.getString("type_rscd");
			String timeZone = rs.getString("tz_rscd");
			String period = rs.getString("period_rscd");
			String name = rs.getString("name_rscd");
			String startDate = rs.getString("start_rscd");
			String endDate = rs.getString("end_rscd");

			System.out.println(startDate);
			System.out.println(endDate);

			Assert.assertEquals(report_frequency, frequency, "Frequency value not matched");
			Assert.assertEquals(report_timeZone, timeZone, "timezone value not matched");
			Assert.assertEquals(report_period, period, "period value not matched");
			Assert.assertEquals(report_name, name, "report name value not matched");
			Assert.assertEquals(newCurrentDate, startDate, "start date value not matched");
			Assert.assertEquals(newFutureDate, endDate, "end date value not matched");

			if (report_frequency.equals(frequency) && report_timeZone.equals(timeZone) && report_period.equals(period)
					&& report_name.equals(name) && newCurrentDate.equals(startDate) && newFutureDate.equals(endDate)) {

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
	
	public void databaseRecordVerificationForFiscalCalendar(WebDriver driver, String queryString, String report_frequency,
			String report_timeZone, String report_period, String report_name, String newCurrentDate) throws SQLException {

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://192.9.200.201:3306/pandora?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false",
				"apillai", "OKzOHKu0R5HGv3nL");

		Statement stmt = conn.createStatement();

		String query = queryString;

		ResultSet rs = stmt.executeQuery(query);

		boolean status = false;

		while (rs.next()) {

			String frequency = rs.getString("type_rscd");
			String timeZone = rs.getString("tz_rscd");
			String period = rs.getString("period_rscd");
			String name = rs.getString("name_rscd");
			String startDate = rs.getString("start_rscd");
			

			System.out.println(startDate);

			Assert.assertEquals(report_frequency, frequency, "Frequency value not matched");
			Assert.assertEquals(report_timeZone, timeZone, "timezone value not matched");
			Assert.assertEquals(report_period, period, "period value not matched");
			Assert.assertEquals(report_name, name, "report name value not matched");
			Assert.assertEquals(newCurrentDate, startDate, "start date value not matched");

			if (report_frequency.equals(frequency) && report_timeZone.equals(timeZone) && report_period.equals(period)
					&& report_name.equals(name) && newCurrentDate.equals(startDate)) {

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

	
	public void databaseRecordVerificationWithOutTime(WebDriver driver, String queryString, String report_frequency,
			String report_timeZone, String report_period, String report_name) throws SQLException {

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://192.9.200.201:3306/pandora?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false",
				"apillai", "OKzOHKu0R5HGv3nL");

		Statement stmt = conn.createStatement();

		String query = queryString;

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
			

			if (report_frequency.equals(frequency) && report_timeZone.equals(timeZone) && report_period.equals(period)
					&& report_name.equals(name)) {

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

	public void searchReportNameInReportScheduledTable(WebDriver driver, String reportName) {
		
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='searchScheduleReportTable']//div[@class='tile b--gray-medium results-row mb1']"));
		int rowCount = rows.size();
		System.out.println(rowCount);

		
		boolean flag = false;

		String beforeXpath = "//div[@id='searchScheduleReportTable']//div[";
		String afterXpath = "]//div[2]";
		
		for(int i=2;i<=rowCount;i++) {
			String actualXpath =beforeXpath+i+afterXpath;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
			if(!element.getText().equals(reportName)) {
				flag = true;
				
			}
			if (flag == false) {

				System.out.println("Report Name present  in table");

			}
			
			Assert.assertFalse(flag, "Report Name: "+reportName+" Not present  in table");
			
		}
			

	}
	
public void searchReportOwnerInReportScheduledTable(WebDriver driver, String reportOwner) {
		
		List<WebElement> rows = driver.findElements(By.xpath("//div[@id='searchScheduleReportTable']//div[@class='tile b--gray-medium results-row mb1']"));
		int rowCount = rows.size();
		System.out.println(rowCount);

		
		boolean flag = false;

		String beforeXpath = "//div[@id='searchScheduleReportTable']//div[";
		String afterXpath = "]//div[8]";
		
		for(int i=2;i<=rowCount;i++) {
			String actualXpath =beforeXpath+i+afterXpath;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			//System.out.println(element.getText());
			if(!element.getText().equals(reportOwner)) {
				flag = true;
				
			}
			if (flag == false) {

				System.out.println("Report Name present  in table");

			}
			
			Assert.assertFalse(flag, "Report Owner: "+reportOwner+" Not present  in table");
			
		}
			

	}

public void searchReportByAdminInReportScheduledTable(WebDriver driver, String reportOwner) {
	
	List<WebElement> rows = driver.findElements(By.xpath("//div[@id='searchScheduleReportTable']//div[@class='tile b--gray-medium results-row mb1']"));
	int rowCount = rows.size();
	System.out.println(rowCount);

	
	boolean flag = false;

	String beforeXpath = "//div[@id='searchScheduleReportTable']//div[";
	String afterXpath = "]//div[8]";
	
	for(int i=2;i<=rowCount;i++) {
		String actualXpath =beforeXpath+i+afterXpath;
		WebElement element = driver.findElement(By.xpath(actualXpath));
		//System.out.println(element.getText());
		if(!element.getText().equals(reportOwner)) {
			flag = true;
			
		}
		if (flag == false) {

			System.out.println("Report Name present  in table");

		}
		
		Assert.assertFalse(flag, "Report Owner: "+reportOwner+" Not present  in table");
		
	}
		

}


public void searchReportStatusInReportScheduledTable(WebDriver driver, String reportStatus) {
	
	List<WebElement> rows = driver.findElements(By.xpath("//div[@id='searchScheduleReportTable']//div[@class='tile b--gray-medium results-row mb1']"));
	int rowCount = rows.size();
	System.out.println(rowCount);

	
	boolean flag = false;

	String beforeXpath = "//div[@id='searchScheduleReportTable']//div[";
	String afterXpath = "]//div[3]";
	
	for(int i=2;i<=rowCount;i++) {
		String actualXpath =beforeXpath+i+afterXpath;
		WebElement element = driver.findElement(By.xpath(actualXpath));
		System.out.println(element.getText());
		if(!element.getText().equals(reportStatus)) {
			flag = true;
			
		}
		if (flag == false) {

			System.out.println("Report Name present  in table");

		}
		
		Assert.assertFalse(flag, "Report Status: "+reportStatus+" Not present  in table");
		
	}
		

}



public void searchReportPeriodRunScheduleInReportScheduledTable(WebDriver driver, String reportPeriodRunSchedule) {
	
	List<WebElement> rows = driver.findElements(By.xpath("//div[@id='searchScheduleReportTable']//div[@class='tile b--gray-medium results-row mb1']"));
	int rowCount = rows.size();
	System.out.println(rowCount);

	
	boolean flag = false;

	String beforeXpath = "//div[@id='searchScheduleReportTable']//div[";
	String afterXpath = "]//div[6]";
	
	for(int i=2;i<=rowCount;i++) {
		String actualXpath =beforeXpath+i+afterXpath;
		WebElement element = driver.findElement(By.xpath(actualXpath));
		System.out.println(element.getText());
		if(!element.getText().equals(reportPeriodRunSchedule)) {
			flag = true;
			
		}
		if (flag == false) {

			System.out.println("Report Period: "+reportPeriodRunSchedule+" present  in table");

		}
		
		Assert.assertFalse(flag, "Report Name Not present  in table");
		
	}
		

}

    public void selectValuesFromReportOwnerDropdownOfScheduleReportPage(WebDriver driver, String value) {

	List<WebElement> choicelist = driver
			.findElements(By.xpath("//ul[@class='select2-results__options']/li[@class='select2-results__option select2-results__option--highlighted']"));

	for (int i = 0; i < choicelist.size(); i++) {

		String text = choicelist.get(i).getText();

		if (text.equals(value)) {
			choicelist.get(i).click();
			break;
		}
	}
}
    
    /*public void selectValuesFromReportOwnerALLDropdownOfScheduleReportPage(WebDriver driver, String value) {

    	List<WebElement> choicelist = driver
    			.findElements(By.xpath("//ul[@class='select2-results__options']/li[@class='select2-results__option']"));

    	for (int i = 0; i < choicelist.size(); i++) {

    		String text = choicelist.get(i).getText();

    		if (text.equals(value)) {
    			choicelist.get(i).click();
    			break;
    		}
    	}
    }*/
    
    public void selectValuesFromReportOwnerDropdownOfScheduleReportPageNotHighlighted(WebDriver driver, String value) {

    	List<WebElement> choicelist = driver
    			.findElements(By.xpath("//ul[@class='select2-results__options']/li[@class='select2-results__option select2-results__option--highlighted']"));

    	for (int i = 0; i < choicelist.size(); i++) {

    		String text = choicelist.get(i).getText();

    		if (text.equals(value)) {
    			choicelist.get(i).click();
    			break;
    		}
    	}
    }
    
    public void selectValuesFromReportOwnerDropdownForSelectUserOfScheduleReportPage(WebDriver driver, String value) {

    	List<WebElement> choicelist = driver
    			.findElements(By.xpath("//ul[@class='select2-results__options']/li[@class='select2-results__option']"));

    	for (int i = 0; i < choicelist.size(); i++) {

    		String text = choicelist.get(i).getText();

    		if (text.equals(value)) {
    			choicelist.get(i).click();
    			break;
    		}
    	}
    }

	//<listener class-name="com.boss.qa.listeners.RetryTransformer" />

}
