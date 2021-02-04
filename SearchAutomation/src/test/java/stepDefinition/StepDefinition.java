package stepDefinition;

import org.junit.Assert;

import com.SearchAutomation.applicationPages.SearchAutomationPage;
import com.SearchAutomation.helper.CommonUtils;
import com.SearchAutomation.helper.LaunchWebUrl;
import com.aventstack.extentreports.Status;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import testRunner.TestRunner;


public class StepDefinition extends CommonUtils {
	
boolean testResult = false;
	
	SearchAutomationPage pageMethods = new SearchAutomationPage();
	LaunchWebUrl launchUrl = new LaunchWebUrl();
	
	
	@Given("^User is in application home page and verify application header (.*)$")
	public void verifyApplicationPageContent(String header) {
		test = TestRunner.getExtent().createTest("Test Step : verify_User_Is_Already_In_HomePage");
		try {
			testResult = pageMethods.verifyApplicationPageContent(header);
		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}
		Assert.assertEquals(true, testResult);
	    
	    
	}

	@Then("^Enter job title name (.*) and Job Location (.*) and Distance (.*)$")
	public void validateDefaultSearch(String jobTitle, String jobLocation , String distance)  {
		test = TestRunner.getExtent().createTest("Test Step : validateDefaultSearch");
		try {
			testResult = pageMethods.verifydefaultSearchField(jobTitle, jobLocation, distance);
		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}
		Assert.assertEquals(true, testResult);
	}

	@Then("^Click on More Option button and verify the section is displayed$")
	public void validateMoreSearchButton()  {
		test = TestRunner.getExtent().createTest("Test Step : validateMoreSearchButton");
		try {
			testResult = pageMethods.verifyMoreSearch();
		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}
		Assert.assertEquals(true, testResult);
	}

	@Then("^Enter Min Salary (.*) and Max Salary (.*) and Salary Type (.*) and Job Type (.*)$")
	public void validateMoreSearchButtonSection(String minSal, String maxSal, String salType, String jobType)  {
		test = TestRunner.getExtent().createTest("Test Step : validateMoreSearchButtonSection");
		try {
			testResult = pageMethods.verifyMoreSearchSection(minSal, maxSal, salType, jobType);
		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}
		Assert.assertEquals(true, testResult);   	
	}

	@Then("^Click on Find job button and verify the Job Search Header (.*)$")
	public void validateFindJobs(String title)  {
		test = TestRunner.getExtent().createTest("Test Step : validateFindJobs");
		try {
			testResult = pageMethods.clickFindJobAndVerifyTitle(title);
		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}
		Assert.assertEquals(true, testResult);  
	}

	@Then("^User navigate back to the home page and verify home page is displayed (.*)$")
	public void validateBrowserBack(String title)  {
		test = TestRunner.getExtent().createTest("Test Step : validateBrowserBack");
		try {
			testResult = pageMethods.validateNavigateBack(title);
		} catch (Exception e) {
			test.log(Status.WARNING, "Error occured !!!" + e);
			testResult &= false;
		}
		Assert.assertEquals(true, testResult);
	}

	

}
