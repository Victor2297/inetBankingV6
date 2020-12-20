package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.EditCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_EditCustomerTest_004 extends BaseClass {
	@Test
	public void editCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickOnLoginButton();
		
		Thread.sleep(3000);
		
		EditCustomerPage ec = new EditCustomerPage(driver);
		ec.openEditPage();
		logger.info("The page is openned");
		ec.setCustomerID("64104");
		logger.info("The customer ID is entered");
		ec.clickOnSubmitButton();
		Thread.sleep(3000);
		
		if(isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Test failed");
			Assert.assertTrue(false);
		}
		else {
			ec.setAddress("newAddress");
			logger.info("Entered address");
			ec.setCity("newCity1");
			logger.info("Entered city");
			ec.setState("newState1");
			logger.info("Entered state");
			ec.setPin("234567");
			logger.info("Entered pin");
			ec.submitForm();
			
			Thread.sleep(3000);
			 if(isAlertPresent() == true) {
				 driver.switchTo().alert().accept();
				 driver.switchTo().defaultContent();
				 logger.info("Test failed");
				 Assert.assertTrue(false);
			 }
			 else {
				 if(driver.getPageSource().contains("Customer details updated Successfully!!!")) {
					 logger.info("Test passed");
					 Assert.assertTrue(true);
				 }
				 else {
					 captureScreen(driver, "editCustomer");
					 logger.info("Test failed");
					 Assert.assertTrue(false);
				 }
			 }
			
		}
		
		
	}
}