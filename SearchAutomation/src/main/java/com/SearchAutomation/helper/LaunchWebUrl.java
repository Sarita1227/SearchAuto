package com.SearchAutomation.helper;

import org.openqa.selenium.WebElement;

import com.SearchAutomation.driver.DriverManager;
import com.SearchAutomation.driver.DriverManagerFactory;
import com.SearchAutomation.driver.DriverType;
import com.aventstack.extentreports.Status;

public class LaunchWebUrl extends CommonUtils {

	DriverManager webDr;
	
	boolean returnValue = false;
	
	public boolean loadAppUrl() throws Exception {
			webDr = DriverManagerFactory.getManager(DriverType.CHROME);
			DriverManager.driver = webDr.getDriver();
			DriverManager.driver.manage().deleteAllCookies();
			DriverManager.driver.navigate().to("https://www.cv-library.co.uk/");
			waitForPageLoaded();
			test.log(Status.INFO, "Verify the application is loaded successfully");
			WebElement loginPageELement = findElement(webElemProp.getProperty("HOMEPAGE_HEADER"), LocatorTypes.CSS);
			returnValue = loginPageELement.isDisplayed();

			if (returnValue) {
				test.log(Status.PASS, "The method <b>loadAppUrl passed");
			} else {
				test.log(Status.FAIL, "The method <b>loadAppUrl failed");
			}
			return returnValue;

	}

}
