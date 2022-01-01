package com.ujian.juaracoding.extentreport.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ujian.juaracoding.extentreport.driver.DriverSingleton;

public class CheckoutPage {
	
private WebDriver driver;
	
	public CheckoutPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(css = "#nav-menu-item-cart")
	private WebElement btnCart;
	
	@FindBy(css = "#post-6 > div > div > div.cart-collaterals > div.cart_totals > div > a")
	private WebElement btnCheckout;
	
	@FindBy(id = "billing_first_name")
	private WebElement txtFirstname;
	
	@FindBy(id = "billing_last_name")
	private WebElement txtLastName;
	
	@FindBy(id = "billing_company")
	private WebElement txtCompany;
	
	@FindBy(id = "billing_address_1")
	private WebElement txtAddresSatu;
	
	@FindBy(id = "billing_address_2")
	private WebElement txtAddressDua;
	
	@FindBy(id = "billing_city")
	private WebElement txtCity;
	
	@FindBy(id = "billing_postcode")
	private WebElement txtPostCode;
	
	@FindBy(id = "billing_phone")
	private WebElement txtPhone;
	
	@FindBy(id = "billing_email")
	private WebElement txtEmail;
	
	@FindBy(css = "#payment > div > div > p > label > span.woocommerce-terms-and-conditions-checkbox-text")
	private WebElement checkBox;

	@FindBy(id = "place_order")
	private WebElement btnOrder;
	
	@FindBy(css = "#post-7 > div > div > div > p.woocommerce-thankyou-order-received")
	private WebElement textAu;
	
	public void Checkout (String firstname, String lastname, String company, String addressatu, String addressdua, String city, String postcode, String phone, String email) {	
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		MethodTambahan methodTambahan = new MethodTambahan();
		btnCart.click();
		js.executeScript("window.scrollBy(0,1000)");
		btnCheckout.click();
		js.executeScript("window.scrollBy(0,800)");
		txtFirstname.sendKeys(firstname);
		txtLastName.sendKeys(lastname);
		txtCompany.sendKeys(company);
		methodTambahan.Country(1);
		txtAddresSatu.sendKeys(addressatu);
		txtAddressDua.sendKeys(addressdua);
		txtCity.sendKeys(city);
		methodTambahan.State(10);
		txtPostCode.sendKeys(postcode);
		txtPhone.sendKeys(phone);
		txtEmail.clear();
		txtEmail.sendKeys(email);
		checkBox.click();
		btnOrder.click();
		js.executeScript("window.scrollBy(0,500)");
	}
	
	public String getDisplayCheckout() {
		return textAu.getText();
	}
}
