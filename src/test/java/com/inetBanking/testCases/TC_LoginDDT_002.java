package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginDDT_002 extends BaseClass {
	@Test(dataProvider = "Data", dataProviderClass = ClassDataProvider.class)
	public void loginDDT(String usern, String pass) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(usern);
		logger.info("Entered username");
		lp.setPassword(pass);
		logger.info("Entered password");
		lp.clickOnLoginButton();
		
		Thread.sleep(3000);
		
		if(this.isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Test failed");
			Assert.assertTrue(false);
		}
		else {
			lp.scrollPage();
			lp.clickOnLogoutButton();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Test passed");
			Assert.assertTrue(true);
		}
		
	}
}