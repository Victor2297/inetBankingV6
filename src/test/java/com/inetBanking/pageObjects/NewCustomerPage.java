package com.inetBanking.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@href=\"addcustomerpage.php\"]")
	WebElement newCustomer;
	@FindBy(name = "name")
	WebElement customerName;
	@FindBy(name = "dob")
	WebElement birthOfDate;
	@FindBy(name = "addr")
	WebElement address;
	@FindBy(name = "city")
	WebElement city;
	@FindBy(xpath = "//*[contains(@name,\"state\")]")
	WebElement state;
	@FindBy(name = "pinno")
	WebElement pin;
	@FindBy(name = "telephoneno")
	WebElement mobilenumber;
	@FindBy(name = "emailid")
	WebElement email;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(name = "sub")
	WebElement submitButton;
	JavascriptExecutor js;
	
	public NewCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openNewCustomerPage() {
		newCustomer.click();
	}
	public void setCustomerName(String cName) {
		customerName.clear();
		customerName.sendKeys(cName);
	}
	public void setBirthOfDate(String bDate) {
		birthOfDate.sendKeys(bDate);
	}
	public void setAddress(String newAddress) {
		address.sendKeys(newAddress);
	}
	public  void setCity(String newCity) {
		city.sendKeys(newCity);
	}
	public void setState(String newState) {
		state.sendKeys(newState);
	}
	public void setPin(String newPin) {
		pin.sendKeys(newPin);
	}
	public void addMobileNumber(String newMobileNumber) {
		mobilenumber.sendKeys(newMobileNumber);
	}
	public void setEmail(String newEmail) {
		email.sendKeys(newEmail);
	}
	public void setPassword(String newPssword) {
		password.sendKeys(newPssword);
	}
	public void submitForm() {
		submitButton.click();
	}
	public void scrollPge() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 300);");
	}
}