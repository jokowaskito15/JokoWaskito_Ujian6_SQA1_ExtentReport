package com.ujian.juaracoding.extentreport.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ujian.juaracoding.extentreport.driver.DriverSingleton;

public class CartPage {
	
private WebDriver driver;
	
	public CartPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(css = "#post-8 > div > div > nav > ul > li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--orders > a")
	private WebElement btnOrder;
	
	@FindBy(css = "#post-8 > div > div > div > div.woocommerce-message.woocommerce-message--info.woocommerce-Message.woocommerce-Message--info.woocommerce-info > a")
	private WebElement btnBrowse;
	
	@FindBy(css = "#noo-site > div.noo-container-shop.noo-shop-wrap > div.noo-row > div > div > div.noo-product-item.one.noo-product-sm-4.not_featured.post-1281.product.type-product.status-publish.has-post-thumbnail.product_cat-shoes.product_tag-shoes.product_tag-women.has-featured.instock.sale.shipping-taxable.purchasable.product-type-variable > div > h3 > a")
	private WebElement barangpertama;
		   
	@FindBy(css = "#product-1281 > div.single-product-content > div.summary.entry-summary > form > div > div.woocommerce-variation-add-to-cart.variations_button.woocommerce-variation-add-to-cart-enabled > button")
	private WebElement btnAdd;
	
	@FindBy(css = "#noo-site > section > div > div > h1")
	private WebElement getTextCart;
	
	public void addtoCart() {
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("window.scrollBy(0,300)");
		btnOrder.click();
		js.executeScript("window.scrollBy(0,300)");
		btnBrowse.click();
		js.executeScript("window.scrollBy(0,500)");
		barangpertama.click();
		js.executeScript("window.scrollBy(0,700)");
		MethodTambahan methodTambahan = new MethodTambahan();
		methodTambahan.Color(1);
		methodTambahan.Size(3);
		btnAdd.click();
	}
	
	public String getDisplayCart() {
		return getTextCart.getText();
	}

}
