package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomer {
	WebDriver driver;
	@FindBy(xpath = "//*[@href=\"DeleteCustomerInput.php\"]")
	WebElement deleteCustomer;
	@FindBy(name = "cusid")
	WebElement customerID;
	@FindBy(name = "AccSubmit")
	WebElement submitButton;
	
	public DeleteCustomer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openDeleteCustomerPage() {
		deleteCustomer.click();
	}
	public void setCustomerID(String newCID) {
		customerID.sendKeys(newCID);
	}
	public void sumbitCustomerID() {
		submitButton.click();
	}
	
}