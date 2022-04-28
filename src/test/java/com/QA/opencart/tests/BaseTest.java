package com.QA.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.QA.opencart.Factory.DriverFactory;
import com.QA.opencart.pages.AccountsPage;
import com.QA.opencart.pages.LoginPage;
import com.QA.opencart.pages.ProductInfoPage;
import com.QA.opencart.pages.RegistarationPage;
import com.QA.opencart.pages.ResultsPage;

public class BaseTest {
	
	WebDriver driver;
	DriverFactory df;	
	Properties prop;
	
	LoginPage loginPage;
	AccountsPage accountsPage;
	RegistarationPage regPage;
	ResultsPage resultsPage;
	ProductInfoPage prodInfoPage;
	
	SoftAssert softAssert;
	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop=df.init_prop();
		System.out.println(prop);
		driver=df.init_driver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
		
	}

}
