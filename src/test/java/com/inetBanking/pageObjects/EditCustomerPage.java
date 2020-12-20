package com.inetBanking.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@href=\"EditCustomer.php\"]")
	WebElement editCustomer;
	@FindBy(name = "cusid")
	WebElement customerID;
	@FindBy(name = "AccSubmit")
	WebElement submitButton;
	@FindBy(name = "addr")
	WebElement address;
	@FindBy(name = "city")
	WebElement city;
	@FindBy(name = "state")
	WebElement state;
	@FindBy(name = "pinno")
	WebElement pin;
	@FindBy(name = "sub")
	WebElement submitB;
	JavascriptExecutor js;
	
	public EditCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openEditPage() {
		editCustomer.click();
	}
	public void setCustomerID(String cID) {
		customerID.sendKeys(cID);
	}
	public void clickOnSubmitButton() {
		submitButton.click();
	}
	public void scrollPage() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 300);");
	}
	public void setAddress(String nAddress) {
		address.clear();
		address.sendKeys(nAddress);
	}
	public void setCity(String nCity) {
		city.clear();
		city.sendKeys(nCity);
	}
	public void setState(String nState) {
		state.clear();
		state.sendKeys(nState);
	}
	public void setPin(String nPin) {
		pin.clear();
		pin.sendKeys(nPin);
	}
	public void submitForm() {
		submitB.click();
	}
}