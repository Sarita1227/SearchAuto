package com.SearchAutomation.applicationPages;

import org.openqa.selenium.WebElement;

import com.SearchAutomation.driver.DriverManager;
import com.SearchAutomation.helper.CommonUtils;
import com.SearchAutomation.helper.LocatorTypes;
import com.aventstack.extentreports.Status;



public class SearchAutomationPage extends CommonUtils{
	
	boolean returnValue = false;
	/**
	 * Verify application page content is displayed
	 * @return
	 */
	public boolean verifyApplicationPageContent(String pageHeader) {
		test.log(Status.INFO, "Verify the user is in application homepage");
		WebElement pageContent = findElement(webElemProp.getProperty("HOMEPAGE_HEADER"), LocatorTypes.CSS);
		returnValue = pageContent.getText().trim().equals(pageHeader);
		if (returnValue) {
			test.log(Status.PASS, "The method <b>verifyApplicationPageContent passed");
		} else {
			test.log(Status.FAIL, "The method <b>verifyApplicationPageContent failed");
		}

		return returnValue;
	}

	/**
	 * Verify default search fields
	 * @param jobTitle
	 * @param location
	 * @param distance
	 * @return
	 */
	public boolean verifydefaultSearchField(String jobTitle, String location, String distance) {
		test.log(Status.INFO, "Set and verify job title");
		returnValue = setAndVerifyFieldValue(webElemProp.getProperty("JOB_TITLE_INPUT"), LocatorTypes.CSS, jobTitle);
		
		test.log(Status.INFO, "Set and verify job location");
		returnValue &= setAndVerifyFieldValue(webElemProp.getProperty("LOCATION_INPUT"), LocatorTypes.CSS, location);
		test.log(Status.INFO, "Select job title");
		pageDropDownByText(webElemProp.getProperty("DISTANCE_DROPDOWN"), LocatorTypes.CSS, distance);
		if (returnValue) {
			test.log(Status.PASS, "The method <b>verifydefaultSearchField passed");
		} else {
			test.log(Status.FAIL, "The method <b>verifydefaultSearchField failed");
		}

		return returnValue;
	}
	
	public boolean verifyMoreSearch() {
		WebElement button = findElement(webElemProp.getProperty("MORE_SEARCH_OPTION_BTN"), LocatorTypes.CSS);
		test.log(Status.INFO, "Click on more search button and verify the section is displayed");
		click(button);
		waitForElementVisibility(webElemProp.getProperty("MORE_SEARCH_SECTION"), 30);
		WebElement section = findElement(webElemProp.getProperty("MORE_SEARCH_SECTION"), LocatorTypes.CSS);
		returnValue = section.isDisplayed();
		if (returnValue) {
			test.log(Status.PASS, "The method <b>verifyMoreSearch passed");
		} else {
			test.log(Status.FAIL, "The method <b>verifyMoreSearch failed");
		}

		return returnValue;
	}
	
	public boolean verifyMoreSearchSection(String minSal, String maxSal, String salType, String jobType) {
		test.log(Status.INFO, "Enter minimum salary");
		returnValue = setAndVerifyFieldValue(webElemProp.getProperty("SALARY_MIN"), LocatorTypes.CSS, minSal);
		
		test.log(Status.INFO, "Enter maximum salary");
		returnValue &= setAndVerifyFieldValue(webElemProp.getProperty("SALARY_MAX"), LocatorTypes.CSS, maxSal);
		
		test.log(Status.INFO, "Select sal type");
		pageDropDownByText(webElemProp.getProperty("SALARY_TYPE"), LocatorTypes.CSS, salType);
		
		test.log(Status.INFO, "Select job type");
		pageDropDownByText(webElemProp.getProperty("JOB_TYPE"), LocatorTypes.CSS, jobType);

		if (returnValue) {
			test.log(Status.PASS, "The method <b>verifyMoreSearchSection passed");
		} else {
			test.log(Status.FAIL, "The method <b>verifyMoreSearchSection failed");
		}

		return returnValue;
	}
	
	public boolean clickFindJobAndVerifyTitle(String titleName) {
		WebElement button = findElement(webElemProp.getProperty("FIND_JOBS_BTN"), LocatorTypes.CSS);
		test.log(Status.INFO, "Click on find job button and verify page title");
		click(button);
		waitForElementVisibility(webElemProp.getProperty("SEARCH_RESULT_TITLE"), 30);
		
		WebElement title = findElement(webElemProp.getProperty("SEARCH_RESULT_TITLE"), LocatorTypes.CSS);
		returnValue = title.getText().equalsIgnoreCase(titleName);
		if (returnValue) {
			test.log(Status.PASS, "The method <b>clickFindJobAndVerifyTitle passed");
		} else {
			test.log(Status.FAIL, "The method <b>clickFindJobAndVerifyTitle failed");
		}

		return returnValue;
		
	}
	
	/**
	 * Navigate back
	 * @param title
	 * @return
	 */
	public boolean validateNavigateBack(String title) {

		DriverManager.driver.navigate().back();
		waitForElementVisibility(webElemProp.getProperty("HOMEPAGE_HEADER"), 30);

		WebElement titleEle = findElement(webElemProp.getProperty("HOMEPAGE_HEADER"), LocatorTypes.CSS);
		returnValue = titleEle.getText().equalsIgnoreCase(title);
		if (returnValue) {
			test.log(Status.PASS, "The method <b>validateNavigateBack passed");
		} else {
			test.log(Status.FAIL, "The method <b>validateNavigateBack failed");
		}

		return returnValue;
	}
}
