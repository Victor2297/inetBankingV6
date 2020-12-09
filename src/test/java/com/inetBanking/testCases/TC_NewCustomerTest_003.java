package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.pageObjects.NewCustomerPage;

public class TC_NewCustomerTest_003 extends BaseClass {
	@Test
	public void createNewCustomer() throws InterruptedException, IOException {
		String email = this.getRandomString();
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickOnLoginButton();
		
		Thread.sleep(3000);
		
		NewCustomerPage newC = new NewCustomerPage(driver);
		newC.openNewCustomerPage();
		newC.scrollPge();
		newC.setCustomerName("Test");
		newC.setBirthOfDate("2204202");
		newC.setAddress("my Address");
		newC.setCity("Chisinau");
		newC.setState("MD");
		newC.setPin("356788");
		newC.addMobileNumber("234567678");
		newC.setEmail(email + "@gmail.com");
		newC.setPassword("123457v");
		newC.submitForm();
		
		Thread.sleep(3000);
		
		if(this.isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Test Failed");
			Assert.assertTrue(false);
		}
		else {
			if(driver.getPageSource().contains("Customer Registered Successfully!!!")) {
				logger.info("Test Passed");
				Assert.assertTrue(true);
			}
			else {
				captureScreen(driver, "createNewCustomer");
				logger.info("Test Failed");
				Assert.assertTrue(false);
			}
		}
		
		
	}
}