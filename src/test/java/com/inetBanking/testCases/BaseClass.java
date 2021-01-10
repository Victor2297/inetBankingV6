package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	WebDriver driver;
	ReadConfig readConfig = new ReadConfig();
	String username = readConfig.getUsername();
	String password = readConfig.getPassword();
	String baseUrl = readConfig.getBaseUrl();
	Logger logger;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String browser) throws Exception {
		logger = Logger.getLogger("log");
		PropertyConfigurator.configure("./log4j.properties");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChromeDriverPath());
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxDriverPath());
			driver = new FirefoxDriver();
		}
		else {
			throw new Exception("Wrong browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String screenName) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		String filePath = System.getProperty("user.dir") + "/Screenshots/" + screenName + ".png";
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(filePath);
		FileUtils.copyFile(SrcFile, DestFile);
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	public String getRandomString() {
		String v = RandomStringUtils.randomAlphanumeric(10);
		return v;
	}
}