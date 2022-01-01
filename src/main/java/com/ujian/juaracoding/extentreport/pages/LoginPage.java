package com.ujian.juaracoding.extentreport.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ujian.juaracoding.extentreport.driver.DriverSingleton;

public class LoginPage {
private WebDriver driver;
	
	public LoginPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user_login")
	private WebElement txtusernameLogin;
	
	@FindBy(id = "user_pass")
	private WebElement txtpasswordLogin;
	
	@FindBy(id = "wp-submit")
	private WebElement buttonLogin;
	
	@FindBy(css = "#noo-site > section > div > div > h1")
	private WebElement TeksLogin;
	
	
	
	public void Login(String usernameakun, String passwordakun) {	
		txtusernameLogin.sendKeys(usernameakun);
		txtpasswordLogin.sendKeys(passwordakun);
		buttonLogin.click();
	}
	
	public String getDisplayLogin() {
		return TeksLogin.getText();
	}	
}
