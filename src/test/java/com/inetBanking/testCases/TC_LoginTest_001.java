package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	@Test
	public void loginTest() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickOnLoginButton();
		
		Thread.sleep(3000);
		if(this.isAlertPresent() == true) {
			logger.info("Test failed");
			Assert.assertTrue(false);
		}
		else {
			if(driver.getPageSource().contains("Manger Id : " + username)) {
				logger.info("Test passed");
				Assert.assertTrue(true);
			}
			else {
				captureScreen(driver, "loginTest");
				logger.info("Test failed");
				Assert.assertTrue(false);
			}
		}
	}
}