package testRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.SearchAutomation.driver.DriverManager;
import com.SearchAutomation.helper.CommonUtils;
import com.SearchAutomation.helper.LaunchWebUrl;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	@RunWith(Cucumber.class)

	@CucumberOptions(
			features = "src/test/java/features/application.feature",
			glue = { "stepDefinition" },
			plugin = { "pretty", "html:test-output/cucumber-html-report", "json:test-output/cucumber.json",
					"junit:test-output/cucumber.xml"}, 

			monochrome = true,
			strict = true, 
			dryRun = false)


public class TestRunner extends CommonUtils{
		
		static boolean testResult = false;
		static LaunchWebUrl launchUrl = new LaunchWebUrl();
		
		@BeforeClass
		public static void beforeclass() throws Exception{
			test = extent.createTest("Before Class");
		  try {
			testResult = launchUrl.loadAppUrl();
		  } catch (Exception e) {
				test.log(Status.WARNING, "Error occured !!!" + e);
				testResult &= false;
			}

			Assert.assertEquals(true, testResult);
		    
			
		}
		@AfterClass
		public static void afterClass(){
			extent.flush();
			DriverManager.driver.quit();
		}
		
		public static ExtentHtmlReporter getHtmlReporter() {
			return htmlReporter;
		}

		public static ExtentReports getExtent() {
			return extent;
		}

}
