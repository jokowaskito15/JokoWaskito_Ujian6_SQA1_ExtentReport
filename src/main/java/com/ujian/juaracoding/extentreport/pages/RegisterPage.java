package com.ujian.juaracoding.extentreport.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ujian.juaracoding.extentreport.driver.DriverSingleton;


public class RegisterPage {

	private WebDriver driver;
	
	public RegisterPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#noo-site > header > div.noo-topbar > div > ul.pull-right.noo-topbar-right > li:nth-child(2) > a")
	private WebElement menumyaccount;
	
	@FindBy(id = "reg_username")
	private WebElement txtUsername;
	
	@FindBy(id = "reg_email")
	private WebElement txtEmail;
	
	@FindBy(id = "reg_password")
	private WebElement txtPassword;
	
	@FindBy(css = "#customer_login > div.u-column2.col-2 > form > p:nth-child(5) > button")
	private WebElement buttonSubmit;
	
	@FindBy(css = "#login > p.login.message")
	private WebElement txtDisplayAccount;
	
	public void goToAccount() {
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("window.scrollBy(0,500)");
		menumyaccount.click();
	}
	
	public void BuatAkun(String usernameakun, String emailakun, String passwordakun) {	
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("arguments[0].scrollIntoView()", txtUsername);
		txtUsername.sendKeys(usernameakun);
		txtEmail.sendKeys(emailakun);
		txtPassword.sendKeys(passwordakun);
		buttonSubmit.click();
	}
	
	public String getDisplayAccount() {
		return txtDisplayAccount.getText();
	}

}
