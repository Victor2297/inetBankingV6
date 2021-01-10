package com.inetBanking.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.DeleteCustomer;
import com.inetBanking.pageObjects.LoginPage;

public class TC_DeleteCustomerTest_005 extends BaseClass {
	WebDriverWait wait;
	@Test
	public void deleteCustomer() throws InterruptedException {
		wait = new WebDriverWait(driver, 35);
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickOnLoginButton();
		
		Thread.sleep(3000);
		
		DeleteCustomer dc = new DeleteCustomer(driver);
		dc.openDeleteCustomerPage();
		logger.info("The Delete Customer Page is open");
		dc.setCustomerID("38934");
		logger.info("The customer ID is entered");
		dc.sumbitCustomerID();
		
		
		wait.until(ExpectedConditions.alertIsPresent());
		String alertText = driver.switchTo().alert().getText();
		if(!alertText.equalsIgnoreCase("Do you really want to delete this Customer?")) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Test failed : " + alertText);
			Assert.assertTrue(false);
		}
		else {
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			String alertText2 = driver.switchTo().alert().getText();
			if(alertText2.equalsIgnoreCase("Customer deleted Successfully")) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
				logger.info("Test passed : " + alertText2);
				Assert.assertTrue(true);
			}
			else {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
				logger.info("Test failed : " + alertText2);
				Assert.assertTrue(false);
			}
		}
		
	}
}