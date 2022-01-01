package com.ujian.juaracoding.extentreport.extents.glue;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.ujian.juaracoding.extentreport.driver.DriverSingleton;
import com.ujian.juaracoding.extentreport.driver.config.AutomationFrameworkConfig;
import com.ujian.juaracoding.extentreport.pages.CartPage;
import com.ujian.juaracoding.extentreport.pages.CartSearchPage;
import com.ujian.juaracoding.extentreport.pages.CheckoutPage;
import com.ujian.juaracoding.extentreport.pages.LoginPage;
import com.ujian.juaracoding.extentreport.pages.RegisterPage;
import com.ujian.juaracoding.extentreport.utils.ConfigurationProperties;
import com.ujian.juaracoding.extentreport.utils.Constants;
import com.ujian.juaracoding.extentreport.utils.TestCases;
import com.ujian.juaracoding.extentreport.utils.Utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.TestCase;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class StepDefinition {

	private WebDriver driver;
	private RegisterPage registerPage;
	private LoginPage loginPage;
	private CartPage cartPage;
	private CartSearchPage cartSearchPage;
	private CheckoutPage checkoutPage;
	ExtentTest extentTest;
	static ExtentReports report = new ExtentReports("src/main/resources/TestReport.html");
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		registerPage = new RegisterPage();
		loginPage = new LoginPage();
		cartPage = new CartPage();
		cartSearchPage = new CartSearchPage();
		checkoutPage = new CheckoutPage();
		TestCases[] tests = TestCases.values();
		extentTest = report.startTest(tests[Utils.testCount].getTestName());
		Utils.testCount++;
	}
	
	@Given("^User buka halaman website")
	public void user_buka_halaman_website() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "User buka halaman website " + Constants.URL);
	}
	
//	REGISTER
	@When("^User klik menu My Account")
	public void User_klik_menu_my_account() {
		registerPage.goToAccount();
		extentTest.log(LogStatus.PASS, "User klik menu My Account");
	}
	
	@When("^User memasukan username email dan password dan klik Submit")
	public void user_memasukan_username_email_dan_password_dan_klik_submit() {
		registerPage.BuatAkun(configurationProperties.getUserNameAkun(), configurationProperties.getEmailAkun(), configurationProperties.getPasswordAkun());
		extentTest.log(LogStatus.PASS, "User memasukan username email dan password dan klik Submit");
	}	
	
	@Then("^User berhasil membuat akun")
	public void user_berhasil_membuat_akun() {
		 assertEquals(configurationProperties.getGetDisplayAkun(), registerPage.getDisplayAccount());
		 extentTest.log(LogStatus.PASS, "User berhasil membuat akun");
	}
	
	
//	LOGIN	
	@When("^User memasukan username dan password dan klik Log In")
	public void user_memasukan_username_dan_password_dan_klik_log_in() {
		loginPage.Login(configurationProperties.getUserNameAkun(), configurationProperties.getPasswordAkun());
		extentTest.log(LogStatus.PASS, "User memasukan username dan password dan klik Log In");
	}	
	
	@Then("^User dapat login ke Website")
	public void user_dapat_login_ke_Website() {
		 assertEquals(configurationProperties.getDisplayLogin(), loginPage.getDisplayLogin());
		 extentTest.log(LogStatus.PASS, "User dapat login ke Website");
	}
	
//	ADD TO CART	
	@When("^User memilih barang dan klik Add to Cart")
	public void user_memilih_barang_dan_klik_add_to_cart() {
		cartPage.addtoCart();
		extentTest.log(LogStatus.PASS, "User memilih barang dan klik Add to Cart");
	}	
	
	@Then("^User berhasil menambahkan barang ke Cart")
	public void user_berhasil_menambahkan_barang_ke_cart() {
		 assertEquals(configurationProperties.getDisplayCart(), cartPage.getDisplayCart());
		 extentTest.log(LogStatus.PASS, "User berhasil menambahkan barang ke Cart");
	}
	
//	ADD TO CART	BY SEARCH
	@When("^User mencari barang dari menu Search")
	public void user_mencari_barang_dari_menu_search() {
		cartSearchPage.menuSearch();
		extentTest.log(LogStatus.PASS, "User mencari barang dari menu Search");
	}	
	
	@Then("^User memilih barang dari hasil pencarian dan klik Add to Cart")
	public void user_memilih_barang_dari_hasil_pencarian_dan_klik_add_to_cart() {
		cartSearchPage.addtoCartSearch();
		extentTest.log(LogStatus.PASS, "User memilih barang dari hasil pencarian dan klik Add to Cart");
	}
	
	@Then("^User berhasil menambahkan barang dari hasil pencarian ke Cart")
	public void user_berhasil_menambahkan_barang_dari_hasil_pencarian_ke_cart() {
		 assertEquals(configurationProperties.getDisplayCartSearch(), cartSearchPage.getDisplayCartSearch());
		 extentTest.log(LogStatus.PASS, "User berhasil menambahkan barang dari hasil pencarian ke Cart");
	}
	
//	CHECKOUT	
	@When("^User melakukan checkout")
	public void user_melakukan_checkout() {
		checkoutPage.Checkout(configurationProperties.getFirstName(), configurationProperties.getLastName(), configurationProperties.getCompany(), configurationProperties.getAddresSsatu(), configurationProperties.getAddressDua(), configurationProperties.getCity(), configurationProperties.getPostCode(), configurationProperties.getPhone(), configurationProperties.getEmailAkun());
		extentTest.log(LogStatus.PASS, "User melakukan checkout");
	}	
	
	@Then("^User berhasil melakukan checkout")
	public void user_berhasil_melakukan_checkout() {
		 assertEquals(configurationProperties.getDisplayCheckout(), checkoutPage.getDisplayCheckout());
		 extentTest.log(LogStatus.PASS, "User berhasil melakukan checkout");
	}
	
	@After
	public void closeObject() {
		report.endTest(extentTest);
		report.flush();
		TestCases[] tests = TestCases.values();
	}
}
