package com.ujian.juaracoding.extentreport.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ujian.juaracoding.extentreport.driver.DriverSingleton;

public class CartSearchPage {
	
private WebDriver driver;
	
	public CartSearchPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(css = "#noo-site > header > div.navbar-wrapper > div > div > div > a > i")
	private WebElement btnSearch;
	
	@FindBy(css = "#noo-site > header > div.search-header.search-header-eff > div.noo-container > form > input.form-control")
	private WebElement txtSearch;
	
	@FindBy(css = "#noo-site > div.noo-container-shop.noo-shop-wrap > div.noo-row > div > div > div.noo-product-item.one.noo-product-sm-4.not_featured.post-1342.product.type-product.status-publish.has-post-thumbnail.product_cat-sun-glasses.product_tag-sun-glasses.product_tag-women.has-featured.instock.shipping-taxable.purchasable.product-type-variable > div > h3 > a")
	private WebElement barangGlass;
	
	@FindBy(css = "#product-1342 > div.single-product-content > div.summary.entry-summary > form > div > div.woocommerce-variation-add-to-cart.variations_button.woocommerce-variation-add-to-cart-enabled > button")
	private WebElement btnAdd;
	
	@FindBy(css = "#noo-site > section > div > div > h1")
	private WebElement getTextCart;
			
	public void menuSearch () {	
		btnSearch.click();
		txtSearch.sendKeys("glass");
		txtSearch.sendKeys(Keys.ENTER);
	}
	
	public void addtoCartSearch () {	
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("window.scrollBy(0,400)");
		barangGlass.click();
		js.executeScript("window.scrollBy(0,800)");
		MethodTambahan methodTambahan = new MethodTambahan();
		methodTambahan.Color(1);
		methodTambahan.Size(1);
		btnAdd.click();
	}
	
	public String getDisplayCartSearch() {
		return getTextCart.getText();
	}
	
}
