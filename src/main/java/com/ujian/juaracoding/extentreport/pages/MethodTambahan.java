package com.ujian.juaracoding.extentreport.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ujian.juaracoding.extentreport.driver.DriverSingleton;

public class MethodTambahan {
	
private WebDriver driver;
	
	public MethodTambahan() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id = "pa_color")
	private WebElement btnpilihcolor;
	
	@FindBy(id = "pa_size")
	private WebElement btnpilihsize;
	
	@FindBy(id = "select2-billing_country-container")
	private WebElement btnCountry;
	
	@FindBy(id = "select2-billing_state-container")
	private WebElement btnState;

	public void Color (int selection) {			
		btnpilihcolor.click();	
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
	}
	
	public void Size (int selection) {			
		btnpilihsize.click();	
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
	}
	
	public void Country (int selection) {			
		btnCountry.click();	
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
	}
	
	public void State (int selection) {			
		btnState.click();	
		List<Keys> lstSequence = new ArrayList<Keys>();
		for (int i = 0; i < selection; i++) {
			lstSequence.add(Keys.DOWN);
		}
		lstSequence.add(Keys.ENTER);
		CharSequence[] cs = lstSequence.toArray(new CharSequence[lstSequence.size()]);
		Actions keyDown = new Actions(driver); keyDown.sendKeys(Keys.chord(cs)).perform();
	}
}
