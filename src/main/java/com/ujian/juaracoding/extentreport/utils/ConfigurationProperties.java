package com.ujian.juaracoding.extentreport.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {

	@Value("${browser}")
	private String browser;
	
	@Value("${usernameakun}")
	private String userNameAkun;

	@Value("${emailakun}")
	private String emailAkun;
	
	@Value("${passwordakun}")
	private String passwordAkun;
	
	@Value("${getaccount}")
	private String getDisplayAkun;
	
	@Value("${getlogin}")
	private String DisplayLogin;
	
	@Value("${getcart}")
	private String DisplayCart;
	
	@Value("${getcartsearch}")
	private String DisplayCartSearch;
	
	@Value("${getcheckout}")
	private String DisplayCheckout;
	
	@Value("${firstname}")
	private String FirstName;
	
	@Value("${lastname}")
	private String LastName;
	
	@Value("${company}")
	private String Company;
	
	@Value("${addressatu}")
	private String AddresSsatu;
	
	@Value("${addressdua}")
	private String AddressDua;
	
	@Value("${city}")
	private String City;
	
	@Value("${postcode}")
	private String PostCode;
	
	@Value("${phone}")
	private String Phone;

	public String getFirstName() {
		return FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public String getCompany() {
		return Company;
	}

	public String getAddresSsatu() {
		return AddresSsatu;
	}

	public String getAddressDua() {
		return AddressDua;
	}

	public String getCity() {
		return City;
	}

	public String getPostCode() {
		return PostCode;
	}

	public String getPhone() {
		return Phone;
	}

	public String getDisplayCheckout() {
		return DisplayCheckout;
	}

	public String getDisplayCartSearch() {
		return DisplayCartSearch;
	}

	public String getDisplayCart() {
		return DisplayCart;
	}

	public String getDisplayLogin() {
		return DisplayLogin;
	}

	public String getBrowser() {
		return browser;
	}

	public String getUserNameAkun() {
		return userNameAkun;
	}

	public String getEmailAkun() {
		return emailAkun;
	}

	public String getPasswordAkun() {
		return passwordAkun;
	}

	public String getGetDisplayAkun() {
		return getDisplayAkun;
	}

}
