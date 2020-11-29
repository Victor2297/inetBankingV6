package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties p;
	public ReadConfig() {
		File file = new File(System.getProperty("user.dir") + "\\Configuration\\config.properties");
		try {
			FileInputStream myFile = new FileInputStream(file);
			p = new Properties();
			p.load(myFile);
		}
		catch(Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}
	}
	
	public String getUsername() {
		String username = p.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password = p.getProperty("password");
		return password;
	}
	public String getChromeDriverPath() {
		String cDriverPath = p.getProperty("chromeDriverPath");
		return cDriverPath;
	}
	public String getFirefoxDriverPath() {
		String fDriverPath = p.getProperty("firefoxDriverPath");
		return fDriverPath;
	}
	public String getBaseUrl() {
		String baseUrl = p.getProperty("baseUrl");
		return baseUrl;
	}
}