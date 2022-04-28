package com.QA.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.QA.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	ElementUtil eleUtil;

	// 1. private By locator
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgottenPwdLink = By.linkText("Forgotten Password");

	private By RegistrationLink = By.linkText("Register");

	// 2. Page constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. public page actions or methods
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}

	public Boolean isForgotPasswordExist() {
		return driver.findElement(forgottenPwdLink).isDisplayed();
	}

	public AccountsPage doLogin(String username, String pwd) {
		eleUtil.doSendKeys(emailId, username);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new AccountsPage(driver);
	}

	public RegistarationPage goToReigisterPage() {
		eleUtil.doClick(RegistrationLink);
		return new RegistarationPage(driver);
	}
}
